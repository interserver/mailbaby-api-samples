# mailbaby-client-kotlin-client - Kotlin client library for MailBaby Email Delivery and Management Service API

## Requires

* Kotlin 1.4.30
* Gradle 5.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in Swagger definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
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

<a name="documentation-for-models"></a>
## Documentation for Models

 - [io.swagger.client.models.AllOfSendMailAdvBcc](docs/AllOfSendMailAdvBcc.md)
 - [io.swagger.client.models.AllOfSendMailAdvCc](docs/AllOfSendMailAdvCc.md)
 - [io.swagger.client.models.AllOfSendMailAdvFrom](docs/AllOfSendMailAdvFrom.md)
 - [io.swagger.client.models.AllOfSendMailAdvReplyto](docs/AllOfSendMailAdvReplyto.md)
 - [io.swagger.client.models.AllOfSendMailAdvTo](docs/AllOfSendMailAdvTo.md)
 - [io.swagger.client.models.DateOrTimestamp](docs/DateOrTimestamp.md)
 - [io.swagger.client.models.DenyRuleNew](docs/DenyRuleNew.md)
 - [io.swagger.client.models.DenyRuleRecord](docs/DenyRuleRecord.md)
 - [io.swagger.client.models.EmailAddressName](docs/EmailAddressName.md)
 - [io.swagger.client.models.EmailAddressNames](docs/EmailAddressNames.md)
 - [io.swagger.client.models.EmailAddressParam](docs/EmailAddressParam.md)
 - [io.swagger.client.models.EmailAddressTypes](docs/EmailAddressTypes.md)
 - [io.swagger.client.models.EmailAddressesTypes](docs/EmailAddressesTypes.md)
 - [io.swagger.client.models.ErrorMessage](docs/ErrorMessage.md)
 - [io.swagger.client.models.GenericResponse](docs/GenericResponse.md)
 - [io.swagger.client.models.MailAttachment](docs/MailAttachment.md)
 - [io.swagger.client.models.MailBlockClickHouse](docs/MailBlockClickHouse.md)
 - [io.swagger.client.models.MailBlockRspamd](docs/MailBlockRspamd.md)
 - [io.swagger.client.models.MailBlocks](docs/MailBlocks.md)
 - [io.swagger.client.models.MailLog](docs/MailLog.md)
 - [io.swagger.client.models.MailLogEntry](docs/MailLogEntry.md)
 - [io.swagger.client.models.MailOrder](docs/MailOrder.md)
 - [io.swagger.client.models.MailOrderDetail](docs/MailOrderDetail.md)
 - [io.swagger.client.models.MailStatsType](docs/MailStatsType.md)
 - [io.swagger.client.models.MailStatsVolume](docs/MailStatsVolume.md)
 - [io.swagger.client.models.SendMail](docs/SendMail.md)
 - [io.swagger.client.models.SendMailAdv](docs/SendMailAdv.md)
 - [io.swagger.client.models.SendMailRaw](docs/SendMailRaw.md)
 - [io.swagger.client.models.SendMailTo](docs/SendMailTo.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth


