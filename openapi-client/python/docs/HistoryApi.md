# openapi_client.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**get_stats**](HistoryApi.md#get_stats) | **GET** /mail/stats | displays a list of blocked email addresses
[**view_mail_log**](HistoryApi.md#view_mail_log) | **GET** /mail/log | displays the mail log


# **get_stats**
> List[GetStats200ResponseInner] get_stats()

displays a list of blocked email addresses

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.get_stats200_response_inner import GetStats200ResponseInner
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
    api_instance = openapi_client.HistoryApi(api_client)

    try:
        # displays a list of blocked email addresses
        api_response = api_instance.get_stats()
        print("The response of HistoryApi->get_stats:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HistoryApi->get_stats: %s\n" % e)
```



### Parameters
This endpoint does not need any parameter.

### Return type

[**List[GetStats200ResponseInner]**](GetStats200ResponseInner.md)

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

# **view_mail_log**
> MailLog view_mail_log(id=id, origin=origin, mx=mx, var_from=var_from, to=to, subject=subject, mailid=mailid, skip=skip, limit=limit, start_date=start_date, end_date=end_date)

displays the mail log

Get a listing of the emails sent through this system 

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.mail_log import MailLog
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
    api_instance = openapi_client.HistoryApi(api_client)
    id = 2604 # int | The ID of your mail order this will be sent through. (optional)
    origin = '1.2.3.4' # str | originating ip address sending mail (optional)
    mx = 'mx.google.com' # str | mx record mail was sent to (optional)
    var_from = 'me@sender.com' # str | from email address (optional)
    to = 'you@receiver.com' # str | to/destination email address (optional)
    subject = 'Support' # str | subject containing this string (optional)
    mailid = '185997065c60008840' # str | mail id (optional)
    skip = 0 # int | number of records to skip for pagination (optional) (default to 0)
    limit = 100 # int | maximum number of records to return (optional) (default to 100)
    start_date = 1641781008 # int | earliest date to get emails in unix timestamp format (optional)
    end_date = 1673317008 # int | earliest date to get emails in unix timestamp format (optional)

    try:
        # displays the mail log
        api_response = api_instance.view_mail_log(id=id, origin=origin, mx=mx, var_from=var_from, to=to, subject=subject, mailid=mailid, skip=skip, limit=limit, start_date=start_date, end_date=end_date)
        print("The response of HistoryApi->view_mail_log:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling HistoryApi->view_mail_log: %s\n" % e)
```



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| The ID of your mail order this will be sent through. | [optional] 
 **origin** | **str**| originating ip address sending mail | [optional] 
 **mx** | **str**| mx record mail was sent to | [optional] 
 **var_from** | **str**| from email address | [optional] 
 **to** | **str**| to/destination email address | [optional] 
 **subject** | **str**| subject containing this string | [optional] 
 **mailid** | **str**| mail id | [optional] 
 **skip** | **int**| number of records to skip for pagination | [optional] [default to 0]
 **limit** | **int**| maximum number of records to return | [optional] [default to 100]
 **start_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 
 **end_date** | **int**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | bad input parameter |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

