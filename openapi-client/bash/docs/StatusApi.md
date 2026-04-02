# StatusApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running



## pingServer

Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string 'Server is up and running' with a '200' status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests.

### Example

```bash
 pingServer
```

### Parameters

This endpoint does not need any parameter.

### Return type

**string**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

