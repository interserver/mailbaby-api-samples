# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | Account usage, cost, and volume statistics for a time window
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | Query the mail delivery log (filterable, paginated)


# **get_stats**
> `get_stats`(req::`HTTP.Request`; `time`=nothing,) -> `MailStatsType`

Account usage, cost, and volume statistics for a time window

**Use this for dashboards or billing-cycle reviews.** Returns aggregate sending statistics for your mail account(s). The `time` query param controls the window for `received`, `sent`, and `volume` (`1h`, `24h`, `7d`, `month`, `day`, `billing`, `all`). The `usage` and `cost` fields are always for the current billing cycle, regardless of `time`.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | **`HTTP.Request`** | The HTTP Request object | 

### Optional Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **`time`** | **`String`**| The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle. Defaults to &#x60;1h&#x60;. | [default to &quot;1h&quot;]

### Return type

[**`MailStatsType`**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> `view_mail_log`(req::`HTTP.Request`; `id`=nothing, `origin`=nothing, `mx`=nothing, `from`=nothing, `to`=nothing, `subject`=nothing, `mailid`=nothing, `message_id`=nothing, `replyto`=nothing, `headerfrom`=nothing, `delivered`=nothing, `skip`=nothing, `limit`=nothing, `start_date`=nothing, `end_date`=nothing, `sort`=nothing, `dir`=nothing, `groupby`=nothing,) -> `MailLog`

Query the mail delivery log (filterable, paginated)

**Use this to find or audit sent messages.** All filters are optional and combinable. The most useful filters: `mailid` (the transaction id returned by a send call), `from` / `to` (envelope addresses), `subject`, `messageId` (case-insensitive substring on the `Message-ID` header), `delivered` (`1`=delivered, `0`=queued/failed), and the `startDate`/`endDate` date range. Returns a paginated list of every email message accepted by the relay for your mail account(s).  **Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).  **Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.  **Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.  **Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 

### Required Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **req** | **`HTTP.Request`** | The HTTP Request object | 

### Optional Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **`id`** | **`Int64`**| The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from &#x60;GET /mail&#x60; or &#x60;GET /mail/{id}&#x60;. | [default to nothing]
 **`origin`** | **`String`**| Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. | [default to nothing]
 **`mx`** | **`String`**| Filter by the MX hostname the relay attempted delivery to.  For example &#x60;mx.google.com&#x60; would return messages destined for Gmail recipients. Maps to &#x60;mxHostname&#x60; in the &#x60;MailLogEntry&#x60; response. | [default to nothing]
 **`from`** | **`String`**| Filter by SMTP envelope &#x60;MAIL FROM&#x60; address (exact match).  This is the address the relay used for bounce handling and may differ from the &#x60;From:&#x60; message header.  For header-level filtering use &#x60;headerfrom&#x60;. | [default to nothing]
 **`to`** | **`String`**| Filter by SMTP envelope &#x60;RCPT TO&#x60; address (exact match).  This is the delivery address used by the relay and may differ from the &#x60;To:&#x60; header when BCC recipients are involved. | [default to nothing]
 **`subject`** | **`String`**| Filter by email &#x60;Subject&#x60; header (exact match).  To search for a substring, include it in the full subject text. | [default to nothing]
 **`mailid`** | **`String`**| Filter by the relay-assigned mail ID string (exact match).  This corresponds to the &#x60;id&#x60; field in &#x60;MailLogEntry&#x60; and to the &#x60;text&#x60; value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as &#x60;185997065c60008840&#x60;. | [default to nothing]
 **`message_id`** | **`String`**| Filter by the &#x60;Message-ID&#x60; email header using a substring (case-insensitive) match. The &#x60;Message-ID&#x60; is assigned by the sending mail client and is visible in the &#x60;messageId&#x60; field of &#x60;MailLogEntry&#x60;.  Useful when you know the message ID generated by your application but not the relay &#x60;mailid&#x60;. | [default to nothing]
 **`replyto`** | **`String`**| Filter by the &#x60;Reply-To&#x60; message header address (exact match).  Only returns messages where this header was explicitly set. | [default to nothing]
 **`headerfrom`** | **`String`**| Filter by the &#x60;From&#x60; message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope &#x60;from&#x60; parameter when sending on behalf of another address. | [default to nothing]
 **`delivered`** | **`Int64`**| Filter by delivery status.  &#x60;1&#x60; returns only messages that were successfully delivered to the destination MX.  &#x60;0&#x60; returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. | [default to nothing]
 **`skip`** | **`Int64`**| Number of records to skip for pagination.  Use in combination with &#x60;limit&#x60; to page through large result sets.  Defaults to &#x60;0&#x60; (no skip). | [default to 0]
 **`limit`** | **`Int64`**| Maximum number of records to return per page.  Defaults to &#x60;100&#x60;. Maximum allowed value is &#x60;10000&#x60;.  The response also includes a &#x60;total&#x60; field with the full matched count so you can calculate the number of pages. | [default to 100]
 **`start_date`** | [**`DateOrTimestamp`**](.md)| Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60; or &#x60;last monday&#x60;.  Messages with a &#x60;time&#x60; value **greater than or equal to** this value will be included. | [default to nothing]
 **`end_date`** | [**`DateOrTimestamp`**](.md)| Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; such as &#x60;2024-01-31&#x60; or &#x60;yesterday&#x60;. Messages with a &#x60;time&#x60; value **less than or equal to** this value will be included. | [default to nothing]
 **`sort`** | **`String`**| Field to sort results by.  Currently only &#x60;time&#x60; is supported (sorts by internal row ID which corresponds to chronological order). | [default to &quot;time&quot;]
 **`dir`** | **`String`**| Sort direction.  &#x60;desc&#x60; returns newest first (default), &#x60;asc&#x60; returns oldest first. | [default to &quot;desc&quot;]
 **`groupby`** | **`String`**| Controls how results are grouped.  &#x60;recipient&#x60; (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and delivery metadata.  &#x60;message&#x60; collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The &#x60;total&#x60; count in the response matches the grouping mode. | [default to &quot;recipient&quot;]

### Return type

[**`MailLog`**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

