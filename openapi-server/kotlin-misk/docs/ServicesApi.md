# ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrderById**](ServicesApi.md#getMailOrderById) | **Get** /mail/{id} | Get one mail order&#39;s full detail including SMTP password
[**getMailOrders**](ServicesApi.md#getMailOrders) | **Get** /mail | List your provisioned mail orders (sending accounts)


<a name="getMailOrderById"></a>
# **getMailOrderById**
> MailOrderDetail getMailOrderById(id)

Get one mail order&#39;s full detail including SMTP password

**Returns the SMTP password** in addition to the basic &#x60;GET /mail&#x60; fields. Use when you need to authenticate against &#x60;relay.mailbaby.net:25&#x60; from an SMTP client directly. Required: &#x60;id&#x60; (path; obtain from &#x60;GET /mail&#x60;). Returns the full detail record for one specific mail order identified by its numeric &#x60;id&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; values returned here can be used directly to authenticate against &#x60;relay.mailbaby.net:25&#x60; (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The &#x60;id&#x60; path parameter is the same integer &#x60;id&#x60; value returned by &#x60;GET /mail&#x60;. 

### Example
```kotlin
// Import classes:
//import MailBabyKotlinMisk.infrastructure.*
//import MailBabyKotlinMisk.models.*

val apiInstance = ServicesApi()
val id : kotlin.Long = 39 // kotlin.Long | The numeric ID of the mail order.
try {
    val result : MailOrderDetail = apiInstance.getMailOrderById(id)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ServicesApi#getMailOrderById")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ServicesApi#getMailOrderById")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **kotlin.Long**| The numeric ID of the mail order. |

### Return type

[**MailOrderDetail**](MailOrderDetail.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: APPLICATION_JSON

<a name="getMailOrders"></a>
# **getMailOrders**
> kotlin.collections.List&lt;MailOrder&gt; getMailOrders()

List your provisioned mail orders (sending accounts)

Use this **before sending** if you need to discover which mail order &#x60;id&#x60; to pass to &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;, &#x60;/mail/log&#x60;, or &#x60;/mail/stats&#x60;. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric &#x60;id&#x60;, the &#x60;status&#x60; (&#x60;active&#x60; or &#x60;canceled&#x60;), the SMTP &#x60;username&#x60; (always &#x60;mb&lt;id&gt;&#x60;), and an optional &#x60;comment&#x60;.  The &#x60;id&#x60; values returned here are used as the &#x60;id&#x60; input parameter on all sending endpoints (&#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;) as well as the log and stats queries.  When the &#x60;id&#x60; parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use &#x60;GET /mail/{id}&#x60;. 

### Example
```kotlin
// Import classes:
//import MailBabyKotlinMisk.infrastructure.*
//import MailBabyKotlinMisk.models.*

val apiInstance = ServicesApi()
try {
    val result : kotlin.collections.List<MailOrder> = apiInstance.getMailOrders()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ServicesApi#getMailOrders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ServicesApi#getMailOrders")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;MailOrder&gt;**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: APPLICATION_JSON

