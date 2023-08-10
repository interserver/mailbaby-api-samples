const samples = require('../samples/SendingApi');
const EmailAddressName = require('../models/EmailAddressName');
const GenericResponse = require('../models/GenericResponse');
const MailAttachment = require('../models/MailAttachment');
const getMailOrders_401_response = require('../models/getMailOrders_401_response');
const utils = require('../utils/utils');

module.exports = {
    sendAdvMail: {
        key: 'sendAdvMail',
        noun: 'Sending',
        display: {
            label: 'Sends an Email with Advanced Options',
            description: 'Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'subject',
                    label: 'The subject or title of the email',
                    type: 'string',
                    required: true,
                },
                {
                    key: 'body',
                    label: 'The main email contents.',
                    type: 'string',
                    required: true,
                },
                ...EmailAddressName.fields(),
                {
                    key: 'to',
                    label: 'A list of destionation email addresses to send this to',
                    type: 'string',
                }
                {
                    key: 'replyto',
                    label: '(optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.',
                    type: 'string',
                }
                {
                    key: 'cc',
                    label: '(optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.',
                    type: 'string',
                }
                {
                    key: 'bcc',
                    label: '(optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.',
                    type: 'string',
                }
                {
                    key: 'attachments',
                    label: '(optional) File attachments to include in the email.  The file contents must be base64 encoded!',
                    type: 'string',
                }
                {
                    key: 'id',
                    label: '(optional)  ID of the Mail order within our system to use as the Mail Account.',
                    type: 'number',
                },
            ],
            outputFields: [
                ...GenericResponse.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/advsend'),
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
    sendMail: {
        key: 'sendMail',
        noun: 'Sending',
        display: {
            label: 'Sends an Email',
            description: 'Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. ',
            hidden: false,
        },
        operation: {
            inputFields: [
                {
                    key: 'to',
                    label: 'The Contact whom is the primary recipient of this email.',
                    type: 'string',
                    required: true,
                },
                {
                    key: 'from',
                    label: 'The contact whom is the this email is from.',
                    type: 'string',
                    required: true,
                },
                {
                    key: 'subject',
                    label: 'The subject or title of the email',
                    type: 'string',
                    required: true,
                },
                {
                    key: 'body',
                    label: 'The main email contents.',
                    type: 'string',
                    required: true,
                },
            ],
            outputFields: [
                ...GenericResponse.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/send'),
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
}
