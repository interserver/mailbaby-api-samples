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
> MailStatsType getStats(time)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api = Openapi().getHistoryApi();
final String time = time_example; // String | The timeframe for the statistics.

try {
    final response = api.getStats(time);
    print(response);
} catch on DioException (e) {
    print('Exception when calling HistoryApi->getStats: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **String**| The timeframe for the statistics. | [optional] 

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api = Openapi().getHistoryApi();
final int id = 2604; // int | The ID of your mail order this will be sent through.
final String origin = 1.2.3.4; // String | originating ip address sending mail
final String mx = mx.google.com; // String | mx record mail was sent to
final String from = me@sender.com; // String | from email address
final String to = you@receiver.com; // String | to/destination email address
final String subject = Support; // String | subject containing this string
final String mailid = 185997065c60008840; // String | mail id
final int skip = 1000; // int | number of records to skip for pagination
final int limit = 1000; // int | maximum number of records to return
final int startDate = 1641781008; // int | earliest date to get emails in unix timestamp format
final int endDate = 1673317008; // int | earliest date to get emails in unix timestamp format
final String replyto = replyto_example; // String | Reply-To Email Address
final String headerfrom = headerfrom_example; // String | Header From Email Address
final String delivered = delivered_example; // String | Limiting the emails to wether or not they were delivered.

try {
    final response = api.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered);
    print(response);
} catch on DioException (e) {
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
 **replyto** | **String**| Reply-To Email Address | [optional] 
 **headerfrom** | **String**| Header From Email Address | [optional] 
 **delivered** | **String**| Limiting the emails to wether or not they were delivered. | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

