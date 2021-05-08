# openapi.model.SendMailAdv

## Load the model package
```dart
import 'package:openapi/api.dart';
```

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **String** | The subject or title of the email | [default to null]
**body** | **String** | The main email contents. | [default to null]
**from** | [**List&lt;SendMailAdvFrom&gt;**](SendMailAdvFrom.md) | The contact whom is the this email is from. | [default to const []]
**to** | [**List&lt;MailContact&gt;**](MailContact.md) | The Contact whom is the primary recipient of this email. | [default to const []]
**id** | **int** | The ID of the Mail order within our system to use as the Mail Account. | [default to null]
**replyto** | [**List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. | [optional] [default to const []]
**cc** | [**List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] [default to const []]
**bcc** | [**List&lt;MailContact&gt;**](MailContact.md) | Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] [default to const []]
**attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md) | Optional file attachments to include in the email | [optional] [default to const []]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


