@file:Suppress(
    "RemoveRedundantQualifierName",
    "unused",
)

package MailBabyKotlinWiremock.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MailBlocks(
    @field:JsonProperty("local")
    val local: kotlin.collections.List<MailBlockClickHouse>,

    @field:JsonProperty("mbtrap")
    val mbtrap: kotlin.collections.List<MailBlockClickHouse>,

    @field:JsonProperty("subject")
    val subject: kotlin.collections.List<MailBlockRspamd>,

)
