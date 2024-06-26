# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics. |
| [**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


<a name="getStats"></a>
# **getStats**
> List getStats()

Account usage statistics.

    Returns information about the usage on your mail accounts.

### Parameters
This endpoint does not need any parameter.

### Return type

[**List**](../Models/getStats_200_response_inner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom)

displays the mail log

    Get a listing of the emails sent through this system 

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Long**| The ID of your mail order this will be sent through. | [optional] [default to null] |
| **origin** | **String**| originating ip address sending mail | [optional] [default to null] |
| **mx** | **String**| mx record mail was sent to | [optional] [default to null] |
| **from** | **String**| from email address | [optional] [default to null] |
| **to** | **String**| to/destination email address | [optional] [default to null] |
| **subject** | **String**| subject containing this string | [optional] [default to null] |
| **mailid** | **String**| mail id | [optional] [default to null] |
| **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0] |
| **limit** | **Integer**| maximum number of records to return | [optional] [default to 100] |
| **startDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [default to null] |
| **endDate** | **Long**| earliest date to get emails in unix timestamp format | [optional] [default to null] |
| **replyto** | **String**| Reply-To Email Address | [optional] [default to null] |
| **headerfrom** | **String**| Header From Email Address | [optional] [default to null] |

### Return type

[**MailLog**](../Models/MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

