# org.openapitools.client - Kotlin client library for MailBaby Email Delivery and Management Service API

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**
# Overview
This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).
# Authentication
In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.
We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.


## Overview
This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.  By using the [openapi-spec](https://github.com/OAI/OpenAPI-Specification) from a remote server, you can easily generate an API client.

- API version: 1.1.0
- Package version: 
- Generator version: 7.14.0-SNAPSHOT
- Build package: org.openapitools.codegen.languages.KotlinClientCodegen
For more information, please visit [https://www.mail.baby/contact/](https://www.mail.baby/contact/)

## Requires

* Kotlin 1.7.21
* Gradle 7.5

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
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a id="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

| Class | Method | HTTP request | Description |
| ------------ | ------------- | ------------- | ------------- |
| *BlockingApi* | [**addRule**](docs/BlockingApi.md#addrule) | **POST** /mail/rules | Creates a new email deny rule. |
| *BlockingApi* | [**deleteRule**](docs/BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule. |
| *BlockingApi* | [**delistBlock**](docs/BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list |
| *BlockingApi* | [**getMailBlocks**](docs/BlockingApi.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses |
| *BlockingApi* | [**getRules**](docs/BlockingApi.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules. |
| *HistoryApi* | [**getStats**](docs/HistoryApi.md#getstats) | **GET** /mail/stats | Account usage statistics. |
| *HistoryApi* | [**viewMailLog**](docs/HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log |
| *SendingApi* | [**sendAdvMail**](docs/SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| *SendingApi* | [**sendMail**](docs/SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email |
| *ServicesApi* | [**getMailOrders**](docs/ServicesApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders |
| *StatusApi* | [**pingServer**](docs/StatusApi.md#pingserver) | **GET** /ping | Checks if the server is running |


<a id="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.DenyRuleNew](docs/DenyRuleNew.md)
 - [org.openapitools.client.models.DenyRuleRecord](docs/DenyRuleRecord.md)
 - [org.openapitools.client.models.EmailAddressName](docs/EmailAddressName.md)
 - [org.openapitools.client.models.EmailAddressTypes](docs/EmailAddressTypes.md)
 - [org.openapitools.client.models.EmailAddressesTypes](docs/EmailAddressesTypes.md)
 - [org.openapitools.client.models.ErrorMessage](docs/ErrorMessage.md)
 - [org.openapitools.client.models.GenericResponse](docs/GenericResponse.md)
 - [org.openapitools.client.models.MailAttachment](docs/MailAttachment.md)
 - [org.openapitools.client.models.MailBlockClickHouse](docs/MailBlockClickHouse.md)
 - [org.openapitools.client.models.MailBlockRspamd](docs/MailBlockRspamd.md)
 - [org.openapitools.client.models.MailBlocks](docs/MailBlocks.md)
 - [org.openapitools.client.models.MailLog](docs/MailLog.md)
 - [org.openapitools.client.models.MailLogEntry](docs/MailLogEntry.md)
 - [org.openapitools.client.models.MailOrder](docs/MailOrder.md)
 - [org.openapitools.client.models.MailStatsType](docs/MailStatsType.md)
 - [org.openapitools.client.models.MailStatsTypeVolume](docs/MailStatsTypeVolume.md)
 - [org.openapitools.client.models.MailStatsTypeVolumeFrom](docs/MailStatsTypeVolumeFrom.md)
 - [org.openapitools.client.models.MailStatsTypeVolumeIp](docs/MailStatsTypeVolumeIp.md)
 - [org.openapitools.client.models.MailStatsTypeVolumeTo](docs/MailStatsTypeVolumeTo.md)
 - [org.openapitools.client.models.SendMail](docs/SendMail.md)
 - [org.openapitools.client.models.SendMailAdv](docs/SendMailAdv.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header



## Author

support@interserver.net
