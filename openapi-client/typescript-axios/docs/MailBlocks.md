# MailBlocks

The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`.  Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**local** | [**Array&lt;MailBlockClickHouse&gt;**](MailBlockClickHouse.md) | Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list. | [default to undefined]
**mbtrap** | [**Array&lt;MailBlockClickHouse&gt;**](MailBlockClickHouse.md) | Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby\&#39;s honeypot / trap address detection. | [default to undefined]
**subject** | [**Array&lt;MailBlockRspamd&gt;**](MailBlockRspamd.md) | Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days. | [default to undefined]

## Example

```typescript
import { MailBlocks } from './api';

const instance: MailBlocks = {
    local,
    mbtrap,
    subject,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
