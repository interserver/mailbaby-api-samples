# swagger_client.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**send_adv_mail**](SendingApi.md#send_adv_mail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**send_mail**](SendingApi.md#send_mail) | **POST** /mail/send | Sends an Email

# **send_adv_mail**
> GenericResponse send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id)

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = swagger_client.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = swagger_client.SendingApi(swagger_client.ApiClient(configuration))
subject = 'subject_example' # str | 
body = 'body_example' # str | 
_from = swagger_client.EmailAddressName() # EmailAddressName | 
to = [swagger_client.EmailAddressName()] # list[EmailAddressName] | 
replyto = [swagger_client.EmailAddressName()] # list[EmailAddressName] | 
cc = [swagger_client.EmailAddressName()] # list[EmailAddressName] | 
bcc = [swagger_client.EmailAddressName()] # list[EmailAddressName] | 
attachments = [swagger_client.MailAttachment()] # list[MailAttachment] | 
id = 789 # int | 

try:
    # Sends an Email with Advanced Options
    api_response = api_instance.send_adv_mail(subject, body, _from, to, replyto, cc, bcc, attachments, id)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling SendingApi->send_adv_mail: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subject** | **str**|  | 
 **body** | **str**|  | 
 **_from** | [**EmailAddressName**](.md)|  | 
 **to** | [**list[EmailAddressName]**](EmailAddressName.md)|  | 
 **replyto** | [**list[EmailAddressName]**](EmailAddressName.md)|  | 
 **cc** | [**list[EmailAddressName]**](EmailAddressName.md)|  | 
 **bcc** | [**list[EmailAddressName]**](EmailAddressName.md)|  | 
 **attachments** | [**list[MailAttachment]**](MailAttachment.md)|  | 
 **id** | **int**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail**
> GenericResponse send_mail(to, _from, subject, body)

Sends an Email

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# Configure API key authorization: apiKeyAuth
configuration = swagger_client.Configuration()
configuration.api_key['X-API-KEY'] = 'YOUR_API_KEY'
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['X-API-KEY'] = 'Bearer'

# create an instance of the API class
api_instance = swagger_client.SendingApi(swagger_client.ApiClient(configuration))
to = 'to_example' # str | 
_from = '_from_example' # str | 
subject = 'subject_example' # str | 
body = 'body_example' # str | 

try:
    # Sends an Email
    api_response = api_instance.send_mail(to, _from, subject, body)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling SendingApi->send_mail: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **to** | **str**|  | 
 **_from** | **str**|  | 
 **subject** | **str**|  | 
 **body** | **str**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

