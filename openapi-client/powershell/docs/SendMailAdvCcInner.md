# SendMailAdvCcInner
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Email** | **String** | The email address | 
**Name** | **String** | (optional) Name to use for the CC contact. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdvCcInner = Initialize-PSOpenAPIToolsSendMailAdvCcInner  -Email janedoe@isp.com `
 -Name Jane Doe
```

- Convert the resource to JSON
```powershell
$SendMailAdvCcInner | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

