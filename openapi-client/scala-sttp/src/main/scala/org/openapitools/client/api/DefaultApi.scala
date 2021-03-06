/**
 * MailBaby Email Delivery API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.client.api

import org.openapitools.client.model.GenericResponse
import org.openapitools.client.model.GetMailOrders200ResponseInner
import org.openapitools.client.model.GetMailOrders401Response
import org.openapitools.client.model.MailLog
import org.openapitools.client.model.SendMailAdv
import org.openapitools.client.core.JsonSupport._
import sttp.client3._
import sttp.model.Method

object DefaultApi {

def apply(baseUrl: String = "https://api.mailbaby.net") = new DefaultApi(baseUrl)
}

class DefaultApi(baseUrl: String) {

  /**
   * Expected answers:
   *   code 200 : Seq[GetMailOrders200ResponseInner] (OK)
   *   code 401 : GetMailOrders401Response (Unauthorized)
   *   code 404 : GetMailOrders401Response (Unauthorized)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   */
  def getMailOrders(apiKey: String)(
): Request[Either[ResponseException[String, Exception], Seq[GetMailOrders200ResponseInner]], Nothing] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mail")
      .contentType("application/json")
      .header("X-API-KEY", apiKey)
      .response(asJson[Seq[GetMailOrders200ResponseInner]])

  /**
   * Expected answers:
   *   code 200 :  (Server is up and running)
   *   code 0 :  (Something is wrong)
   */
  def pingServer(
): Request[Either[ResponseException[String, Exception], Unit], Nothing] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/ping")
      .contentType("application/json")
      .response(asJson[Unit])

  /**
   * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
   * 
   * Expected answers:
   *   code 200 : GenericResponse (search results matching criteria)
   *   code 400 : GetMailOrders401Response (The specified resource was not found)
   *   code 401 : GetMailOrders401Response (Unauthorized)
   *   code 404 : GetMailOrders401Response (The specified resource was not found)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   * 
   * @param sendMailAdv 
   */
  def sendAdvMail(apiKey: String)(sendMailAdv: SendMailAdv
): Request[Either[ResponseException[String, Exception], GenericResponse], Nothing] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/mail/advsend")
      .contentType("application/json")
      .header("X-API-KEY", apiKey)
      .body(sendMailAdv)
      .response(asJson[GenericResponse])

  /**
   * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
   * 
   * Expected answers:
   *   code 200 : GenericResponse (search results matching criteria)
   *   code 400 : GetMailOrders401Response (The specified resource was not found)
   *   code 401 : GetMailOrders401Response (Unauthorized)
   *   code 404 : GetMailOrders401Response (The specified resource was not found)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   * 
   * @param to The Contact whom is the primary recipient of this email.
   * @param from The contact whom is the this email is from.
   * @param subject The subject or title of the email
   * @param body The main email contents.
   */
  def sendMail(apiKey: String)(to: String, from: String, subject: String, body: String
): Request[Either[ResponseException[String, Exception], GenericResponse], Nothing] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/mail/send")
      .contentType("application/x-www-form-urlencoded")
      .header("X-API-KEY", apiKey)
      .body(Map(
        "to" -> to,
        "from" -> from,
        "subject" -> subject,
        "body" -> body
      ))
      .response(asJson[GenericResponse])

  /**
   * By passing in the appropriate options, you can search for available inventory in the system 
   * 
   * Expected answers:
   *   code 200 : MailLog (search results matching criteria)
   *   code 400 :  (bad input parameter)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   * 
   * @param id The ID of your mail order this will be sent through.
   * @param search pass an optional search string for looking up inventory
   * @param skip number of records to skip for pagination
   * @param limit maximum number of records to return
   */
  def viewMailLog(apiKey: String)(id: Option[Long] = None, search: Option[String] = None, skip: Option[Int] = None, limit: Option[Int] = None
): Request[Either[ResponseException[String, Exception], MailLog], Nothing] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/mail/log?id=${ id }&search=${ search }&skip=${ skip }&limit=${ limit }")
      .contentType("application/json")
      .header("X-API-KEY", apiKey)
      .response(asJson[MailLog])

}
