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
 *
 */

import ApiClient from '../ApiClient';

/**
 * The MailOrder model module.
 * @module model/MailOrder
 * @version 1.0.0
 */
class MailOrder {
    /**
     * Constructs a new <code>MailOrder</code>.
     * @alias module:model/MailOrder
     * @param id {Number} 
     * @param status {String} 
     * @param username {String} 
     */
    constructor(id, status, username) { 
        
        MailOrder.initialize(this, id, status, username);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, id, status, username) { 
        obj['id'] = id;
        obj['status'] = status;
        obj['username'] = username;
    }

    /**
     * Constructs a <code>MailOrder</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/MailOrder} obj Optional instance to populate.
     * @return {module:model/MailOrder} The populated <code>MailOrder</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new MailOrder();

            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'Number');
            }
            if (data.hasOwnProperty('status')) {
                obj['status'] = ApiClient.convertToType(data['status'], 'String');
            }
            if (data.hasOwnProperty('username')) {
                obj['username'] = ApiClient.convertToType(data['username'], 'String');
            }
            if (data.hasOwnProperty('password')) {
                obj['password'] = ApiClient.convertToType(data['password'], 'String');
            }
            if (data.hasOwnProperty('comment')) {
                obj['comment'] = ApiClient.convertToType(data['comment'], 'String');
            }
        }
        return obj;
    }


}

/**
 * @member {Number} id
 */
MailOrder.prototype['id'] = undefined;

/**
 * @member {String} status
 */
MailOrder.prototype['status'] = undefined;

/**
 * @member {String} username
 */
MailOrder.prototype['username'] = undefined;

/**
 * @member {String} password
 */
MailOrder.prototype['password'] = undefined;

/**
 * @member {String} comment
 */
MailOrder.prototype['comment'] = undefined;






export default MailOrder;
