# Interserver\Mailbaby\DefaultApi

All URIs are relative to https://api.mailbaby.net.

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders()**](DefaultApi.md#getMailOrders) | **GET** /mail | displays a list of mail service orders
[**pingServer()**](DefaultApi.md#pingServer) | **GET** /ping | Checks if the server is running
[**sendAdvMail()**](DefaultApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail()**](DefaultApi.md#sendMail) | **POST** /mail/send | Sends an Email
[**viewMailLog()**](DefaultApi.md#viewMailLog) | **GET** /mail/log | displays the mail log


## `getMailOrders()`

```php
getMailOrders(): \Interserver\Mailbaby\Model\GetMailOrders200ResponseInner[]
```

displays a list of mail service orders

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new Interserver\Mailbaby\Api\DefaultApi(
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

[**\Interserver\Mailbaby\Model\GetMailOrders200ResponseInner[]**](../Model/GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

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



$apiInstance = new Interserver\Mailbaby\Api\DefaultApi(
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

## `sendAdvMail()`

```php
sendAdvMail($sendMailAdv): \Interserver\Mailbaby\Model\GenericResponse
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new Interserver\Mailbaby\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$sendMailAdv = new \Interserver\Mailbaby\Model\SendMailAdv(); // \Interserver\Mailbaby\Model\SendMailAdv

try {
    $result = $apiInstance->sendAdvMail($sendMailAdv);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendAdvMail: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailAdv** | [**\Interserver\Mailbaby\Model\SendMailAdv**](../Model/SendMailAdv.md)|  |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/json`, `application/x-www-form-urlencoded`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `sendMail()`

```php
sendMail($to, $from, $subject, $body): \Interserver\Mailbaby\Model\GenericResponse
```

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new Interserver\Mailbaby\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$to = 'to_example'; // string | The Contact whom is the primary recipient of this email.
$from = 'from_example'; // string | The contact whom is the this email is from.
$subject = 'subject_example'; // string | The subject or title of the email
$body = 'body_example'; // string | The main email contents.

try {
    $result = $apiInstance->sendMail($to, $from, $subject, $body);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendMail: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**| The Contact whom is the primary recipient of this email. |
 **from** | **string**| The contact whom is the this email is from. |
 **subject** | **string**| The subject or title of the email |
 **body** | **string**| The main email contents. |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `viewMailLog()`

```php
viewMailLog($id, $search, $skip, $limit): \Interserver\Mailbaby\Model\MailLog
```

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new Interserver\Mailbaby\Api\DefaultApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = 56; // int | The ID of your mail order this will be sent through.
$search = 'search_example'; // string | pass an optional search string for looking up inventory
$skip = 0; // int | number of records to skip for pagination
$limit = 100; // int | maximum number of records to return

try {
    $result = $apiInstance->viewMailLog($id, $search, $skip, $limit);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->viewMailLog: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional]
 **search** | **string**| pass an optional search string for looking up inventory | [optional]
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]

### Return type

[**\Interserver\Mailbaby\Model\MailLog**](../Model/MailLog.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
