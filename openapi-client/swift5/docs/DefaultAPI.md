# DefaultAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultAPI.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultAPI.md#pingserver) | **GET** /ping | Checks if the server is running
[**sendAdvMail**](DefaultAPI.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultAPI.md#sendmail) | **POST** /mail/send | Sends an Email
[**viewMailLog**](DefaultAPI.md#viewmaillog) | **GET** /mail/log | displays the mail log


# **getMailOrders**
```swift
    open class func getMailOrders(completion: @escaping (_ data: [GetMailOrders200ResponseInner]?, _ error: Error?) -> Void)
```

displays a list of mail service orders

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// displays a list of mail service orders
DefaultAPI.getMailOrders() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[GetMailOrders200ResponseInner]**](GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pingServer**
```swift
    open class func pingServer(completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Checks if the server is running

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// Checks if the server is running
DefaultAPI.pingServer() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendAdvMail**
```swift
    open class func sendAdvMail(sendMailAdv: SendMailAdv, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let sendMailAdv = SendMailAdv(subject: "subject_example", body: "body_example", from: SendMailAdv_from(email: "email_example", name: "name_example"), to: [SendMailAdv_to_inner(email: "email_example", name: "name_example")], replyto: [SendMailAdv_replyto_inner(email: "email_example", name: "name_example")], cc: [SendMailAdv_cc_inner(email: "email_example", name: "name_example")], bcc: [SendMailAdv_bcc_inner(email: "email_example", name: "name_example")], attachments: [SendMailAdv_attachments_inner(data: URL(string: "https://example.com")!, filename: "filename_example")], id: 123) // SendMailAdv | 

// Sends an Email with Advanced Options
DefaultAPI.sendAdvMail(sendMailAdv: sendMailAdv) { (response, error) in
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
 **sendMailAdv** | [**SendMailAdv**](SendMailAdv.md) |  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
```swift
    open class func sendMail(to: String, from: String, subject: String, body: String, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let to = "to_example" // String | The Contact whom is the primary recipient of this email.
let from = "from_example" // String | The contact whom is the this email is from.
let subject = "subject_example" // String | The subject or title of the email
let body = "body_example" // String | The main email contents.

// Sends an Email
DefaultAPI.sendMail(to: to, from: from, subject: subject, body: body) { (response, error) in
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
 **to** | **String** | The Contact whom is the primary recipient of this email. | 
 **from** | **String** | The contact whom is the this email is from. | 
 **subject** | **String** | The subject or title of the email | 
 **body** | **String** | The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
```swift
    open class func viewMailLog(id: Int64? = nil, origin: String? = nil, mx: String? = nil, from: String? = nil, to: String? = nil, subject: String? = nil, mailid: String? = nil, skip: Int? = nil, limit: Int? = nil, startDate: Int64? = nil, endDate: Int64? = nil, completion: @escaping (_ data: MailLog?, _ error: Error?) -> Void)
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

// displays the mail log
DefaultAPI.viewMailLog(id: id, origin: origin, mx: mx, from: from, to: to, subject: subject, mailid: mailid, skip: skip, limit: limit, startDate: startDate, endDate: endDate) { (response, error) in
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

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

