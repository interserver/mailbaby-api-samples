# openapi-java-client

MailBaby Email Delivery API
- API version: 1.0.0
  - Build date: 2022-06-28T22:22:37.530535-04:00[America/New_York]

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**


# 📌 Overview

This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).


# 🔐 Authentication

In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.  

We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.


  For more information, please visit [https://www.mail.baby/contact/](https://www.mail.baby/contact/)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.openapitools</groupId>
  <artifactId>openapi-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'openapi-java-client' jar has been published to maven central.
    mavenLocal()       // Needed if the 'openapi-java-client' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.openapitools:openapi-java-client:1.0.0"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/openapi-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.mailbaby.net");
    
    // Configure API key authorization: apiKeyAuth
    ApiKeyAuth apiKeyAuth = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyAuth");
    apiKeyAuth.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //apiKeyAuth.setApiKeyPrefix("Token");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<GetMailOrders200ResponseInner> result = apiInstance.getMailOrders();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#getMailOrders");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**getMailOrders**](docs/DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**pingServer**](docs/DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**sendAdvMail**](docs/DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*DefaultApi* | [**sendMail**](docs/DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
*DefaultApi* | [**viewMailLog**](docs/DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


## Documentation for Models

 - [GenericResponse](docs/GenericResponse.md)
 - [GetMailOrders200ResponseInner](docs/GetMailOrders200ResponseInner.md)
 - [GetMailOrders401Response](docs/GetMailOrders401Response.md)
 - [MailLog](docs/MailLog.md)
 - [MailLogEntry](docs/MailLogEntry.md)
 - [SendMail](docs/SendMail.md)
 - [SendMailAdv](docs/SendMailAdv.md)
 - [SendMailAdvAttachmentsInner](docs/SendMailAdvAttachmentsInner.md)
 - [SendMailAdvBccInner](docs/SendMailAdvBccInner.md)
 - [SendMailAdvCcInner](docs/SendMailAdvCcInner.md)
 - [SendMailAdvFrom](docs/SendMailAdvFrom.md)
 - [SendMailAdvReplytoInner](docs/SendMailAdvReplytoInner.md)
 - [SendMailAdvToInner](docs/SendMailAdvToInner.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@interserver.net

