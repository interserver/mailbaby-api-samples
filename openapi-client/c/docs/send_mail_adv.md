# send_mail_adv_t

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **char \*** | The subject or title of the email | 
**body** | **char \*** | The main email contents. | 
**from** | [**list_t**](send_mail_adv_from.md) \* | The contact whom is the this email is from. | 
**to** | [**list_t**](mail_contact.md) \* | The Contact whom is the primary recipient of this email. | 
**id** | **long** | The ID of the Mail order within our system to use as the Mail Account. | 
**replyto** | [**list_t**](mail_contact.md) \* | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**list_t**](mail_contact.md) \* | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**list_t**](mail_contact.md) \* | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**list_t**](mail_attachment.md) \* | Optional file attachments to include in the email | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


