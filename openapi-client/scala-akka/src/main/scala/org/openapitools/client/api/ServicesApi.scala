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
 */
package org.openapitools.client.api

import org.openapitools.client.model.ErrorMessage
import org.openapitools.client.model.MailOrder
import org.openapitools.client.core._
import org.openapitools.client.core.CollectionFormats._
import org.openapitools.client.core.ApiKeyLocations._

object ServicesApi {

  def apply(baseUrl: String = "https://api.mailbaby.net") = new ServicesApi(baseUrl)
}

class ServicesApi(baseUrl: String) {

  /**
   * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
   * 
   * Expected answers:
   *   code 200 : Seq[MailOrder] (OK)
   *   code 401 : ErrorMessage (Unauthorized)
   *   code 404 : ErrorMessage (Unauthorized)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   */
  def getMailOrders()(implicit apiKey: ApiKeyValue): ApiRequest[Seq[MailOrder]] =
    ApiRequest[Seq[MailOrder]](ApiMethods.GET, baseUrl, "/mail", "application/json")
      .withApiKey(apiKey, "X-API-KEY", HEADER)
      .withSuccessResponse[Seq[MailOrder]](200)
      .withErrorResponse[ErrorMessage](401)
      .withErrorResponse[ErrorMessage](404)
      



}

