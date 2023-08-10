# MailBabyEmailDeliveryAndManagementServiceApi.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email



## sendAdvMail

> GenericResponse sendAdvMail(subject, body, from, to, opts)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.SendingApi();
let subject = "subject_example"; // String | The subject or title of the email
let body = "body_example"; // String | The main email contents.
let from = new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName(); // EmailAddressName | 
let to = [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()]; // [EmailAddressName] | A list of destionation email addresses to send this to
let opts = {
  'replyto': [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()], // [EmailAddressName] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
  'cc': [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()], // [EmailAddressName] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  'bcc': [new MailBabyEmailDeliveryAndManagementServiceApi.EmailAddressName()], // [EmailAddressName] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  'attachments': [new MailBabyEmailDeliveryAndManagementServiceApi.MailAttachment()], // [MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
  'id': 789 // Number | (optional)  ID of the Mail order within our system to use as the Mail Account.
};
apiInstance.sendAdvMail(subject, body, from, to, opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**| The subject or title of the email | 
 **body** | **String**| The main email contents. | 
 **from** | [**EmailAddressName**](EmailAddressName.md)|  | 
 **to** | [**[EmailAddressName]**](EmailAddressName.md)| A list of destionation email addresses to send this to | 
 **replyto** | [**[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **cc** | [**[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **bcc** | [**[EmailAddressName]**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
 **attachments** | [**[MailAttachment]**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **id** | **Number**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json


## sendMail

> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.SendingApi();
let to = "to_example"; // String | The Contact whom is the primary recipient of this email.
let from = "from_example"; // String | The contact whom is the this email is from.
let subject = "subject_example"; // String | The subject or title of the email
let body = "body_example"; // String | The main email contents.
apiInstance.sendMail(to, from, subject, body, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
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

