# DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](DefaultApi.md#getMailById) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
[**sendAdvMailById**](DefaultApi.md#sendAdvMailById) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
[**sendMailById**](DefaultApi.md#sendMailById) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewMailLogById) | **GET** /mail/{id}/log | displays the mail log



## getMailById

> MailOrder getMailById(id)

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Long id = null; // Long | User ID
try {
    MailOrder result = apiInstance.getMailById(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMailById");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]

### Return type

[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getMailOrders

> List&lt;MailOrder&gt; getMailOrders()

displays a list of mail service orders

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
try {
    List<MailOrder> result = apiInstance.getMailOrders();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getMailOrders");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;MailOrder&gt;**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml, text/plain


## pingServer

> pingServer()

Checks if the server is running

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
try {
    apiInstance.pingServer();
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#pingServer");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## placeMailOrder

> placeMailOrder(mailOrder)

places a mail order

Adds an item to the system

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
MailOrder mailOrder = new MailOrder(); // MailOrder | Inventory item to add
try {
    apiInstance.placeMailOrder(mailOrder);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#placeMailOrder");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mailOrder** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional]

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## sendAdvMailById

> GenericResponse sendAdvMailById(id, sendMail)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Long id = null; // Long | User ID
SendMail sendMail = new SendMail(); // SendMail | 
try {
    GenericResponse result = apiInstance.sendAdvMailById(id, sendMail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sendAdvMailById");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]
 **sendMail** | [**SendMail**](SendMail.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
- **Accept**: application/json


## sendMailById

> GenericResponse sendMailById(id, subject, body, to, toName, from, fromName)

Sends an Email

Sends An email through one of your mail orders.

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Long id = null; // Long | User ID
String subject = null; // String | 
String body = null; // String | 
String to = null; // String | 
String toName = null; // String | 
String from = null; // String | 
String fromName = null; // String | 
try {
    GenericResponse result = apiInstance.sendMailById(id, subject, body, to, toName, from, fromName);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#sendMailById");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]
 **subject** | **String**|  | [optional] [default to null]
 **body** | **String**|  | [optional] [default to null]
 **to** | **String**|  | [optional] [default to null]
 **toName** | **String**|  | [optional] [default to null]
 **from** | **String**|  | [optional] [default to null]
 **fromName** | **String**|  | [optional] [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## validateMailOrder

> validateMailOrder()

validatess order details before placing an order

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
try {
    apiInstance.validateMailOrder();
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#validateMailOrder");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## viewMailLogById

> List&lt;MailLog&gt; viewMailLogById(id, searchString, skip, limit)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example

```java
// Import classes:
//import org.openapitools.client.api.DefaultApi;

DefaultApi apiInstance = new DefaultApi();
Long id = null; // Long | User ID
String searchString = null; // String | pass an optional search string for looking up inventory
Integer skip = null; // Integer | number of records to skip for pagination
Integer limit = null; // Integer | maximum number of records to return
try {
    List<MailLog> result = apiInstance.viewMailLogById(id, searchString, skip, limit);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#viewMailLogById");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**| User ID | [default to null]
 **searchString** | **String**| pass an optional search string for looking up inventory | [optional] [default to null]
 **skip** | **Integer**| number of records to skip for pagination | [optional] [default to null]
 **limit** | **Integer**| maximum number of records to return | [optional] [default to null]

### Return type

[**List&lt;MailLog&gt;**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

