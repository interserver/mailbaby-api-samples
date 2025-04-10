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
import type { MailLogEntry } from './MailLogEntry';
import {
    MailLogEntryFromJSON,
    MailLogEntryFromJSONTyped,
    MailLogEntryToJSON,
    MailLogEntryToJSONTyped,
} from './MailLogEntry';

/**
 * Mail log records
 * @export
 * @interface MailLog
 */
export interface MailLog {
    /**
     * total number of mail log entries
     * @type {number}
     * @memberof MailLog
     */
    total: number;
    /**
     * number of emails skipped in listing
     * @type {number}
     * @memberof MailLog
     */
    skip: number;
    /**
     * number of emails to return
     * @type {number}
     * @memberof MailLog
     */
    limit: number;
    /**
     * 
     * @type {Array<MailLogEntry>}
     * @memberof MailLog
     */
    emails: Array<MailLogEntry>;
}

/**
 * Check if a given object implements the MailLog interface.
 */
export function instanceOfMailLog(value: object): value is MailLog {
    if (!('total' in value) || value['total'] === undefined) return false;
    if (!('skip' in value) || value['skip'] === undefined) return false;
    if (!('limit' in value) || value['limit'] === undefined) return false;
    if (!('emails' in value) || value['emails'] === undefined) return false;
    return true;
}

export function MailLogFromJSON(json: any): MailLog {
    return MailLogFromJSONTyped(json, false);
}

export function MailLogFromJSONTyped(json: any, ignoreDiscriminator: boolean): MailLog {
    if (json == null) {
        return json;
    }
    return {
        
        'total': json['total'],
        'skip': json['skip'],
        'limit': json['limit'],
        'emails': ((json['emails'] as Array<any>).map(MailLogEntryFromJSON)),
    };
}

export function MailLogToJSON(json: any): MailLog {
    return MailLogToJSONTyped(json, false);
}

export function MailLogToJSONTyped(value?: MailLog | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'total': value['total'],
        'skip': value['skip'],
        'limit': value['limit'],
        'emails': ((value['emails'] as Array<any>).map(MailLogEntryToJSON)),
    };
}

