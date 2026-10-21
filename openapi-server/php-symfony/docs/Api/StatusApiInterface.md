# OpenAPI\Server\Api\StatusApiInterface

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApiInterface.md#pingServer) | **GET** /ping | Health check — verify the API is reachable


## Service Declaration
```yaml
# config/services.yaml
services:
    # ...
    Acme\MyBundle\Api\StatusApi:
        tags:
            - { name: "open_api_server.api", api: "status" }
    # ...
```

## **pingServer**
> string pingServer()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests.

### Example Implementation
```php
<?php
// src/Acme/MyBundle/Api/StatusApiInterface.php

namespace Acme\MyBundle\Api;

use OpenAPI\Server\Api\StatusApiInterface;

class StatusApi implements StatusApiInterface
{

    // ...

    /**
     * Implementation of StatusApiInterface#pingServer
     */
    public function pingServer(int &$responseCode, array &$responseHeaders): array|object|null
    {
        // Implement the operation ...
    }

    // ...
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**string**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

