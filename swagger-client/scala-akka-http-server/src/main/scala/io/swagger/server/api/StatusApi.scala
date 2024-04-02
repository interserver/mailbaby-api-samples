package io.swagger.server.api

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.FromRequestUnmarshaller
import akka.http.scaladsl.marshalling.ToEntityMarshaller
import io.swagger.server.AkkaHttpHelper._

class StatusApi(
    statusService: StatusApiService
) {
  
  lazy val route: Route =
    path() { 
      get {
        
          
            
              
                
                  statusService.pingServer()
               
             
           
         
       
      }
    }
}

trait StatusApiService {

  def pingServer200: Route =
    complete((200, "Server is up and running"))
  def pingServer0: Route =
    complete((0, "Something is wrong"))
  /**
   * Code: 200, Message: Server is up and running
   * Code: 0, Message: Something is wrong
   */
  def pingServer(): Route

}


