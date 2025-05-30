/* tslint:disable */
/* eslint-disable */
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

import { mapValues } from '../runtime';
/**
 * This is a block entry from the rspamd block list.
 * @export
 * @interface MailBlockRspamd
 */
export interface MailBlockRspamd {
    /**
     * 
     * @type {string}
     * @memberof MailBlockRspamd
     */
    from: string;
    /**
     * 
     * @type {string}
     * @memberof MailBlockRspamd
     */
    subject: string;
}

/**
 * Check if a given object implements the MailBlockRspamd interface.
 */
export function instanceOfMailBlockRspamd(value: object): value is MailBlockRspamd {
    if (!('from' in value) || value['from'] === undefined) return false;
    if (!('subject' in value) || value['subject'] === undefined) return false;
    return true;
}

export function MailBlockRspamdFromJSON(json: any): MailBlockRspamd {
    return MailBlockRspamdFromJSONTyped(json, false);
}

export function MailBlockRspamdFromJSONTyped(json: any, ignoreDiscriminator: boolean): MailBlockRspamd {
    if (json == null) {
        return json;
    }
    return {
        
        'from': json['from'],
        'subject': json['subject'],
    };
}

export function MailBlockRspamdToJSON(json: any): MailBlockRspamd {
    return MailBlockRspamdToJSONTyped(json, false);
}

export function MailBlockRspamdToJSONTyped(value?: MailBlockRspamd | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'from': value['from'],
        'subject': value['subject'],
    };
}

