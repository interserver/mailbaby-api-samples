const utils = require('../utils/utils');
const EmailAddressTypes = require('../models/EmailAddressTypes');
const EmailAddressesTypes = require('../models/EmailAddressesTypes');
const MailAttachment = require('../models/MailAttachment');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
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
            ...EmailAddressTypes.fields(`${keyPrefix}from`, isInput),
            ...EmailAddressesTypes.fields(`${keyPrefix}to`, isInput),
            ...EmailAddressesTypes.fields(`${keyPrefix}replyto`, isInput),
            ...EmailAddressesTypes.fields(`${keyPrefix}cc`, isInput),
            ...EmailAddressesTypes.fields(`${keyPrefix}bcc`, isInput),
            {
                key: `${keyPrefix}attachments`,
                label: `[${labelPrefix}attachments]`,
                children: MailAttachment.fields(`${keyPrefix}attachments${!isInput ? '[]' : ''}`, isInput, true), 
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
            'subject': bundle.inputData?.[`${keyPrefix}subject`],
            'body': bundle.inputData?.[`${keyPrefix}body`],
            'from': utils.removeIfEmpty(EmailAddressTypes.mapping(bundle, `${keyPrefix}from`)),
            'to': utils.removeIfEmpty(EmailAddressesTypes.mapping(bundle, `${keyPrefix}to`)),
            'replyto': utils.removeIfEmpty(EmailAddressesTypes.mapping(bundle, `${keyPrefix}replyto`)),
            'cc': utils.removeIfEmpty(EmailAddressesTypes.mapping(bundle, `${keyPrefix}cc`)),
            'bcc': utils.removeIfEmpty(EmailAddressesTypes.mapping(bundle, `${keyPrefix}bcc`)),
            'attachments': utils.childMapping(bundle.inputData?.[`${keyPrefix}attachments`], `${keyPrefix}attachments`, MailAttachment),
            'id': bundle.inputData?.[`${keyPrefix}id`],
        }
    },
}
