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
import ApiClient from "../ApiClient";
import ErrorMessage from '../model/ErrorMessage';
import MailLog from '../model/MailLog';
import MailStatsType from '../model/MailStatsType';

/**
* History service.
* @module api/HistoryApi
* @version 1.1.0
*/
export default class HistoryApi {

    /**
    * Constructs a new HistoryApi. 
    * @alias module:api/HistoryApi
    * @class
    * @param {module:ApiClient} [apiClient] Optional API client implementation to use,
    * default to {@link module:ApiClient#instanc
    e} if unspecified.
    */
    constructor(apiClient) {
        this.apiClient = apiClient || ApiClient.instance;
    }

    /**
     * Callback function to receive the result of the getStats operation.
     * @callback moduleapi/HistoryApi~getStatsCallback
     * @param {String} error Error message, if any.
     * @param {module:model/MailStatsType{ data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Account usage statistics.
     * Returns information about the usage on your mail accounts.
     * @param {Object} opts Optional parameters
     * @param {module:model/String} opts.time The timeframe for the statistics.
     * @param {module:api/HistoryApi~getStatsCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link <&vendorExtensions.x-jsdoc-type>}
     */
    getStats(opts, callback) {
      opts = opts || {};
      let postBody = null;

      let pathParams = {
        
      };
      let queryParams = {
        'time': opts['time']
      };
      let headerParams = {
        
      };
      let formParams = {
        
      };

      let authNames = ['apiKeyAuth'];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = MailStatsType;

      return this.apiClient.callApi(
        '/mail/stats', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
    /**
     * Callback function to receive the result of the viewMailLog operation.
     * @callback moduleapi/HistoryApi~viewMailLogCallback
     * @param {String} error Error message, if any.
     * @param {module:model/MailLog{ data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * displays the mail log
     * Get a listing of the emails sent through this system 
     * @param {Object} opts Optional parameters
     * @param {Number} opts.id The ID of your mail order this will be sent through.
     * @param {String} opts.origin originating ip address sending mail
     * @param {String} opts.mx mx record mail was sent to
     * @param {String} opts.from from email address
     * @param {String} opts.to to/destination email address
     * @param {String} opts.subject subject containing this string
     * @param {String} opts.mailid mail id
     * @param {Number} opts.skip number of records to skip for pagination (default to <.>)
     * @param {Number} opts.limit maximum number of records to return (default to <.>)
     * @param {Number} opts.startDate earliest date to get emails in unix timestamp format
     * @param {Number} opts.endDate earliest date to get emails in unix timestamp format
     * @param {String} opts.replyto Reply-To Email Address
     * @param {String} opts.headerfrom Header From Email Address
     * @param {module:model/String} opts.delivered Limiting the emails to wether or not they were delivered.
     * @param {module:api/HistoryApi~viewMailLogCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link <&vendorExtensions.x-jsdoc-type>}
     */
    viewMailLog(opts, callback) {
      opts = opts || {};
      let postBody = null;

      let pathParams = {
        
      };
      let queryParams = {
        'id': opts['id'],'origin': opts['origin'],'mx': opts['mx'],'from': opts['from'],'to': opts['to'],'subject': opts['subject'],'mailid': opts['mailid'],'skip': opts['skip'],'limit': opts['limit'],'startDate': opts['startDate'],'endDate': opts['endDate'],'replyto': opts['replyto'],'headerfrom': opts['headerfrom'],'delivered': opts['delivered']
      };
      let headerParams = {
        
      };
      let formParams = {
        
      };

      let authNames = ['apiKeyAuth'];
      let contentTypes = [];
      let accepts = ['application/json'];
      let returnType = MailLog;

      return this.apiClient.callApi(
        '/mail/log', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

}