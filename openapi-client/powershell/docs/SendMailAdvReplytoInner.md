# SendMailAdvReplytoInner
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address | 
**Name** | **String** | (optional) Name to use for the sending contact. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdvReplytoInner = Initialize-PSOpenAPIToolsSendMailAdvReplytoInner  -Email support@company.com `
 -Name Support Staff
```

- Convert the resource to JSON
```powershell
$SendMailAdvReplytoInner | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

