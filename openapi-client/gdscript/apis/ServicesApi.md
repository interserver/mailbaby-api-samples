<a name="__pageTop"></a>
# ServicesApi   { #ServicesApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_order_by_id**](#get_mail_order_by_id) | **GET** `/mail/{id}` | Get one mail order&#x27;s full detail including SMTP password
[**get_mail_orders**](#get_mail_orders) | **GET** `/mail` | List your provisioned mail orders (sending accounts)

# **get_mail_order_by_id**   { #get_mail_order_by_id }
<a name="get_mail_order_by_id"></a>

> `get_mail_order_by_id(id: float, on_success: Callable, on_failure: Callable)`

Get one mail order's full detail including SMTP password

**Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 

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
api.get_mail_order_by_id(
	# id: float   Eg: 39
	# The numeric ID of the mail order.
	id,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "get_mail_order_by_id", response)
		assert(response.data is MailOrderDetail)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **get_mail_orders**   { #get_mail_orders }
<a name="get_mail_orders"></a>

> `get_mail_orders( on_success: Callable, on_failure: Callable)`

List your provisioned mail orders (sending accounts)

Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 

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

