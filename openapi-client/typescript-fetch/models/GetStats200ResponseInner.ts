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
 * 
 * @export
 * @interface GetStats200ResponseInner
 */
export interface GetStats200ResponseInner {
    /**
     * 
     * @type {number}
     * @memberof GetStats200ResponseInner
     */
    id: number;
    /**
     * 
     * @type {string}
     * @memberof GetStats200ResponseInner
     */
    status: string;
    /**
     * 
     * @type {string}
     * @memberof GetStats200ResponseInner
     */
    username: string;
    /**
     * 
     * @type {string}
     * @memberof GetStats200ResponseInner
     */
    password?: string;
    /**
     * 
     * @type {string}
     * @memberof GetStats200ResponseInner
     */
    comment?: string;
}

/**
 * Check if a given object implements the GetStats200ResponseInner interface.
 */
export function instanceOfGetStats200ResponseInner(value: object): value is GetStats200ResponseInner {
    if (!('id' in value) || value['id'] === undefined) return false;
    if (!('status' in value) || value['status'] === undefined) return false;
    if (!('username' in value) || value['username'] === undefined) return false;
    return true;
}

export function GetStats200ResponseInnerFromJSON(json: any): GetStats200ResponseInner {
    return GetStats200ResponseInnerFromJSONTyped(json, false);
}

export function GetStats200ResponseInnerFromJSONTyped(json: any, ignoreDiscriminator: boolean): GetStats200ResponseInner {
    if (json == null) {
        return json;
    }
    return {
        
        'id': json['id'],
        'status': json['status'],
        'username': json['username'],
        'password': json['password'] == null ? undefined : json['password'],
        'comment': json['comment'] == null ? undefined : json['comment'],
    };
}

export function GetStats200ResponseInnerToJSON(json: any): GetStats200ResponseInner {
    return GetStats200ResponseInnerToJSONTyped(json, false);
}

export function GetStats200ResponseInnerToJSONTyped(value?: GetStats200ResponseInner | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'id': value['id'],
        'status': value['status'],
        'username': value['username'],
        'password': value['password'],
        'comment': value['comment'],
    };
}

