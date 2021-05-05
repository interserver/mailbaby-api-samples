# Interserver\Mailbaby\DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
[**sendAdvMail**](DefaultApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultApi.md#sendmail) | **POST** /mail/send | Sends an Email
[**validateMailOrder**](DefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultApi.md#viewmaillogbyid) | **GET** /mail/log | displays the mail log

# **getMailOrders**
> \Interserver\Mailbaby\Model\MailOrders getMailOrders($id)

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
$id = 789; // int | The ID of your mail order this will be sent through.

try {
    $result = $apiInstance->getMailOrders($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->getMailOrders: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional]

### Return type

[**\Interserver\Mailbaby\Model\MailOrders**](../Model/MailOrders.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **pingServer**
> pingServer()

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
?>
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

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **placeMailOrder**
> placeMailOrder($body)

places a mail order

Adds an item to the system

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
$body = new \Interserver\Mailbaby\Model\MailOrder(); // \Interserver\Mailbaby\Model\MailOrder | Inventory item to add

try {
    $apiInstance->placeMailOrder($body);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->placeMailOrder: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**\Interserver\Mailbaby\Model\MailOrder**](../Model/MailOrder.md)| Inventory item to add | [optional]

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendAdvMail**
> \Interserver\Mailbaby\Model\GenericResponse sendAdvMail($body)

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
$body = new \Interserver\Mailbaby\Model\SendMailAdv(); // \Interserver\Mailbaby\Model\SendMailAdv | 

try {
    $result = $apiInstance->sendAdvMail($body);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendAdvMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**\Interserver\Mailbaby\Model\SendMailAdv**](../Model/SendMailAdv.md)|  |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendAdvMail**
> \Interserver\Mailbaby\Model\GenericResponse sendAdvMail($subject, $body, $from, $to, $id, $replyto, $cc, $bcc, $attachments)

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
$subject = "subject_example"; // string | 
$body = "body_example"; // string | 
$from = array(new \Interserver\Mailbaby\Model\SendMailAdvFrom()); // \Interserver\Mailbaby\Model\SendMailAdvFrom[] | 
$to = array(new \Interserver\Mailbaby\Model\MailContact()); // \Interserver\Mailbaby\Model\MailContact[] | 
$id = 789; // int | 
$replyto = array(new \Interserver\Mailbaby\Model\MailContact()); // \Interserver\Mailbaby\Model\MailContact[] | 
$cc = array(new \Interserver\Mailbaby\Model\MailContact()); // \Interserver\Mailbaby\Model\MailContact[] | 
$bcc = array(new \Interserver\Mailbaby\Model\MailContact()); // \Interserver\Mailbaby\Model\MailContact[] | 
$attachments = array(new \Interserver\Mailbaby\Model\MailAttachment()); // \Interserver\Mailbaby\Model\MailAttachment[] | 

try {
    $result = $apiInstance->sendAdvMail($subject, $body, $from, $to, $id, $replyto, $cc, $bcc, $attachments);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendAdvMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string**|  |
 **body** | **string**|  |
 **from** | [**\Interserver\Mailbaby\Model\SendMailAdvFrom[]**](../Model/\Interserver\Mailbaby\Model\SendMailAdvFrom.md)|  |
 **to** | [**\Interserver\Mailbaby\Model\MailContact[]**](../Model/\Interserver\Mailbaby\Model\MailContact.md)|  |
 **id** | **int**|  |
 **replyto** | [**\Interserver\Mailbaby\Model\MailContact[]**](../Model/\Interserver\Mailbaby\Model\MailContact.md)|  |
 **cc** | [**\Interserver\Mailbaby\Model\MailContact[]**](../Model/\Interserver\Mailbaby\Model\MailContact.md)|  |
 **bcc** | [**\Interserver\Mailbaby\Model\MailContact[]**](../Model/\Interserver\Mailbaby\Model\MailContact.md)|  |
 **attachments** | [**\Interserver\Mailbaby\Model\MailAttachment[]**](../Model/\Interserver\Mailbaby\Model\MailAttachment.md)|  |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendMail**
> \Interserver\Mailbaby\Model\GenericResponse sendMail($to, $from, $subject, $body)

Sends an Email

Sends An email through one of your mail orders.

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
$to = "to_example"; // string | 
$from = "from_example"; // string | 
$subject = "subject_example"; // string | 
$body = "body_example"; // string | 

try {
    $result = $apiInstance->sendMail($to, $from, $subject, $body);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string**|  |
 **from** | **string**|  |
 **subject** | **string**|  |
 **body** | **string**|  |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendMail**
> \Interserver\Mailbaby\Model\GenericResponse sendMail($body)

Sends an Email

Sends An email through one of your mail orders.

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
$body = new \Interserver\Mailbaby\Model\SendMail(); // \Interserver\Mailbaby\Model\SendMail | 

try {
    $result = $apiInstance->sendMail($body);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->sendMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**\Interserver\Mailbaby\Model\SendMail**](../Model/SendMail.md)|  |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **validateMailOrder**
> validateMailOrder()

validatess order details before placing an order

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
    $apiInstance->validateMailOrder();
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->validateMailOrder: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **viewMailLogById**
> \Interserver\Mailbaby\Model\MailLog[] viewMailLogById($id, $searchString, $skip, $limit)

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
$id = 789; // int | The ID of your mail order this will be sent through.
$searchString = "searchString_example"; // string | pass an optional search string for looking up inventory
$skip = 56; // int | number of records to skip for pagination
$limit = 56; // int | maximum number of records to return

try {
    $result = $apiInstance->viewMailLogById($id, $searchString, $skip, $limit);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling DefaultApi->viewMailLogById: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional]
 **searchString** | **string**| pass an optional search string for looking up inventory | [optional]
 **skip** | **int**| number of records to skip for pagination | [optional]
 **limit** | **int**| maximum number of records to return | [optional]

### Return type

[**\Interserver\Mailbaby\Model\MailLog[]**](../Model/MailLog.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

