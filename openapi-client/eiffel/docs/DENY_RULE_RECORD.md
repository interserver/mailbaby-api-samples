# DENY_RULE_RECORD

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**user** | [**STRING_32**](STRING_32.md) | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] [default to null]
**type** | [**STRING_32**](STRING_32.md) | The type of deny rule. | [default to null]
**data** | [**STRING_32**](STRING_32.md) | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | [default to null]
**id** | [**STRING_32**](STRING_32.md) | The numeric ID of the deny rule, as a string.  Pass this as &#x60;ruleId&#x60; to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove the rule. | [default to null]
**created** | [**DATE_TIME**](DATE_TIME.md) | The timestamp when the rule was created. | [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


