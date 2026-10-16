# mailbaby-client-python.StatusApi

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
from __future__ import print_function
import time
import mailbaby-client-python
from mailbaby-client-python.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = mailbaby-client-python.StatusApi()

try:
    # Health check — verify the API is reachable
    api_response = api_instance.ping_server()
    pprint(api_response)
except ApiException as e:
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

