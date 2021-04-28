# Documentation for Mail Baby API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**getMailById**](Apis/DefaultApi.md#getmailbyid) | **GET** /mail/{id} | Gets mail order information by id
*DefaultApi* | [**getMailOrders**](Apis/DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**pingServer**](Apis/DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**placeMailOrder**](Apis/DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
*DefaultApi* | [**sendAdvMailById**](Apis/DefaultApi.md#sendadvmailbyid) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
*DefaultApi* | [**sendMailById**](Apis/DefaultApi.md#sendmailbyid) | **POST** /mail/{id}/send | Sends an Email
*DefaultApi* | [**validateMailOrder**](Apis/DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
*DefaultApi* | [**viewMailLogById**](Apis/DefaultApi.md#viewmaillogbyid) | **GET** /mail/{id}/log | displays the mail log


<a name="documentation-for-models"></a>
## Documentation for Models

 - [ErrorResponse](./Models/ErrorResponse.md)
 - [GenericResponse](./Models/GenericResponse.md)
 - [MailAttachment](./Models/MailAttachment.md)
 - [MailContact](./Models/MailContact.md)
 - [MailLog](./Models/MailLog.md)
 - [MailOrder](./Models/MailOrder.md)
 - [SendMail](./Models/SendMail.md)


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

