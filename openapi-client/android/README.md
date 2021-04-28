# openapi-android-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>org.openapitools</groupId>
    <artifactId>openapi-android-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "org.openapitools:openapi-android-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

- target/openapi-android-client-1.0.0.jar
- target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import org.openapitools.client.api.DefaultApi;

public class DefaultApiExample {

    public static void main(String[] args) {
        DefaultApi apiInstance = new DefaultApi();
        Long id = null; // Long | User ID
        try {
            MailOrder result = apiInstance.getMailById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getMailById");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**getMailById**](docs/DefaultApi.md#getMailById) | **GET** /mail/{id} | Gets mail order information by id
*DefaultApi* | [**getMailOrders**](docs/DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
*DefaultApi* | [**pingServer**](docs/DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
*DefaultApi* | [**placeMailOrder**](docs/DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
*DefaultApi* | [**sendMailById**](docs/DefaultApi.md#sendMailById) | **POST** /mail/{id}/send | Sends an Email
*DefaultApi* | [**validateMailOrder**](docs/DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
*DefaultApi* | [**viewMailLogById**](docs/DefaultApi.md#viewMailLogById) | **GET** /mail/{id}/log | displays the mail log


## Documentation for Models

 - [Error](docs/Error.md)
 - [GenericResponse](docs/GenericResponse.md)
 - [MailLog](docs/MailLog.md)
 - [MailOrder](docs/MailOrder.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKeyAuth

- **Type**: API key

- **API key parameter name**: X-API-KEY
- **Location**: HTTP header

### apiLoginAuth

- **Type**: API key

- **API key parameter name**: X-API-LOGIN
- **Location**: HTTP header

### apiPasswordAuth

- **Type**: API key

- **API key parameter name**: X-API-PASS
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

detain@interserver.net

