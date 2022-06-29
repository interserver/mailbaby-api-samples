# send_mail_adv_t

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **char \*** | The subject or title of the email | 
**body** | **char \*** | The main email contents. | 
**from** | [**send_mail_adv_from_t**](send_mail_adv_from.md) \* |  | 
**to** | [**list_t**](send_mail_adv_to_inner.md) \* | A list of destionation email addresses to send this to | 
**replyto** | [**list_t**](send_mail_adv_replyto_inner.md) \* | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**list_t**](send_mail_adv_cc_inner.md) \* | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**list_t**](send_mail_adv_bcc_inner.md) \* | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**list_t**](send_mail_adv_attachments_inner.md) \* | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **long** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


