package org.openapitools.model;

import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.Objects;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.time.*;
import java.math.*;
@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */
public class MailBlockClickHouse implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * The date the block event was recorded.
   */
  @JsonProperty("date")
  private LocalDate date;

  /**
   * The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
   */
  @JsonProperty("from")
  private String from;

  /**
   * The &#x60;Subject&#x60; header of the blocked message.
   */
  @JsonProperty("subject")
  private String subject;

  /**
   * The serialized list of recipients of the blocked message.
   */
  @JsonProperty("to")
  private String to;

  /**
   * The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
   */
  @JsonProperty("messageId")
  private String messageId;

  /**
   * The date the block event was recorded.
   * @return date
   */
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  /**
   * The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
   * @return from
   */
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * The &#x60;Subject&#x60; header of the blocked message.
   * @return subject
   */
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The serialized list of recipients of the blocked message.
   * @return to
   */
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  /**
   * The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
   * @return messageId
   */
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
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
        Objects.equals(this.messageId, mailBlockClickHouse.messageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, from, subject, to, messageId);
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
