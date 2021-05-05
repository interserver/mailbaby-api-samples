# DefaultAPI

All URIs are relative to *http://mystage.interserver.net:8787*

Method | HTTP request | Description
------------- | ------------- | -------------
[**DefaultAPI_getMailOrders**](DefaultAPI.md#DefaultAPI_getMailOrders) | **GET** /mail | displays a list of mail service orders
[**DefaultAPI_pingServer**](DefaultAPI.md#DefaultAPI_pingServer) | **GET** /ping | Checks if the server is running
[**DefaultAPI_placeMailOrder**](DefaultAPI.md#DefaultAPI_placeMailOrder) | **POST** /mail/order | places a mail order
[**DefaultAPI_sendAdvMail**](DefaultAPI.md#DefaultAPI_sendAdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**DefaultAPI_sendMail**](DefaultAPI.md#DefaultAPI_sendMail) | **POST** /mail/send | Sends an Email
[**DefaultAPI_validateMailOrder**](DefaultAPI.md#DefaultAPI_validateMailOrder) | **GET** /mail/order | validatess order details before placing an order
[**DefaultAPI_viewMailLog**](DefaultAPI.md#DefaultAPI_viewMailLog) | **GET** /mail/log | displays the mail log


# **DefaultAPI_getMailOrders**
```c
// displays a list of mail service orders
//
list_t* DefaultAPI_getMailOrders(apiClient_t *apiClient, long id);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**id** | **long** | The ID of your mail order this will be sent through. | [optional] 

### Return type

[list_t](mail_order.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_sendAdvMail**
```c
// Sends an Email with Advanced Options
//
// Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
//
generic_response_t* DefaultAPI_sendAdvMail(apiClient_t *apiClient, send_mail_adv_t * send_mail_adv);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**send_mail_adv** | **[send_mail_adv_t](send_mail_adv.md) \*** |  | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_sendMail**
```c
// Sends an Email
//
// Sends An email through one of your mail orders.
//
generic_response_t* DefaultAPI_sendMail(apiClient_t *apiClient, char * to, char * from, char * subject, char * body);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**to** | **char \*** | The Contact whom is the primary recipient of this email. | 
**from** | **char \*** | The contact whom is the this email is from. | 
**subject** | **char \*** | The subject or title of the email | 
**body** | **char \*** | The main email contents. | 

### Return type

[generic_response_t](generic_response.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **DefaultAPI_viewMailLog**
```c
// displays the mail log
//
// By passing in the appropriate options, you can search for available inventory in the system 
//
list_t* DefaultAPI_viewMailLog(apiClient_t *apiClient, long id, char * searchString, int skip, int limit);
```

### Parameters
Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
**apiClient** | **apiClient_t \*** | context containing the client configuration | 
**id** | **long** | The ID of your mail order this will be sent through. | [optional] 
**searchString** | **char \*** | pass an optional search string for looking up inventory | [optional] 
**skip** | **int** | number of records to skip for pagination | [optional] 
**limit** | **int** | maximum number of records to return | [optional] 

### Return type

[list_t](mail_log.md) *


### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

