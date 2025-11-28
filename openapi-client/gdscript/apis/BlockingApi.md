<a name="__pageTop"></a>
# BlockingApi   { #BlockingApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](#add_rule) | **POST** `/mail/rules` | Creates a new email deny rule.
[**delete_rule**](#delete_rule) | **DELETE** `/mail/rules/{ruleId}` | Removes an deny mail rule.
[**delist_block**](#delist_block) | **POST** `/mail/blocks/delete` | Removes an email address from the blocked list
[**get_mail_blocks**](#get_mail_blocks) | **GET** `/mail/blocks` | displays a list of blocked email addresses
[**get_rules**](#get_rules) | **GET** `/mail/rules` | Displays a listing of deny email rules.

# **add_rule**   { #add_rule }
<a name="add_rule"></a>

> `add_rule(type: String,data: String,user = "", on_success: Callable, on_failure: Callable)`

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

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
var api = BlockingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = BlockingApi.new(config, client)


# Invoke an endpoint
api.add_rule(
	# type: String = ""   Eg: type_example
	# The type of deny rule.
	type,
	# data: String = ""   Eg: data_example
	# The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
	data,
	# user: String = ""   Eg: user_example
	# Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
	user,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "add_rule", response)
		assert(response.data is GenericResponse)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **delete_rule**   { #delete_rule }
<a name="delete_rule"></a>

> `delete_rule(ruleId: int, on_success: Callable, on_failure: Callable)`

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

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
var api = BlockingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = BlockingApi.new(config, client)


# Invoke an endpoint
api.delete_rule(
	# ruleId: int   Eg: 34
	# The ID of the Rules entry.
	ruleId,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "delete_rule", response)
		assert(response.data is GenericResponse)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **delist_block**   { #delist_block }
<a name="delist_block"></a>

> `delist_block(body: String, on_success: Callable, on_failure: Callable)`

Removes an email address from the blocked list

Removes an email address from the various block lists. 

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
var api = BlockingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = BlockingApi.new(config, client)


# Invoke an endpoint
api.delist_block(
	# body: String   Eg: {"email":"client@domain.com"}
	body,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "delist_block", response)
		assert(response.data is GenericResponse)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **get_mail_blocks**   { #get_mail_blocks }
<a name="get_mail_blocks"></a>

> `get_mail_blocks( on_success: Callable, on_failure: Callable)`

displays a list of blocked email addresses



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
var api = BlockingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = BlockingApi.new(config, client)


# Invoke an endpoint
api.get_mail_blocks(
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "get_mail_blocks", response)
		assert(response.data is MailBlocks)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **get_rules**   { #get_rules }
<a name="get_rules"></a>

> `get_rules( on_success: Callable, on_failure: Callable)`

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

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
var api = BlockingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = BlockingApi.new(config, client)


# Invoke an endpoint
api.get_rules(
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "get_rules", response)
		assert(response.data is DenyRuleRecord)
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

