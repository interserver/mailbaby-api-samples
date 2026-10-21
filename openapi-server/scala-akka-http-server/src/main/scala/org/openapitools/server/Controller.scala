package org.openapitools.server

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import org.openapitools.server.api.BlockingApi
import org.openapitools.server.api.HistoryApi
import org.openapitools.server.api.SendingApi
import org.openapitools.server.api.ServicesApi
import org.openapitools.server.api.StatusApi

import akka.http.scaladsl.server.Directives._
import akka.actor.ActorSystem
import akka.stream.Materializer

class Controller(blocking: BlockingApi, history: HistoryApi, sending: SendingApi, services: ServicesApi, status: StatusApi)(implicit system: ActorSystem, materializer: Materializer) {

    lazy val routes: Route = blocking.route ~ history.route ~ sending.route ~ services.route ~ status.route 

    Http().newServerAt("0.0.0.0", 9000).bind(routes)
}
