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

import org.openapitools.client.api.GenericResponse
import org.openapitools.client.api.GetMailOrders200ResponseInner
import org.openapitools.client.api.GetMailOrders401Response
import org.openapitools.client.api.MailLog
import org.openapitools.client.api.SendMailAdv

object DefaultApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getMailOrders(host: String): Task[List[GetMailOrders200ResponseInner]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GetMailOrders200ResponseInner]] = jsonOf[List[GetMailOrders200ResponseInner]]

    val path = "/mail"

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
      resp          <- client.expect[List[GetMailOrders200ResponseInner]](req)

    } yield resp
  }

  def pingServer(host: String): Task[Unit] = {
    val path = "/ping"

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def sendAdvMail(host: String, sendMailAdv: SendMailAdv): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/advsend"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMailAdv)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def sendMail(host: String, to: String, from: String, subject: String, body: String): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/send"

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

  def viewMailLog(host: String, id: Long, search: String, skip: Integer = 0, limit: Integer = 100)(implicit idQuery: QueryParam[Long], searchQuery: QueryParam[String], skipQuery: QueryParam[Integer], limitQuery: QueryParam[Integer]): Task[MailLog] = {
    implicit val returnTypeDecoder: EntityDecoder[MailLog] = jsonOf[MailLog]

    val path = "/mail/log"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))), ("search", Some(searchQuery.toParamString(search))), ("skip", Some(skipQuery.toParamString(skip))), ("limit", Some(limitQuery.toParamString(limit))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[MailLog](req)

    } yield resp
  }

}

class HttpServiceDefaultApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getMailOrders(): Task[List[GetMailOrders200ResponseInner]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[GetMailOrders200ResponseInner]] = jsonOf[List[GetMailOrders200ResponseInner]]

    val path = "/mail"

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
      resp          <- client.expect[List[GetMailOrders200ResponseInner]](req)

    } yield resp
  }

  def pingServer(): Task[Unit] = {
    val path = "/ping"

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
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }

  def sendAdvMail(sendMailAdv: SendMailAdv): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/advsend"

    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMailAdv)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }

  def sendMail(to: String, from: String, subject: String, body: String): Task[GenericResponse] = {
    implicit val returnTypeDecoder: EntityDecoder[GenericResponse] = jsonOf[GenericResponse]

    val path = "/mail/send"

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

  def viewMailLog(id: Long, search: String, skip: Integer = 0, limit: Integer = 100)(implicit idQuery: QueryParam[Long], searchQuery: QueryParam[String], skipQuery: QueryParam[Integer], limitQuery: QueryParam[Integer]): Task[MailLog] = {
    implicit val returnTypeDecoder: EntityDecoder[MailLog] = jsonOf[MailLog]

    val path = "/mail/log"

    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))), ("search", Some(searchQuery.toParamString(search))), ("skip", Some(skipQuery.toParamString(skip))), ("limit", Some(limitQuery.toParamString(limit))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[MailLog](req)

    } yield resp
  }

}
