/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import localVarRequest from 'request';
import http from 'http';

/* tslint:disable:no-unused-locals */
import { EmailAddressName } from '../model/emailAddressName';
import { GenericResponse } from '../model/genericResponse';
import { GetMailOrders401Response } from '../model/getMailOrders401Response';
import { MailAttachment } from '../model/mailAttachment';

import { ObjectSerializer, Authentication, VoidAuth, Interceptor } from '../model/models';
import { HttpBasicAuth, HttpBearerAuth, ApiKeyAuth, OAuth } from '../model/models';

import { HttpError, RequestFile } from './apis';

let defaultBasePath = 'https://api.mailbaby.net';

// ===============================================
// This file is autogenerated - Please do not edit
// ===============================================

export enum SendingApiApiKeys {
    apiKeyAuth,
}

export class SendingApi {
    protected _basePath = defaultBasePath;
    protected _defaultHeaders : any = {};
    protected _useQuerystring : boolean = false;

    protected authentications = {
        'default': <Authentication>new VoidAuth(),
        'apiKeyAuth': new ApiKeyAuth('header', 'X-API-KEY'),
    }

    protected interceptors: Interceptor[] = [];

    constructor(basePath?: string);
    constructor(basePathOrUsername: string, password?: string, basePath?: string) {
        if (password) {
            if (basePath) {
                this.basePath = basePath;
            }
        } else {
            if (basePathOrUsername) {
                this.basePath = basePathOrUsername
            }
        }
    }

    set useQuerystring(value: boolean) {
        this._useQuerystring = value;
    }

    set basePath(basePath: string) {
        this._basePath = basePath;
    }

    set defaultHeaders(defaultHeaders: any) {
        this._defaultHeaders = defaultHeaders;
    }

    get defaultHeaders() {
        return this._defaultHeaders;
    }

    get basePath() {
        return this._basePath;
    }

    public setDefaultAuthentication(auth: Authentication) {
        this.authentications.default = auth;
    }

    public setApiKey(key: SendingApiApiKeys, value: string) {
        (this.authentications as any)[SendingApiApiKeys[key]].apiKey = value;
    }

    public addInterceptor(interceptor: Interceptor) {
        this.interceptors.push(interceptor);
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * @summary Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param from 
     * @param to A list of destionation email addresses to send this to
     * @param replyto (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
     * @param cc (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     * @param bcc (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public async sendAdvMail (subject: string, body: string, from: EmailAddressName, to: Array<EmailAddressName>, replyto?: Array<EmailAddressName>, cc?: Array<EmailAddressName>, bcc?: Array<EmailAddressName>, attachments?: Array<MailAttachment>, id?: number, options: {headers: {[name: string]: string}} = {headers: {}}) : Promise<{ response: http.IncomingMessage; body: GenericResponse;  }> {
        const localVarPath = this.basePath + '/mail/advsend';
        let localVarQueryParameters: any = {};
        let localVarHeaderParams: any = (<any>Object).assign({}, this._defaultHeaders);
        const produces = ['application/json'];
        // give precedence to 'application/json'
        if (produces.indexOf('application/json') >= 0) {
            localVarHeaderParams.Accept = 'application/json';
        } else {
            localVarHeaderParams.Accept = produces.join(',');
        }
        let localVarFormParams: any = {};

        // verify required parameter 'subject' is not null or undefined
        if (subject === null || subject === undefined) {
            throw new Error('Required parameter subject was null or undefined when calling sendAdvMail.');
        }

        // verify required parameter 'body' is not null or undefined
        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling sendAdvMail.');
        }

        // verify required parameter 'from' is not null or undefined
        if (from === null || from === undefined) {
            throw new Error('Required parameter from was null or undefined when calling sendAdvMail.');
        }

        // verify required parameter 'to' is not null or undefined
        if (to === null || to === undefined) {
            throw new Error('Required parameter to was null or undefined when calling sendAdvMail.');
        }

        (<any>Object).assign(localVarHeaderParams, options.headers);

        let localVarUseFormData = false;

        if (subject !== undefined) {
            localVarFormParams['subject'] = ObjectSerializer.serialize(subject, "string");
        }

        if (body !== undefined) {
            localVarFormParams['body'] = ObjectSerializer.serialize(body, "string");
        }

        if (from !== undefined) {
            localVarFormParams['from'] = ObjectSerializer.serialize(from, "EmailAddressName");
        }

        if (to !== undefined) {
            localVarFormParams['to'] = ObjectSerializer.serialize(to, "Array<EmailAddressName>");
        }

        if (replyto !== undefined) {
            localVarFormParams['replyto'] = ObjectSerializer.serialize(replyto, "Array<EmailAddressName>");
        }

        if (cc !== undefined) {
            localVarFormParams['cc'] = ObjectSerializer.serialize(cc, "Array<EmailAddressName>");
        }

        if (bcc !== undefined) {
            localVarFormParams['bcc'] = ObjectSerializer.serialize(bcc, "Array<EmailAddressName>");
        }

        if (attachments !== undefined) {
            localVarFormParams['attachments'] = ObjectSerializer.serialize(attachments, "Array<MailAttachment>");
        }

        if (id !== undefined) {
            localVarFormParams['id'] = ObjectSerializer.serialize(id, "number");
        }

        let localVarRequestOptions: localVarRequest.Options = {
            method: 'POST',
            qs: localVarQueryParameters,
            headers: localVarHeaderParams,
            uri: localVarPath,
            useQuerystring: this._useQuerystring,
            json: true,
        };

        let authenticationPromise = Promise.resolve();
        if (this.authentications.apiKeyAuth.apiKey) {
            authenticationPromise = authenticationPromise.then(() => this.authentications.apiKeyAuth.applyToRequest(localVarRequestOptions));
        }
        authenticationPromise = authenticationPromise.then(() => this.authentications.default.applyToRequest(localVarRequestOptions));

        let interceptorPromise = authenticationPromise;
        for (const interceptor of this.interceptors) {
            interceptorPromise = interceptorPromise.then(() => interceptor(localVarRequestOptions));
        }

        return interceptorPromise.then(() => {
            if (Object.keys(localVarFormParams).length) {
                if (localVarUseFormData) {
                    (<any>localVarRequestOptions).formData = localVarFormParams;
                } else {
                    localVarRequestOptions.form = localVarFormParams;
                }
            }
            return new Promise<{ response: http.IncomingMessage; body: GenericResponse;  }>((resolve, reject) => {
                localVarRequest(localVarRequestOptions, (error, response, body) => {
                    if (error) {
                        reject(error);
                    } else {
                        if (response.statusCode && response.statusCode >= 200 && response.statusCode <= 299) {
                            body = ObjectSerializer.deserialize(body, "GenericResponse");
                            resolve({ response: response, body: body });
                        } else {
                            reject(new HttpError(response, body, response.statusCode));
                        }
                    }
                });
            });
        });
    }
    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @summary Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     */
    public async sendMail (to: string, from: string, subject: string, body: string, options: {headers: {[name: string]: string}} = {headers: {}}) : Promise<{ response: http.IncomingMessage; body: GenericResponse;  }> {
        const localVarPath = this.basePath + '/mail/send';
        let localVarQueryParameters: any = {};
        let localVarHeaderParams: any = (<any>Object).assign({}, this._defaultHeaders);
        const produces = ['application/json'];
        // give precedence to 'application/json'
        if (produces.indexOf('application/json') >= 0) {
            localVarHeaderParams.Accept = 'application/json';
        } else {
            localVarHeaderParams.Accept = produces.join(',');
        }
        let localVarFormParams: any = {};

        // verify required parameter 'to' is not null or undefined
        if (to === null || to === undefined) {
            throw new Error('Required parameter to was null or undefined when calling sendMail.');
        }

        // verify required parameter 'from' is not null or undefined
        if (from === null || from === undefined) {
            throw new Error('Required parameter from was null or undefined when calling sendMail.');
        }

        // verify required parameter 'subject' is not null or undefined
        if (subject === null || subject === undefined) {
            throw new Error('Required parameter subject was null or undefined when calling sendMail.');
        }

        // verify required parameter 'body' is not null or undefined
        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling sendMail.');
        }

        (<any>Object).assign(localVarHeaderParams, options.headers);

        let localVarUseFormData = false;

        if (to !== undefined) {
            localVarFormParams['to'] = ObjectSerializer.serialize(to, "string");
        }

        if (from !== undefined) {
            localVarFormParams['from'] = ObjectSerializer.serialize(from, "string");
        }

        if (subject !== undefined) {
            localVarFormParams['subject'] = ObjectSerializer.serialize(subject, "string");
        }

        if (body !== undefined) {
            localVarFormParams['body'] = ObjectSerializer.serialize(body, "string");
        }

        let localVarRequestOptions: localVarRequest.Options = {
            method: 'POST',
            qs: localVarQueryParameters,
            headers: localVarHeaderParams,
            uri: localVarPath,
            useQuerystring: this._useQuerystring,
            json: true,
        };

        let authenticationPromise = Promise.resolve();
        if (this.authentications.apiKeyAuth.apiKey) {
            authenticationPromise = authenticationPromise.then(() => this.authentications.apiKeyAuth.applyToRequest(localVarRequestOptions));
        }
        authenticationPromise = authenticationPromise.then(() => this.authentications.default.applyToRequest(localVarRequestOptions));

        let interceptorPromise = authenticationPromise;
        for (const interceptor of this.interceptors) {
            interceptorPromise = interceptorPromise.then(() => interceptor(localVarRequestOptions));
        }

        return interceptorPromise.then(() => {
            if (Object.keys(localVarFormParams).length) {
                if (localVarUseFormData) {
                    (<any>localVarRequestOptions).formData = localVarFormParams;
                } else {
                    localVarRequestOptions.form = localVarFormParams;
                }
            }
            return new Promise<{ response: http.IncomingMessage; body: GenericResponse;  }>((resolve, reject) => {
                localVarRequest(localVarRequestOptions, (error, response, body) => {
                    if (error) {
                        reject(error);
                    } else {
                        if (response.statusCode && response.statusCode >= 200 && response.statusCode <= 299) {
                            body = ObjectSerializer.deserialize(body, "GenericResponse");
                            resolve({ response: response, body: body });
                        } else {
                            reject(new HttpError(response, body, response.statusCode));
                        }
                    }
                });
            });
        });
    }
}