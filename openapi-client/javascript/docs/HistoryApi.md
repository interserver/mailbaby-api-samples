# MailBabyEmailDeliveryAndManagementServiceApi.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log



## getStats

> [GetStats200ResponseInner] getStats()

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.HistoryApi();
apiInstance.getStats((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**[GetStats200ResponseInner]**](GetStats200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## viewMailLog

> MailLog viewMailLog(opts)

displays the mail log

Get a listing of the emails sent through this system 

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;
// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.HistoryApi();
let opts = {
  'id': 2604, // Number | The ID of your mail order this will be sent through.
  'origin': 1.2.3.4, // String | originating ip address sending mail
  'mx': mx.google.com, // String | mx record mail was sent to
  'from': me@sender.com, // String | from email address
  'to': you@receiver.com, // String | to/destination email address
  'subject': Support, // String | subject containing this string
  'mailid': 185997065c60008840, // String | mail id
  'skip': 1000, // Number | number of records to skip for pagination
  'limit': 1000, // Number | maximum number of records to return
  'startDate': 1641781008, // Number | earliest date to get emails in unix timestamp format
  'endDate': 1673317008, // Number | earliest date to get emails in unix timestamp format
  'replyto': "replyto_example", // String | Reply-To Email Address
  'headerfrom': "headerfrom_example" // String | Header From Email Address
};
apiInstance.viewMailLog(opts, (error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **String**| originating ip address sending mail | [optional] 
 **mx** | **String**| mx record mail was sent to | [optional] 
 **from** | **String**| from email address | [optional] 
 **to** | **String**| to/destination email address | [optional] 
 **subject** | **String**| subject containing this string | [optional] 
 **mailid** | **String**| mail id | [optional] 
 **skip** | **Number**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **Number**| maximum number of records to return | [optional] [default to 100]
 **startDate** | **Number**| earliest date to get emails in unix timestamp format | [optional] 
 **endDate** | **Number**| earliest date to get emails in unix timestamp format | [optional] 
 **replyto** | **String**| Reply-To Email Address | [optional] 
 **headerfrom** | **String**| Header From Email Address | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

