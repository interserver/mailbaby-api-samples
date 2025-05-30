/**
 * MailBaby Email Delivery and Management Service API
 *
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { MailLogEntry } from './mailLogEntry';


/**
 * Mail log records
 */
export interface MailLog { 
    /**
     * total number of mail log entries
     */
    total: number;
    /**
     * number of emails skipped in listing
     */
    skip: number;
    /**
     * number of emails to return
     */
    limit: number;
    emails: Array<MailLogEntry>;
}

