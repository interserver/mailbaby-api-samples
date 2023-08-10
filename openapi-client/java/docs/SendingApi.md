# SendingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email |


<a id="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SendingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    SendingApi apiInstance = new SendingApi(defaultClient);
    String subject = "subject_example"; // String | The subject or title of the email
    String body = "body_example"; // String | The main email contents.
    EmailAddressName from = new EmailAddressName(); // EmailAddressName | 
    List<EmailAddressName> to = Arrays.asList(); // List<EmailAddressName> | A list of destionation email addresses to send this to
    List<EmailAddressName> replyto = Arrays.asList(); // List<EmailAddressName> | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
    List<EmailAddressName> cc = Arrays.asList(); // List<EmailAddressName> | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
    List<EmailAddressName> bcc = Arrays.asList(); // List<EmailAddressName> | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
    List<MailAttachment> attachments = Arrays.asList(); // List<MailAttachment> | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
    Long id = 56L; // Long | (optional)  ID of the Mail order within our system to use as the Mail Account.
    try {
      GenericResponse result = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SendingApi#sendAdvMail");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subject** | **String**| The subject or title of the email | |
| **body** | **String**| The main email contents. | |
| **from** | [**EmailAddressName**](EmailAddressName.md)|  | |
| **to** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| A list of destionation email addresses to send this to | |
| **replyto** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] |
| **cc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] |
| **bcc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] |
| **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] |
| **id** | **Long**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] |

### Return type

[**GenericResponse**](GenericResponse.md)

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

<a id="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.SendingApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    SendingApi apiInstance = new SendingApi(defaultClient);
    String to = "to_example"; // String | The Contact whom is the primary recipient of this email.
    String from = "from_example"; // String | The contact whom is the this email is from.
    String subject = "subject_example"; // String | The subject or title of the email
    String body = "body_example"; // String | The main email contents.
    try {
      GenericResponse result = apiInstance.sendMail(to, from, subject, body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SendingApi#sendMail");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **to** | **String**| The Contact whom is the primary recipient of this email. | |
| **from** | **String**| The contact whom is the this email is from. | |
| **subject** | **String**| The subject or title of the email | |
| **body** | **String**| The main email contents. | |

### Return type

[**GenericResponse**](GenericResponse.md)

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

