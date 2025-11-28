const samples = require('../samples/SendingApi');
const EmailAddressTypes = require('../models/EmailAddressTypes');
const EmailAddressesTypes = require('../models/EmailAddressesTypes');
const ErrorMessage = require('../models/ErrorMessage');
const GenericResponse = require('../models/GenericResponse');
const MailAttachment = require('../models/MailAttachment');
const SendMailRaw = require('../models/SendMailRaw');
const utils = require('../utils/utils');

module.exports = {
    rawMail: {
        key: 'rawMail',
        noun: 'Sending',
        display: {
            label: 'Sends a raw email',
            description: 'This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.',
            hidden: false,
        },
        operation: {
            inputFields: [
                ...SendMailRaw.fields(),
            ],
            outputFields: [
                ...GenericResponse.fields('', false),
            ],
            perform: async (z, bundle) => {
                const options = {
                    url: utils.replacePathParameters('https://api.mailbaby.net/mail/rawsend'),
                    method: 'POST',
                    removeMissingValuesFrom: { params: true, body: true },
                    headers: {
                        'Content-Type': 'application/json, multipart/form-data',
                        'Accept': 'application/json',
                    },
                    params: {
                    },
                    body: {
                        ...SendMailRaw.mapping(bundle),
                    },
                }
                return z.request(utils.requestOptionsMiddleware(z, bundle, options)).then((response) => {
                    response.throwForStatus();
                    const results = utils.responseOptionsMiddleware(z, bundle, 'rawMail', response.json);
                    return results;
                })
            },
            sample: samples['GenericResponseSample']
        }
    },
    sendAdvMail: {
        key: 'sendAdvMail',
        noun: 'Sending',
        display: {
            label: 'Sends an Email with Advanced Options',
            description: 'Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#39; &#x60;&#x60;&#x60; ',
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
                ...EmailAddressTypes.fields(),
                ...EmailAddressesTypes.fields(),
                ...EmailAddressesTypes.fields(),
                ...EmailAddressesTypes.fields(),
                ...EmailAddressesTypes.fields(),
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
                        'Content-Type': 'application/x-www-form-urlencoded, application/json',
                        'Accept': 'application/json',
                    },
                    params: {
                    },
                    body: {
                    },
                }
                return z.request(utils.requestOptionsMiddleware(z, bundle, options)).then((response) => {
                    response.throwForStatus();
                    const results = utils.responseOptionsMiddleware(z, bundle, 'sendAdvMail', response.json);
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
                {
                    key: 'id',
                    label: 'Optional Order ID',
                    type: 'integer',
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
                        'Content-Type': 'application/x-www-form-urlencoded, application/json',
                        'Accept': 'application/json',
                    },
                    params: {
                    },
                    body: {
                    },
                }
                return z.request(utils.requestOptionsMiddleware(z, bundle, options)).then((response) => {
                    response.throwForStatus();
                    const results = utils.responseOptionsMiddleware(z, bundle, 'sendMail', response.json);
                    return results;
                })
            },
            sample: samples['GenericResponseSample']
        }
    },
}
