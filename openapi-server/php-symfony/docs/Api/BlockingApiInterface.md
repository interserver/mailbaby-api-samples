# OpenAPI\Server\Api\BlockingApiInterface

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingApiInterface.md#addRule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix
[**deleteRule**](BlockingApiInterface.md#deleteRule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId
[**delistBlock**](BlockingApiInterface.md#delistBlock) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists
[**getMailBlocks**](BlockingApiInterface.md#getMailBlocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists
[**getRules**](BlockingApiInterface.md#getRules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix)


## Service Declaration
```yaml
# config/services.yaml
services:
    # ...
    Acme\MyBundle\Api\BlockingApi:
        tags:
            - { name: "open_api_server.api", api: "blocking" }
    # ...
```

## **addRule**
> OpenAPI\Server\Model\GenericResponse addRule($type, $data, $user)

Create a deny rule to block a sender, domain, destination, or prefix

**Use this to prevent future relay attempts that match a pattern.** Required: `type` (`email`, `domain`, `destination`, or `startswith`) and `data` (the value to match). Optional: `user` (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/BlockingApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\BlockingApiInterface;

class BlockingApi implements BlockingApiInterface
{

    /**
     * Configure API key authorization: apiKeyAuth
     */
    public function setapiKeyAuth($apiKey)
    {
        // Retrieve logged in user from $apiKey ...
    }

    // ...

    /**
     * Implementation of BlockingApiInterface#addRule
     */
    public function addRule(string $type, string $data, ?string $user, int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **string**| The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix. |
 **data** | **string**| The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. |
 **user** | **string**| Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional]

### Return type

[**OpenAPI\Server\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

## **deleteRule**
> OpenAPI\Server\Model\GenericResponse deleteRule($ruleId)

Delete a deny rule by its numeric ruleId

**Destructive — permanently removes the rule.** Required: `ruleId` (path param; obtain from the `id` field returned by `GET /mail/rules` or the `text` field returned by `POST /mail/rules`). Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/BlockingApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\BlockingApiInterface;

class BlockingApi implements BlockingApiInterface
{

    /**
     * Configure API key authorization: apiKeyAuth
     */
    public function setapiKeyAuth($apiKey)
    {
        // Retrieve logged in user from $apiKey ...
    }

    // ...

    /**
     * Implementation of BlockingApiInterface#deleteRule
     */
    public function deleteRule(int $ruleId, int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleId** | **int**| The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response. |

### Return type

[**OpenAPI\Server\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

## **delistBlock**
> OpenAPI\Server\Model\GenericResponse delistBlock($emailAddressParam)

Delist an email address from the spam-filter block lists

**Destructive — wipes block records for the given address.** Required: `email` (must be a valid address; typically a `from` value previously returned by `GET /mail/blocks` or `GET /mail/log`). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/BlockingApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\BlockingApiInterface;

class BlockingApi implements BlockingApiInterface
{

    /**
     * Configure API key authorization: apiKeyAuth
     */
    public function setapiKeyAuth($apiKey)
    {
        // Retrieve logged in user from $apiKey ...
    }

    // ...

    /**
     * Implementation of BlockingApiInterface#delistBlock
     */
    public function delistBlock(EmailAddressParam $emailAddressParam, int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **emailAddressParam** | [**OpenAPI\Server\Model\EmailAddressParam**](../Model/EmailAddressParam.md)|  |

### Return type

[**OpenAPI\Server\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

## **getMailBlocks**
> OpenAPI\Server\Model\MailBlocks getMailBlocks()

List addresses currently flagged by spam-filter block lists

**Use this to discover which addresses to delist.** The `from` value of any returned entry can be passed to `POST /mail/blocks/delete` (as the `email` field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/BlockingApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\BlockingApiInterface;

class BlockingApi implements BlockingApiInterface
{

    /**
     * Configure API key authorization: apiKeyAuth
     */
    public function setapiKeyAuth($apiKey)
    {
        // Retrieve logged in user from $apiKey ...
    }

    // ...

    /**
     * Implementation of BlockingApiInterface#getMailBlocks
     */
    public function getMailBlocks(int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OpenAPI\Server\Model\MailBlocks**](../Model/MailBlocks.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

## **getRules**
> OpenAPI\Server\Model\DenyRuleRecord getRules()

List custom deny rules (sender / domain / destination / prefix)

**Use this to inspect or pick a `ruleId` to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/BlockingApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\BlockingApiInterface;

class BlockingApi implements BlockingApiInterface
{

    /**
     * Configure API key authorization: apiKeyAuth
     */
    public function setapiKeyAuth($apiKey)
    {
        // Retrieve logged in user from $apiKey ...
    }

    // ...

    /**
     * Implementation of BlockingApiInterface#getRules
     */
    public function getRules(int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OpenAPI\Server\Model\DenyRuleRecord**](../Model/DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

