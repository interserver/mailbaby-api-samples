# io.swagger.client - Kotlin client library for MailBaby Email Delivery API

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
*DefaultApi* | [**getMailOrders**](docs/DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**pingServer**](docs/DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**sendAdvMail**](docs/DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*DefaultApi* | [**sendMail**](docs/DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email
*DefaultApi* | [**viewMailLog**](docs/DefaultApi.md#viewmaillog) | **GET** /mail/log | displays the mail log

<a name="documentation-for-models"></a>
## Documentation for Models

 - [io.swagger.client.models.GenericResponse](docs/GenericResponse.md)
 - [io.swagger.client.models.InlineResponse200](docs/InlineResponse200.md)
 - [io.swagger.client.models.InlineResponse401](docs/InlineResponse401.md)
 - [io.swagger.client.models.MailLog](docs/MailLog.md)
 - [io.swagger.client.models.MailLogEntry](docs/MailLogEntry.md)
 - [io.swagger.client.models.SendMail](docs/SendMail.md)
 - [io.swagger.client.models.SendMailAdv](docs/SendMailAdv.md)
 - [io.swagger.client.models.SendMailAdvAttachments](docs/SendMailAdvAttachments.md)
 - [io.swagger.client.models.SendMailAdvBcc](docs/SendMailAdvBcc.md)
 - [io.swagger.client.models.SendMailAdvCc](docs/SendMailAdvCc.md)
 - [io.swagger.client.models.SendMailAdvFrom](docs/SendMailAdvFrom.md)
 - [io.swagger.client.models.SendMailAdvReplyto](docs/SendMailAdvReplyto.md)
 - [io.swagger.client.models.SendMailAdvTo](docs/SendMailAdvTo.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth


