package MailBabyKotlinSpring.models

import java.util.Objects
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
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 * @param date The date the block event was recorded.
 * @param from The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
 * @param subject The `Subject` header of the blocked message.
 * @param to The serialized list of recipients of the blocked message.
 * @param messageId The `Message-ID` header of the blocked message, or `null` if not present.
 */
data class MailBlockClickHouse(

    @field:Valid
    @Schema(example = "Sun Aug 06 20:00:00 EDT 2023", required = true, description = "The date the block event was recorded.")
    @param:JsonProperty("date", required = true)
    @get:JsonProperty("date", required = true) val date: java.time.LocalDate,

    @Schema(example = "user@domain.com", required = true, description = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: kotlin.String,

    @Schema(example = "Test Email", required = true, description = "The `Subject` header of the blocked message.")
    @param:JsonProperty("subject", required = true)
    @get:JsonProperty("subject", required = true) val subject: kotlin.String,

    @Schema(example = "['client@site.com']", required = true, description = "The serialized list of recipients of the blocked message.")
    @param:JsonProperty("to", required = true)
    @get:JsonProperty("to", required = true) val to: kotlin.String,

    @Schema(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", description = "The `Message-ID` header of the blocked message, or `null` if not present.")
    @param:JsonProperty("messageId")
    @get:JsonProperty("messageId") val messageId: kotlin.String? = null
) {

}

