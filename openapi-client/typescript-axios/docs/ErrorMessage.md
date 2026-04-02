# ErrorMessage

The response body returned when an error occurs.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**code** | **number** | The HTTP-style status code associated with the error. | [default to undefined]
**message** | **string** | A human-readable description of the error. | [default to undefined]

## Example

```typescript
import { ErrorMessage } from './api';

const instance: ErrorMessage = {
    code,
    message,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
