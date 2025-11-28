# HistoryAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getStats**](HistoryAPI.md#getstats) | **GET** /mail/stats | Account usage statistics.
[**viewMailLog**](HistoryAPI.md#viewmaillog) | **GET** /mail/log | displays the mail log


# **getStats**
```swift
    open class func getStats(time: Time_getStats? = nil, completion: @escaping (_ data: MailStatsType?, _ error: Error?) -> Void)
```

Account usage statistics.

Returns information about the usage on your mail accounts.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let time = "time_example" // String | The timeframe for the statistics. (optional)

// Account usage statistics.
HistoryAPI.getStats(time: time) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **time** | **String** | The timeframe for the statistics. | [optional] 

### Return type

[**MailStatsType**](MailStatsType.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
```swift
    open class func viewMailLog(id: Int64? = nil, origin: String? = nil, mx: String? = nil, from: String? = nil, to: String? = nil, subject: String? = nil, mailid: String? = nil, skip: Int? = nil, limit: Int? = nil, startDate: Int64? = nil, endDate: Int64? = nil, replyto: String? = nil, headerfrom: String? = nil, delivered: Delivered_viewMailLog? = nil, completion: @escaping (_ data: MailLog?, _ error: Error?) -> Void)
```

displays the mail log

Get a listing of the emails sent through this system 

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let id = 987 // Int64 | The ID of your mail order this will be sent through. (optional)
let origin = "origin_example" // String | originating ip address sending mail (optional)
let mx = "mx_example" // String | mx record mail was sent to (optional)
let from = "from_example" // String | from email address (optional)
let to = "to_example" // String | to/destination email address (optional)
let subject = "subject_example" // String | subject containing this string (optional)
let mailid = "mailid_example" // String | mail id (optional)
let skip = 987 // Int | number of records to skip for pagination (optional) (default to 0)
let limit = 987 // Int | maximum number of records to return (optional) (default to 100)
let startDate = 987 // Int64 | earliest date to get emails in unix timestamp format (optional)
let endDate = 987 // Int64 | earliest date to get emails in unix timestamp format (optional)
let replyto = "replyto_example" // String | Reply-To Email Address (optional)
let headerfrom = "headerfrom_example" // String | Header From Email Address (optional)
let delivered = "delivered_example" // String | Limiting the emails to wether or not they were delivered. (optional)

// displays the mail log
HistoryAPI.viewMailLog(id: id, origin: origin, mx: mx, from: from, to: to, subject: subject, mailid: mailid, skip: skip, limit: limit, startDate: startDate, endDate: endDate, replyto: replyto, headerfrom: headerfrom, delivered: delivered) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Int64** | The ID of your mail order this will be sent through. | [optional] 
 **origin** | **String** | originating ip address sending mail | [optional] 
 **mx** | **String** | mx record mail was sent to | [optional] 
 **from** | **String** | from email address | [optional] 
 **to** | **String** | to/destination email address | [optional] 
 **subject** | **String** | subject containing this string | [optional] 
 **mailid** | **String** | mail id | [optional] 
 **skip** | **Int** | number of records to skip for pagination | [optional] [default to 0]
 **limit** | **Int** | maximum number of records to return | [optional] [default to 100]
 **startDate** | **Int64** | earliest date to get emails in unix timestamp format | [optional] 
 **endDate** | **Int64** | earliest date to get emails in unix timestamp format | [optional] 
 **replyto** | **String** | Reply-To Email Address | [optional] 
 **headerfrom** | **String** | Header From Email Address | [optional] 
 **delivered** | **String** | Limiting the emails to wether or not they were delivered. | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

