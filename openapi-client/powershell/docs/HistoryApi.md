# PSOpenAPITools.PSOpenAPITools/Api.HistoryApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Get-Stats**](HistoryApi.md#Get-Stats) | **GET** /mail/stats | displays a list of blocked email addresses
[**Invoke-ViewMailLog**](HistoryApi.md#Invoke-ViewMailLog) | **GET** /mail/log | displays the mail log


<a id="Get-Stats"></a>
# **Get-Stats**
> GetStats200ResponseInner[] Get-Stats<br>

displays a list of blocked email addresses

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"


# displays a list of blocked email addresses
try {
    $Result = Get-Stats
} catch {
    Write-Host ("Exception occurred when calling Get-Stats: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GetStats200ResponseInner[]**](GetStats200ResponseInner.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="Invoke-ViewMailLog"></a>
# **Invoke-ViewMailLog**
> MailLog Invoke-ViewMailLog<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <System.Nullable[Int64]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Origin] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Mx] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-From] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-To] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Subject] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Mailid] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Skip] <System.Nullable[Int32]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Limit] <System.Nullable[Int32]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-StartDate] <System.Nullable[Int64]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-EndDate] <System.Nullable[Int64]><br>

displays the mail log

Get a listing of the emails sent through this system 

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$Id = 2604 # Int64 | The ID of your mail order this will be sent through. (optional)
$Origin = "1.2.3.4" # String | originating ip address sending mail (optional)
$Mx = "mx.google.com" # String | mx record mail was sent to (optional)
$From = "me@sender.com" # String | from email address (optional)
$To = "you@receiver.com" # String | to/destination email address (optional)
$Subject = "Support" # String | subject containing this string (optional)
$Mailid = "185997065c60008840" # String | mail id (optional)
$Skip = 1000 # Int32 | number of records to skip for pagination (optional) (default to 0)
$Limit = 1000 # Int32 | maximum number of records to return (optional) (default to 100)
$StartDate = 1641781008 # Int64 | earliest date to get emails in unix timestamp format (optional)
$EndDate = 1673317008 # Int64 | earliest date to get emails in unix timestamp format (optional)

# displays the mail log
try {
    $Result = Invoke-ViewMailLog -Id $Id -Origin $Origin -Mx $Mx -From $From -To $To -Subject $Subject -Mailid $Mailid -Skip $Skip -Limit $Limit -StartDate $StartDate -EndDate $EndDate
} catch {
    Write-Host ("Exception occurred when calling Invoke-ViewMailLog: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Id** | **Int64**| The ID of your mail order this will be sent through. | [optional] 
 **Origin** | **String**| originating ip address sending mail | [optional] 
 **Mx** | **String**| mx record mail was sent to | [optional] 
 **From** | **String**| from email address | [optional] 
 **To** | **String**| to/destination email address | [optional] 
 **Subject** | **String**| subject containing this string | [optional] 
 **Mailid** | **String**| mail id | [optional] 
 **Skip** | **Int32**| number of records to skip for pagination | [optional] [default to 0]
 **Limit** | **Int32**| maximum number of records to return | [optional] [default to 100]
 **StartDate** | **Int64**| earliest date to get emails in unix timestamp format | [optional] 
 **EndDate** | **Int64**| earliest date to get emails in unix timestamp format | [optional] 

### Return type

[**MailLog**](MailLog.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

