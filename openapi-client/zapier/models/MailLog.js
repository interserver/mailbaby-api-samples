const utils = require('../utils/utils');
const MailLogEntry = require('../models/MailLogEntry');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}total`,
                label: `total number of mail log entries - [${labelPrefix}total]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}skip`,
                label: `number of emails skipped in listing - [${labelPrefix}skip]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}limit`,
                label: `number of emails to return - [${labelPrefix}limit]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}emails`,
                label: `[${labelPrefix}emails]`,
                children: MailLogEntry.fields(`${keyPrefix}emails${!isInput ? '[]' : ''}`, isInput, true), 
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'total': bundle.inputData?.[`${keyPrefix}total`],
            'skip': bundle.inputData?.[`${keyPrefix}skip`],
            'limit': bundle.inputData?.[`${keyPrefix}limit`],
            'emails': utils.removeKeyPrefixes(bundle.inputData?.[`${keyPrefix}emails`]),
        }
    },
}
