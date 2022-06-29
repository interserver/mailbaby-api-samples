# SendMailAdvFrom
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address | 
**Name** | **String** | (optional) Name to use for the sending contact. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdvFrom = Initialize-PSOpenAPIToolsSendMailAdvFrom  -Email business@company.com `
 -Name The Man
```

- Convert the resource to JSON
```powershell
$SendMailAdvFrom | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

