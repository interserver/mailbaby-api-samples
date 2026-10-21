package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

@Schema(name = "MailBlockRspamd", description = "A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class MailBlockRspamd {

  private String from;

  private String subject;

  public MailBlockRspamd() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailBlockRspamd(String from, String subject) {
    this.from = from;
    this.subject = subject;
  }

  public MailBlockRspamd from(String from) {
    this.from = from;
    return this;
  }

  /**
   * The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
   * @return from
   */
  @NotNull 
  @Schema(name = "from", example = "user@domain.com", description = "The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }

  @JsonProperty("from")
  public void setFrom(String from) {
    this.from = from;
  }

  public MailBlockRspamd subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The suspicious subject pattern that triggered the block.
   * @return subject
   */
  @NotNull 
  @Schema(name = "subject", example = "Test email", description = "The suspicious subject pattern that triggered the block.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  @JsonProperty("subject")
  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

