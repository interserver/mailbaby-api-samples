# OpenAPIClient::Object::SendMailAdv

## Load the model package
```perl
use OpenAPIClient::Object::SendMailAdv;
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **string** | The subject or title of the email | 
**body** | **string** | The main email contents. | 
**from** | [**SendMailAdvFrom**](SendMailAdvFrom.md) |  | 
**to** | [**ARRAY[SendMailAdvToInner]**](SendMailAdvToInner.md) | A list of destionation email addresses to send this to | 
**replyto** | [**ARRAY[SendMailAdvReplytoInner]**](SendMailAdvReplytoInner.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | [**ARRAY[SendMailAdvCcInner]**](SendMailAdvCcInner.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | [**ARRAY[SendMailAdvBccInner]**](SendMailAdvBccInner.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | [**ARRAY[SendMailAdvAttachmentsInner]**](SendMailAdvAttachmentsInner.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **int** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


