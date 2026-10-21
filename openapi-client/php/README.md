# OpenAPIClient-php

**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**

# Overview

This is the API interface to the [Mail Baby](https://mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).

# Mail Orders

Every sending account in MailBaby is backed by a **Mail Order** — a provisioned sending credential with a numeric `id` and a corresponding SMTP username (`mb<id>`).  Most calls accept an optional `id` parameter; when omitted the API automatically selects the first active order on your account. Use `GET /mail` to list all orders, and `GET /mail/{id}` to inspect a single order including its current SMTP password.

# Sending Email

Three sending methods are available depending on your use-case:
| Endpoint | Best for | |----------|----------| | `POST /mail/send` | Simple single-recipient messages | | `POST /mail/advsend` | Multiple recipients, CC/BCC, attachments, named contacts | | `POST /mail/rawsend` | Pre-built RFC 822 messages (e.g. DKIM-signed payloads) |

After a successful send each endpoint returns a `GenericResponse` whose `text` field contains the **transaction ID** assigned by the relay.  This ID can later be matched against entries in `GET /mail/log` via the `mailid` query parameter.

# Filtering & Logs

`GET /mail/log` provides paginated access to every message accepted by the relay for your account. Combine any of the query parameters to narrow results — e.g. `from`, `to`, `subject`, `messageId`, `origin`, `mx`, `startDate`/`endDate`, and `delivered`.

# Blocking

Two independent mechanisms exist for suppressing unwanted email:
- **Block lists** (`GET /mail/blocks`, `POST /mail/blocks/delete`) — addresses flagged by the
  system spam filters (LOCAL_BL_RCPT / MBTRAP rules in rspamd, and suspicious subjects).
- **Deny rules** (`GET /mail/rules`, `POST /mail/rules`, `DELETE /mail/rules/{ruleId}`) —
  custom rules you configure to reject specific senders, domains, destination addresses, or
  subject-line prefixes before a message is even attempted.


# Authentication

In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.
We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page.
Pass your key in the `X-API-KEY` HTTP request header for every protected call.


For more information, please visit [https://www.mail.baby/contact/](https://www.mail.baby/contact/).

## Installation & Usage

### Requirements

PHP 7.2 and later.

### Composer

To install the bindings via [Composer](https://getcomposer.org/), add the following to `composer.json`:

```json
{
  "repositories": [
    {
      "type": "vcs",
      "url": "https://github.com/GIT_USER_ID/GIT_REPO_ID.git"
    }
  ],
  "require": {
    "GIT_USER_ID/GIT_REPO_ID": "*@dev"
  }
}
```

Then run `composer install`

Your project is free to choose the http client of your choice
Please require packages that will provide http client functionality:
https://packagist.org/providers/psr/http-client-implementation
https://packagist.org/providers/php-http/async-client-implementation
https://packagist.org/providers/psr/http-factory-implementation

As an example:

```
composer require guzzlehttp/guzzle php-http/guzzle7-adapter http-interop/http-factory-guzzle
```

### Manual Installation

Download the files and include `autoload.php`:

```php
<?php
require_once('/path/to/OpenAPIClient-php/vendor/autoload.php');
```

## Getting Started

Please follow the [installation procedure](#installation--usage) and then run the following:

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');



// Configure API key authorization: apiKeyAuth
$config = MailBabyPhp\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = MailBabyPhp\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new MailBabyPhp\Api\BlockingApi(
    // If you want use custom http client, pass your client which implements `Psr\Http\Client\ClientInterface`.
    // This is optional, `Psr18ClientDiscovery` will be used to find http client. For instance `GuzzleHttp\Client` implements that interface
    new GuzzleHttp\Client(),
    $config
);
$type = 'type_example'; // string | The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
$data = 'data_example'; // string | The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
$user = 'user_example'; // string | Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.

try {
    $result = $apiInstance->addRule($type, $data, $user);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling BlockingApi->addRule: ', $e->getMessage(), PHP_EOL;
}

```

## API Endpoints

All URIs are relative to *https://api.mailbaby.net*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*BlockingApi* | [**addRule**](docs/Api/BlockingApi.md#addrule) | **POST** /mail/rules | Create a deny rule to block a sender, domain, destination, or prefix
*BlockingApi* | [**deleteRule**](docs/Api/BlockingApi.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Delete a deny rule by its numeric ruleId
*BlockingApi* | [**delistBlock**](docs/Api/BlockingApi.md#delistblock) | **POST** /mail/blocks/delete | Delist an email address from the spam-filter block lists
*BlockingApi* | [**getMailBlocks**](docs/Api/BlockingApi.md#getmailblocks) | **GET** /mail/blocks | List addresses currently flagged by spam-filter block lists
*BlockingApi* | [**getRules**](docs/Api/BlockingApi.md#getrules) | **GET** /mail/rules | List custom deny rules (sender / domain / destination / prefix)
*HistoryApi* | [**getStats**](docs/Api/HistoryApi.md#getstats) | **GET** /mail/stats | Account usage, cost, and volume statistics for a time window
*HistoryApi* | [**viewMailLog**](docs/Api/HistoryApi.md#viewmaillog) | **GET** /mail/log | Query the mail delivery log (filterable, paginated)
*SendingApi* | [**rawMail**](docs/Api/SendingApi.md#rawmail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
*SendingApi* | [**sendAdvMail**](docs/Api/SendingApi.md#sendadvmail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
*SendingApi* | [**sendMail**](docs/Api/SendingApi.md#sendmail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML)
*ServicesApi* | [**getMailOrderById**](docs/Api/ServicesApi.md#getmailorderbyid) | **GET** /mail/{id} | Get one mail order&#39;s full detail including SMTP password
*ServicesApi* | [**getMailOrders**](docs/Api/ServicesApi.md#getmailorders) | **GET** /mail | List your provisioned mail orders (sending accounts)
*StatusApi* | [**pingServer**](docs/Api/StatusApi.md#pingserver) | **GET** /ping | Health check — verify the API is reachable

## Models

- [DateOrTimestamp](docs/Model/DateOrTimestamp.md)
- [DenyRuleNew](docs/Model/DenyRuleNew.md)
- [DenyRuleRecord](docs/Model/DenyRuleRecord.md)
- [EmailAddressName](docs/Model/EmailAddressName.md)
- [EmailAddressParam](docs/Model/EmailAddressParam.md)
- [EmailAddressTypes](docs/Model/EmailAddressTypes.md)
- [EmailAddressesTypes](docs/Model/EmailAddressesTypes.md)
- [ErrorMessage](docs/Model/ErrorMessage.md)
- [GenericResponse](docs/Model/GenericResponse.md)
- [MailAttachment](docs/Model/MailAttachment.md)
- [MailBlockClickHouse](docs/Model/MailBlockClickHouse.md)
- [MailBlockRspamd](docs/Model/MailBlockRspamd.md)
- [MailBlocks](docs/Model/MailBlocks.md)
- [MailLog](docs/Model/MailLog.md)
- [MailLogEntry](docs/Model/MailLogEntry.md)
- [MailOrder](docs/Model/MailOrder.md)
- [MailOrderDetail](docs/Model/MailOrderDetail.md)
- [MailStatsType](docs/Model/MailStatsType.md)
- [MailStatsVolume](docs/Model/MailStatsVolume.md)
- [SendMail](docs/Model/SendMail.md)
- [SendMailAdv](docs/Model/SendMailAdv.md)
- [SendMailRaw](docs/Model/SendMailRaw.md)
- [SendMailTo](docs/Model/SendMailTo.md)

## Authorization

### apiKeyAuth

- **Type**: API key
- **API key parameter name**: X-API-KEY
- **Location**: HTTP header


## Tests

To run the tests, use:

```bash
composer install
vendor/bin/phpunit
```

## Author

support@interserver.net

## About this package

This PHP package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: `1.5.0`
    - Generator version: `7.26.0`
- Build package: `org.openapitools.codegen.languages.PhpClientCodegen`
