# OpenAPIClient::DefaultApi

## Load the API package
```perl
use OpenAPIClient::Object::DefaultApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**view_mail_log**](DefaultApi.md#view_mail_log) | **GET** /mail/log | displays the mail log


# **get_mail_orders**
> ARRAY[GetMailOrders200ResponseInner] get_mail_orders()

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

[**ARRAY[GetMailOrders200ResponseInner]**](GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

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

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

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

# **view_mail_log**
> MailLog view_mail_log(id => $id, origin => $origin, mx => $mx, from => $from, to => $to, subject => $subject, mailid => $mailid, skip => $skip, limit => $limit, start_date => $start_date, end_date => $end_date)

displays the mail log

Get a listing of the emails sent through this system 

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

my $id = 2604; # int | The ID of your mail order this will be sent through.
my $origin = 1.2.3.4; # string | originating ip address sending mail
my $mx = mx.google.com; # string | mx record mail was sent to
my $from = me@sender.com; # string | from email address
my $to = you@receiver.com; # string | to/destination email address
my $subject = Support; # string | subject containing this string
my $mailid = 185997065c60008840; # string | mail id
my $skip = 1000; # int | number of records to skip for pagination
my $limit = 1000; # int | maximum number of records to return
my $start_date = 1641781008; # int | earliest date to get emails in unix timestamp format
my $end_date = 1673317008; # int | earliest date to get emails in unix timestamp format

eval {
    my $result = $api_instance->view_mail_log(id => $id, origin => $origin, mx => $mx, from => $from, to => $to, subject => $subject, mailid => $mailid, skip => $skip, limit => $limit, start_date => $start_date, end_date => $end_date);
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
 **origin** | **string**| originating ip address sending mail | [optional] 
 **mx** | **string**| mx record mail was sent to | [optional] 
 **from** | **string**| from email address | [optional] 
 **to** | **string**| to/destination email address | [optional] 
 **subject** | **string**| subject containing this string | [optional] 
 **mailid** | **string**| mail id | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **end_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

