# SendMailAdvAttachmentsInner
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filename** | **String** | (optional) Filename to specify for the attachment. | [optional] 
**VarData** | **System.IO.FileInfo** | Contents of the attached file (must be base64 encoded) | 

## Examples

- Prepare the resource
```powershell
$SendMailAdvAttachmentsInner = Initialize-PSOpenAPIToolsSendMailAdvAttachmentsInner  -Filename company_logo.png `
 -VarData null
```

- Convert the resource to JSON
```powershell
$SendMailAdvAttachmentsInner | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

