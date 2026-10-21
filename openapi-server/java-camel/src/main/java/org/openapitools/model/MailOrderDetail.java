package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
/**
 * Extended mail order record including the current SMTP password.  Returned by &#x60;GET /mail/{id}&#x60;.  The &#x60;username&#x60; and &#x60;password&#x60; fields can be used to authenticate directly against &#x60;relay.mailbaby.net:25&#x60; via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.
 */

@Schema(name = "MailOrderDetail", description = "Extended mail order record including the current SMTP password.  Returned by `GET /mail/{id}`.  The `username` and `password` fields can be used to authenticate directly against `relay.mailbaby.net:25` via SMTP AUTH if you prefer to send via a native SMTP client rather than the REST API.")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class MailOrderDetail {

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

  private String password;

  private String comment;

  public MailOrderDetail() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailOrderDetail(Integer id, StatusEnum status, String username, String password) {
    this.id = id;
    this.status = status;
    this.username = username;
    this.password = password;
  }

  public MailOrderDetail id(Integer id) {
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

  public void setId(Integer id) {
    this.id = id;
  }

  public MailOrderDetail status(StatusEnum status) {
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

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public MailOrderDetail username(String username) {
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

  public void setUsername(String username) {
    this.username = username;
  }

  public MailOrderDetail password(String password) {
    this.password = password;
    return this;
  }

  /**
   * The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.
   * @return password
   */
  @NotNull 
  @Schema(name = "password", example = "s3cr3tpassword", description = "The current SMTP AUTH password for this mail order.  Use with the `username` field to authenticate against `relay.mailbaby.net:25`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public MailOrderDetail comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
   * @return comment
   */
  
  @Schema(name = "comment", description = "Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comment")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
    /**
    * A container for additional, undeclared properties.
    * This is a holder for any undeclared properties as specified with
    * the 'additionalProperties' keyword in the OAS document.
    */
    private Map<String, Object> additionalProperties;

    /**
    * Set the additional (undeclared) property with the specified name and value.
    * If the property does not already exist, create it otherwise replace it.
    */
    @JsonAnySetter
    public MailOrderDetail putAdditionalProperty(String key, Object value) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<String, Object>();
        }
        this.additionalProperties.put(key, value);
        return this;
    }

    /**
    * Return the additional (undeclared) property.
    */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
    * Return the additional (undeclared) property with the specified name.
    */
    public Object getAdditionalProperty(String key) {
        if (this.additionalProperties == null) {
            return null;
        }
        return this.additionalProperties.get(key);
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailOrderDetail mailOrderDetail = (MailOrderDetail) o;
    return Objects.equals(this.id, mailOrderDetail.id) &&
        Objects.equals(this.status, mailOrderDetail.status) &&
        Objects.equals(this.username, mailOrderDetail.username) &&
        Objects.equals(this.password, mailOrderDetail.password) &&
        Objects.equals(this.comment, mailOrderDetail.comment) &&
    Objects.equals(this.additionalProperties, mailOrderDetail.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, username, password, comment, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailOrderDetail {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

