# GetStats200ResponseInner
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **Int32** |  | 
**Status** | **String** |  | 
**Username** | **String** |  | 
**Password** | **String** |  | [optional] 
**Comment** | **String** |  | [optional] 

## Examples

- Prepare the resource
```powershell
$GetStats200ResponseInner = Initialize-PSOpenAPIToolsGetStats200ResponseInner  -Id 1234 `
 -Status active `
 -Username mb1234 `
 -Password guest123 `
 -Comment main mail account
```

- Convert the resource to JSON
```powershell
$GetStats200ResponseInner | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

