# EmailAddressName

An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **string** | The email address. | [default to undefined]
**name** | **string** | Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header). | [optional] [default to undefined]

## Example

```typescript
import { EmailAddressName } from './api';

const instance: EmailAddressName = {
    email,
    name,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
