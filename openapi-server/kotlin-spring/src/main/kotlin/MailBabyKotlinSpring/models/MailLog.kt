package MailBabyKotlinSpring.models

import java.util.Objects
import MailBabyKotlinSpring.models.MailLogEntry
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
 * Paginated mail log response returned by `GET /mail/log`.  Contains the full matched count (`total`) plus a page of `MailLogEntry` records.  Use `skip` and `limit` to page through large result sets.
 * @param total Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.
 * @param skip The `skip` value used for this page (echoed from the request).
 * @param limit The `limit` value used for this page (echoed from the request).
 * @param emails 
 */
data class MailLog(

    @Schema(example = "10234", required = true, description = "Total number of log entries that match the supplied filters, regardless of `skip` and `limit`.  Use this to calculate the number of pages: `ceil(total / limit)`.")
    @param:JsonProperty("total", required = true)
    @get:JsonProperty("total", required = true) val total: kotlin.Int,

    @Schema(example = "0", required = true, description = "The `skip` value used for this page (echoed from the request).")
    @param:JsonProperty("skip", required = true)
    @get:JsonProperty("skip", required = true) val skip: kotlin.Int,

    @Schema(example = "100", required = true, description = "The `limit` value used for this page (echoed from the request).")
    @param:JsonProperty("limit", required = true)
    @get:JsonProperty("limit", required = true) val limit: kotlin.Int,

    @field:Valid
    @Schema(required = true, description = "")
    @param:JsonProperty("emails", required = true)
    @get:JsonProperty("emails", required = true) val emails: kotlin.collections.List<MailLogEntry>
) {

}

