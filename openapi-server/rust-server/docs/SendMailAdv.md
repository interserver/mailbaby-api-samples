# SendMailAdv

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject line of the email. | 
**body** | **String** | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. | 
**from** | [***models::EmailAddressTypes**](EmailAddressTypes.md) | The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. | 
**to** | [***models::EmailAddressesTypes**](EmailAddressesTypes.md) | One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | 
**replyto** | [***models::EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. | [optional] [default to None]
**cc** | [***models::EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. | [optional] [default to None]
**bcc** | [***models::EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] [default to None]
**attachments** | [**Vec<models::MailAttachment>**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. | [optional] [default to None]
**id** | **i64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. | [optional] [default to None]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


