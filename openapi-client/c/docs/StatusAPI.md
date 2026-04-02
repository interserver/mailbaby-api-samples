# StatusAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**StatusAPI_pingServer**](StatusAPI.md#StatusAPI_pingServer) | **GET** /ping | Checks if the server is running


# **StatusAPI_pingServer**
```c
// Checks if the server is running
//
// A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 
//
char* StatusAPI_pingServer(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

char*



### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

