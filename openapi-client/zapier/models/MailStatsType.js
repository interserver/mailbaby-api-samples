const utils = require('../utils/utils');
const MailStatsVolume = require('../models/MailStatsVolume');

module.exports = {
    fields: (prefix = '', isInput = true, isArrayChild = false) => {
        const {keyPrefix, labelPrefix} = utils.buildKeyAndLabel(prefix, isInput, isArrayChild)
        return [
            {
                key: `${keyPrefix}time`,
                label: `The time window these `received`, `sent`, and `volume` statistics cover. - [${labelPrefix}time]`,
                type: 'string',
                choices: [
                    'all',
                    'billing',
                    'month',
                    '7d',
                    '24h',
                    'day',
                    '1h',
                ],
            },
            {
                key: `${keyPrefix}usage`,
                label: `Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. - [${labelPrefix}usage]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}currency`,
                label: `The ISO 4217 currency code for this account (e.g. `USD`). - [${labelPrefix}currency]`,
                type: 'string',
            },
            {
                key: `${keyPrefix}cost`,
                label: `Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). - [${labelPrefix}cost]`,
                type: 'number',
            },
            {
                key: `${keyPrefix}received`,
                label: `Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. - [${labelPrefix}received]`,
                type: 'integer',
            },
            {
                key: `${keyPrefix}sent`,
                label: `Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. - [${labelPrefix}sent]`,
                type: 'integer',
            },
            ...MailStatsVolume.fields(`${keyPrefix}volume`, isInput),
        ]
    },
    mapping: (bundle, prefix = '') => {
        const {keyPrefix} = utils.buildKeyAndLabel(prefix)
        return {
            'time': bundle.inputData?.[`${keyPrefix}time`],
            'usage': bundle.inputData?.[`${keyPrefix}usage`],
            'currency': bundle.inputData?.[`${keyPrefix}currency`],
            'cost': bundle.inputData?.[`${keyPrefix}cost`],
            'received': bundle.inputData?.[`${keyPrefix}received`],
            'sent': bundle.inputData?.[`${keyPrefix}sent`],
            'volume': utils.removeIfEmpty(MailStatsVolume.mapping(bundle, `${keyPrefix}volume`)),
        }
    },
}
