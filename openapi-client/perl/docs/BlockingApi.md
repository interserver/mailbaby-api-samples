# OpenAPIClient::BlockingApi

## Load the API package
```perl
use OpenAPIClient::Object::BlockingApi;
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Creates a new email deny rule.
[**delete_rule**](BlockingApi.md#delete_rule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**get_mail_blocks**](BlockingApi.md#get_mail_blocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**get_rules**](BlockingApi.md#get_rules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **add_rule**
> GenericResponse add_rule(type => $type, data => $data, user => $user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```perl
use Data::Dumper;
use OpenAPIClient::BlockingApi;
my $api_instance = OpenAPIClient::BlockingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $type = "type_example"; # string | The type of deny rule.
my $data = "data_example"; # string | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
my $user = "user_example"; # string | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.

eval {
    my $result = $api_instance->add_rule(type => $type, data => $data, user => $user);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling BlockingApi->add_rule: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **string**| The type of deny rule. | 
 **data** | **string**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **user** | **string**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_rule**
> GenericResponse delete_rule(rule_id => $rule_id)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```perl
use Data::Dumper;
use OpenAPIClient::BlockingApi;
my $api_instance = OpenAPIClient::BlockingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $rule_id = 34; # int | The ID of the Rules entry.

eval {
    my $result = $api_instance->delete_rule(rule_id => $rule_id);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling BlockingApi->delete_rule: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rule_id** | **int**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delist_block**
> GenericResponse delist_block(email_address => $email_address)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```perl
use Data::Dumper;
use OpenAPIClient::BlockingApi;
my $api_instance = OpenAPIClient::BlockingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);

my $email_address = OpenAPIClient::Object::EmailAddress->new(); # EmailAddress | 

eval {
    my $result = $api_instance->delist_block(email_address => $email_address);
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling BlockingApi->delist_block: $@\n";
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email_address** | [**EmailAddress**](EmailAddress.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_mail_blocks**
> MailBlocks get_mail_blocks()

displays a list of blocked email addresses

### Example
```perl
use Data::Dumper;
use OpenAPIClient::BlockingApi;
my $api_instance = OpenAPIClient::BlockingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);


eval {
    my $result = $api_instance->get_mail_blocks();
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling BlockingApi->get_mail_blocks: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_rules**
> ARRAY[DenyRuleRecord] get_rules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```perl
use Data::Dumper;
use OpenAPIClient::BlockingApi;
my $api_instance = OpenAPIClient::BlockingApi->new(

    # Configure API key authorization: apiKeyAuth
    api_key => {'X-API-KEY' => 'YOUR_API_KEY'},
    # uncomment below to setup prefix (e.g. Bearer) for API key, if needed
    #api_key_prefix => {'X-API-KEY' => 'Bearer'},
);


eval {
    my $result = $api_instance->get_rules();
    print Dumper($result);
};
if ($@) {
    warn "Exception when calling BlockingApi->get_rules: $@\n";
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ARRAY[DenyRuleRecord]**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

