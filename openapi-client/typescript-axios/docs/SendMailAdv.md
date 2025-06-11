# SendMailAdv

Details for an Email

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **string** | The subject or title of the email | [default to undefined]
**body** | **string** | The main email contents. | [default to undefined]
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | [default to undefined]
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [default to undefined]
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to undefined]
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to undefined]
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to undefined]
**attachments** | [**Array&lt;MailAttachment&gt;**](MailAttachment.md) | (optional) File attachments to include in the email.  The file contents must be base64 encoded! | [optional] [default to undefined]
**id** | **number** | (optional)  ID of the Mail order within our system to use as the Mail Account. | [optional] [default to undefined]

## Example

```typescript
import { SendMailAdv } from './api';

const instance: SendMailAdv = {
    subject,
    body,
    from,
    to,
    replyto,
    cc,
    bcc,
    attachments,
    id,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
