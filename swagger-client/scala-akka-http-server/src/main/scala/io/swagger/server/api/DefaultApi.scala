package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.GenericResponse
import io.swagger.server.model.MailLog
import io.swagger.server.model.SendMail
import io.swagger.server.model.SendMailAdv
import io.swagger.server.model.SendMailAdv_attachments
import io.swagger.server.model.SendMailAdv_bcc
import io.swagger.server.model.SendMailAdv_cc
import io.swagger.server.model.SendMailAdv_from
import io.swagger.server.model.SendMailAdv_replyto
import io.swagger.server.model.SendMailAdv_to
import io.swagger.server.model.inline_response_200
import io.swagger.server.model.inline_response_401

class DefaultApi(
    defaultService: DefaultApiService,
    defaultMarshaller: DefaultApiMarshaller
) {
  import defaultMarshaller._

  lazy val route: Route =
    path() { () => 
      get {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  defaultService.getMailOrders()
               
             
            }
         
        }
      }
    } ~
    path() { () => 
      get {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  defaultService.pingServer()
               
             
            }
         
        }
      }
    } ~
    path() { () => 
      post {
        parameters() { () =>
          
            formFields("subject".as[String], "body".as[String], "from".as[String], "to".as[String], "replyto".as[String], "cc".as[String], "bcc".as[String], "attachments".as[String], "id".as[Long]) { (subject, body, from, to, replyto, cc, bcc, attachments, id) =>
              
                entity(as[SendMailAdv]){ body =>
                  defaultService.sendAdvMail(body = body, subject = subject, body = body, from = from, to = to, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments, id = id)
                }
             
            }
         
        }
      }
    } ~
    path() { () => 
      post {
        parameters() { () =>
          
            formFields("to".as[String], "from".as[String], "subject".as[String], "body".as[String]) { (to, from, subject, body) =>
              
                entity(as[SendMail]){ body =>
                  defaultService.sendMail(to = to, from = from, subject = subject, body = body, body = body)
                }
             
            }
         
        }
      }
    } ~
    path() { () => 
      get {
        parameters("id".as[Long].?, "search".as[String].?, "skip".as[Int].?, "limit".as[Int].?, "startDate".as[Long].?, "endDate".as[Long].?) { (id, search, skip, limit, startDate, endDate) =>
          
            formFields() { () =>
              
                
                  defaultService.viewMailLog(id = id, search = search, skip = skip, limit = limit, startDate = startDate, endDate = endDate)
               
             
            }
         
        }
      }
    }
}

trait DefaultApiService {

  def getMailOrders200(responseinline_response_200array: List[inline_response_200])(implicit toEntityMarshallerinline_response_200array: ToEntityMarshaller[List[inline_response_200]]): Route =
    complete((200, responseinline_response_200array))
  def getMailOrders401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def getMailOrders404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: OK, DataType: List[inline_response_200]
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: Unauthorized, DataType: inline_response_401
   */
  def getMailOrders()
      (implicit toEntityMarshallerinline_response_200array: ToEntityMarshaller[List[inline_response_200]], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def pingServer200: Route =
    complete((200, "Server is up and running"))
  def pingServer0: Route =
    complete((0, "Something is wrong"))
  /**
   * Code: 200, Message: Server is up and running
   * Code: 0, Message: Something is wrong
   */
  def pingServer()
      (implicit ): Route

  def sendAdvMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendAdvMail400(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((400, responseinline_response_401))
  def sendAdvMail401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def sendAdvMail404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: The specified resource was not found, DataType: inline_response_401
   */
  def sendAdvMail(body: String, subject: String, body: String, from: String, to: String, replyto: String, cc: String, bcc: String, attachments: String, id: Long)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def sendMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendMail400(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((400, responseinline_response_401))
  def sendMail401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def sendMail404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: The specified resource was not found, DataType: inline_response_401
   */
  def sendMail(to: String, from: String, subject: String, body: String, body: String)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def viewMailLog200(responseMailLog: MailLog)(implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route =
    complete((200, responseMailLog))
  def viewMailLog400: Route =
    complete((400, "bad input parameter"))
  /**
   * Code: 200, Message: search results matching criteria, DataType: MailLog
   * Code: 400, Message: bad input parameter
   */
  def viewMailLog(id: Option[Long], search: Option[String], skip: Option[Int], limit: Option[Int], startDate: Option[Long], endDate: Option[Long])
      (implicit toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]): Route

}

trait DefaultApiMarshaller {
  implicit def fromRequestUnmarshallerSendMailAdv: FromRequestUnmarshaller[SendMailAdv]

  implicit def fromRequestUnmarshallerSendMail: FromRequestUnmarshaller[SendMail]


  implicit def toEntityMarshallerinline_response_200array: ToEntityMarshaller[List[inline_response_200]]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerMailLog: ToEntityMarshaller[MailLog]

}

