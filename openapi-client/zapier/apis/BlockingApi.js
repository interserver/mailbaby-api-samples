const samples = require('../samples/BlockingApi');
const DenyRuleRecord = require('../models/DenyRuleRecord');
const ErrorMessage = require('../models/ErrorMessage');
const GenericResponse = require('../models/GenericResponse');
const MailBlocks = require('../models/MailBlocks');
const utils = require('../utils/utils');

module.exports = {
    addRule: {
        key: 'addRule',
        noun: 'Blocking',
        display: {
            label: 'Creates a new email deny rule.',
            description: 'Adds a new email deny rule into the system to block new emails that match the given criteria',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'type',
                    label: 'The type of deny rule.',
                    type: 'string',
                    required: true,
                    choices: [
                        'domain',
                        'email',
                        'startswith',
                        'destination',
                    ],
                },
                {
                    key: 'data',
                    label: 'The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.',
                    type: 'string',
                    required: true,
                },
                {
                    key: 'user',
                    label: 'Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.',
                    type: 'string',
                },
            ],
            outputFields: [
                ...GenericResponse.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/rules'),
                    method: 'POST',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Authorization': 'Bearer {{bundle.authData.access_token}}',
                        'Content-Type': 'application/x-www-form-urlencoded, application/json',
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
            sample: samples['GenericResponseSample']
        }
    },
    deleteRule: {
        key: 'deleteRule',
        noun: 'Blocking',
        display: {
            label: 'Removes an deny mail rule.',
            description: 'Removes one of the configured deny mail rules from the system.',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'ruleId',
                    label: 'The ID of the Rules entry.',
                    type: 'integer',
                    required: true,
                },
            ],
            outputFields: [
                ...GenericResponse.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/rules/{ruleId}'),
                    method: 'DELETE',
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
            sample: samples['GenericResponseSample']
        }
    },
    delistBlock: {
        key: 'delistBlock',
        noun: 'Blocking',
        display: {
            label: 'Removes an email address from the blocked list',
            description: 'Removes an email address from the various block lists. ',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'body',
                    label: '',
                    type: 'string',
                    required: true,
                },
            ],
            outputFields: [
                ...GenericResponse.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/blocks/delete'),
                    method: 'POST',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Authorization': 'Bearer {{bundle.authData.access_token}}',
                        'Content-Type': 'application/json, multipart/form-data',
                        'Accept': 'application/json',
                    },
                    params: {
                    },
                    body: {
                        'body': bundle.inputData?.['body'],
                    },
                }
                return z.request(options).then((response) => {
                    response.throwForStatus();
                    const results = response.json;
                    return results;
                })
            },
            sample: samples['GenericResponseSample']
        }
    },
    getMailBlocks: {
        key: 'getMailBlocks',
        noun: 'Blocking',
        display: {
            label: 'displays a list of blocked email addresses',
            description: '',
            hidden: false,
        },
        operation: {
            inputFields: [
            ],
            outputFields: [
                ...MailBlocks.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/blocks'),
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
            sample: samples['MailBlocksSample']
        }
    },
    getRules: {
        key: 'getRules',
        noun: 'Blocking',
        display: {
            label: 'Displays a listing of deny email rules.',
            description: 'Returns a listing of all the deny block rules you have configured.',
            hidden: false,
        },
        operation: {
            inputFields: [
            ],
            outputFields: [
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/rules'),
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
            sample: samples['DenyRuleRecordSample']
        }
    },
}
