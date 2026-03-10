# MailBlockRspamd
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**VarFrom** | **String** | The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender. | 
**Subject** | **String** | The suspicious subject pattern that triggered the block. | 

## Examples

- Prepare the resource
```powershell
$MailBlockRspamd = Initialize-PSOpenAPIToolsMailBlockRspamd  -VarFrom user@domain.com `
 -Subject Test email
```

- Convert the resource to JSON
```powershell
$MailBlockRspamd | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

