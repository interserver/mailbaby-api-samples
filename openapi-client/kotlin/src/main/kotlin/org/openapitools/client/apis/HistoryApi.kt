/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.apis

import java.io.IOException
import okhttp3.Call
import okhttp3.HttpUrl

import org.openapitools.client.models.ErrorMessage
import org.openapitools.client.models.GetStats200ResponseInner
import org.openapitools.client.models.MailLog

import com.squareup.moshi.Json

import org.openapitools.client.infrastructure.ApiClient
import org.openapitools.client.infrastructure.ApiResponse
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.ClientError
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.infrastructure.ServerError
import org.openapitools.client.infrastructure.MultiValueMap
import org.openapitools.client.infrastructure.PartConfig
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod
import org.openapitools.client.infrastructure.ResponseType
import org.openapitools.client.infrastructure.Success
import org.openapitools.client.infrastructure.toMultiValue

class HistoryApi(basePath: kotlin.String = defaultBasePath, client: Call.Factory = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api.mailbaby.net")
        }
    }

    /**
     * GET /mail/stats
     * Account usage statistics.
     * Returns information about the usage on your mail accounts.
     * @return kotlin.collections.List<GetStats200ResponseInner>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getStats() : kotlin.collections.List<GetStats200ResponseInner> {
        val localVarResponse = getStatsWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<GetStats200ResponseInner>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * GET /mail/stats
     * Account usage statistics.
     * Returns information about the usage on your mail accounts.
     * @return ApiResponse<kotlin.collections.List<GetStats200ResponseInner>?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getStatsWithHttpInfo() : ApiResponse<kotlin.collections.List<GetStats200ResponseInner>?> {
        val localVariableConfig = getStatsRequestConfig()

        return request<Unit, kotlin.collections.List<GetStats200ResponseInner>>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getStats
     *
     * @return RequestConfig
     */
    fun getStatsRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/mail/stats",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * GET /mail/log
     * displays the mail log
     * Get a listing of the emails sent through this system 
     * @param id The ID of your mail order this will be sent through. (optional)
     * @param origin originating ip address sending mail (optional)
     * @param mx mx record mail was sent to (optional)
     * @param from from email address (optional)
     * @param to to/destination email address (optional)
     * @param subject subject containing this string (optional)
     * @param mailid mail id (optional)
     * @param skip number of records to skip for pagination (optional, default to 0)
     * @param limit maximum number of records to return (optional, default to 100)
     * @param startDate earliest date to get emails in unix timestamp format (optional)
     * @param endDate earliest date to get emails in unix timestamp format (optional)
     * @param replyto Reply-To Email Address (optional)
     * @param headerfrom Header From Email Address (optional)
     * @return MailLog
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun viewMailLog(id: kotlin.Long? = null, origin: kotlin.String? = null, mx: kotlin.String? = null, from: kotlin.String? = null, to: kotlin.String? = null, subject: kotlin.String? = null, mailid: kotlin.String? = null, skip: kotlin.Int? = 0, limit: kotlin.Int? = 100, startDate: kotlin.Long? = null, endDate: kotlin.Long? = null, replyto: kotlin.String? = null, headerfrom: kotlin.String? = null) : MailLog {
        val localVarResponse = viewMailLogWithHttpInfo(id = id, origin = origin, mx = mx, from = from, to = to, subject = subject, mailid = mailid, skip = skip, limit = limit, startDate = startDate, endDate = endDate, replyto = replyto, headerfrom = headerfrom)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as MailLog
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * GET /mail/log
     * displays the mail log
     * Get a listing of the emails sent through this system 
     * @param id The ID of your mail order this will be sent through. (optional)
     * @param origin originating ip address sending mail (optional)
     * @param mx mx record mail was sent to (optional)
     * @param from from email address (optional)
     * @param to to/destination email address (optional)
     * @param subject subject containing this string (optional)
     * @param mailid mail id (optional)
     * @param skip number of records to skip for pagination (optional, default to 0)
     * @param limit maximum number of records to return (optional, default to 100)
     * @param startDate earliest date to get emails in unix timestamp format (optional)
     * @param endDate earliest date to get emails in unix timestamp format (optional)
     * @param replyto Reply-To Email Address (optional)
     * @param headerfrom Header From Email Address (optional)
     * @return ApiResponse<MailLog?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun viewMailLogWithHttpInfo(id: kotlin.Long?, origin: kotlin.String?, mx: kotlin.String?, from: kotlin.String?, to: kotlin.String?, subject: kotlin.String?, mailid: kotlin.String?, skip: kotlin.Int?, limit: kotlin.Int?, startDate: kotlin.Long?, endDate: kotlin.Long?, replyto: kotlin.String?, headerfrom: kotlin.String?) : ApiResponse<MailLog?> {
        val localVariableConfig = viewMailLogRequestConfig(id = id, origin = origin, mx = mx, from = from, to = to, subject = subject, mailid = mailid, skip = skip, limit = limit, startDate = startDate, endDate = endDate, replyto = replyto, headerfrom = headerfrom)

        return request<Unit, MailLog>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation viewMailLog
     *
     * @param id The ID of your mail order this will be sent through. (optional)
     * @param origin originating ip address sending mail (optional)
     * @param mx mx record mail was sent to (optional)
     * @param from from email address (optional)
     * @param to to/destination email address (optional)
     * @param subject subject containing this string (optional)
     * @param mailid mail id (optional)
     * @param skip number of records to skip for pagination (optional, default to 0)
     * @param limit maximum number of records to return (optional, default to 100)
     * @param startDate earliest date to get emails in unix timestamp format (optional)
     * @param endDate earliest date to get emails in unix timestamp format (optional)
     * @param replyto Reply-To Email Address (optional)
     * @param headerfrom Header From Email Address (optional)
     * @return RequestConfig
     */
    fun viewMailLogRequestConfig(id: kotlin.Long?, origin: kotlin.String?, mx: kotlin.String?, from: kotlin.String?, to: kotlin.String?, subject: kotlin.String?, mailid: kotlin.String?, skip: kotlin.Int?, limit: kotlin.Int?, startDate: kotlin.Long?, endDate: kotlin.Long?, replyto: kotlin.String?, headerfrom: kotlin.String?) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
            .apply {
                if (id != null) {
                    put("id", listOf(id.toString()))
                }
                if (origin != null) {
                    put("origin", listOf(origin.toString()))
                }
                if (mx != null) {
                    put("mx", listOf(mx.toString()))
                }
                if (from != null) {
                    put("from", listOf(from.toString()))
                }
                if (to != null) {
                    put("to", listOf(to.toString()))
                }
                if (subject != null) {
                    put("subject", listOf(subject.toString()))
                }
                if (mailid != null) {
                    put("mailid", listOf(mailid.toString()))
                }
                if (skip != null) {
                    put("skip", listOf(skip.toString()))
                }
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (startDate != null) {
                    put("startDate", listOf(startDate.toString()))
                }
                if (endDate != null) {
                    put("endDate", listOf(endDate.toString()))
                }
                if (replyto != null) {
                    put("replyto", listOf(replyto.toString()))
                }
                if (headerfrom != null) {
                    put("headerfrom", listOf(headerfrom.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/mail/log",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
