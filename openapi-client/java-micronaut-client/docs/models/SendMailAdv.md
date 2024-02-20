

# SendMailAdv

Details for an Email

The class is defined in **[SendMailAdv.java](../../src/main/java/org/openapitools/model/SendMailAdv.java)**

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | `String` | The subject or title of the email | 
**_body** | `String` | The main email contents. | 
**from** | [`EmailAddressTypes`](EmailAddressTypes.md) |  | 
**to** | [`EmailAddressesTypes`](EmailAddressesTypes.md) |  | 
**replyto** | [`EmailAddressesTypes`](EmailAddressesTypes.md) |  |  [optional property]
**cc** | [`EmailAddressesTypes`](EmailAddressesTypes.md) |  |  [optional property]
**bcc** | [`EmailAddressesTypes`](EmailAddressesTypes.md) |  |  [optional property]
**attachments** | [`List&lt;MailAttachment&gt;`](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! |  [optional property]
**id** | `Long` | (optional)  ID of the Mail order within our system to use as the Mail Account. |  [optional property]











