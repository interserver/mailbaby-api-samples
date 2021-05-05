# SendMail
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **String** | The subject or title of the email | 
**Body** | **String** | The main email contents. | 
**VarFrom** | [**SendMailFrom[]**](SendMailFrom.md) | The contact whom is the this email is from. | 
**To** | [**MailContact[]**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**Id** | **Int64** | The ID of the Mail order within our system to use as the Mail Account. | 
**Replyto** | [**MailContact[]**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**Cc** | [**MailContact[]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**Bcc** | [**MailContact[]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**Attachments** | [**MailAttachment[]**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMail = Initialize-PSOpenAPIToolsSendMail  -Subject Your Package has been Delivered! `
 -Body The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
 `
 -VarFrom null `
 -To null `
 -Id 5000 `
 -Replyto null `
 -Cc null `
 -Bcc null `
 -Attachments null
```

- Convert the resource to JSON
```powershell
$SendMail | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

