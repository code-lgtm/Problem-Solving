# Automated Price Extensions using Content and Google Adwords API

This client simplifies creating price extensions using product feed information
in Google Merchant Center. It uses Content API to fetch the feed and
utilize Google Ads API to create price extensions in Google Ads accounts

**NOTE**: This library is _not_ compatible with Python versions less than Python 3.6.

## Prerequisites

For your convenience, you can run the following command from this directory to
install all needed dependencies via [pip](https://pip.pypa.io/):

    $ pip install -r requirements.txt

## Setup Authentication and Configuration

We are assuming you've checked out the code and are reading this from a local
directory. If not, check out the code to a local directory.

1.  In your home directory create a shopping directoty `$(HOME)/shopping` to store all the
    the configuration files.

    Within this directory, also create the following subdirectory

    * `content`

2. Copy the googleads.yaml in the repository root to 
   file `$(HOME)/shopping`

   This will be used to store credentials and other settings that can be loaded
   to initialize GoogleAds client. 

   This client assumes that you are using OAuth2 client id as authentication method.

4. Set up your OAuth2 credentials

   The AdWords and Content API use [OAuth2](http://oauth.net/2/) as the authentication mechanism. Follow the
   guide below:

   * [OAuth Credentials](https://github.com/googleads/googleads-python-lib/wiki/API-access-using-own-credentials-(installed-application-flow))


3. In googleads.yaml file update following fields in AdwordsClientConfigurations:

   * developer\_token
   * client\_customer\_id
   * client\_id
   * client\_secret
   * refresh\_token
   Follow [these](https://developers.google.com/google-ads/api/docs/client-libs/python/oauth-installed) instructions to get an OAuth2 refresh token


5. Download your [OAuth2 client credentials](https://console.developers.google.com/apis/credentials) to
    the file `client-secrets.json` in the content `$(HOME)/shopping/content` directory.


6. Take the example `merchant-info.json` from the repository root and copy it into `$(HOME)/shopping/content`.
   It contains a JSON object. Modify the following fields:

    | Field                     | Type   | Description                                    |
    |---------------------------|--------|------------------------------------------------|
    | `merchantId`              | number | The Merchant Center ID of GMC account          |

7.  Start up the client:

        $ python -m auto_price_extensions

**NOTE**: This is not an officially supported Google product
