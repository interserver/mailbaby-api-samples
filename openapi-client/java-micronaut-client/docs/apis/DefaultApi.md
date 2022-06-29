# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders |
| [**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running |
| [**sendAdvMail**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email |
| [**viewMailLog**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log |


## Creating DefaultApi

To initiate an instance of `DefaultApi`, you can use micronaut's `ApplicationContext`:
```java
/* imports
import io.micronaut.runtime.Micronaut;
import io.micronaut.context.ApplicationContext;
import org.openapitools.api.DefaultApi;
*/

ApplicationContext context = Micronaut.run(/* ... */);
PetApi apiInstance = context.getBean(DefaultApi.class);
```

Or the `@Inject` annotation:
```java
@Singleton
class MyClass {
    @Inject
    DefaultApi defaultApi;

    /* ... use the injected variable */
}
```
Note that the class needs to be annotated with one of Micronaut's [scope annotations](https://docs.micronaut.io/latest/guide/#scopes) like `Singleton` in order to be processed.

More information can be found inside [Inversion of Control guide section](https://docs.micronaut.io/latest/guide/#ioc).

<a name="getMailOrders"></a>
# **getMailOrders**
```java
Mono<List<GetMailOrders200ResponseInner>> DefaultApi.getMailOrders()
```

displays a list of mail service orders



### Return type
[**List&lt;GetMailOrders200ResponseInner&gt;**](GetMailOrders200ResponseInner.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

<a name="pingServer"></a>
# **pingServer**
```java
Mono<Void> DefaultApi.pingServer()
```

Checks if the server is running







### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="sendAdvMail"></a>
# **sendAdvMail**
```java
Mono<GenericResponse> DefaultApi.sendAdvMail(sendMailAdv)
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md)|  | |


### Return type
[**GenericResponse**](GenericResponse.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: `application/json`, `application/x-www-form-urlencoded`
 - **Accept**: `application/json`

<a name="sendMail"></a>
# **sendMail**
```java
Mono<GenericResponse> DefaultApi.sendMail(tofromsubject_body)
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

<a name="viewMailLog"></a>
# **viewMailLog**
```java
Mono<MailLog> DefaultApi.viewMailLog(idsearchskiplimit)
```

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Parameters
| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | `Long`| The ID of your mail order this will be sent through. | [optional parameter] |
| **search** | `String`| pass an optional search string for looking up inventory | [optional parameter] |
| **skip** | `Integer`| number of records to skip for pagination | [optional parameter] [default to `0`] |
| **limit** | `Integer`| maximum number of records to return | [optional parameter] [default to `100`] |


### Return type
[**MailLog**](MailLog.md)

### Authorization
* **[apiKeyAuth](auth.md#apiKeyAuth)**

### HTTP request headers
 - **Content-Type**: Not defined
 - **Accept**: `application/json`

