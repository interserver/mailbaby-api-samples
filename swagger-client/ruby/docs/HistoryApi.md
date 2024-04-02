# SwaggerClient::HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | Account usage statistics.
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | displays the mail log

# **get_stats**
> Array&lt;InlineResponse200&gt; get_stats

Account usage statistics.

Returns information about the usage on your mail accounts.

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

api_instance = SwaggerClient::HistoryApi.new

begin
  #Account usage statistics.
  result = api_instance.get_stats
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling HistoryApi->get_stats: #{e}"
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

api_instance = SwaggerClient::HistoryApi.new
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
  end_date: 789, # Integer | earliest date to get emails in unix timestamp format
  replyto: 'replyto_example', # String | Reply-To Email Address
  headerfrom: 'headerfrom_example' # String | Header From Email Address
}

begin
  #displays the mail log
  result = api_instance.view_mail_log(opts)
  p result
rescue SwaggerClient::ApiError => e
  puts "Exception when calling HistoryApi->view_mail_log: #{e}"
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
 **replyto** | **String**| Reply-To Email Address | [optional] 
 **headerfrom** | **String**| Header From Email Address | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json



