# Interserver\Mailbaby\HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getstats) | **GET** /mail/stats | displays a list of blocked email addresses
[**viewMailLog**](HistoryApi.md#viewmaillog) | **GET** /mail/log | displays the mail log

# **getStats**
> \Interserver\Mailbaby\Model\InlineResponse200[] getStats()

displays a list of blocked email addresses

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Interserver\Mailbaby\Api\HistoryApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getStats();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling HistoryApi->getStats: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**\Interserver\Mailbaby\Model\InlineResponse200[]**](../Model/InlineResponse200.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **viewMailLog**
> \Interserver\Mailbaby\Model\MailLog viewMailLog($id, $origin, $mx, $from, $to, $subject, $mailid, $skip, $limit, $startDate, $endDate)

displays the mail log

Get a listing of the emails sent through this system

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');
// Configure API key authorization: apiKeyAuth
$config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKey('X-API-KEY', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Interserver\Mailbaby\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-API-KEY', 'Bearer');

$apiInstance = new Interserver\Mailbaby\Api\HistoryApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$id = 789; // int | The ID of your mail order this will be sent through.
$origin = "origin_example"; // string | originating ip address sending mail
$mx = "mx_example"; // string | mx record mail was sent to
$from = "from_example"; // string | from email address
$to = "to_example"; // string | to/destination email address
$subject = "subject_example"; // string | subject containing this string
$mailid = "mailid_example"; // string | mail id
$skip = 0; // int | number of records to skip for pagination
$limit = 100; // int | maximum number of records to return
$startDate = 789; // int | earliest date to get emails in unix timestamp format
$endDate = 789; // int | earliest date to get emails in unix timestamp format

try {
    $result = $apiInstance->viewMailLog($id, $origin, $mx, $from, $to, $subject, $mailid, $skip, $limit, $startDate, $endDate);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling HistoryApi->viewMailLog: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional]
 **origin** | **string**| originating ip address sending mail | [optional]
 **mx** | **string**| mx record mail was sent to | [optional]
 **from** | **string**| from email address | [optional]
 **to** | **string**| to/destination email address | [optional]
 **subject** | **string**| subject containing this string | [optional]
 **mailid** | **string**| mail id | [optional]
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]
 **startDate** | **int**| earliest date to get emails in unix timestamp format | [optional]
 **endDate** | **int**| earliest date to get emails in unix timestamp format | [optional]

### Return type

[**\Interserver\Mailbaby\Model\MailLog**](../Model/MailLog.md)

### Authorization

[apiKeyAuth](../../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

