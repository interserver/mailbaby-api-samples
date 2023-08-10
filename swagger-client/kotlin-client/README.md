# io.swagger.client - Kotlin client library for MailBaby Email Delivery and Management Service API

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
*BlockingApi* | [**addRule**](docs/BlockingApi.md#addrule) | **POST** /mail/rules | Creates a new email deny rule.
*BlockingApi* | [**deleteRule**](docs/BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
*BlockingApi* | [**delistBlock**](docs/BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
*BlockingApi* | [**getMailBlocks**](docs/BlockingApi.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses
*BlockingApi* | [**getRules**](docs/BlockingApi.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules.
*HistoryApi* | [**getStats**](docs/HistoryApi.md#getstats) | **GET** /mail/stats | displays a list of blocked email addresses
*HistoryApi* | [**viewMailLog**](docs/HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log
*SendingApi* | [**sendAdvMail**](docs/SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*SendingApi* | [**sendMail**](docs/SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email
*ServicesApi* | [**getMailOrders**](docs/ServicesApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*StatusApi* | [**pingServer**](docs/StatusApi.md#pingserver) | **GET** /ping | Checks if the server is running

<a name="documentation-for-models"></a>
## Documentation for Models

 - [io.swagger.client.models.DenyRuleNew](docs/DenyRuleNew.md)
 - [io.swagger.client.models.DenyRuleRecord](docs/DenyRuleRecord.md)
 - [io.swagger.client.models.EmailAddress](docs/EmailAddress.md)
 - [io.swagger.client.models.EmailAddressName](docs/EmailAddressName.md)
 - [io.swagger.client.models.GenericResponse](docs/GenericResponse.md)
 - [io.swagger.client.models.InlineResponse200](docs/InlineResponse200.md)
 - [io.swagger.client.models.InlineResponse401](docs/InlineResponse401.md)
 - [io.swagger.client.models.MailAttachment](docs/MailAttachment.md)
 - [io.swagger.client.models.MailBlockClickHouse](docs/MailBlockClickHouse.md)
 - [io.swagger.client.models.MailBlockRspamd](docs/MailBlockRspamd.md)
 - [io.swagger.client.models.MailBlocks](docs/MailBlocks.md)
 - [io.swagger.client.models.MailLog](docs/MailLog.md)
 - [io.swagger.client.models.MailLogEntry](docs/MailLogEntry.md)
 - [io.swagger.client.models.MailOrder](docs/MailOrder.md)
 - [io.swagger.client.models.SendMail](docs/SendMail.md)
 - [io.swagger.client.models.SendMailAdv](docs/SendMailAdv.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth


