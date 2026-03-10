# \SendingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**RawMail**](SendingAPI.md#RawMail) | **Post** /mail/rawsend | Sends a raw RFC 822 email
[**SendAdvMail**](SendingAPI.md#SendAdvMail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingAPI.md#SendMail) | **Post** /mail/send | Sends an Email



## RawMail

> GenericResponse RawMail(ctx).SendMailRaw(sendMailRaw).Execute()

Sends a raw RFC 822 email



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
	sendMailRaw := *openapiclient.NewSendMailRaw("RawEmail_example") // SendMailRaw | 

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SendingAPI.RawMail(context.Background()).SendMailRaw(sendMailRaw).Execute()
	if err != nil {
		fmt.Fprintf(os.Stderr, "Error when calling `SendingAPI.RawMail``: %v\n", err)
		fmt.Fprintf(os.Stderr, "Full HTTP response: %v\n", r)
	}
	// response from `RawMail`: GenericResponse
	fmt.Fprintf(os.Stdout, "Response from `SendingAPI.RawMail`: %v\n", resp)
}
```

### Path Parameters



### Other Parameters

Other parameters are passed through a pointer to a apiRawMailRequest struct via the builder pattern


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **sendMailRaw** | [**SendMailRaw**](SendMailRaw.md) |  | 

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
	subject := "subject_example" // string | The subject line of the email.
	body := "body_example" // string | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
	from := openapiclient.EmailAddressTypes{EmailAddressName: openapiclient.NewEmailAddressName("user@domain.com")} // EmailAddressTypes | 
	to := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes | 
	replyto := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes |  (optional)
	cc := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes |  (optional)
	bcc := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes |  (optional)
	attachments := []openapiclient.MailAttachment{*openapiclient.NewMailAttachment("message.txt", string([B@7a583586))} // []MailAttachment | Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name. (optional)
	id := int64(789) // int64 | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional)

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
 **subject** | **string** | The subject line of the email. | 
 **body** | **string** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **attachments** | [**[]MailAttachment**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | 
 **id** | **int64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | 

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

> GenericResponse SendMail(ctx).To(to).From(from).Subject(subject).Body(body).Id(id).Execute()

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
	to := openapiclient.SendMail_to{ArrayOfString: new([]string)} // SendMailTo | 
	from := "from_example" // string | The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
	subject := "subject_example" // string | The subject line of the email.
	body := "body_example" // string | The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
	id := int64(789) // int64 | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. (optional)

	configuration := openapiclient.NewConfiguration()
	apiClient := openapiclient.NewAPIClient(configuration)
	resp, r, err := apiClient.SendingAPI.SendMail(context.Background()).To(to).From(from).Subject(subject).Body(body).Id(id).Execute()
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
 **to** | [**SendMailTo**](SendMailTo.md) |  | 
 **from** | **string** | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
 **subject** | **string** | The subject line of the email. | 
 **body** | **string** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
 **id** | **int64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | 

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

