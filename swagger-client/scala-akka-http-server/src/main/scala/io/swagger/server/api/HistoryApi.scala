package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.ErrorMessage
import io.swagger.server.model.MailLog
import io.swagger.server.model.inline_response_200

class HistoryApi(
    historyService: HistoryApiService,
    historyMarshaller: HistoryApiMarshaller
) {
  import historyMarshaller._

  lazy val route: Route =
    path() { () => 
      get {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  historyService.getStats()
               
             
            }
         
        }
      }
    } ~
    path() { () => 
      get {
        parameters("id".as[Long].?, "origin".as[String].?, "mx".as[String].?, "from".as[String].?, "to".as[String].?, "subject".as[String].?, "mailid".as[String].?, "skip".as[Int].?, "limit".as[Int].?, "startDate".as[Long].?, "endDate".as[Long].?) { (id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate) =>
          
            formFields() { () =>
              
                
                  historyService.viewMailLog(id = id, origin = origin, mx = mx, from = from, to = to, subject = subject, mailid = mailid, skip = skip, limit = limit, startDate = startDate, endDate = endDate)
               
             
            }
         
        }
      }
    }
}

trait HistoryApiService {

  def getStats200(responseinline_response_200array: List[inline_response_200])(implicit toEntityMarshallerinline_response_200array: ToEntityMarshaller[List[inline_response_200]]): Route =
    complete((200, responseinline_response_200array))
  def getStats401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def getStats404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: List[inline_response_200]
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: Unauthorized, DataType: ErrorMessage
   */
  def getStats()
      (implicit toEntityMarshallerinline_response_200array: ToEntityMarshaller[List[inline_response_200]], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def viewMailLog200(responseMailLog: MailLog)(implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route =
    complete((200, responseMailLog))
  def viewMailLog400: Route =
    complete((400, "bad input parameter"))
  /**
   * Code: 200, Message: search results matching criteria, DataType: MailLog
   * Code: 400, Message: bad input parameter
   */
  def viewMailLog(id: Option[Long], origin: Option[String], mx: Option[String], from: Option[String], to: Option[String], subject: Option[String], mailid: Option[String], skip: Option[Int], limit: Option[Int], startDate: Option[Long], endDate: Option[Long])
      (implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route

}

trait HistoryApiMarshaller {

  implicit def toEntityMarshallerinline_response_200array: ToEntityMarshaller[List[inline_response_200]]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]

}

