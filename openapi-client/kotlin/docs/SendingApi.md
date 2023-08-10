# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email


<a id="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = SendingApi()
val subject : kotlin.String = subject_example // kotlin.String | The subject or title of the email
val body : kotlin.String = body_example // kotlin.String | The main email contents.
val from : EmailAddressName =  // EmailAddressName | 
val to : kotlin.collections.List<EmailAddressName> =  // kotlin.collections.List<EmailAddressName> | A list of destionation email addresses to send this to
val replyto : kotlin.collections.List<EmailAddressName> =  // kotlin.collections.List<EmailAddressName> | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
val cc : kotlin.collections.List<EmailAddressName> =  // kotlin.collections.List<EmailAddressName> | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
val bcc : kotlin.collections.List<EmailAddressName> =  // kotlin.collections.List<EmailAddressName> | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
val attachments : kotlin.collections.List<MailAttachment> =  // kotlin.collections.List<MailAttachment> | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
val id : kotlin.Long = 789 // kotlin.Long | (optional)  ID of the Mail order within our system to use as the Mail Account.
try {
    val result : GenericResponse = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#sendAdvMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#sendAdvMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **kotlin.String**| The subject or title of the email |
 **body** | **kotlin.String**| The main email contents. |
 **from** | [**EmailAddressName**](EmailAddressName.md)|  |
 **to** | [**kotlin.collections.List&lt;EmailAddressName&gt;**](EmailAddressName.md)| A list of destionation email addresses to send this to |
 **replyto** | [**kotlin.collections.List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional]
 **cc** | [**kotlin.collections.List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional]
 **bcc** | [**kotlin.collections.List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional]
 **attachments** | [**kotlin.collections.List&lt;MailAttachment&gt;**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional]
 **id** | **kotlin.Long**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a id="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```kotlin
// Import classes:
//import org.openapitools.client.infrastructure.*
//import org.openapitools.client.models.*

val apiInstance = SendingApi()
val to : kotlin.String = to_example // kotlin.String | The Contact whom is the primary recipient of this email.
val from : kotlin.String = from_example // kotlin.String | The contact whom is the this email is from.
val subject : kotlin.String = subject_example // kotlin.String | The subject or title of the email
val body : kotlin.String = body_example // kotlin.String | The main email contents.
try {
    val result : GenericResponse = apiInstance.sendMail(to, from, subject, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SendingApi#sendMail")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SendingApi#sendMail")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **kotlin.String**| The Contact whom is the primary recipient of this email. |
 **from** | **kotlin.String**| The contact whom is the this email is from. |
 **subject** | **kotlin.String**| The subject or title of the email |
 **body** | **kotlin.String**| The main email contents. |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization


Configure apiKeyAuth:
    ApiClient.apiKey["X-API-KEY"] = ""
    ApiClient.apiKeyPrefix["X-API-KEY"] = ""

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

