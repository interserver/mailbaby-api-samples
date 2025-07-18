/**
 * @fileoverview AUTOMATICALLY GENERATED service for API.Client.SendingApi.
 * Do not edit this file by hand or your changes will be lost next time it is
 * generated.
 *
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 * Version: 1.1.0
* Generator version: 7.14.0-SNAPSHOT
 * Generated by: org.openapitools.codegen.languages.JavascriptClosureAngularClientCodegen
 */
/**
 * @license GNU GPLv3
 * https://www.gnu.org/licenses/gpl.txt
 */

goog.provide('API.Client.SendingApi');

goog.require('API.Client.EmailAddressTypes');
goog.require('API.Client.EmailAddressesTypes');
goog.require('API.Client.ErrorMessage');
goog.require('API.Client.GenericResponse');
goog.require('API.Client.MailAttachment');

/**
 * @constructor
 * @param {!angular.$http} $http
 * @param {!Object} $httpParamSerializer
 * @param {!angular.$injector} $injector
 * @struct
 */
API.Client.SendingApi = function($http, $httpParamSerializer, $injector) {
  /** @private {!string} */
  this.basePath_ = $injector.has('SendingApiBasePath') ?
                   /** @type {!string} */ ($injector.get('SendingApiBasePath')) :
                   'https://api.mailbaby.net';

  /** @private {!Object<string, string>} */
  this.defaultHeaders_ = $injector.has('SendingApiDefaultHeaders') ?
                   /** @type {!Object<string, string>} */ (
                       $injector.get('SendingApiDefaultHeaders')) :
                   {};

  /** @private {!angular.$http} */
  this.http_ = $http;

  /** @package {!Object} */
  this.httpParamSerializer = $injector.get('$httpParamSerializer');
}
API.Client.SendingApi.$inject = ['$http', '$httpParamSerializer', '$injector'];

/**
 * Sends an Email with Advanced Options
 * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#39; &#x60;&#x60;&#x60; 
 * @param {!string} subject The subject or title of the email
 * @param {!string} body The main email contents.
 * @param {!API.Client.EmailAddressTypes} from 
 * @param {!API.Client.EmailAddressesTypes} to 
 * @param {!API.Client.EmailAddressesTypes=} opt_replyto 
 * @param {!API.Client.EmailAddressesTypes=} opt_cc 
 * @param {!API.Client.EmailAddressesTypes=} opt_bcc 
 * @param {!Array<!API.Client.MailAttachment>=} opt_attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
 * @param {!number=} opt_id (optional)  ID of the Mail order within our system to use as the Mail Account.
 * @param {!angular.$http.Config=} opt_extraHttpRequestParams Extra HTTP parameters to send.
 * @return {!angular.$q.Promise<!API.Client.GenericResponse>}
 */
API.Client.SendingApi.prototype.sendAdvMail = function(subject, body, from, to, opt_replyto, opt_cc, opt_bcc, opt_attachments, opt_id, opt_extraHttpRequestParams) {
  /** @const {string} */
  var path = this.basePath_ + '/mail/advsend';

  /** @type {!Object} */
  var queryParameters = {};

  /** @type {!Object} */
  var headerParams = angular.extend({}, this.defaultHeaders_);
  /** @type {!Object} */
  var formParams = {};

  // verify required parameter 'subject' is set
  if (!subject) {
    throw new Error('Missing required parameter subject when calling sendAdvMail');
  }
  // verify required parameter 'body' is set
  if (!body) {
    throw new Error('Missing required parameter body when calling sendAdvMail');
  }
  // verify required parameter 'from' is set
  if (!from) {
    throw new Error('Missing required parameter from when calling sendAdvMail');
  }
  // verify required parameter 'to' is set
  if (!to) {
    throw new Error('Missing required parameter to when calling sendAdvMail');
  }
  headerParams['Content-Type'] = 'application/x-www-form-urlencoded';

  formParams['subject'] = subject;

  formParams['body'] = body;

  formParams['from'] = from;

  formParams['to'] = to;

  formParams['replyto'] = opt_replyto;

  formParams['cc'] = opt_cc;

  formParams['bcc'] = opt_bcc;

  formParams['attachments'] = opt_attachments;

  formParams['id'] = opt_id;

  /** @type {!Object} */
  var httpRequestParams = {
    method: 'POST',
    url: path,
    json: false,
        data: this.httpParamSerializer(formParams),
    params: queryParameters,
    headers: headerParams
  };

  if (opt_extraHttpRequestParams) {
    httpRequestParams = angular.extend(httpRequestParams, opt_extraHttpRequestParams);
  }

  return (/** @type {?} */ (this.http_))(httpRequestParams);
}

/**
 * Sends an Email
 * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
 * @param {!string} to The Contact whom is the primary recipient of this email.
 * @param {!string} from The contact whom is the this email is from.
 * @param {!string} subject The subject or title of the email
 * @param {!string} body The main email contents.
 * @param {!angular.$http.Config=} opt_extraHttpRequestParams Extra HTTP parameters to send.
 * @return {!angular.$q.Promise<!API.Client.GenericResponse>}
 */
API.Client.SendingApi.prototype.sendMail = function(to, from, subject, body, opt_extraHttpRequestParams) {
  /** @const {string} */
  var path = this.basePath_ + '/mail/send';

  /** @type {!Object} */
  var queryParameters = {};

  /** @type {!Object} */
  var headerParams = angular.extend({}, this.defaultHeaders_);
  /** @type {!Object} */
  var formParams = {};

  // verify required parameter 'to' is set
  if (!to) {
    throw new Error('Missing required parameter to when calling sendMail');
  }
  // verify required parameter 'from' is set
  if (!from) {
    throw new Error('Missing required parameter from when calling sendMail');
  }
  // verify required parameter 'subject' is set
  if (!subject) {
    throw new Error('Missing required parameter subject when calling sendMail');
  }
  // verify required parameter 'body' is set
  if (!body) {
    throw new Error('Missing required parameter body when calling sendMail');
  }
  headerParams['Content-Type'] = 'application/x-www-form-urlencoded';

  formParams['to'] = to;

  formParams['from'] = from;

  formParams['subject'] = subject;

  formParams['body'] = body;

  /** @type {!Object} */
  var httpRequestParams = {
    method: 'POST',
    url: path,
    json: false,
        data: this.httpParamSerializer(formParams),
    params: queryParameters,
    headers: headerParams
  };

  if (opt_extraHttpRequestParams) {
    httpRequestParams = angular.extend(httpRequestParams, opt_extraHttpRequestParams);
  }

  return (/** @type {?} */ (this.http_))(httpRequestParams);
}
