# DenyRuleNew
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**User** | **String** | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] 
**Type** | **String** | The type of deny rule. | 
**VarData** | **String** | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | 

## Examples

- Prepare the resource
```powershell
$DenyRuleNew = Initialize-PSOpenAPIToolsDenyRuleNew  -User mb20682 `
 -Type email `
 -VarData domeinwo@server.guesshost.net
```

- Convert the resource to JSON
```powershell
$DenyRuleNew | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

