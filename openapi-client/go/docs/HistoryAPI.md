# \HistoryAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**GetStats**](HistoryAPI.md#GetStats) | **Get** /mail/stats | Account usage statistics.
[**ViewMailLog**](HistoryAPI.md#ViewMailLog) | **Get** /mail/log | displays the mail log



## GetStats

> []GetStats200ResponseInner GetStats(ctx).Execute()

Account usage statistics.



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
    resp, r, err := apiClient.HistoryAPI.GetStats(context.Background()).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `HistoryAPI.GetStats``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `GetStats`: []GetStats200ResponseInner
    fmt.Fprintf(os.Stdout, "Response from `HistoryAPI.GetStats`: %v\n", resp)
}
```

### Path Parameters

This endpoint does not need any parameter.

### Other Parameters

Other parameters are passed through a pointer to a apiGetStatsRequest struct via the builder pattern


### Return type

[**[]GetStats200ResponseInner**](GetStats200ResponseInner.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints)
[[Back to Model list]](../README.md#documentation-for-models)
[[Back to README]](../README.md)


## ViewMailLog

> MailLog ViewMailLog(ctx).Id(id).Origin(origin).Mx(mx).From(from).To(to).Subject(subject).Mailid(mailid).Skip(skip).Limit(limit).StartDate(startDate).EndDate(endDate).Replyto(replyto).Headerfrom(headerfrom).Execute()

displays the mail log



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
    replyto := "replyto_example" // string | Reply-To Email Address (optional)
    headerfrom := "headerfrom_example" // string | Header From Email Address (optional)

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.HistoryAPI.ViewMailLog(context.Background()).Id(id).Origin(origin).Mx(mx).From(from).To(to).Subject(subject).Mailid(mailid).Skip(skip).Limit(limit).StartDate(startDate).EndDate(endDate).Replyto(replyto).Headerfrom(headerfrom).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `HistoryAPI.ViewMailLog``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `ViewMailLog`: MailLog
    fmt.Fprintf(os.Stdout, "Response from `HistoryAPI.ViewMailLog`: %v\n", resp)
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
 **replyto** | **string** | Reply-To Email Address | 
 **headerfrom** | **string** | Header From Email Address | 

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

