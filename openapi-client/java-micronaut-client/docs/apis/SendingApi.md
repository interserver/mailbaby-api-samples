# SendingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email |


## Creating SendingApi

To initiate an instance of `SendingApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.SendingApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(SendingApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    SendingApi sendingApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a id="sendAdvMail"></a>
# **sendAdvMail**
```java
Mono<GenericResponse> SendingApi.sendAdvMail(subject_bodyfromtoreplytoccbccattachmentsid)
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subject** | `String`| The subject or title of the email | |
| **_body** | `String`| The main email contents. | |
| **from** | [**EmailAddressName**](EmailAddressName.md)|  | |
| **to** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| A list of destionation email addresses to send this to | |
| **replyto** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional parameter] |
| **cc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional parameter] |
| **bcc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional parameter] |
| **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional parameter] |
| **id** | `Long`| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional parameter] |


### Return type
[**GenericResponse**](GenericResponse.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
 - **Accept**: `application/json`

<a id="sendMail"></a>
# **sendMail**
```java
Mono<GenericResponse> SendingApi.sendMail(tofromsubject_body)
```

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **to** | `String`| The Contact whom is the primary recipient of this email. | |
| **from** | `String`| The contact whom is the this email is from. | |
| **subject** | `String`| The subject or title of the email | |
| **_body** | `String`| The main email contents. | |


### Return type
[**GenericResponse**](GenericResponse.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
 - **Accept**: `application/json`

