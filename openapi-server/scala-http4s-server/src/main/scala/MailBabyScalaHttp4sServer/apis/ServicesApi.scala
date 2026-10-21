package MailBabyScalaHttp4sServer.apis

import MailBabyScalaHttp4sServer.apis.path._
import MailBabyScalaHttp4sServer.apis.query._

import MailBabyScalaHttp4sServer.models.ErrorMessage
import MailBabyScalaHttp4sServer.models.MailOrder
import MailBabyScalaHttp4sServer.models.MailOrderDetail


import cats.Monad
import cats.syntax.all._

import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.headers._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityEncoder._

final case class ServicesApiRoutes[
  F[_]: JsonDecoder: Monad, apiKeyAuth
](delegate: ServicesApiDelegate[F, apiKeyAuth]) extends Http4sDsl[F] {
  object getMailOrderById {
    import ServicesApiDelegate.getMailOrderByIdResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ GET -> Root / "mail" / LongVarr(id)) as auth =>
        delegate.getMailOrderById.handle_apiKeyAuth(auth, req, id, responses)

    }

    val responses: getMailOrderByIdResponses[F] = new getMailOrderByIdResponses[F] {
      def resp200(value: MailOrderDetail): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }
  object getMailOrders {
    import ServicesApiDelegate.getMailOrdersResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ GET -> Root / "mail") as auth =>
        delegate.getMailOrders.handle_apiKeyAuth(auth, req, responses)

    }

    val responses: getMailOrdersResponses[F] = new getMailOrdersResponses[F] {
      def resp200(value: List[MailOrder]): F[Response[F]] = Ok(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
    }
  }

  val routesapiKeyAuth =
    getMailOrderById.routeapiKeyAuth <+>
    getMailOrders.routeapiKeyAuth
}

object ServicesApiDelegate {
  trait getMailOrderByIdResponses[F[_]] {
    def resp200(value: MailOrderDetail): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

  trait getMailOrdersResponses[F[_]] {
    def resp200(value: List[MailOrder]): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
  }

}

trait ServicesApiDelegate[F[_], apiKeyAuth] {

  trait getMailOrderById {
    import ServicesApiDelegate.getMailOrderByIdResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      id: Long,
      responses: getMailOrderByIdResponses[F]
    ): F[Response[F]]

  }
  def getMailOrderById: getMailOrderById


  trait getMailOrders {
    import ServicesApiDelegate.getMailOrdersResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: getMailOrdersResponses[F]
    ): F[Response[F]]

  }
  def getMailOrders: getMailOrders

}