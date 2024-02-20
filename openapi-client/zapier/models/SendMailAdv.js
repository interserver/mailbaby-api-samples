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
                label: `The subject or title of the email - [${labelPrefix}subject]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}body`,
                label: `The main email contents. - [${labelPrefix}body]`,
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
                label: `(optional)  ID of the Mail order within our system to use as the Mail Account. - [${labelPrefix}id]`,
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
