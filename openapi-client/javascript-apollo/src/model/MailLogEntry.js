/**
 * MailBaby Email Delivery API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.  We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
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
     * @member {Number} _id
     * @type {Number}
     */
    _id;
    /**
     * @member {String} id
     * @type {String}
     */
    id;
    /**
     * @member {String} from
     * @type {String}
     */
    from;
    /**
     * @member {String} to
     * @type {String}
     */
    to;
    /**
     * @member {String} subject
     * @type {String}
     */
    subject;
    /**
     * @member {String} created
     * @type {String}
     */
    created;
    /**
     * @member {Number} time
     * @type {Number}
     */
    time;
    /**
     * @member {String} user
     * @type {String}
     */
    user;
    /**
     * @member {String} transtype
     * @type {String}
     */
    transtype;
    /**
     * @member {String} origin
     * @type {String}
     */
    origin;
    /**
     * @member {String} interface
     * @type {String}
     */
    interface;
    /**
     * @member {String} sendingZone
     * @type {String}
     */
    sendingZone;
    /**
     * @member {Number} bodySize
     * @type {Number}
     */
    bodySize;
    /**
     * @member {Number} seq
     * @type {Number}
     */
    seq;
    /**
     * @member {String} recipient
     * @type {String}
     */
    recipient;
    /**
     * @member {String} domain
     * @type {String}
     */
    domain;
    /**
     * @member {Number} locked
     * @type {Number}
     */
    locked;
    /**
     * @member {Number} lockTime
     * @type {Number}
     */
    lockTime;
    /**
     * @member {String} assigned
     * @type {String}
     */
    assigned;
    /**
     * @member {String} queued
     * @type {String}
     */
    queued;
    /**
     * @member {String} mxHostname
     * @type {String}
     */
    mxHostname;
    /**
     * @member {String} response
     * @type {String}
     */
    response;
    /**
     * @member {String} messageId
     * @type {String}
     */
    messageId;

    

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
     * @param lockTime {Number} lock timestamp
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
                obj['lockTime'] = ApiClient.convertToType(data['lockTime'], 'Number');
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
}



export default MailLogEntry;

