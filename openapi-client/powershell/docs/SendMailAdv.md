# SendMailAdv
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **String** | The subject or title of the email | 
**Body** | **String** | The main email contents. | 
**VarFrom** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**To** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**Replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**Attachments** | [**MailAttachment[]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**Id** | **Int64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMailAdv = Initialize-PSOpenAPIToolsSendMailAdv  -Subject Your Package has been Delivered! `
 -Body The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. `
 -VarFrom null `
 -To null `
 -Replyto null `
 -Cc null `
 -Bcc null `
 -Attachments [
        {
            &quot;filename&quot;: &quot;text.txt&quot;,
            &quot;data&quot;: &quot;base64_encoded_contents&quot;
        }
] `
 -Id 5000
```

- Convert the resource to JSON
```powershell
$SendMailAdv | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

