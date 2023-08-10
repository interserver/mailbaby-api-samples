# openapi_client.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email


# **send_adv_mail**
> GenericResponse send_adv_mail(subject, body, var_from, to, replyto=replyto, cc=cc, bcc=bcc, attachments=attachments, id=id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.email_address_name import EmailAddressName
from openapi_client.models.generic_response import GenericResponse
from openapi_client.models.mail_attachment import MailAttachment
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.SendingApi(api_client)
    subject = 'subject_example' # str | The subject or title of the email
    body = 'body_example' # str | The main email contents.
    var_from = openapi_client.EmailAddressName() # EmailAddressName | 
    to = [openapi_client.EmailAddressName()] # List[EmailAddressName] | A list of destionation email addresses to send this to
    replyto = [openapi_client.EmailAddressName()] # List[EmailAddressName] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. (optional)
    cc = [openapi_client.EmailAddressName()] # List[EmailAddressName] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. (optional)
    bcc = [openapi_client.EmailAddressName()] # List[EmailAddressName] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. (optional)
    attachments = [openapi_client.MailAttachment()] # List[MailAttachment] | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
    id = 56 # int | (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)

    try:
        # Sends an Email with Advanced Options
        api_response = api_instance.send_adv_mail(subject, body, var_from, to, replyto=replyto, cc=cc, bcc=bcc, attachments=attachments, id=id)
        print("The response of SendingApi->send_adv_mail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SendingApi->send_adv_mail: %s\n" % e)
```



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **str**| The subject or title of the email | 
 **body** | **str**| The main email contents. | 
 **var_from** | [**EmailAddressName**](EmailAddressName.md)|  | 
 **to** | [**List[EmailAddressName]**](EmailAddressName.md)| A list of destionation email addresses to send this to | 
 **replyto** | [**List[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **cc** | [**List[EmailAddressName]**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **bcc** | [**List[EmailAddressName]**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
 **attachments** | [**List[MailAttachment]**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **id** | **int**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

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
**200** | search results matching criteria |  -  |
**400** | The specified resource was not found |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> GenericResponse send_mail(to, var_from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.generic_response import GenericResponse
from openapi_client.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)

# The client must configure the authentication and authorization parameters
# in accordance with the API server security policy.
# Examples for each auth method are provided below, use the example that
# satisfies your auth use case.

# Configure API key authorization: apiKeyAuth
configuration.api_key['apiKeyAuth'] = os.environ["API_KEY"]

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = openapi_client.SendingApi(api_client)
    to = 'to_example' # str | The Contact whom is the primary recipient of this email.
    var_from = 'var_from_example' # str | The contact whom is the this email is from.
    subject = 'subject_example' # str | The subject or title of the email
    body = 'body_example' # str | The main email contents.

    try:
        # Sends an Email
        api_response = api_instance.send_mail(to, var_from, subject, body)
        print("The response of SendingApi->send_mail:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling SendingApi->send_mail: %s\n" % e)
```



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **str**| The Contact whom is the primary recipient of this email. | 
 **var_from** | **str**| The contact whom is the this email is from. | 
 **subject** | **str**| The subject or title of the email | 
 **body** | **str**| The main email contents. | 

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
**200** | search results matching criteria |  -  |
**400** | The specified resource was not found |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

