# SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendAdvMail**](SendingApi.md#SendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendMail**](SendingApi.md#SendMail) | **POST** /mail/send | Sends an Email


# **SendAdvMail**
> GenericResponse SendAdvMail(subject, body, from, to, replyto = var.replyto, cc = var.cc, bcc = var.bcc, attachments = var.attachments, id = var.id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 

### Example
```R
library(openapi)

# Sends an Email with Advanced Options
#
# prepare function argument(s)
var_subject <- "subject_example" # character | The subject or title of the email
var_body <- "body_example" # character | The main email contents.
var_from <- EmailAddressTypes$new("email_example", "name_example") # EmailAddressTypes | 
var_to <- EmailAddressesTypes$new() # EmailAddressesTypes | 
var_replyto <- EmailAddressesTypes$new() # EmailAddressesTypes |  (Optional)
var_cc <- EmailAddressesTypes$new() # EmailAddressesTypes |  (Optional)
var_bcc <- EmailAddressesTypes$new() # EmailAddressesTypes |  (Optional)
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
 **from** | [**EmailAddressTypes**](EmailAddressTypes.md)|  | 
 **to** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | 
 **replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] 
 **cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] 
 **bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md)|  | [optional] 
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
| **400** | Error message when there was a problem with the input parameters. |  -  |
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
| **400** | Error message when there was a problem with the input parameters. |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

