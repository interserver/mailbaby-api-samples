const utils = require('../utils/utils');
const ByteArray = require('../models/ByteArray');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}filename`,
                label: `The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`). - [${labelPrefix}filename]`,
                required: true,
                type: 'string',
            },
            ...ByteArray.fields(`${keyPrefix}data`, isInput),
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'filename': bundle.inputData?.[`${keyPrefix}filename`],
            'data': utils.removeIfEmpty(ByteArray.mapping(bundle, `${keyPrefix}data`)),
        }
    },
}
