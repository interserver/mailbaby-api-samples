const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}to`,
                label: `Message counts keyed by destination (envelope `to`) email address. - [${labelPrefix}to]`,
                type: 'object',
            },
            {
                key: `${keyPrefix}from`,
                label: `Message counts keyed by sender (envelope `from`) email address. - [${labelPrefix}from]`,
                type: 'object',
            },
            {
                key: `${keyPrefix}ip`,
                label: `Message counts keyed by originating client IP address. - [${labelPrefix}ip]`,
                type: 'object',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'to': bundle.inputData?.[`${keyPrefix}to`],
            'from': bundle.inputData?.[`${keyPrefix}from`],
            'ip': bundle.inputData?.[`${keyPrefix}ip`],
        }
    },
}
