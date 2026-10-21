package org.openapitools.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.StatusCodes
import org.openapitools.server.AkkaHttpHelper._


class StatusApi(
    statusService: StatusApiService
) {

  
  
  lazy val route: Route =
    path("ping") { 
      get {  
            statusService.pingServer()
      }
    }
}


trait StatusApiService {

  def pingServer200(responseString: String)(implicit toEntityMarshallerString: ToEntityMarshaller[String]): Route =
    complete((200, responseString))
  def pingServerDefault(statusCode: Int): Route =
    complete((statusCode, "Something is wrong"))
  /**
   * Code: 200, Message: Server is up and running, DataType: String
   * Code: 0, Message: Something is wrong
   */
  def pingServer(): Route

}


