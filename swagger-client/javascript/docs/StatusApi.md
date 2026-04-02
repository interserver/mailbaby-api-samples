# MailBabyEmailDeliveryAndManagementServiceApi.StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Checks if the server is running

<a name="pingServer"></a>
# **pingServer**
> &#x27;String&#x27; pingServer()

Checks if the server is running

A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. 

### Example
```javascript
import {MailBabyEmailDeliveryAndManagementServiceApi} from 'mail_baby_email_delivery_and_management_service_api';
let defaultClient = MailBabyEmailDeliveryAndManagementServiceApi.ApiClient.instance;

// Configure API key authorization: apiKeyAuth
let apiKeyAuth = defaultClient.authentications['apiKeyAuth'];
apiKeyAuth.apiKey = 'YOUR API KEY';
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKeyAuth.apiKeyPrefix = 'Token';

let apiInstance = new MailBabyEmailDeliveryAndManagementServiceApi.StatusApi();
apiInstance.pingServer((error, data, response) => {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
});
```

### Parameters
This endpoint does not need any parameter.

### Return type

**&#x27;String&#x27;**

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

