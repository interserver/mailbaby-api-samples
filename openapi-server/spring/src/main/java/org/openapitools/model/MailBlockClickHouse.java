package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */

@Schema(name = "MailBlockClickHouse", description = "A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class MailBlockClickHouse {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private String from;

  private String subject;

  private String to;

  private JsonNullable<String> messageId = JsonNullable.<String>undefined();

  public MailBlockClickHouse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailBlockClickHouse(LocalDate date, String from, String subject, String to) {
    this.date = date;
    this.from = from;
    this.subject = subject;
    this.to = to;
  }

  public MailBlockClickHouse date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The date the block event was recorded.
   * @return date
   */
  @NotNull @Valid 
  @Schema(name = "date", example = "2023-08-07", description = "The date the block event was recorded.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  @JsonProperty("date")
  public void setDate(LocalDate date) {
    this.date = date;
  }

  public MailBlockClickHouse from(String from) {
    this.from = from;
    return this;
  }

  /**
   * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
   * @return from
   */
  @NotNull 
  @Schema(name = "from", example = "user@domain.com", description = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }

  @JsonProperty("from")
  public void setFrom(String from) {
    this.from = from;
  }

  public MailBlockClickHouse subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The `Subject` header of the blocked message.
   * @return subject
   */
  @NotNull 
  @Schema(name = "subject", example = "Test Email", description = "The `Subject` header of the blocked message.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  @JsonProperty("subject")
  public void setSubject(String subject) {
    this.subject = subject;
  }

  public MailBlockClickHouse to(String to) {
    this.to = to;
    return this;
  }

  /**
   * The serialized list of recipients of the blocked message.
   * @return to
   */
  @NotNull 
  @Schema(name = "to", example = "['client@site.com']", description = "The serialized list of recipients of the blocked message.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("to")
  public String getTo() {
    return to;
  }

  @JsonProperty("to")
  public void setTo(String to) {
    this.to = to;
  }

  public MailBlockClickHouse messageId(String messageId) {
    this.messageId = JsonNullable.of(messageId);
    return this;
  }

  /**
   * The `Message-ID` header of the blocked message, or `null` if not present.
   * @return messageId
   */
  
  @Schema(name = "messageId", example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", description = "The `Message-ID` header of the blocked message, or `null` if not present.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, nullable = true)
  @JsonProperty("messageId")
  public JsonNullable<String> getMessageId() {
    return messageId;
  }

  public void setMessageId(JsonNullable<String> messageId) {
    this.messageId = messageId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailBlockClickHouse mailBlockClickHouse = (MailBlockClickHouse) o;
    return Objects.equals(this.date, mailBlockClickHouse.date) &&
        Objects.equals(this.from, mailBlockClickHouse.from) &&
        Objects.equals(this.subject, mailBlockClickHouse.subject) &&
        Objects.equals(this.to, mailBlockClickHouse.to) &&
        equalsNullable(this.messageId, mailBlockClickHouse.messageId);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, from, subject, to, hashCodeNullable(messageId));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlockClickHouse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
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

