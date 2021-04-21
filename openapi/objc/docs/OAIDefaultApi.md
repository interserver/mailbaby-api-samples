# OAIDefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMailById**](OAIDefaultApi.md#getmailbyid) | **GET** /mail/{id} | Gets mail order information by id
[**getMailOrders**](OAIDefaultApi.md#getmailorders) | **GET** /mail | displays a list of mail service orders
[**pingServer**](OAIDefaultApi.md#pingserver) | **GET** /ping | Checks if the server is running
[**placeMailOrder**](OAIDefaultApi.md#placemailorder) | **POST** /mail/order | places a mail order
[**sendAdvMailById**](OAIDefaultApi.md#sendadvmailbyid) | **POST** /mail/{id}/advsend | Sends an Email with Advanced Options
[**sendMailById**](OAIDefaultApi.md#sendmailbyid) | **POST** /mail/{id}/send | Sends an Email
[**validateMailOrder**](OAIDefaultApi.md#validatemailorder) | **GET** /mail/order | validatess order details before placing an order
[**viewMailLogById**](OAIDefaultApi.md#viewmaillogbyid) | **GET** /mail/{id}/log | displays the mail log


# **getMailById**
```objc
-(NSURLSessionTask*) getMailByIdWithId: (NSNumber*) _id
        completionHandler: (void (^)(OAIMailOrder* output, NSError* error)) handler;
```

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];


NSNumber* _id = @56; // User ID

OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// Gets mail order information by id
[apiInstance getMailByIdWithId:_id
          completionHandler: ^(OAIMailOrder* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->getMailById: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_id** | **NSNumber***| User ID | 

### Return type

[**OAIMailOrder***](OAIMailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMailOrders**
```objc
-(NSURLSessionTask*) getMailOrdersWithCompletionHandler: 
        (void (^)(NSArray<OAIMailOrder>* output, NSError* error)) handler;
```

displays a list of mail service orders

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];



OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// displays a list of mail service orders
[apiInstance getMailOrdersWithCompletionHandler: 
          ^(NSArray<OAIMailOrder>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->getMailOrders: %@", error);
                        }
                    }];
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**NSArray<OAIMailOrder>***](OAIMailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **pingServer**
```objc
-(NSURLSessionTask*) pingServerWithCompletionHandler: 
        (void (^)(NSError* error)) handler;
```

Checks if the server is running

### Example 
```objc


OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// Checks if the server is running
[apiInstance pingServerWithCompletionHandler: 
          ^(NSError* error) {
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->pingServer: %@", error);
                        }
                    }];
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **placeMailOrder**
```objc
-(NSURLSessionTask*) placeMailOrderWithMailOrder: (OAIMailOrder*) mailOrder
        completionHandler: (void (^)(NSError* error)) handler;
```

places a mail order

Adds an item to the system

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];


OAIMailOrder* mailOrder = [[OAIMailOrder alloc] init]; // Inventory item to add (optional)

OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// places a mail order
[apiInstance placeMailOrderWithMailOrder:mailOrder
          completionHandler: ^(NSError* error) {
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->placeMailOrder: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mailOrder** | [**OAIMailOrder***](OAIMailOrder.md)| Inventory item to add | [optional] 

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendAdvMailById**
```objc
-(NSURLSessionTask*) sendAdvMailByIdWithId: (NSNumber*) _id
    sendMail: (OAISendMail*) sendMail
        completionHandler: (void (^)(OAIGenericResponse* output, NSError* error)) handler;
```

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];


NSNumber* _id = @56; // User ID
OAISendMail* sendMail = [[OAISendMail alloc] init]; // 

OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// Sends an Email with Advanced Options
[apiInstance sendAdvMailByIdWithId:_id
              sendMail:sendMail
          completionHandler: ^(OAIGenericResponse* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->sendAdvMailById: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_id** | **NSNumber***| User ID | 
 **sendMail** | [**OAISendMail***](OAISendMail.md)|  | 

### Return type

[**OAIGenericResponse***](OAIGenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded, text/plain
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **sendMailById**
```objc
-(NSURLSessionTask*) sendMailByIdWithId: (NSNumber*) _id
    subject: (NSString*) subject
    body: (NSString*) body
    to: (NSString*) to
    toName: (NSString*) toName
    from: (NSString*) from
    fromName: (NSString*) fromName
        completionHandler: (void (^)(OAIGenericResponse* output, NSError* error)) handler;
```

Sends an Email

Sends An email through one of your mail orders.

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];


NSNumber* _id = @56; // User ID
NSString* subject = @"subject_example"; //  (optional)
NSString* body = @"body_example"; //  (optional)
NSString* to = @"to_example"; //  (optional)
NSString* toName = @"toName_example"; //  (optional)
NSString* from = @"from_example"; //  (optional)
NSString* fromName = @"fromName_example"; //  (optional)

OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// Sends an Email
[apiInstance sendMailByIdWithId:_id
              subject:subject
              body:body
              to:to
              toName:toName
              from:from
              fromName:fromName
          completionHandler: ^(OAIGenericResponse* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->sendMailById: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_id** | **NSNumber***| User ID | 
 **subject** | **NSString***|  | [optional] 
 **body** | **NSString***|  | [optional] 
 **to** | **NSString***|  | [optional] 
 **toName** | **NSString***|  | [optional] 
 **from** | **NSString***|  | [optional] 
 **fromName** | **NSString***|  | [optional] 

### Return type

[**OAIGenericResponse***](OAIGenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **validateMailOrder**
```objc
-(NSURLSessionTask*) validateMailOrderWithCompletionHandler: 
        (void (^)(NSError* error)) handler;
```

validatess order details before placing an order

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];



OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// validatess order details before placing an order
[apiInstance validateMailOrderWithCompletionHandler: 
          ^(NSError* error) {
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->validateMailOrder: %@", error);
                        }
                    }];
```

### Parameters
This endpoint does not need any parameter.

### Return type

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **viewMailLogById**
```objc
-(NSURLSessionTask*) viewMailLogByIdWithId: (NSNumber*) _id
    searchString: (NSString*) searchString
    skip: (NSNumber*) skip
    limit: (NSNumber*) limit
        completionHandler: (void (^)(NSArray<OAIMailLog>* output, NSError* error)) handler;
```

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example 
```objc
OAIDefaultConfiguration *apiConfig = [OAIDefaultConfiguration sharedConfig];

// Configure API key authorization: (authentication scheme: apiKeyAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-KEY"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-KEY"];

// Configure API key authorization: (authentication scheme: apiLoginAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-LOGIN"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-LOGIN"];

// Configure API key authorization: (authentication scheme: apiPasswordAuth)
[apiConfig setApiKey:@"YOUR_API_KEY" forApiKeyIdentifier:@"X-API-PASS"];
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
//[apiConfig setApiKeyPrefix:@"Bearer" forApiKeyIdentifier:@"X-API-PASS"];


NSNumber* _id = @56; // User ID
NSString* searchString = @"searchString_example"; // pass an optional search string for looking up inventory (optional)
NSNumber* skip = @56; // number of records to skip for pagination (optional)
NSNumber* limit = @56; // maximum number of records to return (optional)

OAIDefaultApi*apiInstance = [[OAIDefaultApi alloc] init];

// displays the mail log
[apiInstance viewMailLogByIdWithId:_id
              searchString:searchString
              skip:skip
              limit:limit
          completionHandler: ^(NSArray<OAIMailLog>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling OAIDefaultApi->viewMailLogById: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **_id** | **NSNumber***| User ID | 
 **searchString** | **NSString***| pass an optional search string for looking up inventory | [optional] 
 **skip** | **NSNumber***| number of records to skip for pagination | [optional] 
 **limit** | **NSNumber***| maximum number of records to return | [optional] 

### Return type

[**NSArray<OAIMailLog>***](OAIMailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

