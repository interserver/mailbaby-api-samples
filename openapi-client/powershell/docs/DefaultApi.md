# PSOpenAPITools.PSOpenAPITools/Api.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Get-MailOrders**](DefaultApi.md#Get-MailOrders) | **GET** /mail | displays a list of mail service orders
[**Ping-Server**](DefaultApi.md#Ping-Server) | **GET** /ping | Checks if the server is running
[**Invoke-PlaceMailOrder**](DefaultApi.md#Invoke-PlaceMailOrder) | **POST** /mail/order | places a mail order
[**Send-AdvMail**](DefaultApi.md#Send-AdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**Send-Mail**](DefaultApi.md#Send-Mail) | **POST** /mail/send | Sends an Email
[**Confirm-MailOrder**](DefaultApi.md#Confirm-MailOrder) | **GET** /mail/order | validatess order details before placing an order
[**Invoke-ViewMailLogById**](DefaultApi.md#Invoke-ViewMailLogById) | **GET** /mail/log | displays the mail log


<a name="Get-MailOrders"></a>
# **Get-MailOrders**
> MailOrder[] Get-MailOrders<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <System.Nullable[Int64]><br>

displays a list of mail service orders

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$Id = 987 # Int64 | The ID of your mail order this will be sent through. (optional)

# displays a list of mail service orders
try {
     $Result = Get-MailOrders -Id $Id
} catch {
    Write-Host ("Exception occured when calling Get-MailOrders: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Id** | **Int64**| The ID of your mail order this will be sent through. | [optional] 

### Return type

[**MailOrder[]**](MailOrder.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

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

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Send-AdvMail"></a>
# **Send-AdvMail**
> GenericResponse Send-AdvMail<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-SendMailAdv] <PSCustomObject><br>

Sends an Email with Advanced Options

Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$SendMailAdv = (Initialize-SendMailAdv -Subject "Subject_example" -Body "Body_example" -VarFrom @((Initialize-SendMailAdv_from -Email "Email_example" -Name "Name_example")) -To @((Initialize-MailContact -Email "Email_example" -Name "Name_example")) -Id 123 -Replyto @((Initialize-MailContact -Email "Email_example" -Name "Name_example")) -Cc @() -Bcc @() -Attachments @((Initialize-MailAttachment -Filename "Filename_example" -VarData 123))) # SendMailAdv | 

# Sends an Email with Advanced Options
try {
     $Result = Send-AdvMail -SendMailAdv $SendMailAdv
} catch {
    Write-Host ("Exception occured when calling Send-AdvMail: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **SendMailAdv** | [**SendMailAdv**](SendMailAdv.md)|  | 

### Return type

[**GenericResponse**](GenericResponse.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, application/x-www-form-urlencoded
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Send-Mail"></a>
# **Send-Mail**
> GenericResponse Send-Mail<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-To] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-From] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Subject] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Body] <String><br>

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

$To = "To_example" # String | The Contact whom is the primary recipient of this email.
$From = "From_example" # String | The contact whom is the this email is from.
$Subject = "Subject_example" # String | The subject or title of the email
$Body = "Body_example" # String | The main email contents.

# Sends an Email
try {
     $Result = Send-Mail -To $To -From $From -Subject $Subject -Body $Body
} catch {
    Write-Host ("Exception occured when calling Send-Mail: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **To** | **String**| The Contact whom is the primary recipient of this email. | 
 **From** | **String**| The contact whom is the this email is from. | 
 **Subject** | **String**| The subject or title of the email | 
 **Body** | **String**| The main email contents. | 

### Return type

[**GenericResponse**](GenericResponse.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
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

void (empty response body)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a name="Invoke-ViewMailLogById"></a>
# **Invoke-ViewMailLogById**
> MailLog[] Invoke-ViewMailLogById<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <System.Nullable[Int64]><br>
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

$Id = 987 # Int64 | The ID of your mail order this will be sent through. (optional)
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
 **Id** | **Int64**| The ID of your mail order this will be sent through. | [optional] 
 **SearchString** | **String**| pass an optional search string for looking up inventory | [optional] 
 **Skip** | **Int32**| number of records to skip for pagination | [optional] 
 **Limit** | **Int32**| maximum number of records to return | [optional] 

### Return type

[**MailLog[]**](MailLog.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

