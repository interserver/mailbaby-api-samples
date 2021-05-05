# SwaggerClient::DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**place_mail_order**](DefaultApi.md#place_mail_order) | **POST** /mail/order | places a mail order
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**validate_mail_order**](DefaultApi.md#validate_mail_order) | **GET** /mail/order | validatess order details before placing an order
[**view_mail_log_by_id**](DefaultApi.md#view_mail_log_by_id) | **GET** /mail/log | displays the mail log

# **get_mail_orders**
> MailOrders get_mail_orders(opts)

displays a list of mail service orders

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

api_instance = SwaggerClient::DefaultApi.new
opts = { 
  id: 789 # Integer | The ID of your mail order this will be sent through.
}

begin
  #displays a list of mail service orders
  result = api_instance.get_mail_orders(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->get_mail_orders: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The ID of your mail order this will be sent through. | [optional] 

### Return type

[**MailOrders**](MailOrders.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain



# **ping_server**
> ping_server

Checks if the server is running

### Example
```ruby
# load the gem
require 'swagger_client'

api_instance = SwaggerClient::DefaultApi.new

begin
  #Checks if the server is running
  api_instance.ping_server
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->ping_server: #{e}"
end
```

### Parameters
This endpoint does not need any parameter.

### Return type

nil (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined



# **place_mail_order**
> place_mail_order(opts)

places a mail order

Adds an item to the system

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

api_instance = SwaggerClient::DefaultApi.new
opts = { 
  body: SwaggerClient::MailOrder.new # MailOrder | Inventory item to add
}

begin
  #places a mail order
  api_instance.place_mail_order(opts)
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->place_mail_order: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional] 

### Return type

nil (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json



# **send_adv_mail**
> GenericResponse send_adv_mail(body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

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

api_instance = SwaggerClient::DefaultApi.new
body = SwaggerClient::SendMailAdv.new # SendMailAdv | 


begin
  #Sends an Email with Advanced Options
  result = api_instance.send_adv_mail(body)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->send_adv_mail: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json



# **send_adv_mail**
> GenericResponse send_adv_mail(subjectbodyfromtoidreplytoccbccattachments)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

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

api_instance = SwaggerClient::DefaultApi.new
subject = 'subject_example' # String | 
body = 'body_example' # String | 
from = [SwaggerClient::SendMailAdvFrom.new] # Array<SendMailAdvFrom> | 
to = [SwaggerClient::MailContact.new] # Array<MailContact> | 
id = 789 # Integer | 
replyto = [SwaggerClient::MailContact.new] # Array<MailContact> | 
cc = [SwaggerClient::MailContact.new] # Array<MailContact> | 
bcc = [SwaggerClient::MailContact.new] # Array<MailContact> | 
attachments = [SwaggerClient::MailAttachment.new] # Array<MailAttachment> | 


begin
  #Sends an Email with Advanced Options
  result = api_instance.send_adv_mail(subjectbodyfromtoidreplytoccbccattachments)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->send_adv_mail: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**|  | 
 **body** | **String**|  | 
 **from** | [**Array&lt;SendMailAdvFrom&gt;**](SendMailAdvFrom.md)|  | 
 **to** | [**Array&lt;MailContact&gt;**](MailContact.md)|  | 
 **id** | **Integer**|  | 
 **replyto** | [**Array&lt;MailContact&gt;**](MailContact.md)|  | 
 **cc** | [**Array&lt;MailContact&gt;**](MailContact.md)|  | 
 **bcc** | [**Array&lt;MailContact&gt;**](MailContact.md)|  | 
 **attachments** | [**Array&lt;MailAttachment&gt;**](MailAttachment.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json



# **send_mail**
> GenericResponse send_mail(body)

Sends an Email

Sends An email through one of your mail orders.

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

api_instance = SwaggerClient::DefaultApi.new
body = SwaggerClient::Body.new # Body | 


begin
  #Sends an Email
  result = api_instance.send_mail(body)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->send_mail: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Body**](Body.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json



# **send_mail**
> GenericResponse send_mail(tofromsubjectbody)

Sends an Email

Sends An email through one of your mail orders.

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

api_instance = SwaggerClient::DefaultApi.new
to = 'to_example' # String | 
from = 'from_example' # String | 
subject = 'subject_example' # String | 
body = 'body_example' # String | 


begin
  #Sends an Email
  result = api_instance.send_mail(tofromsubjectbody)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->send_mail: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **String**|  | 
 **from** | **String**|  | 
 **subject** | **String**|  | 
 **body** | **String**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json



# **validate_mail_order**
> validate_mail_order

validatess order details before placing an order

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

api_instance = SwaggerClient::DefaultApi.new

begin
  #validatess order details before placing an order
  api_instance.validate_mail_order
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->validate_mail_order: #{e}"
end
```

### Parameters
This endpoint does not need any parameter.

### Return type

nil (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



# **view_mail_log_by_id**
> Array&lt;MailLog&gt; view_mail_log_by_id(opts)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

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

api_instance = SwaggerClient::DefaultApi.new
opts = { 
  id: 789, # Integer | The ID of your mail order this will be sent through.
  search_string: 'search_string_example', # String | pass an optional search string for looking up inventory
  skip: 56, # Integer | number of records to skip for pagination
  limit: 56 # Integer | maximum number of records to return
}

begin
  #displays the mail log
  result = api_instance.view_mail_log_by_id(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->view_mail_log_by_id: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The ID of your mail order this will be sent through. | [optional] 
 **search_string** | **String**| pass an optional search string for looking up inventory | [optional] 
 **skip** | **Integer**| number of records to skip for pagination | [optional] 
 **limit** | **Integer**| maximum number of records to return | [optional] 

### Return type

[**Array&lt;MailLog&gt;**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



