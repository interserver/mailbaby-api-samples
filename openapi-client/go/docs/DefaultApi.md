# \DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetMailOrders**](DefaultApi.md#GetMailOrders) | **Get** /mail | displays a list of mail service orders
[**PingServer**](DefaultApi.md#PingServer) | **Get** /ping | Checks if the server is running
[**SendAdvMail**](DefaultApi.md#SendAdvMail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](DefaultApi.md#SendMail) | **Post** /mail/send | Sends an Email
[**ViewMailLog**](DefaultApi.md#ViewMailLog) | **Get** /mail/log | displays the mail log



## GetMailOrders

> []GetMailOrders200ResponseInner GetMailOrders(ctx).Execute()

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

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.DefaultApi.GetMailOrders(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.GetMailOrders``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetMailOrders`: []GetMailOrders200ResponseInner
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.GetMailOrders`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetMailOrdersRequest struct via the builder pattern


### Return type

[**[]GetMailOrders200ResponseInner**](GetMailOrders200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

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
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.DefaultApi.PingServer(context.Background()).Execute()
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


## SendAdvMail

> GenericResponse SendAdvMail(ctx).SendMailAdv(sendMailAdv).Execute()

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
    sendMailAdv := *openapiclient.NewSendMailAdv("Your Package has been Delivered!", "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", *openapiclient.NewSendMailAdvFrom("business@company.com"), []openapiclient.SendMailAdvToInner{*openapiclient.NewSendMailAdvToInner("johndoe@isp.com")}) // SendMailAdv | 

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.DefaultApi.SendAdvMail(context.Background()).SendMailAdv(sendMailAdv).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.SendAdvMail``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SendAdvMail`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.SendAdvMail`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSendAdvMailRequest struct via the builder pattern


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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## SendMail

> GenericResponse SendMail(ctx).To(to).From(from).Subject(subject).Body(body).Execute()

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
    to := "to_example" // string | The Contact whom is the primary recipient of this email.
    from := "from_example" // string | The contact whom is the this email is from.
    subject := "subject_example" // string | The subject or title of the email
    body := "body_example" // string | The main email contents.

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.DefaultApi.SendMail(context.Background()).To(to).From(from).Subject(subject).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.SendMail``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SendMail`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.SendMail`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSendMailRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **string** | The Contact whom is the primary recipient of this email. | 
 **from** | **string** | The contact whom is the this email is from. | 
 **subject** | **string** | The subject or title of the email | 
 **body** | **string** | The main email contents. | 

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


## ViewMailLog

> MailLog ViewMailLog(ctx).Id(id).Origin(origin).Mx(mx).From(from).To(to).Subject(subject).Mailid(mailid).Skip(skip).Limit(limit).StartDate(startDate).EndDate(endDate).Execute()

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
    id := int64(2604) // int64 | The ID of your mail order this will be sent through. (optional)
    origin := "1.2.3.4" // string | originating ip address sending mail (optional)
    mx := "mx.google.com" // string | mx record mail was sent to (optional)
    from := "me@sender.com" // string | from email address (optional)
    to := "you@receiver.com" // string | to/destination email address (optional)
    subject := "Support" // string | subject containing this string (optional)
    mailid := "185997065c60008840" // string | mail id (optional)
    skip := int32(1000) // int32 | number of records to skip for pagination (optional) (default to 0)
    limit := int32(1000) // int32 | maximum number of records to return (optional) (default to 100)
    startDate := int64(1641781008) // int64 | earliest date to get emails in unix timestamp format (optional)
    endDate := int64(1673317008) // int64 | earliest date to get emails in unix timestamp format (optional)

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.DefaultApi.ViewMailLog(context.Background()).Id(id).Origin(origin).Mx(mx).From(from).To(to).Subject(subject).Mailid(mailid).Skip(skip).Limit(limit).StartDate(startDate).EndDate(endDate).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `DefaultApi.ViewMailLog``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `ViewMailLog`: MailLog
    fmt.Fprintf(os.Stdout, "Response from `DefaultApi.ViewMailLog`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiViewMailLogRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int64** | The ID of your mail order this will be sent through. | 
 **origin** | **string** | originating ip address sending mail | 
 **mx** | **string** | mx record mail was sent to | 
 **from** | **string** | from email address | 
 **to** | **string** | to/destination email address | 
 **subject** | **string** | subject containing this string | 
 **mailid** | **string** | mail id | 
 **skip** | **int32** | number of records to skip for pagination | [default to 0]
 **limit** | **int32** | maximum number of records to return | [default to 100]
 **startDate** | **int64** | earliest date to get emails in unix timestamp format | 
 **endDate** | **int64** | earliest date to get emails in unix timestamp format | 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)

