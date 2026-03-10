# MailLog

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | [**kotlin.Int**](.md) | Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;. | 
**skip** | [**kotlin.Int**](.md) | The &#x60;skip&#x60; value used for this page (echoed from the request). | 
**limit** | [**kotlin.Int**](.md) | The &#x60;limit&#x60; value used for this page (echoed from the request). | 
**emails** | [**kotlin.Array&lt;MailLogEntry&gt;**](MailLogEntry.md) |  | 
