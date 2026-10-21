package MailBabyScalaHttp4sServer

import org.http4s.circe._
import cats.Monad
import cats.syntax.all._
import cats.data.OptionT
import cats.data.Kleisli
import org.http4s._
import org.http4s.server._

import MailBabyScalaHttp4sServer.apis._

final case class API [
  F[_]: JsonDecoder: Monad, apiKeyAuth
](
  apiKeyAuth: Kleisli[OptionT[F, *], Request[F], apiKeyAuth],
)(
  delegateBlockingApi: BlockingApiDelegate[F, apiKeyAuth],
  delegateHistoryApi: HistoryApiDelegate[F, apiKeyAuth],
  delegateSendingApi: SendingApiDelegate[F, apiKeyAuth],
  delegateServicesApi: ServicesApiDelegate[F, apiKeyAuth],
  delegateStatusApi: StatusApiDelegate[F],
){
  val apiKeyAuthMiddleware = AuthMiddleware(apiKeyAuth)

  val blockingApiRoutes = new BlockingApiRoutes(delegateBlockingApi)
  val historyApiRoutes = new HistoryApiRoutes(delegateHistoryApi)
  val sendingApiRoutes = new SendingApiRoutes(delegateSendingApi)
  val servicesApiRoutes = new ServicesApiRoutes(delegateServicesApi)
  val statusApiRoutes = new StatusApiRoutes(delegateStatusApi)

  val routes = 
    statusApiRoutes.routes
  
  val routesapiKeyAuth = apiKeyAuthMiddleware(
    blockingApiRoutes.routesapiKeyAuth <+>
      historyApiRoutes.routesapiKeyAuth <+>
      sendingApiRoutes.routesapiKeyAuth <+>
      servicesApiRoutes.routesapiKeyAuth
  )

  val routesAll =
    routes <+>
    routesapiKeyAuth
}
