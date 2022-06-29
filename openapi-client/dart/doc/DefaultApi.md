# openapi.api.DefaultApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultApi.md#viewmaillog) | **GET** /mail/log | displays the mail log


# **getMailOrders**
> List<GetMailOrders200ResponseInner> getMailOrders()

displays a list of mail service orders

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();

try {
    final result = api_instance.getMailOrders();
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->getMailOrders: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<GetMailOrders200ResponseInner>**](GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pingServer**
> pingServer()

Checks if the server is running

### Example
```dart
import 'package:openapi/api.dart';

final api_instance = DefaultApi();

try {
    api_instance.pingServer();
} catch (e) {
    print('Exception when calling DefaultApi->pingServer: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendAdvMail**
> GenericResponse sendAdvMail(sendMailAdv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final sendMailAdv = SendMailAdv(); // SendMailAdv | 

try {
    final result = api_instance.sendAdvMail(sendMailAdv);
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->sendAdvMail: $e\n');
}
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final to = to_example; // String | The Contact whom is the primary recipient of this email.
final from = from_example; // String | The contact whom is the this email is from.
final subject = subject_example; // String | The subject or title of the email
final body = body_example; // String | The main email contents.

try {
    final result = api_instance.sendMail(to, from, subject, body);
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->sendMail: $e\n');
}
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
> MailLog viewMailLog(id, search, skip, limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = DefaultApi();
final id = 789; // int | The ID of your mail order this will be sent through.
final search = search_example; // String | pass an optional search string for looking up inventory
final skip = 56; // int | number of records to skip for pagination
final limit = 56; // int | maximum number of records to return

try {
    final result = api_instance.viewMailLog(id, search, skip, limit);
    print(result);
} catch (e) {
    print('Exception when calling DefaultApi->viewMailLog: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 
 **search** | **String**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

