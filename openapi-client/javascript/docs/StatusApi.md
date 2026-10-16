# MailBabyEmailDeliveryAndManagementServiceApi.StatusApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pingServer**](StatusApi.md#pingServer) | **GET** /ping | Health check — verify the API is reachable



## pingServer

> String pingServer()

Health check — verify the API is reachable

**No authentication required.** Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API host is reachable. Use this as a connectivity smoke-test before attempting any authenticated call. Useful for uptime monitoring, load-balancer health checks, and CI smoke tests. 

### Example

```javascript
import MailBabyEmailDeliveryAndManagementServiceApi from 'mail_baby_email_delivery_and_management_service_api';

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

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: text/plain, application/json

