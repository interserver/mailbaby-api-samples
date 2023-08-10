# swagger_client.ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](ServicesApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders

# **get_mail_orders**
> list[MailOrder] get_mail_orders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

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
api_instance = swagger_client.ServicesApi(swagger_client.ApiClient(configuration))

try:
    # displays a list of mail service orders
    api_response = api_instance.get_mail_orders()
    pprint(api_response)
except ApiException as e:
    print("Exception when calling ServicesApi->get_mail_orders: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**list[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

