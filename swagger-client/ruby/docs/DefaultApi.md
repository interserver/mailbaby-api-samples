# SwaggerClient::DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_adv_mail**](DefaultApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**send_mail**](DefaultApi.md#send_mail) | **POST** /mail/send | Sends an Email
[**view_mail_log**](DefaultApi.md#view_mail_log) | **GET** /mail/log | displays the mail log

# **get_mail_orders**
> Array&lt;InlineResponse200&gt; get_mail_orders

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

begin
  #displays a list of mail service orders
  result = api_instance.get_mail_orders
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->get_mail_orders: #{e}"
end
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Array&lt;InlineResponse200&gt;**](InlineResponse200.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



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

api_instance = SwaggerClient::DefaultApi.new
subject = 'subject_example' # String | 
body = 'body_example' # String | 
from = SwaggerClient::SendMailAdvFrom.new # SendMailAdvFrom | 
to = [SwaggerClient::SendMailAdvTo.new] # Array<SendMailAdvTo> | 
replyto = [SwaggerClient::SendMailAdvReplyto.new] # Array<SendMailAdvReplyto> | 
cc = [SwaggerClient::SendMailAdvCc.new] # Array<SendMailAdvCc> | 
bcc = [SwaggerClient::SendMailAdvBcc.new] # Array<SendMailAdvBcc> | 
attachments = [SwaggerClient::SendMailAdvAttachments.new] # Array<SendMailAdvAttachments> | 
id = 789 # Integer | 


begin
  #Sends an Email with Advanced Options
  result = api_instance.send_adv_mail(subjectbodyfromtoreplytoccbccattachmentsid)
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
 **from** | [**SendMailAdvFrom**](.md)|  | 
 **to** | [**Array&lt;SendMailAdvTo&gt;**](SendMailAdvTo.md)|  | 
 **replyto** | [**Array&lt;SendMailAdvReplyto&gt;**](SendMailAdvReplyto.md)|  | 
 **cc** | [**Array&lt;SendMailAdvCc&gt;**](SendMailAdvCc.md)|  | 
 **bcc** | [**Array&lt;SendMailAdvBcc&gt;**](SendMailAdvBcc.md)|  | 
 **attachments** | [**Array&lt;SendMailAdvAttachments&gt;**](SendMailAdvAttachments.md)|  | 
 **id** | **Integer**|  | 

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

api_instance = SwaggerClient::DefaultApi.new
body = SwaggerClient::SendMail.new # SendMail | 


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
 **body** | [**SendMail**](SendMail.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json



# **view_mail_log**
> MailLog view_mail_log(opts)

displays the mail log

Get a listing of the emails sent through this system 

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
  origin: 'origin_example', # String | originating ip address sending mail
  mx: 'mx_example', # String | mx record mail was sent to
  from: 'from_example', # String | from email address
  to: 'to_example', # String | to/destination email address
  subject: 'subject_example', # String | subject containing this string
  mailid: 'mailid_example', # String | mail id
  skip: 0, # Integer | number of records to skip for pagination
  limit: 100, # Integer | maximum number of records to return
  start_date: 789, # Integer | earliest date to get emails in unix timestamp format
  end_date: 789 # Integer | earliest date to get emails in unix timestamp format
}

begin
  #displays the mail log
  result = api_instance.view_mail_log(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling DefaultApi->view_mail_log: #{e}"
end
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **String**| originating ip address sending mail | [optional] 
 **mx** | **String**| mx record mail was sent to | [optional] 
 **from** | **String**| from email address | [optional] 
 **to** | **String**| to/destination email address | [optional] 
 **subject** | **String**| subject containing this string | [optional] 
 **mailid** | **String**| mail id | [optional] 
 **skip** | **Integer**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **Integer**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **Integer**| earliest date to get emails in unix timestamp format | [optional] 
 **end_date** | **Integer**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



