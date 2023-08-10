const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}id`,
                label: `[${labelPrefix}id]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}status`,
                label: `[${labelPrefix}status]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}username`,
                label: `[${labelPrefix}username]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}password`,
                label: `[${labelPrefix}password]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}comment`,
                label: `[${labelPrefix}comment]`,
                type: 'string',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'id': bundle.inputData?.[`${keyPrefix}id`],
            'status': bundle.inputData?.[`${keyPrefix}status`],
            'username': bundle.inputData?.[`${keyPrefix}username`],
            'password': bundle.inputData?.[`${keyPrefix}password`],
            'comment': bundle.inputData?.[`${keyPrefix}comment`],
        }
    },
}
