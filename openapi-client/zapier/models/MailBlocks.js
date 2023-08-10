const utils = require('../utils/utils');
const MailBlockClickHouse = require('../models/MailBlockClickHouse');
const MailBlockRspamd = require('../models/MailBlockRspamd');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}local`,
                label: `[${labelPrefix}local]`,
                children: MailBlockClickHouse.fields(`${keyPrefix}local${!isInput ? '[]' : ''}`, isInput, true), 
            },
            {
                key: `${keyPrefix}mbtrap`,
                label: `[${labelPrefix}mbtrap]`,
                children: MailBlockClickHouse.fields(`${keyPrefix}mbtrap${!isInput ? '[]' : ''}`, isInput, true), 
            },
            {
                key: `${keyPrefix}subject`,
                label: `[${labelPrefix}subject]`,
                children: MailBlockRspamd.fields(`${keyPrefix}subject${!isInput ? '[]' : ''}`, isInput, true), 
            },
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'local': utils.removeKeyPrefixes(bundle.inputData?.[`${keyPrefix}local`]),
            'mbtrap': utils.removeKeyPrefixes(bundle.inputData?.[`${keyPrefix}mbtrap`]),
            'subject': utils.removeKeyPrefixes(bundle.inputData?.[`${keyPrefix}subject`]),
        }
    },
}
