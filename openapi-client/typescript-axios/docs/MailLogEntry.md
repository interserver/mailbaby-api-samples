# MailLogEntry

An email record

## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**_id** | **number** | internal db id | [default to undefined]
**id** | **string** | mail id | [default to undefined]
**from** | **string** | from address | [default to undefined]
**to** | **string** | to address | [default to undefined]
**subject** | **string** | email subject | [default to undefined]
**created** | **string** | creation date | [default to undefined]
**time** | **number** | creation timestamp | [default to undefined]
**user** | **string** | user account | [default to undefined]
**transtype** | **string** | transaction type | [default to undefined]
**origin** | **string** | origin ip | [default to undefined]
**_interface** | **string** | interface name | [default to undefined]
**sendingZone** | **string** | sending zone | [default to undefined]
**bodySize** | **number** | email body size in bytes | [default to undefined]
**seq** | **number** | index of email in the to adderess list | [default to undefined]
**recipient** | **string** | to address this email is being sent to | [default to undefined]
**domain** | **string** | to address domain | [default to undefined]
**locked** | **number** | locked status | [default to undefined]
**lockTime** | **string** | lock timestamp | [default to undefined]
**assigned** | **string** | assigned server | [default to undefined]
**queued** | **string** | queued timestamp | [default to undefined]
**mxHostname** | **string** | mx hostname | [default to undefined]
**response** | **string** | mail delivery response | [default to undefined]
**messageId** | **string** | message id | [optional] [default to undefined]

## Example

```typescript
import { MailLogEntry } from './api';

const instance: MailLogEntry = {
    _id,
    id,
    from,
    to,
    subject,
    created,
    time,
    user,
    transtype,
    origin,
    _interface,
    sendingZone,
    bodySize,
    seq,
    recipient,
    domain,
    locked,
    lockTime,
    assigned,
    queued,
    mxHostname,
    response,
    messageId,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
