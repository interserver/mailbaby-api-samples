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
 * This is a block entry from the rspamd block list.
 */
@Schema(description = "This is a block entry from the rspamd block list.")
@Validated
@Introspected
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2025-09-24T20:31:39.806768800-04:00[America/New_York]")
public class MailBlockRspamd   {
  @JsonProperty("from")
  private String from = null;

  @JsonProperty("subject")
  private String subject = null;

  public MailBlockRspamd from(String from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  **/
  @Schema(required = true, description = "")
  @NotNull

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public MailBlockRspamd subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * Get subject
   * @return subject
  **/
  @Schema(required = true, description = "")
  @NotNull

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailBlockRspamd mailBlockRspamd = (MailBlockRspamd) o;
    return Objects.equals(this.from, mailBlockRspamd.from) &&
        Objects.equals(this.subject, mailBlockRspamd.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlockRspamd {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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
