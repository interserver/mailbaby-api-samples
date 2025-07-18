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
 * @interface MailStatsTypeVolumeTo
 */
export interface MailStatsTypeVolumeTo {
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeTo
     */
    clientdomainCom?: number;
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeTo
     */
    usersiteNet?: number;
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeTo
     */
    salescompanyCom?: number;
    /**
     * 
     * @type {number}
     * @memberof MailStatsTypeVolumeTo
     */
    clientanothersiteCom?: number;
}

/**
 * Check if a given object implements the MailStatsTypeVolumeTo interface.
 */
export function instanceOfMailStatsTypeVolumeTo(value: object): value is MailStatsTypeVolumeTo {
    return true;
}

export function MailStatsTypeVolumeToFromJSON(json: any): MailStatsTypeVolumeTo {
    return MailStatsTypeVolumeToFromJSONTyped(json, false);
}

export function MailStatsTypeVolumeToFromJSONTyped(json: any, ignoreDiscriminator: boolean): MailStatsTypeVolumeTo {
    if (json == null) {
        return json;
    }
    return {
        
        'clientdomainCom': json['client@domain.com'] == null ? undefined : json['client@domain.com'],
        'usersiteNet': json['user@site.net'] == null ? undefined : json['user@site.net'],
        'salescompanyCom': json['sales@company.com'] == null ? undefined : json['sales@company.com'],
        'clientanothersiteCom': json['client@anothersite.com'] == null ? undefined : json['client@anothersite.com'],
    };
}

export function MailStatsTypeVolumeToToJSON(json: any): MailStatsTypeVolumeTo {
    return MailStatsTypeVolumeToToJSONTyped(json, false);
}

export function MailStatsTypeVolumeToToJSONTyped(value?: MailStatsTypeVolumeTo | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'client@domain.com': value['clientdomainCom'],
        'user@site.net': value['usersiteNet'],
        'sales@company.com': value['salescompanyCom'],
        'client@anothersite.com': value['clientanothersiteCom'],
    };
}

