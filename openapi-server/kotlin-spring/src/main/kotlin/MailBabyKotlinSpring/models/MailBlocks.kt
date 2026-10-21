package MailBabyKotlinSpring.models

import java.util.Objects
import MailBabyKotlinSpring.models.MailBlockClickHouse
import MailBabyKotlinSpring.models.MailBlockRspamd
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
 * @param local Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
 * @param mbtrap Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
 * @param subject Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
 */
data class MailBlocks(

    @field:Valid
    @Schema(required = true, description = "Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.")
    @param:JsonProperty("local", required = true)
    @get:JsonProperty("local", required = true) val local: kotlin.collections.List<MailBlockClickHouse>,

    @field:Valid
    @Schema(required = true, description = "Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.")
    @param:JsonProperty("mbtrap", required = true)
    @get:JsonProperty("mbtrap", required = true) val mbtrap: kotlin.collections.List<MailBlockClickHouse>,

    @field:Valid
    @Schema(required = true, description = "Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.")
    @param:JsonProperty("subject", required = true)
    @get:JsonProperty("subject", required = true) val subject: kotlin.collections.List<MailBlockRspamd>
) {

}

