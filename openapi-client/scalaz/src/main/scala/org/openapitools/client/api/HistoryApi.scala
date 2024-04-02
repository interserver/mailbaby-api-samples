package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import java.io.File
import java.net.URLEncoder
import java.util.UUID

import org.http4s._
import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.http4s.client._
import org.http4s.client.blaze.PooledHttp1Client
import org.http4s.headers._

import org.joda.time.DateTime

import scalaz.concurrent.Task

import HelperCodecs._

import org.openapitools.client.api.ErrorMessage
import org.openapitools.client.api.GetStats200ResponseInner
import org.openapitools.client.api.MailLog

object HistoryApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getStats(host: String): Task[List[GetStats200ResponseInner]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GetStats200ResponseInner]] = jsonOf[List[GetStats200ResponseInner]]

    val path = "/mail/stats"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[GetStats200ResponseInner]](req)

    } yield resp
  }

  def viewMailLog(host: String, id: Long, origin: String, mx: String, from: String, to: String, subject: String, mailid: String, skip: Integer = 0, limit: Integer = 100, startDate: Long, endDate: Long, replyto: String, headerfrom: String)(implicit idQuery: QueryParam[Long], originQuery: QueryParam[String], mxQuery: QueryParam[String], fromQuery: QueryParam[String], toQuery: QueryParam[String], subjectQuery: QueryParam[String], mailidQuery: QueryParam[String], skipQuery: QueryParam[Integer], limitQuery: QueryParam[Integer], startDateQuery: QueryParam[Long], endDateQuery: QueryParam[Long], replytoQuery: QueryParam[String], headerfromQuery: QueryParam[String]): Task[MailLog] = {
    implicit val returnTypeDecoder: EntityDecoder[MailLog] = jsonOf[MailLog]

    val path = "/mail/log"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))), ("origin", Some(originQuery.toParamString(origin))), ("mx", Some(mxQuery.toParamString(mx))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))), ("subject", Some(subjectQuery.toParamString(subject))), ("mailid", Some(mailidQuery.toParamString(mailid))), ("skip", Some(skipQuery.toParamString(skip))), ("limit", Some(limitQuery.toParamString(limit))), ("startDate", Some(startDateQuery.toParamString(startDate))), ("endDate", Some(endDateQuery.toParamString(endDate))), ("replyto", Some(replytoQuery.toParamString(replyto))), ("headerfrom", Some(headerfromQuery.toParamString(headerfrom))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[MailLog](req)

    } yield resp
  }

}

class HttpServiceHistoryApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getStats(): Task[List[GetStats200ResponseInner]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GetStats200ResponseInner]] = jsonOf[List[GetStats200ResponseInner]]

    val path = "/mail/stats"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[GetStats200ResponseInner]](req)

    } yield resp
  }

  def viewMailLog(id: Long, origin: String, mx: String, from: String, to: String, subject: String, mailid: String, skip: Integer = 0, limit: Integer = 100, startDate: Long, endDate: Long, replyto: String, headerfrom: String)(implicit idQuery: QueryParam[Long], originQuery: QueryParam[String], mxQuery: QueryParam[String], fromQuery: QueryParam[String], toQuery: QueryParam[String], subjectQuery: QueryParam[String], mailidQuery: QueryParam[String], skipQuery: QueryParam[Integer], limitQuery: QueryParam[Integer], startDateQuery: QueryParam[Long], endDateQuery: QueryParam[Long], replytoQuery: QueryParam[String], headerfromQuery: QueryParam[String]): Task[MailLog] = {
    implicit val returnTypeDecoder: EntityDecoder[MailLog] = jsonOf[MailLog]

    val path = "/mail/log"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))), ("origin", Some(originQuery.toParamString(origin))), ("mx", Some(mxQuery.toParamString(mx))), ("from", Some(fromQuery.toParamString(from))), ("to", Some(toQuery.toParamString(to))), ("subject", Some(subjectQuery.toParamString(subject))), ("mailid", Some(mailidQuery.toParamString(mailid))), ("skip", Some(skipQuery.toParamString(skip))), ("limit", Some(limitQuery.toParamString(limit))), ("startDate", Some(startDateQuery.toParamString(startDate))), ("endDate", Some(endDateQuery.toParamString(endDate))), ("replyto", Some(replytoQuery.toParamString(replyto))), ("headerfrom", Some(headerfromQuery.toParamString(headerfrom))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[MailLog](req)

    } yield resp
  }

}
