# Go API client for swagger

This is an API for accesssing the mail services.

## Overview
This API client was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  By using the [swagger-spec](https://github.com/swagger-api/swagger-spec) from a remote server, you can easily generate an API client.

- API version: 1.0.0
- Package version: 1.0.0
- Build package: io.swagger.codegen.v3.generators.go.GoClientCodegen
For more information, please visit [https://www.interserver.net/contact-information.html](https://www.interserver.net/contact-information.html)

## Installation
Put the package under your project folder and add the following in import:
```golang
import "./swagger"
```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**GetMailById**](docs/DefaultApi.md#getmailbyid) | **Get** /mail/{id} | Gets mail order information by id
*DefaultApi* | [**GetMailOrders**](docs/DefaultApi.md#getmailorders) | **Get** /mail | displays a list of mail service orders
*DefaultApi* | [**PingServer**](docs/DefaultApi.md#pingserver) | **Get** /ping | Checks if the server is running
*DefaultApi* | [**PlaceMailOrder**](docs/DefaultApi.md#placemailorder) | **Post** /mail/order | places a mail order
*DefaultApi* | [**SendMailById**](docs/DefaultApi.md#sendmailbyid) | **Post** /mail/{id}/send | Sends an Email
*DefaultApi* | [**ValidateMailOrder**](docs/DefaultApi.md#validatemailorder) | **Get** /mail/order | validatess order details before placing an order
*DefaultApi* | [**ViewMailLogById**](docs/DefaultApi.md#viewmaillogbyid) | **Get** /mail/{id}/log | displays the mail log

## Documentation For Models

 - [GenericResponse](docs/GenericResponse.md)
 - [MailLog](docs/MailLog.md)
 - [MailOrder](docs/MailOrder.md)
 - [ModelError](docs/ModelError.md)

## Documentation For Authorization

## apiKeyAuth
- **Type**: API key 

Example
```golang
auth := context.WithValue(context.Background(), sw.ContextAPIKey, sw.APIKey{
	Key: "APIKEY",
	Prefix: "Bearer", // Omit if not necessary.
})
r, err := client.Service.Operation(auth, args)
```
## apiLoginAuth
- **Type**: API key 

Example
```golang
auth := context.WithValue(context.Background(), sw.ContextAPIKey, sw.APIKey{
	Key: "APIKEY",
	Prefix: "Bearer", // Omit if not necessary.
})
r, err := client.Service.Operation(auth, args)
```
## apiPasswordAuth
- **Type**: API key 

Example
```golang
auth := context.WithValue(context.Background(), sw.ContextAPIKey, sw.APIKey{
	Key: "APIKEY",
	Prefix: "Bearer", // Omit if not necessary.
})
r, err := client.Service.Operation(auth, args)
```

## Author

detain@interserver.net