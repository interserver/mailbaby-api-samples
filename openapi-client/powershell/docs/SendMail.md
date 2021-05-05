# SendMail
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**To** | **String** | The Contact whom is the primary recipient of this email. | [optional] 
**VarFrom** | **String** | The contact whom is the this email is from. | [optional] 
**Subject** | **String** | The subject or title of the email | [optional] 
**Body** | **String** | The main email contents. | [optional] 

## Examples

- Prepare the resource
```powershell
$SendMail = Initialize-PSOpenAPIToolsSendMail  -To johndoe@company.com `
 -VarFrom johndoe@company.com `
 -Subject Your Package has been Delivered! `
 -Body The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.

```

- Convert the resource to JSON
```powershell
$SendMail | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

