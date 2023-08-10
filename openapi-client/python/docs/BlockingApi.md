# openapi_client.BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Creates a new email deny rule.
[**delete_rule**](BlockingApi.md#delete_rule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**get_mail_blocks**](BlockingApi.md#get_mail_blocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**get_rules**](BlockingApi.md#get_rules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **add_rule**
> GenericResponse add_rule(type, data, user=user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

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
    api_instance = openapi_client.BlockingApi(api_client)
    type = 'type_example' # str | The type of deny rule.
    data = 'data_example' # str | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
    user = 'user_example' # str | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional)

    try:
        # Creates a new email deny rule.
        api_response = api_instance.add_rule(type, data, user=user)
        print("The response of BlockingApi->add_rule:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlockingApi->add_rule: %s\n" % e)
```



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | **str**| The type of deny rule. | 
 **data** | **str**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **user** | **str**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

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

# **delete_rule**
> GenericResponse delete_rule(rule_id)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

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
    api_instance = openapi_client.BlockingApi(api_client)
    rule_id = 34 # int | The ID of the Rules entry.

    try:
        # Removes an deny mail rule.
        api_response = api_instance.delete_rule(rule_id)
        print("The response of BlockingApi->delete_rule:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlockingApi->delete_rule: %s\n" % e)
```



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rule_id** | **int**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | The specified resource was not found |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delist_block**
> GenericResponse delist_block(email_address)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.email_address import EmailAddress
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
    api_instance = openapi_client.BlockingApi(api_client)
    email_address = {"email":"client@domain.com"} # EmailAddress | 

    try:
        # Removes an email address from the blocked list
        api_response = api_instance.delist_block(email_address)
        print("The response of BlockingApi->delist_block:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlockingApi->delist_block: %s\n" % e)
```



### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email_address** | [**EmailAddress**](EmailAddress.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | search results matching criteria |  -  |
**400** | The specified resource was not found |  -  |
**401** | Unauthorized |  -  |
**404** | The specified resource was not found |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_mail_blocks**
> MailBlocks get_mail_blocks()

displays a list of blocked email addresses

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.mail_blocks import MailBlocks
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
    api_instance = openapi_client.BlockingApi(api_client)

    try:
        # displays a list of blocked email addresses
        api_response = api_instance.get_mail_blocks()
        print("The response of BlockingApi->get_mail_blocks:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlockingApi->get_mail_blocks: %s\n" % e)
```



### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md)

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

# **get_rules**
> List[DenyRuleRecord] get_rules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example

* Api Key Authentication (apiKeyAuth):
```python
import time
import os
import openapi_client
from openapi_client.models.deny_rule_record import DenyRuleRecord
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
    api_instance = openapi_client.BlockingApi(api_client)

    try:
        # Displays a listing of deny email rules.
        api_response = api_instance.get_rules()
        print("The response of BlockingApi->get_rules:\n")
        pprint(api_response)
    except Exception as e:
        print("Exception when calling BlockingApi->get_rules: %s\n" % e)
```



### Parameters
This endpoint does not need any parameter.

### Return type

[**List[DenyRuleRecord]**](DenyRuleRecord.md)

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

