/**
 * MailBaby Email Delivery and Management Service API
 *
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { MailStatsTypeVolume } from './mailStatsTypeVolume';


/**
 * Statistics about the mail usage including volume by IP, To address, and From address; as well as total sent / delivered counts and cost.
 */
export interface MailStatsType { 
    time?: MailStatsType.TimeEnum;
    usage?: number;
    currency?: string;
    currencySymbol?: string;
    cost?: number;
    received?: number;
    sent?: number;
    volume?: MailStatsTypeVolume;
}
export namespace MailStatsType {
    export const TimeEnum = {
        All: 'all',
        Billing: 'billing',
        Month: 'month',
        _7d: '7d',
        _24h: '24h',
        Today: 'today',
        _1h: '1h'
    } as const;
    export type TimeEnum = typeof TimeEnum[keyof typeof TimeEnum];
}


