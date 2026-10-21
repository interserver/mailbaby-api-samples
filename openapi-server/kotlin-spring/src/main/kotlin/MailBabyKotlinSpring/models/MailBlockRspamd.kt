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
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 * @param from The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
 * @param subject The suspicious subject pattern that triggered the block.
 */
data class MailBlockRspamd(

    @Schema(example = "user@domain.com", required = true, description = "The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.")
    @param:JsonProperty("from", required = true)
    @get:JsonProperty("from", required = true) val from: kotlin.String,

    @Schema(example = "Test email", required = true, description = "The suspicious subject pattern that triggered the block.")
    @param:JsonProperty("subject", required = true)
    @get:JsonProperty("subject", required = true) val subject: kotlin.String
) {

}

