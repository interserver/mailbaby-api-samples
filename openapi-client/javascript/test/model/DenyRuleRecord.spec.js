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

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', process.cwd()+'/src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require(process.cwd()+'/src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.MailBabyEmailDeliveryAndManagementServiceApi);
  }
}(this, function(expect, MailBabyEmailDeliveryAndManagementServiceApi) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('DenyRuleRecord', function() {
    it('should create an instance of DenyRuleRecord', function() {
      // uncomment below and update the code to test DenyRuleRecord
      //var instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
      //expect(instance).to.be.a(MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord);
    });

    it('should have the property type (base name: "type")', function() {
      // uncomment below and update the code to test the property type
      //var instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
      //expect(instance).to.be();
    });

    it('should have the property data (base name: "data")', function() {
      // uncomment below and update the code to test the property data
      //var instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
      //expect(instance).to.be();
    });

    it('should have the property id (base name: "id")', function() {
      // uncomment below and update the code to test the property id
      //var instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
      //expect(instance).to.be();
    });

    it('should have the property created (base name: "created")', function() {
      // uncomment below and update the code to test the property created
      //var instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
      //expect(instance).to.be();
    });

    it('should have the property user (base name: "user")', function() {
      // uncomment below and update the code to test the property user
      //var instance = new MailBabyEmailDeliveryAndManagementServiceApi.DenyRuleRecord();
      //expect(instance).to.be();
    });

  });

}));
