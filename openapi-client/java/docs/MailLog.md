

# MailLog

Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**total** | **Integer** | Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;. |  |
|**skip** | **Integer** | The &#x60;skip&#x60; value used for this page (echoed from the request). |  |
|**limit** | **Integer** | The &#x60;limit&#x60; value used for this page (echoed from the request). |  |
|**emails** | [**List&lt;MailLogEntry&gt;**](MailLogEntry.md) |  |  |



