const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}id`,
                label: `The ID of the order. - [${labelPrefix}id]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}status`,
                label: `The order status. - [${labelPrefix}status]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}username`,
                label: `The username to use for this order. - [${labelPrefix}username]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}comment`,
                label: `Optional order comment. - [${labelPrefix}comment]`,
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
            'comment': bundle.inputData?.[`${keyPrefix}comment`],
        }
    },
}
