# MailStatsTypeVolume
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | **System.Collections.Hashtable** | Message counts keyed by destination (envelope &#x60;to&#x60;) email address. | [optional] 
**VarFrom** | **System.Collections.Hashtable** | Message counts keyed by sender (envelope &#x60;from&#x60;) email address. | [optional] 
**Ip** | **System.Collections.Hashtable** | Message counts keyed by originating client IP address. | [optional] 

## Examples

- Prepare the resource
```powershell
$MailStatsTypeVolume = Initialize-PSOpenAPIToolsMailStatsTypeVolume  -To null `
 -VarFrom null `
 -Ip null
```

- Convert the resource to JSON
```powershell
$MailStatsTypeVolume | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

