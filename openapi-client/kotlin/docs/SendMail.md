
# SendMail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **kotlin.String** | The subject or title of the email | 
**body** | **kotlin.String** | The main email contents. | 
**from** | [**MailContact**](MailContact.md) |  | 
**to** | [**kotlin.collections.List&lt;MailContact&gt;**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**id** | **kotlin.Long** | The ID of the Mail order within our system to use as the Mail Account. | 
**replyto** | [**kotlin.collections.List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. |  [optional]
**cc** | [**kotlin.collections.List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. |  [optional]
**bcc** | [**kotlin.collections.List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. |  [optional]
**attachments** | [**kotlin.collections.List&lt;MailAttachment&gt;**](MailAttachment.md) | Optional file attachments to include in the email |  [optional]



