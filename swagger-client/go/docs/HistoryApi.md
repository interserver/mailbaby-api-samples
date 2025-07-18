# {{classname}}

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetStats**](HistoryApi.md#GetStats) | **Get** /mail/stats | Account usage statistics.
[**ViewMailLog**](HistoryApi.md#ViewMailLog) | **Get** /mail/log | displays the mail log

# **GetStats**
> MailStatsType GetStats(ctx, optional)
Account usage statistics.

Returns information about the usage on your mail accounts.

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***HistoryApiGetStatsOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a HistoryApiGetStatsOpts struct
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **optional.String**| The timeframe for the statistics. | 

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ViewMailLog**
> MailLog ViewMailLog(ctx, optional)
displays the mail log

Get a listing of the emails sent through this system 

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
 **optional** | ***HistoryApiViewMailLogOpts** | optional parameters | nil if no parameters

### Optional Parameters
Optional parameters are passed through a pointer to a HistoryApiViewMailLogOpts struct
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **optional.Int64**| The ID of your mail order this will be sent through. | 
 **origin** | **optional.String**| originating ip address sending mail | 
 **mx** | **optional.String**| mx record mail was sent to | 
 **from** | **optional.String**| from email address | 
 **to** | **optional.String**| to/destination email address | 
 **subject** | **optional.String**| subject containing this string | 
 **mailid** | **optional.String**| mail id | 
 **skip** | **optional.Int32**| number of records to skip for pagination | [default to 0]
 **limit** | **optional.Int32**| maximum number of records to return | [default to 100]
 **startDate** | **optional.Int64**| earliest date to get emails in unix timestamp format | 
 **endDate** | **optional.Int64**| earliest date to get emails in unix timestamp format | 
 **replyto** | **optional.String**| Reply-To Email Address | 
 **headerfrom** | **optional.String**| Header From Email Address | 
 **delivered** | **optional.String**| Limiting the emails to wether or not they were delivered. | 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

