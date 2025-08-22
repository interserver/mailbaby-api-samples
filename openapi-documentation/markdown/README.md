# Documentation for MailBaby Email Delivery and Management Service API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *BlockingApi* | [**addRule**](Apis/BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule. |
*BlockingApi* | [**deleteRule**](Apis/BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
*BlockingApi* | [**delistBlock**](Apis/BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
*BlockingApi* | [**getMailBlocks**](Apis/BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
*BlockingApi* | [**getRules**](Apis/BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules. |
| *HistoryApi* | [**getStats**](Apis/HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics. |
*HistoryApi* | [**viewMailLog**](Apis/HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |
| *SendingApi* | [**sendAdvMail**](Apis/SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
*SendingApi* | [**sendMail**](Apis/SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email |
| *ServicesApi* | [**getMailOrders**](Apis/ServicesApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |
| *StatusApi* | [**pingServer**](Apis/StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [DenyRuleNew](./Models/DenyRuleNew.md)
 - [DenyRuleRecord](./Models/DenyRuleRecord.md)
 - [EmailAddressName](./Models/EmailAddressName.md)
 - [EmailAddressTypes](./Models/EmailAddressTypes.md)
 - [EmailAddressesTypes](./Models/EmailAddressesTypes.md)
 - [ErrorMessage](./Models/ErrorMessage.md)
 - [GenericResponse](./Models/GenericResponse.md)
 - [MailAttachment](./Models/MailAttachment.md)
 - [MailBlockClickHouse](./Models/MailBlockClickHouse.md)
 - [MailBlockRspamd](./Models/MailBlockRspamd.md)
 - [MailBlocks](./Models/MailBlocks.md)
 - [MailLog](./Models/MailLog.md)
 - [MailLogEntry](./Models/MailLogEntry.md)
 - [MailOrder](./Models/MailOrder.md)
 - [MailStatsType](./Models/MailStatsType.md)
 - [MailStatsType_volume](./Models/MailStatsType_volume.md)
 - [MailStatsType_volume_from](./Models/MailStatsType_volume_from.md)
 - [MailStatsType_volume_ip](./Models/MailStatsType_volume_ip.md)
 - [MailStatsType_volume_to](./Models/MailStatsType_volume_to.md)
 - [SendMail](./Models/SendMail.md)
 - [SendMailAdv](./Models/SendMailAdv.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

