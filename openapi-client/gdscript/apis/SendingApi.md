<a name="__pageTop"></a>
# SendingApi   { #SendingApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](#send_adv_mail) | **POST** `/mail/advsend` | Sends an Email with Advanced Options
[**send_mail**](#send_mail) | **POST** `/mail/send` | Sends an Email

# **send_adv_mail**   { #send_adv_mail }
<a name="send_adv_mail"></a>

> `send_adv_mail(subject: String,body: String,from: EmailAddressTypes,to: EmailAddressesTypes,replyto = null,cc = null,bcc = null,attachments = null,id = null, on_success: Callable, on_failure: Callable)`

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 

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
var api = SendingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = SendingApi.new(config, client)


# Invoke an endpoint
api.send_adv_mail(
	# subject: String = ""   Eg: subject_example
	# The subject or title of the email
	subject,
	# body: String = ""   Eg: body_example
	# The main email contents.
	body,
	# from: EmailAddressTypes
	from,
	# to: EmailAddressesTypes
	to,
	# replyto: EmailAddressesTypes
	replyto,
	# cc: EmailAddressesTypes
	cc,
	# bcc: EmailAddressesTypes
	bcc,
	# attachments: Array
	# (optional) File attachments to include in the email.  The file contents must be base64 encoded!
	attachments,
	# id: float   Eg: 789
	# (optional)  ID of the Mail order within our system to use as the Mail Account.
	id,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "send_adv_mail", response)
		assert(response.data is GenericResponse)
		pass  # do things, make stuff
		,
	# On Error
	func(error):  # error is ApiError
		push_error(str(error))
		,
)

```

# **send_mail**   { #send_mail }
<a name="send_mail"></a>

> `send_mail(to: String,from: String,subject: String,body: String, on_success: Callable, on_failure: Callable)`

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

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
var api = SendingApi.new(config)
# You can also provide your own HTTPClient, to re-use it across apis.
#var api = SendingApi.new(config, client)


# Invoke an endpoint
api.send_mail(
	# to: String = ""   Eg: to_example
	# The Contact whom is the primary recipient of this email.
	to,
	# from: String = ""   Eg: from_example
	# The contact whom is the this email is from.
	from,
	# subject: String = ""   Eg: subject_example
	# The subject or title of the email
	subject,
	# body: String = ""   Eg: body_example
	# The main email contents.
	body,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "send_mail", response)
		assert(response.data is GenericResponse)
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

