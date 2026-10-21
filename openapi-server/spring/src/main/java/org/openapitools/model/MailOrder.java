package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The &#x60;id&#x60; is the numeric identifier used across most API calls.  The &#x60;username&#x60; is always &#x60;mb&lt;id&gt;&#x60; and is the SMTP AUTH username for &#x60;relay.mailbaby.net&#x60;.
 */

@Schema(name = "MailOrder", description = "A mail service order record.  Each order represents one provisioned sending account with a dedicated SMTP username.  The `id` is the numeric identifier used across most API calls.  The `username` is always `mb<id>` and is the SMTP AUTH username for `relay.mailbaby.net`.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class MailOrder {

  private Integer id;

  /**
   * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    CANCELED("canceled"),
    
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  private StatusEnum status;

  private String username;

  private @Nullable String comment;

  public MailOrder() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailOrder(Integer id, StatusEnum status, String username) {
    this.id = id;
    this.status = status;
    this.username = username;
  }

  public MailOrder id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
   * @return id
   */
  @NotNull 
  @Schema(name = "id", example = "21472", description = "The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  public MailOrder status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
   * @return status
   */
  @NotNull 
  @Schema(name = "status", example = "active", description = "The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public MailOrder username(String username) {
    this.username = username;
    return this;
  }

  /**
   * The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
   * @return username
   */
  @NotNull @Pattern(regexp = "^mb\\d+$") 
  @Schema(name = "username", example = "mb21472", description = "The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  @JsonProperty("username")
  public void setUsername(String username) {
    this.username = username;
  }

  public MailOrder comment(@Nullable String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
   * @return comment
   */
  
  @Schema(name = "comment", description = "Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public @Nullable String getComment() {
    return comment;
  }

  @JsonProperty("comment")
  public void setComment(@Nullable String comment) {
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailOrder mailOrder = (MailOrder) o;
    return Objects.equals(this.id, mailOrder.id) &&
        Objects.equals(this.status, mailOrder.status) &&
        Objects.equals(this.username, mailOrder.username) &&
        Objects.equals(this.comment, mailOrder.comment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, username, comment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailOrder {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

