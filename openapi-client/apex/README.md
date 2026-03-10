# MailBaby Email Delivery and Management Service API API Client


**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**\n\n# Overview\n\nThis is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).\n\n# Mail Orders\n\nEvery sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric `id` and a corresponding SMTP username (`mb<id>`).  Most calls accept an optional `id` parameter; when omitted the API automatically selects the first active order on your account. Use `GET /mail` to list all orders, and `GET /mail/{id}` to inspect a single order including its current SMTP password.\n\n# Sending Email\n\nThree sending methods are available depending on your use-case:\n| Endpoint | Best for | |----------|----------| | `POST /mail/send` | Simple single-recipient messages | | `POST /mail/advsend` | Multiple recipients, CC/BCC, attachments, named contacts | | `POST /mail/rawsend` | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |\n\nAfter a successful send each endpoint returns a `GenericResponse` whose `text` field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in `GET /mail/log` via the `mailid` query parameter.\n\n# Filtering & Logs\n\n`GET /mail/log` provides paginated access to every message accepted by the relay for your account.  Combine any of the query parameters to narrow results — e.g. `from`, `to`, `subject`, `messageId`, `origin`, `mx`, `startDate`/`endDate`, and `delivered`.\n\n# Blocking\n\nTwo independent mechanisms exist for suppressing unwanted email:\n- **Block lists** (`GET /mail/blocks`, `POST /mail/blocks/delete`) — addresses flagged by the\n  system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects).\n- **Deny rules** (`GET /mail/rules`, `POST /mail/rules`, `DELETE /mail/rules/{ruleId}`) —\n  custom rules you configure to reject specific senders, domains, destination addresses, or\n  subject-line prefixes before a message is even attempted.\n\n\n# Authentication\n\nIn order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.\nWe support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.\nPass your key in the `X-API-KEY` HTTP request header for every protected call.\n

## Requirements

- [Salesforce DX](https://www.salesforce.com/products/platform/products/salesforce-dx/)

If everything is set correctly:

- Running `sfdx version` in a command prompt should output something like:

  ```bash
  sfdx-cli/5.7.5-05549de (darwin-amd64) go1.7.5 sfdxstable
  ```

## Installation

1. Copy the output into your Salesforce DX folder - or alternatively deploy the output directly into the workspace.
2. Deploy the code via Salesforce DX to your Scratch Org

   ```bash
      sfdx force:source:push
   ```

3. If the API needs authentication update the Named Credential in Setup.
4. Run your Apex tests using

   ```bash
       sfdx sfdx force:apex:test:run
   ```

5. Retrieve the job id from the console and check the test results.

  ```bash
  sfdx force:apex:test:report -i theJobId
  ```

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Apex code:

```java
OASBlockingApi api = new OASBlockingApi();
OASClient client = api.getClient();


Map<String, Object> params = new Map<String, Object>{
    'type' => 'null',
    'data' => 'null',
    'user' => 'null'
};

try {
    // cross your fingers
    OASGenericResponse result = api.addRule(params);
    System.debug(result);
} catch (OAS.ApiException e) {
    // ...handle your exceptions
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OASBlockingApi* | [**addRule**](OASBlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule
*OASBlockingApi* | [**deleteRule**](OASBlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes a deny mail rule
*OASBlockingApi* | [**delistBlock**](OASBlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the block lists
*OASBlockingApi* | [**getMailBlocks**](OASBlockingApi.md#getMailBlocks) | **GET** /mail/blocks | Displays a list of blocked email addresses
*OASBlockingApi* | [**getRules**](OASBlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules
*OASHistoryApi* | [**getStats**](OASHistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics
*OASHistoryApi* | [**viewMailLog**](OASHistoryApi.md#viewMailLog) | **GET** /mail/log | Displays the mail log
*OASSendingApi* | [**rawMail**](OASSendingApi.md#rawMail) | **POST** /mail/rawsend | Sends a raw RFC 822 email
*OASSendingApi* | [**sendAdvMail**](OASSendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*OASSendingApi* | [**sendMail**](OASSendingApi.md#sendMail) | **POST** /mail/send | Sends an Email
*OASServicesApi* | [**getMailOrderById**](OASServicesApi.md#getMailOrderById) | **GET** /mail/{id} | Displays details for a single mail order
*OASServicesApi* | [**getMailOrders**](OASServicesApi.md#getMailOrders) | **GET** /mail | Displays a list of mail service orders
*OASStatusApi* | [**pingServer**](OASStatusApi.md#pingServer) | **GET** /ping | Checks if the server is running


## Documentation for Models

 - [OASDenyRuleNew](OASDenyRuleNew.md)
 - [OASDenyRuleRecord](OASDenyRuleRecord.md)
 - [OASEmailAddressName](OASEmailAddressName.md)
 - [OASEmailAddressParam](OASEmailAddressParam.md)
 - [OASEmailAddressTypes](OASEmailAddressTypes.md)
 - [OASEmailAddressesTypes](OASEmailAddressesTypes.md)
 - [OASErrorMessage](OASErrorMessage.md)
 - [OASGenericResponse](OASGenericResponse.md)
 - [OASMailAttachment](OASMailAttachment.md)
 - [OASMailBlockClickHouse](OASMailBlockClickHouse.md)
 - [OASMailBlockRspamd](OASMailBlockRspamd.md)
 - [OASMailBlocks](OASMailBlocks.md)
 - [OASMailLog](OASMailLog.md)
 - [OASMailLogEntry](OASMailLogEntry.md)
 - [OASMailOrder](OASMailOrder.md)
 - [OASMailOrderDetail](OASMailOrderDetail.md)
 - [OASMailStatsType](OASMailStatsType.md)
 - [OASMailStatsTypeVolume](OASMailStatsTypeVolume.md)
 - [OASSendMail](OASSendMail.md)
 - [OASSendMailAdv](OASSendMailAdv.md)
 - [OASSendMailRaw](OASSendMailRaw.md)
 - [OASSendMailTo](OASSendMailTo.md)


## Documentation for Authorization


Authentication schemes defined for the API:
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header


## Author

support@interserver.net

