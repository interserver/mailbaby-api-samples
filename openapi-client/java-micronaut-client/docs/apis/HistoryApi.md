# HistoryApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics |
| [**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | Displays the mail log |


## Creating HistoryApi

To initiate an instance of `HistoryApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.HistoryApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(HistoryApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    HistoryApi historyApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a id="getStats"></a>
# **getStats**
```java
Mono<MailStatsType> HistoryApi.getStats(time)
```

Account usage statistics

Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **&#x60;usage&#x60;** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **&#x60;cost&#x60;** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **&#x60;received&#x60;** / **&#x60;sent&#x60;** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected &#x60;time&#x60; window. - **&#x60;volume&#x60;** — top-500 breakdown of message counts grouped by source IP (&#x60;ip&#x60;),   destination address (&#x60;to&#x60;), and sender address (&#x60;from&#x60;) within the selected window.   **Time windows** (controlled by the &#x60;time&#x60; parameter): | Value | Window | |-------|--------| | &#x60;1h&#x60; | Last 1 hour (default) | | &#x60;24h&#x60; | Last 24 hours | | &#x60;7d&#x60; | Last 7 days | | &#x60;month&#x60; | Current calendar month (1st to now) | | &#x60;day&#x60; | Today (midnight to now) | | &#x60;billing&#x60; | Current billing cycle (last invoice date to next invoice date) | | &#x60;all&#x60; | All time | 

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **time** | `String`| The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle.  Defaults to &#x60;1h&#x60;. | [optional parameter] [default to `1h`] [enum: `all`, `billing`, `month`, `7d`, `24h`, `day`, `1h`] |


### Return type
[**MailStatsType**](MailStatsType.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

<a id="viewMailLog"></a>
# **viewMailLog**
```java
Mono<MailLog> HistoryApi.viewMailLog(idoriginmxfromtosubjectmailidmessageIdreplytoheaderfromdeliveredskiplimitstartDateendDate)
```

Displays the mail log

Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by &#x60;skip&#x60; and &#x60;limit&#x60;.  The response includes a &#x60;total&#x60; count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (&#x60;startDate&#x60; / &#x60;endDate&#x60;).  For example, to retrieve emails sent in January 2024: &#x60;startDate&#x3D;1704067200&amp;endDate&#x3D;1706745599&#x60;.  **Delivery status** can be filtered with the &#x60;delivered&#x60; parameter: &#x60;delivered&#x3D;1&#x60; returns only successfully delivered messages; &#x60;delivered&#x3D;0&#x60; returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (&#x60;from&#x60;, &#x60;to&#x60;) and message headers (&#x60;headerfrom&#x60; for the &#x60;From:&#x60; header, &#x60;replyto&#x60; for &#x60;Reply-To:&#x60;). These may differ when a message is sent on behalf of another address.  The &#x60;mailid&#x60; parameter corresponds to the &#x60;id&#x60; field in the returned &#x60;MailLogEntry&#x60; objects, **not** the &#x60;_id&#x60; field.  It also matches the transaction ID returned in the &#x60;text&#x60; field of a successful send response from &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, or &#x60;/mail/rawsend&#x60;.  The &#x60;messageId&#x60; parameter searches the &#x60;Message-ID&#x60; email header (case-insensitive substring match). 

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | `Long`| The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from &#x60;GET /mail&#x60; or &#x60;GET /mail/{id}&#x60;. | [optional parameter] |
| **origin** | `String`| Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. | [optional parameter] |
| **mx** | `String`| Filter by the MX hostname the relay attempted delivery to.  For example &#x60;mx.google.com&#x60; would return messages destined for Gmail recipients. Maps to &#x60;mxHostname&#x60; in the &#x60;MailLogEntry&#x60; response. | [optional parameter] |
| **from** | `String`| Filter by SMTP envelope &#x60;MAIL FROM&#x60; address (exact match).  This is the address the relay used for bounce handling and may differ from the &#x60;From:&#x60; message header.  For header-level filtering use &#x60;headerfrom&#x60;. | [optional parameter] |
| **to** | `String`| Filter by SMTP envelope &#x60;RCPT TO&#x60; address (exact match).  This is the delivery address used by the relay and may differ from the &#x60;To:&#x60; header when BCC recipients are involved. | [optional parameter] |
| **subject** | `String`| Filter by email &#x60;Subject&#x60; header (exact match).  To search for a substring, include it in the full subject text. | [optional parameter] |
| **mailid** | `String`| Filter by the relay-assigned mail ID string (exact match).  This corresponds to the &#x60;id&#x60; field in &#x60;MailLogEntry&#x60; and to the &#x60;text&#x60; value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as &#x60;185997065c60008840&#x60;. | [optional parameter] |
| **messageId** | `String`| Filter by the &#x60;Message-ID&#x60; email header using a substring (case-insensitive) match.  The &#x60;Message-ID&#x60; is assigned by the sending mail client and is visible in the &#x60;messageId&#x60; field of &#x60;MailLogEntry&#x60;.  Useful when you know the message ID generated by your application but not the relay &#x60;mailid&#x60;. | [optional parameter] |
| **replyto** | `String`| Filter by the &#x60;Reply-To&#x60; message header address (exact match).  Only returns messages where this header was explicitly set. | [optional parameter] |
| **headerfrom** | `String`| Filter by the &#x60;From&#x60; message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope &#x60;from&#x60; parameter when sending on behalf of another address. | [optional parameter] |
| **delivered** | `Integer`| Filter by delivery status.  &#x60;1&#x60; returns only messages that were successfully delivered to the destination MX.  &#x60;0&#x60; returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. | [optional parameter] [enum: `0`, `1`] |
| **skip** | `Integer`| Number of records to skip for pagination.  Use in combination with &#x60;limit&#x60; to page through large result sets.  Defaults to &#x60;0&#x60; (no skip). | [optional parameter] [default to `0`] |
| **limit** | `Integer`| Maximum number of records to return per page.  Defaults to &#x60;100&#x60;. Maximum allowed value is &#x60;10000&#x60;.  The response also includes a &#x60;total&#x60; field with the full matched count so you can calculate the number of pages. | [optional parameter] [default to `100`] |
| **startDate** | `Long`| Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a &#x60;time&#x60; value **greater than or equal to** this value will be included. | [optional parameter] |
| **endDate** | `Long`| Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a &#x60;time&#x60; value **less than or equal to** this value will be included. | [optional parameter] |


### Return type
[**MailLog**](MailLog.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

