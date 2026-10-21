package MailBabyKotlinSpring.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 * @param id The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
 * @param status The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
 * @param username The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
 * @param password The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
 * @param comment Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
 */
data class MailOrderDetail(

    @Schema(example = "21472", required = true, description = "The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.")
    @param:JsonProperty("id", required = true)
    @get:JsonProperty("id", required = true) val id: kotlin.Int,

    @Schema(example = "active", required = true, description = "The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.")
    @param:JsonProperty("status", required = true)
    @get:JsonProperty("status", required = true) val status: MailOrderDetail.Status,

    @get:Pattern(regexp="^mb\\d+$")
    @Schema(example = "mb21472", required = true, description = "The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.")
    @param:JsonProperty("username", required = true)
    @get:JsonProperty("username", required = true) val username: kotlin.String,

    @Schema(example = "s3cr3tpassword", required = true, description = "The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.")
    @param:JsonProperty("password", required = true)
    @get:JsonProperty("password", required = true) val password: kotlin.String,

    @Schema(description = "Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.")
    @param:JsonProperty("comment")
    @get:JsonProperty("comment") val comment: kotlin.String? = null
) {

    /**
    * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
    * Values: active,canceled,unknown_default_open_api
    */
    enum class Status(@get:JsonValue val value: kotlin.String) {

        active("active"),
        canceled("canceled"),
        unknown_default_open_api("unknown_default_open_api");
    
        companion object {
            @JvmStatic
            @JsonCreator
            fun forValue(value: kotlin.String): Status {
                return values().firstOrNull{ it.value == value }
                                ?: unknown_default_open_api
            }
        }
    }

}

