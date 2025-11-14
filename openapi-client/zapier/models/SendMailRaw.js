const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}raw_email`,
                label: `The entire email contents - [${labelPrefix}raw_email]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}id`,
                label: `Optional order id - [${labelPrefix}id]`,
                type: 'integer',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'raw_email': bundle.inputData?.[`${keyPrefix}raw_email`],
            'id': bundle.inputData?.[`${keyPrefix}id`],
        }
    },
}
