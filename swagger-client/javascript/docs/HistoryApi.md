# MailBabyEmailDeliveryAndManagementServiceApi.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryApi.md#getStats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryApi.md#viewMailLog) | **GET** /mail/log | displays the mail log

<a name="getStats"></a>
# **getStats**
> MailStatsType getStats(opts)

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```javascript
import {MailBabyEmailDeliveryAndManagementServiceApi} from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.HistoryApi();
let opts = { 
  'time': "time_example" // String | The timeframe for the statistics.
};
apiInstance.getStats(opts, (error, data, response) => {
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
 **time** | **String**| The timeframe for the statistics. | [optional] 

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="viewMailLog"></a>
# **viewMailLog**
> MailLog viewMailLog(opts)

displays the mail log

Get a listing of the emails sent through this system 

### Example
```javascript
import {MailBabyEmailDeliveryAndManagementServiceApi} from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.HistoryApi();
let opts = { 
  'id': 789, // Number | The ID of your mail order this will be sent through.
  'origin': "origin_example", // String | originating ip address sending mail
  'mx': "mx_example", // String | mx record mail was sent to
  'from': "from_example", // String | from email address
  'to': "to_example", // String | to/destination email address
  'subject': "subject_example", // String | subject containing this string
  'mailid': "mailid_example", // String | mail id
  'skip': 0, // Number | number of records to skip for pagination
  'limit': 100, // Number | maximum number of records to return
  'startDate': 789, // Number | earliest date to get emails in unix timestamp format
  'endDate': 789, // Number | earliest date to get emails in unix timestamp format
  'replyto': "replyto_example", // String | Reply-To Email Address
  'headerfrom': "headerfrom_example", // String | Header From Email Address
  'delivered': "delivered_example" // String | Limiting the emails to wether or not they were delivered.
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
 **delivered** | **String**| Limiting the emails to wether or not they were delivered. | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

