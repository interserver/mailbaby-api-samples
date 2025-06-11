# HistoryApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log



## getStats

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example

```bash
 getStats  time=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_time** | **string** | The timeframe for the statistics. | [optional] [default to null]

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## viewMailLog

displays the mail log

Get a listing of the emails sent through this system

### Example

```bash
 viewMailLog  id=value  origin=value  mx=value  from=value  to=value  subject=value  mailid=value  skip=value  limit=value  startDate=value  endDate=value  replyto=value  headerfrom=value  delivered=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | The ID of your mail order this will be sent through. | [optional] [default to null]
 **origin** | **string** | originating ip address sending mail | [optional] [default to null]
 **mx** | **string** | mx record mail was sent to | [optional] [default to null]
 **from** | **string** | from email address | [optional] [default to null]
 **to** | **string** | to/destination email address | [optional] [default to null]
 **subject** | **string** | subject containing this string | [optional] [default to null]
 **mailid** | **string** | mail id | [optional] [default to null]
 **skip** | **integer** | number of records to skip for pagination | [optional] [default to 0]
 **limit** | **integer** | maximum number of records to return | [optional] [default to 100]
 **startDate** | **integer** | earliest date to get emails in unix timestamp format | [optional] [default to null]
 **endDate** | **integer** | earliest date to get emails in unix timestamp format | [optional] [default to null]
 **replyto** | **string** | Reply-To Email Address | [optional] [default to null]
 **headerfrom** | **string** | Header From Email Address | [optional] [default to null]
 **delivered** | **string** | Limiting the emails to wether or not they were delivered. | [optional] [default to null]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

