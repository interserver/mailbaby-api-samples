# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetStats**](HistoryApi.md#GetStats) | **GET** /mail/stats | displays a list of blocked email addresses
[**ViewMailLog**](HistoryApi.md#ViewMailLog) | **GET** /mail/log | displays the mail log


# **GetStats**
> array[GetStats200ResponseInner] GetStats()

displays a list of blocked email addresses

### Example
```R
library(openapi)

# displays a list of blocked email addresses
#

api_instance <- HistoryApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$GetStats(data_file = "result.txt")
result <- api_instance$GetStats()
dput(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**array[GetStats200ResponseInner]**](getStats_200_response_inner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |

# **ViewMailLog**
> MailLog ViewMailLog(id = var.id, origin = var.origin, mx = var.mx, from = var.from, to = var.to, subject = var.subject, mailid = var.mailid, skip = 0, limit = 100, start_date = var.start_date, end_date = var.end_date)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```R
library(openapi)

# displays the mail log
#
# prepare function argument(s)
var_id <- 2604 # integer | The ID of your mail order this will be sent through. (Optional)
var_origin <- "1.2.3.4" # character | originating ip address sending mail (Optional)
var_mx <- "mx.google.com" # character | mx record mail was sent to (Optional)
var_from <- "me@sender.com" # character | from email address (Optional)
var_to <- "you@receiver.com" # character | to/destination email address (Optional)
var_subject <- "Support" # character | subject containing this string (Optional)
var_mailid <- "185997065c60008840" # character | mail id (Optional)
var_skip <- 0 # integer | number of records to skip for pagination (Optional)
var_limit <- 100 # integer | maximum number of records to return (Optional)
var_start_date <- 1641781008 # integer | earliest date to get emails in unix timestamp format (Optional)
var_end_date <- 1673317008 # integer | earliest date to get emails in unix timestamp format (Optional)

api_instance <- HistoryApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$ViewMailLog(id = var_id, origin = var_origin, mx = var_mx, from = var_from, to = var_to, subject = var_subject, mailid = var_mailid, skip = var_skip, limit = var_limit, start_date = var_start_date, end_date = var_end_datedata_file = "result.txt")
result <- api_instance$ViewMailLog(id = var_id, origin = var_origin, mx = var_mx, from = var_from, to = var_to, subject = var_subject, mailid = var_mailid, skip = var_skip, limit = var_limit, start_date = var_start_date, end_date = var_end_date)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **character**| originating ip address sending mail | [optional] 
 **mx** | **character**| mx record mail was sent to | [optional] 
 **from** | **character**| from email address | [optional] 
 **to** | **character**| to/destination email address | [optional] 
 **subject** | **character**| subject containing this string | [optional] 
 **mailid** | **character**| mail id | [optional] 
 **skip** | **integer**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **integer**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **integer**| earliest date to get emails in unix timestamp format | [optional] 
 **end_date** | **integer**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | bad input parameter |  -  |

