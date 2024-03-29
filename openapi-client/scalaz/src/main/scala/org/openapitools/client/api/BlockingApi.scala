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

import org.openapitools.client.api.DenyRuleRecord
import org.openapitools.client.api.ErrorMessage
import org.openapitools.client.api.GenericResponse
import org.openapitools.client.api.MailBlocks

object BlockingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def addRule(host: String, `type`: String, data: String, user: String): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/rules"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def deleteRule(host: String, ruleId: Integer): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/rules/{ruleId}".replaceAll("\\{" + "ruleId" + "\\}",escape(ruleId.toString))

    val httpMethod = Method.DELETE
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def delistBlock(host: String, body: String): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/blocks/delete"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def getMailBlocks(host: String): Task[MailBlocks] = {
    implicit val returnTypeDecoder: EntityDecoder[MailBlocks] = jsonOf[MailBlocks]

    val path = "/mail/blocks"

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
      resp          <- client.expect[MailBlocks](req)

    } yield resp
  }

  def getRules(host: String): Task[List[DenyRuleRecord]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DenyRuleRecord]] = jsonOf[List[DenyRuleRecord]]

    val path = "/mail/rules"

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
      resp          <- client.expect[List[DenyRuleRecord]](req)

    } yield resp
  }

}

class HttpServiceBlockingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def addRule(`type`: String, data: String, user: String): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/rules"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def deleteRule(ruleId: Integer): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/rules/{ruleId}".replaceAll("\\{" + "ruleId" + "\\}",escape(ruleId.toString))

    val httpMethod = Method.DELETE
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def delistBlock(body: String): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/blocks/delete"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(body)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def getMailBlocks(): Task[MailBlocks] = {
    implicit val returnTypeDecoder: EntityDecoder[MailBlocks] = jsonOf[MailBlocks]

    val path = "/mail/blocks"

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
      resp          <- client.expect[MailBlocks](req)

    } yield resp
  }

  def getRules(): Task[List[DenyRuleRecord]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[DenyRuleRecord]] = jsonOf[List[DenyRuleRecord]]

    val path = "/mail/rules"

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
      resp          <- client.expect[List[DenyRuleRecord]](req)

    } yield resp
  }

}
