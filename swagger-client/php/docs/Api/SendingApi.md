# Interserver\Mailbaby\SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Sends an Email

# **sendAdvMail**
> \Interserver\Mailbaby\Model\GenericResponse sendAdvMail($subject, $body, $from, $to, $replyto, $cc, $bcc, $attachments, $id)

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

$apiInstance = new Interserver\Mailbaby\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$subject = "subject_example"; // string | 
$body = "body_example"; // string | 
$from = new \Interserver\Mailbaby\Model\EmailAddressName(); // \Interserver\Mailbaby\Model\EmailAddressName | 
$to = array(new \Interserver\Mailbaby\Model\EmailAddressName()); // \Interserver\Mailbaby\Model\EmailAddressName[] | 
$replyto = array(new \Interserver\Mailbaby\Model\EmailAddressName()); // \Interserver\Mailbaby\Model\EmailAddressName[] | 
$cc = array(new \Interserver\Mailbaby\Model\EmailAddressName()); // \Interserver\Mailbaby\Model\EmailAddressName[] | 
$bcc = array(new \Interserver\Mailbaby\Model\EmailAddressName()); // \Interserver\Mailbaby\Model\EmailAddressName[] | 
$attachments = array(new \Interserver\Mailbaby\Model\MailAttachment()); // \Interserver\Mailbaby\Model\MailAttachment[] | 
$id = 789; // int | 

try {
    $result = $apiInstance->sendAdvMail($subject, $body, $from, $to, $replyto, $cc, $bcc, $attachments, $id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SendingApi->sendAdvMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string**|  |
 **body** | **string**|  |
 **from** | [**\Interserver\Mailbaby\Model\EmailAddressName**](../Model/.md)|  |
 **to** | [**\Interserver\Mailbaby\Model\EmailAddressName[]**](../Model/\Interserver\Mailbaby\Model\EmailAddressName.md)|  |
 **replyto** | [**\Interserver\Mailbaby\Model\EmailAddressName[]**](../Model/\Interserver\Mailbaby\Model\EmailAddressName.md)|  |
 **cc** | [**\Interserver\Mailbaby\Model\EmailAddressName[]**](../Model/\Interserver\Mailbaby\Model\EmailAddressName.md)|  |
 **bcc** | [**\Interserver\Mailbaby\Model\EmailAddressName[]**](../Model/\Interserver\Mailbaby\Model\EmailAddressName.md)|  |
 **attachments** | [**\Interserver\Mailbaby\Model\MailAttachment[]**](../Model/\Interserver\Mailbaby\Model\MailAttachment.md)|  |
 **id** | **int**|  |

### Return type

[**\Interserver\Mailbaby\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

$apiInstance = new Interserver\Mailbaby\Api\SendingApi(
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
    echo 'Exception when calling SendingApi->sendAdvMail: ', $e->getMessage(), PHP_EOL;
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

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendMail**
> \Interserver\Mailbaby\Model\GenericResponse sendMail($to, $from, $subject, $body)

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

$apiInstance = new Interserver\Mailbaby\Api\SendingApi(
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
    echo 'Exception when calling SendingApi->sendMail: ', $e->getMessage(), PHP_EOL;
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

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Interserver\Mailbaby\Api\SendingApi(
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
    echo 'Exception when calling SendingApi->sendMail: ', $e->getMessage(), PHP_EOL;
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

