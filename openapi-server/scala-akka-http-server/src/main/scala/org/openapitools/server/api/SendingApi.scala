package org.openapitools.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import akka.http.scaladsl.unmarshalling.FromEntityUnmarshaller
import akka.http.scaladsl.unmarshalling.FromStringUnmarshaller
import org.openapitools.server.AkkaHttpHelper._
import org.openapitools.server.model.EmailAddressTypes
import org.openapitools.server.model.EmailAddressesTypes
import org.openapitools.server.model.ErrorMessage
import org.openapitools.server.model.GenericResponse
import org.openapitools.server.model.MailAttachment
import org.openapitools.server.model.SendMailRaw
import org.openapitools.server.model.SendMailTo


class SendingApi(
    sendingService: SendingApiService,
    sendingMarshaller: SendingApiMarshaller
) {

  
  import sendingMarshaller._

  lazy val route: Route =
    path("mail" / "rawsend") { 
      post {  
            entity(as[SendMailRaw]){ sendMailRaw =>
              sendingService.rawMail(sendMailRaw = sendMailRaw)
            }
      }
    } ~
    path("mail" / "advsend") { 
      post {  
          formFields("subject".as[String], "body".as[String], "from".as[String], "to".as[String], "replyto".as[String].?, "cc".as[String].?, "bcc".as[String].?, "attachments".as[String].?, "id".as[Long].?) { (subject, body, from, to, replyto, cc, bcc, attachments, id) =>
            sendingService.sendAdvMail(subject = subject, body = body, from = from, to = to, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments, id = id)
          }
      }
    } ~
    path("mail" / "send") { 
      post {  
          formFields("to".as[String], "from".as[String], "subject".as[String], "body".as[String], "id".as[Long].?) { (to, from, subject, body, id) =>
            sendingService.sendMail(to = to, from = from, subject = subject, body = body, id = id)
          }
      }
    }
}


trait SendingApiService {

  def rawMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def rawMail400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def rawMail401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def rawMail404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: Email accepted for delivery, DataType: GenericResponse
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def rawMail(sendMailRaw: SendMailRaw)
      (implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route

  def sendAdvMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendAdvMail400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def sendAdvMail401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def sendAdvMail404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: Email accepted for delivery, DataType: GenericResponse
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def sendAdvMail(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: Option[EmailAddressesTypes], cc: Option[EmailAddressesTypes], bcc: Option[EmailAddressesTypes], attachments: Option[Seq[MailAttachment]], id: Option[Long])
      (implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route

  def sendMail200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def sendMail400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def sendMail401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def sendMail404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: Email accepted for delivery, DataType: GenericResponse
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def sendMail(to: SendMailTo, from: String, subject: String, body: String, id: Option[Long])
      (implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route

}

trait SendingApiMarshaller {
  implicit def fromEntityUnmarshallerMailAttachmentList: FromEntityUnmarshaller[Seq[MailAttachment]]

  implicit def fromEntityUnmarshallerSendMailRaw: FromEntityUnmarshaller[SendMailRaw]

  implicit def fromEntityUnmarshallerEmailAddressesTypes: FromEntityUnmarshaller[EmailAddressesTypes]

  implicit def fromEntityUnmarshallerSendMailTo: FromEntityUnmarshaller[SendMailTo]

  implicit def fromEntityUnmarshallerEmailAddressTypes: FromEntityUnmarshaller[EmailAddressTypes]



  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

}

