# SEND_MAIL_ADV

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**STRING_32**](STRING_32.md) | The subject or title of the email | [default to null]
**body** | [**STRING_32**](STRING_32.md) | The main email contents. | [default to null]
**var_from** | [**SEND_MAIL_ADV_FROM**](SendMailAdv_from.md) |  | [default to null]
**to** | [**LIST [SEND_MAIL_ADV_TO_INNER]**](SendMailAdv_to_inner.md) | A list of destionation email addresses to send this to | [default to null]
**replyto** | [**LIST [SEND_MAIL_ADV_REPLYTO_INNER]**](SendMailAdv_replyto_inner.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to null]
**cc** | [**LIST [SEND_MAIL_ADV_CC_INNER]**](SendMailAdv_cc_inner.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to null]
**bcc** | [**LIST [SEND_MAIL_ADV_BCC_INNER]**](SendMailAdv_bcc_inner.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to null]
**attachments** | [**LIST [SEND_MAIL_ADV_ATTACHMENTS_INNER]**](SendMailAdv_attachments_inner.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null]
**id** | **INTEGER_64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


