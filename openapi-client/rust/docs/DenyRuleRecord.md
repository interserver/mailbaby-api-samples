# DenyRuleRecord

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**r#type** | **Type** | The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix. (enum: domain, email, startswith, destination) | 
**data** | **String** | The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. | 
**id** | **String** | The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule. | 
**created** | **chrono::DateTime<chrono::FixedOffset>** | The timestamp when the rule was created. | 
**user** | Option<**String**> | Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. | [optional]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


