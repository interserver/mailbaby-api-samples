# IO.Swagger - the C# library for the Mail Baby API

This is an API defintion for accesssing the Mail.Baby mail service.

This C# SDK is automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen) project:

- API version: 1.0.0
- SDK version: 1.0.0
- Build package: io.swagger.codegen.v3.generators.dotnet.CSharpClientCodegen
    For more information, please visit [https://www.interserver.net/contact-information.html](https://www.interserver.net/contact-information.html)

<a name="frameworks-supported"></a>
## Frameworks supported
- .NET 4.0 or later
- Windows Phone 7.1 (Mango)

<a name="dependencies"></a>
## Dependencies
- [RestSharp](https://www.nuget.org/packages/RestSharp) - 105.1.0 or later
- [Json.NET](https://www.nuget.org/packages/Newtonsoft.Json/) - 7.0.0 or later
- [JsonSubTypes](https://www.nuget.org/packages/JsonSubTypes/) - 1.2.0 or later

The DLLs included in the package may not be the latest version. We recommend using [NuGet](https://docs.nuget.org/consume/installing-nuget) to obtain the latest version of the packages:
```
Install-Package RestSharp
Install-Package Newtonsoft.Json
Install-Package JsonSubTypes
```

NOTE: RestSharp versions greater than 105.1.0 have a bug which causes file uploads to fail. See [RestSharp#742](https://github.com/restsharp/RestSharp/issues/742)

<a name="installation"></a>
## Installation
Run the following command to generate the DLL
- [Mac/Linux] `/bin/sh build.sh`
- [Windows] `build.bat`

Then include the DLL (under the `bin` folder) in the C# project, and use the namespaces:
```csharp
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;
```
<a name="packaging"></a>
## Packaging

A `.nuspec` is included with the project. You can follow the Nuget quickstart to [create](https://docs.microsoft.com/en-us/nuget/quickstart/create-and-publish-a-package#create-the-package) and [publish](https://docs.microsoft.com/en-us/nuget/quickstart/create-and-publish-a-package#publish-the-package) packages.

This `.nuspec` uses placeholders from the `.csproj`, so build the `.csproj` directly:

```
nuget pack -Build -OutputDirectory out IO.Swagger.csproj
```

Then, publish to a [local feed](https://docs.microsoft.com/en-us/nuget/hosting-packages/local-feeds) or [other host](https://docs.microsoft.com/en-us/nuget/hosting-packages/overview) and consume the new package via Nuget as usual.

<a name="getting-started"></a>
## Getting Started

```csharp
using System;
using System.Diagnostics;
using IO.Swagger.Api;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace Example
{
    public class Example
    {
        public void main()
        {
            // Configure API key authorization: apiKeyAuth
            Configuration.Default.ApiKey.Add("X-API-KEY", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-KEY", "Bearer");
            // Configure API key authorization: apiLoginAuth
            Configuration.Default.ApiKey.Add("X-API-LOGIN", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-LOGIN", "Bearer");
            // Configure API key authorization: apiPasswordAuth
            Configuration.Default.ApiKey.Add("X-API-PASS", "YOUR_API_KEY");
            // Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
            // Configuration.Default.ApiKeyPrefix.Add("X-API-PASS", "Bearer");

            var apiInstance = new DefaultApi();
            var id = 789;  // long? | User ID

            try
            {
                // Gets mail order information by id
                MailOrder result = apiInstance.GetMailById(id);
                Debug.WriteLine(result);
            }
            catch (Exception e)
            {
                Debug.Print("Exception when calling DefaultApi.GetMailById: " + e.Message );
            }
        }
    }
}
```

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**GetMailById**](docs/DefaultApi.md#getmailbyid) | **GET** /mail/{id} | Gets mail order information by id
*DefaultApi* | [**GetMailOrders**](docs/DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**PingServer**](docs/DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**PlaceMailOrder**](docs/DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
*DefaultApi* | [**SendAdvMailById**](docs/DefaultApi.md#sendadvmailbyid) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
*DefaultApi* | [**SendMailById**](docs/DefaultApi.md#sendmailbyid) | **POST** /mail/{id}/send | Sends an Email
*DefaultApi* | [**ValidateMailOrder**](docs/DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
*DefaultApi* | [**ViewMailLogById**](docs/DefaultApi.md#viewmaillogbyid) | **GET** /mail/{id}/log | displays the mail log

<a name="documentation-for-models"></a>
## Documentation for Models

 - [Model.ErrorResponse](docs/ErrorResponse.md)
 - [Model.GenericResponse](docs/GenericResponse.md)
 - [Model.MailAttachment](docs/MailAttachment.md)
 - [Model.MailContact](docs/MailContact.md)
 - [Model.MailLog](docs/MailLog.md)
 - [Model.MailOrder](docs/MailOrder.md)
 - [Model.MailOrders](docs/MailOrders.md)
 - [Model.SendMail](docs/SendMail.md)
 - [Model.SendMailForm](docs/SendMailForm.md)

<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="apiKeyAuth"></a>
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

<a name="apiLoginAuth"></a>
### apiLoginAuth

- **Type**: API key
- **API key parameter name**: X-API-LOGIN
- **Location**: HTTP header

<a name="apiPasswordAuth"></a>
### apiPasswordAuth

- **Type**: API key
- **API key parameter name**: X-API-PASS
- **Location**: HTTP header
