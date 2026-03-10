# SendMailAdv
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **String** | The subject line of the email. | 
**Body** | **String** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**VarFrom** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**To** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**Replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Attachments** | [**MailAttachment[]**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] 
**Id** | **Int64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdv = Initialize-PSOpenAPIToolsSendMailAdv  -Subject Your Package has been Delivered! `
 -Body The package you ordered on 2021-01-23 has been delivered. `
 -VarFrom null `
 -To null `
 -Replyto null `
 -Cc null `
 -Bcc null `
 -Attachments null `
 -Id 5000
```

- Convert the resource to JSON
```powershell
$SendMailAdv | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

