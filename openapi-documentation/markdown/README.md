# Documentation for MailBaby Email Delivery and Management Service API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *BlockingApi* | [**addRule**](Apis/BlockingApi.md#addRule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix |
*BlockingApi* | [**deleteRule**](Apis/BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId |
*BlockingApi* | [**delistBlock**](Apis/BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists |
*BlockingApi* | [**getMailBlocks**](Apis/BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists |
*BlockingApi* | [**getRules**](Apis/BlockingApi.md#getRules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix) |
| *HistoryApi* | [**getStats**](Apis/HistoryApi.md#getStats) | **GET** /mail/stats | Account usage, cost, and volume statistics for a time window |
*HistoryApi* | [**viewMailLog**](Apis/HistoryApi.md#viewMailLog) | **GET** /mail/log | Query the mail delivery log (filterable, paginated) |
| *SendingApi* | [**rawMail**](Apis/SendingApi.md#rawMail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM) |
*SendingApi* | [**sendAdvMail**](Apis/SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts |
*SendingApi* | [**sendMail**](Apis/SendingApi.md#sendMail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML) |
| *ServicesApi* | [**getMailOrderById**](Apis/ServicesApi.md#getMailOrderById) | **GET** /mail/{id} | Get one mail order's full detail including SMTP password |
*ServicesApi* | [**getMailOrders**](Apis/ServicesApi.md#getMailOrders) | **GET** /mail | List your provisioned mail orders (sending accounts) |
| *StatusApi* | [**pingServer**](Apis/StatusApi.md#pingServer) | **GET** /ping | Health check — verify the API is reachable |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [DateOrTimestamp](./Models/DateOrTimestamp.md)
 - [DenyRuleNew](./Models/DenyRuleNew.md)
 - [DenyRuleRecord](./Models/DenyRuleRecord.md)
 - [EmailAddressName](./Models/EmailAddressName.md)
 - [EmailAddressParam](./Models/EmailAddressParam.md)
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
 - [MailOrderDetail](./Models/MailOrderDetail.md)
 - [MailStatsType](./Models/MailStatsType.md)
 - [MailStatsVolume](./Models/MailStatsVolume.md)
 - [SendMail](./Models/SendMail.md)
 - [SendMailAdv](./Models/SendMailAdv.md)
 - [SendMailRaw](./Models/SendMailRaw.md)
 - [SendMailTo](./Models/SendMailTo.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

