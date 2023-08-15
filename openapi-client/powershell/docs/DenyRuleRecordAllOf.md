# DenyRuleRecordAllOf
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**Id** | **Int32** | The deny rule Id number. | 
**Created** | **System.DateTime** | the date the rule was created. | 

## Examples

- Prepare the resource
```powershell
$DenyRuleRecordAllOf = Initialize-PSOpenAPIToolsDenyRuleRecordAllOf  -Id 41124 `
 -Created null
```

- Convert the resource to JSON
```powershell
$DenyRuleRecordAllOf | ConvertTo-JSON
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)

