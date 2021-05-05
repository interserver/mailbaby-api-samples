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

import org.openapitools.client.api.ErrorResponse
import org.openapitools.client.api.GenericResponse
import org.openapitools.client.api.MailLog
import org.openapitools.client.api.MailOrder
import org.openapitools.client.api.SendMail

object DefaultApi {

  val client = PooledHttp1Client()

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getMailOrders(host: String, id: Long)(implicit idQuery: QueryParam[Long]): Task[List[MailOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MailOrder]] = jsonOf[List[MailOrder]]

    val path = "/mail"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[MailOrder]](req)

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
  
  def placeMailOrder(host: String, mailOrder: MailOrder): Task[Unit] = {
    val path = "/mail/order"
    
    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(mailOrder)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }
  
  def sendAdvMailById(host: String, sendMail: SendMail): Task[GenericResponse] = {
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
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMail)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }
  
  def sendMailById(host: String, sendMail: SendMail): Task[GenericResponse] = {
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
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMail)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }
  
  def validateMailOrder(host: String): Task[Unit] = {
    val path = "/mail/order"
    
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
  
  def viewMailLogById(host: String, id: Long, searchString: String, skip: Integer, limit: Integer)(implicit idQuery: QueryParam[Long], searchStringQuery: QueryParam[String], skipQuery: QueryParam[Integer], limitQuery: QueryParam[Integer]): Task[List[MailLog]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MailLog]] = jsonOf[List[MailLog]]

    val path = "/mail/log"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))), ("searchString", Some(searchStringQuery.toParamString(searchString))), ("skip", Some(skipQuery.toParamString(skip))), ("limit", Some(limitQuery.toParamString(limit))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(host + path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[MailLog]](req)

    } yield resp
  }
  
}

class HttpServiceDefaultApi(service: HttpService) {
  val client = Client.fromHttpService(service)

  def escape(value: String): String = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20")

  def getMailOrders(id: Long)(implicit idQuery: QueryParam[Long]): Task[List[MailOrder]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MailOrder]] = jsonOf[List[MailOrder]]

    val path = "/mail"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[MailOrder]](req)

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
  
  def placeMailOrder(mailOrder: MailOrder): Task[Unit] = {
    val path = "/mail/order"
    
    val httpMethod = Method.POST
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      )

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(mailOrder)
      resp          <- client.fetch[Unit](req)(_ => Task.now(()))

    } yield resp
  }
  
  def sendAdvMailById(sendMail: SendMail): Task[GenericResponse] = {
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
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMail)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }
  
  def sendMailById(sendMail: SendMail): Task[GenericResponse] = {
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
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType)).withBody(sendMail)
      resp          <- client.expect[GenericResponse](req)

    } yield resp
  }
  
  def validateMailOrder(): Task[Unit] = {
    val path = "/mail/order"
    
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
  
  def viewMailLogById(id: Long, searchString: String, skip: Integer, limit: Integer)(implicit idQuery: QueryParam[Long], searchStringQuery: QueryParam[String], skipQuery: QueryParam[Integer], limitQuery: QueryParam[Integer]): Task[List[MailLog]] = {
    implicit val returnTypeDecoder: EntityDecoder[List[MailLog]] = jsonOf[List[MailLog]]

    val path = "/mail/log"
    
    val httpMethod = Method.GET
    val contentType = `Content-Type`(MediaType.`application/json`)
    val headers = Headers(
      )
    val queryParams = Query(
      ("id", Some(idQuery.toParamString(id))), ("searchString", Some(searchStringQuery.toParamString(searchString))), ("skip", Some(skipQuery.toParamString(skip))), ("limit", Some(limitQuery.toParamString(limit))))

    for {
      uri           <- Task.fromDisjunction(Uri.fromString(path))
      uriWithParams =  uri.copy(query = queryParams)
      req           =  Request(method = httpMethod, uri = uriWithParams, headers = headers.put(contentType))
      resp          <- client.expect[List[MailLog]](req)

    } yield resp
  }
  
}
