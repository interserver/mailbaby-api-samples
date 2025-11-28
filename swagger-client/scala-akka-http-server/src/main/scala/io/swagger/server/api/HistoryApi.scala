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
        parameters("id".as[Long].?, "origin".as[String].?, "mx".as[String].?, "from".as[String].?, "to".as[String].?, "subject".as[String].?, "mailid".as[String].?, "skip".as[Int].?, "limit".as[Int].?, "startDate".as[Long].?, "endDate".as[Long].?, "replyto".as[String].?, "headerfrom".as[String].?, "delivered".as[String].?) { (id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered) =>
          
            
              
                
                  historyService.viewMailLog(id = id, origin = origin, mx = mx, from = from, to = to, subject = subject, mailid = mailid, skip = skip, limit = limit, startDate = startDate, endDate = endDate, replyto = replyto, headerfrom = headerfrom, delivered = delivered)
               
             
           
         
        }
      }
    }
}

trait HistoryApiService {

  def getStats200(responseMailStatsType: MailStatsType)(implicit toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType]): Route =
    complete((200, responseMailStatsType))
  def getStats401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def getStats404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: MailStatsType
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: Unauthorized, DataType: ErrorMessage
   */
  def getStats(time: Option[String])
      (implicit toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def viewMailLog200(responseMailLog: MailLog)(implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route =
    complete((200, responseMailLog))
  def viewMailLog400: Route =
    complete((400, "bad input parameter"))
  /**
   * Code: 200, Message: search results matching criteria, DataType: MailLog
   * Code: 400, Message: bad input parameter
   */
  def viewMailLog(id: Option[Long], origin: Option[String], mx: Option[String], from: Option[String], to: Option[String], subject: Option[String], mailid: Option[String], skip: Option[Int], limit: Option[Int], startDate: Option[Long], endDate: Option[Long], replyto: Option[String], headerfrom: Option[String], delivered: Option[String])
      (implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route

}

trait HistoryApiMarshaller {

  implicit def toEntityMarshallerMailStatsType: ToEntityMarshaller[MailStatsType]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]

}

