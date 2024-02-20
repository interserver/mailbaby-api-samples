# EmailAddressTypes
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address. | 
**Name** | **String** | Name to use for the sending contact. | [optional] 

## Examples

- Prepare the resource
```powershell
$EmailAddressTypes = Initialize-PSOpenAPIToolsEmailAddressTypes  -Email user@domain.com `
 -Name John Smith
```

- Convert the resource to JSON
```powershell
$EmailAddressTypes | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

