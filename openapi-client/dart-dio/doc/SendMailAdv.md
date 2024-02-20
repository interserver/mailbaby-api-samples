# openapi.model.SendMailAdv

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject or title of the email | 
**body** | **String** | The main email contents. | 
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
**attachments** | [**BuiltList&lt;MailAttachment&gt;**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **int** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


