# SendingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingAPI.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingAPI.md#sendmail) | **POST** /mail/send | Sends an Email


# **sendAdvMail**
```swift
    open class func sendAdvMail(subject: String, body: String, from: EmailAddressName, to: [EmailAddressName], replyto: [EmailAddressName]? = nil, cc: [EmailAddressName]? = nil, bcc: [EmailAddressName]? = nil, attachments: [MailAttachment]? = nil, id: Int64? = nil, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let subject = "subject_example" // String | The subject or title of the email
let body = "body_example" // String | The main email contents.
let from = TODO // EmailAddressName | 
let to = ["TODO"] // [EmailAddressName] | A list of destionation email addresses to send this to
let replyto = ["TODO"] // [EmailAddressName] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. (optional)
let cc = ["TODO"] // [EmailAddressName] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. (optional)
let bcc = ["TODO"] // [EmailAddressName] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. (optional)
let attachments = ["TODO"] // [MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
let id = 987 // Int64 | (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)

// Sends an Email with Advanced Options
SendingAPI.sendAdvMail(subject: subject, body: body, from: from, to: to, replyto: replyto, cc: cc, bcc: bcc, attachments: attachments, id: id) { (response, error) in
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
 **subject** | **String** | The subject or title of the email | 
 **body** | **String** | The main email contents. | 
 **from** | [**EmailAddressName**](EmailAddressName.md) |  | 
 **to** | [**[EmailAddressName]**](EmailAddressName.md) | A list of destionation email addresses to send this to | 
 **replyto** | [**[EmailAddressName]**](EmailAddressName.md) | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **cc** | [**[EmailAddressName]**](EmailAddressName.md) | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **bcc** | [**[EmailAddressName]**](EmailAddressName.md) | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
 **attachments** | [**[MailAttachment]**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **id** | **Int64** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMail**
```swift
    open class func sendMail(to: String, from: String, subject: String, body: String, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let to = "to_example" // String | The Contact whom is the primary recipient of this email.
let from = "from_example" // String | The contact whom is the this email is from.
let subject = "subject_example" // String | The subject or title of the email
let body = "body_example" // String | The main email contents.

// Sends an Email
SendingAPI.sendMail(to: to, from: from, subject: subject, body: body) { (response, error) in
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

