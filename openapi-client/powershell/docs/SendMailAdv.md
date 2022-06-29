# SendMailAdv
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **String** | The subject or title of the email | 
**Body** | **String** | The main email contents. | 
**VarFrom** | [**SendMailAdvFrom**](SendMailAdvFrom.md) |  | 
**To** | [**SendMailAdvToInner[]**](SendMailAdvToInner.md) | A list of destionation email addresses to send this to | 
**Replyto** | [**SendMailAdvReplytoInner[]**](SendMailAdvReplytoInner.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**Cc** | [**SendMailAdvCcInner[]**](SendMailAdvCcInner.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**Bcc** | [**SendMailAdvBccInner[]**](SendMailAdvBccInner.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**Attachments** | [**SendMailAdvAttachmentsInner[]**](SendMailAdvAttachmentsInner.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
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
 -Attachments null `
 -Id 5000
```

- Convert the resource to JSON
```powershell
$SendMailAdv | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

