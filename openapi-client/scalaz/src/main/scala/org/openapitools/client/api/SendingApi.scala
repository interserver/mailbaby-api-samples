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

import org.openapitools.client.api.EmailAddressTypes
import org.openapitools.client.api.EmailAddressesTypes
import org.openapitools.client.api.ErrorMessage
import org.openapitools.client.api.GenericResponse
import org.openapitools.client.api.MailAttachment

object SendingApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def sendAdvMail(host: String, subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: List[MailAttachment], id: Long): Task[GenericResponse] = {
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
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
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

}

class HttpServiceSendingApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def sendAdvMail(subject: String, body: String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: List[MailAttachment], id: Long): Task[GenericResponse] = {
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
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
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

}
