package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.ErrorResponse
import io.swagger.server.model.GenericResponse
import io.swagger.server.model.MailAttachment
import io.swagger.server.model.MailContact
import io.swagger.server.model.MailLog
import io.swagger.server.model.MailOrder
import io.swagger.server.model.MailOrders
import io.swagger.server.model.SendMail
import io.swagger.server.model.SendMail_from

class DefaultApi(
    defaultService: DefaultApiService,
    defaultMarshaller: DefaultApiMarshaller
) {
  import defaultMarshaller._

  lazy val route: Route =
    path() { () => 
      get {
        parameters("id".as[Long].?) { (id) =>
          
            formFields() { () =>
              
                
                  defaultService.getMailOrders(id = id)
               
             
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
          
            formFields() { () =>
              
                entity(as[SendMail]){ body =>
                  defaultService.sendAdvMailById(body = body)
                }
             
            }
         
        }
      }
    } ~
    path() { () => 
      post {
        parameters() { () =>
          
            formFields("subject".as[String], "body".as[String], "from".as[String], "to".as[String], "id".as[Long], "replyto".as[String], "cc".as[String], "bcc".as[String], "attachments".as[String]) { (subject, body, from, to, id, replyto, cc, bcc, attachments) =>
              
                entity(as[SendMail]){ body =>
                  defaultService.sendMailById(body = body, subject = subject, body = body, from = from, to = to, id = id, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments)
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
              
                
                  defaultService.viewMailLogById(id = id, searchString = searchString, skip = skip, limit = limit)
               
             
            }
         
        }
      }
    }
}

trait DefaultApiService {

  def getMailOrders200(responseMailOrders: MailOrders)(implicit toEntityMarshallerMailOrders: ToEntityMarshaller[MailOrders]): Route =
    complete((200, responseMailOrders))
  def getMailOrders401(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((401, responseErrorResponse))
  /**
   * Code: 200, Message: OK, DataType: MailOrders
   * Code: 401, Message: Unauthorized, DataType: ErrorResponse
   */
  def getMailOrders(id: Option[Long])
      (implicit toEntityMarshallerMailOrders: ToEntityMarshaller[MailOrders], toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route

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
  def placeMailOrder400: Route =
    complete((400, "invalid input, object invalid"))
  def placeMailOrder409: Route =
    complete((409, "an existing item already exists"))
  def placeMailOrder401(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((401, responseErrorResponse))
  /**
   * Code: 200, Message: list of mail orders
   * Code: 400, Message: invalid input, object invalid
   * Code: 409, Message: an existing item already exists
   * Code: 401, Message: Unauthorized, DataType: ErrorResponse
   */
  def placeMailOrder(body: MailOrder)
      (implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route

  def sendAdvMailById200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendAdvMailById400: Route =
    complete((400, "bad input parameter"))
  def sendAdvMailById401(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((401, responseErrorResponse))
  def sendAdvMailById404(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((404, responseErrorResponse))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: bad input parameter
   * Code: 401, Message: Unauthorized, DataType: ErrorResponse
   * Code: 404, Message: The specified resource was not found, DataType: ErrorResponse
   */
  def sendAdvMailById(body: SendMail)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse], toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route

  def sendMailById200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendMailById400: Route =
    complete((400, "bad input parameter"))
  def sendMailById401(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((401, responseErrorResponse))
  def sendMailById404(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((404, responseErrorResponse))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: bad input parameter
   * Code: 401, Message: Unauthorized, DataType: ErrorResponse
   * Code: 404, Message: The specified resource was not found, DataType: ErrorResponse
   */
  def sendMailById(body: String, subject: String, body: String, from: String, to: String, id: Long, replyto: String, cc: String, bcc: String, attachments: String)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse], toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route

  def validateMailOrder200: Route =
    complete((200, "list of mail orders"))
  def validateMailOrder401(responseErrorResponse: ErrorResponse)(implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route =
    complete((401, responseErrorResponse))
  /**
   * Code: 200, Message: list of mail orders
   * Code: 401, Message: Unauthorized, DataType: ErrorResponse
   */
  def validateMailOrder()
      (implicit toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]): Route

  def viewMailLogById200(responseMailLogarray: List[MailLog])(implicit toEntityMarshallerMailLogarray: ToEntityMarshaller[List[MailLog]]): Route =
    complete((200, responseMailLogarray))
  def viewMailLogById400: Route =
    complete((400, "bad input parameter"))
  /**
   * Code: 200, Message: search results matching criteria, DataType: List[MailLog]
   * Code: 400, Message: bad input parameter
   */
  def viewMailLogById(id: Option[Long], searchString: Option[String], skip: Option[Int], limit: Option[Int])
      (implicit toEntityMarshallerMailLogarray: ToEntityMarshaller[List[MailLog]]): Route

}

trait DefaultApiMarshaller {
  implicit def fromRequestUnmarshallerMailOrder: FromRequestUnmarshaller[MailOrder]

  implicit def fromRequestUnmarshallerSendMail: FromRequestUnmarshaller[SendMail]


  implicit def toEntityMarshallerMailOrders: ToEntityMarshaller[MailOrders]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerErrorResponse: ToEntityMarshaller[ErrorResponse]

  implicit def toEntityMarshallerMailLogarray: ToEntityMarshaller[List[MailLog]]

}

