@file:Suppress(
    "RemoveRedundantQualifierName",
    "UnusedImport",
    "unused",
)

package MailBabyKotlinWiremock.apis

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.matching.StringValuePattern
import MailBabyKotlinWiremock.models.*

/**
 *  Builder for WireMock stubs of operation getMailOrderById.
 */
class GetMailOrderByIdStubBuilder internal constructor(private val objectMapper: ObjectMapper, private val stub: MappingBuilder) {

    /**
     * Let the stub for getMailOrderById respond with HTTP status code 200.
     *
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith200(
        body: MailOrderDetail,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this },
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(body))
            .configurer()
        )

    /**
     * Let the stub for getMailOrderById respond with HTTP status code 400.
     *
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith400(
        body: ErrorMessage,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this },
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(400)
            .withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(body))
            .configurer()
        )

    /**
     * Let the stub for getMailOrderById respond with HTTP status code 401.
     *
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith401(
        body: ErrorMessage,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this },
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(401)
            .withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(body))
            .configurer()
        )

    /**
     * Let the stub for getMailOrderById respond with HTTP status code 404.
     *
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith404(
        body: ErrorMessage,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this },
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(404)
            .withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(body))
            .configurer()
        )

    /**
     * Let the stub for getMailOrderById respond with HTTP status code [code].
     *
     * @param code the response code.
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith(
        code: Int,
        body: Any? = null,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this }
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(code)
            .apply {
                body?.let {
                    withHeader("Content-Type", "application/json")
                    withBody(objectMapper.writeValueAsString(it))
                }
            }
            .configurer()
    )
}

/**
 *  Builder for WireMock stubs of operation getMailOrders.
 */
class GetMailOrdersStubBuilder internal constructor(private val objectMapper: ObjectMapper, private val stub: MappingBuilder) {

    /**
     * Let the stub for getMailOrders respond with HTTP status code 200.
     *
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith200(
        body: kotlin.collections.List<MailOrder>,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this },
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(body))
            .configurer()
        )

    /**
     * Let the stub for getMailOrders respond with HTTP status code 401.
     *
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith401(
        body: ErrorMessage,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this },
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(401)
            .withHeader("Content-Type", "application/json")
            .withBody(objectMapper.writeValueAsString(body))
            .configurer()
        )

    /**
     * Let the stub for getMailOrders respond with HTTP status code [code].
     *
     * @param code the response code.
     * @param body response body for the [MappingBuilder].
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return a [MappingBuilder] to be registered with a WireMock instance.
     */
    fun respondWith(
        code: Int,
        body: Any? = null,
        configurer: ResponseDefinitionBuilder.() -> ResponseDefinitionBuilder = { this }
    ): MappingBuilder =
        stub.willReturn(aResponse()
            .withStatus(code)
            .apply {
                body?.let {
                    withHeader("Content-Type", "application/json")
                    withBody(objectMapper.writeValueAsString(it))
                }
            }
            .configurer()
    )
}

