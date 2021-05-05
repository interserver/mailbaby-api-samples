# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **string** | The subject or title of the email | 
**body** | **string** | The main email contents. | 
**from** | [**\Interserver\Mailbaby\Model\SendMailAdvFrom[]**](SendMailAdvFrom.md) | The contact whom is the this email is from. | 
**to** | [**\Interserver\Mailbaby\Model\MailContact[]**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**id** | **int** | The ID of the Mail order within our system to use as the Mail Account. | 
**replyto** | [**\Interserver\Mailbaby\Model\MailContact[]**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**\Interserver\Mailbaby\Model\MailContact[]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**\Interserver\Mailbaby\Model\MailContact[]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**\Interserver\Mailbaby\Model\MailAttachment[]**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 

[[Back to Model list]](../../README.md#documentation-for-models) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to README]](../../README.md)

