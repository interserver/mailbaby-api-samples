# IO.Swagger.Api.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email

<a name="sendadvmail"></a>
# **SendAdvMail**
> GenericResponse SendAdvMail (string subject, string body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, long? id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/x-www-form-urlencoded' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data 'subject=Welcome' \\ - -data 'body=Hello' \\ - -data from=user@domain.com \\ - -data to=support@interserver.net ```  ```ArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/x-www-form-urlencoded' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data 'subject=Welcome' \\ - -data 'body=Hello' \\ - -data from=user@domain.com \\ - -data \"to[0][name]=Joe\" \\ - -data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/x-www-form-urlencoded' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data 'subject=Welcome' \\ - -data 'body=Hello' \\ - -data from=\"Joe <user@domain.com>\" \\ - -data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/x-www-form-urlencoded' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data 'subject=Welcome' \\ - -data 'body=Hello' \\ - -data from=user@domain.com \\ - -data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/x-www-form-urlencoded' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data 'subject=Welcome' \\ - -data 'body=Hello' \\ - -data from=user@domain.com \\ - -data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/x-www-form-urlencoded' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data 'subject=Welcome' \\ - -data 'body=Hello' \\ - -data from=user@domain.com \\ - -data \"to[0][name]=Joe\" \\ - -data \"to[0][email]=support@interserver.net\" \\ - -data \"to[1][name]=Joe\" \\ - -data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/json' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ```ArrayJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/json' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ```NameEmailJson curl -i - -request POST - -url https://api.mailbaby.net/mail/advsend \\ - -header 'Accept: application/json' \\ - -header 'Content-Type: application/json' \\ - -header 'X-API-KEY: YOUR_API_KEY' \\ - -data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 

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
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

            var apiInstance = new SendingApi();
            var subject = subject_example;  // string | 
            var body = body_example;  // string | 
            var from = new EmailAddressTypes(); // EmailAddressTypes | 
            var to = new EmailAddressesTypes(); // EmailAddressesTypes | 
            var replyto = new EmailAddressesTypes(); // EmailAddressesTypes | 
            var cc = new EmailAddressesTypes(); // EmailAddressesTypes | 
            var bcc = new EmailAddressesTypes(); // EmailAddressesTypes | 
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
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md)|  | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | 
 **attachments** | [**List&lt;MailAttachment&gt;**](MailAttachment.md)|  | 
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
            Configuration.Default.AddApiKey("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.AddApiKeyPrefix("X-API-KEY", "Bearer");

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
