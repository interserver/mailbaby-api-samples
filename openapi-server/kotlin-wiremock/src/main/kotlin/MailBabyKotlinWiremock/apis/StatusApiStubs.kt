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
open class StatusApiStubs(private val objectMapper: ObjectMapper) {

    /**
     * Construct a stub for the operation pingServer.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [PingServerStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun pingServer(configurer: MappingBuilder.() -> MappingBuilder = { this }): PingServerStubBuilder =
        PingServerStubBuilder(objectMapper, get(urlPathTemplate("/ping"))
            .configurer()
        )
}
