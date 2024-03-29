// tslint:disable
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

import { exists, mapValues } from '../runtime';
import {
    EmailAddressTypes,
    EmailAddressTypesFromJSON,
    EmailAddressTypesToJSON,
    EmailAddressesTypes,
    EmailAddressesTypesFromJSON,
    EmailAddressesTypesToJSON,
    MailAttachment,
    MailAttachmentFromJSON,
    MailAttachmentToJSON,
} from './';

/**
 * Details for an Email
 * @export
 * @interface SendMailAdv
 */
export interface SendMailAdv  {
    /**
     * The subject or title of the email
     * @type {string}
     * @memberof SendMailAdv
     */
    subject: string;
    /**
     * The main email contents.
     * @type {string}
     * @memberof SendMailAdv
     */
    body: string;
    /**
     * 
     * @type {EmailAddressTypes}
     * @memberof SendMailAdv
     */
    from: EmailAddressTypes;
    /**
     * 
     * @type {EmailAddressesTypes}
     * @memberof SendMailAdv
     */
    to: EmailAddressesTypes;
    /**
     * 
     * @type {EmailAddressesTypes}
     * @memberof SendMailAdv
     */
    replyto?: EmailAddressesTypes;
    /**
     * 
     * @type {EmailAddressesTypes}
     * @memberof SendMailAdv
     */
    cc?: EmailAddressesTypes;
    /**
     * 
     * @type {EmailAddressesTypes}
     * @memberof SendMailAdv
     */
    bcc?: EmailAddressesTypes;
    /**
     * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @type {Array<MailAttachment>}
     * @memberof SendMailAdv
     */
    attachments?: Array<MailAttachment>;
    /**
     * (optional)  ID of the Mail order within our system to use as the Mail Account.
     * @type {number}
     * @memberof SendMailAdv
     */
    id?: number;
}

export function SendMailAdvFromJSON(json: any): SendMailAdv {
    return {
        'subject': json['subject'],
        'body': json['body'],
        'from': EmailAddressTypesFromJSON(json['from']),
        'to': EmailAddressesTypesFromJSON(json['to']),
        'replyto': !exists(json, 'replyto') ? undefined : EmailAddressesTypesFromJSON(json['replyto']),
        'cc': !exists(json, 'cc') ? undefined : EmailAddressesTypesFromJSON(json['cc']),
        'bcc': !exists(json, 'bcc') ? undefined : EmailAddressesTypesFromJSON(json['bcc']),
        'attachments': !exists(json, 'attachments') ? undefined : (json['attachments'] as Array<any>).map(MailAttachmentFromJSON),
        'id': !exists(json, 'id') ? undefined : json['id'],
    };
}

export function SendMailAdvToJSON(value?: SendMailAdv): any {
    if (value === undefined) {
        return undefined;
    }
    return {
        'subject': value.subject,
        'body': value.body,
        'from': EmailAddressTypesToJSON(value.from),
        'to': EmailAddressesTypesToJSON(value.to),
        'replyto': EmailAddressesTypesToJSON(value.replyto),
        'cc': EmailAddressesTypesToJSON(value.cc),
        'bcc': EmailAddressesTypesToJSON(value.bcc),
        'attachments': value.attachments === undefined ? undefined : (value.attachments as Array<any>).map(MailAttachmentToJSON),
        'id': value.id,
    };
}


