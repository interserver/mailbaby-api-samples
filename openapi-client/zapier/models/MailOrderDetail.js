const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}id`,
                label: `The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries. - [${labelPrefix}id]`,
                required: true,
                type: 'integer',
            },
            {
                key: `${keyPrefix}status`,
                label: `The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send. - [${labelPrefix}status]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}username`,
                label: `The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed. - [${labelPrefix}username]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}password`,
                label: `The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`. - [${labelPrefix}password]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}comment`,
                label: `Optional human-readable note associated with the order. - [${labelPrefix}comment]`,
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
