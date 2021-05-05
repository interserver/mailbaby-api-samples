# SEND_MAIL

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**STRING_32**](STRING_32.md) | The subject or title of the email | [default to null]
**body** | [**STRING_32**](STRING_32.md) | The main email contents. | [default to null]
**var_from** | [**LIST [SEND_MAIL_FROM]**](SendMail_from.md) | The contact whom is the this email is from. | [default to null]
**to** | [**LIST [MAIL_CONTACT]**](MailContact.md) | The Contact whom is the primary recipient of this email. | [default to null]
**id** | **INTEGER_64** | The ID of the Mail order within our system to use as the Mail Account. | [default to null]
**replyto** | [**LIST [MAIL_CONTACT]**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to null]
**cc** | [**LIST [MAIL_CONTACT]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to null]
**bcc** | [**LIST [MAIL_CONTACT]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to null]
**attachments** | [**LIST [MAIL_ATTACHMENT]**](MailAttachment.md) | Optional file attachments to include in the email | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


