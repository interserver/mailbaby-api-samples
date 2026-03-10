# MailBlockClickHouse

A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**date** | **string** | The date the block event was recorded. | [default to undefined]
**from** | **string** | The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it. | [default to undefined]
**subject** | **string** | The &#x60;Subject&#x60; header of the blocked message. | [default to undefined]
**to** | **string** | The serialized list of recipients of the blocked message. | [default to undefined]
**messageId** | **string** | The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present. | [optional] [default to undefined]

## Example

```typescript
import { MailBlockClickHouse } from './api';

const instance: MailBlockClickHouse = {
    date,
    from,
    subject,
    to,
    messageId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
