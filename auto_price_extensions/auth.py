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

"""Authentication-related info for the Content API for Shopping."""
import logging
import os
import sys
import _constants
import common

from google_auth_oauthlib import flow
import token_storage
import google.auth
from google.oauth2 import service_account

logger = logging.getLogger(__name__)


def authorize(config):
  """Authorization for the Content API Samples.

  Args:
      config: dictionary, Python representation of config JSON.

  Returns:
      An google.auth.credentials.Credentials object suitable for
      accessing the Content API.
  """

  logger.addHandler(common.get_logging_handler())
  try:
    credentials, _ = google.auth.default(scopes=[_constants.CONTENT_API_SCOPE])
    return credentials
  except google.auth.exceptions.DefaultCredentialsError:
    pass  # Can safely ignore this error, since it just means none were found.
  if 'path' not in config:
    logger.critical('Must use Application Default Credentials'
                    'with no configuration.')
    sys.exit(1)
  service_account_path = os.path.join(config['path'],
                                      _constants.SERVICE_ACCOUNT_FILE)
  client_secrets_path = os.path.join(config['path'],
                                     _constants.CLIENT_SECRETS_FILE)
  if os.path.isfile(service_account_path):
    logger.info('Using service account credentials'
                'from %s.', service_account_path)
    return service_account.Credentials.from_service_account_file(
        service_account_path,
        scopes=[_constants.CONTENT_API_SCOPE])
  elif os.path.isfile(client_secrets_path):
    logger.info('Using OAuth2 client secrets from %s.', client_secrets_path)
    storage = token_storage.Storage(config)
    credentials = storage.get()
    if credentials and credentials.valid:
      return credentials
    client_config = token_storage.retrieve_client_config(config)
    auth_flow = flow.InstalledAppFlow.from_client_config(
        client_config, scopes=[_constants.CONTENT_API_SCOPE])
    credentials = auth_flow.run_local_server(authorization_prompt_message='')
    storage.put(credentials)
    return credentials
  logger.critical('No OAuth2 authentication files found. Checked:')
  logger.critical('- Google Application Default Credentials')
  logger.critical('- %s', service_account_path)
  logger.critical('- %s', client_secrets_path)
  logger.critical('Please read the accompanying documentation.')
  sys.exit(1)
  return None
