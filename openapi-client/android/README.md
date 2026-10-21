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

import io.interserver.client.api.BlockingApi;

public class BlockingApiExample {

    public static void main(String[] args) {
        BlockingApi apiInstance = new BlockingApi();
        String type = null; // String | The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
        String data = null; // String | The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
        String user = null; // String | Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
        try {
            GenericResponse result = apiInstance.addRule(type, data, user);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling BlockingApi#addRule");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingApi* | [**addRule**](docs/BlockingApi.md#addRule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix
*BlockingApi* | [**deleteRule**](docs/BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId
*BlockingApi* | [**delistBlock**](docs/BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists
*BlockingApi* | [**getMailBlocks**](docs/BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists
*BlockingApi* | [**getRules**](docs/BlockingApi.md#getRules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix)
*HistoryApi* | [**getStats**](docs/HistoryApi.md#getStats) | **GET** /mail/stats | Account usage, cost, and volume statistics for a time window
*HistoryApi* | [**viewMailLog**](docs/HistoryApi.md#viewMailLog) | **GET** /mail/log | Query the mail delivery log (filterable, paginated)
*SendingApi* | [**rawMail**](docs/SendingApi.md#rawMail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
*SendingApi* | [**sendAdvMail**](docs/SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
*SendingApi* | [**sendMail**](docs/SendingApi.md#sendMail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML)
*ServicesApi* | [**getMailOrderById**](docs/ServicesApi.md#getMailOrderById) | **GET** /mail/{id} | Get one mail order&#39;s full detail including SMTP password
*ServicesApi* | [**getMailOrders**](docs/ServicesApi.md#getMailOrders) | **GET** /mail | List your provisioned mail orders (sending accounts)
*StatusApi* | [**pingServer**](docs/StatusApi.md#pingServer) | **GET** /ping | Health check — verify the API is reachable


## Documentation for Models

 - [DateOrTimestamp](docs/DateOrTimestamp.md)
 - [DenyRuleNew](docs/DenyRuleNew.md)
 - [DenyRuleRecord](docs/DenyRuleRecord.md)
 - [EmailAddressName](docs/EmailAddressName.md)
 - [EmailAddressParam](docs/EmailAddressParam.md)
 - [EmailAddressTypes](docs/EmailAddressTypes.md)
 - [EmailAddressesTypes](docs/EmailAddressesTypes.md)
 - [ErrorMessage](docs/ErrorMessage.md)
 - [GenericResponse](docs/GenericResponse.md)
 - [MailAttachment](docs/MailAttachment.md)
 - [MailBlockClickHouse](docs/MailBlockClickHouse.md)
 - [MailBlockRspamd](docs/MailBlockRspamd.md)
 - [MailBlocks](docs/MailBlocks.md)
 - [MailLog](docs/MailLog.md)
 - [MailLogEntry](docs/MailLogEntry.md)
 - [MailOrder](docs/MailOrder.md)
 - [MailOrderDetail](docs/MailOrderDetail.md)
 - [MailStatsType](docs/MailStatsType.md)
 - [MailStatsVolume](docs/MailStatsVolume.md)
 - [SendMail](docs/SendMail.md)
 - [SendMailAdv](docs/SendMailAdv.md)
 - [SendMailRaw](docs/SendMailRaw.md)
 - [SendMailTo](docs/SendMailTo.md)


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

