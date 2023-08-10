# SwaggerClient::BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Creates a new email deny rule.
[**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Creates a new email deny rule.
[**delete_rule**](BlockingApi.md#delete_rule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**get_mail_blocks**](BlockingApi.md#get_mail_blocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**get_rules**](BlockingApi.md#get_rules) | **GET** /mail/rules | Displays a listing of deny email rules.

# **add_rule**
> GenericResponse add_rule(usertypedata)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new
user = 'user_example' # String | 
type = 'type_example' # String | 
data = 'data_example' # String | 


begin
  #Creates a new email deny rule.
  result = api_instance.add_rule(usertypedata)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->add_rule: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | **String**|  | 
 **type** | **String**|  | 
 **data** | **String**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json



# **add_rule**
> GenericResponse add_rule(body)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new
body = SwaggerClient::DenyRuleNew.new # DenyRuleNew | These are the fields needed to create a new email deny rule.


begin
  #Creates a new email deny rule.
  result = api_instance.add_rule(body)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->add_rule: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DenyRuleNew**](DenyRuleNew.md)| These are the fields needed to create a new email deny rule. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json



# **delete_rule**
> GenericResponse delete_rule(rule_id)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new
rule_id = 56 # Integer | The ID of the Rules entry.


begin
  #Removes an deny mail rule.
  result = api_instance.delete_rule(rule_id)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->delete_rule: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rule_id** | **Integer**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



# **delist_block**
> GenericResponse delist_block(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new
body = SwaggerClient::EmailAddress.new # EmailAddress | 


begin
  #Removes an email address from the blocked list
  result = api_instance.delist_block(body)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->delist_block: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailAddress**](EmailAddress.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json



# **delist_block**
> GenericResponse delist_block(email)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new
email = 'email_example' # String | 


begin
  #Removes an email address from the blocked list
  result = api_instance.delist_block(email)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->delist_block: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json



# **get_mail_blocks**
> MailBlocks get_mail_blocks

displays a list of blocked email addresses

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new

begin
  #displays a list of blocked email addresses
  result = api_instance.get_mail_blocks
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->get_mail_blocks: #{e}"
end
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



# **get_rules**
> Array&lt;DenyRuleRecord&gt; get_rules

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```ruby
# load the gem
require 'swagger_client'
# setup authorization
SwaggerClient.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  #config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = SwaggerClient::BlockingApi.new

begin
  #Displays a listing of deny email rules.
  result = api_instance.get_rules
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling BlockingApi->get_rules: #{e}"
end
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Array&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



