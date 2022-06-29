# MailLog
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Total** | **Int32** | total number of mail log entries | 
**Skip** | **Int32** | number of emails skipped in listing | 
**Limit** | **Int32** | number of emails to return | 
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

