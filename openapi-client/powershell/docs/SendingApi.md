# PSOpenAPITools.PSOpenAPITools/Api.SendingApi

All URIs are relative to *https://api.mailbaby.net*

Method | HTTP request | Description
------------- | ------------- | -------------
[**Send-AdvMail**](SendingApi.md#Send-AdvMail) | **POST** /mail/advsend | Sends an Email with Advanced Options
[**Send-Mail**](SendingApi.md#Send-Mail) | **POST** /mail/send | Sends an Email


<a id="Send-AdvMail"></a>
# **Send-AdvMail**
> GenericResponse Send-AdvMail<br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Subject] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Body] <String><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-From] <PSCustomObject><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-To] <PSCustomObject[]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Replyto] <PSCustomObject[]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Cc] <PSCustomObject[]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Bcc] <PSCustomObject[]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Attachments] <PSCustomObject[]><br>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[-Id] <System.Nullable[Int64]><br>

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

$Subject = "MySubject" # String | The subject or title of the email
$Body = "MyBody" # String | The main email contents.
$EmailAddressName = Initialize-EmailAddressName -Email "user@domain.com" -Name "John Smith" # EmailAddressName | 
 # EmailAddressName[] | A list of destionation email addresses to send this to
 # EmailAddressName[] | (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. (optional)
 # EmailAddressName[] | (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. (optional)
 # EmailAddressName[] | (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. (optional)
$MailAttachment = Initialize-MailAttachment -Filename "message.txt" -VarData "aGVsbG8gdGhlcmUK" # MailAttachment[] | (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
$Id = 789 # Int64 | (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)

# Sends an Email with Advanced Options
try {
    $Result = Send-AdvMail -Subject $Subject -Body $Body -From $From -To $To -Replyto $Replyto -Cc $Cc -Bcc $Bcc -Attachments $Attachments -Id $Id
} catch {
    Write-Host ("Exception occurred when calling Send-AdvMail: {0}" -f ($_.ErrorDetails | ConvertFrom-Json))
    Write-Host ("Response headers: {0}" -f ($_.Exception.Response.Headers | ConvertTo-Json))
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Subject** | **String**| The subject or title of the email | 
 **Body** | **String**| The main email contents. | 
 **From** | [**EmailAddressName**](EmailAddressName.md)|  | 
 **To** | [**EmailAddressName[]**](EmailAddressName.md)| A list of destionation email addresses to send this to | 
 **Replyto** | [**EmailAddressName[]**](EmailAddressName.md)| (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address. | [optional] 
 **Cc** | [**EmailAddressName[]**](EmailAddressName.md)| (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. | [optional] 
 **Bcc** | [**EmailAddressName[]**](EmailAddressName.md)| (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. | [optional] 
 **Attachments** | [**MailAttachment[]**](MailAttachment.md)| (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] 
 **Id** | **Int64**| (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] 

### Return type

[**GenericResponse**](GenericResponse.md) (PSCustomObject)

### Authorization

[apiKeyAuth](../README.md#apiKeyAuth)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded, application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

<a id="Send-Mail"></a>
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

