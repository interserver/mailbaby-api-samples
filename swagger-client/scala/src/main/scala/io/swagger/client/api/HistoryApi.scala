/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package io.swagger.client.api

import java.text.SimpleDateFormat

import io.swagger.client.model.ErrorMessage
import io.swagger.client.model.MailLog
import io.swagger.client.model.MailStatsType
import io.swagger.client.{ApiInvoker, ApiException}

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date
import java.util.TimeZone

import scala.collection.mutable.HashMap

import com.wordnik.swagger.client._
import scala.concurrent.Future
import collection.mutable

import java.net.URI

import com.wordnik.swagger.client.ClientResponseReaders.Json4sFormatsReader._
import com.wordnik.swagger.client.RequestWriters.Json4sFormatsWriter._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

import org.json4s._

class HistoryApi(
  val defBasePath: String = "https://api.mailbaby.net",
  defApiInvoker: ApiInvoker = ApiInvoker
) {
  private lazy val dateTimeFormatter = {
    val formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
    formatter
  }
  private val dateFormatter = {
    val formatter = new SimpleDateFormat("yyyy-MM-dd")
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
    formatter
  }
  implicit val formats = new org.json4s.DefaultFormats {
    override def dateFormatter = dateTimeFormatter
  }
  implicit val stringReader: ClientResponseReader[String] = ClientResponseReaders.StringReader
  implicit val unitReader: ClientResponseReader[Unit] = ClientResponseReaders.UnitReader
  implicit val jvalueReader: ClientResponseReader[JValue] = ClientResponseReaders.JValueReader
  implicit val jsonReader: ClientResponseReader[Nothing] = JsonFormatsReader
  implicit val stringWriter: RequestWriter[String] = RequestWriters.StringWriter
  implicit val jsonWriter: RequestWriter[Nothing] = JsonFormatsWriter

  var basePath: String = defBasePath
  var apiInvoker: ApiInvoker = defApiInvoker

  def addHeader(key: String, value: String): mutable.HashMap[String, String] = {
    apiInvoker.defaultHeaders += key -> value
  }

  val config: SwaggerConfig = SwaggerConfig.forUrl(new URI(defBasePath))
  val client = new RestClient(config)
  val helper = new HistoryApiAsyncHelper(client, config)

  /**
   * Account usage statistics.
   * Returns information about the usage on your mail accounts.
   *
   * @param time The timeframe for the statistics. (optional)
   * @return MailStatsType
   */
  def getStats(time: Option[String] = None): Option[MailStatsType] = {
    val await = Try(Await.result(getStatsAsync(time), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Account usage statistics. asynchronously
   * Returns information about the usage on your mail accounts.
   *
   * @param time The timeframe for the statistics. (optional)
   * @return Future(MailStatsType)
   */
  def getStatsAsync(time: Option[String] = None): Future[MailStatsType] = {
      helper.getStats(time)
  }

  /**
   * displays the mail log
   * Get a listing of the emails sent through this system 
   *
   * @param id The ID of your mail order this will be sent through. (optional)
   * @param origin originating ip address sending mail (optional)
   * @param mx mx record mail was sent to (optional)
   * @param from from email address (optional)
   * @param to to/destination email address (optional)
   * @param subject subject containing this string (optional)
   * @param mailid mail id (optional)
   * @param skip number of records to skip for pagination (optional, default to 0)
   * @param limit maximum number of records to return (optional, default to 100)
   * @param startDate earliest date to get emails in unix timestamp format (optional)
   * @param endDate earliest date to get emails in unix timestamp format (optional)
   * @param replyto Reply-To Email Address (optional)
   * @param headerfrom Header From Email Address (optional)
   * @param delivered Limiting the emails to wether or not they were delivered. (optional)
   * @return MailLog
   */
  def viewMailLog(id: Option[Long] = None, origin: Option[String] = None, mx: Option[String] = None, from: Option[String] = None, to: Option[String] = None, subject: Option[String] = None, mailid: Option[String] = None, skip: Option[Integer] = Option(0), limit: Option[Integer] = Option(100), startDate: Option[Long] = None, endDate: Option[Long] = None, replyto: Option[String] = None, headerfrom: Option[String] = None, delivered: Option[String] = None): Option[MailLog] = {
    val await = Try(Await.result(viewMailLogAsync(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * displays the mail log asynchronously
   * Get a listing of the emails sent through this system 
   *
   * @param id The ID of your mail order this will be sent through. (optional)
   * @param origin originating ip address sending mail (optional)
   * @param mx mx record mail was sent to (optional)
   * @param from from email address (optional)
   * @param to to/destination email address (optional)
   * @param subject subject containing this string (optional)
   * @param mailid mail id (optional)
   * @param skip number of records to skip for pagination (optional, default to 0)
   * @param limit maximum number of records to return (optional, default to 100)
   * @param startDate earliest date to get emails in unix timestamp format (optional)
   * @param endDate earliest date to get emails in unix timestamp format (optional)
   * @param replyto Reply-To Email Address (optional)
   * @param headerfrom Header From Email Address (optional)
   * @param delivered Limiting the emails to wether or not they were delivered. (optional)
   * @return Future(MailLog)
   */
  def viewMailLogAsync(id: Option[Long] = None, origin: Option[String] = None, mx: Option[String] = None, from: Option[String] = None, to: Option[String] = None, subject: Option[String] = None, mailid: Option[String] = None, skip: Option[Integer] = Option(0), limit: Option[Integer] = Option(100), startDate: Option[Long] = None, endDate: Option[Long] = None, replyto: Option[String] = None, headerfrom: Option[String] = None, delivered: Option[String] = None): Future[MailLog] = {
      helper.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered)
  }

}

class HistoryApiAsyncHelper(client: TransportClient, config: SwaggerConfig) extends ApiClient(client, config) {

  def getStats(time: Option[String] = None
    )(implicit reader: ClientResponseReader[MailStatsType]): Future[MailStatsType] = {
    // create path and map variables
    val path = (addFmt("/mail/stats"))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    time match {
      case Some(param) => queryParams += "time" -> param.toString
      case _ => queryParams
    }

    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  def viewMailLog(id: Option[Long] = None,
    origin: Option[String] = None,
    mx: Option[String] = None,
    from: Option[String] = None,
    to: Option[String] = None,
    subject: Option[String] = None,
    mailid: Option[String] = None,
    skip: Option[Integer] = Option(0),
    limit: Option[Integer] = Option(100),
    startDate: Option[Long] = None,
    endDate: Option[Long] = None,
    replyto: Option[String] = None,
    headerfrom: Option[String] = None,
    delivered: Option[String] = None
    )(implicit reader: ClientResponseReader[MailLog]): Future[MailLog] = {
    // create path and map variables
    val path = (addFmt("/mail/log"))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    id match {
      case Some(param) => queryParams += "id" -> param.toString
      case _ => queryParams
    }
    origin match {
      case Some(param) => queryParams += "origin" -> param.toString
      case _ => queryParams
    }
    mx match {
      case Some(param) => queryParams += "mx" -> param.toString
      case _ => queryParams
    }
    from match {
      case Some(param) => queryParams += "from" -> param.toString
      case _ => queryParams
    }
    to match {
      case Some(param) => queryParams += "to" -> param.toString
      case _ => queryParams
    }
    subject match {
      case Some(param) => queryParams += "subject" -> param.toString
      case _ => queryParams
    }
    mailid match {
      case Some(param) => queryParams += "mailid" -> param.toString
      case _ => queryParams
    }
    skip match {
      case Some(param) => queryParams += "skip" -> param.toString
      case _ => queryParams
    }
    limit match {
      case Some(param) => queryParams += "limit" -> param.toString
      case _ => queryParams
    }
    startDate match {
      case Some(param) => queryParams += "startDate" -> param.toString
      case _ => queryParams
    }
    endDate match {
      case Some(param) => queryParams += "endDate" -> param.toString
      case _ => queryParams
    }
    replyto match {
      case Some(param) => queryParams += "replyto" -> param.toString
      case _ => queryParams
    }
    headerfrom match {
      case Some(param) => queryParams += "headerfrom" -> param.toString
      case _ => queryParams
    }
    delivered match {
      case Some(param) => queryParams += "delivered" -> param.toString
      case _ => queryParams
    }

    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }


}
