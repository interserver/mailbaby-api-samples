# OpenAPIClient::DefaultApi

## Load the API package
```perl
use OpenAPIClient::Object::DefaultApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_by_id**](DefaultApi.md#get_mail_by_id) | **GET** /mail/{id} | Gets mail order information by id
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**place_mail_order**](DefaultApi.md#place_mail_order) | **POST** /mail/order | places a mail order
[**send_adv_mail_by_id**](DefaultApi.md#send_adv_mail_by_id) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
[**send_mail_by_id**](DefaultApi.md#send_mail_by_id) | **POST** /mail/{id}/send | Sends an Email
[**validate_mail_order**](DefaultApi.md#validate_mail_order) | **GET** /mail/order | validatess order details before placing an order
[**view_mail_log_by_id**](DefaultApi.md#view_mail_log_by_id) | **GET** /mail/{id}/log | displays the mail log


# **get_mail_by_id**
> MailOrder get_mail_by_id(id => $id)

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);

my $id = 789; # int | User ID

eval { 
    my $result = $api_instance->get_mail_by_id(id => $id);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->get_mail_by_id: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 

### Return type

[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_mail_orders**
> ARRAY[MailOrder] get_mail_orders()

displays a list of mail service orders

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);


eval { 
    my $result = $api_instance->get_mail_orders();
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->get_mail_orders: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ARRAY[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ping_server**
> ping_server()

Checks if the server is running

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(
);


eval { 
    $api_instance->ping_server();
};
if ($@) {
    warn "Exception when calling DefaultApi->ping_server: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **place_mail_order**
> place_mail_order(mail_order => $mail_order)

places a mail order

Adds an item to the system

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);

my $mail_order = OpenAPIClient::Object::MailOrder->new(); # MailOrder | Inventory item to add

eval { 
    $api_instance->place_mail_order(mail_order => $mail_order);
};
if ($@) {
    warn "Exception when calling DefaultApi->place_mail_order: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mail_order** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional] 

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail_by_id**
> GenericResponse send_adv_mail_by_id(id => $id, send_mail => $send_mail)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);

my $id = 789; # int | User ID
my $send_mail = OpenAPIClient::Object::SendMail->new(); # SendMail | 

eval { 
    my $result = $api_instance->send_adv_mail_by_id(id => $id, send_mail => $send_mail);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->send_adv_mail_by_id: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 
 **send_mail** | [**SendMail**](SendMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail_by_id**
> GenericResponse send_mail_by_id(id => $id, subject => $subject, body => $body, to => $to, to_name => $to_name, from => $from, from_name => $from_name)

Sends an Email

Sends An email through one of your mail orders.

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);

my $id = 789; # int | User ID
my $subject = "subject_example"; # string | 
my $body = "body_example"; # string | 
my $to = "to_example"; # string | 
my $to_name = "to_name_example"; # string | 
my $from = "from_example"; # string | 
my $from_name = "from_name_example"; # string | 

eval { 
    my $result = $api_instance->send_mail_by_id(id => $id, subject => $subject, body => $body, to => $to, to_name => $to_name, from => $from, from_name => $from_name);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->send_mail_by_id: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 
 **subject** | **string**|  | [optional] 
 **body** | **string**|  | [optional] 
 **to** | **string**|  | [optional] 
 **to_name** | **string**|  | [optional] 
 **from** | **string**|  | [optional] 
 **from_name** | **string**|  | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_mail_order**
> validate_mail_order()

validatess order details before placing an order

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);


eval { 
    $api_instance->validate_mail_order();
};
if ($@) {
    warn "Exception when calling DefaultApi->validate_mail_order: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log_by_id**
> ARRAY[MailLog] view_mail_log_by_id(id => $id, search_string => $search_string, skip => $skip, limit => $limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example 
```perl
use Data::Dumper;
use OpenAPIClient::DefaultApi;
my $api_instance = OpenAPIClient::DefaultApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
    # Configure API key authorization: apiLoginAuth
    api_key => {'X-API-LOGIN' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-LOGIN' => 'Bearer'},
    # Configure API key authorization: apiPasswordAuth
    api_key => {'X-API-PASS' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-PASS' => 'Bearer'},
);

my $id = 789; # int | User ID
my $search_string = "search_string_example"; # string | pass an optional search string for looking up inventory
my $skip = 56; # int | number of records to skip for pagination
my $limit = 56; # int | maximum number of records to return

eval { 
    my $result = $api_instance->view_mail_log_by_id(id => $id, search_string => $search_string, skip => $skip, limit => $limit);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->view_mail_log_by_id: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID | 
 **search_string** | **string**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] 
 **limit** | **int**| maximum number of records to return | [optional] 

### Return type

[**ARRAY[MailLog]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

