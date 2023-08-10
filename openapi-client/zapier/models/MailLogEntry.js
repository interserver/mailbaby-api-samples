const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}_id`,
                label: `internal db id - [${labelPrefix}_id]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}id`,
                label: `mail id - [${labelPrefix}id]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}from`,
                label: `from address - [${labelPrefix}from]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}to`,
                label: `to address - [${labelPrefix}to]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}subject`,
                label: `email subject - [${labelPrefix}subject]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}created`,
                label: `creation date - [${labelPrefix}created]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}time`,
                label: `creation timestamp - [${labelPrefix}time]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}user`,
                label: `user account - [${labelPrefix}user]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}transtype`,
                label: `transaction type - [${labelPrefix}transtype]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}origin`,
                label: `origin ip - [${labelPrefix}origin]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}interface`,
                label: `interface name - [${labelPrefix}interface]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}sendingZone`,
                label: `sending zone - [${labelPrefix}sendingZone]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}bodySize`,
                label: `email body size in bytes - [${labelPrefix}bodySize]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}seq`,
                label: `index of email in the to adderess list - [${labelPrefix}seq]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}recipient`,
                label: `to address this email is being sent to - [${labelPrefix}recipient]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}domain`,
                label: `to address domain - [${labelPrefix}domain]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}locked`,
                label: `locked status - [${labelPrefix}locked]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}lockTime`,
                label: `lock timestamp - [${labelPrefix}lockTime]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}assigned`,
                label: `assigned server - [${labelPrefix}assigned]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}queued`,
                label: `queued timestamp - [${labelPrefix}queued]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}mxHostname`,
                label: `mx hostname - [${labelPrefix}mxHostname]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}response`,
                label: `mail delivery response - [${labelPrefix}response]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}messageId`,
                label: `message id - [${labelPrefix}messageId]`,
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
            'subject': bundle.inputData?.[`${keyPrefix}subject`],
            'created': bundle.inputData?.[`${keyPrefix}created`],
            'time': bundle.inputData?.[`${keyPrefix}time`],
            'user': bundle.inputData?.[`${keyPrefix}user`],
            'transtype': bundle.inputData?.[`${keyPrefix}transtype`],
            'origin': bundle.inputData?.[`${keyPrefix}origin`],
            'interface': bundle.inputData?.[`${keyPrefix}interface`],
            'sendingZone': bundle.inputData?.[`${keyPrefix}sendingZone`],
            'bodySize': bundle.inputData?.[`${keyPrefix}bodySize`],
            'seq': bundle.inputData?.[`${keyPrefix}seq`],
            'recipient': bundle.inputData?.[`${keyPrefix}recipient`],
            'domain': bundle.inputData?.[`${keyPrefix}domain`],
            'locked': bundle.inputData?.[`${keyPrefix}locked`],
            'lockTime': bundle.inputData?.[`${keyPrefix}lockTime`],
            'assigned': bundle.inputData?.[`${keyPrefix}assigned`],
            'queued': bundle.inputData?.[`${keyPrefix}queued`],
            'mxHostname': bundle.inputData?.[`${keyPrefix}mxHostname`],
            'response': bundle.inputData?.[`${keyPrefix}response`],
            'messageId': bundle.inputData?.[`${keyPrefix}messageId`],
        }
    },
}
