# MailBabyApi.SendMail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Number** | The ID of the Mail order within our system to use as the Mail Account. | 
**from** | [**MailContact**](MailContact.md) |  | 
**to** | [**[MailContact]**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**subject** | **String** | The subject or title of the email | 
**body** | **String** | The main email contents. | 
**replyto** | [**[MailContact]**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**[MailContact]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**[MailContact]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**[MailAttachment]**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 


