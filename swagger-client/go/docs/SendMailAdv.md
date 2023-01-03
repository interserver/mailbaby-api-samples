# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Subject** | **string** | The subject or title of the email | [default to null]
**Body** | **string** | The main email contents. | [default to null]
**From** | [***SendMailAdvFrom**](SendMailAdv_from.md) |  | [default to null]
**To** | [**[]SendMailAdvTo**](SendMailAdv_to.md) | A list of destionation email addresses to send this to | [default to null]
**Replyto** | [**[]SendMailAdvReplyto**](SendMailAdv_replyto.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to null]
**Cc** | [**[]SendMailAdvCc**](SendMailAdv_cc.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to null]
**Bcc** | [**[]SendMailAdvBcc**](SendMailAdv_bcc.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to null]
**Attachments** | [**[]SendMailAdvAttachments**](SendMailAdv_attachments.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to null]
**Id** | **int64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

