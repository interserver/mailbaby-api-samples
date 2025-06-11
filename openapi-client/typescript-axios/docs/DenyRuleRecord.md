# DenyRuleRecord

The data for a email deny rule record.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **string** | The type of deny rule. | [default to undefined]
**data** | **string** | The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com. | [default to undefined]
**id** | **string** | The deny rule Id number. | [default to undefined]
**created** | **string** | the date the rule was created. | [default to undefined]
**user** | **string** | Mail account username that will be tied to this rule.  If not specified the first active mail order will be used. | [optional] [default to undefined]

## Example

```typescript
import { DenyRuleRecord } from './api';

const instance: DenyRuleRecord = {
    type,
    data,
    id,
    created,
    user,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
