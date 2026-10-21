package org.openapitools.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import akka.http.scaladsl.unmarshalling.FromEntityUnmarshaller
import akka.http.scaladsl.unmarshalling.FromStringUnmarshaller
import org.openapitools.server.AkkaHttpHelper._
import org.openapitools.server.model.DenyRuleRecord
import org.openapitools.server.model.EmailAddressParam
import org.openapitools.server.model.ErrorMessage
import org.openapitools.server.model.GenericResponse
import org.openapitools.server.model.MailBlocks


class BlockingApi(
    blockingService: BlockingApiService,
    blockingMarshaller: BlockingApiMarshaller
) {

  
  import blockingMarshaller._

  lazy val route: Route =
    path("mail" / "rules") { 
      post {  
          formFields("user".as[String].?, "type".as[String], "data".as[String]) { (user, `type`, data) =>
            blockingService.addRule(`type` = `type`, data = data, user = user)
          }
      }
    } ~
    path("mail" / "rules" / IntNumber) { (ruleId) => 
      delete {  
            blockingService.deleteRule(ruleId = ruleId)
      }
    } ~
    path("mail" / "blocks" / "delete") { 
      post {  
            entity(as[EmailAddressParam]){ emailAddressParam =>
              blockingService.delistBlock(emailAddressParam = emailAddressParam)
            }
      }
    } ~
    path("mail" / "blocks") { 
      get {  
            blockingService.getMailBlocks()
      }
    } ~
    path("mail" / "rules") { 
      get {  
            blockingService.getRules()
      }
    }
}


trait BlockingApiService {

  def addRule200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def addRule400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def addRule401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def addRule404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: Rule created successfully, DataType: GenericResponse
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def addRule(`type`: String, data: String, user: Option[String])
      (implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route

  def deleteRule200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def deleteRule400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def deleteRule401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def deleteRule404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: Rule deleted successfully, DataType: GenericResponse
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def deleteRule(ruleId: Int)
      (implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route

  def delistBlock200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def delistBlock400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def delistBlock401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def delistBlock404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: Address successfully delisted, DataType: GenericResponse
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def delistBlock(emailAddressParam: EmailAddressParam)
      (implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route

  def getMailBlocks200(responseMailBlocks: MailBlocks)(implicit toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks]): Route =
    complete((200, responseMailBlocks))
  def getMailBlocks401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: MailBlocks
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   */
  def getMailBlocks()
      (implicit toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def getRules200(responseDenyRuleRecordarray: Seq[DenyRuleRecord])(implicit toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[Seq[DenyRuleRecord]]): Route =
    complete((200, responseDenyRuleRecordarray))
  def getRules401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: Seq[DenyRuleRecord]
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   */
  def getRules()
      (implicit toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[Seq[DenyRuleRecord]], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait BlockingApiMarshaller {
  implicit def fromEntityUnmarshallerEmailAddressParam: FromEntityUnmarshaller[EmailAddressParam]



  implicit def toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks]

  implicit def toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[Seq[DenyRuleRecord]]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

}

