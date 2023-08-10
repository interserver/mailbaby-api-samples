# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
String subject = "subject_example"; // String | 
String body = "body_example"; // String | 
EmailAddressName from = new EmailAddressName(); // EmailAddressName | 
List<EmailAddressName> to = Arrays.asList(new EmailAddressName()); // List<EmailAddressName> | 
List<EmailAddressName> replyto = Arrays.asList(new EmailAddressName()); // List<EmailAddressName> | 
List<EmailAddressName> cc = Arrays.asList(new EmailAddressName()); // List<EmailAddressName> | 
List<EmailAddressName> bcc = Arrays.asList(new EmailAddressName()); // List<EmailAddressName> | 
List<MailAttachment> attachments = Arrays.asList(new MailAttachment()); // List<MailAttachment> | 
Long id = 789L; // Long | 
try {
    GenericResponse result = apiInstance.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendAdvMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **String**|  |
 **body** | **String**|  |
 **from** | [**EmailAddressName**](.md)|  |
 **to** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **replyto** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **cc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **bcc** | [**List&lt;EmailAddressName&gt;**](EmailAddressName.md)|  |
 **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)|  |
 **id** | **Long**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendAdvMail"></a>
# **sendAdvMail**
> GenericResponse sendAdvMail(body)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
SendMailAdv body = new SendMailAdv(); // SendMailAdv | 
try {
    GenericResponse result = apiInstance.sendAdvMail(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendAdvMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMailAdv**](SendMailAdv.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
String to = "to_example"; // String | 
String from = "from_example"; // String | 
String subject = "subject_example"; // String | 
String body = "body_example"; // String | 
try {
    GenericResponse result = apiInstance.sendMail(to, from, subject, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **String**|  |
 **from** | **String**|  |
 **subject** | **String**|  |
 **body** | **String**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="sendMail"></a>
# **sendMail**
> GenericResponse sendMail(body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.SendingApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKeyAuth
ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
apiKeyAuth.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.setApiKeyPrefix("Token");

SendingApi apiInstance = new SendingApi();
SendMail body = new SendMail(); // SendMail | 
try {
    GenericResponse result = apiInstance.sendMail(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SendingApi#sendMail");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SendMail**](SendMail.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

