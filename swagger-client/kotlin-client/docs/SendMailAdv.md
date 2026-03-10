# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | [**kotlin.String**](.md) | The subject line of the email. | 
**body** | [**kotlin.String**](.md) | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  |  [optional]
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  |  [optional]
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  |  [optional]
**attachments** | [**kotlin.Array&lt;MailAttachment&gt;**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. |  [optional]
**id** | [**kotlin.Long**](.md) | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. |  [optional]
