const samples = require('../samples/HistoryApi');
const ErrorMessage = require('../models/ErrorMessage');
const MailLog = require('../models/MailLog');
const getStats_200_response_inner = require('../models/getStats_200_response_inner');
const utils = require('../utils/utils');

module.exports = {
    getStats: {
        key: 'getStats',
        noun: 'History',
        display: {
            label: 'Account usage statistics.',
            description: 'Returns information about the usage on your mail accounts.',
            hidden: false,
        },
        operation: {
            inputFields: [
            ],
            outputFields: [
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/stats'),
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
            sample: samples['getStats_200_response_innerSample']
        }
    },
    viewMailLog: {
        key: 'viewMailLog',
        noun: 'History',
        display: {
            label: 'displays the mail log',
            description: 'Get a listing of the emails sent through this system ',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'id',
                    label: 'The ID of your mail order this will be sent through.',
                    type: 'number',
                },
                {
                    key: 'origin',
                    label: 'originating ip address sending mail',
                    type: 'string',
                },
                {
                    key: 'mx',
                    label: 'mx record mail was sent to',
                    type: 'string',
                },
                {
                    key: 'from',
                    label: 'from email address',
                    type: 'string',
                },
                {
                    key: 'to',
                    label: 'to/destination email address',
                    type: 'string',
                },
                {
                    key: 'subject',
                    label: 'subject containing this string',
                    type: 'string',
                },
                {
                    key: 'mailid',
                    label: 'mail id',
                    type: 'string',
                },
                {
                    key: 'skip',
                    label: 'number of records to skip for pagination',
                    type: 'integer',
                },
                {
                    key: 'limit',
                    label: 'maximum number of records to return',
                    type: 'integer',
                },
                {
                    key: 'startDate',
                    label: 'earliest date to get emails in unix timestamp format',
                    type: 'number',
                },
                {
                    key: 'endDate',
                    label: 'earliest date to get emails in unix timestamp format',
                    type: 'number',
                },
            ],
            outputFields: [
                ...MailLog.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/log'),
                    method: 'GET',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Authorization': 'Bearer {{bundle.authData.access_token}}',
                        'Content-Type': '',
                        'Accept': 'application/json',
                    },
                    params: {
                        'id': bundle.inputData?.['id'],
                        'origin': bundle.inputData?.['origin'],
                        'mx': bundle.inputData?.['mx'],
                        'from': bundle.inputData?.['from'],
                        'to': bundle.inputData?.['to'],
                        'subject': bundle.inputData?.['subject'],
                        'mailid': bundle.inputData?.['mailid'],
                        'skip': bundle.inputData?.['skip'],
                        'limit': bundle.inputData?.['limit'],
                        'startDate': bundle.inputData?.['startDate'],
                        'endDate': bundle.inputData?.['endDate'],
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
            sample: samples['MailLogSample']
        }
    },
}
