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


/**
 * The data for a email deny rule record.
 */
export interface DenyRuleNew { 
    /**
     * The type of deny rule.
     */
    type: DenyRuleNew.TypeEnum;
    /**
     * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     */
    data: string;
    /**
     * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    user?: string;
}
export namespace DenyRuleNew {
    export type TypeEnum = 'domain' | 'email' | 'startswith';
    export const TypeEnum = {
        Domain: 'domain' as TypeEnum,
        Email: 'email' as TypeEnum,
        Startswith: 'startswith' as TypeEnum
    }
}