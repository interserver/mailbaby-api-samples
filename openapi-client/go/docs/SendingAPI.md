# \SendingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendAdvMail**](SendingAPI.md#SendAdvMail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingAPI.md#SendMail) | **Post** /mail/send | Sends an Email



## SendAdvMail

> GenericResponse SendAdvMail(ctx).Subject(subject).Body(body).From(from).To(to).Replyto(replyto).Cc(cc).Bcc(bcc).Attachments(attachments).Id(id).Execute()

Sends an Email with Advanced Options



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
    subject := "subject_example" // string | The subject or title of the email
    body := "body_example" // string | The main email contents.
    from := *openapiclient.NewEmailAddressName("user@domain.com") // EmailAddressName | 
    to := []openapiclient.EmailAddressName{*openapiclient.NewEmailAddressName("user@domain.com")} // []EmailAddressName | A list of destionation email addresses to send this to
    replyto := []openapiclient.EmailAddressName{} // []EmailAddressName | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. (optional)
    cc := []openapiclient.EmailAddressName{} // []EmailAddressName | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. (optional)
    bcc := []openapiclient.EmailAddressName{} // []EmailAddressName | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. (optional)
    attachments := []openapiclient.MailAttachment{*openapiclient.NewMailAttachment("message.txt", "aGVsbG8gdGhlcmUK")} // []MailAttachment | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
    id := int64(789) // int64 | (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.SendingAPI.SendAdvMail(context.Background()).Subject(subject).Body(body).From(from).To(to).Replyto(replyto).Cc(cc).Bcc(bcc).Attachments(attachments).Id(id).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `SendingAPI.SendAdvMail``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SendAdvMail`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `SendingAPI.SendAdvMail`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiSendAdvMailRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **string** | The subject or title of the email | 
 **body** | **string** | The main email contents. | 
 **from** | [**EmailAddressName**](EmailAddressName.md) |  | 
 **to** | [**[]EmailAddressName**](EmailAddressName.md) | A list of destionation email addresses to send this to | 
 **replyto** | [**[]EmailAddressName**](EmailAddressName.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | 
 **cc** | [**[]EmailAddressName**](EmailAddressName.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | 
 **bcc** | [**[]EmailAddressName**](EmailAddressName.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | 
 **attachments** | [**[]MailAttachment**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | 
 **id** | **int64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | 

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
    openapiclient "github.com/GIT_USER_ID/GIT_REPO_ID"
)

func main() {
    to := "to_example" // string | The Contact whom is the primary recipient of this email.
    from := "from_example" // string | The contact whom is the this email is from.
    subject := "subject_example" // string | The subject or title of the email
    body := "body_example" // string | The main email contents.

    configuration := openapiclient.NewConfiguration()
    apiClient := openapiclient.NewAPIClient(configuration)
    resp, r, err := apiClient.SendingAPI.SendMail(context.Background()).To(to).From(from).Subject(subject).Body(body).Execute()
    if err != nil {
        fmt.Fprintf(os.Stderr, "Error when calling `SendingAPI.SendMail``: %v\n", err)
        fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
    }
    // response from `SendMail`: GenericResponse
    fmt.Fprintf(os.Stdout, "Response from `SendingAPI.SendMail`: %v\n", resp)
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

