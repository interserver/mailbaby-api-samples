# openapi.model.SendMailAdv

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject line of the email. | 
**body** | **String** | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. | 
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) | The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object. | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects. | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`. | [optional] 
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients. | [optional] 
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) | Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header. | [optional] 
**attachments** | [**BuiltList&lt;MailAttachment&gt;**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. | [optional] 
**id** | **int** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


