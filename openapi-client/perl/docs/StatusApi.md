# OpenAPIClient::StatusApi

## Load the API package
```perl
use OpenAPIClient::Object::StatusApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](StatusApi.md#ping_server) | **GET** /ping | Checks if the server is running


# **ping_server**
> string ping_server()

Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string `Server is up and running` with a `200` status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Example
```perl
use Data::Dumper;
use OpenAPIClient::StatusApi;
my $api_instance = OpenAPIClient::StatusApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);


eval {
    my $result = $api_instance->ping_server();
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling StatusApi->ping_server: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**string**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

