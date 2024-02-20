# HistoryAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**HistoryAPI_getStats**](HistoryAPI.md#HistoryAPI_getStats) | **GET** /mail/stats | Account usage statistics.
[**HistoryAPI_viewMailLog**](HistoryAPI.md#HistoryAPI_viewMailLog) | **GET** /mail/log | displays the mail log


# **HistoryAPI_getStats**
```c
// Account usage statistics.
//
// Returns information about the usage on your mail accounts.
//
list_t* HistoryAPI_getStats(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

[list_t](get_stats_200_response_inner.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **HistoryAPI_viewMailLog**
```c
// displays the mail log
//
// Get a listing of the emails sent through this system 
//
mail_log_t* HistoryAPI_viewMailLog(apiClient_t *apiClient, long id, char * origin, char * mx, char * from, char * to, char * subject, char * mailid, int skip, int limit, long startDate, long endDate);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**id** | **long** | The ID of your mail order this will be sent through. | [optional] 
**origin** | **char \*** | originating ip address sending mail | [optional] 
**mx** | **char \*** | mx record mail was sent to | [optional] 
**from** | **char \*** | from email address | [optional] 
**to** | **char \*** | to/destination email address | [optional] 
**subject** | **char \*** | subject containing this string | [optional] 
**mailid** | **char \*** | mail id | [optional] 
**skip** | **int** | number of records to skip for pagination | [optional] [default to 0]
**limit** | **int** | maximum number of records to return | [optional] [default to 100]
**startDate** | **long** | earliest date to get emails in unix timestamp format | [optional] 
**endDate** | **long** | earliest date to get emails in unix timestamp format | [optional] 

### Return type

[mail_log_t](mail_log.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

