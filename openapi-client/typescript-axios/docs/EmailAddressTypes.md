# EmailAddressTypes

A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **string** | The email address. | [default to undefined]
**name** | **string** | Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header). | [optional] [default to undefined]

## Example

```typescript
import { EmailAddressTypes } from './api';

const instance: EmailAddressTypes = {
    email,
    name,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
