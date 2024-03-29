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

import { exists, mapValues } from '../runtime';
/**
 * An email record
 * @export
 * @interface MailLogEntry
 */
export interface MailLogEntry {
    /**
     * internal db id
     * @type {number}
     * @memberof MailLogEntry
     */
    id: number;
    /**
     * mail id
     * @type {string}
     * @memberof MailLogEntry
     */
    id: string;
    /**
     * from address
     * @type {string}
     * @memberof MailLogEntry
     */
    from: string;
    /**
     * to address
     * @type {string}
     * @memberof MailLogEntry
     */
    to: string;
    /**
     * email subject
     * @type {string}
     * @memberof MailLogEntry
     */
    subject: string;
    /**
     * creation date
     * @type {string}
     * @memberof MailLogEntry
     */
    created: string;
    /**
     * creation timestamp
     * @type {number}
     * @memberof MailLogEntry
     */
    time: number;
    /**
     * user account
     * @type {string}
     * @memberof MailLogEntry
     */
    user: string;
    /**
     * transaction type
     * @type {string}
     * @memberof MailLogEntry
     */
    transtype: string;
    /**
     * origin ip
     * @type {string}
     * @memberof MailLogEntry
     */
    origin: string;
    /**
     * interface name
     * @type {string}
     * @memberof MailLogEntry
     */
    _interface: string;
    /**
     * sending zone
     * @type {string}
     * @memberof MailLogEntry
     */
    sendingZone: string;
    /**
     * email body size in bytes
     * @type {number}
     * @memberof MailLogEntry
     */
    bodySize: number;
    /**
     * index of email in the to adderess list
     * @type {number}
     * @memberof MailLogEntry
     */
    seq: number;
    /**
     * to address this email is being sent to
     * @type {string}
     * @memberof MailLogEntry
     */
    recipient: string;
    /**
     * to address domain
     * @type {string}
     * @memberof MailLogEntry
     */
    domain: string;
    /**
     * locked status
     * @type {number}
     * @memberof MailLogEntry
     */
    locked: number;
    /**
     * lock timestamp
     * @type {string}
     * @memberof MailLogEntry
     */
    lockTime: string;
    /**
     * assigned server
     * @type {string}
     * @memberof MailLogEntry
     */
    assigned: string;
    /**
     * queued timestamp
     * @type {string}
     * @memberof MailLogEntry
     */
    queued: string;
    /**
     * mx hostname
     * @type {string}
     * @memberof MailLogEntry
     */
    mxHostname: string;
    /**
     * mail delivery response
     * @type {string}
     * @memberof MailLogEntry
     */
    response: string;
    /**
     * message id
     * @type {string}
     * @memberof MailLogEntry
     */
    messageId?: string;
}

/**
 * Check if a given object implements the MailLogEntry interface.
 */
export function instanceOfMailLogEntry(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "id" in value;
    isInstance = isInstance && "id" in value;
    isInstance = isInstance && "from" in value;
    isInstance = isInstance && "to" in value;
    isInstance = isInstance && "subject" in value;
    isInstance = isInstance && "created" in value;
    isInstance = isInstance && "time" in value;
    isInstance = isInstance && "user" in value;
    isInstance = isInstance && "transtype" in value;
    isInstance = isInstance && "origin" in value;
    isInstance = isInstance && "_interface" in value;
    isInstance = isInstance && "sendingZone" in value;
    isInstance = isInstance && "bodySize" in value;
    isInstance = isInstance && "seq" in value;
    isInstance = isInstance && "recipient" in value;
    isInstance = isInstance && "domain" in value;
    isInstance = isInstance && "locked" in value;
    isInstance = isInstance && "lockTime" in value;
    isInstance = isInstance && "assigned" in value;
    isInstance = isInstance && "queued" in value;
    isInstance = isInstance && "mxHostname" in value;
    isInstance = isInstance && "response" in value;

    return isInstance;
}

export function MailLogEntryFromJSON(json: any): MailLogEntry {
    return MailLogEntryFromJSONTyped(json, false);
}

export function MailLogEntryFromJSONTyped(json: any, ignoreDiscriminator: boolean): MailLogEntry {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'id': json['_id'],
        'id': json['id'],
        'from': json['from'],
        'to': json['to'],
        'subject': json['subject'],
        'created': json['created'],
        'time': json['time'],
        'user': json['user'],
        'transtype': json['transtype'],
        'origin': json['origin'],
        '_interface': json['interface'],
        'sendingZone': json['sendingZone'],
        'bodySize': json['bodySize'],
        'seq': json['seq'],
        'recipient': json['recipient'],
        'domain': json['domain'],
        'locked': json['locked'],
        'lockTime': json['lockTime'],
        'assigned': json['assigned'],
        'queued': json['queued'],
        'mxHostname': json['mxHostname'],
        'response': json['response'],
        'messageId': !exists(json, 'messageId') ? undefined : json['messageId'],
    };
}

export function MailLogEntryToJSON(value?: MailLogEntry | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        '_id': value.id,
        'id': value.id,
        'from': value.from,
        'to': value.to,
        'subject': value.subject,
        'created': value.created,
        'time': value.time,
        'user': value.user,
        'transtype': value.transtype,
        'origin': value.origin,
        'interface': value._interface,
        'sendingZone': value.sendingZone,
        'bodySize': value.bodySize,
        'seq': value.seq,
        'recipient': value.recipient,
        'domain': value.domain,
        'locked': value.locked,
        'lockTime': value.lockTime,
        'assigned': value.assigned,
        'queued': value.queued,
        'mxHostname': value.mxHostname,
        'response': value.response,
        'messageId': value.messageId,
    };
}

