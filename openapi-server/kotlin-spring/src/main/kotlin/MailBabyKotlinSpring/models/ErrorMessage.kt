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
 * The response body returned when an error occurs.
 * @param code The HTTP-style status code associated with the error.
 * @param message A human-readable description of the error.
 */
data class ErrorMessage(

    @Schema(example = "400", required = true, description = "The HTTP-style status code associated with the error.")
    @param:JsonProperty("code", required = true)
    @get:JsonProperty("code", required = true) val code: kotlin.Int,

    @Schema(example = "The specified ID was invalid.", required = true, description = "A human-readable description of the error.")
    @param:JsonProperty("message", required = true)
    @get:JsonProperty("message", required = true) val message: kotlin.String
) {

}

