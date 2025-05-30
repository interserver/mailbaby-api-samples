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
 *
 */

import ApiClient from '../ApiClient';

/**
 * The MailOrder model module.
 * @module model/MailOrder
 * @version 1.1.0
 */
class MailOrder {
    /**
     * Constructs a new <code>MailOrder</code>.
     * A mail order record
     * @alias module:model/MailOrder
     * @param id {Number} The ID of the order.
     * @param status {String} The order status.
     * @param username {String} The username to use for this order.
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
            if (data.hasOwnProperty('comment')) {
                obj['comment'] = ApiClient.convertToType(data['comment'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>MailOrder</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>MailOrder</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of MailOrder.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        // ensure the json data is a string
        if (data['status'] && !(typeof data['status'] === 'string' || data['status'] instanceof String)) {
            throw new Error("Expected the field `status` to be a primitive type in the JSON string but got " + data['status']);
        }
        // ensure the json data is a string
        if (data['username'] && !(typeof data['username'] === 'string' || data['username'] instanceof String)) {
            throw new Error("Expected the field `username` to be a primitive type in the JSON string but got " + data['username']);
        }
        // ensure the json data is a string
        if (data['comment'] && !(typeof data['comment'] === 'string' || data['comment'] instanceof String)) {
            throw new Error("Expected the field `comment` to be a primitive type in the JSON string but got " + data['comment']);
        }

        return true;
    }


}

MailOrder.RequiredProperties = ["id", "status", "username"];

/**
 * The ID of the order.
 * @member {Number} id
 */
MailOrder.prototype['id'] = undefined;

/**
 * The order status.
 * @member {String} status
 */
MailOrder.prototype['status'] = undefined;

/**
 * The username to use for this order.
 * @member {String} username
 */
MailOrder.prototype['username'] = undefined;

/**
 * Optional order comment.
 * @member {String} comment
 */
MailOrder.prototype['comment'] = undefined;






export default MailOrder;

