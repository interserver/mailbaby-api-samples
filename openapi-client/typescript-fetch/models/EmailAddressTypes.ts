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

import {
    EmailAddressName,
    instanceOfEmailAddressName,
    EmailAddressNameFromJSON,
    EmailAddressNameFromJSONTyped,
    EmailAddressNameToJSON,
} from './EmailAddressName';
import {
    string,
    instanceOfstring,
    stringFromJSON,
    stringFromJSONTyped,
    stringToJSON,
} from './string';

/**
 * @type EmailAddressTypes
 * 
 * @export
 */
export type EmailAddressTypes = EmailAddressName | string;

export function EmailAddressTypesFromJSON(json: any): EmailAddressTypes {
    return EmailAddressTypesFromJSONTyped(json, false);
}

export function EmailAddressTypesFromJSONTyped(json: any, ignoreDiscriminator: boolean): EmailAddressTypes {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return { ...EmailAddressNameFromJSONTyped(json, true), ...stringFromJSONTyped(json, true) };
}

export function EmailAddressTypesToJSON(value?: EmailAddressTypes | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }

    if (instanceOfEmailAddressName(value)) {
        return EmailAddressNameToJSON(value as EmailAddressName);
    }
    if (instanceOfstring(value)) {
        return stringToJSON(value as string);
    }

    return {};
}
