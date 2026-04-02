# StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**PingServer**](StatusApi.md#PingServer) | **GET** /ping | Checks if the server is running


# **PingServer**
> character PingServer()

Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Example
```R
library(openapi)

# Checks if the server is running
#

api_instance <- StatusApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$PingServer(data_file = "result.txt")
result <- api_instance$PingServer()
dput(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

**character**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Server is up and running |  -  |
| **0** | Something is wrong |  -  |

