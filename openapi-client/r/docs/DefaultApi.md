# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#GetMailOrders) | **GET** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#PingServer) | **GET** /ping | Checks if the server is running
[**SendAdvMail**](DefaultApi.md#SendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](DefaultApi.md#SendMail) | **POST** /mail/send | Sends an Email
[**ViewMailLog**](DefaultApi.md#ViewMailLog) | **GET** /mail/log | displays the mail log


# **GetMailOrders**
> array[GetMailOrders200ResponseInner] GetMailOrders()

displays a list of mail service orders

### Example
```R
library(openapi)


#displays a list of mail service orders
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$GetMailOrders()
dput(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**array[GetMailOrders200ResponseInner]**](getMailOrders_200_response_inner.md)

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

# **PingServer**
> PingServer()

Checks if the server is running

### Example
```R
library(openapi)


#Checks if the server is running
api.instance <- DefaultApi$new()
api.instance$PingServer()
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

# **SendAdvMail**
> GenericResponse SendAdvMail(send_mail_adv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```R
library(openapi)

var.send_mail_adv <- SendMailAdv$new("subject_example", "body_example", SendMailAdv_from$new("email_example", "name_example"), list(SendMailAdv_to_inner$new("email_example", "name_example")), list(SendMailAdv_replyto_inner$new("email_example", "name_example")), list(SendMailAdv_cc_inner$new("email_example", "name_example")), list(SendMailAdv_bcc_inner$new("email_example", "name_example")), list(SendMailAdv_attachments_inner$new(123, "filename_example")), 123) # SendMailAdv | 

#Sends an Email with Advanced Options
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$SendAdvMail(var.send_mail_adv)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send_mail_adv** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **SendMail**
> GenericResponse SendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```R
library(openapi)

var.to <- 'to_example' # character | The Contact whom is the primary recipient of this email.
var.from <- 'from_example' # character | The contact whom is the this email is from.
var.subject <- 'subject_example' # character | The subject or title of the email
var.body <- 'body_example' # character | The main email contents.

#Sends an Email
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$SendMail(var.to, var.from, var.subject, var.body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **character**| The Contact whom is the primary recipient of this email. | 
 **from** | **character**| The contact whom is the this email is from. | 
 **subject** | **character**| The subject or title of the email | 
 **body** | **character**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **ViewMailLog**
> MailLog ViewMailLog(id=var.id, search=var.search, skip=0, limit=100)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```R
library(openapi)

var.id <- 56 # integer | The ID of your mail order this will be sent through.
var.search <- 'search_example' # character | pass an optional search string for looking up inventory
var.skip <- 0 # integer | number of records to skip for pagination
var.limit <- 100 # integer | maximum number of records to return

#displays the mail log
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$ViewMailLog(id=var.id, search=var.search, skip=var.skip, limit=var.limit)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer**| The ID of your mail order this will be sent through. | [optional] 
 **search** | **character**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **integer**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **integer**| maximum number of records to return | [optional] [default to 100]

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

