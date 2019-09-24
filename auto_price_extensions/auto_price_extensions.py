#!/usr/bin/python
#
# Copyright 2019 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""Gets feed from merchant center and adds price extensions for relevant text campaigns."""

import logging
import os
import sys
import _constants

import common
from googleads import adwords
from googleads import errors
import sqlite3


logger = logging.getLogger(__name__)


def get_feed(argv):
  """Fetches feed from Merchant Center.

  Retrieves feed items from Merchant Center and store
  it locally

  Args:
    argv: list of command-line parameters of the application

  Raises:
     ValueError when relevant feeds are not identified
     sqlite3.Error if there is an error reading from the local sqlite db

  """
  # Authenticate and construct service.
  service, config, _ = common.init(argv, __doc__)
  merchant_id = config['merchantId']

  request = service.products().list(
      merchantId=merchant_id, maxResults=_constants.MAX_PAGE_SIZE)

  # Remove previous feed
  if os.path.exists(os.path.join(os.getcwd(), _constants.DB)):
    os.remove(_constants.DB)

  conn = sqlite3.connect(_constants.DB)
  c = conn.cursor()

  try:
    c.execute('''CREATE TABLE feed
                 (id TEXT, title TEXT, label_0 TEXT, label_1 TEXT, price TEXT,
                  currency TEXT, description TEXT, productType TEXT,
                  link TEXT)''')
  except sqlite3.Error as e:
    logger.critical(e.args[0])
    raise sqlite3.Error

  while request is not None:
    result = request.execute()
    products = result.get('resources')
    if not products:
      break
    rows = []
    for product in products:
      try:
        link = _constants.DEFAULT_URL
        label_0, label_1 = None, None

        if 'link' in product:
          link = product['link']
        if 'customLabel0' in product:
          label_0 = product['customLabel0']
        if 'customLabel1' in product:
          label_1 = product['customLabel1']
        row = (product['id'], product['title'],
               label_0, label_1,
               product['price']['value'], product['price']['currency'],
               str(product['description']), str(product['productTypes']), link)
      except KeyError:
        continue
      rows.append(row)

    if not rows:
      logger.critical('Empty Feed: No feed with required'
                      ' custom labels were retrieved')
      raise ValueError

    c.executemany('INSERT INTO feed VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)', rows)
    conn.commit()
    request = service.products().list_next(request, result)
  conn.close()


def remove_existing_extensions(client, campaign):
  """Removes Price Extensions.

  Removes Existing Price Extensions from provided campaign.

  Args:
    client: Adwords client object
    campaign: campaign object

  """
  campaign_extension_setting_service = client.GetService(
      'CampaignExtensionSettingService', 'v201809')
  remove_extension_setting = {
      'campaignId': campaign['id'],
      'extensionType': 'PRICE'
  }

  operations = [{
      'operator': 'REMOVE',
      'operand': remove_extension_setting
  }]

  try:
    campaign_extension_setting_service.mutate(operations)
  except errors.GoogleAdsServerFault:
    logger.warning('There are no extension to remove for campaign %s',
                   campaign['name'])


def gen_query(c0, c1):
  """Generates query for retrieving products.

  Based on value of label EXT-NAME* in campaigns generate queries for
  fetch relevant products from the field.

  Args:
    c0: String containing value for customLabel0
    c1: Staring containing value fot customLabel1

  Yields:
    A string containg query for fetching relevant products
    from local sqllite db

  """
  if c0 and c1:
    for label_0 in c0:
      for label_1 in c1:
        yield ('SELECT * FROM feed where label_0 like \'%s\' and '
               'label_1 like \'%s\'' % (label_0, label_1))

  if c0:
    for label_0 in c0:
      yield 'SELECT * FROM feed where label_0 like \'%s\'' % (label_0)

  if c1:
    for label_1 in c1:
      yield 'SELECT * FROM feed where label_1 like \'%s\'' % (label_1)


def add_new_extensions(client, campaign, label):
  """Add new price extensions on campaigns.

  Args:
    client: Adwords Client Object
    campaign: Campaign Object on which extension needs to be applied
    label: JSON String containing label EXT-NAME* values for campaign

  """
  campaign_extension_setting_service = client.GetService(
      'CampaignExtensionSettingService', 'v201809')

  # Parse Label
  description = label['attribute']['description']
  custom_labels = description.split(',')
  c0, c1 = [], []
  for clabel in custom_labels:
    if clabel[:2] == 'C0':
      c0.append('%' + clabel[3:] + '%')
    elif clabel[:2] == 'C1':
      c1.append('%' + clabel[3:] + '%')
    else:
      return

  conn = sqlite3.connect(_constants.DB)
  conn.row_factory = sqlite3.Row
  c = conn.cursor()
  results = []

  for query in gen_query(c0, c1):
    c.execute(query)
    rows = c.fetchmany(_constants.MAX_PAGE_SIZE)
    found = False

    for r in rows:
      duplicate = False
      for entry in results:
        if entry['title'][:22] == r['title'][:22]:
          duplicate = True
          break
      # Add if the first 22 characters of title are unique
      if not duplicate:
        results.append(r)
      if len(results) > _constants.MAX_EXTENSION_ENTRIES:
        results = results[:_constants.MAX_EXTENSION_ENTRIES]
        found = True
        break
      if len(results) == _constants.MAX_EXTENSION_ENTRIES:
        found = True
        break

    # Maximum possible entries found
    if found:
      break

  conn.close()

  if len(results) < _constants.MIN_EXTENSION_ENTRIES:
    logger.warning('No relevant extensions to be applied to campaign %s',
                   campaign['name'])
    return

  table_rows = []
  for result in results:
    r = {
        'header': result['title'][:22] + '...',
        'description': result['description'][:22] + '...',
        'finalUrls': {
            'urls': [
                result['link']
            ]
        },
        'price': {
            'money': {
                'microAmount': int(float(result['price'])) *
                               _constants.MICROS_PER_DOLLAR
            },
            'currencyCode': result['currency']
        },
        'priceUnit': 'NONE',
        'xsi_type': 'PriceTableRow'
    }
    table_rows.append(r)

  add_extension_setting = {
      'campaignId': campaign['id'],
      'extensionType': 'PRICE',
      'extensionSetting': {
          'extensions': [{
              'priceExtensionType': 'PRODUCT_TIERS',
              'language': 'en',
              'priceQualifier': 'NONE',
              'tableRows': table_rows,
              'xsi_type': 'PriceFeedItem',
              'trackingUrlTemplate': '',
              'finalUrlSuffix': '',
              'campaignTargeting': {
                  'TargetingCampaignId': campaign['id']
              }
          }]
      }
  }

  operations = [{
      'operator': 'ADD',
      'operand': add_extension_setting
  }]

  try:
    campaign_extension_setting_service.mutate(operations)
  except errors.GoogleAdsServerFault:
    logger.warning('Error occured while writing to campaign %s',
                   campaign['name'])


def init_logger():
  """Initializes Application Logger.

  Uses class TimedRotatingFileHandler for rotating logs daily
  and keep a backup of last 10 days
  """
  if not os.path.isdir(os.path.join(os.getcwd(), _constants.LOG_DIRECTORY)):
    os.makedirs(os.path.join(os.getcwd(), _constants.LOG_DIRECTORY))

  logger.addHandler(common.get_logging_handler())


def main(client):
  """Entry point to the application.

  Initializes  services, get relevant campaigns using Google Ads API,
  fetch data from merchant center using Content API, removes and add
  price extensions

  Args:
    client: Adwords client object

  """
  campaign_service = client.GetService('CampaignService', version='v201809')

  # Construct selector and get all campaigns.
  query = (adwords.ServiceQueryBuilder()
           .Select('Id', 'Name', 'Status', 'Labels')
           .Where('Status').EqualTo('ENABLED')
           .Where('AdvertisingChannelType').EqualTo('SEARCH')
           .OrderBy('Name')
           .Limit(0, _constants.MAX_PAGE_SIZE)
           .Build())

  for page in query.Pager(campaign_service):
    # Check for labels in campaigns
    if 'entries' in page:
      for campaign in page['entries']:
        for label in campaign['labels']:
          if 'EXT-Name' in label['name']:
            remove_existing_extensions(client, campaign)
            add_new_extensions(client, campaign, label)

if __name__ == '__main__':
  init_logger()
  get_feed(sys.argv)
  adwords_client = (adwords.AdWordsClient.LoadFromStorage(
      os.path.expanduser('~/shopping/googleads.yaml')))
  main(adwords_client)
