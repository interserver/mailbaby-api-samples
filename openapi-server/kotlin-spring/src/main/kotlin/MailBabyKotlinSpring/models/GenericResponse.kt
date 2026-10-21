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
 * Standard success response returned by write operations (send, add rule, delete, etc.).  The `status` field is always `\"ok\"` on success.  The `text` field carries operation-specific data — for sending calls it contains the relay transaction ID; for create calls it contains the new record's ID; for delete calls it contains a confirmation string.
 * @param status Always `\"ok\"` on success.
 * @param text Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.
 */
data class GenericResponse(

    @Schema(example = "ok", required = true, description = "Always `\"ok\"` on success.")
    @param:JsonProperty("status", required = true)
    @get:JsonProperty("status", required = true) val status: kotlin.String,

    @Schema(example = "185caa69ff7000f47c", required = true, description = "Operation-specific result string.  For send operations this is the relay transaction ID (e.g. `185caa69ff7000f47c`) which can be used as the `mailid` parameter in `GET /mail/log`.  For create operations this is the new record's numeric ID.  For delete operations this is a human-readable confirmation.")
    @param:JsonProperty("text", required = true)
    @get:JsonProperty("text", required = true) val text: kotlin.String
) {

}

