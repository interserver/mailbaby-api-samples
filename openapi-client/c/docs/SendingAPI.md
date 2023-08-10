# SendingAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**SendingAPI_sendAdvMail**](SendingAPI.md#SendingAPI_sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**SendingAPI_sendMail**](SendingAPI.md#SendingAPI_sendMail) | **POST** /mail/send | Sends an Email


# **SendingAPI_sendAdvMail**
```c
// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t* SendingAPI_sendAdvMail(apiClient_t *apiClient, char * subject, char * body, email_address_name_t * from, list_t * to, list_t * replyto, list_t * cc, list_t * bcc, list_t * attachments, long id);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**subject** | **char \*** | The subject or title of the email | 
**body** | **char \*** | The main email contents. | 
**from** | **[email_address_name_t](email_address_name.md) \*** |  | 
**to** | **[list_t](email_address_name.md) \*** | A list of destionation email addresses to send this to | 
**replyto** | **[list_t](email_address_name.md) \*** | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
**cc** | **[list_t](email_address_name.md) \*** | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
**bcc** | **[list_t](email_address_name.md) \*** | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
**attachments** | **[list_t](mail_attachment.md) \*** | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
**id** | **long** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **SendingAPI_sendMail**
```c
// Sends an Email
//
// Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
//
generic_response_t* SendingAPI_sendMail(apiClient_t *apiClient, char * to, char * from, char * subject, char * body);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration |
**to** | **char \*** | The Contact whom is the primary recipient of this email. | 
**from** | **char \*** | The contact whom is the this email is from. | 
**subject** | **char \*** | The subject or title of the email | 
**body** | **char \*** | The main email contents. | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

