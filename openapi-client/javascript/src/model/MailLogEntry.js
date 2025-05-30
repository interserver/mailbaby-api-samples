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
 * The MailLogEntry model module.
 * @module model/MailLogEntry
 * @version 1.1.0
 */
class MailLogEntry {
    /**
     * Constructs a new <code>MailLogEntry</code>.
     * An email record
     * @alias module:model/MailLogEntry
     * @param id {Number} internal db id
     * @param id {String} mail id
     * @param from {String} from address
     * @param to {String} to address
     * @param subject {String} email subject
     * @param created {String} creation date
     * @param time {Number} creation timestamp
     * @param user {String} user account
     * @param transtype {String} transaction type
     * @param origin {String} origin ip
     * @param _interface {String} interface name
     * @param sendingZone {String} sending zone
     * @param bodySize {Number} email body size in bytes
     * @param seq {Number} index of email in the to adderess list
     * @param recipient {String} to address this email is being sent to
     * @param domain {String} to address domain
     * @param locked {Number} locked status
     * @param lockTime {String} lock timestamp
     * @param assigned {String} assigned server
     * @param queued {String} queued timestamp
     * @param mxHostname {String} mx hostname
     * @param response {String} mail delivery response
     */
    constructor(id, id, from, to, subject, created, time, user, transtype, origin, _interface, sendingZone, bodySize, seq, recipient, domain, locked, lockTime, assigned, queued, mxHostname, response) { 
        
        MailLogEntry.initialize(this, id, id, from, to, subject, created, time, user, transtype, origin, _interface, sendingZone, bodySize, seq, recipient, domain, locked, lockTime, assigned, queued, mxHostname, response);
    }

    /**
     * Initializes the fields of this object.
     * This method is used by the constructors of any subclasses, in order to implement multiple inheritance (mix-ins).
     * Only for internal use.
     */
    static initialize(obj, id, id, from, to, subject, created, time, user, transtype, origin, _interface, sendingZone, bodySize, seq, recipient, domain, locked, lockTime, assigned, queued, mxHostname, response) { 
        obj['_id'] = id;
        obj['id'] = id;
        obj['from'] = from;
        obj['to'] = to;
        obj['subject'] = subject;
        obj['created'] = created;
        obj['time'] = time;
        obj['user'] = user;
        obj['transtype'] = transtype;
        obj['origin'] = origin;
        obj['interface'] = _interface;
        obj['sendingZone'] = sendingZone;
        obj['bodySize'] = bodySize;
        obj['seq'] = seq;
        obj['recipient'] = recipient;
        obj['domain'] = domain;
        obj['locked'] = locked;
        obj['lockTime'] = lockTime;
        obj['assigned'] = assigned;
        obj['queued'] = queued;
        obj['mxHostname'] = mxHostname;
        obj['response'] = response;
    }

    /**
     * Constructs a <code>MailLogEntry</code> from a plain JavaScript object, optionally creating a new instance.
     * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @param {module:model/MailLogEntry} obj Optional instance to populate.
     * @return {module:model/MailLogEntry} The populated <code>MailLogEntry</code> instance.
     */
    static constructFromObject(data, obj) {
        if (data) {
            obj = obj || new MailLogEntry();

            if (data.hasOwnProperty('_id')) {
                obj['_id'] = ApiClient.convertToType(data['_id'], 'Number');
            }
            if (data.hasOwnProperty('id')) {
                obj['id'] = ApiClient.convertToType(data['id'], 'String');
            }
            if (data.hasOwnProperty('from')) {
                obj['from'] = ApiClient.convertToType(data['from'], 'String');
            }
            if (data.hasOwnProperty('to')) {
                obj['to'] = ApiClient.convertToType(data['to'], 'String');
            }
            if (data.hasOwnProperty('subject')) {
                obj['subject'] = ApiClient.convertToType(data['subject'], 'String');
            }
            if (data.hasOwnProperty('created')) {
                obj['created'] = ApiClient.convertToType(data['created'], 'String');
            }
            if (data.hasOwnProperty('time')) {
                obj['time'] = ApiClient.convertToType(data['time'], 'Number');
            }
            if (data.hasOwnProperty('user')) {
                obj['user'] = ApiClient.convertToType(data['user'], 'String');
            }
            if (data.hasOwnProperty('transtype')) {
                obj['transtype'] = ApiClient.convertToType(data['transtype'], 'String');
            }
            if (data.hasOwnProperty('origin')) {
                obj['origin'] = ApiClient.convertToType(data['origin'], 'String');
            }
            if (data.hasOwnProperty('interface')) {
                obj['interface'] = ApiClient.convertToType(data['interface'], 'String');
            }
            if (data.hasOwnProperty('sendingZone')) {
                obj['sendingZone'] = ApiClient.convertToType(data['sendingZone'], 'String');
            }
            if (data.hasOwnProperty('bodySize')) {
                obj['bodySize'] = ApiClient.convertToType(data['bodySize'], 'Number');
            }
            if (data.hasOwnProperty('seq')) {
                obj['seq'] = ApiClient.convertToType(data['seq'], 'Number');
            }
            if (data.hasOwnProperty('recipient')) {
                obj['recipient'] = ApiClient.convertToType(data['recipient'], 'String');
            }
            if (data.hasOwnProperty('domain')) {
                obj['domain'] = ApiClient.convertToType(data['domain'], 'String');
            }
            if (data.hasOwnProperty('locked')) {
                obj['locked'] = ApiClient.convertToType(data['locked'], 'Number');
            }
            if (data.hasOwnProperty('lockTime')) {
                obj['lockTime'] = ApiClient.convertToType(data['lockTime'], 'String');
            }
            if (data.hasOwnProperty('assigned')) {
                obj['assigned'] = ApiClient.convertToType(data['assigned'], 'String');
            }
            if (data.hasOwnProperty('queued')) {
                obj['queued'] = ApiClient.convertToType(data['queued'], 'String');
            }
            if (data.hasOwnProperty('mxHostname')) {
                obj['mxHostname'] = ApiClient.convertToType(data['mxHostname'], 'String');
            }
            if (data.hasOwnProperty('response')) {
                obj['response'] = ApiClient.convertToType(data['response'], 'String');
            }
            if (data.hasOwnProperty('messageId')) {
                obj['messageId'] = ApiClient.convertToType(data['messageId'], 'String');
            }
        }
        return obj;
    }

    /**
     * Validates the JSON data with respect to <code>MailLogEntry</code>.
     * @param {Object} data The plain JavaScript object bearing properties of interest.
     * @return {boolean} to indicate whether the JSON data is valid with respect to <code>MailLogEntry</code>.
     */
    static validateJSON(data) {
        // check to make sure all required properties are present in the JSON string
        for (const property of MailLogEntry.RequiredProperties) {
            if (!data.hasOwnProperty(property)) {
                throw new Error("The required field `" + property + "` is not found in the JSON data: " + JSON.stringify(data));
            }
        }
        // ensure the json data is a string
        if (data['id'] && !(typeof data['id'] === 'string' || data['id'] instanceof String)) {
            throw new Error("Expected the field `id` to be a primitive type in the JSON string but got " + data['id']);
        }
        // ensure the json data is a string
        if (data['from'] && !(typeof data['from'] === 'string' || data['from'] instanceof String)) {
            throw new Error("Expected the field `from` to be a primitive type in the JSON string but got " + data['from']);
        }
        // ensure the json data is a string
        if (data['to'] && !(typeof data['to'] === 'string' || data['to'] instanceof String)) {
            throw new Error("Expected the field `to` to be a primitive type in the JSON string but got " + data['to']);
        }
        // ensure the json data is a string
        if (data['subject'] && !(typeof data['subject'] === 'string' || data['subject'] instanceof String)) {
            throw new Error("Expected the field `subject` to be a primitive type in the JSON string but got " + data['subject']);
        }
        // ensure the json data is a string
        if (data['created'] && !(typeof data['created'] === 'string' || data['created'] instanceof String)) {
            throw new Error("Expected the field `created` to be a primitive type in the JSON string but got " + data['created']);
        }
        // ensure the json data is a string
        if (data['user'] && !(typeof data['user'] === 'string' || data['user'] instanceof String)) {
            throw new Error("Expected the field `user` to be a primitive type in the JSON string but got " + data['user']);
        }
        // ensure the json data is a string
        if (data['transtype'] && !(typeof data['transtype'] === 'string' || data['transtype'] instanceof String)) {
            throw new Error("Expected the field `transtype` to be a primitive type in the JSON string but got " + data['transtype']);
        }
        // ensure the json data is a string
        if (data['origin'] && !(typeof data['origin'] === 'string' || data['origin'] instanceof String)) {
            throw new Error("Expected the field `origin` to be a primitive type in the JSON string but got " + data['origin']);
        }
        // ensure the json data is a string
        if (data['interface'] && !(typeof data['interface'] === 'string' || data['interface'] instanceof String)) {
            throw new Error("Expected the field `interface` to be a primitive type in the JSON string but got " + data['interface']);
        }
        // ensure the json data is a string
        if (data['sendingZone'] && !(typeof data['sendingZone'] === 'string' || data['sendingZone'] instanceof String)) {
            throw new Error("Expected the field `sendingZone` to be a primitive type in the JSON string but got " + data['sendingZone']);
        }
        // ensure the json data is a string
        if (data['recipient'] && !(typeof data['recipient'] === 'string' || data['recipient'] instanceof String)) {
            throw new Error("Expected the field `recipient` to be a primitive type in the JSON string but got " + data['recipient']);
        }
        // ensure the json data is a string
        if (data['domain'] && !(typeof data['domain'] === 'string' || data['domain'] instanceof String)) {
            throw new Error("Expected the field `domain` to be a primitive type in the JSON string but got " + data['domain']);
        }
        // ensure the json data is a string
        if (data['lockTime'] && !(typeof data['lockTime'] === 'string' || data['lockTime'] instanceof String)) {
            throw new Error("Expected the field `lockTime` to be a primitive type in the JSON string but got " + data['lockTime']);
        }
        // ensure the json data is a string
        if (data['assigned'] && !(typeof data['assigned'] === 'string' || data['assigned'] instanceof String)) {
            throw new Error("Expected the field `assigned` to be a primitive type in the JSON string but got " + data['assigned']);
        }
        // ensure the json data is a string
        if (data['queued'] && !(typeof data['queued'] === 'string' || data['queued'] instanceof String)) {
            throw new Error("Expected the field `queued` to be a primitive type in the JSON string but got " + data['queued']);
        }
        // ensure the json data is a string
        if (data['mxHostname'] && !(typeof data['mxHostname'] === 'string' || data['mxHostname'] instanceof String)) {
            throw new Error("Expected the field `mxHostname` to be a primitive type in the JSON string but got " + data['mxHostname']);
        }
        // ensure the json data is a string
        if (data['response'] && !(typeof data['response'] === 'string' || data['response'] instanceof String)) {
            throw new Error("Expected the field `response` to be a primitive type in the JSON string but got " + data['response']);
        }
        // ensure the json data is a string
        if (data['messageId'] && !(typeof data['messageId'] === 'string' || data['messageId'] instanceof String)) {
            throw new Error("Expected the field `messageId` to be a primitive type in the JSON string but got " + data['messageId']);
        }

        return true;
    }


}

MailLogEntry.RequiredProperties = ["_id", "id", "from", "to", "subject", "created", "time", "user", "transtype", "origin", "interface", "sendingZone", "bodySize", "seq", "recipient", "domain", "locked", "lockTime", "assigned", "queued", "mxHostname", "response"];

/**
 * internal db id
 * @member {Number} _id
 */
MailLogEntry.prototype['_id'] = undefined;

/**
 * mail id
 * @member {String} id
 */
MailLogEntry.prototype['id'] = undefined;

/**
 * from address
 * @member {String} from
 */
MailLogEntry.prototype['from'] = undefined;

/**
 * to address
 * @member {String} to
 */
MailLogEntry.prototype['to'] = undefined;

/**
 * email subject
 * @member {String} subject
 */
MailLogEntry.prototype['subject'] = undefined;

/**
 * creation date
 * @member {String} created
 */
MailLogEntry.prototype['created'] = undefined;

/**
 * creation timestamp
 * @member {Number} time
 */
MailLogEntry.prototype['time'] = undefined;

/**
 * user account
 * @member {String} user
 */
MailLogEntry.prototype['user'] = undefined;

/**
 * transaction type
 * @member {String} transtype
 */
MailLogEntry.prototype['transtype'] = undefined;

/**
 * origin ip
 * @member {String} origin
 */
MailLogEntry.prototype['origin'] = undefined;

/**
 * interface name
 * @member {String} interface
 */
MailLogEntry.prototype['interface'] = undefined;

/**
 * sending zone
 * @member {String} sendingZone
 */
MailLogEntry.prototype['sendingZone'] = undefined;

/**
 * email body size in bytes
 * @member {Number} bodySize
 */
MailLogEntry.prototype['bodySize'] = undefined;

/**
 * index of email in the to adderess list
 * @member {Number} seq
 */
MailLogEntry.prototype['seq'] = undefined;

/**
 * to address this email is being sent to
 * @member {String} recipient
 */
MailLogEntry.prototype['recipient'] = undefined;

/**
 * to address domain
 * @member {String} domain
 */
MailLogEntry.prototype['domain'] = undefined;

/**
 * locked status
 * @member {Number} locked
 */
MailLogEntry.prototype['locked'] = undefined;

/**
 * lock timestamp
 * @member {String} lockTime
 */
MailLogEntry.prototype['lockTime'] = undefined;

/**
 * assigned server
 * @member {String} assigned
 */
MailLogEntry.prototype['assigned'] = undefined;

/**
 * queued timestamp
 * @member {String} queued
 */
MailLogEntry.prototype['queued'] = undefined;

/**
 * mx hostname
 * @member {String} mxHostname
 */
MailLogEntry.prototype['mxHostname'] = undefined;

/**
 * mail delivery response
 * @member {String} response
 */
MailLogEntry.prototype['response'] = undefined;

/**
 * message id
 * @member {String} messageId
 */
MailLogEntry.prototype['messageId'] = undefined;






export default MailLogEntry;

