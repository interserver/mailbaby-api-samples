# MailBabyEmailDeliveryAndManagementServiceApi.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id, body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```javascript
import {MailBabyEmailDeliveryAndManagementServiceApi} from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.SendingApi();
let subject = "subject_example"; // String | 
let body = "body_example"; // String | 
let from = new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName(); // EmailAddressName | 
let to = [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()]; // [EmailAddressName] | 
let replyto = [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()]; // [EmailAddressName] | 
let cc = [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()]; // [EmailAddressName] | 
let bcc = [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()]; // [EmailAddressName] | 
let attachments = [new MailBabyEmailDeliveryAndManagementServiceApi.MailAttachment()]; // [MailAttachment] | 
let id = 789; // Number | 
let body = new MailBabyEmailDeliveryAndManagementServiceApi.SendMailAdv(); // SendMailAdv | 

apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id, body, (error, data, response) => {
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
 **subject** | **String**|  | 
 **body** | **String**|  | 
 **from** | [**EmailAddressName**](.md)|  | 
 **to** | [**[EmailAddressName]**](EmailAddressName.md)|  | 
 **replyto** | [**[EmailAddressName]**](EmailAddressName.md)|  | 
 **cc** | [**[EmailAddressName]**](EmailAddressName.md)|  | 
 **bcc** | [**[EmailAddressName]**](EmailAddressName.md)|  | 
 **attachments** | [**[MailAttachment]**](MailAttachment.md)|  | 
 **id** | **Number**|  | 
 **body** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```javascript
import {MailBabyEmailDeliveryAndManagementServiceApi} from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.SendingApi();
let to = "to_example"; // String | 
let from = "from_example"; // String | 
let subject = "subject_example"; // String | 
let body = "body_example"; // String | 
let body = new MailBabyEmailDeliveryAndManagementServiceApi.SendMail(); // SendMail | 

apiInstance.sendMail(to, from, subject, body, body, (error, data, response) => {
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
 **to** | **String**|  | 
 **from** | **String**|  | 
 **subject** | **String**|  | 
 **body** | **String**|  | 
 **body** | [**SendMail**](SendMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

