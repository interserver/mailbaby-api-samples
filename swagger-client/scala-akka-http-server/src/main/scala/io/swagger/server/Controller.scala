package io.swagger.server

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import io.swagger.server.api.BlockingApi
import io.swagger.server.api.HistoryApi
import io.swagger.server.api.SendingApi
import io.swagger.server.api.ServicesApi
import io.swagger.server.api.StatusApi
import akka.http.scaladsl.server.Directives._
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

class Controller(blocking: BlockingApi, history: HistoryApi, sending: SendingApi, services: ServicesApi, status: StatusApi)(implicit system: ActorSystem, materializer: ActorMaterializer) {

    lazy val routes: Route = blocking.route ~ history.route ~ sending.route ~ services.route ~ status.route 

    Http().bindAndHandle(routes, "0.0.0.0", 9000)
}