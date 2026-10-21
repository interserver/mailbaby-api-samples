package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;

/**
 * A complete deny rule record as returned by &#x60;GET /mail/rules&#x60;.  Combines the rule definition fields (&#x60;DenyRuleNew&#x60;) with server-assigned metadata (&#x60;id&#x60; and &#x60;created&#x60;).  The &#x60;id&#x60; value is required by &#x60;DELETE /mail/rules/{ruleId}&#x60;.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DenyRuleRecord   {
  


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
      return value;
    }
  }

  private TypeEnum type;
  private String data;
  private String id;
  private OffsetDateTime created;
  private String user;

  public DenyRuleRecord () {

  }

  public DenyRuleRecord (TypeEnum type, String data, String id, OffsetDateTime created, String user) {
    this.type = type;
    this.data = data;
    this.id = id;
    this.created = created;
    this.user = user;
  }

    
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

    
  @JsonProperty("data")
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }

    
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

    
  @JsonProperty("created")
  public OffsetDateTime getCreated() {
    return created;
  }
  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

    
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
    DenyRuleRecord denyRuleRecord = (DenyRuleRecord) o;
    return Objects.equals(type, denyRuleRecord.type) &&
        Objects.equals(data, denyRuleRecord.data) &&
        Objects.equals(id, denyRuleRecord.id) &&
        Objects.equals(created, denyRuleRecord.created) &&
        Objects.equals(user, denyRuleRecord.user);
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
