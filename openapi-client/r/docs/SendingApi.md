# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendAdvMail**](SendingApi.md#SendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingApi.md#SendMail) | **POST** /mail/send | Sends an Email


# **SendAdvMail**
> GenericResponse SendAdvMail(subject, body, from, to, replyto = var.replyto, cc = var.cc, bcc = var.bcc, attachments = var.attachments, id = var.id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```R
library(openapi)

# Sends an Email with Advanced Options
#
# prepare function argument(s)
var_subject <- "subject_example" # character | The subject or title of the email
var_body <- "body_example" # character | The main email contents.
var_from <- EmailAddressName$new("email_example", "name_example") # EmailAddressName | 
var_to <- c(EmailAddressName$new("email_example", "name_example")) # array[EmailAddressName] | A list of destionation email addresses to send this to
var_replyto <- c(EmailAddressName$new("email_example", "name_example")) # array[EmailAddressName] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. (Optional)
var_cc <- c(EmailAddressName$new("email_example", "name_example")) # array[EmailAddressName] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. (Optional)
var_bcc <- c(EmailAddressName$new("email_example", "name_example")) # array[EmailAddressName] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. (Optional)
var_attachments <- c(MailAttachment$new("filename_example", "data_example")) # array[MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (Optional)
var_id <- 56 # integer | (optional)  ID of the Mail order within our system to use as the Mail Account. (Optional)

api_instance <- SendingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$SendAdvMail(var_subject, var_body, var_from, var_to, replyto = var_replyto, cc = var_cc, bcc = var_bcc, attachments = var_attachments, id = var_iddata_file = "result.txt")
result <- api_instance$SendAdvMail(var_subject, var_body, var_from, var_to, replyto = var_replyto, cc = var_cc, bcc = var_bcc, attachments = var_attachments, id = var_id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **character**| The subject or title of the email | 
 **body** | **character**| The main email contents. | 
 **from** | [**EmailAddressName**](EmailAddressName.md)|  | 
 **to** | list( [**EmailAddressName**](EmailAddressName.md) )| A list of destionation email addresses to send this to | 
 **replyto** | list( [**EmailAddressName**](EmailAddressName.md) )| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **cc** | list( [**EmailAddressName**](EmailAddressName.md) )| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **bcc** | list( [**EmailAddressName**](EmailAddressName.md) )| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
 **attachments** | list( [**MailAttachment**](MailAttachment.md) )| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **id** | **integer**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **SendMail**
> GenericResponse SendMail(to, from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```R
library(openapi)

# Sends an Email
#
# prepare function argument(s)
var_to <- "to_example" # character | The Contact whom is the primary recipient of this email.
var_from <- "from_example" # character | The contact whom is the this email is from.
var_subject <- "subject_example" # character | The subject or title of the email
var_body <- "body_example" # character | The main email contents.

api_instance <- SendingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$SendMail(var_to, var_from, var_subject, var_bodydata_file = "result.txt")
result <- api_instance$SendMail(var_to, var_from, var_subject, var_body)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **character**| The Contact whom is the primary recipient of this email. | 
 **from** | **character**| The contact whom is the this email is from. | 
 **subject** | **character**| The subject or title of the email | 
 **body** | **character**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

