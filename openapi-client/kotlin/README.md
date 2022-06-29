# org.openapitools.client - Kotlin client library for MailBaby Email Delivery API

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

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

 - [org.openapitools.client.models.GenericResponse](docs/GenericResponse.md)
 - [org.openapitools.client.models.GetMailOrders200ResponseInner](docs/GetMailOrders200ResponseInner.md)
 - [org.openapitools.client.models.GetMailOrders401Response](docs/GetMailOrders401Response.md)
 - [org.openapitools.client.models.MailLog](docs/MailLog.md)
 - [org.openapitools.client.models.MailLogEntry](docs/MailLogEntry.md)
 - [org.openapitools.client.models.SendMail](docs/SendMail.md)
 - [org.openapitools.client.models.SendMailAdv](docs/SendMailAdv.md)
 - [org.openapitools.client.models.SendMailAdvAttachmentsInner](docs/SendMailAdvAttachmentsInner.md)
 - [org.openapitools.client.models.SendMailAdvBccInner](docs/SendMailAdvBccInner.md)
 - [org.openapitools.client.models.SendMailAdvCcInner](docs/SendMailAdvCcInner.md)
 - [org.openapitools.client.models.SendMailAdvFrom](docs/SendMailAdvFrom.md)
 - [org.openapitools.client.models.SendMailAdvReplytoInner](docs/SendMailAdvReplytoInner.md)
 - [org.openapitools.client.models.SendMailAdvToInner](docs/SendMailAdvToInner.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

