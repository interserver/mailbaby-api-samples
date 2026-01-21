package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Raw Email Object
 */
@Schema(description = "Raw Email Object")
@Validated
@Introspected
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2026-01-21T17:25:46.931236432-05:00[America/New_York]")
public class SendMailRaw   {
  @JsonProperty("raw_email")
  private String rawEmail = null;

  @JsonProperty("id")
  private Integer id = null;

  public SendMailRaw rawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
    return this;
  }

  /**
   * The entire email contents
   * @return rawEmail
  **/
  @Schema(required = true, description = "The entire email contents")
  @NotNull

  public String getRawEmail() {
    return rawEmail;
  }

  public void setRawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
  }

  public SendMailRaw id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Optional order id
   * @return id
  **/
  @Schema(description = "Optional order id")
  @NotNull

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMailRaw sendMailRaw = (SendMailRaw) o;
    return Objects.equals(this.rawEmail, sendMailRaw.rawEmail) &&
        Objects.equals(this.id, sendMailRaw.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawEmail, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailRaw {\n");
    
    sb.append("    rawEmail: ").append(toIndentedString(rawEmail)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
