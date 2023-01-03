# PSOpenAPITools.PSOpenAPITools/Api.DefaultApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Get-MailOrders**](DefaultApi.md#Get-MailOrders) | **GET** /mail | displays a list of mail service orders
[**Ping-Server**](DefaultApi.md#Ping-Server) | **GET** /ping | Checks if the server is running
[**Send-AdvMail**](DefaultApi.md#Send-AdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**Send-Mail**](DefaultApi.md#Send-Mail) | **POST** /mail/send | Sends an Email
[**Invoke-ViewMailLog**](DefaultApi.md#Invoke-ViewMailLog) | **GET** /mail/log | displays the mail log


<a name="Get-MailOrders"></a>
# **Get-MailOrders**
> GetMailOrders200ResponseInner[] Get-MailOrders<br>

displays a list of mail service orders

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

[**GetMailOrders200ResponseInner[]**](GetMailOrders200ResponseInner.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

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
    Write-Host ("Exception occurred when calling Ping-Server: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
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

$SendMailAdvFrom = Initialize-SendMailAdvFrom -Email "business@company.com" -Name "The Man"
$SendMailAdvToInner = Initialize-SendMailAdvToInner -Email "johndoe@isp.com" -Name "John Doe"
$SendMailAdvReplytoInner = Initialize-SendMailAdvReplytoInner -Email "support@company.com" -Name "Support Staff"
$SendMailAdvCcInner = Initialize-SendMailAdvCcInner -Email "janedoe@isp.com" -Name "Jane Doe"
$SendMailAdvBccInner = Initialize-SendMailAdvBccInner -Email "records@company.com" -Name "Records Department"
$SendMailAdvAttachmentsInner = Initialize-SendMailAdvAttachmentsInner -Filename "company_logo.png" -VarData 
$SendMailAdv = Initialize-SendMailAdv -Subject "Your Package has been Delivered!" -Body "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else." -VarFrom $SendMailAdvFrom -To $SendMailAdvToInner -Replyto $SendMailAdvReplytoInner -Cc $SendMailAdvCcInner -Bcc $SendMailAdvBccInner -Attachments $SendMailAdvAttachmentsInner -Id 5000 # SendMailAdv | 

# Sends an Email with Advanced Options
try {
    $Result = Send-AdvMail -SendMailAdv $SendMailAdv
} catch {
    Write-Host ("Exception occurred when calling Send-AdvMail: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
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

Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$To = "MyTo" # String | The Contact whom is the primary recipient of this email.
$From = "MyFrom" # String | The contact whom is the this email is from.
$Subject = "MySubject" # String | The subject or title of the email
$Body = "MyBody" # String | The main email contents.

# Sends an Email
try {
    $Result = Send-Mail -To $To -From $From -Subject $Subject -Body $Body
} catch {
    Write-Host ("Exception occurred when calling Send-Mail: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
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

<a name="Invoke-ViewMailLog"></a>
# **Invoke-ViewMailLog**
> MailLog Invoke-ViewMailLog<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <System.Nullable[Int64]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Search] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Skip] <System.Nullable[Int32]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Limit] <System.Nullable[Int32]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-StartDate] <System.Nullable[Int64]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-EndDate] <System.Nullable[Int64]><br>

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

$Id = 789 # Int64 | The ID of your mail order this will be sent through. (optional)
$Search = "MySearch" # String | pass an optional search string for looking up inventory (optional)
$Skip = 56 # Int32 | number of records to skip for pagination (optional) (default to 0)
$Limit = 56 # Int32 | maximum number of records to return (optional) (default to 100)
$StartDate = 789 # Int64 | earliest date to get emails in unix timestamp format (optional)
$EndDate = 789 # Int64 | earliest date to get emails in unix timestamp format (optional)

# displays the mail log
try {
    $Result = Invoke-ViewMailLog -Id $Id -Search $Search -Skip $Skip -Limit $Limit -StartDate $StartDate -EndDate $EndDate
} catch {
    Write-Host ("Exception occurred when calling Invoke-ViewMailLog: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Id** | **Int64**| The ID of your mail order this will be sent through. | [optional] 
 **Search** | **String**| pass an optional search string for looking up inventory | [optional] 
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

