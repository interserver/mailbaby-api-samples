# \SendingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**RawMail**](SendingAPI.md#RawMail) | **Post** /mail/rawsend | Sends a raw email
[**SendAdvMail**](SendingAPI.md#SendAdvMail) | **Post** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingAPI.md#SendMail) | **Post** /mail/send | Sends an Email



## RawMail

> GenericResponse RawMail(ctx).SendMailRaw(sendMailRaw).Execute()

Sends a raw email



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
	subject := "subject_example" // string | The subject or title of the email
	body := "body_example" // string | The main email contents.
	from := openapiclient.EmailAddressTypes{EmailAddressName: openapiclient.NewEmailAddressName("user@domain.com")} // EmailAddressTypes | 
	to := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes | 
	replyto := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes |  (optional)
	cc := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes |  (optional)
	bcc := openapiclient.EmailAddressesTypes{ArrayOfEmailAddressName: new([]EmailAddressName)} // EmailAddressesTypes |  (optional)
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
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
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
	to := "to_example" // string | The Contact whom is the primary recipient of this email.
	from := "from_example" // string | The contact whom is the this email is from.
	subject := "subject_example" // string | The subject or title of the email
	body := "body_example" // string | The main email contents.
	id := int32(56) // int32 | Optional Order ID (optional)

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
 **to** | **string** | The Contact whom is the primary recipient of this email. | 
 **from** | **string** | The contact whom is the this email is from. | 
 **subject** | **string** | The subject or title of the email | 
 **body** | **string** | The main email contents. | 
 **id** | **int32** | Optional Order ID | 

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

