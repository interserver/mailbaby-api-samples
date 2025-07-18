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

import org.openapitools.client.model.EmailAddressTypes
import org.openapitools.client.model.EmailAddressesTypes
import org.openapitools.client.model.ErrorMessage
import org.openapitools.client.model.GenericResponse
import org.openapitools.client.model.MailAttachment
import org.openapitools.client.core.JsonSupport._
import sttp.client4._
import sttp.model.Method

object SendingApi {
  def apply(baseUrl: String = "https://api.mailbaby.net") = new SendingApi(baseUrl)
}

class SendingApi(baseUrl: String) {

  /**
   * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/x-www-form-urlencoded' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data 'subject=Welcome' \\ --data 'body=Hello' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header 'Accept: application/json' \\ --header 'Content-Type: application/json' \\ --header 'X-API-KEY: YOUR_API_KEY' \\ --data '{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }' ``` 
   * 
   * Expected answers:
   *   code 200 : GenericResponse (search results matching criteria)
   *   code 400 : ErrorMessage (Error message when there was a problem with the input parameters.)
   *   code 401 : ErrorMessage (Unauthorized)
   *   code 404 : ErrorMessage (The specified resource was not found)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   * 
   * @param subject The subject or title of the email
   * @param body The main email contents.
   * @param from 
   * @param to 
   * @param replyto 
   * @param cc 
   * @param bcc 
   * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
   * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
   */
  def sendAdvMail(apiKey: String)(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: Option[EmailAddressesTypes] = None, cc: Option[EmailAddressesTypes] = None, bcc: Option[EmailAddressesTypes] = None, attachments: Seq[MailAttachment], id: Option[Long] = None): Request[Either[ResponseException[String, Exception], GenericResponse]] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/mail/advsend")
      .contentType("application/x-www-form-urlencoded")
      .header("X-API-KEY", apiKey)
      .body(Map(
        "subject" -> subject,
        "body" -> body,
        "from" -> from,
        "to" -> to,
        "replyto" -> replyto,
        "cc" -> cc,
        "bcc" -> bcc,
        "attachments" -> ArrayValues(attachments, CSV),
        "id" -> id
      ))
      .response(asJson[GenericResponse])

  /**
   * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
   * 
   * Expected answers:
   *   code 200 : GenericResponse (search results matching criteria)
   *   code 400 : ErrorMessage (Error message when there was a problem with the input parameters.)
   *   code 401 : ErrorMessage (Unauthorized)
   *   code 404 : ErrorMessage (The specified resource was not found)
   * 
   * Available security schemes:
   *   apiKeyAuth (apiKey)
   * 
   * @param to The Contact whom is the primary recipient of this email.
   * @param from The contact whom is the this email is from.
   * @param subject The subject or title of the email
   * @param body The main email contents.
   */
  def sendMail(apiKey: String)(to: String, from: String, subject: String, body: String): Request[Either[ResponseException[String, Exception], GenericResponse]] =
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

}
