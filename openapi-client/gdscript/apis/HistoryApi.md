<a name="__pageTop"></a>
# HistoryApi   { #HistoryApi }


All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](#get_stats) | **GET** `/mail/stats` | Account usage statistics
[**view_mail_log**](#view_mail_log) | **GET** `/mail/log` | Displays the mail log

# **get_stats**   { #get_stats }
<a name="get_stats"></a>

> `get_stats(some_timenull = "1h", on_success: Callable, on_failure: Callable)`

Account usage statistics

Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 

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
	# some_timenull: String = "1h"   Eg: some_timenull_example
	# The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle.  Defaults to `1h`.
	some_timenull,
	# On Success
	func(response):  # response is ApiResponse
		prints("Success!", "get_stats", response)
		assert(response.data is MailStatsType)
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

> `view_mail_log(id = null,origin = "",mx = "",from = null,to = null,subject = "",mailid = "",messageId = "",replyto = null,headerfrom = null,delivered = null,skip = 0,limit = 100,startDate = null,endDate = null, on_success: Callable, on_failure: Callable)`

Displays the mail log

Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 

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
	# The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`.
	id,
	# origin: String = ""   Eg: 1.2.3.4
	# Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.
	origin,
	# mx: String = ""   Eg: mx.google.com
	# Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response.
	mx,
	# from: String   Eg: me@sender.com
	# Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`.
	from,
	# to: String   Eg: you@receiver.com
	# Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved.
	to,
	# subject: String = ""   Eg: Your order has shipped
	# Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text.
	subject,
	# mailid: String = ""   Eg: 185997065c60008840
	# Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`.
	mailid,
	# messageId: String = ""   Eg: <abc123@yourdomain.com>
	# Filter by the `Message-ID` email header using a substring (case-insensitive) match.  The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`.
	messageId,
	# replyto: String   Eg: replies@sender.com
	# Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set.
	replyto,
	# headerfrom: String   Eg: newsletter@sender.com
	# Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address.
	headerfrom,
	# delivered: int   Eg: 1
	# Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.
	delivered,
	# skip: int = 0   Eg: 0
	# Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip).
	skip,
	# limit: int = 100   Eg: 100
	# Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages.
	limit,
	# startDate: float   Eg: 1641781008
	# Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a `time` value **greater than or equal to** this value will be included.
	startDate,
	# endDate: float   Eg: 1673317008
	# Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a `time` value **less than or equal to** this value will be included.
	endDate,
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

