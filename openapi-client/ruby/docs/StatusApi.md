# OpenapiClient::StatusApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**ping_server**](StatusApi.md#ping_server) | **GET** /ping | Health check — verify the API is reachable |


## ping_server

> String ping_server

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Examples

```ruby
require 'time'
require 'openapi_client'

api_instance = OpenapiClient::StatusApi.new

begin
  # Health check — verify the API is reachable
  result = api_instance.ping_server
  p result
rescue OpenapiClient::ApiError => e
  puts "Error when calling StatusApi->ping_server: #{e}"
end
```

#### Using the ping_server_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(String, Integer, Hash)> ping_server_with_http_info

```ruby
begin
  # Health check — verify the API is reachable
  data, status_code, headers = api_instance.ping_server_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => String
rescue OpenapiClient::ApiError => e
  puts "Error when calling StatusApi->ping_server_with_http_info: #{e}"
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

