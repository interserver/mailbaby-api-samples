# DenyRuleRecord
## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
| **type** | **String** | The type of deny rule. | [default to null] |
| **data** | **String** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | [default to null] |
| **id** | **Integer** | The deny rule Id number. | [default to null] |
| **created** | **Date** | the date the rule was created. | [default to null] |
| **user** | **String** | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] [default to null] |

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

