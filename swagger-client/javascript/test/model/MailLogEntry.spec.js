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
(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.MailBabyEmailDeliveryAndManagementServiceApi);
  }
}(this, function(expect, MailBabyEmailDeliveryAndManagementServiceApi) {
  'use strict';

  var instance;

  describe('(package)', function() {
    describe('MailLogEntry', function() {
      beforeEach(function() {
        instance = new MailBabyEmailDeliveryAndManagementServiceApi.MailLogEntry();
      });

      it('should create an instance of MailLogEntry', function() {
        // TODO: update the code to test MailLogEntry
        expect(instance).to.be.a(MailBabyEmailDeliveryAndManagementServiceApi.MailLogEntry);
      });

      it('should have the property id (base name: "_id")', function() {
        // TODO: update the code to test the property id
        expect(instance).to.have.property('id');
        // expect(instance.id).to.be(expectedValueLiteral);
      });

      it('should have the property id (base name: "id")', function() {
        // TODO: update the code to test the property id
        expect(instance).to.have.property('id');
        // expect(instance.id).to.be(expectedValueLiteral);
      });

      it('should have the property from (base name: "from")', function() {
        // TODO: update the code to test the property from
        expect(instance).to.have.property('from');
        // expect(instance.from).to.be(expectedValueLiteral);
      });

      it('should have the property to (base name: "to")', function() {
        // TODO: update the code to test the property to
        expect(instance).to.have.property('to');
        // expect(instance.to).to.be(expectedValueLiteral);
      });

      it('should have the property subject (base name: "subject")', function() {
        // TODO: update the code to test the property subject
        expect(instance).to.have.property('subject');
        // expect(instance.subject).to.be(expectedValueLiteral);
      });

      it('should have the property messageId (base name: "messageId")', function() {
        // TODO: update the code to test the property messageId
        expect(instance).to.have.property('messageId');
        // expect(instance.messageId).to.be(expectedValueLiteral);
      });

      it('should have the property created (base name: "created")', function() {
        // TODO: update the code to test the property created
        expect(instance).to.have.property('created');
        // expect(instance.created).to.be(expectedValueLiteral);
      });

      it('should have the property time (base name: "time")', function() {
        // TODO: update the code to test the property time
        expect(instance).to.have.property('time');
        // expect(instance.time).to.be(expectedValueLiteral);
      });

      it('should have the property user (base name: "user")', function() {
        // TODO: update the code to test the property user
        expect(instance).to.have.property('user');
        // expect(instance.user).to.be(expectedValueLiteral);
      });

      it('should have the property transtype (base name: "transtype")', function() {
        // TODO: update the code to test the property transtype
        expect(instance).to.have.property('transtype');
        // expect(instance.transtype).to.be(expectedValueLiteral);
      });

      it('should have the property origin (base name: "origin")', function() {
        // TODO: update the code to test the property origin
        expect(instance).to.have.property('origin');
        // expect(instance.origin).to.be(expectedValueLiteral);
      });

      it('should have the property _interface (base name: "interface")', function() {
        // TODO: update the code to test the property _interface
        expect(instance).to.have.property('_interface');
        // expect(instance._interface).to.be(expectedValueLiteral);
      });

      it('should have the property sendingZone (base name: "sendingZone")', function() {
        // TODO: update the code to test the property sendingZone
        expect(instance).to.have.property('sendingZone');
        // expect(instance.sendingZone).to.be(expectedValueLiteral);
      });

      it('should have the property bodySize (base name: "bodySize")', function() {
        // TODO: update the code to test the property bodySize
        expect(instance).to.have.property('bodySize');
        // expect(instance.bodySize).to.be(expectedValueLiteral);
      });

      it('should have the property seq (base name: "seq")', function() {
        // TODO: update the code to test the property seq
        expect(instance).to.have.property('seq');
        // expect(instance.seq).to.be(expectedValueLiteral);
      });

      it('should have the property recipient (base name: "recipient")', function() {
        // TODO: update the code to test the property recipient
        expect(instance).to.have.property('recipient');
        // expect(instance.recipient).to.be(expectedValueLiteral);
      });

      it('should have the property domain (base name: "domain")', function() {
        // TODO: update the code to test the property domain
        expect(instance).to.have.property('domain');
        // expect(instance.domain).to.be(expectedValueLiteral);
      });

      it('should have the property locked (base name: "locked")', function() {
        // TODO: update the code to test the property locked
        expect(instance).to.have.property('locked');
        // expect(instance.locked).to.be(expectedValueLiteral);
      });

      it('should have the property lockTime (base name: "lockTime")', function() {
        // TODO: update the code to test the property lockTime
        expect(instance).to.have.property('lockTime');
        // expect(instance.lockTime).to.be(expectedValueLiteral);
      });

      it('should have the property assigned (base name: "assigned")', function() {
        // TODO: update the code to test the property assigned
        expect(instance).to.have.property('assigned');
        // expect(instance.assigned).to.be(expectedValueLiteral);
      });

      it('should have the property queued (base name: "queued")', function() {
        // TODO: update the code to test the property queued
        expect(instance).to.have.property('queued');
        // expect(instance.queued).to.be(expectedValueLiteral);
      });

      it('should have the property mxHostname (base name: "mxHostname")', function() {
        // TODO: update the code to test the property mxHostname
        expect(instance).to.have.property('mxHostname');
        // expect(instance.mxHostname).to.be(expectedValueLiteral);
      });

      it('should have the property response (base name: "response")', function() {
        // TODO: update the code to test the property response
        expect(instance).to.have.property('response');
        // expect(instance.response).to.be(expectedValueLiteral);
      });

    });
  });

}));