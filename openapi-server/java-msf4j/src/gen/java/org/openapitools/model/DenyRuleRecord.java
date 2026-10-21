package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
 */
@ApiModel(description = "A complete deny rule record as returned by `GET /mail/rules`.  Combines the rule definition fields (`DenyRuleNew`) with server-assigned metadata (`id` and `created`).  The `id` value is required by `DELETE /mail/rules/{ruleId}`.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", comments = "Generator version: 7.26.0")
public class DenyRuleRecord   {
  /**
   * The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
   */
  public enum TypeEnum {
    DOMAIN("domain"),
    
    EMAIL("email"),
    
    STARTSWITH("startswith"),
    
    DESTINATION("destination"),
    
    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

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
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("type")
  private TypeEnum type;

  @JsonProperty("data")
  private String data;

  @JsonProperty("id")
  private String id;

  @JsonProperty("created")
  private Date created;

  @JsonProperty("user")
  private String user;

  public DenyRuleRecord type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.
   * @return type
  **/
  @ApiModelProperty(example = "email", required = true, value = "The matching strategy for this rule.  `email` blocks an exact sender address, `domain` blocks all senders at a domain, `destination` blocks an exact recipient address, and `startswith` blocks any sender whose local-part begins with the given prefix.")
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
  @ApiModelProperty(example = "domeinwo@server.guesshost.net", required = true, value = "The value to match against, interpreted according to `type`: a full email address for `email`/`destination`, a domain name for `domain`, or an alphanumeric prefix string for `startswith`.")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public DenyRuleRecord id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.
   * @return id
  **/
  @ApiModelProperty(example = "41124", required = true, value = "The numeric ID of the deny rule, as a string.  Pass this as `ruleId` to `DELETE /mail/rules/{ruleId}` to remove the rule.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DenyRuleRecord created(Date created) {
    this.created = created;
    return this;
  }

   /**
   * The timestamp when the rule was created.
   * @return created
  **/
  @ApiModelProperty(required = true, value = "The timestamp when the rule was created.")
  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
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
  @ApiModelProperty(example = "mb20682", value = "Optional SMTP username of the mail order to associate this rule with (e.g. `mb20682`).  If omitted the first active order is used.  Valid usernames are the `username` values returned by `GET /mail`.")
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
    DenyRuleRecord denyRuleRecord = (DenyRuleRecord) o;
    return Objects.equals(this.type, denyRuleRecord.type) &&
        Objects.equals(this.data, denyRuleRecord.data) &&
        Objects.equals(this.id, denyRuleRecord.id) &&
        Objects.equals(this.created, denyRuleRecord.created) &&
        Objects.equals(this.user, denyRuleRecord.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, data, id, created, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DenyRuleRecord {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
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

