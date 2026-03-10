const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}_id`,
                label: `Internal auto-increment database row ID.  Not meaningful outside the API. - [${labelPrefix}_id]`,
                required: true,
                type: 'integer',
            },
            {
                key: `${keyPrefix}id`,
                label: `The relay-assigned mail ID (18–19 hex characters).  This is the value returned as `text` by the sending endpoints and accepted as the `mailid` filter on `GET /mail/log`. - [${labelPrefix}id]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}from`,
                label: `SMTP envelope `MAIL FROM` address (may differ from the `From:` header). - [${labelPrefix}from]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}to`,
                label: `SMTP envelope `RCPT TO` address. - [${labelPrefix}to]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}created`,
                label: `Human-readable creation timestamp in `YYYY-MM-DD HH:MM:SS` format. - [${labelPrefix}created]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}time`,
                label: `Unix timestamp of message acceptance.  Corresponds to the `startDate` and `endDate` filter parameters on `GET /mail/log`. - [${labelPrefix}time]`,
                required: true,
                type: 'integer',
            },
            {
                key: `${keyPrefix}user`,
                label: `The SMTP AUTH username used to submit the message (e.g. `mb5658`). Corresponds to the `username` field in `GET /mail` orders. - [${labelPrefix}user]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}transtype`,
                label: `SMTP transaction type negotiated with the relay (e.g. `ESMTPSA`). - [${labelPrefix}transtype]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}origin`,
                label: `IP address of the client that submitted the message to the relay. Corresponds to the `origin` filter parameter on `GET /mail/log`. - [${labelPrefix}origin]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}interface`,
                label: `Relay interface name that accepted the message (e.g. `feeder`). - [${labelPrefix}interface]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}subject`,
                label: `The `Subject` header value, if available. - [${labelPrefix}subject]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}messageId`,
                label: `The `Message-ID` header value, if present.  Can be used with the `messageId` filter on `GET /mail/log` for subsequent lookups. - [${labelPrefix}messageId]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}sendingZone`,
                label: `The sending zone assigned by the relay for outbound delivery. - [${labelPrefix}sendingZone]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}bodySize`,
                label: `Size of the message body in bytes. - [${labelPrefix}bodySize]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}seq`,
                label: `Sequence index of this recipient in a multi-recipient message. Starts at 1. - [${labelPrefix}seq]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}delivered`,
                label: `Delivery status flag.  `1` = successfully delivered to destination MX. `0` = queued, deferred, or failed.  `null` = delivery not yet attempted. Corresponds to the `delivered` filter parameter on `GET /mail/log`. - [${labelPrefix}delivered]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}response`,
                label: `The SMTP response string received from the destination MX server upon delivery attempt (e.g. `\"250 2.0.0 Ok queued as C91D83E128C\"`). - [${labelPrefix}response]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}recipient`,
                label: `The specific recipient address this delivery record is for. - [${labelPrefix}recipient]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}domain`,
                label: `The destination domain.  Corresponds to the `mx` filter parameter (which matches `mxHostname`, not `domain`) on `GET /mail/log`. - [${labelPrefix}domain]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}locked`,
                label: `Whether the queue entry is currently locked for delivery processing. - [${labelPrefix}locked]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}lockTime`,
                label: `Millisecond-precision timestamp of the last queue lock acquisition. - [${labelPrefix}lockTime]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}assigned`,
                label: `The relay server node assigned to deliver this message. - [${labelPrefix}assigned]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}queued`,
                label: `ISO 8601 timestamp when the message was placed into the delivery queue. - [${labelPrefix}queued]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}mxHostname`,
                label: `The MX hostname the relay connected to for delivery.  Corresponds to the `mx` filter parameter on `GET /mail/log`. - [${labelPrefix}mxHostname]`,
                type: 'string',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            '_id': bundle.inputData?.[`${keyPrefix}_id`],
            'id': bundle.inputData?.[`${keyPrefix}id`],
            'from': bundle.inputData?.[`${keyPrefix}from`],
            'to': bundle.inputData?.[`${keyPrefix}to`],
            'created': bundle.inputData?.[`${keyPrefix}created`],
            'time': bundle.inputData?.[`${keyPrefix}time`],
            'user': bundle.inputData?.[`${keyPrefix}user`],
            'transtype': bundle.inputData?.[`${keyPrefix}transtype`],
            'origin': bundle.inputData?.[`${keyPrefix}origin`],
            'interface': bundle.inputData?.[`${keyPrefix}interface`],
            'subject': bundle.inputData?.[`${keyPrefix}subject`],
            'messageId': bundle.inputData?.[`${keyPrefix}messageId`],
            'sendingZone': bundle.inputData?.[`${keyPrefix}sendingZone`],
            'bodySize': bundle.inputData?.[`${keyPrefix}bodySize`],
            'seq': bundle.inputData?.[`${keyPrefix}seq`],
            'delivered': bundle.inputData?.[`${keyPrefix}delivered`],
            'response': bundle.inputData?.[`${keyPrefix}response`],
            'recipient': bundle.inputData?.[`${keyPrefix}recipient`],
            'domain': bundle.inputData?.[`${keyPrefix}domain`],
            'locked': bundle.inputData?.[`${keyPrefix}locked`],
            'lockTime': bundle.inputData?.[`${keyPrefix}lockTime`],
            'assigned': bundle.inputData?.[`${keyPrefix}assigned`],
            'queued': bundle.inputData?.[`${keyPrefix}queued`],
            'mxHostname': bundle.inputData?.[`${keyPrefix}mxHostname`],
        }
    },
}
