
# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **kotlin.String** | The subject or title of the email | 
**body** | **kotlin.String** | The main email contents. | 
**from** | [**SendMailAdvFrom**](SendMailAdvFrom.md) |  | 
**to** | [**kotlin.collections.List&lt;SendMailAdvToInner&gt;**](SendMailAdvToInner.md) | A list of destionation email addresses to send this to | 
**replyto** | [**kotlin.collections.List&lt;SendMailAdvReplytoInner&gt;**](SendMailAdvReplytoInner.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. |  [optional]
**cc** | [**kotlin.collections.List&lt;SendMailAdvCcInner&gt;**](SendMailAdvCcInner.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. |  [optional]
**bcc** | [**kotlin.collections.List&lt;SendMailAdvBccInner&gt;**](SendMailAdvBccInner.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. |  [optional]
**attachments** | [**kotlin.collections.List&lt;SendMailAdvAttachmentsInner&gt;**](SendMailAdvAttachmentsInner.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! |  [optional]
**id** | **kotlin.Long** | (optional)  ID of the Mail order within our system to use as the Mail Account. |  [optional]



