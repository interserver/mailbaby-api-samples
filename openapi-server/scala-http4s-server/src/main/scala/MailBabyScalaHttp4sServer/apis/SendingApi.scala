package MailBabyScalaHttp4sServer.apis

import MailBabyScalaHttp4sServer.apis.path._
import MailBabyScalaHttp4sServer.apis.query._

import MailBabyScalaHttp4sServer.models.EmailAddressTypes
import MailBabyScalaHttp4sServer.models.EmailAddressesTypes
import MailBabyScalaHttp4sServer.models.ErrorMessage
import MailBabyScalaHttp4sServer.models.GenericResponse
import MailBabyScalaHttp4sServer.models.MailAttachment
import MailBabyScalaHttp4sServer.models.SendMailRaw
import MailBabyScalaHttp4sServer.models.SendMailTo


import cats.Monad
import cats.syntax.all._

import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.headers._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityEncoder._

final case class SendingApiRoutes[
  F[_]: JsonDecoder: Monad, apiKeyAuth
](delegate: SendingApiDelegate[F, apiKeyAuth]) extends Http4sDsl[F] {
  object rawMail {
    import SendingApiDelegate.rawMailResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ POST -> Root / "mail" / "rawsend") as auth =>
      req.contentType match {
        case Some(`Content-Type`(MediaType.application.json, _)) =>
            delegate.rawMail.handle_apiKeyAuth(auth, req, req.asJsonDecode[SendMailRaw] , responses)

        case _ =>
          delegate.rawMail.handle_apiKeyAuth(auth, req, responses)

      }
    }

    val responses: rawMailResponses[F] = new rawMailResponses[F] {
      def resp200(value: GenericResponse): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }
  object sendAdvMail {
    import SendingApiDelegate.sendAdvMailResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ POST -> Root / "mail" / "advsend") as auth =>
      req.contentType match {
        case Some(`Content-Type`(MediaType.application.json, _)) =>
            delegate.sendAdvMail.handle_apiKeyAuth(auth, req, req.asJsonDecode[] , responses)

        case _ =>
          delegate.sendAdvMail.handle_apiKeyAuth(auth, req, responses)

      }
    }

    val responses: sendAdvMailResponses[F] = new sendAdvMailResponses[F] {
      def resp200(value: GenericResponse): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }
  object sendMail {
    import SendingApiDelegate.sendMailResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ POST -> Root / "mail" / "send") as auth =>
      req.contentType match {
        case Some(`Content-Type`(MediaType.application.json, _)) =>
            delegate.sendMail.handle_apiKeyAuth(auth, req, req.asJsonDecode[] , responses)

        case _ =>
          delegate.sendMail.handle_apiKeyAuth(auth, req, responses)

      }
    }

    val responses: sendMailResponses[F] = new sendMailResponses[F] {
      def resp200(value: GenericResponse): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }

  val routesapiKeyAuth =
    rawMail.routeapiKeyAuth <+>
    sendAdvMail.routeapiKeyAuth <+>
    sendMail.routeapiKeyAuth
}

object SendingApiDelegate {
  trait rawMailResponses[F[_]] {
    def resp200(value: GenericResponse): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

  trait sendAdvMailResponses[F[_]] {
    def resp200(value: GenericResponse): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

  trait sendMailResponses[F[_]] {
    def resp200(value: GenericResponse): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

}

trait SendingApiDelegate[F[_], apiKeyAuth] {

  trait rawMail {
    import SendingApiDelegate.rawMailResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      rawMail: F[SendMailRaw],
      responses: rawMailResponses[F]
    ): F[Response[F]]



    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: rawMailResponses[F]
    ): F[Response[F]]

  }
  def rawMail: rawMail


  trait sendAdvMail {
    import SendingApiDelegate.sendAdvMailResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      sendAdvMail: F[],
      responses: sendAdvMailResponses[F]
    ): F[Response[F]]



    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: sendAdvMailResponses[F]
    ): F[Response[F]]

  }
  def sendAdvMail: sendAdvMail


  trait sendMail {
    import SendingApiDelegate.sendMailResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      sendMail: F[],
      responses: sendMailResponses[F]
    ): F[Response[F]]



    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: sendMailResponses[F]
    ): F[Response[F]]

  }
  def sendMail: sendMail

}