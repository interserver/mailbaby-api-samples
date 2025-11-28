# SendMailRaw
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**RawEmail** | **String** | The entire email contents | 
**Id** | **Int32** | Optional order id | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailRaw = Initialize-PSOpenAPIToolsSendMailRaw  -RawEmail null `
 -Id null
```

- Convert the resource to JSON
```powershell
$SendMailRaw | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

