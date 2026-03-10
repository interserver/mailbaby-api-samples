# BlockingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**BlockingAPI_addRule**](BlockingAPI.md#BlockingAPI_addRule) | **POST** /mail/rules | Creates a new email deny rule
[**BlockingAPI_deleteRule**](BlockingAPI.md#BlockingAPI_deleteRule) | **DELETE** /mail/rules/{ruleId} | Removes a deny mail rule
[**BlockingAPI_delistBlock**](BlockingAPI.md#BlockingAPI_delistBlock) | **POST** /mail/blocks/delete | Removes an email address from the block lists
[**BlockingAPI_getMailBlocks**](BlockingAPI.md#BlockingAPI_getMailBlocks) | **GET** /mail/blocks | Displays a list of blocked email addresses
[**BlockingAPI_getRules**](BlockingAPI.md#BlockingAPI_getRules) | **GET** /mail/rules | Displays a listing of deny email rules


# **BlockingAPI_addRule**
```c
// Creates a new email deny rule
//
// Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 
//
generic_response_t* BlockingAPI_addRule(apiClient_t *apiClient, mailbaby_email_delivery_and_management_service_api_addRule_type_e type, char *data, char *user);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**type** | **mailbaby_email_delivery_and_management_service_api_addRule_type_e** | The type of deny rule. | 
**data** | **char \*** | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | 
**user** | **char \*** | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_deleteRule**
```c
// Removes a deny mail rule
//
// Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
//
generic_response_t* BlockingAPI_deleteRule(apiClient_t *apiClient, int *ruleId);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**ruleId** | **int \*** | The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response. | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_delistBlock**
```c
// Removes an email address from the block lists
//
// Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
//
generic_response_t* BlockingAPI_delistBlock(apiClient_t *apiClient, email_address_param_t *email_address_param);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**email_address_param** | **[email_address_param_t](email_address_param.md) \*** |  | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_getMailBlocks**
```c
// Displays a list of blocked email addresses
//
// Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 
//
mail_blocks_t* BlockingAPI_getMailBlocks(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

[mail_blocks_t](mail_blocks.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **BlockingAPI_getRules**
```c
// Displays a listing of deny email rules
//
// Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 
//
list_t* BlockingAPI_getRules(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |

### Return type

[list_t](deny_rule_record.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

