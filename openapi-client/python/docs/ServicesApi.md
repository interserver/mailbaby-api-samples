# openapi_client.ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_orders**](ServicesApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders


# **get_mail_orders**
> List[MailOrder] get_mail_orders()

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.mail_order import MailOrder
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
    api_instance = openapi_client.ServicesApi(api_client)

    try:
        # displays a list of mail service orders
        api_response = api_instance.get_mail_orders()
        print("The response of ServicesApi->get_mail_orders:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling ServicesApi->get_mail_orders: %s\n" % e)
```



### Parameters
This endpoint does not need any parameter.

### Return type

[**List[MailOrder]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**404** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

