const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}date`,
                label: `The date the block event was recorded. - [${labelPrefix}date]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}from`,
                label: `The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it. - [${labelPrefix}from]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}subject`,
                label: `The `Subject` header of the blocked message. - [${labelPrefix}subject]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}to`,
                label: `The serialized list of recipients of the blocked message. - [${labelPrefix}to]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}messageId`,
                label: `The `Message-ID` header of the blocked message, or `null` if not present. - [${labelPrefix}messageId]`,
                type: 'string',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'date': bundle.inputData?.[`${keyPrefix}date`],
            'from': bundle.inputData?.[`${keyPrefix}from`],
            'subject': bundle.inputData?.[`${keyPrefix}subject`],
            'to': bundle.inputData?.[`${keyPrefix}to`],
            'messageId': bundle.inputData?.[`${keyPrefix}messageId`],
        }
    },
}
