# GenericResponse

Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record\'s ID; for delete calls it contains a confirmation string.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**status** | **string** | Always &#x60;\&quot;ok\&quot;&#x60; on success. | [optional] [default to undefined]
**text** | **string** | Operation-specific result string.  For send operations this is the relay transaction ID (e.g. &#x60;185caa69ff7000f47c&#x60;) which can be used as the &#x60;mailid&#x60; parameter in &#x60;GET /mail/log&#x60;.  For create operations this is the new record\&#39;s numeric ID.  For delete operations this is a human-readable confirmation. | [optional] [default to undefined]

## Example

```typescript
import { GenericResponse } from './api';

const instance: GenericResponse = {
    status,
    text,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
