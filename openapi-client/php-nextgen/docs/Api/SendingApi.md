# OpenAPI\Client\SendingApi

All URIs are relative to https://api.mailbaby.net, except if the operation defines another base path.

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**sendAdvMail()**](SendingApi.md#sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options |
| [**sendMail()**](SendingApi.md#sendMail) | **POST** /mail/send | Sends an Email |


## `sendAdvMail()`

```php
sendAdvMail($subject, $body, $from, $to, $replyto, $cc, $bcc, $attachments, $id): \OpenAPI\Client\Model\GenericResponse
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ```

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$subject = 'subject_example'; // string | The subject or title of the email
$body = 'body_example'; // string | The main email contents.
$from = new \OpenAPI\Client\Model\EmailAddressTypes(); // \OpenAPI\Client\Model\EmailAddressTypes
$to = new \OpenAPI\Client\Model\EmailAddressesTypes(); // \OpenAPI\Client\Model\EmailAddressesTypes
$replyto = new \OpenAPI\Client\Model\EmailAddressesTypes(); // \OpenAPI\Client\Model\EmailAddressesTypes
$cc = new \OpenAPI\Client\Model\EmailAddressesTypes(); // \OpenAPI\Client\Model\EmailAddressesTypes
$bcc = new \OpenAPI\Client\Model\EmailAddressesTypes(); // \OpenAPI\Client\Model\EmailAddressesTypes
$attachments = array(new \OpenAPI\Client\Model\\OpenAPI\Client\Model\MailAttachment()); // \OpenAPI\Client\Model\MailAttachment[] | (optional) File attachments to include in the email.  The file contents must be base64 encoded!
$id = 56; // int | (optional)  ID of the Mail order within our system to use as the Mail Account.

try {
    $result = $apiInstance->sendAdvMail($subject, $body, $from, $to, $replyto, $cc, $bcc, $attachments, $id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SendingApi->sendAdvMail: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **subject** | **string**| The subject or title of the email | |
| **body** | **string**| The main email contents. | |
| **from** | [**\OpenAPI\Client\Model\EmailAddressTypes**](../Model/EmailAddressTypes.md)|  | |
| **to** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](../Model/EmailAddressesTypes.md)|  | |
| **replyto** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](../Model/EmailAddressesTypes.md)|  | [optional] |
| **cc** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](../Model/EmailAddressesTypes.md)|  | [optional] |
| **bcc** | [**\OpenAPI\Client\Model\EmailAddressesTypes**](../Model/EmailAddressesTypes.md)|  | [optional] |
| **attachments** | [**\OpenAPI\Client\Model\MailAttachment[]**](../Model/\OpenAPI\Client\Model\MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] |
| **id** | **int**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] |

### Return type

[**\OpenAPI\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `sendMail()`

```php
sendMail($to, $from, $subject, $body): \OpenAPI\Client\Model\GenericResponse
```

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKeyAuth
$config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = OpenAPI\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');


$apiInstance = new OpenAPI\Client\Api\SendingApi(
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
    echo 'Exception when calling SendingApi->sendMail: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **to** | **string**| The Contact whom is the primary recipient of this email. | |
| **from** | **string**| The contact whom is the this email is from. | |
| **subject** | **string**| The subject or title of the email | |
| **body** | **string**| The main email contents. | |

### Return type

[**\OpenAPI\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: `application/x-www-form-urlencoded`, `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
