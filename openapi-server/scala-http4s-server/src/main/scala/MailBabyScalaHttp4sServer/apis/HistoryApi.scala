package MailBabyScalaHttp4sServer.apis

import MailBabyScalaHttp4sServer.apis.path._
import MailBabyScalaHttp4sServer.apis.query._

import MailBabyScalaHttp4sServer.models.ErrorMessage
import MailBabyScalaHttp4sServer.models.MailLog
import MailBabyScalaHttp4sServer.models.MailStatsType

import eu.timepit.refined.api.Refined
import eu.timepit.refined.boolean.And
import eu.timepit.refined.collection.MaxSize
import eu.timepit.refined.collection.MinSize
import eu.timepit.refined.numeric.GreaterEqual
import eu.timepit.refined.numeric.LessEqual

import cats.Monad
import cats.syntax.all._

import org.http4s._
import org.http4s.circe._
import org.http4s.server._
import org.http4s.headers._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe.CirceEntityEncoder._

final case class HistoryApiRoutes[
  F[_]: JsonDecoder: Monad, apiKeyAuth
](delegate: HistoryApiDelegate[F, apiKeyAuth]) extends Http4sDsl[F] {
  object getStats {
    import HistoryApiDelegate.getStatsResponses

    object timeQueryParam extends OptionalQueryParamDecoderMatcher[String]("time")

    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ GET -> Root / "mail" / "stats" :? timeQueryParam(time)) as auth =>
        delegate.getStats.handle_apiKeyAuth(auth, req, time, responses)

    }

    val responses: getStatsResponses[F] = new getStatsResponses[F] {
      def resp200(value: MailStatsType): F[Response[F]] = Ok(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
    }
  }
  object viewMailLog {
    import HistoryApiDelegate.viewMailLogResponses

    object idQueryParam extends OptionalQueryParamDecoderMatcher[Long]("id")
    object originQueryParam extends OptionalQueryParamDecoderMatcher[String]("origin")
    object mxQueryParam extends OptionalQueryParamDecoderMatcher[String]("mx")
    object fromQueryParam extends OptionalQueryParamDecoderMatcher[String]("from")
    object toQueryParam extends OptionalQueryParamDecoderMatcher[String]("to")
    object subjectQueryParam extends OptionalQueryParamDecoderMatcher[String]("subject")
    object mailidQueryParam extends OptionalQueryParamDecoderMatcher[Refined[String, MinSize[18] And MaxSize[19]]]("mailid")
    object messageIdQueryParam extends OptionalQueryParamDecoderMatcher[String]("messageId")
    object replytoQueryParam extends OptionalQueryParamDecoderMatcher[String]("replyto")
    object headerfromQueryParam extends OptionalQueryParamDecoderMatcher[String]("headerfrom")
    object deliveredQueryParam extends OptionalQueryParamDecoderMatcher[Int]("delivered")
    object skipQueryParam extends OptionalQueryParamDecoderMatcher[Refined[Int, GreaterEqual[0]]]("skip")
    object limitQueryParam extends OptionalQueryParamDecoderMatcher[Refined[Int, GreaterEqual[1] And LessEqual[10000]]]("limit")
    object startDateQueryParam extends OptionalQueryParamDecoderMatcher[String]("startDate")
    object endDateQueryParam extends OptionalQueryParamDecoderMatcher[String]("endDate")
    object sortQueryParam extends OptionalQueryParamDecoderMatcher[String]("sort")
    object dirQueryParam extends OptionalQueryParamDecoderMatcher[String]("dir")
    object groupbyQueryParam extends OptionalQueryParamDecoderMatcher[String]("groupby")

    val routeapiKeyAuth = AuthedRoutes.of[apiKeyAuth, F] {
      case (req @ GET -> Root / "mail" / "log" :? idQueryParam(id) +& originQueryParam(origin) +& mxQueryParam(mx) +& fromQueryParam(from) +& toQueryParam(to) +& subjectQueryParam(subject) +& mailidQueryParam(mailid) +& messageIdQueryParam(messageId) +& replytoQueryParam(replyto) +& headerfromQueryParam(headerfrom) +& deliveredQueryParam(delivered) +& skipQueryParam(skip) +& limitQueryParam(limit) +& startDateQueryParam(startDate) +& endDateQueryParam(endDate) +& sortQueryParam(sort) +& dirQueryParam(dir) +& groupbyQueryParam(groupby)) as auth =>
        delegate.viewMailLog.handle_apiKeyAuth(auth, req, id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby, responses)

    }

    val responses: viewMailLogResponses[F] = new viewMailLogResponses[F] {
      def resp200(value: MailLog): F[Response[F]] = Ok(value)
      def resp400(value: ErrorMessage): F[Response[F]] = BadRequest(value)
      def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]] = Unauthorized(authenticate, value)
    }
  }

  val routesapiKeyAuth =
    getStats.routeapiKeyAuth <+>
    viewMailLog.routeapiKeyAuth
}

object HistoryApiDelegate {
  trait getStatsResponses[F[_]] {
    def resp200(value: MailStatsType): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
  }

  trait viewMailLogResponses[F[_]] {
    def resp200(value: MailLog): F[Response[F]]
    def resp400(value: ErrorMessage): F[Response[F]]
    def resp401(authenticate: `WWW-Authenticate`, value: ErrorMessage): F[Response[F]]
  }

}

trait HistoryApiDelegate[F[_], apiKeyAuth] {

  trait getStats {
    import HistoryApiDelegate.getStatsResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      time: Option[String],
      responses: getStatsResponses[F]
    ): F[Response[F]]

  }
  def getStats: getStats


  trait viewMailLog {
    import HistoryApiDelegate.viewMailLogResponses


    def handle_apiKeyAuth(
      auth: apiKeyAuth,
      req: Request[F],
      id: Option[Long],
      origin: Option[String],
      mx: Option[String],
      from: Option[String],
      to: Option[String],
      subject: Option[String],
      mailid: Option[Refined[String, MinSize[18] And MaxSize[19]]],
      messageId: Option[String],
      replyto: Option[String],
      headerfrom: Option[String],
      delivered: Option[Int],
      skip: Option[Refined[Int, GreaterEqual[0]]],
      limit: Option[Refined[Int, GreaterEqual[1] And LessEqual[10000]]],
      startDate: Option[String],
      endDate: Option[String],
      sort: Option[String],
      dir: Option[String],
      groupby: Option[String],
      responses: viewMailLogResponses[F]
    ): F[Response[F]]

  }
  def viewMailLog: viewMailLog

}