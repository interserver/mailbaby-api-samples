package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.DenyRuleNew;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The data for a email deny rule record.
 */
@Schema(description = "The data for a email deny rule record.")
@Validated
@Introspected
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2025-09-28T16:29:05.877636411-04:00[America/New_York]")
public class DenyRuleRecord   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("user")
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
   * The deny rule Id number.
   * @return id
  **/
  @Schema(example = "41124", required = true, description = "The deny rule Id number.")
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
   * the date the rule was created.
   * @return created
  **/
  @Schema(required = true, description = "the date the rule was created.")
  @NotNull

  @Valid
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
   * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
   * @return user
  **/
  @Schema(example = "mb20682", description = "Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.")
  @NotNull

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
   * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
   * @return data
  **/
  @Schema(example = "domeinwo@server.guesshost.net", required = true, description = "The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.")
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
