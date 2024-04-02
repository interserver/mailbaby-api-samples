# swagger.api.HistoryApi

## Load the API package
```dart
import 'package:swagger/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log

# **getStats**
> List<InlineResponse200> getStats()

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```dart
import 'package:swagger/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//swagger.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//swagger.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";

var api_instance = new HistoryApi();

try {
    var result = api_instance.getStats();
    print(result);
} catch (e) {
    print("Exception when calling HistoryApi->getStats: $e\n");
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List<InlineResponse200>**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```dart
import 'package:swagger/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//swagger.api.Configuration.apiKey{'X-API-KEY'} = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//swagger.api.Configuration.apiKeyPrefix{'X-API-KEY'} = "Bearer";

var api_instance = new HistoryApi();
var id = 789; // int | The ID of your mail order this will be sent through.
var origin = origin_example; // String | originating ip address sending mail
var mx = mx_example; // String | mx record mail was sent to
var from = from_example; // String | from email address
var to = to_example; // String | to/destination email address
var subject = subject_example; // String | subject containing this string
var mailid = mailid_example; // String | mail id
var skip = 56; // int | number of records to skip for pagination
var limit = 56; // int | maximum number of records to return
var startDate = 789; // int | earliest date to get emails in unix timestamp format
var endDate = 789; // int | earliest date to get emails in unix timestamp format
var replyto = replyto_example; // String | Reply-To Email Address
var headerfrom = headerfrom_example; // String | Header From Email Address

try {
    var result = api_instance.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom);
    print(result);
} catch (e) {
    print("Exception when calling HistoryApi->viewMailLog: $e\n");
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

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

