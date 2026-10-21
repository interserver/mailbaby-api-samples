# MailBabyRuby::StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](StatusApi.md#ping_server) | **GET** /ping | Health check — verify the API is reachable

# **ping_server**
> String ping_server

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example
```ruby
# load the gem
require 'mailbaby_client_ruby'

api_instance = MailBabyRuby::StatusApi.new

begin
  #Health check — verify the API is reachable
  result = api_instance.ping_server
  p result
rescue MailBabyRuby::ApiError => e
  puts "Exception when calling StatusApi->ping_server: #{e}"
end
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json



