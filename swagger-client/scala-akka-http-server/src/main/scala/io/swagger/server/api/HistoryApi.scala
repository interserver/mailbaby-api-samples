package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.ErrorMessage
import io.swagger.server.model.MailLog
import io.swagger.server.model.MailStatsType

class HistoryApi(
    historyService: HistoryApiService,
    historyMarshaller: HistoryApiMarshaller
) {
  import historyMarshaller._

  lazy val route: Route =
    path() { 
      get {
        parameters("time".as[String].?) { (time) =>
          
            
              
                
                  historyService.getStats(time = time)
               
             
           
         
        }
      }
    } ~
    path() { 
      get {
        parameters("id".as[Long].?, "origin".as[String].?, "mx".as[String].?, "from".as[String].?, "to".as[String].?, "subject".as[String].?, "mailid".as[String].?, "messageId".as[String].?, "replyto".as[String].?, "headerfrom".as[String].?, "delivered".as[Int].?, "skip".as[Int].?, "limit".as[Int].?, "startDate".as[Long].?, "endDate".as[Long].?) { (id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate) =>
          
            
              
                
                  historyService.viewMailLog(id = id, origin = origin, mx = mx, from = from, to = to, subject = subject, mailid = mailid, messageId = messageId, replyto = replyto, headerfrom = headerfrom, delivered = delivered, skip = skip, limit = limit, startDate = startDate, endDate = endDate)
               
             
           
         
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
  def getStats(time: Option[String])
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
  def viewMailLog(id: Option[Long], origin: Option[String], mx: Option[String], from: Option[String], to: Option[String], subject: Option[String], mailid: Option[String], messageId: Option[String], replyto: Option[String], headerfrom: Option[String], delivered: Option[Int], skip: Option[Int], limit: Option[Int], startDate: Option[Long], endDate: Option[Long])
      (implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait HistoryApiMarshaller {

  implicit def toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

}

