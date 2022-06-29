# Documentation for MailBaby Email Delivery API

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *DefaultApi* | [**getMailOrders**](Apis/DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders |
*DefaultApi* | [**pingServer**](Apis/DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running |
*DefaultApi* | [**sendAdvMail**](Apis/DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
*DefaultApi* | [**sendMail**](Apis/DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email |
*DefaultApi* | [**viewMailLog**](Apis/DefaultApi.md#viewmaillog) | **GET** /mail/log | displays the mail log |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [GenericResponse](./Models/GenericResponse.md)
 - [MailLog](./Models/MailLog.md)
 - [MailLogEntry](./Models/MailLogEntry.md)
 - [SendMail](./Models/SendMail.md)
 - [SendMailAdv](./Models/SendMailAdv.md)
 - [SendMailAdv_attachments_inner](./Models/SendMailAdv_attachments_inner.md)
 - [SendMailAdv_bcc_inner](./Models/SendMailAdv_bcc_inner.md)
 - [SendMailAdv_cc_inner](./Models/SendMailAdv_cc_inner.md)
 - [SendMailAdv_from](./Models/SendMailAdv_from.md)
 - [SendMailAdv_replyto_inner](./Models/SendMailAdv_replyto_inner.md)
 - [SendMailAdv_to_inner](./Models/SendMailAdv_to_inner.md)
 - [getMailOrders_200_response_inner](./Models/getMailOrders_200_response_inner.md)
 - [getMailOrders_401_response](./Models/getMailOrders_401_response.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

