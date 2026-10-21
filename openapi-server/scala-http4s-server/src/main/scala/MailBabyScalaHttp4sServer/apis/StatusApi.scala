package MailBabyScalaHttp4sServer.apis

import MailBabyScalaHttp4sServer.apis.path._
import MailBabyScalaHttp4sServer.apis.query._



import cats.Monad
import cats.syntax.all._

import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.headers._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityEncoder._

final case class StatusApiRoutes[
  F[_]: JsonDecoder: Monad
](delegate: StatusApiDelegate[F]) extends Http4sDsl[F] {
  object pingServer {
    import StatusApiDelegate.pingServerResponses


    val route = HttpRoutes.of[F] {
      case req @ GET -> Root / "ping" =>
        delegate.pingServer.handle(req, responses)

    }


    val responses: pingServerResponses[F] = new pingServerResponses[F] {
      def resp200(value: String): F[Response[F]] = Ok(value)
      def resp200(): F[Response[F]] = Ok()
      def resp200(): F[Response[F]] = Ok()
    }
  }

  val routes =
    pingServer.route
}

object StatusApiDelegate {
  trait pingServerResponses[F[_]] {
    def resp200(value: String): F[Response[F]]
    def resp200(): F[Response[F]]
    def resp200(): F[Response[F]]
  }

}

trait StatusApiDelegate[F[_]] {

  trait pingServer {
    import StatusApiDelegate.pingServerResponses

    def handle(
      req: Request[F],
      responses: pingServerResponses[F]
    ): F[Response[F]]

  }
  def pingServer: pingServer

}