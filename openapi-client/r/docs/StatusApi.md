# StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**PingServer**](StatusApi.md#PingServer) | **GET** /ping | Checks if the server is running


# **PingServer**
> PingServer()

Checks if the server is running

### Example
```R
library(openapi)

# Checks if the server is running
#

api_instance <- StatusApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
api_instance$PingServer()
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

