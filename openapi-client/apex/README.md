# Mail Baby API API Client


This is an API defintion for accesssing the Mail.Baby mail service.

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
    List<OASMailOrder> result = api.getMailOrders();
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
*OASDefaultApi* | [**placeMailOrder**](OASDefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
*OASDefaultApi* | [**sendAdvMail**](OASDefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
*OASDefaultApi* | [**sendMail**](OASDefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
*OASDefaultApi* | [**validateMailOrder**](OASDefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
*OASDefaultApi* | [**viewMailLog**](OASDefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


## Documentation for Models

 - [OASErrorResponse](OASErrorResponse.md)
 - [OASGenericResponse](OASGenericResponse.md)
 - [OASMailAttachment](OASMailAttachment.md)
 - [OASMailContact](OASMailContact.md)
 - [OASMailLog](OASMailLog.md)
 - [OASMailOrder](OASMailOrder.md)
 - [OASSendMail](OASSendMail.md)
 - [OASSendMailAdv](OASSendMailAdv.md)
 - [OASSendMailAdvFrom](OASSendMailAdvFrom.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKeyAuth


- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header


## Author

detain@interserver.net

