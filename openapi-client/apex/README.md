# MailBaby Email Delivery API API Client


**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**\n\n\n# 📌 Overview\n\nThis is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).\n\n\n# 🔐 Authentication\n\nIn order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.\n\nWe support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.\n

## Requirements

- [Salesforce DX](https://www.salesforce.com/products/platform/products/salesforce-dx/)

If everything is set correctly:

- Running `sfdx version` in a command prompt should output something like:

  ```bash
  sfdx-cli/5.7.5-05549de (darwin-amd64) go1.7.5 sfdxstable
  ```

## Installation

1. Copy the output into your Salesforce DX folder - or alternatively deploy the output directly into the workspace.
2. Deploy the code via Salesforce DX to your Scratch Org

   ```bash
      sfdx force:source:push
   ```

3. If the API needs authentication update the Named Credential in Setup.
4. Run your Apex tests using

   ```bash
       sfdx sfdx force:apex:test:run
   ```

5. Retrieve the job id from the console and check the test results.

  ```bash
  sfdx force:apex:test:report -i theJobId
  ```

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Apex code:

```java
OASDefaultApi api = new OASDefaultApi();
OASClient client = api.getClient();


try {
    // cross your fingers
    List<OASGetMailOrders200ResponseInner> result = api.getMailOrders();
    System.debug(result);
} catch (OAS.ApiException e) {
    // ...handle your exceptions
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OASDefaultApi* | [**getMailOrders**](OASDefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
*OASDefaultApi* | [**pingServer**](OASDefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
*OASDefaultApi* | [**sendAdvMail**](OASDefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*OASDefaultApi* | [**sendMail**](OASDefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
*OASDefaultApi* | [**viewMailLog**](OASDefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


## Documentation for Models

 - [OASGenericResponse](OASGenericResponse.md)
 - [OASGetMailOrders200ResponseInner](OASGetMailOrders200ResponseInner.md)
 - [OASGetMailOrders401Response](OASGetMailOrders401Response.md)
 - [OASMailLog](OASMailLog.md)
 - [OASMailLogEntry](OASMailLogEntry.md)
 - [OASSendMail](OASSendMail.md)
 - [OASSendMailAdv](OASSendMailAdv.md)
 - [OASSendMailAdvAttachmentsInner](OASSendMailAdvAttachmentsInner.md)
 - [OASSendMailAdvBccInner](OASSendMailAdvBccInner.md)
 - [OASSendMailAdvCcInner](OASSendMailAdvCcInner.md)
 - [OASSendMailAdvFrom](OASSendMailAdvFrom.md)
 - [OASSendMailAdvReplytoInner](OASSendMailAdvReplytoInner.md)
 - [OASSendMailAdvToInner](OASSendMailAdvToInner.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKeyAuth


- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header


## Author

support@interserver.net

