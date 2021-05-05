# \DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#GetMailOrders) | **Get** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#PingServer) | **Get** /ping | Checks if the server is running
[**PlaceMailOrder**](DefaultApi.md#PlaceMailOrder) | **Post** /mail/order | places a mail order
[**SendAdvMailById**](DefaultApi.md#SendAdvMailById) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMailById**](DefaultApi.md#SendMailById) | **Post** /mail/send | Sends an Email
[**ValidateMailOrder**](DefaultApi.md#ValidateMailOrder) | **Get** /mail/order | validatess order details before placing an order
[**ViewMailLogById**](DefaultApi.md#ViewMailLogById) | **Get** /mail/log | displays the mail log



## GetMailOrders

> []MailOrder GetMailOrders(ctx).Id(id).Execute()

displays a list of mail service orders

### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {
    id := int64(789) // int64 | The ID of your mail order this will be sent through. (optional)

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.GetMailOrders(context.Background()).Id(id).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.GetMailOrders``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetMailOrders`: []MailOrder
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.GetMailOrders`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiGetMailOrdersRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int64** | The ID of your mail order this will be sent through. | 

### Return type

[**[]MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PingServer

> PingServer(ctx).Execute()

Checks if the server is running

### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.PingServer(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.PingServer``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiPingServerRequest struct via the builder pattern


### Return type

 (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## PlaceMailOrder

> PlaceMailOrder(ctx).MailOrder(mailOrder).Execute()

places a mail order



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {
    mailOrder := *openapiclient.NewMailOrder(int32(1234), "active", "mb1234") // MailOrder | Inventory item to add (optional)

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.PlaceMailOrder(context.Background()).MailOrder(mailOrder).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.PlaceMailOrder``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiPlaceMailOrderRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mailOrder** | [**MailOrder**](MailOrder.md) | Inventory item to add | 

### Return type

 (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SendAdvMailById

> GenericResponse SendAdvMailById(ctx).SendMail(sendMail).Execute()

Sends an Email with Advanced Options



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {
    sendMail := *openapiclient.NewSendMail("Your Package has been Delivered!", "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
", *openapiclient.NewMailContact("johndoe@company.com"), []openapiclient.MailContact{*openapiclient.NewMailContact("johndoe@company.com")}, int64(5000)) // SendMail | 

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.SendAdvMailById(context.Background()).SendMail(sendMail).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.SendAdvMailById``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SendAdvMailById`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.SendAdvMailById`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSendAdvMailByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMail** | [**SendMail**](SendMail.md) |  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SendMailById

> GenericResponse SendMailById(ctx).SendMail(sendMail).Execute()

Sends an Email



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {
    sendMail := *openapiclient.NewSendMail("Your Package has been Delivered!", "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.
", *openapiclient.NewMailContact("johndoe@company.com"), []openapiclient.MailContact{*openapiclient.NewMailContact("johndoe@company.com")}, int64(5000)) // SendMail | 

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.SendMailById(context.Background()).SendMail(sendMail).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.SendMailById``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SendMailById`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.SendMailById`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSendMailByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMail** | [**SendMail**](SendMail.md) |  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: application/json, application/x-www-form-urlencoded
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ValidateMailOrder

> ValidateMailOrder(ctx).Execute()

validatess order details before placing an order

### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.ValidateMailOrder(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.ValidateMailOrder``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiValidateMailOrderRequest struct via the builder pattern


### Return type

 (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ViewMailLogById

> []MailLog ViewMailLogById(ctx).Id(id).SearchString(searchString).Skip(skip).Limit(limit).Execute()

displays the mail log



### Example

```go
package main

import (
    "context"
    "fmt"
    "os"
    openapiclient "./openapi"
)

func main() {
    id := int64(789) // int64 | The ID of your mail order this will be sent through. (optional)
    searchString := "searchString_example" // string | pass an optional search string for looking up inventory (optional)
    skip := int32(56) // int32 | number of records to skip for pagination (optional)
    limit := int32(56) // int32 | maximum number of records to return (optional)

    configuration := openapiclient.NewConfiguration()
    api_client := openapiclient.NewAPIClient(configuration)
    resp, r, err := api_client.DefaultApi.ViewMailLogById(context.Background()).Id(id).SearchString(searchString).Skip(skip).Limit(limit).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.ViewMailLogById``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `ViewMailLogById`: []MailLog
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.ViewMailLogById`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiViewMailLogByIdRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int64** | The ID of your mail order this will be sent through. | 
 **searchString** | **string** | pass an optional search string for looking up inventory | 
 **skip** | **int32** | number of records to skip for pagination | 
 **limit** | **int32** | maximum number of records to return | 

### Return type

[**[]MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

