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
 * WireMock stub request builder.
 */
open class ServicesApiStubs(private val objectMapper: ObjectMapper) {

    /**
     * Construct a stub for the operation getMailOrderById.
     *
     * @param id path parameter id pattern.
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [GetMailOrderByIdStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun getMailOrderById(id: StringValuePattern, configurer: MappingBuilder.() -> MappingBuilder = { this }): GetMailOrderByIdStubBuilder =
        GetMailOrderByIdStubBuilder(objectMapper, get(urlPathTemplate("/mail/{id}"))
            .withPathParam("id", id)
            .configurer()
        )

    /**
     * Construct a stub for the operation getMailOrders.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [GetMailOrdersStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun getMailOrders(configurer: MappingBuilder.() -> MappingBuilder = { this }): GetMailOrdersStubBuilder =
        GetMailOrdersStubBuilder(objectMapper, get(urlPathTemplate("/mail"))
            .configurer()
        )
}
