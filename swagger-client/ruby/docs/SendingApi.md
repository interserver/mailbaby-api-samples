# SwaggerClient::SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email

# **send_adv_mail**
> GenericResponse send_adv_mail(subjectbodyfromtoreplytoccbccattachmentsid)

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

api_instance = SwaggerClient::SendingApi.new
subject = 'subject_example' # String | 
body = 'body_example' # String | 
from = SwaggerClient::EmailAddressName.new # EmailAddressName | 
to = [SwaggerClient::EmailAddressName.new] # Array<EmailAddressName> | 
replyto = [SwaggerClient::EmailAddressName.new] # Array<EmailAddressName> | 
cc = [SwaggerClient::EmailAddressName.new] # Array<EmailAddressName> | 
bcc = [SwaggerClient::EmailAddressName.new] # Array<EmailAddressName> | 
attachments = [SwaggerClient::MailAttachment.new] # Array<MailAttachment> | 
id = 789 # Integer | 


begin
  #Sends an Email with Advanced Options
  result = api_instance.send_adv_mail(subjectbodyfromtoreplytoccbccattachmentsid)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling SendingApi->send_adv_mail: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**|  | 
 **body** | **String**|  | 
 **from** | [**EmailAddressName**](.md)|  | 
 **to** | [**Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **replyto** | [**Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **cc** | [**Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **bcc** | [**Array&lt;EmailAddressName&gt;**](EmailAddressName.md)|  | 
 **attachments** | [**Array&lt;MailAttachment&gt;**](MailAttachment.md)|  | 
 **id** | **Integer**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

api_instance = SwaggerClient::SendingApi.new
body = SwaggerClient::SendMailAdv.new # SendMailAdv | 


begin
  #Sends an Email with Advanced Options
  result = api_instance.send_adv_mail(body)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling SendingApi->send_adv_mail: #{e}"
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

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json



# **send_mail**
> GenericResponse send_mail(tofromsubjectbody)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

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

api_instance = SwaggerClient::SendingApi.new
to = 'to_example' # String | 
from = 'from_example' # String | 
subject = 'subject_example' # String | 
body = 'body_example' # String | 


begin
  #Sends an Email
  result = api_instance.send_mail(tofromsubjectbody)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling SendingApi->send_mail: #{e}"
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

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json



# **send_mail**
> GenericResponse send_mail(body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

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

api_instance = SwaggerClient::SendingApi.new
body = SwaggerClient::SendMail.new # SendMail | 


begin
  #Sends an Email
  result = api_instance.send_mail(body)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling SendingApi->send_mail: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMail**](SendMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json



