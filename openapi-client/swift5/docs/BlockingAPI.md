# BlockingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addRule**](BlockingAPI.md#addrule) | **POST** /mail/rules | Creates a new email deny rule.
[**deleteRule**](BlockingAPI.md#deleterule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delistBlock**](BlockingAPI.md#delistblock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**getMailBlocks**](BlockingAPI.md#getmailblocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**getRules**](BlockingAPI.md#getrules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **addRule**
```swift
    open class func addRule(type: ModelType_addRule, data: String, user: String? = nil, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let type = "type_example" // String | The type of deny rule.
let data = "data_example" // String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
let user = "user_example" // String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional)

// Creates a new email deny rule.
BlockingAPI.addRule(type: type, data: data, user: user) { (response, error) in
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
 **type** | **String** | The type of deny rule. | 
 **data** | **String** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **user** | **String** | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteRule**
```swift
    open class func deleteRule(ruleId: Int, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let ruleId = 987 // Int | The ID of the Rules entry.

// Removes an deny mail rule.
BlockingAPI.deleteRule(ruleId: ruleId) { (response, error) in
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
 **ruleId** | **Int** | The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delistBlock**
```swift
    open class func delistBlock(emailAddress: EmailAddress, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let emailAddress = EmailAddress(email: "email_example") // EmailAddress | 

// Removes an email address from the blocked list
BlockingAPI.delistBlock(emailAddress: emailAddress) { (response, error) in
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
 **emailAddress** | [**EmailAddress**](EmailAddress.md) |  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMailBlocks**
```swift
    open class func getMailBlocks(completion: @escaping (_ data: MailBlocks?, _ error: Error?) -> Void)
```

displays a list of blocked email addresses

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// displays a list of blocked email addresses
BlockingAPI.getMailBlocks() { (response, error) in
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

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRules**
```swift
    open class func getRules(completion: @escaping (_ data: [DenyRuleRecord]?, _ error: Error?) -> Void)
```

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient


// Displays a listing of deny email rules.
BlockingAPI.getRules() { (response, error) in
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

[**[DenyRuleRecord]**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

