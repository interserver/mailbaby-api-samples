# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApi.md#addRule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix
[**deleteRule**](BlockingApi.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId
[**delistBlock**](BlockingApi.md#delistBlock) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists
[**getMailBlocks**](BlockingApi.md#getMailBlocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists
[**getRules**](BlockingApi.md#getRules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix)



## addRule

> GenericResponse addRule(type, data, user)

Create a deny rule to block a sender, domain, destination, or prefix

**Use this to prevent future relay attempts that match a pattern.** Required: &#x60;type&#x60; (&#x60;email&#x60;, &#x60;domain&#x60;, &#x60;destination&#x60;, or &#x60;startswith&#x60;) and &#x60;data&#x60; (the value to match). Optional: &#x60;user&#x60; (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#39;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 

### Example

```java
// Import classes:
//import io.interserver.client.api.BlockingApi;

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
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **String**| The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix. | [default to null] [enum: domain, email, startswith, destination]
 **data** | **String**| The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | [default to null]
 **user** | **String**| Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json


## deleteRule

> GenericResponse deleteRule(ruleId)

Delete a deny rule by its numeric ruleId

**Destructive — permanently removes the rule.** Required: &#x60;ruleId&#x60; (path param; obtain from the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field returned by &#x60;POST /mail/rules&#x60;). Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 

### Example

```java
// Import classes:
//import io.interserver.client.api.BlockingApi;

BlockingApi apiInstance = new BlockingApi();
Integer ruleId = 34; // Integer | The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.
try {
    GenericResponse result = apiInstance.deleteRule(ruleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#deleteRule");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **Integer**| The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response. | [default to null]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## delistBlock

> GenericResponse delistBlock(emailAddressParam)

Delist an email address from the spam-filter block lists

**Destructive — wipes block records for the given address.** Required: &#x60;email&#x60; (must be a valid address; typically a &#x60;from&#x60; value previously returned by &#x60;GET /mail/blocks&#x60; or &#x60;GET /mail/log&#x60;). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 

### Example

```java
// Import classes:
//import io.interserver.client.api.BlockingApi;

BlockingApi apiInstance = new BlockingApi();
EmailAddressParam emailAddressParam = {"email":"client@domain.com"}; // EmailAddressParam | 
try {
    GenericResponse result = apiInstance.delistBlock(emailAddressParam);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#delistBlock");
    e.printStackTrace();
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailAddressParam** | [**EmailAddressParam**](EmailAddressParam.md)|  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json


## getMailBlocks

> MailBlocks getMailBlocks()

List addresses currently flagged by spam-filter block lists

**Use this to discover which addresses to delist.** The &#x60;from&#x60; value of any returned entry can be passed to &#x60;POST /mail/blocks/delete&#x60; (as the &#x60;email&#x60; field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#39;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#39;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address. 

### Example

```java
// Import classes:
//import io.interserver.client.api.BlockingApi;

BlockingApi apiInstance = new BlockingApi();
try {
    MailBlocks result = apiInstance.getMailBlocks();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#getMailBlocks");
    e.printStackTrace();
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


## getRules

> List&lt;DenyRuleRecord&gt; getRules()

List custom deny rules (sender / domain / destination / prefix)

**Use this to inspect or pick a &#x60;ruleId&#x60; to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call. 

### Example

```java
// Import classes:
//import io.interserver.client.api.BlockingApi;

BlockingApi apiInstance = new BlockingApi();
try {
    List<DenyRuleRecord> result = apiInstance.getRules();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BlockingApi#getRules");
    e.printStackTrace();
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

