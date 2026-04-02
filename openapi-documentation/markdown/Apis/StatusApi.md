# StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running |


<a name="pingServer"></a>
# **pingServer**
> String pingServer()

Checks if the server is running

    A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain

