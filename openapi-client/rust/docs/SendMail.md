# SendMail

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **i64** | The ID of the Mail order within our system to use as the Mail Account. | 
**from** | [**crate::models::MailContact**](MailContact.md) |  | 
**to** | [**Vec<crate::models::MailContact>**](MailContact.md) | The Contact whom is the primary recipient of this email. | 
**subject** | **String** | The subject or title of the email | 
**body** | **String** | The main email contents. | 
**replyto** | Option<[**Vec<crate::models::MailContact>**](MailContact.md)> | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional]
**cc** | Option<[**Vec<crate::models::MailContact>**](MailContact.md)> | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional]
**bcc** | Option<[**Vec<crate::models::MailContact>**](MailContact.md)> | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional]
**attachments** | Option<[**Vec<crate::models::MailAttachment>**](MailAttachment.md)> | Optional file attachments to include in the email | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


