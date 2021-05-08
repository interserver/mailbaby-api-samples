package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.GenericResponse
import io.swagger.server.model.MailAttachment
import io.swagger.server.model.MailContact
import io.swagger.server.model.MailLog
import io.swagger.server.model.MailOrder
import io.swagger.server.model.MailOrders
import io.swagger.server.model.SendMail
import io.swagger.server.model.SendMailAdv
import io.swagger.server.model.SendMailAdv_from
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
          
            formFields() { () =>
              
                entity(as[MailOrder]){ body =>
                  defaultService.placeMailOrder(body = body)
                }
             
            }
         
        }
      }
    } ~
    path() { () => 
      post {
        parameters() { () =>
          
            formFields("subject".as[String], "body".as[String], "from".as[String], "to".as[String], "id".as[Long], "replyto".as[String], "cc".as[String], "bcc".as[String], "attachments".as[String]) { (subject, body, from, to, id, replyto, cc, bcc, attachments) =>
              
                entity(as[SendMailAdv]){ body =>
                  defaultService.sendAdvMail(body = body, subject = subject, body = body, from = from, to = to, id = id, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments)
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
        parameters() { () =>
          
            formFields() { () =>
              
                
                  defaultService.validateMailOrder()
               
             
            }
         
        }
      }
    } ~
    path() { () => 
      get {
        parameters("id".as[Long].?, "searchString".as[String].?, "skip".as[Int].?, "limit".as[Int].?) { (id, searchString, skip, limit) =>
          
            formFields() { () =>
              
                
                  defaultService.viewMailLog(id = id, searchString = searchString, skip = skip, limit = limit)
               
             
            }
         
        }
      }
    }
}

trait DefaultApiService {

  def getMailOrders200(responseMailOrders: MailOrders)(implicit toEntityMarshallerMailOrders: ToEntityMarshaller[MailOrders]): Route =
    complete((200, responseMailOrders))
  def getMailOrders401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def getMailOrders404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: OK, DataType: MailOrders
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: Unauthorized, DataType: inline_response_401
   */
  def getMailOrders()
      (implicit toEntityMarshallerMailOrders: ToEntityMarshaller[MailOrders], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

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

  def placeMailOrder200: Route =
    complete((200, "list of mail orders"))
  def placeMailOrder400(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((400, responseinline_response_401))
  def placeMailOrder409(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((409, responseinline_response_401))
  def placeMailOrder401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  /**
   * Code: 200, Message: list of mail orders
   * Code: 400, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 409, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   */
  def placeMailOrder(body: MailOrder)
      (implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

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
  def sendAdvMail(body: String, subject: String, body: String, from: String, to: String, id: Long, replyto: String, cc: String, bcc: String, attachments: String)
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

  def validateMailOrder200: Route =
    complete((200, "list of mail orders"))
  def validateMailOrder401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  /**
   * Code: 200, Message: list of mail orders
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   */
  def validateMailOrder()
      (implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def viewMailLog200(responseMailLogarray: List[MailLog])(implicit toEntityMarshallerMailLogarray: ToEntityMarshaller[List[MailLog]]): Route =
    complete((200, responseMailLogarray))
  def viewMailLog400: Route =
    complete((400, "bad input parameter"))
  /**
   * Code: 200, Message: search results matching criteria, DataType: List[MailLog]
   * Code: 400, Message: bad input parameter
   */
  def viewMailLog(id: Option[Long], searchString: Option[String], skip: Option[Int], limit: Option[Int])
      (implicit toEntityMarshallerMailLogarray: ToEntityMarshaller[List[MailLog]]): Route

}

trait DefaultApiMarshaller {
  implicit def fromRequestUnmarshallerMailOrder: FromRequestUnmarshaller[MailOrder]

  implicit def fromRequestUnmarshallerSendMailAdv: FromRequestUnmarshaller[SendMailAdv]

  implicit def fromRequestUnmarshallerSendMail: FromRequestUnmarshaller[SendMail]


  implicit def toEntityMarshallerMailOrders: ToEntityMarshaller[MailOrders]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

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

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerMailLogarray: ToEntityMarshaller[List[MailLog]]

}

