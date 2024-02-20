# IO.Swagger.Model.DenyRuleRecord
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **string** | The deny rule Id number. | 
**Created** | **DateTime?** | the date the rule was created. | 
**User** | **string** | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] 
**Type** | **string** | The type of deny rule. | 
**Data** | **string** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

