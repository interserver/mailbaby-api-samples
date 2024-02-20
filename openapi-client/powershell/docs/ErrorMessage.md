# ErrorMessage
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Code** | **Int32** | The response code associated with the error. | 
**Message** | **String** | The details or description of the error. | 

## Examples

- Prepare the resource
```powershell
$ErrorMessage = Initialize-PSOpenAPIToolsErrorMessage  -Code 400 `
 -Message There was an error.
```

- Convert the resource to JSON
```powershell
$ErrorMessage | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

