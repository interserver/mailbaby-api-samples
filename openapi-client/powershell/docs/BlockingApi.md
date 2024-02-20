# PSOpenAPITools.PSOpenAPITools\Api.BlockingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Add-Rule**](BlockingApi.md#Add-Rule) | **POST** /mail/rules | Creates a new email deny rule.
[**Invoke-DeleteRule**](BlockingApi.md#Invoke-DeleteRule) | **DELETE** /mail/rules/{ruleId} | Removes an deny mail rule.
[**Invoke-DelistBlock**](BlockingApi.md#Invoke-DelistBlock) | **POST** /mail/blocks/delete | Removes an email address from the blocked list
[**Get-MailBlocks**](BlockingApi.md#Get-MailBlocks) | **GET** /mail/blocks | displays a list of blocked email addresses
[**Get-Rules**](BlockingApi.md#Get-Rules) | **GET** /mail/rules | Displays a listing of deny email rules.


<a id="Add-Rule"></a>
# **Add-Rule**
> GenericResponse Add-Rule<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Type] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Data] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-User] <String><br>

Creates a new email deny rule.

Adds a new email deny rule into the system to block new emails that match the given criteria

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$Type = "domain" # String | The type of deny rule.
$Data = "MyData" # String | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
$User = "MyUser" # String | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. (optional)

# Creates a new email deny rule.
try {
    $Result = Add-Rule -Type $Type -Data $Data -User $User
} catch {
    Write-Host ("Exception occurred when calling Add-Rule: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Type** | **String**| The type of deny rule. | 
 **Data** | **String**| The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 
 **User** | **String**| Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="Invoke-DeleteRule"></a>
# **Invoke-DeleteRule**
> GenericResponse Invoke-DeleteRule<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-RuleId] <Int32><br>

Removes an deny mail rule.

Removes one of the configured deny mail rules from the system.

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$RuleId = 34 # Int32 | The ID of the Rules entry.

# Removes an deny mail rule.
try {
    $Result = Invoke-DeleteRule -RuleId $RuleId
} catch {
    Write-Host ("Exception occurred when calling Invoke-DeleteRule: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **RuleId** | **Int32**| The ID of the Rules entry. | 

### Return type

[**GenericResponse**](GenericResponse.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="Invoke-DelistBlock"></a>
# **Invoke-DelistBlock**
> GenericResponse Invoke-DelistBlock<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Body] <String><br>

Removes an email address from the blocked list

Removes an email address from the various block lists. 

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"

$Body = "{"email":"client@domain.com"}" # String | 

# Removes an email address from the blocked list
try {
    $Result = Invoke-DelistBlock -Body $Body
} catch {
    Write-Host ("Exception occurred when calling Invoke-DelistBlock: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Body** | **String**|  | 

### Return type

[**GenericResponse**](GenericResponse.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/json, multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="Get-MailBlocks"></a>
# **Get-MailBlocks**
> MailBlocks Get-MailBlocks<br>

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
    $Result = Get-MailBlocks
} catch {
    Write-Host ("Exception occurred when calling Get-MailBlocks: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MailBlocks**](MailBlocks.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="Get-Rules"></a>
# **Get-Rules**
> DenyRuleRecord[] Get-Rules<br>

Displays a listing of deny email rules.

Returns a listing of all the deny block rules you have configured.

### Example
```powershell
# general setting of the PowerShell module, e.g. base URL, authentication, etc
$Configuration = Get-Configuration
# Configure API key authorization: apiKeyAuth
$Configuration.ApiKey.X-API-KEY = "YOUR_API_KEY"
# Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
#$Configuration.ApiKeyPrefix.X-API-KEY = "Bearer"


# Displays a listing of deny email rules.
try {
    $Result = Get-Rules
} catch {
    Write-Host ("Exception occurred when calling Get-Rules: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**DenyRuleRecord[]**](DenyRuleRecord.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

