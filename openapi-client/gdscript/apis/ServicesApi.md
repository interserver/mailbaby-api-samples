<a name="__pageTop"></a>
# ServicesApi   { #ServicesApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](#get_mail_orders) | **GET** `/mail` | displays a list of mail service orders

# **get_mail_orders**   { #get_mail_orders }
<a name="get_mail_orders"></a>

> `get_mail_orders( on_success: Callable, on_failure: Callable)`

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

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
var api = ServicesApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = ServicesApi.new(config, client)


# Invoke an endpoint
api.get_mail_orders(
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "get_mail_orders", response)
		assert(response.data is MailOrder)
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

