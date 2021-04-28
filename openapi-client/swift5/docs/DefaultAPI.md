# DefaultAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](DefaultAPI.md#getmailbyid) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders**](DefaultAPI.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](DefaultAPI.md#pingserver) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](DefaultAPI.md#placemailorder) | **POST** /mail/order | places a mail order
[**sendMailById**](DefaultAPI.md#sendmailbyid) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder**](DefaultAPI.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](DefaultAPI.md#viewmaillogbyid) | **GET** /mail/{id}/log | displays the mail log


# **getMailById**
```swift
    open class func getMailById(id: Int64, completion: @escaping (_ data: MailOrder?, _ error: Error?) -> Void)
```

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let id = 987 // Int64 | User ID

// Gets mail order information by id
DefaultAPI.getMailById(id: id) { (response, error) in
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
 **id** | **Int64** | User ID | 

### Return type

[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

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

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

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

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMailById**
```swift
    open class func sendMailById(id: Int64, subject: String? = nil, body: String? = nil, to: String? = nil, from: String? = nil, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Sends an Email

Sends An email through one of your mail orders.

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let id = 987 // Int64 | User ID
let subject = "subject_example" // String |  (optional)
let body = "body_example" // String |  (optional)
let to = "to_example" // String |  (optional)
let from = "from_example" // String |  (optional)

// Sends an Email
DefaultAPI.sendMailById(id: id, subject: subject, body: body, to: to, from: from) { (response, error) in
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
 **id** | **Int64** | User ID | 
 **subject** | **String** |  | [optional] 
 **body** | **String** |  | [optional] 
 **to** | **String** |  | [optional] 
 **from** | **String** |  | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
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

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLogById**
```swift
    open class func viewMailLogById(id: Int64, searchString: String? = nil, skip: Int? = nil, limit: Int? = nil, completion: @escaping (_ data: [MailLog]?, _ error: Error?) -> Void)
```

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example 
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let id = 987 // Int64 | User ID
let searchString = "searchString_example" // String | pass an optional search string for looking up inventory (optional)
let skip = 987 // Int | number of records to skip for pagination (optional)
let limit = 987 // Int | maximum number of records to return (optional)

// displays the mail log
DefaultAPI.viewMailLogById(id: id, searchString: searchString, skip: skip, limit: limit) { (response, error) in
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
 **id** | **Int64** | User ID | 
 **searchString** | **String** | pass an optional search string for looking up inventory | [optional] 
 **skip** | **Int** | number of records to skip for pagination | [optional] 
 **limit** | **Int** | maximum number of records to return | [optional] 

### Return type

[**[MailLog]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

