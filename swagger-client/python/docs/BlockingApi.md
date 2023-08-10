# swagger_client.BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**add_rule**](BlockingApi.md#add_rule) | **POST** /mail/rules | Creates a new email deny rule.
[**delete_rule**](BlockingApi.md#delete_rule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**delist_block**](BlockingApi.md#delist_block) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**get_mail_blocks**](BlockingApi.md#get_mail_blocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**get_rules**](BlockingApi.md#get_rules) | **GET** /mail/rules | Displays a listing of deny email rules.

# **add_rule**
> GenericResponse add_rule(user, type, data)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

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
api_instance = swagger_client.BlockingApi(swagger_client.ApiClient(configuration))
user = 'user_example' # str | 
type = 'type_example' # str | 
data = 'data_example' # str | 

try:
    # Creates a new email deny rule.
    api_response = api_instance.add_rule(user, type, data)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling BlockingApi->add_rule: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | **str**|  | 
 **type** | **str**|  | 
 **data** | **str**|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delete_rule**
> GenericResponse delete_rule(rule_id)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

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
api_instance = swagger_client.BlockingApi(swagger_client.ApiClient(configuration))
rule_id = 56 # int | The ID of the Rules entry.

try:
    # Removes an deny mail rule.
    api_response = api_instance.delete_rule(rule_id)
    pprint(api_response)
except ApiException as e:
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delist_block**
> GenericResponse delist_block(body)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

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
api_instance = swagger_client.BlockingApi(swagger_client.ApiClient(configuration))
body = swagger_client.EmailAddress() # EmailAddress | 

try:
    # Removes an email address from the blocked list
    api_response = api_instance.delist_block(body)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling BlockingApi->delist_block: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**EmailAddress**](EmailAddress.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_mail_blocks**
> MailBlocks get_mail_blocks()

displays a list of blocked email addresses

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
api_instance = swagger_client.BlockingApi(swagger_client.ApiClient(configuration))

try:
    # displays a list of blocked email addresses
    api_response = api_instance.get_mail_blocks()
    pprint(api_response)
except ApiException as e:
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

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_rules**
> list[DenyRuleRecord] get_rules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

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
api_instance = swagger_client.BlockingApi(swagger_client.ApiClient(configuration))

try:
    # Displays a listing of deny email rules.
    api_response = api_instance.get_rules()
    pprint(api_response)
except ApiException as e:
    print("Exception when calling BlockingApi->get_rules: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**list[DenyRuleRecord]**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

