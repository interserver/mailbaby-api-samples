package io.interserver.jaxrs.cxf.extended.model;

import org.joda.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 */
@ApiModel(description="A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")

public class MailBlockClickHouse  {
  
 /**
  * The date the block event was recorded.
  */
  @ApiModelProperty(example = "2023-08-07", required = true, value = "The date the block event was recorded.")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate date;

 /**
  * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
  */
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
  private String from;

 /**
  * The `Subject` header of the blocked message.
  */
  @ApiModelProperty(example = "Test Email", required = true, value = "The `Subject` header of the blocked message.")
  private String subject;

 /**
  * The serialized list of recipients of the blocked message.
  */
  @ApiModelProperty(example = "['client@site.com']", required = true, value = "The serialized list of recipients of the blocked message.")
  private String to;

 /**
  * The `Message-ID` header of the blocked message, or `null` if not present.
  */
  @ApiModelProperty(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", value = "The `Message-ID` header of the blocked message, or `null` if not present.")
  private String messageId;
 /**
  * The date the block event was recorded.
  * @return date
  */
  @JsonProperty("date")
  @NotNull
  public LocalDate getDate() {
    return date;
  }

  /**
   * Sets the <code>date</code> property.
   */
 public void setDate(LocalDate date) {
    this.date = date;
  }

  /**
   * Sets the <code>date</code> property.
   */
  public MailBlockClickHouse date(LocalDate date) {
    this.date = date;
    return this;
  }

 /**
  * The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
  * @return from
  */
  @JsonProperty("from")
  @NotNull
  public String getFrom() {
    return from;
  }

  /**
   * Sets the <code>from</code> property.
   */
 public void setFrom(String from) {
    this.from = from;
  }

  /**
   * Sets the <code>from</code> property.
   */
  public MailBlockClickHouse from(String from) {
    this.from = from;
    return this;
  }

 /**
  * The &#x60;Subject&#x60; header of the blocked message.
  * @return subject
  */
  @JsonProperty("subject")
  @NotNull
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the <code>subject</code> property.
   */
 public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Sets the <code>subject</code> property.
   */
  public MailBlockClickHouse subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
  * The serialized list of recipients of the blocked message.
  * @return to
  */
  @JsonProperty("to")
  @NotNull
  public String getTo() {
    return to;
  }

  /**
   * Sets the <code>to</code> property.
   */
 public void setTo(String to) {
    this.to = to;
  }

  /**
   * Sets the <code>to</code> property.
   */
  public MailBlockClickHouse to(String to) {
    this.to = to;
    return this;
  }

 /**
  * The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
  * @return messageId
  */
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }

  /**
   * Sets the <code>messageId</code> property.
   */
 public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * Sets the <code>messageId</code> property.
   */
  public MailBlockClickHouse messageId(String messageId) {
    this.messageId = messageId;
    return this;
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
  private static String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

