/**
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 */

import ApiClient from '../ApiClient';

/**
* The Body1 model module.
* @module model/Body1
* @version 1.0.0
*/
export default class Body1 {
    /**
    * Constructs a new <code>Body1</code>.
    * Details for an Email
    * @alias module:model/Body1
    * @class
    */

    constructor() {
        
        
        
    }

    /**
    * Constructs a <code>Body1</code> from a plain JavaScript object, optionally creating a new instance.
    * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
    * @param {Object} data The plain JavaScript object bearing properties of interest.
    * @param {module:model/Body1} obj Optional instance to populate.
    * @return {module:model/Body1} The populated <code>Body1</code> instance.
    */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new Body1();
                        
            
            if (data.hasOwnProperty('to')) {
                obj['to'] = ApiClient.convertToType(data['to'], 'String');
            }
            if (data.hasOwnProperty('from')) {
                obj['from'] = ApiClient.convertToType(data['from'], 'String');
            }
            if (data.hasOwnProperty('subject')) {
                obj['subject'] = ApiClient.convertToType(data['subject'], 'String');
            }
            if (data.hasOwnProperty('body')) {
                obj['body'] = ApiClient.convertToType(data['body'], 'String');
            }
        }
        return obj;
    }

    /**
    * The Contact whom is the primary recipient of this email.
    * @member {String} to
    */
    'to' = undefined;
    /**
    * The contact whom is the this email is from.
    * @member {String} from
    */
    'from' = undefined;
    /**
    * The subject or title of the email
    * @member {String} subject
    */
    'subject' = undefined;
    /**
    * The main email contents.
    * @member {String} body
    */
    'body' = undefined;




}