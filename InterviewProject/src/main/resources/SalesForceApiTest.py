import requests
import json

# *** Update these values to match your configuration ***
SALESFORCE_TOKEN_URL = 'https://test.salesforce.com/services/oauth2/token'
SALESFORCE_USER_TOKEN_URL = 'https://linkedin--1337.my.salesforce.com/services/apexrest/ApproveIn/auth'
SALESFORCE_CLIENT_ID = "3MVG9Z8h6Bxz0zc4HiVDYJDrFq1zCBxrDOVupuY97s7pBtCOw7kZczIYlUzlSbcoCM8ZzuJBDgUsGOOTN63QO"
SALESFORCE_CLIENT_SECRET = "77F93635A9669CC2C7C31E1F17462093359A054BCA97969D3718E39CD755FA5D"
SALESFORCE_USER = "svc-approvein@linkedin.com"
SALESFORCE_USER_PASSWORD = "Sfdc#43210pFBStEvIygo4ciANTsF4wZlJd"
USER_EMAIL = 'manikumar@linkedin.com'

OKTA_TOEKN_URL = 'https://linkedin.oktapreview.com/oauth2/v1/token'
OKTA_CLIENT_ID = "0oah3buh4xEKJQXvt0h7"
OKTA_REFRESH_TOKEN = "edGE89H3fSRwBCrAiv-yxQP-DhkxHUv-DOEgUgDjFxU"
OKTA_REDIRECT_URI = "com.linkedin.approvein:/callback"

GRANT_TYPE_REFRESH_TOKEN = "refresh_token"
GRANT_TYPE_PASSWORD = "password"

OKTA_TOKEN = ''
service_account_session_token = ''
user_token = ''
approval_id = ''


class AuthClaim:
    def __init__(self, grant_type, client_id, client_secret=None, refresh_token=None, redirect_uri=None, username=None,
                 password=None):
        self.grant_type = grant_type
        self.client_id = client_id
        self.client_secret = client_secret
        self.refresh_token = refresh_token
        self.redirect_uri = redirect_uri
        self.username = username
        self.password = password

    def toJson(self):
        return dict((name, getattr(self, name)) for name in dir(self) if getattr(self, name))


def getServiceAccountToken():
    global service_account_session_token
    print "constructing claims"
    claim = AuthClaim(grant_type=GRANT_TYPE_PASSWORD, client_id=SALESFORCE_CLIENT_ID,
                      client_secret=SALESFORCE_CLIENT_SECRET, username=SALESFORCE_USER,
                      password=SALESFORCE_USER_PASSWORD).toJson()
    print('Making OAuth request...')
    r = requests.post(SALESFORCE_TOKEN_URL,
                      headers={"Content-Type": "application/x-www-form-urlencoded"},
                      data=claim)
    if r.status_code == 200:
        print(json.dumps(r.json(), indent=4, sort_keys=True))
        service_account_session_token = r.json()["access_token"]

    else:
        raise Exception("Test failed with exception " + r.content)


def getOktaToken():
    global OKTA_TOKEN
    # *******************************************************
    print "constructing okta claims for refresh token"
    claim = AuthClaim(grant_type=GRANT_TYPE_REFRESH_TOKEN, client_id=OKTA_CLIENT_ID,
                      refresh_token=OKTA_REFRESH_TOKEN, redirect_uri=OKTA_REDIRECT_URI).toJson()

    print('Making OAuth request...')
    r = requests.post(OKTA_TOEKN_URL,
                      headers={"Content-Type": "application/x-www-form-urlencoded"},
                      data=claim)
    if r.status_code == 200:
        print(json.dumps(r.json(), indent=4, sort_keys=True))
        OKTA_TOKEN = r.json()["access_token"]
    else:
        raise Exception("Test failed" + r.content)


def getAccessTokenForUser():
    global user_token
    print('Construction Get body for getaccesstoken for user......')
    claim = {
        "X-OKta-Token": OKTA_TOKEN,
        "user_email": USER_EMAIL,
        "Authorization": "Bearer " + service_account_session_token
    }

    print('Making salesforce request...')
    r = requests.get(SALESFORCE_USER_TOKEN_URL,
                     headers=claim)
    if r.status_code == 200:
        print(json.dumps(r.json(), indent=4, sort_keys=True))
        user_token = r.json()["access_token"]
    else:
        raise Exception("Test failed" + r.content)


def getApprovalList():
    global user_token
    global approval_id
    print('Construction Get body for getApprovalList......')
    claim = {
        "X-OKta-Token": OKTA_TOKEN,
        "user_email": USER_EMAIL,
        "Authorization": "Bearer " + user_token
    }

    print('Making salesforce request...')
    r = requests.get('https://linkedin--1337.my.salesforce.com/services/apexrest/ApproveIn/pendingApprovals',
                     headers=claim)
    if r.status_code == 200:
        print(json.dumps(r.json(), indent=4, sort_keys=True))
        approval_id = r.json()[0]["agreementId"]
    else:
        raise Exception("Test failed" + r.content)


def getApprovalDetails():
    global user_token
    global approval_id
    print('Construction header for for getApprovalDetails......')
    claim = {
        "X-OKta-Token": OKTA_TOKEN,
        "user_email": USER_EMAIL,
        "Authorization": "Bearer " + user_token
    }

    print('Making salesforce request...')
    r = requests.get('https://linkedin--1337.my.salesforce.com/services/apexrest/ApproveIn/agreement/' + approval_id,
                     headers=claim)
    if r.status_code == 200:
        print(json.dumps(r.json(), indent=4, sort_keys=True))

    else:
        raise Exception("Test failed" + r.content)


if __name__ == '__main__':
    # Step 1
    getServiceAccountToken()
    # Step 2
    getOktaToken()
    # Step 3
    getAccessTokenForUser()
    # Step 4
    getApprovalList()
    # Step 5
    getApprovalDetails()
