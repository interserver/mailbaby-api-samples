package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.MailOrder
import io.swagger.server.model.inline_response_401

class ServicesApi(
    servicesService: ServicesApiService,
    servicesMarshaller: ServicesApiMarshaller
) {
  import servicesMarshaller._

  lazy val route: Route =
    path() { () => 
      get {
        parameters() { () =>
          
            formFields() { () =>
              
                
                  servicesService.getMailOrders()
               
             
            }
         
        }
      }
    }
}

trait ServicesApiService {

  def getMailOrders200(responseMailOrderarray: List[MailOrder])(implicit toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]]): Route =
    complete((200, responseMailOrderarray))
  def getMailOrders401(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((401, responseinline_response_401))
  def getMailOrders404(responseinline_response_401: inline_response_401)(implicit toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route =
    complete((404, responseinline_response_401))
  /**
   * Code: 200, Message: OK, DataType: List[MailOrder]
   * Code: 401, Message: Unauthorized, DataType: inline_response_401
   * Code: 404, Message: Unauthorized, DataType: inline_response_401
   */
  def getMailOrders()
      (implicit toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401], toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]): Route

}

trait ServicesApiMarshaller {

  implicit def toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

  implicit def toEntityMarshallerinline_response_401: ToEntityMarshaller[inline_response_401]

}

