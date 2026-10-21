# MailBabyPythonPydanticV1.StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**ping_server**](StatusApi.md#ping_server) | **GET** /ping | Health check — verify the API is reachable


# **ping_server**
> str ping_server()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string `Server is up and running` with a `200` status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests.


### Example

```python
import time
import os
import MailBabyPythonPydanticV1
from MailBabyPythonPydanticV1.rest import ApiException
from pprint import pprint

# Defining the host is optional and defaults to https://api.mailbaby.net
# See configuration.py for a list of all supported configuration parameters.
configuration = MailBabyPythonPydanticV1.Configuration(
    host = "https://api.mailbaby.net"
)


# Enter a context with an instance of the API client
with MailBabyPythonPydanticV1.ApiClient(configuration) as api_client:
    # Create an instance of the API class
    api_instance = MailBabyPythonPydanticV1.StatusApi(api_client)

    try:
        # Health check — verify the API is reachable
        api_response = api_instance.ping_server()
        print("The response of StatusApi->ping_server:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling StatusApi->ping_server: %s\n" % e)
```



### Parameters
This endpoint does not need any parameter.

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Server is up and running |  -  |
**0** | Something is wrong |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

