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
open class BlockingApiStubs(private val objectMapper: ObjectMapper) {

    /**
     * Construct a stub for the operation addRule.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [AddRuleStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun addRule(configurer: MappingBuilder.() -> MappingBuilder = { this }): AddRuleStubBuilder =
        AddRuleStubBuilder(objectMapper, post(urlPathTemplate("/mail/rules"))
            .configurer()
        )

    /**
     * Construct a stub for the operation deleteRule.
     *
     * @param ruleId path parameter ruleId pattern.
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [DeleteRuleStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun deleteRule(ruleId: StringValuePattern, configurer: MappingBuilder.() -> MappingBuilder = { this }): DeleteRuleStubBuilder =
        DeleteRuleStubBuilder(objectMapper, delete(urlPathTemplate("/mail/rules/{ruleId}"))
            .withPathParam("ruleId", ruleId)
            .configurer()
        )

    /**
     * Construct a stub for the operation delistBlock.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [DelistBlockStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun delistBlock(configurer: MappingBuilder.() -> MappingBuilder = { this }): DelistBlockStubBuilder =
        DelistBlockStubBuilder(objectMapper, post(urlPathTemplate("/mail/blocks/delete"))
            .configurer()
        )

    /**
     * Construct a stub for the operation getMailBlocks.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [GetMailBlocksStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun getMailBlocks(configurer: MappingBuilder.() -> MappingBuilder = { this }): GetMailBlocksStubBuilder =
        GetMailBlocksStubBuilder(objectMapper, get(urlPathTemplate("/mail/blocks"))
            .configurer()
        )

    /**
     * Construct a stub for the operation getRules.
     *
     * @param configurer configurer for the [MappingBuilder], allowing for arbitrary changes.
     * @return A [GetRulesStubBuilder] to configure the response, and the final [MappingBuilder].
     */
    fun getRules(configurer: MappingBuilder.() -> MappingBuilder = { this }): GetRulesStubBuilder =
        GetRulesStubBuilder(objectMapper, get(urlPathTemplate("/mail/rules"))
            .configurer()
        )
}
