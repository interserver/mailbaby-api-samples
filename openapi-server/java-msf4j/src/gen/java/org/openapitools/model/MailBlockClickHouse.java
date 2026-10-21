package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */
@ApiModel(description = "A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaMSF4JServerCodegen", comments = "Generator version: 7.26.0")
public class MailBlockClickHouse   {
  @JsonProperty("date")
  private Date date;

  @JsonProperty("from")
  private String from;

  @JsonProperty("subject")
  private String subject;

  @JsonProperty("to")
  private String to;

  @JsonProperty("messageId")
  private String messageId;

  public MailBlockClickHouse date(Date date) {
    this.date = date;
    return this;
  }

   /**
   * The date the block event was recorded.
   * @return date
  **/
  @ApiModelProperty(example = "2023-08-07", required = true, value = "The date the block event was recorded.")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public MailBlockClickHouse from(String from) {
    this.from = from;
    return this;
  }

   /**
   * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
   * @return from
  **/
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
  public String getFrom() {
    return from;
  }

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
  **/
  @ApiModelProperty(example = "Test Email", required = true, value = "The `Subject` header of the blocked message.")
  public String getSubject() {
    return subject;
  }

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
  **/
  @ApiModelProperty(example = "['client@site.com']", required = true, value = "The serialized list of recipients of the blocked message.")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public MailBlockClickHouse messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

   /**
   * The `Message-ID` header of the blocked message, or `null` if not present.
   * @return messageId
  **/
  @ApiModelProperty(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", value = "The `Message-ID` header of the blocked message, or `null` if not present.")
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

