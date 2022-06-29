# SendMailAdvBccInner
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address | 
**Name** | **String** | (optional) Name to use for the BCC contact. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdvBccInner = Initialize-PSOpenAPIToolsSendMailAdvBccInner  -Email records@company.com `
 -Name Records Department
```

- Convert the resource to JSON
```powershell
$SendMailAdvBccInner | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

