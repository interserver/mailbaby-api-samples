# PSOpenAPITools.PSOpenAPITools/Api.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Get-MailById**](DefaultApi.md#Get-MailById) | **GET** /mail/{id} | Gets mail order information by id
[**Get-MailOrders**](DefaultApi.md#Get-MailOrders) | **GET** /mail | displays a list of mail service orders
[**Ping-Server**](DefaultApi.md#Ping-Server) | **GET** /ping | Checks if the server is running
[**Invoke-PlaceMailOrder**](DefaultApi.md#Invoke-PlaceMailOrder) | **POST** /mail/order | places a mail order
[**Send-MailById**](DefaultApi.md#Send-MailById) | **POST** /mail/{id}/send | Sends an Email
[**Confirm-MailOrder**](DefaultApi.md#Confirm-MailOrder) | **GET** /mail/order | validatess order details before placing an order
[**Invoke-ViewMailLogById**](DefaultApi.md#Invoke-ViewMailLogById) | **GET** /mail/{id}/log | displays the mail log


<a name="Get-MailById"></a>
# **Get-MailById**
> MailOrder Get-MailById<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <Int64><br>

Gets mail order information by id

returns information about a mail order in the system with the given id.

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

# Configure API key authorization: apiLoginAuth
$Configuration.ApiKey.X-API-LOGIN = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-LOGIN = "Bearer"

# Configure API key authorization: apiPasswordAuth
$Configuration.ApiKey.X-API-PASS = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-PASS = "Bearer"

$Id = 987 # Int64 | User ID

# Gets mail order information by id
try {
     $Result = Get-MailById -Id $Id
} catch {
    Write-Host ("Exception occured when calling Get-MailById: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Id** | **Int64**| User ID | 

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
[**MailOrder**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Get-MailOrders"></a>
# **Get-MailOrders**
> MailOrder[] Get-MailOrders<br>

displays a list of mail service orders

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

# Configure API key authorization: apiLoginAuth
$Configuration.ApiKey.X-API-LOGIN = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-LOGIN = "Bearer"

# Configure API key authorization: apiPasswordAuth
$Configuration.ApiKey.X-API-PASS = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-PASS = "Bearer"


# displays a list of mail service orders
try {
     $Result = Get-MailOrders
} catch {
    Write-Host ("Exception occured when calling Get-MailOrders: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
[**MailOrder[]**](MailOrder.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml, text/plain

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Ping-Server"></a>
# **Ping-Server**
> void Ping-Server<br>

Checks if the server is running

### Example
```powershell

# Checks if the server is running
try {
     $Result = Ping-Server
} catch {
    Write-Host ("Exception occured when calling Ping-Server: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Invoke-PlaceMailOrder"></a>
# **Invoke-PlaceMailOrder**
> void Invoke-PlaceMailOrder<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-MailOrder] <PSCustomObject><br>

places a mail order

Adds an item to the system

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

# Configure API key authorization: apiLoginAuth
$Configuration.ApiKey.X-API-LOGIN = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-LOGIN = "Bearer"

# Configure API key authorization: apiPasswordAuth
$Configuration.ApiKey.X-API-PASS = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-PASS = "Bearer"

$MailOrder = (Initialize-MailOrder -Id 123 -Status "Status_example" -Username "Username_example" -Password "Password_example" -Comment "Comment_example") # MailOrder | Inventory item to add (optional)

# places a mail order
try {
     $Result = Invoke-PlaceMailOrder -MailOrder $MailOrder
} catch {
    Write-Host ("Exception occured when calling Invoke-PlaceMailOrder: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **MailOrder** | [**MailOrder**](MailOrder.md)| Inventory item to add | [optional] 

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Send-MailById"></a>
# **Send-MailById**
> GenericResponse Send-MailById<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <Int64><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Subject] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Body] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-To] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-From] <String><br>

Sends an Email

Sends An email through one of your mail orders.

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

# Configure API key authorization: apiLoginAuth
$Configuration.ApiKey.X-API-LOGIN = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-LOGIN = "Bearer"

# Configure API key authorization: apiPasswordAuth
$Configuration.ApiKey.X-API-PASS = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-PASS = "Bearer"

$Id = 987 # Int64 | User ID
$Subject = "Subject_example" # String |  (optional)
$Body = "Body_example" # String |  (optional)
$To = "To_example" # String |  (optional)
$From = "From_example" # String |  (optional)

# Sends an Email
try {
     $Result = Send-MailById -Id $Id -Subject $Subject -Body $Body -To $To -From $From
} catch {
    Write-Host ("Exception occured when calling Send-MailById: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Id** | **Int64**| User ID | 
 **Subject** | **String**|  | [optional] 
 **Body** | **String**|  | [optional] 
 **To** | **String**|  | [optional] 
 **From** | **String**|  | [optional] 

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
[**GenericResponse**](GenericResponse.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Confirm-MailOrder"></a>
# **Confirm-MailOrder**
> void Confirm-MailOrder<br>

validatess order details before placing an order

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

# Configure API key authorization: apiLoginAuth
$Configuration.ApiKey.X-API-LOGIN = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-LOGIN = "Bearer"

# Configure API key authorization: apiPasswordAuth
$Configuration.ApiKey.X-API-PASS = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-PASS = "Bearer"


# validatess order details before placing an order
try {
     $Result = Confirm-MailOrder
} catch {
    Write-Host ("Exception occured when calling Confirm-MailOrder: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Invoke-ViewMailLogById"></a>
# **Invoke-ViewMailLogById**
> MailLog[] Invoke-ViewMailLogById<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <Int64><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-SearchString] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Skip] <System.Nullable[Int32]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Limit] <System.Nullable[Int32]><br>

displays the mail log

By passing in the appropriate options, you can search for available inventory in the system 

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

# Configure API key authorization: apiLoginAuth
$Configuration.ApiKey.X-API-LOGIN = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-LOGIN = "Bearer"

# Configure API key authorization: apiPasswordAuth
$Configuration.ApiKey.X-API-PASS = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-PASS = "Bearer"

$Id = 987 # Int64 | User ID
$SearchString = "SearchString_example" # String | pass an optional search string for looking up inventory (optional)
$Skip = 987 # Int32 | number of records to skip for pagination (optional)
$Limit = 987 # Int32 | maximum number of records to return (optional)

# displays the mail log
try {
     $Result = Invoke-ViewMailLogById -Id $Id -SearchString $SearchString -Skip $Skip -Limit $Limit
} catch {
    Write-Host ("Exception occured when calling Invoke-ViewMailLogById: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Id** | **Int64**| User ID | 
 **SearchString** | **String**| pass an optional search string for looking up inventory | [optional] 
 **Skip** | **Int32**| number of records to skip for pagination | [optional] 
 **Limit** | **Int32**| maximum number of records to return | [optional] 

### Return type
# cmdlet returns PSCustomObject, the return object contains the properties of below type
[**MailLog[]**](MailLog.md)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth), [apiLoginAuth](../README.md#apiLoginAuth), [apiPasswordAuth](../README.md#apiPasswordAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

