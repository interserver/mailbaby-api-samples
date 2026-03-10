const utils = require('../utils/utils');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}type`,
                label: `The type of deny rule. - [${labelPrefix}type]`,
                required: true,
                type: 'string',
                choices: [
                    'domain',
                    'email',
                    'startswith',
                    'destination',
                ],
            },
            {
                key: `${keyPrefix}data`,
                label: `The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`. - [${labelPrefix}data]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}user`,
                label: `Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`. - [${labelPrefix}user]`,
                type: 'string',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'type': bundle.inputData?.[`${keyPrefix}type`],
            'data': bundle.inputData?.[`${keyPrefix}data`],
            'user': bundle.inputData?.[`${keyPrefix}user`],
        }
    },
}
