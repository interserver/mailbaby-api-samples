# OpenAPIClient::ServicesApi

## Load the API package
```perl
use OpenAPIClient::Object::ServicesApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](ServicesApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders


# **get_mail_orders**
> ARRAY[MailOrder] get_mail_orders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example
```perl
use Data::Dumper;
use OpenAPIClient::ServicesApi;
my $api_instance = OpenAPIClient::ServicesApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);


eval {
    my $result = $api_instance->get_mail_orders();
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling ServicesApi->get_mail_orders: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ARRAY[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

