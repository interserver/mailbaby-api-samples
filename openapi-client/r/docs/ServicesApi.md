# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](ServicesApi.md#GetMailOrders) | **GET** /mail | displays a list of mail service orders


# **GetMailOrders**
> array[MailOrder] GetMailOrders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example
```R
library(openapi)

# displays a list of mail service orders
#

api_instance <- ServicesApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$GetMailOrders(data_file = "result.txt")
result <- api_instance$GetMailOrders()
dput(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**array[MailOrder]**](MailOrder.md)

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

