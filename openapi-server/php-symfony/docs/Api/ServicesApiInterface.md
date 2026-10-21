# OpenAPI\Server\Api\ServicesApiInterface

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrderById**](ServicesApiInterface.md#getMailOrderById) | **GET** /mail/{id} | Get one mail order&#39;s full detail including SMTP password
[**getMailOrders**](ServicesApiInterface.md#getMailOrders) | **GET** /mail | List your provisioned mail orders (sending accounts)


## Service Declaration
```yaml
# config/services.yaml
services:
    # ...
    Acme\MyBundle\Api\ServicesApi:
        tags:
            - { name: "open_api_server.api", api: "services" }
    # ...
```

## **getMailOrderById**
> OpenAPI\Server\Model\MailOrderDetail getMailOrderById($id)

Get one mail order's full detail including SMTP password

**Returns the SMTP password** in addition to the basic `GET /mail` fields. Use when you need to authenticate against `relay.mailbaby.net:25` from an SMTP client directly. Required: `id` (path; obtain from `GET /mail`). Returns the full detail record for one specific mail order identified by its numeric `id`.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/ServicesApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\ServicesApiInterface;

class ServicesApi implements ServicesApiInterface
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
     * Implementation of ServicesApiInterface#getMailOrderById
     */
    public function getMailOrderById(int $id, int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The numeric ID of the mail order. |

### Return type

[**OpenAPI\Server\Model\MailOrderDetail**](../Model/MailOrderDetail.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

## **getMailOrders**
> OpenAPI\Server\Model\MailOrder getMailOrders()

List your provisioned mail orders (sending accounts)

Use this **before sending** if you need to discover which mail order `id` to pass to `/mail/send`, `/mail/advsend`, `/mail/rawsend`, `/mail/log`, or `/mail/stats`. Returns every mail order (active **and** canceled) on your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/ServicesApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\ServicesApiInterface;

class ServicesApi implements ServicesApiInterface
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
     * Implementation of ServicesApiInterface#getMailOrders
     */
    public function getMailOrders(int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OpenAPI\Server\Model\MailOrder**](../Model/MailOrder.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

