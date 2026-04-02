# DenyRuleRecord

A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**user** | **str** | Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;. | [optional] 
**type** | **str** | The matching strategy for this rule.  &#x60;email&#x60; blocks an exact sender address, &#x60;domain&#x60; blocks all senders at a domain, &#x60;destination&#x60; blocks an exact recipient address, and &#x60;startswith&#x60; blocks any sender whose local-part begins with the given prefix. | 
**data** | **str** | The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;. | 
**id** | **str** | The numeric ID of the deny rule, as a string.  Pass this as &#x60;ruleId&#x60; to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove the rule. | 
**created** | **datetime** | The timestamp when the rule was created. | 

## Example

```python
from openapi_client.models.deny_rule_record import DenyRuleRecord

# TODO update the JSON string below
json = "{}"
# create an instance of DenyRuleRecord from a JSON string
deny_rule_record_instance = DenyRuleRecord.from_json(json)
# print the JSON string representation of the object
print(DenyRuleRecord.to_json())

# convert the object into a dict
deny_rule_record_dict = deny_rule_record_instance.to_dict()
# create an instance of DenyRuleRecord from a dict
deny_rule_record_from_dict = DenyRuleRecord.from_dict(deny_rule_record_dict)
```
[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


