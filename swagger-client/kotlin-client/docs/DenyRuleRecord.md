# DenyRuleRecord

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | [**kotlin.String**](.md) | The numeric ID of the deny rule, as a string.  Pass this as &#x60;ruleId&#x60; to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove the rule. | 
**created** | [**java.time.LocalDateTime**](java.time.LocalDateTime.md) | The timestamp when the rule was created. | 
**user** | [**kotlin.String**](.md) | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. |  [optional]
**type** | [**inline**](#Type) | The type of deny rule. | 
**&#x60;data&#x60;** | [**kotlin.String**](.md) | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | 

<a name="Type"></a>
## Enum: type
Name | Value
---- | -----
type | domain, email, startswith, destination
