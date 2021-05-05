# DefaultAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailOrders**](DefaultAPI.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultAPI.md#pingserver) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultAPI.md#placemailorder) | **POST** /mail/order | places a mail order
[**sendAdvMail**](DefaultAPI.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](DefaultAPI.md#sendmail) | **POST** /mail/send | Sends an Email
[**validateMailOrder**](DefaultAPI.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLog**](DefaultAPI.md#viewmaillog) | **GET** /mail/log | displays the mail log


# **getMailOrders**
```swift
    open class func getMailOrders(completion: @escaping (_ data: [MailOrder]?, _ error: Error?) -> Void)
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

[**[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

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

# **placeMailOrder**
```swift
    open class func placeMailOrder(mailOrder: MailOrder? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

places a mail order

Adds an item to the system

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let mailOrder = MailOrder(id: 123, status: "status_example", username: "username_example", password: "password_example", comment: "comment_example") // MailOrder | Inventory item to add (optional)

// places a mail order
DefaultAPI.placeMailOrder(mailOrder: mailOrder) { (response, error) in
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
 **mailOrder** | [**MailOrder**](MailOrder.md) | Inventory item to add | [optional] 

### Return type

Void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

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

let sendMailAdv = SendMailAdv(subject: "subject_example", body: "body_example", from: [SendMailAdv_from(email: "email_example", name: "name_example")], to: [MailContact(email: "email_example", name: "name_example")], id: 123, replyto: [nil], cc: [nil], bcc: [nil], attachments: [MailAttachment(data: URL(string: "https://example.com")!, filename: "filename_example")]) // SendMailAdv | 

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

Sends An email through one of your mail orders.

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

# **validateMailOrder**
```swift
    open class func validateMailOrder(completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

validatess order details before placing an order

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// validatess order details before placing an order
DefaultAPI.validateMailOrder() { (response, error) in
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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLog**
```swift
    open class func viewMailLog(id: Int64? = nil, searchString: String? = nil, skip: Int? = nil, limit: Int? = nil, completion: @escaping (_ data: [MailLog]?, _ error: Error?) -> Void)
```

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let id = 987 // Int64 | The ID of your mail order this will be sent through. (optional)
let searchString = "searchString_example" // String | pass an optional search string for looking up inventory (optional)
let skip = 987 // Int | number of records to skip for pagination (optional)
let limit = 987 // Int | maximum number of records to return (optional)

// displays the mail log
DefaultAPI.viewMailLog(id: id, searchString: searchString, skip: skip, limit: limit) { (response, error) in
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
 **searchString** | **String** | pass an optional search string for looking up inventory | [optional] 
 **skip** | **Int** | number of records to skip for pagination | [optional] 
 **limit** | **Int** | maximum number of records to return | [optional] 

### Return type

[**[MailLog]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

