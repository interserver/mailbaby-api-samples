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
 */
package io.swagger.client.apis

import io.swagger.client.models.ErrorResponse
import io.swagger.client.models.GenericResponse
import io.swagger.client.models.MailLog
import io.swagger.client.models.MailOrder
import io.swagger.client.models.MailOrders
import io.swagger.client.models.SendMail

import io.swagger.client.infrastructure.*

class DefaultApi(basePath: kotlin.String = "https://api.mailbaby.net/") : ApiClient(basePath) {

    /**
     * Gets mail order information by id
     * returns information about a mail order in the system with the given id.
     * @param id User ID 
     * @return MailOrder
     */
    @Suppress("UNCHECKED_CAST")
    fun getMailById(id: kotlin.Long): MailOrder {
        
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/mail/{id}".replace("{" + "id" + "}", "$id")
        )
        val response = request<MailOrder>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as MailOrder
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * displays a list of mail service orders
     * 
     * @return MailOrders
     */
    @Suppress("UNCHECKED_CAST")
    fun getMailOrders(): MailOrders {
        
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/mail"
        )
        val response = request<MailOrders>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as MailOrders
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * Checks if the server is running
     * 
     * @return void
     */
    fun pingServer(): Unit {
        
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/ping"
        )
        val response = request<Any?>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * places a mail order
     * Adds an item to the system
     * @param body Inventory item to add (optional)
     * @return void
     */
    fun placeMailOrder(body: MailOrder? = null): Unit {
        val localVariableBody: kotlin.Any? = body
        
        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/mail/order"
        )
        val response = request<Any?>(
                localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * @param body  
     * @param id User ID 
     * @return GenericResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun sendAdvMailById(body: SendMail, id: kotlin.Long): GenericResponse {
        val localVariableBody: kotlin.Any? = body
        
        val localVariableHeaders: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/mail/{id}/advsend".replace("{" + "id" + "}", "$id"), headers = localVariableHeaders
        )
        val response = request<GenericResponse>(
                localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GenericResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * @param id2  
     * @param id User ID 
     * @return GenericResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun sendAdvMailById(id2: kotlin.Long, id: kotlin.Long): GenericResponse {
        val localVariableBody: kotlin.Any? = mapOf("id" to "$id")
        
        val localVariableHeaders: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/mail/{id}/advsend".replace("{" + "id" + "}", "$id"), headers = localVariableHeaders
        )
        val response = request<GenericResponse>(
                localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GenericResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * @param body  
     * @param id User ID 
     * @return GenericResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun sendAdvMailById(body: SendMail, id: kotlin.Long): GenericResponse {
        val localVariableBody: kotlin.Any? = body
        
        val localVariableHeaders: kotlin.collections.Map<kotlin.String, kotlin.String> = mapOf("Content-Type" to "multipart/form-data")
        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/mail/{id}/advsend".replace("{" + "id" + "}", "$id"), headers = localVariableHeaders
        )
        val response = request<GenericResponse>(
                localVariableConfig, localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GenericResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * Sends an Email
     * Sends An email through one of your mail orders.
     * @param id User ID 
     * @param subject  (optional)
     * @param body  (optional)
     * @param to  (optional)
     * @param toName  (optional)
     * @param from  (optional)
     * @param fromName  (optional)
     * @return GenericResponse
     */
    @Suppress("UNCHECKED_CAST")
    fun sendMailById(id: kotlin.Long, subject: kotlin.String? = null, body: kotlin.String? = null, to: kotlin.String? = null, toName: kotlin.String? = null, from: kotlin.String? = null, fromName: kotlin.String? = null): GenericResponse {
        val localVariableQuery: MultiValueMap = mapOf("subject" to listOf("$subject"), "body" to listOf("$body"), "to" to listOf("$to"), "toName" to listOf("$toName"), "from" to listOf("$from"), "fromName" to listOf("$fromName"))
        val localVariableConfig = RequestConfig(
                RequestMethod.POST,
                "/mail/{id}/send".replace("{" + "id" + "}", "$id"), query = localVariableQuery
        )
        val response = request<GenericResponse>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as GenericResponse
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * validatess order details before placing an order
     * 
     * @return void
     */
    fun validateMailOrder(): Unit {
        
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/mail/order"
        )
        val response = request<Any?>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
    /**
     * displays the mail log
     * By passing in the appropriate options, you can search for available inventory in the system 
     * @param id User ID 
     * @param searchString pass an optional search string for looking up inventory (optional)
     * @param skip number of records to skip for pagination (optional)
     * @param limit maximum number of records to return (optional)
     * @return kotlin.Array<MailLog>
     */
    @Suppress("UNCHECKED_CAST")
    fun viewMailLogById(id: kotlin.Long, searchString: kotlin.String? = null, skip: kotlin.Int? = null, limit: kotlin.Int? = null): kotlin.Array<MailLog> {
        val localVariableQuery: MultiValueMap = mapOf("searchString" to listOf("$searchString"), "skip" to listOf("$skip"), "limit" to listOf("$limit"))
        val localVariableConfig = RequestConfig(
                RequestMethod.GET,
                "/mail/{id}/log".replace("{" + "id" + "}", "$id"), query = localVariableQuery
        )
        val response = request<kotlin.Array<MailLog>>(
                localVariableConfig
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as kotlin.Array<MailLog>
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }
}