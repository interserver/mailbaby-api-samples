# WWW::OpenAPIClient::StatusApi

## Load the API package
```perl
use WWW::OpenAPIClient::Object::StatusApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](StatusApi.md#ping_server) | **GET** /ping | Health check — verify the API is reachable


# **ping_server**
> string ping_server()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example
```perl
use Data::Dumper;
use WWW::OpenAPIClient::StatusApi;
my $api_instance = WWW::OpenAPIClient::StatusApi->new(
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

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

