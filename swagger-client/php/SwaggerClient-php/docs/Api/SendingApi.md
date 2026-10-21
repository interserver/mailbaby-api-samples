# Swagger\Client\SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**rawMail**](SendingApi.md#rawmail) | **POST** /mail/rawsend | Send a pre-built RFC 822 message verbatim (preserves DKIM)
[**sendAdvMail**](SendingApi.md#sendadvmail) | **POST** /mail/advsend | Send email with multiple recipients, CC/BCC, attachments, named contacts
[**sendMail**](SendingApi.md#sendmail) | **POST** /mail/send | Send a simple email (single recipient, plain or HTML)

# **rawMail**
> \Swagger\Client\Model\GenericResponse rawMail($body)

Send a pre-built RFC 822 message verbatim (preserves DKIM)

**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Swagger\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$body = new \Swagger\Client\Model\SendMailRaw(); // \Swagger\Client\Model\SendMailRaw | 

try {
    $result = $apiInstance->rawMail($body);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SendingApi->rawMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**\Swagger\Client\Model\SendMailRaw**](../Model/SendMailRaw.md)|  |

### Return type

[**\Swagger\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **rawMail**
> \Swagger\Client\Model\GenericResponse rawMail($raw_email, $id)

Send a pre-built RFC 822 message verbatim (preserves DKIM)

**Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: `raw_email` (full RFC 822 string with headers + body). Optional: `id` (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Swagger\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$raw_email = "raw_email_example"; // string | 
$id = 789; // int | 

try {
    $result = $apiInstance->rawMail($raw_email, $id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SendingApi->rawMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **raw_email** | **string**|  |
 **id** | **int**|  |

### Return type

[**\Swagger\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendAdvMail**
> \Swagger\Client\Model\GenericResponse sendAdvMail($subject, $body, $from, $to, $replyto, $cc, $bcc, $attachments, $id)

Send email with multiple recipients, CC/BCC, attachments, named contacts

**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ```

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Swagger\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$subject = "subject_example"; // string | 
$body = "body_example"; // string | 
$from = new \Swagger\Client\Model\null(); //  | 
$to = new \Swagger\Client\Model\null(); //  | 
$replyto = new \Swagger\Client\Model\null(); //  | 
$cc = new \Swagger\Client\Model\null(); //  | 
$bcc = new \Swagger\Client\Model\null(); //  | 
$attachments = array(new \Swagger\Client\Model\MailAttachment()); // \Swagger\Client\Model\MailAttachment[] | 
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
 **from** | [****](../Model/.md)|  |
 **to** | [****](../Model/.md)|  |
 **replyto** | [****](../Model/.md)|  |
 **cc** | [****](../Model/.md)|  |
 **bcc** | [****](../Model/.md)|  |
 **attachments** | [**\Swagger\Client\Model\MailAttachment[]**](../Model/\Swagger\Client\Model\MailAttachment.md)|  |
 **id** | **int**|  |

### Return type

[**\Swagger\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendAdvMail**
> \Swagger\Client\Model\GenericResponse sendAdvMail($body)

Send email with multiple recipients, CC/BCC, attachments, named contacts

**Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: `from`, `to`, `subject`, `body`. Optional: `cc`, `bcc`, `replyto`, `attachments` (array of `{filename,data}` with base64 data), `id`. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' \\   -d 'body=Hello' \\   -d 'from=Joe <user@domain.com>' \\   -d 'to=Jane <support@interserver.net>' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/x-www-form-urlencoded' \\   -d 'subject=Welcome' -d 'body=Hello' \\   -d from=user@domain.com \\   -d 'to[0][name]=Joe' -d 'to[0][email]=support@interserver.net' \\   -d 'to[1][name]=Jane' -d 'to[1][email]=jane@interserver.net' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H 'X-API-KEY: YOUR_API_KEY' \\   -H 'Content-Type: application/json' \\   -d '{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }' ```

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Swagger\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$body = new \Swagger\Client\Model\SendMailAdv(); // \Swagger\Client\Model\SendMailAdv | 

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
 **body** | [**\Swagger\Client\Model\SendMailAdv**](../Model/SendMailAdv.md)|  |

### Return type

[**\Swagger\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendMail**
> \Swagger\Client\Model\GenericResponse sendMail($to, $from, $subject, $body, $id)

Send a simple email (single recipient, plain or HTML)

**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Swagger\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$to = new \Swagger\Client\Model\SendMailTo(); // \Swagger\Client\Model\SendMailTo | 
$from = "from_example"; // string | 
$subject = "subject_example"; // string | 
$body = "body_example"; // string | 
$id = 789; // int | 

try {
    $result = $apiInstance->sendMail($to, $from, $subject, $body, $id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SendingApi->sendMail: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | [**\Swagger\Client\Model\SendMailTo**](../Model/.md)|  |
 **from** | **string**|  |
 **subject** | **string**|  |
 **body** | **string**|  |
 **id** | **int**|  |

### Return type

[**\Swagger\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **sendMail**
> \Swagger\Client\Model\GenericResponse sendMail($body)

Send a simple email (single recipient, plain or HTML)

**Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: `from`, `to`, `subject`, `body`. Optional: `id` (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record.

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Swagger\Client\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Swagger\Client\Api\SendingApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$body = new \Swagger\Client\Model\SendMail(); // \Swagger\Client\Model\SendMail | 

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
 **body** | [**\Swagger\Client\Model\SendMail**](../Model/SendMail.md)|  |

### Return type

[**\Swagger\Client\Model\GenericResponse**](../Model/GenericResponse.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

