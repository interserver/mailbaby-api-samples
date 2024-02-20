# PSOpenAPITools.PSOpenAPITools\Api.ServicesApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Get-MailOrders**](ServicesApi.md#Get-MailOrders) | **GET** /mail | displays a list of mail service orders


<a id="Get-MailOrders"></a>
# **Get-MailOrders**
> MailOrder[] Get-MailOrders<br>

displays a list of mail service orders

This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"


# displays a list of mail service orders
try {
    $Result = Get-MailOrders
} catch {
    Write-Host ("Exception occurred when calling Get-MailOrders: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailOrder[]**](MailOrder.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

