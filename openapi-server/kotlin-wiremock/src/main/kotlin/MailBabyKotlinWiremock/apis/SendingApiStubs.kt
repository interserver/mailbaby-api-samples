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
open class SendingApiStubs(private val objectMapper: ObjectMapper) {

    /**
     * Construct a stub for the operation rawMail.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [RawMailStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun rawMail(configurer: MappingBuilder.() -> MappingBuilder = { this }): RawMailStubBuilder =
        RawMailStubBuilder(objectMapper, post(urlPathTemplate("/mail/rawsend"))
            .configurer()
        )

    /**
     * Construct a stub for the operation sendAdvMail.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [SendAdvMailStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun sendAdvMail(configurer: MappingBuilder.() -> MappingBuilder = { this }): SendAdvMailStubBuilder =
        SendAdvMailStubBuilder(objectMapper, post(urlPathTemplate("/mail/advsend"))
            .configurer()
        )

    /**
     * Construct a stub for the operation sendMail.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [SendMailStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun sendMail(configurer: MappingBuilder.() -> MappingBuilder = { this }): SendMailStubBuilder =
        SendMailStubBuilder(objectMapper, post(urlPathTemplate("/mail/send"))
            .configurer()
        )
}
