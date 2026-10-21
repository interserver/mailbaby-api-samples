# MailBabyRuby::BlockingApi

All URIs are relative to *https://api.mailbaby.net*

| Method | HTTP request | Description |
| ------ | ------------ | ----------- |
| [**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix |
| [**delete_rule**](BlockingApi.md#delete_rule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId |
| [**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists |
| [**get_mail_blocks**](BlockingApi.md#get_mail_blocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists |
| [**get_rules**](BlockingApi.md#get_rules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix) |


## add_rule

> <GenericResponse> add_rule(type, data, opts)

Create a deny rule to block a sender, domain, destination, or prefix

**Use this to prevent future relay attempts that match a pattern.** Required: `type` (`email`, `domain`, `destination`, or `startswith`) and `data` (the value to match). Optional: `user` (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule's `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 

### Examples

```ruby
require 'time'
require 'mailbaby_client_ruby'
# setup authorization
MailBabyRuby.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = MailBabyRuby::BlockingApi.new
type = 'domain' # String | The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
data = 'data_example' # String | The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
opts = {
  user: 'user_example' # String | Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
}

begin
  # Create a deny rule to block a sender, domain, destination, or prefix
  result = api_instance.add_rule(type, data, opts)
  p result
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->add_rule: #{e}"
end
```

#### Using the add_rule_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(<GenericResponse>, Integer, Hash)> add_rule_with_http_info(type, data, opts)

```ruby
begin
  # Create a deny rule to block a sender, domain, destination, or prefix
  data, status_code, headers = api_instance.add_rule_with_http_info(type, data, opts)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => <GenericResponse>
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->add_rule_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **type** | **String** | The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix. |  |
| **data** | **String** | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. |  |
| **user** | **String** | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json


## delete_rule

> <GenericResponse> delete_rule(rule_id)

Delete a deny rule by its numeric ruleId

**Destructive — permanently removes the rule.** Required: `ruleId` (path param; obtain from the `id` field returned by `GET /mail/rules` or the `text` field returned by `POST /mail/rules`). Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 

### Examples

```ruby
require 'time'
require 'mailbaby_client_ruby'
# setup authorization
MailBabyRuby.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = MailBabyRuby::BlockingApi.new
rule_id = 34 # Integer | The numeric ID of the deny rule to delete.  Obtain this from the `id` field in `GET /mail/rules` or the `text` field of a `POST /mail/rules` response.

begin
  # Delete a deny rule by its numeric ruleId
  result = api_instance.delete_rule(rule_id)
  p result
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->delete_rule: #{e}"
end
```

#### Using the delete_rule_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(<GenericResponse>, Integer, Hash)> delete_rule_with_http_info(rule_id)

```ruby
begin
  # Delete a deny rule by its numeric ruleId
  data, status_code, headers = api_instance.delete_rule_with_http_info(rule_id)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => <GenericResponse>
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->delete_rule_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **rule_id** | **Integer** | The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response. |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## delist_block

> <GenericResponse> delist_block(email_address_param)

Delist an email address from the spam-filter block lists

**Destructive — wipes block records for the given address.** Required: `email` (must be a valid address; typically a `from` value previously returned by `GET /mail/blocks` or `GET /mail/log`). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 

### Examples

```ruby
require 'time'
require 'mailbaby_client_ruby'
# setup authorization
MailBabyRuby.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = MailBabyRuby::BlockingApi.new
email_address_param = MailBabyRuby::EmailAddressParam.new({email: 'user@domain.com'}) # EmailAddressParam | 

begin
  # Delist an email address from the spam-filter block lists
  result = api_instance.delist_block(email_address_param)
  p result
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->delist_block: #{e}"
end
```

#### Using the delist_block_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(<GenericResponse>, Integer, Hash)> delist_block_with_http_info(email_address_param)

```ruby
begin
  # Delist an email address from the spam-filter block lists
  data, status_code, headers = api_instance.delist_block_with_http_info(email_address_param)
  p status_code # => 2xx
  p headers # => { ... }
  p data # => <GenericResponse>
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->delist_block_with_http_info: #{e}"
end
```

### Parameters

| Name | Type | Description | Notes |
| ---- | ---- | ----------- | ----- |
| **email_address_param** | [**EmailAddressParam**](EmailAddressParam.md) |  |  |

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json


## get_mail_blocks

> <MailBlocks> get_mail_blocks

List addresses currently flagged by spam-filter block lists

**Use this to discover which addresses to delist.** The `from` value of any returned entry can be passed to `POST /mail/blocks/delete` (as the `email` field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account's local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby's internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 

### Examples

```ruby
require 'time'
require 'mailbaby_client_ruby'
# setup authorization
MailBabyRuby.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = MailBabyRuby::BlockingApi.new

begin
  # List addresses currently flagged by spam-filter block lists
  result = api_instance.get_mail_blocks
  p result
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->get_mail_blocks: #{e}"
end
```

#### Using the get_mail_blocks_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(<MailBlocks>, Integer, Hash)> get_mail_blocks_with_http_info

```ruby
begin
  # List addresses currently flagged by spam-filter block lists
  data, status_code, headers = api_instance.get_mail_blocks_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => <MailBlocks>
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->get_mail_blocks_with_http_info: #{e}"
end
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


## get_rules

> <Array<DenyRuleRecord>> get_rules

List custom deny rules (sender / domain / destination / prefix)

**Use this to inspect or pick a `ruleId` to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 

### Examples

```ruby
require 'time'
require 'mailbaby_client_ruby'
# setup authorization
MailBabyRuby.configure do |config|
  # Configure API key authorization: apiKeyAuth
  config.api_key['X-API-KEY'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['X-API-KEY'] = 'Bearer'
end

api_instance = MailBabyRuby::BlockingApi.new

begin
  # List custom deny rules (sender / domain / destination / prefix)
  result = api_instance.get_rules
  p result
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->get_rules: #{e}"
end
```

#### Using the get_rules_with_http_info variant

This returns an Array which contains the response data, status code and headers.

> <Array(<Array<DenyRuleRecord>>, Integer, Hash)> get_rules_with_http_info

```ruby
begin
  # List custom deny rules (sender / domain / destination / prefix)
  data, status_code, headers = api_instance.get_rules_with_http_info
  p status_code # => 2xx
  p headers # => { ... }
  p data # => <Array<DenyRuleRecord>>
rescue MailBabyRuby::ApiError => e
  puts "Error when calling BlockingApi->get_rules_with_http_info: #{e}"
end
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**Array&lt;DenyRuleRecord&gt;**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

