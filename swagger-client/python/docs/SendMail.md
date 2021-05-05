# SendMail

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **str** | The subject or title of the email | 
**body** | **str** | The main email contents. | 
**_from** | [**MailContact**](MailContact.md) |  | 
**to** | [**list[MailContact]**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**id** | **int** | The ID of the Mail order within our system to use as the Mail Account. | 
**replyto** | [**list[MailContact]**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**list[MailContact]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**list[MailContact]**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**list[MailAttachment]**](MailAttachment.md) | Optional file attachments to include in the email | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

