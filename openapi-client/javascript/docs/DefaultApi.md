# MailBabyEmailDeliveryApi.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log



## getMailOrders

> [GetMailOrders200ResponseInner] getMailOrders()

displays a list of mail service orders

### Example

```javascript
import MailBabyEmailDeliveryApi from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
apiInstance.getMailOrders((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[GetMailOrders200ResponseInner]**](GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## pingServer

> pingServer()

Checks if the server is running

### Example

```javascript
import MailBabyEmailDeliveryApi from 'mail_baby_email_delivery_api';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
apiInstance.pingServer((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully.');
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## sendAdvMail

> GenericResponse sendAdvMail(sendMailAdv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```javascript
import MailBabyEmailDeliveryApi from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
let sendMailAdv = new MailBabyEmailDeliveryApi.SendMailAdv(); // SendMailAdv | 
apiInstance.sendAdvMail(sendMailAdv, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json


## sendMail

> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example

```javascript
import MailBabyEmailDeliveryApi from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
let to = "to_example"; // String | The Contact whom is the primary recipient of this email.
let from = "from_example"; // String | The contact whom is the this email is from.
let subject = "subject_example"; // String | The subject or title of the email
let body = "body_example"; // String | The main email contents.
apiInstance.sendMail(to, from, subject, body, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **String**| The Contact whom is the primary recipient of this email. | 
 **from** | **String**| The contact whom is the this email is from. | 
 **subject** | **String**| The subject or title of the email | 
 **body** | **String**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json


## viewMailLog

> MailLog viewMailLog(opts)

displays the mail log

Get a listing of the emails sent through this system 

### Example

```javascript
import MailBabyEmailDeliveryApi from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
let opts = {
  'id': 2604, // Number | The ID of your mail order this will be sent through.
  'origin': 1.2.3.4, // String | originating ip address sending mail
  'mx': mx.google.com, // String | mx record mail was sent to
  'from': me@sender.com, // String | from email address
  'to': you@receiver.com, // String | to/destination email address
  'subject': Support, // String | subject containing this string
  'mailid': 185997065c60008840, // String | mail id
  'skip': 1000, // Number | number of records to skip for pagination
  'limit': 1000, // Number | maximum number of records to return
  'startDate': 1641781008, // Number | earliest date to get emails in unix timestamp format
  'endDate': 1673317008 // Number | earliest date to get emails in unix timestamp format
};
apiInstance.viewMailLog(opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **String**| originating ip address sending mail | [optional] 
 **mx** | **String**| mx record mail was sent to | [optional] 
 **from** | **String**| from email address | [optional] 
 **to** | **String**| to/destination email address | [optional] 
 **subject** | **String**| subject containing this string | [optional] 
 **mailid** | **String**| mail id | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **Number**| maximum number of records to return | [optional] [default to 100]
 **startDate** | **Number**| earliest date to get emails in unix timestamp format | [optional] 
 **endDate** | **Number**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

