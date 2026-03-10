<a name="__pageTop"></a>
# BlockingApi   { #BlockingApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](#add_rule) | **POST** `/mail/rules` | Creates a new email deny rule
[**delete_rule**](#delete_rule) | **DELETE** `/mail/rules/{ruleId}` | Removes a deny mail rule
[**delist_block**](#delist_block) | **POST** `/mail/blocks/delete` | Removes an email address from the block lists
[**get_mail_blocks**](#get_mail_blocks) | **GET** `/mail/blocks` | Displays a list of blocked email addresses
[**get_rules**](#get_rules) | **GET** `/mail/rules` | Displays a listing of deny email rules

# **add_rule**   { #add_rule }
<a name="add_rule"></a>

> `add_rule(type: String,data: String,user = "", on_success: Callable, on_failure: Callable)`

Creates a new email deny rule

Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 

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
	# The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
	data,
	# user: String = ""   Eg: user_example
	# Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
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

Removes a deny mail rule

Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 

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
	# The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.
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

> `delist_block(emailAddressParam: EmailAddressParam, on_success: Callable, on_failure: Callable)`

Removes an email address from the block lists

Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 

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

var emailAddressParam = EmailAddressParam.new()
# … fill model emailAddressParam with data

# Invoke an endpoint
api.delist_block(
	# emailAddressParam: EmailAddressParam   Eg: {"email":"client@domain.com"}
	emailAddressParam,
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

Displays a list of blocked email addresses

Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 

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

Displays a listing of deny email rules

Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 

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

