package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.DenyRuleNew
import io.swagger.server.model.DenyRuleRecord
import io.swagger.server.model.EmailAddress
import io.swagger.server.model.GenericResponse
import io.swagger.server.model.MailBlocks
import io.swagger.server.model.inline_response_401

class BlockingApi(
    blockingService: BlockingApiService,
    blockingMarshaller: BlockingApiMarshaller
) {
  import blockingMarshaller._

  lazy val route: Route =
    path() { () => 
      post {
        parameters() { () =>
          
            formFields("user".as[String], "type".as[String], "data".as[String]) { (user, &#x60;type&#x60;, data) =>
              
                entity(as[DenyRuleNew]){ body =>
                  blockingService.addRule(user = user, &#x60;type&#x60; = &#x60;type&#x60;, data = data, body = body)
                }
             
            }
         
        }
      }
    } ~
    path() { (ruleId) => 
      delete {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  blockingService.deleteRule(ruleId = ruleId)
               
             
            }
         
        }
      }
    } ~
    path() { () => 
      post {
        parameters() { () =>
          
            formFields("email".as[String]) { (email) =>
              
                entity(as[EmailAddress]){ body =>
                  blockingService.delistBlock(body = body, email = email)
                }
             
            }
         
        }
      }
    } ~
    path() { () => 
      get {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  blockingService.getMailBlocks()
               
             
            }
         
        }
      }
    } ~
    path() { () => 
      get {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  blockingService.getRules()
               
             
            }
         
        }
      }
    }
}

trait BlockingApiService {

  def addRule200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def addRule400(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((400, responseinline_response_401))
  def addRule401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def addRule404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: The specified resource was not found, DataType: inline_response_401
   */
  def addRule(user: String, &#x60;type&#x60;: String, data: String, body: DenyRuleNew)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def deleteRule200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def deleteRule400(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((400, responseinline_response_401))
  def deleteRule401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def deleteRule404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: The specified resource was not found, DataType: inline_response_401
   */
  def deleteRule(ruleId: Int)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def delistBlock200(responseGenericResponse: GenericResponse)(implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]): Route =
    complete((200, responseGenericResponse))
  def delistBlock400(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((400, responseinline_response_401))
  def delistBlock401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def delistBlock404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: search results matching criteria, DataType: GenericResponse
   * Code: 400, Message: The specified resource was not found, DataType: inline_response_401
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: The specified resource was not found, DataType: inline_response_401
   */
  def delistBlock(body: EmailAddress, email: String)
      (implicit toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def getMailBlocks200(responseMailBlocks: MailBlocks)(implicit toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks]): Route =
    complete((200, responseMailBlocks))
  def getMailBlocks401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def getMailBlocks404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: OK, DataType: MailBlocks
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: Unauthorized, DataType: inline_response_401
   */
  def getMailBlocks()
      (implicit toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

  def getRules200(responseDenyRuleRecordarray: List[DenyRuleRecord])(implicit toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[List[DenyRuleRecord]]): Route =
    complete((200, responseDenyRuleRecordarray))
  def getRules401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def getRules404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: OK, DataType: List[DenyRuleRecord]
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: Unauthorized, DataType: inline_response_401
   */
  def getRules()
      (implicit toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[List[DenyRuleRecord]], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

}

trait BlockingApiMarshaller {
  implicit def fromRequestUnmarshallerDenyRuleNew: FromRequestUnmarshaller[DenyRuleNew]

  implicit def fromRequestUnmarshallerEmailAddress: FromRequestUnmarshaller[EmailAddress]


  implicit def toEntityMarshallerGenericResponse: ToEntityMarshaller[GenericResponse]

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

  implicit def toEntityMarshallerMailBlocks: ToEntityMarshaller[MailBlocks]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerDenyRuleRecordarray: ToEntityMarshaller[List[DenyRuleRecord]]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

}

