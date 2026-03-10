package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;


/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 **/
@Schema(description = "A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")


public class MailBlockClickHouse   {
  @JsonProperty("date")
  private Date date = null;
  @JsonProperty("from")
  private String from = null;
  @JsonProperty("messageId")
  private String messageId = null;
  @JsonProperty("subject")
  private String subject = null;
  @JsonProperty("to")
  private String to = null;
  /**
   * The date the block event was recorded.
   **/
  public MailBlockClickHouse date(Date date) {
    this.date = date;
    return this;
  }

  
  @Schema(example = "Sun Aug 06 20:00:00 EDT 2023", required = true, description = "The date the block event was recorded.")
  @JsonProperty("date")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
   **/
  public MailBlockClickHouse from(String from) {
    this.from = from;
    return this;
  }

  
  @Schema(example = "user@domain.com", required = true, description = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * The `Message-ID` header of the blocked message, or `null` if not present.
   **/
  public MailBlockClickHouse messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  
  @Schema(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", description = "The `Message-ID` header of the blocked message, or `null` if not present.")
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * The `Subject` header of the blocked message.
   **/
  public MailBlockClickHouse subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @Schema(example = "Test Email", required = true, description = "The `Subject` header of the blocked message.")
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The serialized list of recipients of the blocked message.
   **/
  public MailBlockClickHouse to(String to) {
    this.to = to;
    return this;
  }

  
  @Schema(example = "['client@site.com']", required = true, description = "The serialized list of recipients of the blocked message.")
  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailBlockClickHouse mailBlockClickHouse = (MailBlockClickHouse) o;
    return Objects.equals(date, mailBlockClickHouse.date) &&
        Objects.equals(from, mailBlockClickHouse.from) &&
        Objects.equals(messageId, mailBlockClickHouse.messageId) &&
        Objects.equals(subject, mailBlockClickHouse.subject) &&
        Objects.equals(to, mailBlockClickHouse.to);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, from, messageId, subject, to);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlockClickHouse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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
