# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendAdvMailWithHttpInfo**](SendingApi.md#sendAdvMailWithHttpInfo) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**sendMailWithHttpInfo**](SendingApi.md#sendMailWithHttpInfo) | **POST** /mail/send | Sends an Email



## sendAdvMail

> sendAdvMail(sendAdvMailRequest): ApiRequest[GenericResponse]

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```scala
// Import classes:
import 
import 
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = SendingApi("https://api.mailbaby.net")
    val subject: String = subject_example // String | The subject or title of the email

    val body: String = body_example // String | The main email contents.

    val from: EmailAddressName =  // EmailAddressName | 

    val to: Seq[EmailAddressName] =  // Seq[EmailAddressName] | A list of destionation email addresses to send this to

    val replyto: Seq[EmailAddressName] =  // Seq[EmailAddressName] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.

    val cc: Seq[EmailAddressName] =  // Seq[EmailAddressName] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.

    val bcc: Seq[EmailAddressName] =  // Seq[EmailAddressName] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.

    val attachments: Seq[MailAttachment] =  // Seq[MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded!

    val id: Long = 789 // Long | (optional)  ID of the Mail order within our system to use as the Mail Account.
    
    val request = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling SendingApi#sendAdvMail")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling SendingApi#sendAdvMail")
            exception.printStackTrace();
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**| The subject or title of the email |
 **body** | **String**| The main email contents. |
 **from** | [**EmailAddressName**](EmailAddressName.md)|  |
 **to** | [**Seq[EmailAddressName]**](EmailAddressName.md)| A list of destionation email addresses to send this to |
 **replyto** | [**Seq[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional]
 **cc** | [**Seq[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional]
 **bcc** | [**Seq[EmailAddressName]**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional]
 **attachments** | [**Seq[MailAttachment]**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional]
 **id** | **Long**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional]

### Return type

ApiRequest[[**GenericResponse**](GenericResponse.md)]


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |


## sendMail

> sendMail(sendMailRequest): ApiRequest[GenericResponse]

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example

```scala
// Import classes:
import 
import 
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

import akka.actor.ActorSystem
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Example extends App {
    
    implicit val system: ActorSystem = ActorSystem()
    import system.dispatcher
    
    // Configure API key authorization: apiKeyAuth
    implicit val apiKeyAuth: ApiKeyValue = ApiKeyValue("YOUR API KEY")

    val apiInvoker = ApiInvoker()
    val apiInstance = SendingApi("https://api.mailbaby.net")
    val to: String = to_example // String | The Contact whom is the primary recipient of this email.

    val from: String = from_example // String | The contact whom is the this email is from.

    val subject: String = subject_example // String | The subject or title of the email

    val body: String = body_example // String | The main email contents.
    
    val request = apiInstance.sendMail(to, from, subject, body)
    val response = apiInvoker.execute(request)

    response.onComplete {
        case Success(ApiResponse(code, content, headers)) =>
            System.out.println(s"Status code: $code}")
            System.out.println(s"Response headers: ${headers.mkString(", ")}")
            System.out.println(s"Response body: $content")
        
        case Failure(error @ ApiError(code, message, responseContent, cause, headers)) =>
            System.err.println("Exception when calling SendingApi#sendMail")
            System.err.println(s"Status code: $code}")
            System.err.println(s"Reason: $responseContent")
            System.err.println(s"Response headers: ${headers.mkString(", ")}")
            error.printStackTrace();

        case Failure(exception) => 
            System.err.println("Exception when calling SendingApi#sendMail")
            exception.printStackTrace();
    }
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

ApiRequest[[**GenericResponse**](GenericResponse.md)]


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

