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
 * The data for a email deny rule record.
 * @export
 * @interface DenyRuleRecord
 */
export interface DenyRuleRecord {
    /**
     * The type of deny rule.
     * @type {string}
     * @memberof DenyRuleRecord
     */
    type: DenyRuleRecordTypeEnum;
    /**
     * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @type {string}
     * @memberof DenyRuleRecord
     */
    data: string;
    /**
     * The deny rule Id number.
     * @type {number}
     * @memberof DenyRuleRecord
     */
    id: number;
    /**
     * the date the rule was created.
     * @type {Date}
     * @memberof DenyRuleRecord
     */
    created: Date;
    /**
     * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     * @type {string}
     * @memberof DenyRuleRecord
     */
    user?: string;
}


/**
 * @export
 */
export const DenyRuleRecordTypeEnum = {
    Domain: 'domain',
    Email: 'email',
    Startswith: 'startswith'
} as const;
export type DenyRuleRecordTypeEnum = typeof DenyRuleRecordTypeEnum[keyof typeof DenyRuleRecordTypeEnum];


/**
 * Check if a given object implements the DenyRuleRecord interface.
 */
export function instanceOfDenyRuleRecord(value: object): boolean {
    let isInstance = true;
    isInstance = isInstance && "type" in value;
    isInstance = isInstance && "data" in value;
    isInstance = isInstance && "id" in value;
    isInstance = isInstance && "created" in value;

    return isInstance;
}

export function DenyRuleRecordFromJSON(json: any): DenyRuleRecord {
    return DenyRuleRecordFromJSONTyped(json, false);
}

export function DenyRuleRecordFromJSONTyped(json: any, ignoreDiscriminator: boolean): DenyRuleRecord {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'type': json['type'],
        'data': json['data'],
        'id': json['id'],
        'created': (new Date(json['created'])),
        'user': !exists(json, 'user') ? undefined : json['user'],
    };
}

export function DenyRuleRecordToJSON(value?: DenyRuleRecord | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'type': value.type,
        'data': value.data,
        'id': value.id,
        'created': (value.created.toISOString()),
        'user': value.user,
    };
}
