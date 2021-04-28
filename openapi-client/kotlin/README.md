# org.openapitools.client - Kotlin client library for Mail Baby API

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
*DefaultApi* | [**getMailById**](docs/DefaultApi.md#getmailbyid) | **GET** /mail/{id} | Gets mail order information by id
*DefaultApi* | [**getMailOrders**](docs/DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**pingServer**](docs/DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**placeMailOrder**](docs/DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
*DefaultApi* | [**sendMailById**](docs/DefaultApi.md#sendmailbyid) | **POST** /mail/{id}/send | Sends an Email
*DefaultApi* | [**validateMailOrder**](docs/DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
*DefaultApi* | [**viewMailLogById**](docs/DefaultApi.md#viewmaillogbyid) | **GET** /mail/{id}/log | displays the mail log


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.openapitools.client.models.Error](docs/Error.md)
 - [org.openapitools.client.models.GenericResponse](docs/GenericResponse.md)
 - [org.openapitools.client.models.MailLog](docs/MailLog.md)
 - [org.openapitools.client.models.MailOrder](docs/MailOrder.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

<a name="apiLoginAuth"></a>
### apiLoginAuth

- **Type**: API key
- **API key parameter name**: X-API-LOGIN
- **Location**: HTTP header

<a name="apiPasswordAuth"></a>
### apiPasswordAuth

- **Type**: API key
- **API key parameter name**: X-API-PASS
- **Location**: HTTP header

