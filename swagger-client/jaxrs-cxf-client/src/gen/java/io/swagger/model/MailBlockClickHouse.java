package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
  * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 **/
@Schema(description="A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
public class MailBlockClickHouse   {
  
  @Schema(example = "Sun Aug 06 20:00:00 EDT 2023", required = true, description = "The date the block event was recorded.")
 /**
   * The date the block event was recorded.  
  **/
  private LocalDate date = null;
  
  @Schema(example = "user@domain.com", required = true, description = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
 /**
   * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.  
  **/
  private String from = null;
  
  @Schema(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", description = "The `Message-ID` header of the blocked message, or `null` if not present.")
 /**
   * The `Message-ID` header of the blocked message, or `null` if not present.  
  **/
  private String messageId = null;
  
  @Schema(example = "Test Email", required = true, description = "The `Subject` header of the blocked message.")
 /**
   * The `Subject` header of the blocked message.  
  **/
  private String subject = null;
  
  @Schema(example = "['client@site.com']", required = true, description = "The serialized list of recipients of the blocked message.")
 /**
   * The serialized list of recipients of the blocked message.  
  **/
  private String to = null;
 /**
   * The date the block event was recorded.
   * @return date
  **/
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public MailBlockClickHouse date(LocalDate date) {
    this.date = date;
    return this;
  }

 /**
   * The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
   * @return from
  **/
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public MailBlockClickHouse from(String from) {
    this.from = from;
    return this;
  }

 /**
   * The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
   * @return messageId
  **/
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public MailBlockClickHouse messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

 /**
   * The &#x60;Subject&#x60; header of the blocked message.
   * @return subject
  **/
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public MailBlockClickHouse subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
   * The serialized list of recipients of the blocked message.
   * @return to
  **/
  @JsonProperty("to")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public MailBlockClickHouse to(String to) {
    this.to = to;
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
