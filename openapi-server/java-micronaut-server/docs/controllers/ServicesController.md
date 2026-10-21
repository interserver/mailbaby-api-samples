# ServicesController

All URIs are relative to `""`

The controller class is defined in **[ServicesController.java](../../src/main/java/org/openapitools/controller/ServicesController.java)**

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrderById**](#getMailOrderById) | **GET** /mail/{id} | Get one mail order&#39;s full detail including SMTP password
[**getMailOrders**](#getMailOrders) | **GET** /mail | List your provisioned mail orders (sending accounts)

<a id="getMailOrderById"></a>
# **getMailOrderById**
```java
Mono<MailOrderDetail> ServicesController.getMailOrderById(id)
```

Get one mail order&#39;s full detail including SMTP password

**Returns the SMTP password** in addition to the basic &#x60;GET /mail&#x60; fields. Use when you need to authenticate against &#x60;relay.mailbaby.net:25&#x60; from an SMTP client directly. Required: &#x60;id&#x60; (path; obtain from &#x60;GET /mail&#x60;). Returns the full detail record for one specific mail order identified by its numeric &#x60;id&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; values returned here can be used directly to authenticate against &#x60;relay.mailbaby.net:25&#x60; (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The &#x60;id&#x60; path parameter is the same integer &#x60;id&#x60; value returned by &#x60;GET /mail&#x60;. 

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**id** | `Long` | The numeric ID of the mail order. |

### Return type
[**MailOrderDetail**](../../docs/models/MailOrderDetail.md)

### Authorization
* **apiKeyAuth**

### HTTP request headers
 - **Accepts Content-Type**: Not defined
 - **Produces Content-Type**: `application/json`

<a id="getMailOrders"></a>
# **getMailOrders**
```java
Mono<List<MailOrder>> ServicesController.getMailOrders()
```

List your provisioned mail orders (sending accounts)

Use this **before sending** if you need to discover which mail order &#x60;id&#x60; to pass to &#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;, &#x60;/mail/log&#x60;, or &#x60;/mail/stats&#x60;. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric &#x60;id&#x60;, the &#x60;status&#x60; (&#x60;active&#x60; or &#x60;canceled&#x60;), the SMTP &#x60;username&#x60; (always &#x60;mb&lt;id&gt;&#x60;), and an optional &#x60;comment&#x60;.  The &#x60;id&#x60; values returned here are used as the &#x60;id&#x60; input parameter on all sending endpoints (&#x60;/mail/send&#x60;, &#x60;/mail/advsend&#x60;, &#x60;/mail/rawsend&#x60;) as well as the log and stats queries.  When the &#x60;id&#x60; parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use &#x60;GET /mail/{id}&#x60;. 


### Return type
[**List&lt;MailOrder&gt;**](../../docs/models/MailOrder.md)

### Authorization
* **apiKeyAuth**

### HTTP request headers
 - **Accepts Content-Type**: Not defined
 - **Produces Content-Type**: `application/json`

