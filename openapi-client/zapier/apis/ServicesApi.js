const samples = require('../samples/ServicesApi');
const MailOrder = require('../models/MailOrder');
const getMailOrders_401_response = require('../models/getMailOrders_401_response');
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
                        'Authorization': 'Bearer {{bundle.authData.access_token}}',
                        'Content-Type': '',
                        'Accept': 'application/json',
                    },
                    params: {
                    },
                    body: {
                    },
                }
                return z.request(options).then((response) => {
                    response.throwForStatus();
                    const results = response.json;
                    return results;
                })
            },
            sample: samples['MailOrderSample']
        }
    },
}
