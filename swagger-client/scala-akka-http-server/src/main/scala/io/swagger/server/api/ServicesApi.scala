package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._
import io.swagger.server.model.ErrorMessage
import io.swagger.server.model.MailOrder
import io.swagger.server.model.MailOrderDetail

class ServicesApi(
    servicesService: ServicesApiService,
    servicesMarshaller: ServicesApiMarshaller
) {
  import servicesMarshaller._

  lazy val route: Route =
    path() { (id) => 
      get {
        
          
            
              
                
                  servicesService.getMailOrderById(id = id)
               
             
           
         
       
      }
    } ~
    path() { 
      get {
        
          
            
              
                
                  servicesService.getMailOrders()
               
             
           
         
       
      }
    }
}

trait ServicesApiService {

  def getMailOrderById200(responseMailOrderDetail: MailOrderDetail)(implicit toEntityMarshallerMailOrderDetail: ToEntityMarshaller[MailOrderDetail]): Route =
    complete((200, responseMailOrderDetail))
  def getMailOrderById400(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((400, responseErrorMessage))
  def getMailOrderById401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  def getMailOrderById404(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((404, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: MailOrderDetail
   * Code: 400, Message: Bad request — one or more input parameters were missing or invalid., DataType: ErrorMessage
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   * Code: 404, Message: The specified resource was not found or does not belong to your account., DataType: ErrorMessage
   */
  def getMailOrderById(id: Long)
      (implicit toEntityMarshallerMailOrderDetail: ToEntityMarshaller[MailOrderDetail], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

  def getMailOrders200(responseMailOrderarray: List[MailOrder])(implicit toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]]): Route =
    complete((200, responseMailOrderarray))
  def getMailOrders401(responseErrorMessage: ErrorMessage)(implicit toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route =
    complete((401, responseErrorMessage))
  /**
   * Code: 200, Message: OK, DataType: List[MailOrder]
   * Code: 401, Message: Authentication failed.  Ensure you are sending a valid &#x60;X-API-KEY&#x60; header. Obtain your API key from [my.interserver.net/account_security](https://my.interserver.net/account_security)., DataType: ErrorMessage
   */
  def getMailOrders()
      (implicit toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]], toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]): Route

}

trait ServicesApiMarshaller {

  implicit def toEntityMarshallerMailOrderDetail: ToEntityMarshaller[MailOrderDetail]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

  implicit def toEntityMarshallerMailOrderarray: ToEntityMarshaller[List[MailOrder]]

  implicit def toEntityMarshallerErrorMessage: ToEntityMarshaller[ErrorMessage]

}

