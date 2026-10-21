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
 * A single email address parameter used as the body of `POST /mail/blocks/delete`.
 * @param email The email address to delist from all block lists.
 */
data class EmailAddressParam(

    @get:Email
    @Schema(example = "user@domain.com", required = true, description = "The email address to delist from all block lists.")
    @param:JsonProperty("email", required = true)
    @get:JsonProperty("email", required = true) val email: kotlin.String
) {

}

