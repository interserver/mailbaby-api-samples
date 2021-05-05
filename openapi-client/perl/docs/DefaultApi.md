# OpenAPIClient::DefaultApi

## Load the API package
```perl
use OpenAPIClient::Object::DefaultApi;
```

All URIs are relative to *http://mystage.interserver.net:8787*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**place_mail_order**](DefaultApi.md#place_mail_order) | **POST** /mail/order | places a mail order
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**validate_mail_order**](DefaultApi.md#validate_mail_order) | **GET** /mail/order | validatess order details before placing an order
[**view_mail_log**](DefaultApi.md#view_mail_log) | **GET** /mail/log | displays the mail log


# **get_mail_orders**
> ARRAY[MailOrder] get_mail_orders(id => $id)

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
);

my $id = 789; # int | The ID of your mail order this will be sent through.

eval { 
    my $result = $api_instance->get_mail_orders(id => $id);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->get_mail_orders: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 

### Return type

[**ARRAY[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_adv_mail**
> GenericResponse send_adv_mail(send_mail_adv => $send_mail_adv)

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
);

my $send_mail_adv = OpenAPIClient::Object::SendMailAdv->new(); # SendMailAdv | 

eval { 
    my $result = $api_instance->send_adv_mail(send_mail_adv => $send_mail_adv);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->send_adv_mail: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **send_mail_adv** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> GenericResponse send_mail(to => $to, from => $from, subject => $subject, body => $body)

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
);

my $to = "to_example"; # string | The Contact whom is the primary recipient of this email.
my $from = "from_example"; # string | The contact whom is the this email is from.
my $subject = "subject_example"; # string | The subject or title of the email
my $body = "body_example"; # string | The main email contents.

eval { 
    my $result = $api_instance->send_mail(to => $to, from => $from, subject => $subject, body => $body);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->send_mail: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**| The Contact whom is the primary recipient of this email. | 
 **from** | **string**| The contact whom is the this email is from. | 
 **subject** | **string**| The subject or title of the email | 
 **body** | **string**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> ARRAY[MailLog] view_mail_log(id => $id, search_string => $search_string, skip => $skip, limit => $limit)

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
);

my $id = 789; # int | The ID of your mail order this will be sent through.
my $search_string = "search_string_example"; # string | pass an optional search string for looking up inventory
my $skip = 56; # int | number of records to skip for pagination
my $limit = 56; # int | maximum number of records to return

eval { 
    my $result = $api_instance->view_mail_log(id => $id, search_string => $search_string, skip => $skip, limit => $limit);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling DefaultApi->view_mail_log: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 
 **search_string** | **string**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] 
 **limit** | **int**| maximum number of records to return | [optional] 

### Return type

[**ARRAY[MailLog]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

