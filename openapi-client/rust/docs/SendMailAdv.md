# SendMailAdv

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject line of the email. | 
**body** | **String** | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. | 
**from** | [**models::EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**models::EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | Option<[**models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**cc** | Option<[**models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**bcc** | Option<[**models::EmailAddressesTypes**](EmailAddressesTypes.md)> |  | [optional]
**attachments** | Option<[**Vec<models::MailAttachment>**](MailAttachment.md)> | Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. | [optional]
**id** | Option<**i64**> | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


