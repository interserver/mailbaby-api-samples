# \BlockingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddRule**](BlockingAPI.md#AddRule) | **Post** /mail/rules | Creates a new email deny rule.
[**DeleteRule**](BlockingAPI.md#DeleteRule) | **Delete** /mail/rules/{ruleId} | Removes an deny mail rule.
[**DelistBlock**](BlockingAPI.md#DelistBlock) | **Post** /mail/blocks/delete | Removes an email address from the blocked list
[**GetMailBlocks**](BlockingAPI.md#GetMailBlocks) | **Get** /mail/blocks | displays a list of blocked email addresses
[**GetRules**](BlockingAPI.md#GetRules) | **Get** /mail/rules | Displays a listing of deny email rules.



## AddRule

> GenericResponse AddRule(ctx).Type_(type_).Data(data).User(user).Execute()

Creates a new email deny rule.



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {
    type_ := "type__example" // string | The type of deny rule.
    data := "data_example" // string | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    user := "user_example" // string | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional)

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.BlockingAPI.AddRule(context.Background()).Type_(type_).Data(data).User(user).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `BlockingAPI.AddRule``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `AddRule`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `BlockingAPI.AddRule`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiAddRuleRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type_** | **string** | The type of deny rule. | 
 **data** | **string** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **user** | **string** | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/x-www-form-urlencoded, application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DeleteRule

> GenericResponse DeleteRule(ctx, ruleId).Execute()

Removes an deny mail rule.



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {
    ruleId := int32(34) // int32 | The ID of the Rules entry.

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.BlockingAPI.DeleteRule(context.Background(), ruleId).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `BlockingAPI.DeleteRule``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `DeleteRule`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `BlockingAPI.DeleteRule`: %v\n", resp)
}
```

### Path Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**ctx** | **context.Context** | context for authentication, logging, cancellation, deadlines, tracing, etc.
**ruleId** | **int32** | The ID of the Rules entry. | 

### Other Parameters

Other parameters are passed through a pointer to a apiDeleteRuleRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------


### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## DelistBlock

> GenericResponse DelistBlock(ctx).EmailAddress(emailAddress).Execute()

Removes an email address from the blocked list



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {
    emailAddress := *openapiclient.NewEmailAddress() // EmailAddress | 

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.BlockingAPI.DelistBlock(context.Background()).EmailAddress(emailAddress).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `BlockingAPI.DelistBlock``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `DelistBlock`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `BlockingAPI.DelistBlock`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiDelistBlockRequest struct via the builder pattern


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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetMailBlocks

> MailBlocks GetMailBlocks(ctx).Execute()

displays a list of blocked email addresses

### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.BlockingAPI.GetMailBlocks(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `BlockingAPI.GetMailBlocks``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetMailBlocks`: MailBlocks
    fmt.Fprintf(os.Stdout, "Response from `BlockingAPI.GetMailBlocks`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetMailBlocksRequest struct via the builder pattern


### Return type

[**MailBlocks**](MailBlocks.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## GetRules

> []DenyRuleRecord GetRules(ctx).Execute()

Displays a listing of deny email rules.



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.BlockingAPI.GetRules(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `BlockingAPI.GetRules``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetRules`: []DenyRuleRecord
    fmt.Fprintf(os.Stdout, "Response from `BlockingAPI.GetRules`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetRulesRequest struct via the builder pattern


### Return type

[**[]DenyRuleRecord**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

