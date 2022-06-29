# SendMailAdvToInner
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address | 
**Name** | **String** | (optional) Name to use for the destination contact. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdvToInner = Initialize-PSOpenAPIToolsSendMailAdvToInner  -Email johndoe@isp.com `
 -Name John Doe
```

- Convert the resource to JSON
```powershell
$SendMailAdvToInner | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

