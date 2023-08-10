# Documentation for MailBaby Email Delivery and Management Service API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *BlockingApi* | [**addRule**](Apis/BlockingApi.md#addrule) | **POST** /mail/rules | Creates a new email deny rule. |
*BlockingApi* | [**deleteRule**](Apis/BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
*BlockingApi* | [**delistBlock**](Apis/BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
*BlockingApi* | [**getMailBlocks**](Apis/BlockingApi.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
*BlockingApi* | [**getRules**](Apis/BlockingApi.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules. |
| *HistoryApi* | [**getStats**](Apis/HistoryApi.md#getstats) | **GET** /mail/stats | displays a list of blocked email addresses |
*HistoryApi* | [**viewMailLog**](Apis/HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log |
| *SendingApi* | [**sendAdvMail**](Apis/SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
*SendingApi* | [**sendMail**](Apis/SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email |
| *ServicesApi* | [**getMailOrders**](Apis/ServicesApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders |
| *StatusApi* | [**pingServer**](Apis/StatusApi.md#pingserver) | **GET** /ping | Checks if the server is running |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [DenyRuleNew](./Models/DenyRuleNew.md)
 - [DenyRuleRecord](./Models/DenyRuleRecord.md)
 - [EmailAddress](./Models/EmailAddress.md)
 - [EmailAddressName](./Models/EmailAddressName.md)
 - [GenericResponse](./Models/GenericResponse.md)
 - [MailAttachment](./Models/MailAttachment.md)
 - [MailBlockClickHouse](./Models/MailBlockClickHouse.md)
 - [MailBlockRspamd](./Models/MailBlockRspamd.md)
 - [MailBlocks](./Models/MailBlocks.md)
 - [MailLog](./Models/MailLog.md)
 - [MailLogEntry](./Models/MailLogEntry.md)
 - [MailOrder](./Models/MailOrder.md)
 - [SendMail](./Models/SendMail.md)
 - [SendMailAdv](./Models/SendMailAdv.md)
 - [getMailOrders_401_response](./Models/getMailOrders_401_response.md)
 - [getStats_200_response_inner](./Models/getStats_200_response_inner.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

