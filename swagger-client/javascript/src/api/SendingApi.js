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
import {ApiClient} from "../ApiClient";
import {EmailAddressName} from '../model/EmailAddressName';
import {GenericResponse} from '../model/GenericResponse';
import {InlineResponse401} from '../model/InlineResponse401';
import {MailAttachment} from '../model/MailAttachment';
import {SendMail} from '../model/SendMail';
import {SendMailAdv} from '../model/SendMailAdv';

/**
* Sending service.
* @module api/SendingApi
* @version 1.1.0
*/
export class SendingApi {

    /**
    * Constructs a new SendingApi. 
    * @alias module:api/SendingApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instanc
    e} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }

    /**
     * Callback function to receive the result of the sendAdvMail operation.
     * @callback moduleapi/SendingApi~sendAdvMailCallback
     * @param {String} error Error message, if any.
     * @param {module:model/GenericResponse{ data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * @param {String} subject 
     * @param {String} body 
     * @param {module:model/EmailAddressName} from 
     * @param {Array.<module:model/EmailAddressName>} to 
     * @param {Array.<module:model/EmailAddressName>} replyto 
     * @param {Array.<module:model/EmailAddressName>} cc 
     * @param {Array.<module:model/EmailAddressName>} bcc 
     * @param {Array.<module:model/MailAttachment>} attachments 
     * @param {Number} id 
     * @param {module:model/SendMailAdv} body 
     * @param {module:api/SendingApi~sendAdvMailCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link <&vendorExtensions.x-jsdoc-type>}
     */
    sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id, body, callback) {
      
      let postBody = body;
      // verify the required parameter 'subject' is set
      if (subject === undefined || subject === null) {
        throw new Error("Missing the required parameter 'subject' when calling sendAdvMail");
      }
      // verify the required parameter 'body' is set
      if (body === undefined || body === null) {
        throw new Error("Missing the required parameter 'body' when calling sendAdvMail");
      }
      // verify the required parameter 'from' is set
      if (from === undefined || from === null) {
        throw new Error("Missing the required parameter 'from' when calling sendAdvMail");
      }
      // verify the required parameter 'to' is set
      if (to === undefined || to === null) {
        throw new Error("Missing the required parameter 'to' when calling sendAdvMail");
      }
      // verify the required parameter 'replyto' is set
      if (replyto === undefined || replyto === null) {
        throw new Error("Missing the required parameter 'replyto' when calling sendAdvMail");
      }
      // verify the required parameter 'cc' is set
      if (cc === undefined || cc === null) {
        throw new Error("Missing the required parameter 'cc' when calling sendAdvMail");
      }
      // verify the required parameter 'bcc' is set
      if (bcc === undefined || bcc === null) {
        throw new Error("Missing the required parameter 'bcc' when calling sendAdvMail");
      }
      // verify the required parameter 'attachments' is set
      if (attachments === undefined || attachments === null) {
        throw new Error("Missing the required parameter 'attachments' when calling sendAdvMail");
      }
      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling sendAdvMail");
      }
      // verify the required parameter 'body' is set
      if (body === undefined || body === null) {
        throw new Error("Missing the required parameter 'body' when calling sendAdvMail");
      }

      let pathParams = {
        
      };
      let queryParams = {
        
      };
      let headerParams = {
        
      };
      let formParams = {
        'subject': subject,'body': body,'from': from,'to': this.apiClient.buildCollectionParam(to, 'multi'),'replyto': this.apiClient.buildCollectionParam(replyto, 'multi'),'cc': this.apiClient.buildCollectionParam(cc, 'multi'),'bcc': this.apiClient.buildCollectionParam(bcc, 'multi'),'attachments': this.apiClient.buildCollectionParam(attachments, 'multi'),'id': id
      };

      let authNames = ['apiKeyAuth'];
      let contentTypes = ['application/x-www-form-urlencoded', 'application/json'];
      let accepts = ['application/json'];
      let returnType = GenericResponse;

      return this.apiClient.callApi(
        '/mail/advsend', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the sendMail operation.
     * @callback moduleapi/SendingApi~sendMailCallback
     * @param {String} error Error message, if any.
     * @param {module:model/GenericResponse{ data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Sends an Email
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @param {String} to 
     * @param {String} from 
     * @param {String} subject 
     * @param {String} body 
     * @param {module:model/SendMail} body 
     * @param {module:api/SendingApi~sendMailCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link <&vendorExtensions.x-jsdoc-type>}
     */
    sendMail(to, from, subject, body, body, callback) {
      
      let postBody = body;
      // verify the required parameter 'to' is set
      if (to === undefined || to === null) {
        throw new Error("Missing the required parameter 'to' when calling sendMail");
      }
      // verify the required parameter 'from' is set
      if (from === undefined || from === null) {
        throw new Error("Missing the required parameter 'from' when calling sendMail");
      }
      // verify the required parameter 'subject' is set
      if (subject === undefined || subject === null) {
        throw new Error("Missing the required parameter 'subject' when calling sendMail");
      }
      // verify the required parameter 'body' is set
      if (body === undefined || body === null) {
        throw new Error("Missing the required parameter 'body' when calling sendMail");
      }
      // verify the required parameter 'body' is set
      if (body === undefined || body === null) {
        throw new Error("Missing the required parameter 'body' when calling sendMail");
      }

      let pathParams = {
        
      };
      let queryParams = {
        
      };
      let headerParams = {
        
      };
      let formParams = {
        'to': to,'from': from,'subject': subject,'body': body
      };

      let authNames = ['apiKeyAuth'];
      let contentTypes = ['application/x-www-form-urlencoded', 'application/json'];
      let accepts = ['application/json'];
      let returnType = GenericResponse;

      return this.apiClient.callApi(
        '/mail/send', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

}