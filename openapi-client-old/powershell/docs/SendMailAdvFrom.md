# SendMailAdvFrom
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address | 
**Name** | **String** | Optional contact name | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdvFrom = Initialize-PSOpenAPIToolsSendMailAdvFrom  -Email johndoe@company.com `
 -Name John Doe
```

- Convert the resource to JSON
```powershell
$SendMailAdvFrom | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

