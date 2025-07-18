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
 * @interface MailStatsTypeVolumeIp
 */
export interface MailStatsTypeVolumeIp {
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeIp
     */
    _1111?: number;
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeIp
     */
    _2222?: number;
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeIp
     */
    _3333?: number;
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeIp
     */
    _4444?: number;
}

/**
 * Check if a given object implements the MailStatsTypeVolumeIp interface.
 */
export function instanceOfMailStatsTypeVolumeIp(value: object): value is MailStatsTypeVolumeIp {
    return true;
}

export function MailStatsTypeVolumeIpFromJSON(json: any): MailStatsTypeVolumeIp {
    return MailStatsTypeVolumeIpFromJSONTyped(json, false);
}

export function MailStatsTypeVolumeIpFromJSONTyped(json: any, ignoreDiscriminator: boolean): MailStatsTypeVolumeIp {
    if (json == null) {
        return json;
    }
    return {
        
        '_1111': json['1.1.1.1'] == null ? undefined : json['1.1.1.1'],
        '_2222': json['2.2.2.2'] == null ? undefined : json['2.2.2.2'],
        '_3333': json['3.3.3.3'] == null ? undefined : json['3.3.3.3'],
        '_4444': json['4.4.4.4'] == null ? undefined : json['4.4.4.4'],
    };
}

export function MailStatsTypeVolumeIpToJSON(json: any): MailStatsTypeVolumeIp {
    return MailStatsTypeVolumeIpToJSONTyped(json, false);
}

export function MailStatsTypeVolumeIpToJSONTyped(value?: MailStatsTypeVolumeIp | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        '1.1.1.1': value['_1111'],
        '2.2.2.2': value['_2222'],
        '3.3.3.3': value['_3333'],
        '4.4.4.4': value['_4444'],
    };
}

