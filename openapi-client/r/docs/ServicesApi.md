# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrderById**](ServicesApi.md#GetMailOrderById) | **GET** /mail/{id} | Get one mail order&#39;s full detail including SMTP password
[**GetMailOrders**](ServicesApi.md#GetMailOrders) | **GET** /mail | List your provisioned mail orders (sending accounts)


# **GetMailOrderById**
> MailOrderDetail GetMailOrderById(id)

Get one mail order's full detail including SMTP password

**Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 

### Example
```R
library(openapi)

# Get one mail order's full detail including SMTP password
#
# prepare function argument(s)
var_id <- 39 # integer | The numeric ID of the mail order.

api_instance <- ServicesApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$GetMailOrderById(var_iddata_file = "result.txt")
result <- api_instance$GetMailOrderById(var_id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer**| The numeric ID of the mail order. | 

### Return type

[**MailOrderDetail**](MailOrderDetail.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **400** | Bad request — one or more input parameters were missing or invalid. |  -  |
| **401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |
| **404** | The specified resource was not found or does not belong to your account. |  -  |

# **GetMailOrders**
> array[MailOrder] GetMailOrders()

List your provisioned mail orders (sending accounts)

Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 

### Example
```R
library(openapi)

# List your provisioned mail orders (sending accounts)
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
| **401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |

