# SendMail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | [default to null]
**Body** | **string** | The main email contents. | [default to null]
**From** | [**[]SendMailFrom**](SendMail_from.md) | The contact whom is the this email is from. | [default to null]
**To** | [**[]MailContact**](MailContact.md) | The Contact whom is the primary recipient of this email. | [default to null]
**Id** | **int64** | The ID of the Mail order within our system to use as the Mail Account. | [default to null]
**Replyto** | [**[]MailContact**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to null]
**Cc** | [**[]MailContact**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to null]
**Bcc** | [**[]MailContact**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to null]
**Attachments** | [**[]MailAttachment**](MailAttachment.md) | Optional file attachments to include in the email | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

