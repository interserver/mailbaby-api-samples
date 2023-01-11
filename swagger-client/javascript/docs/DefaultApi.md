# MailBabyEmailDeliveryApi.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log

<a name="getMailOrders"></a>
# **getMailOrders**
> [InlineResponse200] getMailOrders()

displays a list of mail service orders

### Example
```javascript
import {MailBabyEmailDeliveryApi} from 'mail_baby_email_delivery_api';
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

[**[InlineResponse200]**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="pingServer"></a>
# **pingServer**
> pingServer()

Checks if the server is running

### Example
```javascript
import {MailBabyEmailDeliveryApi} from 'mail_baby_email_delivery_api';

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

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(body, subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```javascript
import {MailBabyEmailDeliveryApi} from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
let body = new MailBabyEmailDeliveryApi.SendMailAdv(); // SendMailAdv | 
let subject = "subject_example"; // String | 
let body = "body_example"; // String | 
let from = new MailBabyEmailDeliveryApi.SendMailAdvFrom(); // SendMailAdvFrom | 
let to = [new MailBabyEmailDeliveryApi.SendMailAdvTo()]; // [SendMailAdvTo] | 
let replyto = [new MailBabyEmailDeliveryApi.SendMailAdvReplyto()]; // [SendMailAdvReplyto] | 
let cc = [new MailBabyEmailDeliveryApi.SendMailAdvCc()]; // [SendMailAdvCc] | 
let bcc = [new MailBabyEmailDeliveryApi.SendMailAdvBcc()]; // [SendMailAdvBcc] | 
let attachments = [new MailBabyEmailDeliveryApi.SendMailAdvAttachments()]; // [SendMailAdvAttachments] | 
let id = 789; // Number | 

apiInstance.sendAdvMail(body, subject, body, from, to, replyto, cc, bcc, attachments, id, (error, data, response) => {
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
 **body** | [**SendMailAdv**](SendMailAdv.md)|  | 
 **subject** | **String**|  | 
 **body** | **String**|  | 
 **from** | [**SendMailAdvFrom**](.md)|  | 
 **to** | [**[SendMailAdvTo]**](SendMailAdvTo.md)|  | 
 **replyto** | [**[SendMailAdvReplyto]**](SendMailAdvReplyto.md)|  | 
 **cc** | [**[SendMailAdvCc]**](SendMailAdvCc.md)|  | 
 **bcc** | [**[SendMailAdvBcc]**](SendMailAdvBcc.md)|  | 
 **attachments** | [**[SendMailAdvAttachments]**](SendMailAdvAttachments.md)|  | 
 **id** | **Number**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```javascript
import {MailBabyEmailDeliveryApi} from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
let to = "to_example"; // String | 
let from = "from_example"; // String | 
let subject = "subject_example"; // String | 
let body = "body_example"; // String | 
let body = new MailBabyEmailDeliveryApi.SendMail(); // SendMail | 

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

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(opts)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```javascript
import {MailBabyEmailDeliveryApi} from 'mail_baby_email_delivery_api';
let defaultClient = MailBabyEmailDeliveryApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryApi.DefaultApi();
let opts = { 
  'id': 789, // Number | The ID of your mail order this will be sent through.
  'origin': "origin_example", // String | originating ip address sending mail
  'mx': "mx_example", // String | mx record mail was sent to
  'from': "from_example", // String | from email address
  'to': "to_example", // String | to/destination email address
  'subject': "subject_example", // String | subject containing this string
  'mailid': "mailid_example", // String | mail id
  'skip': 0, // Number | number of records to skip for pagination
  'limit': 100, // Number | maximum number of records to return
  'startDate': 789, // Number | earliest date to get emails in unix timestamp format
  'endDate': 789 // Number | earliest date to get emails in unix timestamp format
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

