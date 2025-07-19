package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.DenyRuleNew
import io.swagger.server.model.DenyRuleRecord
import io.swagger.server.model.ErrorMessage
import io.swagger.server.model.GenericResponse
import io.swagger.server.model.MailBlocks

class BlockingApi(
    blockingService: BlockingApiService,
    blockingMarshaller: BlockingApiMarshaller
) {
  import blockingMarshaller._

  lazy val route: Route =
    path() { 
      post {
        
          
            formFields("user".as[String], "type".as[String], "data".as[String]) { (user, &#x60;type&#x60;, data) =>
              
                entity(as[DenyRuleNew]){ body =>
                  blockingService.addRule(user = user, &#x60;type&#x60; = &#x60;type&#x60;, data = data, body = body)
                }
             
            }
         
       
      }
    } ~
    path() { (ruleId) => 
      delete {
        
          
            
              
                
                  blockingService.deleteRule(ruleId = ruleId)
               
             
           
         
       
      }
    } ~
    path() { 
      post {
        
          
            
              
                entity(as[String]){ body =>
                  blockingService.delistBlock(body = body)
                }
             
           
         
       
      }
    } ~
    path() { 
      get {
        
          
            
              
                
                  blockingService.getMailBlocks()
               
             
           
         
       
      }
    } ~
    path() { 
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
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: Error message when there was a problem with the input parameters., DataType: ErrorMessage
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found, DataType: ErrorMessage
   */
  def addRule(user: String, &#x60;type&#x60;: String, data: String, body: DenyRuleNew)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def deleteRule200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def deleteRule400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def deleteRule401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def deleteRule404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: Error message when there was a problem with the input parameters., DataType: ErrorMessage
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found, DataType: ErrorMessage
   */
  def deleteRule(ruleId: Int)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def delistBlock200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def delistBlock400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def delistBlock401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def delistBlock404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: Error message when there was a problem with the input parameters., DataType: ErrorMessage
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found, DataType: ErrorMessage
   */
  def delistBlock(body: String)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def getMailBlocks200(responseMailBlocks: MailBlocks)(implicit toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks]): Route =
    complete((200, responseMailBlocks))
  def getMailBlocks401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def getMailBlocks404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: MailBlocks
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: Unauthorized, DataType: ErrorMessage
   */
  def getMailBlocks()
      (implicit toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def getRules200(responseDenyRuleRecordarray: List[DenyRuleRecord])(implicit toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[List[DenyRuleRecord]]): Route =
    complete((200, responseDenyRuleRecordarray))
  def getRules401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def getRules404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: List[DenyRuleRecord]
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: Unauthorized, DataType: ErrorMessage
   */
  def getRules()
      (implicit toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[List[DenyRuleRecord]], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait BlockingApiMarshaller {
  implicit def fromRequestUnmarshallerString: FromRequestUnmarshaller[String]

  implicit def fromRequestUnmarshallerDenyRuleNew: FromRequestUnmarshaller[DenyRuleNew]


  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[List[DenyRuleRecord]]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

}

