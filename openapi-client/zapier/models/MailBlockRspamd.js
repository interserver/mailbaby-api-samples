const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}from`,
                label: `The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender. - [${labelPrefix}from]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}subject`,
                label: `The suspicious subject pattern that triggered the block. - [${labelPrefix}subject]`,
                required: true,
                type: 'string',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'from': bundle.inputData?.[`${keyPrefix}from`],
            'subject': bundle.inputData?.[`${keyPrefix}subject`],
        }
    },
}
