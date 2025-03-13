# SendingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendAdvMail**](SendingAPI.md#sendadvmail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**sendMail**](SendingAPI.md#sendmail) | **POST** /mail/send | Sends an Email


# **sendAdvMail**
```swift
    open class func sendAdvMail(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes? = nil, cc: EmailAddressesTypes? = nil, bcc: EmailAddressesTypes? = nil, attachments: [MailAttachment]? = nil, id: Int64? = nil, completion: @escaping (_ data: GenericResponse?, _ error: Error?) -> Void)
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import OpenAPIClient

let subject = "subject_example" // String | The subject or title of the email
let body = "body_example" // String | The main email contents.
let from = EmailAddressTypes(email: "email_example", name: "name_example") // EmailAddressTypes | 
let to = EmailAddressesTypes() // EmailAddressesTypes | 
let replyto = EmailAddressesTypes() // EmailAddressesTypes |  (optional)
let cc = EmailAddressesTypes() // EmailAddressesTypes |  (optional)
let bcc = EmailAddressesTypes() // EmailAddressesTypes |  (optional)
let attachments = [MailAttachment(filename: "filename_example", data: "data_example")] // [MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
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
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] 
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

