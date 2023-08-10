# swagger.api.SendingApi

## Load the API package
```dart
import 'package:swagger/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email

# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id, body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```dart
import 'package:swagger/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//swagger.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//swagger.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";

var api_instance = new SendingApi();
var subject = subject_example; // String | 
var body = body_example; // String | 
var from = ; // EmailAddressName | 
var to = []; // List<EmailAddressName> | 
var replyto = []; // List<EmailAddressName> | 
var cc = []; // List<EmailAddressName> | 
var bcc = []; // List<EmailAddressName> | 
var attachments = []; // List<MailAttachment> | 
var id = 789; // int | 
var body = new SendMailAdv(); // SendMailAdv | 

try {
    var result = api_instance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id, body);
    print(result);
} catch (e) {
    print("Exception when calling SendingApi->sendAdvMail: $e\n");
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**|  | 
 **body** | **String**|  | 
 **from** | [**EmailAddressName**](.md)|  | 
 **to** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **replyto** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **cc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **bcc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)|  | 
 **id** | **int**|  | 
 **body** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
> GenericResponse sendMail(to, from, subject, body, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```dart
import 'package:swagger/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//swagger.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//swagger.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";

var api_instance = new SendingApi();
var to = to_example; // String | 
var from = from_example; // String | 
var subject = subject_example; // String | 
var body = body_example; // String | 
var body = new SendMail(); // SendMail | 

try {
    var result = api_instance.sendMail(to, from, subject, body, body);
    print(result);
} catch (e) {
    print("Exception when calling SendingApi->sendMail: $e\n");
}
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

