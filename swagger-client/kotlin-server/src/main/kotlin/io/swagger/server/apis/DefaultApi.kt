/**
* Mail Baby API
* This is an API defintion for accesssing the Mail.Baby mail service.
*
* OpenAPI spec version: 1.0.0
* Contact: detain@interserver.net
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/package io.swagger.server.apis

import com.google.gson.Gson
import io.ktor.application.call
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authentication
import io.ktor.auth.authenticate
import io.ktor.auth.OAuthAccessTokenResponse
import io.ktor.auth.OAuthServerSettings
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.delete
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.locations.put
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.route

import io.swagger.server.Paths
import io.swagger.server.infrastructure.ApiPrincipal


import io.swagger.server.models.ErrorResponse
import io.swagger.server.models.GenericResponse
import io.swagger.server.models.MailLog
import io.swagger.server.models.MailOrder
import io.swagger.server.models.MailOrders
import io.swagger.server.models.SendMail

@KtorExperimentalLocationsAPI
fun Route.DefaultApi() {
    val gson = Gson()
    val empty = mutableMapOf<String, Any?>()
    get<Paths.getMailById> {  _: Paths.getMailById ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            val exampleContentType = "application/json"
            val exampleContentString = """{
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
}"""
            
            when(exampleContentType) {
                "application/json" -> call.respond(gson.fromJson(exampleContentString, empty::class.java))
                "application/xml" -> call.respondText(exampleContentString, ContentType.Text.Xml)
                else -> call.respondText(exampleContentString)
            }        }
    }
    get<Paths.getMailOrders> {  _: Paths.getMailOrders ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            val exampleContentType = "application/json"
            val exampleContentString = """[ {
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
}, {
  "password" : "guest123",
  "comment" : "main mail account",
  "id" : 1234,
  "status" : "active",
  "username" : "mb1234"
} ]"""
            
            when(exampleContentType) {
                "application/json" -> call.respond(gson.fromJson(exampleContentString, empty::class.java))
                "application/xml" -> call.respondText(exampleContentString, ContentType.Text.Xml)
                else -> call.respondText(exampleContentString)
            }        }
    }
    get<Paths.pingServer> {  _: Paths.pingServer ->
        call.respond(HttpStatusCode.NotImplemented)
    }
    post<Paths.placeMailOrder> {  _: Paths.placeMailOrder ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            call.respond(HttpStatusCode.NotImplemented)
        }
    }
    post<Paths.sendAdvMailById> {  _: Paths.sendAdvMailById ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            val exampleContentType = "application/json"
            val exampleContentString = """{
  "status_text" : "The command completed successfully.",
  "status" : "ok"
}"""
            
            when(exampleContentType) {
                "application/json" -> call.respond(gson.fromJson(exampleContentString, empty::class.java))
                "application/xml" -> call.respondText(exampleContentString, ContentType.Text.Xml)
                else -> call.respondText(exampleContentString)
            }        }
    }
    post<Paths.sendMailById> {  _: Paths.sendMailById ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            val exampleContentType = "application/json"
            val exampleContentString = """{
  "status_text" : "The command completed successfully.",
  "status" : "ok"
}"""
            
            when(exampleContentType) {
                "application/json" -> call.respond(gson.fromJson(exampleContentString, empty::class.java))
                "application/xml" -> call.respondText(exampleContentString, ContentType.Text.Xml)
                else -> call.respondText(exampleContentString)
            }        }
    }
    get<Paths.validateMailOrder> {  _: Paths.validateMailOrder ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            call.respond(HttpStatusCode.NotImplemented)
        }
    }
    get<Paths.viewMailLogById> {  _: Paths.viewMailLogById ->
        val principal = call.authentication.principal<ApiPrincipal>()
        if (principal == null) {
            call.respond(HttpStatusCode.Unauthorized)
        } else {
            val exampleContentType = "application/json"
            val exampleContentString = """[ {
  "id" : 0
}, {
  "id" : 0
} ]"""
            
            when(exampleContentType) {
                "application/json" -> call.respond(gson.fromJson(exampleContentString, empty::class.java))
                "application/xml" -> call.respondText(exampleContentString, ContentType.Text.Xml)
                else -> call.respondText(exampleContentString)
            }        }
    }
}