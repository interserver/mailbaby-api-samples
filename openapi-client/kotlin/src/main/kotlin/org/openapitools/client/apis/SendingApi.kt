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
import okhttp3.OkHttpClient
import okhttp3.HttpUrl

import org.openapitools.client.models.EmailAddressTypes
import org.openapitools.client.models.EmailAddressesTypes
import org.openapitools.client.models.ErrorMessage
import org.openapitools.client.models.GenericResponse
import org.openapitools.client.models.MailAttachment

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

class SendingApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://api.mailbaby.net")
        }
    }

    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#39; &#x60;&#x60;&#x60; 
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param from 
     * @param to 
     * @param replyto  (optional)
     * @param cc  (optional)
     * @param bcc  (optional)
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
     * @return GenericResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun sendAdvMail(subject: kotlin.String, body: kotlin.String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes? = null, cc: EmailAddressesTypes? = null, bcc: EmailAddressesTypes? = null, attachments: kotlin.collections.List<MailAttachment>? = null, id: kotlin.Long? = null) : GenericResponse {
        val localVarResponse = sendAdvMailWithHttpInfo(subject = subject, body = body, from = from, to = to, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments, id = id)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GenericResponse
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
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/x-www-form-urlencoded&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;subject&#x3D;Welcome&#39; \\ --data &#39;body&#x3D;Hello&#39; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#39; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60; curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#39;Accept: application/json&#39; \\ --header &#39;Content-Type: application/json&#39; \\ --header &#39;X-API-KEY: YOUR_API_KEY&#39; \\ --data &#39;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#39; &#x60;&#x60;&#x60; 
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param from 
     * @param to 
     * @param replyto  (optional)
     * @param cc  (optional)
     * @param bcc  (optional)
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
     * @return ApiResponse<GenericResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun sendAdvMailWithHttpInfo(subject: kotlin.String, body: kotlin.String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes?, cc: EmailAddressesTypes?, bcc: EmailAddressesTypes?, attachments: kotlin.collections.List<MailAttachment>?, id: kotlin.Long?) : ApiResponse<GenericResponse?> {
        val localVariableConfig = sendAdvMailRequestConfig(subject = subject, body = body, from = from, to = to, replyto = replyto, cc = cc, bcc = bcc, attachments = attachments, id = id)

        return request<Map<String, PartConfig<*>>, GenericResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation sendAdvMail
     *
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param from 
     * @param to 
     * @param replyto  (optional)
     * @param cc  (optional)
     * @param bcc  (optional)
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional)
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account. (optional)
     * @return RequestConfig
     */
    fun sendAdvMailRequestConfig(subject: kotlin.String, body: kotlin.String, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes?, cc: EmailAddressesTypes?, bcc: EmailAddressesTypes?, attachments: kotlin.collections.List<MailAttachment>?, id: kotlin.Long?) : RequestConfig<Map<String, PartConfig<*>>> {
        val localVariableBody = mapOf(
            "subject" to PartConfig(body = subject, headers = mutableMapOf()),
            "body" to PartConfig(body = body, headers = mutableMapOf()),
            "from" to PartConfig(body = from, headers = mutableMapOf()),
            "to" to PartConfig(body = to, headers = mutableMapOf()),
            "replyto" to PartConfig(body = replyto, headers = mutableMapOf()),
            "cc" to PartConfig(body = cc, headers = mutableMapOf()),
            "bcc" to PartConfig(body = bcc, headers = mutableMapOf()),
            "attachments" to PartConfig(body = attachments, headers = mutableMapOf()),
            "id" to PartConfig(body = id, headers = mutableMapOf()),)
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/x-www-form-urlencoded")
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/mail/advsend",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }

    /**
     * Sends an Email
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @param to The Contact whom is the primary recipient of this email.
     * @param from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @return GenericResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun sendMail(to: kotlin.String, from: kotlin.String, subject: kotlin.String, body: kotlin.String) : GenericResponse {
        val localVarResponse = sendMailWithHttpInfo(to = to, from = from, subject = subject, body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as GenericResponse
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
     * Sends an Email
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @param to The Contact whom is the primary recipient of this email.
     * @param from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @return ApiResponse<GenericResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun sendMailWithHttpInfo(to: kotlin.String, from: kotlin.String, subject: kotlin.String, body: kotlin.String) : ApiResponse<GenericResponse?> {
        val localVariableConfig = sendMailRequestConfig(to = to, from = from, subject = subject, body = body)

        return request<Map<String, PartConfig<*>>, GenericResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation sendMail
     *
     * @param to The Contact whom is the primary recipient of this email.
     * @param from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @return RequestConfig
     */
    fun sendMailRequestConfig(to: kotlin.String, from: kotlin.String, subject: kotlin.String, body: kotlin.String) : RequestConfig<Map<String, PartConfig<*>>> {
        val localVariableBody = mapOf(
            "to" to PartConfig(body = to, headers = mutableMapOf()),
            "from" to PartConfig(body = from, headers = mutableMapOf()),
            "subject" to PartConfig(body = subject, headers = mutableMapOf()),
            "body" to PartConfig(body = body, headers = mutableMapOf()),)
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf("Content-Type" to "application/x-www-form-urlencoded")
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/mail/send",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}