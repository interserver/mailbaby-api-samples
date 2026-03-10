# HistoryApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | Displays the mail log



## getStats

Account usage statistics

Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.

The response includes:
- **'usage'** — total messages accepted by the relay during the current billing
  cycle (used for cost calculation).
- **'cost'** — estimated cost for the billing cycle based on the base plan price
  plus per-email charges.
- **'received'** / **'sent'** — count of messages accepted by the relay /
  successfully delivered to the destination MX within the selected 'time' window.
- **'volume'** — top-500 breakdown of message counts grouped by source IP ('ip'),
  destination address ('to'), and sender address ('from') within the selected window.


**Time windows** (controlled by the 'time' parameter):
| Value | Window | |-------|--------| | '1h' | Last 1 hour (default) | | '24h' | Last 24 hours | | '7d' | Last 7 days | | 'month' | Current calendar month (1st to now) | | 'day' | Today (midnight to now) | | 'billing' | Current billing cycle (last invoice date to next invoice date) | | 'all' | All time |

### Example

```bash
 getStats  time=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_time** | **string** | The time window to scope 'received', 'sent', and 'volume' statistics. Does not affect 'usage' or 'cost', which are always calculated over the current billing cycle.  Defaults to '1h'. | [optional] [default to 1h]

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


## viewMailLog

Displays the mail log

Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.

**Pagination** is controlled by 'skip' and 'limit'.  The response includes a 'total' count so clients can determine how many pages exist.

**Date filtering** uses Unix timestamps ('startDate' / 'endDate').  For example, to retrieve emails sent in January 2024: 'startDate=1704067200&endDate=1706745599'.

**Delivery status** can be filtered with the 'delivered' parameter: 'delivered=1' returns only successfully delivered messages; 'delivered=0' returns messages still in queue or that failed.

**Address filtering** distinguishes between the SMTP envelope address ('from', 'to') and message headers ('headerfrom' for the 'From:' header, 'replyto' for 'Reply-To:'). These may differ when a message is sent on behalf of another address.

The 'mailid' parameter corresponds to the 'id' field in the returned 'MailLogEntry' objects, **not** the '_id' field.  It also matches the transaction ID returned in the 'text' field of a successful send response from '/mail/send', '/mail/advsend', or '/mail/rawsend'.

The 'messageId' parameter searches the 'Message-ID' email header (case-insensitive substring match).

### Example

```bash
 viewMailLog  id=value  origin=value  mx=value  from=value  to=value  subject=value  mailid=value  messageId=value  replyto=value  headerfrom=value  delivered=value  skip=value  limit=value  startDate=value  endDate=value
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **integer** | The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from 'GET /mail' or 'GET /mail/{id}'. | [optional] [default to null]
 **origin** | **string** | Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. | [optional] [default to null]
 **mx** | **string** | Filter by the MX hostname the relay attempted delivery to.  For example 'mx.google.com' would return messages destined for Gmail recipients. Maps to 'mxHostname' in the 'MailLogEntry' response. | [optional] [default to null]
 **from** | **string** | Filter by SMTP envelope 'MAIL FROM' address (exact match).  This is the address the relay used for bounce handling and may differ from the 'From:' message header.  For header-level filtering use 'headerfrom'. | [optional] [default to null]
 **to** | **string** | Filter by SMTP envelope 'RCPT TO' address (exact match).  This is the delivery address used by the relay and may differ from the 'To:' header when BCC recipients are involved. | [optional] [default to null]
 **subject** | **string** | Filter by email 'Subject' header (exact match).  To search for a substring, include it in the full subject text. | [optional] [default to null]
 **mailid** | **string** | Filter by the relay-assigned mail ID string (exact match).  This corresponds to the 'id' field in 'MailLogEntry' and to the 'text' value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as '185997065c60008840'. | [optional] [default to null]
 **messageId** | **string** | Filter by the 'Message-ID' email header using a substring (case-insensitive) match.  The 'Message-ID' is assigned by the sending mail client and is visible in the 'messageId' field of 'MailLogEntry'.  Useful when you know the message ID generated by your application but not the relay 'mailid'. | [optional] [default to null]
 **replyto** | **string** | Filter by the 'Reply-To' message header address (exact match).  Only returns messages where this header was explicitly set. | [optional] [default to null]
 **headerfrom** | **string** | Filter by the 'From' message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope 'from' parameter when sending on behalf of another address. | [optional] [default to null]
 **delivered** | **integer** | Filter by delivery status.  '1' returns only messages that were successfully delivered to the destination MX.  '0' returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. | [optional] [default to null]
 **skip** | **integer** | Number of records to skip for pagination.  Use in combination with 'limit' to page through large result sets.  Defaults to '0' (no skip). | [optional] [default to 0]
 **limit** | **integer** | Maximum number of records to return per page.  Defaults to '100'. Maximum allowed value is '10000'.  The response also includes a 'total' field with the full matched count so you can calculate the number of pages. | [optional] [default to 100]
 **startDate** | **integer** | Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a 'time' value **greater than or equal to** this value will be included. | [optional] [default to null]
 **endDate** | **integer** | Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a 'time' value **less than or equal to** this value will be included. | [optional] [default to null]

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not Applicable
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

