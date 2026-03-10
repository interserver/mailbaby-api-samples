# MailAttachment
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Filename** | **String** | The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;). | 
**VarData** | [**SystemByte**](SystemByte.md) | The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. | 

## Examples

- Prepare the resource
```powershell
$MailAttachment = Initialize-PSOpenAPIToolsMailAttachment  -Filename message.txt `
 -VarData [B@3ae126d1
```

- Convert the resource to JSON
```powershell
$MailAttachment | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

