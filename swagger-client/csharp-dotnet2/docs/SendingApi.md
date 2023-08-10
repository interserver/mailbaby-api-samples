# IO.Swagger.Api.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email

<a name="sendadvmail"></a>
# **SendAdvMail**
> GenericResponse SendAdvMail (string subject, string body, EmailAddressName from, List<EmailAddressName> to, List<EmailAddressName> replyto, List<EmailAddressName> cc, List<EmailAddressName> bcc, List<MailAttachment> attachments, long? id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SendAdvMailExample
    {
        public void main()
        {

            // Configure API key authorization: apiKeyAuth
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");

            var apiInstance = new SendingApi();
            var subject = subject_example;  // string | 
            var body = body_example;  // string | 
            var from = new EmailAddressName(); // EmailAddressName | 
            var to = new List<EmailAddressName>(); // List<EmailAddressName> | 
            var replyto = new List<EmailAddressName>(); // List<EmailAddressName> | 
            var cc = new List<EmailAddressName>(); // List<EmailAddressName> | 
            var bcc = new List<EmailAddressName>(); // List<EmailAddressName> | 
            var attachments = new List<MailAttachment>(); // List<MailAttachment> | 
            var id = 789;  // long? | 

            try
            {
                // Sends an Email with Advanced Options
                GenericResponse result = apiInstance.SendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SendingApi.SendAdvMail: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string**|  | 
 **body** | **string**|  | 
 **from** | [**EmailAddressName**](.md)|  | 
 **to** | [**List<EmailAddressName>**](EmailAddressName.md)|  | 
 **replyto** | [**List<EmailAddressName>**](EmailAddressName.md)|  | 
 **cc** | [**List<EmailAddressName>**](EmailAddressName.md)|  | 
 **bcc** | [**List<EmailAddressName>**](EmailAddressName.md)|  | 
 **attachments** | [**List<MailAttachment>**](MailAttachment.md)|  | 
 **id** | **long?**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="sendmail"></a>
# **SendMail**
> GenericResponse SendMail (string to, string from, string subject, string body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class SendMailExample
    {
        public void main()
        {

            // Configure API key authorization: apiKeyAuth
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");

            var apiInstance = new SendingApi();
            var to = to_example;  // string | 
            var from = from_example;  // string | 
            var subject = subject_example;  // string | 
            var body = body_example;  // string | 

            try
            {
                // Sends an Email
                GenericResponse result = apiInstance.SendMail(to, from, subject, body);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling SendingApi.SendMail: " + e.Message );
            }
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**|  | 
 **from** | **string**|  | 
 **subject** | **string**|  | 
 **body** | **string**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

