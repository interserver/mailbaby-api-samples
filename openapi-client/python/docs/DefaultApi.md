# openapi_client.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_mail_by_id**](DefaultApi.md#get_mail_by_id) | **GET** /mail/{id} | Gets mail order information by id
[**get_mail_orders**](DefaultApi.md#get_mail_orders) | **GET** /mail | displays a list of mail service orders
[**ping_server**](DefaultApi.md#ping_server) | **GET** /ping | Checks if the server is running
[**place_mail_order**](DefaultApi.md#place_mail_order) | **POST** /mail/order | places a mail order
[**send_mail_by_id**](DefaultApi.md#send_mail_by_id) | **POST** /mail/{id}/send | Sends an Email
[**validate_mail_order**](DefaultApi.md#validate_mail_order) | **GET** /mail/order | validatess order details before placing an order
[**view_mail_log_by_id**](DefaultApi.md#view_mail_log_by_id) | **GET** /mail/{id}/log | displays the mail log


# **get_mail_by_id**
> MailOrder get_mail_by_id(id)

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example

* Api Key Authentication (apiKeyAuth):
* Api Key Authentication (apiLoginAuth):
* Api Key Authentication (apiPasswordAuth):
```python
import time
import openapi_client
from openapi_client.api import default_api
from openapi_client.model.mail_order import MailOrder
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
configuration.api_key['apiKeyAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Configure API key authorization: apiLoginAuth
configuration.api_key['apiLoginAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiLoginAuth'] = 'Bearer'

# Configure API key authorization: apiPasswordAuth
configuration.api_key['apiPasswordAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiPasswordAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)
    id = 1 # int | User ID

    # example passing only required values which don't have defaults set
    try:
        # Gets mail order information by id
        api_response = api_instance.get_mail_by_id(id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->get_mail_by_id: %s\n" % e)
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID |

### Return type

[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Successful operation |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_mail_orders**
> MailOrders get_mail_orders()

displays a list of mail service orders

### Example

* Api Key Authentication (apiKeyAuth):
* Api Key Authentication (apiLoginAuth):
* Api Key Authentication (apiPasswordAuth):
```python
import time
import openapi_client
from openapi_client.api import default_api
from openapi_client.model.mail_orders import MailOrders
from openapi_client.model.error import Error
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
configuration.api_key['apiKeyAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Configure API key authorization: apiLoginAuth
configuration.api_key['apiLoginAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiLoginAuth'] = 'Bearer'

# Configure API key authorization: apiPasswordAuth
configuration.api_key['apiPasswordAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiPasswordAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        # displays a list of mail service orders
        api_response = api_instance.get_mail_orders()
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->get_mail_orders: %s\n" % e)
```


### Parameters
This endpoint does not need any parameter.

### Return type

[**MailOrders**](MailOrders.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **ping_server**
> ping_server()

Checks if the server is running

### Example

```python
import time
import openapi_client
from openapi_client.api import default_api
from pprint import pprint
# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = openapi_client.Configuration(
    host = "https://api.mailbaby.net"
)


# Enter a context with an instance of the API client
with openapi_client.ApiClient() as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        # Checks if the server is running
        api_instance.ping_server()
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->ping_server: %s\n" % e)
```


### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server is up and running |  -  |
**0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **place_mail_order**
> place_mail_order()

places a mail order

Adds an item to the system

### Example

* Api Key Authentication (apiKeyAuth):
* Api Key Authentication (apiLoginAuth):
* Api Key Authentication (apiPasswordAuth):
```python
import time
import openapi_client
from openapi_client.api import default_api
from openapi_client.model.error import Error
from openapi_client.model.mail_order import MailOrder
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
configuration.api_key['apiKeyAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Configure API key authorization: apiLoginAuth
configuration.api_key['apiLoginAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiLoginAuth'] = 'Bearer'

# Configure API key authorization: apiPasswordAuth
configuration.api_key['apiPasswordAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiPasswordAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)
    mail_order = MailOrder(
        id=1234,
        status="active",
        username="mb1234",
        password="guest123",
        comment="main mail account",
    ) # MailOrder | Inventory item to add (optional)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        # places a mail order
        api_instance.place_mail_order(mail_order=mail_order)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->place_mail_order: %s\n" % e)
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mail_order** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional]

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | list of mail orders |  -  |
**400** | invalid input, object invalid |  -  |
**409** | an existing item already exists |  -  |
**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **send_mail_by_id**
> GenericResponse send_mail_by_id(id)

Sends an Email

Sends An email through one of your mail orders.

### Example

* Api Key Authentication (apiKeyAuth):
* Api Key Authentication (apiLoginAuth):
* Api Key Authentication (apiPasswordAuth):
```python
import time
import openapi_client
from openapi_client.api import default_api
from openapi_client.model.generic_response import GenericResponse
from openapi_client.model.error import Error
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
configuration.api_key['apiKeyAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Configure API key authorization: apiLoginAuth
configuration.api_key['apiLoginAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiLoginAuth'] = 'Bearer'

# Configure API key authorization: apiPasswordAuth
configuration.api_key['apiPasswordAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiPasswordAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)
    id = 1 # int | User ID
    subject = "subject_example" # str |  (optional)
    body = "body_example" # str |  (optional)
    to = "to_example" # str |  (optional)
    _from = "from_example" # str |  (optional)

    # example passing only required values which don't have defaults set
    try:
        # Sends an Email
        api_response = api_instance.send_mail_by_id(id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->send_mail_by_id: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        # Sends an Email
        api_response = api_instance.send_mail_by_id(id, subject=subject, body=body, to=to, _from=_from)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->send_mail_by_id: %s\n" % e)
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID |
 **subject** | **str**|  | [optional]
 **body** | **str**|  | [optional]
 **to** | **str**|  | [optional]
 **_from** | **str**|  | [optional]

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | bad input parameter |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validate_mail_order**
> validate_mail_order()

validatess order details before placing an order

### Example

* Api Key Authentication (apiKeyAuth):
* Api Key Authentication (apiLoginAuth):
* Api Key Authentication (apiPasswordAuth):
```python
import time
import openapi_client
from openapi_client.api import default_api
from openapi_client.model.error import Error
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
configuration.api_key['apiKeyAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Configure API key authorization: apiLoginAuth
configuration.api_key['apiLoginAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiLoginAuth'] = 'Bearer'

# Configure API key authorization: apiPasswordAuth
configuration.api_key['apiPasswordAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiPasswordAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)

    # example, this endpoint has no required or optional parameters
    try:
        # validatess order details before placing an order
        api_instance.validate_mail_order()
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->validate_mail_order: %s\n" % e)
```


### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | list of mail orders |  -  |
**401** | Unauthorized |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **view_mail_log_by_id**
> [MailLog] view_mail_log_by_id(id)

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example

* Api Key Authentication (apiKeyAuth):
* Api Key Authentication (apiLoginAuth):
* Api Key Authentication (apiPasswordAuth):
```python
import time
import openapi_client
from openapi_client.api import default_api
from openapi_client.model.mail_log import MailLog
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
configuration.api_key['apiKeyAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiKeyAuth'] = 'Bearer'

# Configure API key authorization: apiLoginAuth
configuration.api_key['apiLoginAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiLoginAuth'] = 'Bearer'

# Configure API key authorization: apiPasswordAuth
configuration.api_key['apiPasswordAuth'] = 'YOUR_API_KEY'

# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
# configuration.api_key_prefix['apiPasswordAuth'] = 'Bearer'

# Enter a context with an instance of the API client
with openapi_client.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = default_api.DefaultApi(api_client)
    id = 1 # int | User ID
    search_string = "searchString_example" # str | pass an optional search string for looking up inventory (optional)
    skip = 0 # int | number of records to skip for pagination (optional)
    limit = 0 # int | maximum number of records to return (optional)

    # example passing only required values which don't have defaults set
    try:
        # displays the mail log
        api_response = api_instance.view_mail_log_by_id(id)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->view_mail_log_by_id: %s\n" % e)

    # example passing only required values which don't have defaults set
    # and optional values
    try:
        # displays the mail log
        api_response = api_instance.view_mail_log_by_id(id, search_string=search_string, skip=skip, limit=limit)
        pprint(api_response)
    except openapi_client.ApiException as e:
        print("Exception when calling DefaultApi->view_mail_log_by_id: %s\n" % e)
```


### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| User ID |
 **search_string** | **str**| pass an optional search string for looking up inventory | [optional]
 **skip** | **int**| number of records to skip for pagination | [optional]
 **limit** | **int**| maximum number of records to return | [optional]

### Return type

[**[MailLog]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | bad input parameter |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
