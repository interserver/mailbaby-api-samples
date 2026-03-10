# StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running |


<a name="pingServer"></a>
# **pingServer**
> pingServer()

Checks if the server is running

    A lightweight health-check endpoint.  Returns a plain-text &#x60;200 OK&#x60; when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

