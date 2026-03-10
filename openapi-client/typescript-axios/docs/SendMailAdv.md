# SendMailAdv

Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**subject** | **string** | The subject line of the email. | [default to undefined]
**body** | **string** | The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;. | [default to undefined]
**from** | [**EmailAddressTypes**](EmailAddressTypes.md) |  | [default to undefined]
**to** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [default to undefined]
**replyto** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to undefined]
**cc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to undefined]
**bcc** | [**EmailAddressesTypes**](EmailAddressesTypes.md) |  | [optional] [default to undefined]
**attachments** | [**Array&lt;MailAttachment&gt;**](MailAttachment.md) | Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name. | [optional] [default to undefined]
**id** | **number** | Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;. | [optional] [default to undefined]

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
