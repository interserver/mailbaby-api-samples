const samples = require('../samples/ServicesApi');
const ErrorMessage = require('../models/ErrorMessage');
const MailOrder = require('../models/MailOrder');
const utils = require('../utils/utils');

module.exports = {
    getMailOrders: {
        key: 'getMailOrders',
        noun: 'Services',
        display: {
            label: 'displays a list of mail service orders',
            description: 'This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.',
            hidden: false,
        },
        operation: {
            inputFields: [
            ],
            outputFields: [
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail'),
                    method: 'GET',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Content-Type': '',
                        'Accept': 'application/json',
                    },
                    params: {
                    },
                    body: {
                    },
                }
                return z.request(utils.requestOptionsMiddleware(z, bundle, options)).then((response) => {
                    response.throwForStatus();
                    const results = utils.responseOptionsMiddleware(z, bundle, 'getMailOrders', response.json);
                    return results;
                })
            },
            sample: samples['MailOrderSample']
        }
    },
}
