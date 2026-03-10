# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Creates a new email deny rule
[**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes a deny mail rule
[**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the block lists
[**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | Displays a list of blocked email addresses
[**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | Displays a listing of deny email rules

<a name="addRule"></a>
# **addRule**
> GenericResponse addRule(user, type, `data`)

Creates a new email deny rule

Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#x27;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val user : kotlin.String = user_example // kotlin.String | 
val type : kotlin.String = type_example // kotlin.String | 
val `data` : kotlin.String = `data`_example // kotlin.String | 
try {
    val result : GenericResponse = apiInstance.addRule(user, type, `data`)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#addRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#addRule")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | **kotlin.String**|  |
 **type** | **kotlin.String**|  | [enum: domain, email, startswith, destination]
 **&#x60;data&#x60;** | **kotlin.String**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="addRule"></a>
# **addRule**
> GenericResponse addRule(body)

Creates a new email deny rule

Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#x27;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val body : DenyRuleNew = {
  "summary" : "Block a specific sender",
  "value" : {
    "type" : "email",
    "data" : "spammer@badactor.net"
  }
} // DenyRuleNew | Fields required to create a new email deny rule.
try {
    val result : GenericResponse = apiInstance.addRule(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#addRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#addRule")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**DenyRuleNew**](DenyRuleNew.md)| Fields required to create a new email deny rule. |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

<a name="deleteRule"></a>
# **deleteRule**
> GenericResponse deleteRule(ruleId)

Removes a deny mail rule

Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val ruleId : kotlin.Int = 56 // kotlin.Int | The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.
try {
    val result : GenericResponse = apiInstance.deleteRule(ruleId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#deleteRule")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#deleteRule")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **kotlin.Int**| The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response. |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="delistBlock"></a>
# **delistBlock**
> GenericResponse delistBlock(body)

Removes an email address from the block lists

Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val body : EmailAddressParam = {
  "value" : {
    "email" : "client@domain.com"
  }
} // EmailAddressParam | 
try {
    val result : GenericResponse = apiInstance.delistBlock(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#delistBlock")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#delistBlock")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailAddressParam**](EmailAddressParam.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="delistBlock"></a>
# **delistBlock**
> GenericResponse delistBlock(email)

Removes an email address from the block lists

Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
val email : kotlin.String = email_example // kotlin.String | 
try {
    val result : GenericResponse = apiInstance.delistBlock(email)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#delistBlock")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#delistBlock")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **kotlin.String**|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

<a name="getMailBlocks"></a>
# **getMailBlocks**
> MailBlocks getMailBlocks()

Displays a list of blocked email addresses

Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#x27;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#x27;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
try {
    val result : MailBlocks = apiInstance.getMailBlocks()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#getMailBlocks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#getMailBlocks")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRules"></a>
# **getRules**
> kotlin.Array&lt;DenyRuleRecord&gt; getRules()

Displays a listing of deny email rules

Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call. 

### Example
```kotlin
// Import classes:
//import mailbaby-client-kotlin-client.infrastructure.*
//import io.swagger.client.models.*;

val apiInstance = BlockingApi()
try {
    val result : kotlin.Array<DenyRuleRecord> = apiInstance.getRules()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling BlockingApi#getRules")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling BlockingApi#getRules")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Array&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

