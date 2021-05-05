# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#GetMailOrders) | **GET** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#PingServer) | **GET** /ping | Checks if the server is running
[**PlaceMailOrder**](DefaultApi.md#PlaceMailOrder) | **POST** /mail/order | places a mail order
[**SendAdvMail**](DefaultApi.md#SendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](DefaultApi.md#SendMail) | **POST** /mail/send | Sends an Email
[**ValidateMailOrder**](DefaultApi.md#ValidateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**ViewMailLogById**](DefaultApi.md#ViewMailLogById) | **GET** /mail/log | displays the mail log


# **GetMailOrders**
> array[MailOrder] GetMailOrders(id=var.id)

displays a list of mail service orders

### Example
```R
library(openapi)

var.id <- 56 # integer | The ID of your mail order this will be sent through.

#displays a list of mail service orders
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$GetMailOrders(id=var.id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer**| The ID of your mail order this will be sent through. | [optional] 

### Return type

[**array[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |

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

# **PlaceMailOrder**
> PlaceMailOrder(mail.order=var.mail.order)

places a mail order

Adds an item to the system

### Example
```R
library(openapi)

var.mail.order <- MailOrder$new(123, "status_example", "username_example", "password_example", "comment_example") # MailOrder | Inventory item to add

#places a mail order
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
api.instance$PlaceMailOrder(mail.order=var.mail.order)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mail.order** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional] 

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | list of mail orders |  -  |
| **400** | invalid input, object invalid |  -  |
| **409** | an existing item already exists |  -  |
| **401** | Unauthorized |  -  |

# **SendAdvMail**
> GenericResponse SendAdvMail(send.mail.adv)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```R
library(openapi)

var.send.mail.adv <- SendMailAdv$new("subject_example", "body_example", list(SendMailAdv_from$new("email_example", "name_example")), list(MailContact$new("email_example", "name_example")), 123, list(MailContact$new("email_example", "name_example")), list(MailContact$new("email_example", "name_example")), list(MailContact$new("email_example", "name_example")), list(MailAttachment$new(123, "filename_example"))) # SendMailAdv | 

#Sends an Email with Advanced Options
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$SendAdvMail(var.send.mail.adv)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send.mail.adv** | [**SendMailAdv**](SendMailAdv.md)|  | 

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
| **400** | bad input parameter |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **SendMail**
> GenericResponse SendMail(send.mail)

Sends an Email

Sends An email through one of your mail orders.

### Example
```R
library(openapi)

var.send.mail <- SendMail$new("to_example", "from_example", "subject_example", "body_example") # SendMail | 

#Sends an Email
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$SendMail(var.send.mail)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send.mail** | [**SendMail**](SendMail.md)|  | 

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
| **400** | bad input parameter |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **ValidateMailOrder**
> ValidateMailOrder()

validatess order details before placing an order

### Example
```R
library(openapi)


#validatess order details before placing an order
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
api.instance$ValidateMailOrder()
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | list of mail orders |  -  |
| **401** | Unauthorized |  -  |

# **ViewMailLogById**
> array[MailLog] ViewMailLogById(id=var.id, search.string=var.search.string, skip=var.skip, limit=var.limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```R
library(openapi)

var.id <- 56 # integer | The ID of your mail order this will be sent through.
var.search.string <- 'search.string_example' # character | pass an optional search string for looking up inventory
var.skip <- 56 # integer | number of records to skip for pagination
var.limit <- 56 # integer | maximum number of records to return

#displays the mail log
api.instance <- DefaultApi$new()
# Configure API key authorization: apiKeyAuth
api.instance$apiClient$apiKeys['X-API-KEY'] <- 'TODO_YOUR_API_KEY';
result <- api.instance$ViewMailLogById(id=var.id, search.string=var.search.string, skip=var.skip, limit=var.limit)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer**| The ID of your mail order this will be sent through. | [optional] 
 **search.string** | **character**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **integer**| number of records to skip for pagination | [optional] 
 **limit** | **integer**| maximum number of records to return | [optional] 

### Return type

[**array[MailLog]**](MailLog.md)

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

