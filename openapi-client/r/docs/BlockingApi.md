# BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**AddRule**](BlockingApi.md#AddRule) | **POST** /mail/rules | Creates a new email deny rule.
[**DeleteRule**](BlockingApi.md#DeleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**DelistBlock**](BlockingApi.md#DelistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**GetMailBlocks**](BlockingApi.md#GetMailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**GetRules**](BlockingApi.md#GetRules) | **GET** /mail/rules | Displays a listing of deny email rules.


# **AddRule**
> GenericResponse AddRule(type, data, user = var.user)

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```R
library(openapi)

# Creates a new email deny rule.
#
# prepare function argument(s)
var_type <- "type_example" # character | The type of deny rule.
var_data <- "data_example" # character | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
var_user <- "user_example" # character | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (Optional)

api_instance <- BlockingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$AddRule(var_type, var_data, user = var_userdata_file = "result.txt")
result <- api_instance$AddRule(var_type, var_data, user = var_user)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **type** | Enum [domain, email, startswith] | The type of deny rule. | 
 **data** | **character**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **user** | **character**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

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
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **DeleteRule**
> GenericResponse DeleteRule(rule_id)

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```R
library(openapi)

# Removes an deny mail rule.
#
# prepare function argument(s)
var_rule_id <- 34 # integer | The ID of the Rules entry.

api_instance <- BlockingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$DeleteRule(var_rule_iddata_file = "result.txt")
result <- api_instance$DeleteRule(var_rule_id)
dput(result)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **rule_id** | **integer**| The ID of the Rules entry. | 

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
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **DelistBlock**
> GenericResponse DelistBlock(email_address)

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```R
library(openapi)

# Removes an email address from the blocked list
#
# prepare function argument(s)
var_email_address <- EmailAddress$new("email_example") # EmailAddress | 

api_instance <- BlockingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$DelistBlock(var_email_addressdata_file = "result.txt")
result <- api_instance$DelistBlock(var_email_address)
dput(result)
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
| **200** | search results matching criteria |  -  |
| **400** | The specified resource was not found |  -  |
| **401** | Unauthorized |  -  |
| **404** | The specified resource was not found |  -  |

# **GetMailBlocks**
> MailBlocks GetMailBlocks()

displays a list of blocked email addresses

### Example
```R
library(openapi)

# displays a list of blocked email addresses
#

api_instance <- BlockingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$GetMailBlocks(data_file = "result.txt")
result <- api_instance$GetMailBlocks()
dput(result)
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
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |

# **GetRules**
> array[DenyRuleRecord] GetRules()

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```R
library(openapi)

# Displays a listing of deny email rules.
#

api_instance <- BlockingApi$new()
# Configure API key authorization: apiKeyAuth
api_instance$api_client$api_keys["X-API-KEY"] <- Sys.getenv("API_KEY")
# to save the result into a file, simply add the optional `data_file` parameter, e.g.
# result <- api_instance$GetRules(data_file = "result.txt")
result <- api_instance$GetRules()
dput(result)
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**array[DenyRuleRecord]**](DenyRuleRecord.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **401** | Unauthorized |  -  |
| **404** | Unauthorized |  -  |

