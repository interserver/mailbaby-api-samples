const utils = require('../utils/utils');
const SendMailTo = require('../models/SendMailTo');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            ...SendMailTo.fields(`${keyPrefix}to`, isInput),
            {
                key: `${keyPrefix}from`,
                label: `The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order. - [${labelPrefix}from]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}subject`,
                label: `The subject line of the email. - [${labelPrefix}subject]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}body`,
                label: `The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`. - [${labelPrefix}body]`,
                required: true,
                type: 'string',
            },
            {
                key: `${keyPrefix}id`,
                label: `Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`. - [${labelPrefix}id]`,
                type: 'number',
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'to': utils.removeIfEmpty(SendMailTo.mapping(bundle, `${keyPrefix}to`)),
            'from': bundle.inputData?.[`${keyPrefix}from`],
            'subject': bundle.inputData?.[`${keyPrefix}subject`],
            'body': bundle.inputData?.[`${keyPrefix}body`],
            'id': bundle.inputData?.[`${keyPrefix}id`],
        }
    },
}
