<a name="__pageTop"></a>
# HistoryApi   { #HistoryApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](#get_stats) | **GET** `/mail/stats` | Account usage statistics.
[**view_mail_log**](#view_mail_log) | **GET** `/mail/log` | displays the mail log

# **get_stats**   { #get_stats }
<a name="get_stats"></a>

> `get_stats( on_success: Callable, on_failure: Callable)`

Account usage statistics.

Returns information about the usage on your mail accounts.

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
var api = HistoryApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = HistoryApi.new(config, client)


# Invoke an endpoint
api.get_stats(
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "get_stats", response)
		assert(response.data is getStats_200_response_inner)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **view_mail_log**   { #view_mail_log }
<a name="view_mail_log"></a>

> `view_mail_log(id = null,origin = "",mx = "",from = "",to = "",subject = "",mailid = "",skip = 0,limit = 100,startDate = null,endDate = null,replyto = "",headerfrom = "", on_success: Callable, on_failure: Callable)`

displays the mail log

Get a listing of the emails sent through this system 

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
var api = HistoryApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = HistoryApi.new(config, client)


# Invoke an endpoint
api.view_mail_log(
	# id: float   Eg: 2604
	# The ID of your mail order this will be sent through.
	id,
	# origin: String = ""   Eg: 1.2.3.4
	# originating ip address sending mail
	origin,
	# mx: String = ""   Eg: mx.google.com
	# mx record mail was sent to
	mx,
	# from: String = ""   Eg: me@sender.com
	# from email address
	from,
	# to: String = ""   Eg: you@receiver.com
	# to/destination email address
	to,
	# subject: String = ""   Eg: Support
	# subject containing this string
	subject,
	# mailid: String = ""   Eg: 185997065c60008840
	# mail id
	mailid,
	# skip: int = 0   Eg: 1000
	# number of records to skip for pagination
	skip,
	# limit: int = 100   Eg: 1000
	# maximum number of records to return
	limit,
	# startDate: float   Eg: 1641781008
	# earliest date to get emails in unix timestamp format
	startDate,
	# endDate: float   Eg: 1673317008
	# earliest date to get emails in unix timestamp format
	endDate,
	# replyto: String = ""   Eg: replyto_example
	# Reply-To Email Address
	replyto,
	# headerfrom: String = ""   Eg: headerfrom_example
	# Header From Email Address
	headerfrom,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "view_mail_log", response)
		assert(response.data is MailLog)
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

