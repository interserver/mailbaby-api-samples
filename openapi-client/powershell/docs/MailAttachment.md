# MailAttachment
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filename** | **String** | Optional filename to specify for the attachment. | [optional] 
**VarData** | **System.IO.FileInfo** | Contents of the attached file | 

## Examples

- Prepare the resource
```powershell
$MailAttachment = Initialize-PSOpenAPIToolsMailAttachment  -Filename company_logo.png `
 -VarData null
```

- Convert the resource to JSON
```powershell
$MailAttachment | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

