/**
 * MailBaby Email Delivery and Management Service API
 *
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


/**
 * (optional) File attachments to include in the email.  The file contents must be base64
 */
export interface MailAttachment { 
    /**
     * The filename of the attached file.
     */
    filename: string;
    /**
     * The file contents base64 encoded
     */
    data: string;
}

