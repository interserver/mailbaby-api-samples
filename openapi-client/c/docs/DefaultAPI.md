# DefaultAPI

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DefaultAPI_getMailById**](DefaultAPI.md#DefaultAPI_getMailById) | **GET** /mail/{id} | Gets mail order information by id
[**DefaultAPI_getMailOrders**](DefaultAPI.md#DefaultAPI_getMailOrders) | **GET** /mail | displays a list of mail service orders
[**DefaultAPI_pingServer**](DefaultAPI.md#DefaultAPI_pingServer) | **GET** /ping | Checks if the server is running
[**DefaultAPI_placeMailOrder**](DefaultAPI.md#DefaultAPI_placeMailOrder) | **POST** /mail/order | places a mail order
[**DefaultAPI_sendAdvMailById**](DefaultAPI.md#DefaultAPI_sendAdvMailById) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
[**DefaultAPI_sendMailById**](DefaultAPI.md#DefaultAPI_sendMailById) | **POST** /mail/{id}/send | Sends an Email
[**DefaultAPI_validateMailOrder**](DefaultAPI.md#DefaultAPI_validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**DefaultAPI_viewMailLogById**](DefaultAPI.md#DefaultAPI_viewMailLogById) | **GET** /mail/{id}/log | displays the mail log


# **DefaultAPI_getMailById**
```c
// Gets mail order information by id
//
// returns information about a mail order in the system with the given id.
//
mail_order_t* DefaultAPI_getMailById(apiClient_t *apiClient, long id);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**id** | **long** | User ID | 

### Return type

[mail_order_t](mail_order.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_getMailOrders**
```c
// displays a list of mail service orders
//
list_t* DefaultAPI_getMailOrders(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 

### Return type

[list_t](mail_order.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_pingServer**
```c
// Checks if the server is running
//
void DefaultAPI_pingServer(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 

### Return type

void

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_placeMailOrder**
```c
// places a mail order
//
// Adds an item to the system
//
void DefaultAPI_placeMailOrder(apiClient_t *apiClient, mail_order_t * mail_order);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**mail_order** | **[mail_order_t](mail_order.md) \*** | Inventory item to add | [optional] 

### Return type

void

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_sendAdvMailById**
```c
// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t* DefaultAPI_sendAdvMailById(apiClient_t *apiClient, long id, send_mail_t * send_mail);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**id** | **long** | User ID | 
**send_mail** | **[send_mail_t](send_mail.md) \*** |  | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_sendMailById**
```c
// Sends an Email
//
// Sends An email through one of your mail orders.
//
generic_response_t* DefaultAPI_sendMailById(apiClient_t *apiClient, long id, char * subject, char * body, char * to, char * toName, char * from, char * fromName);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**id** | **long** | User ID | 
**subject** | **char \*** |  | [optional] 
**body** | **char \*** |  | [optional] 
**to** | **char \*** |  | [optional] 
**toName** | **char \*** |  | [optional] 
**from** | **char \*** |  | [optional] 
**fromName** | **char \*** |  | [optional] 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_validateMailOrder**
```c
// validatess order details before placing an order
//
void DefaultAPI_validateMailOrder(apiClient_t *apiClient);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 

### Return type

void

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_viewMailLogById**
```c
// displays the mail log
//
// By passing in the appropriate options, you can search for available inventory in the system 
//
list_t* DefaultAPI_viewMailLogById(apiClient_t *apiClient, long id, char * searchString, int skip, int limit);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**id** | **long** | User ID | 
**searchString** | **char \*** | pass an optional search string for looking up inventory | [optional] 
**skip** | **int** | number of records to skip for pagination | [optional] 
**limit** | **int** | maximum number of records to return | [optional] 

### Return type

[list_t](mail_log.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)
