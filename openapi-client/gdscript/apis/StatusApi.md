<a name="__pageTop"></a>
# StatusApi   { #StatusApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](#ping_server) | **GET** `/ping` | Checks if the server is running

# **ping_server**   { #ping_server }
<a name="ping_server"></a>

> `ping_server( on_success: Callable, on_failure: Callable)`

Checks if the server is running



### Example

* Api Key Authentication (`apiKeyAuth`)

```gdscript

# Customize configuration
var config := ApiConfig.new()
config.host = "localhost"
config.port = 8080
#config.tls_enabled = true
#config.trusted_chain = preload("res://my_cert_chain.crt")

# Instantiate the api
var api = StatusApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = StatusApi.new(config, client)


# Invoke an endpoint
api.ping_server(
	# On Success
	func(response):
		prints("Success!", "ping_server", response)
		
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

[[Back to top]](#__pageTop) \
[[Back to API list]](../README.md#documentation-for-api-endpoints) \
[[Back to Model list]](../README.md#documentation-for-models) \
[[Back to README]](../README.md) \

