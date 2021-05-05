# Documentation for Mail Baby API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**getMailOrders**](Apis/DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**pingServer**](Apis/DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**placeMailOrder**](Apis/DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
*DefaultApi* | [**sendAdvMail**](Apis/DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*DefaultApi* | [**sendMail**](Apis/DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email
*DefaultApi* | [**validateMailOrder**](Apis/DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
*DefaultApi* | [**viewMailLogById**](Apis/DefaultApi.md#viewmaillogbyid) | **GET** /mail/log | displays the mail log


<a name="documentation-for-models"></a>
## Documentation for Models

 - [ErrorResponse](./Models/ErrorResponse.md)
 - [GenericResponse](./Models/GenericResponse.md)
 - [MailAttachment](./Models/MailAttachment.md)
 - [MailContact](./Models/MailContact.md)
 - [MailLog](./Models/MailLog.md)
 - [MailOrder](./Models/MailOrder.md)
 - [SendMail](./Models/SendMail.md)
 - [SendMailAdv](./Models/SendMailAdv.md)
 - [SendMailAdvFrom](./Models/SendMailAdvFrom.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

