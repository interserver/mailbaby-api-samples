# OpenAPI\Client\DefaultApi

All URIs are relative to https://api.mailbaby.net.

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById()**](DefaultApi.md#getMailById) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders()**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer()**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**placeMailOrder()**](DefaultApi.md#placeMailOrder) | **POST** /mail/order | places a mail order
[**sendMailById()**](DefaultApi.md#sendMailById) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder()**](DefaultApi.md#validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById()**](DefaultApi.md#viewMailLogById) | **GET** /mail/{id}/log | displays the mail log


## `getMailById()`

```php
getMailById($id): \OpenAPI\Client\Model\MailOrder
```

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

// Configure API key authorization: apiLoginAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-LOGIN', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-LOGIN', 'Bearer');

// Configure API key authorization: apiPasswordAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-PASS', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-PASS', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = 56; // int | User ID

try {
    $result = $apiInstance->getMailById($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->getMailById: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID |

### Return type

[**\OpenAPI\Client\Model\MailOrder**](../Model/MailOrder.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth), [apiLoginAuth](../../README.md#apiLoginAuth), [apiPasswordAuth](../../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getMailOrders()`

```php
getMailOrders(): \OpenAPI\Client\Model\MailOrder[]
```

displays a list of mail service orders

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

// Configure API key authorization: apiLoginAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-LOGIN', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-LOGIN', 'Bearer');

// Configure API key authorization: apiPasswordAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-PASS', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-PASS', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getMailOrders();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->getMailOrders: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\OpenAPI\Client\Model\MailOrder[]**](../Model/MailOrder.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth), [apiLoginAuth](../../README.md#apiLoginAuth), [apiPasswordAuth](../../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`, `application/xml`, `text/plain`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `pingServer()`

```php
pingServer()
```

Checks if the server is running

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');



$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);

try {
    $apiInstance->pingServer();
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->pingServer: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `placeMailOrder()`

```php
placeMailOrder($mail_order)
```

places a mail order

Adds an item to the system

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

// Configure API key authorization: apiLoginAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-LOGIN', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-LOGIN', 'Bearer');

// Configure API key authorization: apiPasswordAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-PASS', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-PASS', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$mail_order = new \OpenAPI\Client\Model\MailOrder(); // \OpenAPI\Client\Model\MailOrder | Inventory item to add

try {
    $apiInstance->placeMailOrder($mail_order);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->placeMailOrder: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mail_order** | [**\OpenAPI\Client\Model\MailOrder**](../Model/MailOrder.md)| Inventory item to add | [optional]

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth), [apiLoginAuth](../../README.md#apiLoginAuth), [apiPasswordAuth](../../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `sendMailById()`

```php
sendMailById($id, $subject, $body, $to, $from): \OpenAPI\Client\Model\GenericResponse
```

Sends an Email

Sends An email through one of your mail orders.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

// Configure API key authorization: apiLoginAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-LOGIN', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-LOGIN', 'Bearer');

// Configure API key authorization: apiPasswordAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-PASS', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-PASS', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = 56; // int | User ID
$subject = 'subject_example'; // string
$body = 'body_example'; // string
$to = 'to_example'; // string
$from = 'from_example'; // string

try {
    $result = $apiInstance->sendMailById($id, $subject, $body, $to, $from);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendMailById: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID |
 **subject** | **string**|  | [optional]
 **body** | **string**|  | [optional]
 **to** | **string**|  | [optional]
 **from** | **string**|  | [optional]

### Return type

[**\OpenAPI\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth), [apiLoginAuth](../../README.md#apiLoginAuth), [apiPasswordAuth](../../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `validateMailOrder()`

```php
validateMailOrder()
```

validatess order details before placing an order

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

// Configure API key authorization: apiLoginAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-LOGIN', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-LOGIN', 'Bearer');

// Configure API key authorization: apiPasswordAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-PASS', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-PASS', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $apiInstance->validateMailOrder();
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->validateMailOrder: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth), [apiLoginAuth](../../README.md#apiLoginAuth), [apiPasswordAuth](../../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `viewMailLogById()`

```php
viewMailLogById($id, $search_string, $skip, $limit): \OpenAPI\Client\Model\MailLog[]
```

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

// Configure API key authorization: apiLoginAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-LOGIN', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-LOGIN', 'Bearer');

// Configure API key authorization: apiPasswordAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-PASS', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-PASS', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = 56; // int | User ID
$search_string = 'search_string_example'; // string | pass an optional search string for looking up inventory
$skip = 56; // int | number of records to skip for pagination
$limit = 56; // int | maximum number of records to return

try {
    $result = $apiInstance->viewMailLogById($id, $search_string, $skip, $limit);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->viewMailLogById: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID |
 **search_string** | **string**| pass an optional search string for looking up inventory | [optional]
 **skip** | **int**| number of records to skip for pagination | [optional]
 **limit** | **int**| maximum number of records to return | [optional]

### Return type

[**\OpenAPI\Client\Model\MailLog[]**](../Model/MailLog.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth), [apiLoginAuth](../../README.md#apiLoginAuth), [apiPasswordAuth](../../README.md#apiPasswordAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
