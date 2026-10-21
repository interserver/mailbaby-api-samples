package org.openapitools.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import akka.http.scaladsl.unmarshalling.FromEntityUnmarshaller
import akka.http.scaladsl.unmarshalling.FromStringUnmarshaller
import org.openapitools.server.AkkaHttpHelper._
import org.openapitools.server.model.DateOrTimestamp
import org.openapitools.server.model.ErrorMessage
import org.openapitools.server.model.MailLog
import org.openapitools.server.model.MailStatsType


class HistoryApi(
    historyService: HistoryApiService,
    historyMarshaller: HistoryApiMarshaller
) {

  
  import historyMarshaller._

  lazy val route: Route =
    path("mail" / "stats") { 
      get { 
        parameters("time".as[String].?("1h")) { (time) => 
            historyService.getStats(time = time)
        }
      }
    } ~
    path("mail" / "log") { 
      get { 
        parameters("id".as[Long].?, "origin".as[String].?, "mx".as[String].?, "from".as[String].?, "to".as[String].?, "subject".as[String].?, "mailid".as[String].?, "messageId".as[String].?, "replyto".as[String].?, "headerfrom".as[String].?, "delivered".as[Int].?, "skip".as[Int].?(0), "limit".as[Int].?(100), "startDate".as[String].?, "endDate".as[String].?, "sort".as[String].?("time"), "dir".as[String].?("desc"), "groupby".as[String].?("recipient")) { (id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby) => 
            historyService.viewMailLog(id = id, origin = origin, mx = mx, from = from, to = to, subject = subject, mailid = mailid, messageId = messageId, replyto = replyto, headerfrom = headerfrom, delivered = delivered, skip = skip, limit = limit, startDate = startDate, endDate = endDate, sort = sort, dir = dir, groupby = groupby)
        }
      }
    }
}


trait HistoryApiService {

  def getStats200(responseMailStatsType: MailStatsType)(implicit toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType]): Route =
    complete((200, responseMailStatsType))
  def getStats401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: MailStatsType
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   */
  def getStats(time: String)
      (implicit toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def viewMailLog200(responseMailLog: MailLog)(implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route =
    complete((200, responseMailLog))
  def viewMailLog400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def viewMailLog401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  /**
   * Code: 200, Message: Paginated list of mail log entries, DataType: MailLog
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   */
  def viewMailLog(id: Option[Long], origin: Option[String], mx: Option[String], from: Option[String], to: Option[String], subject: Option[String], mailid: Option[String], messageId: Option[String], replyto: Option[String], headerfrom: Option[String], delivered: Option[Int], skip: Int, limit: Int, startDate: Option[String], endDate: Option[String], sort: String, dir: String, groupby: String)
      (implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait HistoryApiMarshaller {


  implicit def toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType]

  implicit def toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

}

