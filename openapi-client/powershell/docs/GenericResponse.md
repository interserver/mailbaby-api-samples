# GenericResponse
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Status** | **String** |  | [optional] 
**Text** | **String** |  | [optional] 

## Examples

- Prepare the resource
```powershell
$GenericResponse = Initialize-PSOpenAPIToolsGenericResponse  -Status ok `
 -Text The command completed successfully.
```

- Convert the resource to JSON
```powershell
$GenericResponse | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

