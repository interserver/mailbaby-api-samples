# ErrorResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Code** | **String** |  | 
**Message** | **String** |  | 

## Examples

- Prepare the resource
```powershell
$ErrorResponse = Initialize-PSOpenAPIToolsErrorResponse  -Code null `
 -Message null
```

- Convert the resource to JSON
```powershell
$ErrorResponse | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

