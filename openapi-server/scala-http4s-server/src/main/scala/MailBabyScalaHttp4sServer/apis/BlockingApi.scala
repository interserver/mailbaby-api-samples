package MailBabyScalaHttp4sServer.apis

import MailBabyScalaHttp4sServer.apis.path._
import MailBabyScalaHttp4sServer.apis.query._

import MailBabyScalaHttp4sServer.models.DenyRuleRecord
import MailBabyScalaHttp4sServer.models.EmailAddressParam
import MailBabyScalaHttp4sServer.models.ErrorMessage
import MailBabyScalaHttp4sServer.models.GenericResponse
import MailBabyScalaHttp4sServer.models.MailBlocks


import cats.Monad
import cats.syntax.all._

import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.headers._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityEncoder._

final case class BlockingApiRoutes[
  F[_]: JsonDecoder: Monad, apiKeyAuth
](delegate: BlockingApiDelegate[F, apiKeyAuth]) extends Http4sDsl[F] {
  object addRule {
    import BlockingApiDelegate.addRuleResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ POST -> Root / "mail" / "rules") as auth =>
      req.contentType match {
        case Some(`Content-Type`(MediaType.application.json, _)) =>
            delegate.addRule.handle_apiKeyAuth(auth, req, req.asJsonDecode[] , responses)

        case _ =>
          delegate.addRule.handle_apiKeyAuth(auth, req, responses)

      }
    }

    val responses: addRuleResponses[F] = new addRuleResponses[F] {
      def resp200(value: GenericResponse): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }
  object deleteRule {
    import BlockingApiDelegate.deleteRuleResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ DELETE -> Root / "mail" / "rules" / IntVarr(ruleId)) as auth =>
        delegate.deleteRule.handle_apiKeyAuth(auth, req, ruleId, responses)

    }

    val responses: deleteRuleResponses[F] = new deleteRuleResponses[F] {
      def resp200(value: GenericResponse): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }
  object delistBlock {
    import BlockingApiDelegate.delistBlockResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ POST -> Root / "mail" / "blocks" / "delete") as auth =>
      req.contentType match {
        case Some(`Content-Type`(MediaType.application.json, _)) =>
            delegate.delistBlock.handle_apiKeyAuth(auth, req, req.asJsonDecode[EmailAddressParam] , responses)

        case _ =>
          delegate.delistBlock.handle_apiKeyAuth(auth, req, responses)

      }
    }

    val responses: delistBlockResponses[F] = new delistBlockResponses[F] {
      def resp200(value: GenericResponse): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
      def resp404(value: ErrorMessage): F[Response[F]] = NotFound(value)
    }
  }
  object getMailBlocks {
    import BlockingApiDelegate.getMailBlocksResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ GET -> Root / "mail" / "blocks") as auth =>
        delegate.getMailBlocks.handle_apiKeyAuth(auth, req, responses)

    }

    val responses: getMailBlocksResponses[F] = new getMailBlocksResponses[F] {
      def resp200(value: MailBlocks): F[Response[F]] = Ok(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
    }
  }
  object getRules {
    import BlockingApiDelegate.getRulesResponses


    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ GET -> Root / "mail" / "rules") as auth =>
        delegate.getRules.handle_apiKeyAuth(auth, req, responses)

    }

    val responses: getRulesResponses[F] = new getRulesResponses[F] {
      def resp200(value: List[DenyRuleRecord]): F[Response[F]] = Ok(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
    }
  }

  val routesapiKeyAuth =
    addRule.routeapiKeyAuth <+>
    deleteRule.routeapiKeyAuth <+>
    delistBlock.routeapiKeyAuth <+>
    getMailBlocks.routeapiKeyAuth <+>
    getRules.routeapiKeyAuth
}

object BlockingApiDelegate {
  trait addRuleResponses[F[_]] {
    def resp200(value: GenericResponse): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

  trait deleteRuleResponses[F[_]] {
    def resp200(value: GenericResponse): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

  trait delistBlockResponses[F[_]] {
    def resp200(value: GenericResponse): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
    def resp404(value: ErrorMessage): F[Response[F]]
  }

  trait getMailBlocksResponses[F[_]] {
    def resp200(value: MailBlocks): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
  }

  trait getRulesResponses[F[_]] {
    def resp200(value: List[DenyRuleRecord]): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
  }

}

trait BlockingApiDelegate[F[_], apiKeyAuth] {

  trait addRule {
    import BlockingApiDelegate.addRuleResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      addRule: F[],
      responses: addRuleResponses[F]
    ): F[Response[F]]



    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: addRuleResponses[F]
    ): F[Response[F]]

  }
  def addRule: addRule


  trait deleteRule {
    import BlockingApiDelegate.deleteRuleResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      ruleId: Int,
      responses: deleteRuleResponses[F]
    ): F[Response[F]]

  }
  def deleteRule: deleteRule


  trait delistBlock {
    import BlockingApiDelegate.delistBlockResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      delistBlock: F[EmailAddressParam],
      responses: delistBlockResponses[F]
    ): F[Response[F]]



    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: delistBlockResponses[F]
    ): F[Response[F]]

  }
  def delistBlock: delistBlock


  trait getMailBlocks {
    import BlockingApiDelegate.getMailBlocksResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: getMailBlocksResponses[F]
    ): F[Response[F]]

  }
  def getMailBlocks: getMailBlocks


  trait getRules {
    import BlockingApiDelegate.getRulesResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      responses: getRulesResponses[F]
    ): F[Response[F]]

  }
  def getRules: getRules

}