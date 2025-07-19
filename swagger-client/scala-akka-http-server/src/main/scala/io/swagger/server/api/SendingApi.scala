package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.EmailAddressTypes
import io.swagger.server.model.EmailAddressesTypes
import io.swagger.server.model.ErrorMessage
import io.swagger.server.model.GenericResponse
import io.swagger.server.model.MailAttachment
import io.swagger.server.model.SendMail
import io.swagger.server.model.SendMailAdv

class SendingApi(
    sendingService: SendingApiService,
    sendingMarshaller: SendingApiMarshaller
) {
  import sendingMarshaller._

  lazy val route: Route =
    path() { 
      post {
        
          
            formFields("subject".as[String], "body".as[String], "from".as[String], "to".as[String], "replyto".as[String], "cc".as[String], "bcc".as[String], "attachments".as[String], "id".as[Long]) { (subject, body, from, to, replyto, cc, bcc, attachments, id) =>
              
                entity(as[SendMailAdv]){ body =>
                  sendingService.sendAdvMail(subject = subject, body = body, from = from, to = to, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments, id = id, body = body)
                }
             
            }
         
       
      }
    } ~
    path() { 
      post {
        
          
            formFields("to".as[String], "from".as[String], "subject".as[String], "body".as[String]) { (to, from, subject, body) =>
              
                entity(as[SendMail]){ body =>
                  sendingService.sendMail(to = to, from = from, subject = subject, body = body, body = body)
                }
             
            }
         
       
      }
    }
}

trait SendingApiService {

  def sendAdvMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendAdvMail400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def sendAdvMail401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def sendAdvMail404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: Error message when there was a problem with the input parameters., DataType: ErrorMessage
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found, DataType: ErrorMessage
   */
  def sendAdvMail(subject: String, body: String, from: String, to: String, replyto: String, cc: String, bcc: String, attachments: String, id: Long, body: String)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def sendMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendMail400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def sendMail401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def sendMail404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: Error message when there was a problem with the input parameters., DataType: ErrorMessage
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found, DataType: ErrorMessage
   */
  def sendMail(to: String, from: String, subject: String, body: String, body: String)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait SendingApiMarshaller {
  implicit def fromRequestUnmarshallerSendMailAdv: FromRequestUnmarshaller[SendMailAdv]

  implicit def fromRequestUnmarshallerSendMail: FromRequestUnmarshaller[SendMail]


  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

}

