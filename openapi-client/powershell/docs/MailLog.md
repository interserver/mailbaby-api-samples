# MailLog
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Total** | **Int32** | Total number of log entries that match the supplied filters, regardless of &#x60;skip&#x60; and &#x60;limit&#x60;.  Use this to calculate the number of pages: &#x60;ceil(total / limit)&#x60;. | 
**Skip** | **Int32** | The &#x60;skip&#x60; value used for this page (echoed from the request). | 
**Limit** | **Int32** | The &#x60;limit&#x60; value used for this page (echoed from the request). | 
**Emails** | [**MailLogEntry[]**](MailLogEntry.md) |  | 

## Examples

- Prepare the resource
```powershell
$MailLog = Initialize-PSOpenAPIToolsMailLog  -Total 10234 `
 -Skip 0 `
 -Limit 100 `
 -Emails null
```

- Convert the resource to JSON
```powershell
$MailLog | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

