/*
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 3.0.46
 *
 * Do not edit the class manually.
 *
 */
import {ApiClient} from '../ApiClient';

/**
 * The MailAttachment model module.
 * @module model/MailAttachment
 * @version 1.1.0
 */
export class MailAttachment {
  /**
   * Constructs a new <code>MailAttachment</code>.
   * (optional) File attachments to include in the email.  The file contents must be base64
   * @alias module:model/MailAttachment
   * @class
   * @param filename {String} The filename of the attached file.
   * @param data {String} The file contents base64 encoded
   */
  constructor(filename, data) {
    this.filename = filename;
    this.data = data;
  }

  /**
   * Constructs a <code>MailAttachment</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/MailAttachment} obj Optional instance to populate.
   * @return {module:model/MailAttachment} The populated <code>MailAttachment</code> instance.
   */
  static constructFromObject(data, obj) {
    if (data) {
      obj = obj || new MailAttachment();
      if (data.hasOwnProperty('filename'))
        obj.filename = ApiClient.convertToType(data['filename'], 'String');
      if (data.hasOwnProperty('data'))
        obj.data = ApiClient.convertToType(data['data'], 'String');
    }
    return obj;
  }
}

/**
 * The filename of the attached file.
 * @member {String} filename
 */
MailAttachment.prototype.filename = undefined;

/**
 * The file contents base64 encoded
 * @member {String} data
 */
MailAttachment.prototype.data = undefined;
