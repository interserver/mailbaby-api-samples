package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.DenyRuleNew;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
 */
@Schema(description = "A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.")
@Validated
@NotUndefined



public class DenyRuleRecord   {
  @JsonProperty("id")

  private String id = null;

  @JsonProperty("created")

  private OffsetDateTime created = null;

  @JsonProperty("user")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String user = null;

  /**
   * The type of deny rule.
   */
  public enum TypeEnum {
    DOMAIN("domain"),
    
    EMAIL("email"),
    
    STARTSWITH("startswith"),
    
    DESTINATION("destination");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("type")

  private TypeEnum type = null;

  @JsonProperty("data")

  private String data = null;


  public DenyRuleRecord id(String id) { 

    this.id = id;
    return this;
  }

  /**
   * The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
   * @return id
   **/
  
  @Schema(example = "41124", required = true, description = "The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.")
  
  @NotNull
  public String getId() {  
    return id;
  }



  public void setId(String id) { 

    this.id = id;
  }

  public DenyRuleRecord created(OffsetDateTime created) { 

    this.created = created;
    return this;
  }

  /**
   * The timestamp when the rule was created.
   * @return created
   **/
  
  @Schema(required = true, description = "The timestamp when the rule was created.")
  
@Valid
  @NotNull
  public OffsetDateTime getCreated() {  
    return created;
  }



  public void setCreated(OffsetDateTime created) { 

    this.created = created;
  }

  public DenyRuleRecord user(String user) { 

    this.user = user;
    return this;
  }

  /**
   * Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.
   * @return user
   **/
  
  @Schema(example = "mb20682", description = "Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.")
  
  public String getUser() {  
    return user;
  }



  public void setUser(String user) { 
    this.user = user;
  }

  public DenyRuleRecord type(TypeEnum type) { 

    this.type = type;
    return this;
  }

  /**
   * The type of deny rule.
   * @return type
   **/
  
  @Schema(example = "email", required = true, description = "The type of deny rule.")
  
  @NotNull
  public TypeEnum getType() {  
    return type;
  }



  public void setType(TypeEnum type) { 

    this.type = type;
  }

  public DenyRuleRecord data(String data) { 

    this.data = data;
    return this;
  }

  /**
   * The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.
   * @return data
   **/
  
  @Schema(example = "domeinwo@server.guesshost.net", required = true, description = "The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.")
  
  @NotNull
  public String getData() {  
    return data;
  }



  public void setData(String data) { 

    this.data = data;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DenyRuleRecord denyRuleRecord = (DenyRuleRecord) o;
    return Objects.equals(this.id, denyRuleRecord.id) &&
        Objects.equals(this.created, denyRuleRecord.created) &&
        Objects.equals(this.user, denyRuleRecord.user) &&
        Objects.equals(this.type, denyRuleRecord.type) &&
        Objects.equals(this.data, denyRuleRecord.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, user, type, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DenyRuleRecord {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
