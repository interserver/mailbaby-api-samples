const samples = require('../samples/StatusApi');
const utils = require('../utils/utils');

module.exports = {
    pingServer: {
        key: 'pingServer',
        noun: 'Status',
        display: {
            label: 'Checks if the server is running',
            description: 'A lightweight health-check endpoint.  Returns the plain-text string &#x60;Server is up and running&#x60; with a &#x60;200&#x60; status when the API server is reachable.  **No authentication is required.** Useful for uptime monitoring, load-balancer health checks, and smoke tests. ',
            hidden: false,
        },
        operation: {
            inputFields: [
            ],
            outputFields: [
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/ping'),
                    method: 'GET',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Content-Type': '',
                        'Accept': 'text/plain',
                    },
                    params: {
                    },
                    body: {
                    },
                }
                return z.request(utils.requestOptionsMiddleware(z, bundle, options)).then((response) => {
                    response.throwForStatus();
                    const results = utils.responseOptionsMiddleware(z, bundle, 'pingServer', response.json);
                    return { data: results };
                })
            },
            sample: { data: {} }
        }
    },
}
