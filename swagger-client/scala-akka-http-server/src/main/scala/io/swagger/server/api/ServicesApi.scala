package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.ErrorMessage
import io.swagger.server.model.MailOrder

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
  def getMailOrders401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def getMailOrders404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: List[MailOrder]
   * Code: 401, Message: Unauthorized, DataType: ErrorMessage
   * Code: 404, Message: Unauthorized, DataType: ErrorMessage
   */
  def getMailOrders()
      (implicit toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait ServicesApiMarshaller {

  implicit def toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

}

