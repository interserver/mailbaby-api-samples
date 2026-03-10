# EmailAddressName
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address. | 
**Name** | **String** | Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header). | [optional] 

## Examples

- Prepare the resource
```powershell
$EmailAddressName = Initialize-PSOpenAPIToolsEmailAddressName  -Email user@domain.com `
 -Name John Smith
```

- Convert the resource to JSON
```powershell
$EmailAddressName | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

