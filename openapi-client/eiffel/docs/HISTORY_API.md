# HISTORY_API

All URIs are relative to *https://api.mailbaby.net*

Feature | HTTP request | Description
------------- | ------------- | -------------
[**stats**](HISTORY_API.md#stats) | **Get** /mail/stats | Account usage statistics.
[**view_mail_log**](HISTORY_API.md#view_mail_log) | **Get** /mail/log | displays the mail log


# **stats**
> stats (time:  detachable STRING_32 ): detachable MAIL_STATS_TYPE


Account usage statistics.

Returns information about the usage on your mail accounts.


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **STRING_32**| The timeframe for the statistics. | [optional] [default to null]

### Return type

[**MAIL_STATS_TYPE**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> view_mail_log (id:  detachable INTEGER_64 ; origin:  detachable STRING_32 ; mx:  detachable STRING_32 ; var_from:  detachable STRING_32 ; to:  detachable STRING_32 ; subject:  detachable STRING_32 ; mailid:  detachable STRING_32 ; skip:  detachable INTEGER_32 ; limit:  detachable INTEGER_32 ; start_date:  detachable INTEGER_64 ; end_date:  detachable INTEGER_64 ; replyto:  detachable STRING_32 ; headerfrom:  detachable STRING_32 ; delivered:  detachable STRING_32 ): detachable MAIL_LOG


displays the mail log

Get a listing of the emails sent through this system 


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **INTEGER_64**| The ID of your mail order this will be sent through. | [optional] [default to null]
 **origin** | **STRING_32**| originating ip address sending mail | [optional] [default to null]
 **mx** | **STRING_32**| mx record mail was sent to | [optional] [default to null]
 **var_from** | **STRING_32**| from email address | [optional] [default to null]
 **to** | **STRING_32**| to/destination email address | [optional] [default to null]
 **subject** | **STRING_32**| subject containing this string | [optional] [default to null]
 **mailid** | **STRING_32**| mail id | [optional] [default to null]
 **skip** | **INTEGER_32**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **INTEGER_32**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **INTEGER_64**| earliest date to get emails in unix timestamp format | [optional] [default to null]
 **end_date** | **INTEGER_64**| earliest date to get emails in unix timestamp format | [optional] [default to null]
 **replyto** | **STRING_32**| Reply-To Email Address | [optional] [default to null]
 **headerfrom** | **STRING_32**| Header From Email Address | [optional] [default to null]
 **delivered** | **STRING_32**| Limiting the emails to wether or not they were delivered. | [optional] [default to null]

### Return type

[**MAIL_LOG**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

