# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**kotlin.String**](.md) | The subject or title of the email | 
**body** | [**kotlin.String**](.md) | The main email contents. | 
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  |  [optional]
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  |  [optional]
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  |  [optional]
**attachments** | [**kotlin.Array&lt;MailAttachment&gt;**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! |  [optional]
**id** | [**kotlin.Long**](.md) | (optional)  ID of the Mail order within our system to use as the Mail Account. |  [optional]
