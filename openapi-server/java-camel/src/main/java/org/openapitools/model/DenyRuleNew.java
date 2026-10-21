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

/**
 * The fields required to create a new email deny rule via &#x60;POST /mail/rules&#x60;. The &#x60;type&#x60; controls what &#x60;data&#x60; is matched against: - &#x60;email&#x60; — exact sender address match - &#x60;domain&#x60; — all senders from a domain - &#x60;destination&#x60; — exact recipient address match - &#x60;startswith&#x60; — sender local-part prefix match (alphanumeric + &#x60;+_.-&#x60; only)
 */

@Schema(name = "DenyRuleNew", description = "The fields required to create a new email deny rule via `POST /mail/rules`. The `type` controls what `data` is matched against: - `email` — exact sender address match - `domain` — all senders from a domain - `destination` — exact recipient address match - `startswith` — sender local-part prefix match (alphanumeric + `+_.-` only)")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class DenyRuleNew {

  /**
   * The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
   */
  public enum TypeEnum {
    DOMAIN("domain"),
    
    EMAIL("email"),
    
    STARTSWITH("startswith"),
    
    DESTINATION("destination"),
    
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private final String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  private TypeEnum type;

  private String data;

  private String user;

  public DenyRuleNew() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DenyRuleNew(TypeEnum type, String data) {
    this.type = type;
    this.data = data;
  }

  public DenyRuleNew type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
   * @return type
   */
  @NotNull 
  @Schema(name = "type", example = "email", description = "The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public DenyRuleNew data(String data) {
    this.data = data;
    return this;
  }

  /**
   * The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
   * @return data
   */
  @NotNull 
  @Schema(name = "data", example = "domeinwo@server.guesshost.net", description = "The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public DenyRuleNew user(String user) {
    this.user = user;
    return this;
  }

  /**
   * Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
   * @return user
   */
  
  @Schema(name = "user", example = "mb20682", description = "Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user")
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DenyRuleNew denyRuleNew = (DenyRuleNew) o;
    return Objects.equals(this.type, denyRuleNew.type) &&
        Objects.equals(this.data, denyRuleNew.data) &&
        Objects.equals(this.user, denyRuleNew.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, data, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DenyRuleNew {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

