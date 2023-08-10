# openapi.api.SendingApi

## Load the API package
```dart
import 'package:openapi/api.dart';
```

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email


# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = SendingApi();
final subject = subject_example; // String | The subject or title of the email
final body = body_example; // String | The main email contents.
final from = ; // EmailAddressName | 
final to = []; // List<EmailAddressName> | A list of destionation email addresses to send this to
final replyto = []; // List<EmailAddressName> | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
final cc = []; // List<EmailAddressName> | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
final bcc = []; // List<EmailAddressName> | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
final attachments = []; // List<MailAttachment> | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
final id = 789; // int | (optional)  ID of the Mail order within our system to use as the Mail Account.

try {
    final result = api_instance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
    print(result);
} catch (e) {
    print('Exception when calling SendingApi->sendAdvMail: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**| The subject or title of the email | 
 **body** | **String**| The main email contents. | 
 **from** | [**EmailAddressName**](EmailAddressName.md)|  | 
 **to** | [**List<EmailAddressName>**](EmailAddressName.md)| A list of destionation email addresses to send this to | 
 **replyto** | [**List<EmailAddressName>**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **cc** | [**List<EmailAddressName>**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **bcc** | [**List<EmailAddressName>**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
 **attachments** | [**List<MailAttachment>**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **id** | **int**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```dart
import 'package:openapi/api.dart';
// TODO Configure API key authorization: apiKeyAuth
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKey = 'YOUR_API_KEY';
// uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//defaultApiClient.getAuthentication<ApiKeyAuth>('apiKeyAuth').apiKeyPrefix = 'Bearer';

final api_instance = SendingApi();
final to = to_example; // String | The Contact whom is the primary recipient of this email.
final from = from_example; // String | The contact whom is the this email is from.
final subject = subject_example; // String | The subject or title of the email
final body = body_example; // String | The main email contents.

try {
    final result = api_instance.sendMail(to, from, subject, body);
    print(result);
} catch (e) {
    print('Exception when calling SendingApi->sendMail: $e\n');
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **String**| The Contact whom is the primary recipient of this email. | 
 **from** | **String**| The contact whom is the this email is from. | 
 **subject** | **String**| The subject or title of the email | 
 **body** | **String**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

