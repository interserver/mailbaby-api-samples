# openapi.api.HistoryApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getstats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log


# **getStats**
> List<GetStats200ResponseInner> getStats()

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = HistoryApi();

try {
    final result = api_instance.getStats();
    print(result);
} catch (e) {
    print('Exception when calling HistoryApi->getStats: $e\n');
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<GetStats200ResponseInner>**](GetStats200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = HistoryApi();
final id = 2604; // int | The ID of your mail order this will be sent through.
final origin = 1.2.3.4; // String | originating ip address sending mail
final mx = mx.google.com; // String | mx record mail was sent to
final from = me@sender.com; // String | from email address
final to = you@receiver.com; // String | to/destination email address
final subject = Support; // String | subject containing this string
final mailid = 185997065c60008840; // String | mail id
final skip = 1000; // int | number of records to skip for pagination
final limit = 1000; // int | maximum number of records to return
final startDate = 1641781008; // int | earliest date to get emails in unix timestamp format
final endDate = 1673317008; // int | earliest date to get emails in unix timestamp format

try {
    final result = api_instance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate);
    print(result);
} catch (e) {
    print('Exception when calling HistoryApi->viewMailLog: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **String**| originating ip address sending mail | [optional] 
 **mx** | **String**| mx record mail was sent to | [optional] 
 **from** | **String**| from email address | [optional] 
 **to** | **String**| to/destination email address | [optional] 
 **subject** | **String**| subject containing this string | [optional] 
 **mailid** | **String**| mail id | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]
 **startDate** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **endDate** | **int**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

