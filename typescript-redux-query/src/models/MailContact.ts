// tslint:disable
/**
 * Mail Baby API
 * This is an API for accesssing the mail services.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * An Email Contact
 * @export
 * @interface MailContact
 */
export interface MailContact  {
    /**
     * The email address
     * @type {string}
     * @memberof MailContact
     */
    email: string;
    /**
     * Optional contact name
     * @type {string}
     * @memberof MailContact
     */
    name?: string;
}

export function MailContactFromJSON(json: any): MailContact {
    return {
        'email': json['email'],
        'name': !exists(json, 'name') ? undefined : json['name'],
    };
}

export function MailContactToJSON(value?: MailContact): any {
    if (value === undefined) {
        return undefined;
    }
    return {
        'email': value.email,
        'name': value.name,
    };
}

