# SendMail
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | [**SendMailTo**](SendMailTo.md) |  | 
**VarFrom** | **String** | The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order. | 
**Subject** | **String** | The subject line of the email. | 
**Body** | **String** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | 
**Id** | **Int64** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMail = Initialize-PSOpenAPIToolsSendMail  -To null `
 -VarFrom janedoe@company.com `
 -Subject Attention Client `
 -Body This is an email to inform you that something noteworthy happened. `
 -Id 2604
```

- Convert the resource to JSON
```powershell
$SendMail | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

