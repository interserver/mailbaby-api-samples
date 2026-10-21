# OAIMailLog

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**total** | **NSNumber*** | Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;. | 
**skip** | **NSNumber*** | The &#x60;skip&#x60; value used for this page (echoed from the request). | 
**limit** | **NSNumber*** | The &#x60;limit&#x60; value used for this page (echoed from the request). | 
**emails** | [**NSArray&lt;OAIMailLogEntry&gt;***](OAIMailLogEntry.md) |  | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


