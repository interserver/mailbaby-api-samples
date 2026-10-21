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
 * A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 * @param filename The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
 * @param `data` The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
 */
data class MailAttachment(

    @Schema(example = "message.txt", required = true, description = "The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).")
    @param:JsonProperty("filename", required = true)
    @get:JsonProperty("filename", required = true) val filename: kotlin.String,

    @Schema(example = "[B@2ffb3aec", required = true, description = "The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.")
    @param:JsonProperty("data", required = true)
    @get:JsonProperty("data", required = true) val `data`: kotlin.ByteArray
) {

}

