# MailAttachment

A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**filename** | **string** | The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;). | [default to undefined]
**data** | **string** | The file contents as a base64-encoded string.  Decode this to retrieve the original binary file. | [default to undefined]

## Example

```typescript
import { MailAttachment } from './api';

const instance: MailAttachment = {
    filename,
    data,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
