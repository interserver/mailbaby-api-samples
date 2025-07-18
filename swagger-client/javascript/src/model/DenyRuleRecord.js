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
 * Swagger Codegen version: 3.0.71
 *
 * Do not edit the class manually.
 *
 */
import ApiClient from '../ApiClient';
import DenyRuleNew from './DenyRuleNew';

/**
 * The DenyRuleRecord model module.
 * @module model/DenyRuleRecord
 * @version 1.1.0
 */
export default class DenyRuleRecord {
  /**
   * Constructs a new <code>DenyRuleRecord</code>.
   * The data for a email deny rule record.
   * @alias module:model/DenyRuleRecord
   * @class
   * @param id {} The deny rule Id number.
   * @param created {} the date the rule was created.
   * @param type {} The type of deny rule.
   * @param data {} The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
   */
  constructor(id, created, type, data) {
    this.type = type;
    this.data = data;
  }

  /**
   * Constructs a <code>DenyRuleRecord</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/DenyRuleRecord} obj Optional instance to populate.
   * @return {module:model/DenyRuleRecord} The populated <code>DenyRuleRecord</code> instance.
   */
  static constructFromObject(data, obj) {
    if (data) {
      obj = obj || new DenyRuleRecord();
      if (data.hasOwnProperty('user'))
        obj.user = ApiClient.convertToType(data['user'], 'String');
      if (data.hasOwnProperty('type'))
        obj.type = ApiClient.convertToType(data['type'], 'String');
      if (data.hasOwnProperty('data'))
        obj.data = ApiClient.convertToType(data['data'], 'String');
    }
    return obj;
  }
}

/**
 * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
 * @member {String} user
 */
DenyRuleRecord.prototype.user = undefined;

/**
 * Allowed values for the <code>type</code> property.
 * @enum {String}
 * @readonly
 */
DenyRuleRecord.TypeEnum = {
  /**
   * value: "domain"
   * @const
   */
  domain: "domain",

  /**
   * value: "email"
   * @const
   */
  email: "email",

  /**
   * value: "startswith"
   * @const
   */
  startswith: "startswith",

  /**
   * value: "destination"
   * @const
   */
  destination: "destination"
};
/**
 * The type of deny rule.
 * @member {module:model/DenyRuleRecord.TypeEnum} type
 */
DenyRuleRecord.prototype.type = undefined;

/**
 * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
 * @member {String} data
 */
DenyRuleRecord.prototype.data = undefined;

