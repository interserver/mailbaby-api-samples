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
 * An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 * @param email The email address.
 * @param name Optional display name shown to recipients (e.g. in the `From:` header).
 */
data class EmailAddressName(

    @get:Email
    @Schema(example = "user@domain.com", required = true, description = "The email address.")
    @param:JsonProperty("email", required = true)
    @get:JsonProperty("email", required = true) val email: kotlin.String,

    @Schema(example = "John Smith", description = "Optional display name shown to recipients (e.g. in the `From:` header).")
    @param:JsonProperty("name")
    @get:JsonProperty("name") val name: kotlin.String? = null
) : EmailAddressTypes {

}

