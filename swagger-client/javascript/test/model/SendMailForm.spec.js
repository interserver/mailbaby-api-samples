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
(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.MailBabyApi);
  }
}(this, function(expect, MailBabyApi) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new MailBabyApi.SendMailForm();
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

  describe('SendMailForm', function() {
    it('should create an instance of SendMailForm', function() {
      // uncomment below and update the code to test SendMailForm
      //var instane = new MailBabyApi.SendMailForm();
      //expect(instance).to.be.a(MailBabyApi.SendMailForm);
    });

    it('should have the property id (base name: "id")', function() {
      // uncomment below and update the code to test the property id
      //var instane = new MailBabyApi.SendMailForm();
      //expect(instance).to.be();
    });

  });

}));