# openapi_client.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | Account usage statistics
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | Displays the mail log


# **get_stats**
> MailStatsType get_stats(time=time)

Account usage statistics

Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.

The response includes:
- **`usage`** — total messages accepted by the relay during the current billing
  cycle (used for cost calculation).
- **`cost`** — estimated cost for the billing cycle based on the base plan price
  plus per-email charges.
- **`received`** / **`sent`** — count of messages accepted by the relay /
  successfully delivered to the destination MX within the selected `time` window.
- **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),
  destination address (`to`), and sender address (`from`) within the selected window.


**Time windows** (controlled by the `time` parameter):
| Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time |


### Example

* Api Key Authentication (apiKeyAuth):

```python
import openapi_client
from openapi_client.models.mail_stats_type import MailStatsType
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.HistoryApi(api_client)
    time = 1h # str | The time window to scope `received`, `sent`, and `volume` statistics. Does not affect `usage` or `cost`, which are always calculated over the current billing cycle. Defaults to `1h`. (optional) (default to 1h)

    try:
        # Account usage statistics
        api_response = api_instance.get_stats(time=time)
        print("The response of HistoryApi->get_stats:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HistoryApi->get_stats: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **str**| The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle. Defaults to &#x60;1h&#x60;. | [optional] [default to 1h]

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log**
> MailLog view_mail_log(id=id, origin=origin, mx=mx, var_from=var_from, to=to, subject=subject, mailid=mailid, message_id=message_id, replyto=replyto, headerfrom=headerfrom, delivered=delivered, skip=skip, limit=limit, start_date=start_date, end_date=end_date, sort=sort, dir=dir, groupby=groupby)

Displays the mail log

Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.

**Row grouping** is controlled by the `groupby` parameter.  By default (`groupby=recipient`), the response contains one row per delivery attempt — so a single message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and `mxHostname` values.  Set `groupby=message` to collapse to one row per message (delivery fields will reflect one arbitrary recipient).

**Pagination** is controlled by `skip` and `limit`.  The `total` in the response reflects the row count **after** grouping, so it matches the number of pages you need to fetch.

**Date filtering** accepts either a Unix timestamp (integer) or a date string parseable by PHP `strtotime()` such as `2024-01-15`, `last monday`, or `2024-01-01 00:00:00`.  Examples: `startDate=1704067200&endDate=1706745599` or `startDate=2024-01-01&endDate=2024-01-31`.

**Sorting** is controlled by `sort` and `dir`.  Currently the only sort key is `time` (default), which orders by internal row ID.

**Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.

**Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.

The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.

The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match).


### Example

* Api Key Authentication (apiKeyAuth):

```python
import openapi_client
from openapi_client.models.mail_log import MailLog
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.HistoryApi(api_client)
    id = 2604 # int | The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from `GET /mail` or `GET /mail/{id}`. (optional)
    origin = '1.2.3.4' # str | Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. (optional)
    mx = 'mx.google.com' # str | Filter by the MX hostname the relay attempted delivery to.  For example `mx.google.com` would return messages destined for Gmail recipients. Maps to `mxHostname` in the `MailLogEntry` response. (optional)
    var_from = 'me@sender.com' # str | Filter by SMTP envelope `MAIL FROM` address (exact match).  This is the address the relay used for bounce handling and may differ from the `From:` message header.  For header-level filtering use `headerfrom`. (optional)
    to = 'you@receiver.com' # str | Filter by SMTP envelope `RCPT TO` address (exact match).  This is the delivery address used by the relay and may differ from the `To:` header when BCC recipients are involved. (optional)
    subject = 'Your order has shipped' # str | Filter by email `Subject` header (exact match).  To search for a substring, include it in the full subject text. (optional)
    mailid = '185997065c60008840' # str | Filter by the relay-assigned mail ID string (exact match).  This corresponds to the `id` field in `MailLogEntry` and to the `text` value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as `185997065c60008840`. (optional)
    message_id = '<abc123@yourdomain.com>' # str | Filter by the `Message-ID` email header using a substring (case-insensitive) match. The `Message-ID` is assigned by the sending mail client and is visible in the `messageId` field of `MailLogEntry`.  Useful when you know the message ID generated by your application but not the relay `mailid`. (optional)
    replyto = 'replies@sender.com' # str | Filter by the `Reply-To` message header address (exact match).  Only returns messages where this header was explicitly set. (optional)
    headerfrom = 'newsletter@sender.com' # str | Filter by the `From` message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope `from` parameter when sending on behalf of another address. (optional)
    delivered = 1 # int | Filter by delivery status.  `1` returns only messages that were successfully delivered to the destination MX.  `0` returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. (optional)
    skip = 0 # int | Number of records to skip for pagination.  Use in combination with `limit` to page through large result sets.  Defaults to `0` (no skip). (optional) (default to 0)
    limit = 100 # int | Maximum number of records to return per page.  Defaults to `100`. Maximum allowed value is `10000`.  The response also includes a `total` field with the full matched count so you can calculate the number of pages. (optional) (default to 100)
    start_date = openapi_client.DateOrTimestamp() # DateOrTimestamp | Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-15` or `last monday`.  Messages with a `time` value **greater than or equal to** this value will be included. (optional)
    end_date = openapi_client.DateOrTimestamp() # DateOrTimestamp | Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by `strtotime()` such as `2024-01-31` or `yesterday`. Messages with a `time` value **less than or equal to** this value will be included. (optional)
    sort = time # str | Field to sort results by.  Currently only `time` is supported (sorts by internal row ID which corresponds to chronological order). (optional) (default to time)
    dir = desc # str | Sort direction.  `desc` returns newest first (default), `asc` returns oldest first. (optional) (default to desc)
    groupby = recipient # str | Controls how results are grouped.  `recipient` (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own `recipient`, `delivered`, `response`, and delivery metadata.  `message` collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The `total` count in the response matches the grouping mode. (optional) (default to recipient)

    try:
        # Displays the mail log
        api_response = api_instance.view_mail_log(id=id, origin=origin, mx=mx, var_from=var_from, to=to, subject=subject, mailid=mailid, message_id=message_id, replyto=replyto, headerfrom=headerfrom, delivered=delivered, skip=skip, limit=limit, start_date=start_date, end_date=end_date, sort=sort, dir=dir, groupby=groupby)
        print("The response of HistoryApi->view_mail_log:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HistoryApi->view_mail_log: %s\n" % e)
```



### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from &#x60;GET /mail&#x60; or &#x60;GET /mail/{id}&#x60;. | [optional] 
 **origin** | **str**| Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. | [optional] 
 **mx** | **str**| Filter by the MX hostname the relay attempted delivery to.  For example &#x60;mx.google.com&#x60; would return messages destined for Gmail recipients. Maps to &#x60;mxHostname&#x60; in the &#x60;MailLogEntry&#x60; response. | [optional] 
 **var_from** | **str**| Filter by SMTP envelope &#x60;MAIL FROM&#x60; address (exact match).  This is the address the relay used for bounce handling and may differ from the &#x60;From:&#x60; message header.  For header-level filtering use &#x60;headerfrom&#x60;. | [optional] 
 **to** | **str**| Filter by SMTP envelope &#x60;RCPT TO&#x60; address (exact match).  This is the delivery address used by the relay and may differ from the &#x60;To:&#x60; header when BCC recipients are involved. | [optional] 
 **subject** | **str**| Filter by email &#x60;Subject&#x60; header (exact match).  To search for a substring, include it in the full subject text. | [optional] 
 **mailid** | **str**| Filter by the relay-assigned mail ID string (exact match).  This corresponds to the &#x60;id&#x60; field in &#x60;MailLogEntry&#x60; and to the &#x60;text&#x60; value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as &#x60;185997065c60008840&#x60;. | [optional] 
 **message_id** | **str**| Filter by the &#x60;Message-ID&#x60; email header using a substring (case-insensitive) match. The &#x60;Message-ID&#x60; is assigned by the sending mail client and is visible in the &#x60;messageId&#x60; field of &#x60;MailLogEntry&#x60;.  Useful when you know the message ID generated by your application but not the relay &#x60;mailid&#x60;. | [optional] 
 **replyto** | **str**| Filter by the &#x60;Reply-To&#x60; message header address (exact match).  Only returns messages where this header was explicitly set. | [optional] 
 **headerfrom** | **str**| Filter by the &#x60;From&#x60; message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope &#x60;from&#x60; parameter when sending on behalf of another address. | [optional] 
 **delivered** | **int**| Filter by delivery status.  &#x60;1&#x60; returns only messages that were successfully delivered to the destination MX.  &#x60;0&#x60; returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. | [optional] 
 **skip** | **int**| Number of records to skip for pagination.  Use in combination with &#x60;limit&#x60; to page through large result sets.  Defaults to &#x60;0&#x60; (no skip). | [optional] [default to 0]
 **limit** | **int**| Maximum number of records to return per page.  Defaults to &#x60;100&#x60;. Maximum allowed value is &#x60;10000&#x60;.  The response also includes a &#x60;total&#x60; field with the full matched count so you can calculate the number of pages. | [optional] [default to 100]
 **start_date** | [**DateOrTimestamp**](.md)| Earliest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; such as &#x60;2024-01-15&#x60; or &#x60;last monday&#x60;.  Messages with a &#x60;time&#x60; value **greater than or equal to** this value will be included. | [optional] 
 **end_date** | [**DateOrTimestamp**](.md)| Latest date to include.  Accepts either a Unix timestamp (integer seconds since epoch) or a date string parseable by &#x60;strtotime()&#x60; such as &#x60;2024-01-31&#x60; or &#x60;yesterday&#x60;. Messages with a &#x60;time&#x60; value **less than or equal to** this value will be included. | [optional] 
 **sort** | **str**| Field to sort results by.  Currently only &#x60;time&#x60; is supported (sorts by internal row ID which corresponds to chronological order). | [optional] [default to time]
 **dir** | **str**| Sort direction.  &#x60;desc&#x60; returns newest first (default), &#x60;asc&#x60; returns oldest first. | [optional] [default to desc]
 **groupby** | **str**| Controls how results are grouped.  &#x60;recipient&#x60; (default) returns one row per delivery attempt — a message sent to 4 recipients produces 4 rows, each with its own &#x60;recipient&#x60;, &#x60;delivered&#x60;, &#x60;response&#x60;, and delivery metadata.  &#x60;message&#x60; collapses to one row per unique message ID; delivery-level fields will reflect one arbitrary recipient per message.  The &#x60;total&#x60; count in the response matches the grouping mode. | [optional] [default to recipient]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details

| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Paginated list of mail log entries |  -  |
**400** | Bad request — one or more input parameters were missing or invalid. |  -  |
**401** | Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security). |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

