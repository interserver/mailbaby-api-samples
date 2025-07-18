# \HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | Account usage statistics.
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | displays the mail log



## get_stats

> models::MailStatsType get_stats(time)
Account usage statistics.

Returns information about the usage on your mail accounts.

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**time** | Option<**String**> | The timeframe for the statistics. |  |

### Return type

[**models::MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## view_mail_log

> models::MailLog view_mail_log(id, origin, mx, from, to, subject, mailid, skip, limit, start_date, end_date, replyto, headerfrom, delivered)
displays the mail log

Get a listing of the emails sent through this system 

### Parameters


Name | Type | Description  | Required | Notes
------------- | ------------- | ------------- | ------------- | -------------
**id** | Option<**i64**> | The ID of your mail order this will be sent through. |  |
**origin** | Option<**String**> | originating ip address sending mail |  |
**mx** | Option<**String**> | mx record mail was sent to |  |
**from** | Option<**String**> | from email address |  |
**to** | Option<**String**> | to/destination email address |  |
**subject** | Option<**String**> | subject containing this string |  |
**mailid** | Option<**String**> | mail id |  |
**skip** | Option<**i32**> | number of records to skip for pagination |  |[default to 0]
**limit** | Option<**i32**> | maximum number of records to return |  |[default to 100]
**start_date** | Option<**i64**> | earliest date to get emails in unix timestamp format |  |
**end_date** | Option<**i64**> | earliest date to get emails in unix timestamp format |  |
**replyto** | Option<**String**> | Reply-To Email Address |  |
**headerfrom** | Option<**String**> | Header From Email Address |  |
**delivered** | Option<**String**> | Limiting the emails to wether or not they were delivered. |  |

### Return type

[**models::MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

