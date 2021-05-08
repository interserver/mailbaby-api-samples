# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**kotlin.String**](.md) | The subject or title of the email | 
**body** | [**kotlin.String**](.md) | The main email contents. | 
**from** | [**kotlin.Array&lt;SendMailAdvFrom&gt;**](SendMailAdvFrom.md) | The contact whom is the this email is from. | 
**to** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**id** | [**kotlin.Long**](.md) | The ID of the Mail order within our system to use as the Mail Account. | 
**replyto** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. |  [optional]
**cc** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. |  [optional]
**bcc** | [**kotlin.Array&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. |  [optional]
**attachments** | [**kotlin.Array&lt;MailAttachment&gt;**](MailAttachment.md) | Optional file attachments to include in the email |  [optional]
