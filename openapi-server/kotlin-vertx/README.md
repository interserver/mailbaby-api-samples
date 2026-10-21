# MailBabyKotlinVertx - Kotlin Server library for MailBaby Email Delivery and Management Service API

## Requires

* Kotlin 1.3.10
* Maven 3.3

## Build

```
mvn clean package
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.

<a id="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingApi* | [**addRule**](docs/BlockingApi.md#addrule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix
*BlockingApi* | [**deleteRule**](docs/BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId
*BlockingApi* | [**delistBlock**](docs/BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists
*BlockingApi* | [**getMailBlocks**](docs/BlockingApi.md#getmailblocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists
*BlockingApi* | [**getRules**](docs/BlockingApi.md#getrules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix)
*HistoryApi* | [**getStats**](docs/HistoryApi.md#getstats) | **GET** /mail/stats | Account usage, cost, and volume statistics for a time window
*HistoryApi* | [**viewMailLog**](docs/HistoryApi.md#viewmaillog) | **GET** /mail/log | Query the mail delivery log (filterable, paginated)
*SendingApi* | [**rawMail**](docs/SendingApi.md#rawmail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
*SendingApi* | [**sendAdvMail**](docs/SendingApi.md#sendadvmail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
*SendingApi* | [**sendMail**](docs/SendingApi.md#sendmail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML)
*ServicesApi* | [**getMailOrderById**](docs/ServicesApi.md#getmailorderbyid) | **GET** /mail/{id} | Get one mail order's full detail including SMTP password
*ServicesApi* | [**getMailOrders**](docs/ServicesApi.md#getmailorders) | **GET** /mail | List your provisioned mail orders (sending accounts)
*StatusApi* | [**pingServer**](docs/StatusApi.md#pingserver) | **GET** /ping | Health check — verify the API is reachable


<a id="documentation-for-models"></a>
## Documentation for Models

 - [MailBabyKotlinVertx.models.DateOrTimestamp](docs/DateOrTimestamp.md)
 - [MailBabyKotlinVertx.models.DenyRuleNew](docs/DenyRuleNew.md)
 - [MailBabyKotlinVertx.models.DenyRuleRecord](docs/DenyRuleRecord.md)
 - [MailBabyKotlinVertx.models.EmailAddressName](docs/EmailAddressName.md)
 - [MailBabyKotlinVertx.models.EmailAddressParam](docs/EmailAddressParam.md)
 - [MailBabyKotlinVertx.models.EmailAddressTypes](docs/EmailAddressTypes.md)
 - [MailBabyKotlinVertx.models.EmailAddressesTypes](docs/EmailAddressesTypes.md)
 - [MailBabyKotlinVertx.models.ErrorMessage](docs/ErrorMessage.md)
 - [MailBabyKotlinVertx.models.GenericResponse](docs/GenericResponse.md)
 - [MailBabyKotlinVertx.models.MailAttachment](docs/MailAttachment.md)
 - [MailBabyKotlinVertx.models.MailBlockClickHouse](docs/MailBlockClickHouse.md)
 - [MailBabyKotlinVertx.models.MailBlockRspamd](docs/MailBlockRspamd.md)
 - [MailBabyKotlinVertx.models.MailBlocks](docs/MailBlocks.md)
 - [MailBabyKotlinVertx.models.MailLog](docs/MailLog.md)
 - [MailBabyKotlinVertx.models.MailLogEntry](docs/MailLogEntry.md)
 - [MailBabyKotlinVertx.models.MailOrder](docs/MailOrder.md)
 - [MailBabyKotlinVertx.models.MailOrderDetail](docs/MailOrderDetail.md)
 - [MailBabyKotlinVertx.models.MailStatsType](docs/MailStatsType.md)
 - [MailBabyKotlinVertx.models.MailStatsVolume](docs/MailStatsVolume.md)
 - [MailBabyKotlinVertx.models.SendMail](docs/SendMail.md)
 - [MailBabyKotlinVertx.models.SendMailAdv](docs/SendMailAdv.md)
 - [MailBabyKotlinVertx.models.SendMailRaw](docs/SendMailRaw.md)
 - [MailBabyKotlinVertx.models.SendMailTo](docs/SendMailTo.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

