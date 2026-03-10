package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 */
@Schema(description = "A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
@Validated
@NotUndefined



public class MailBlockClickHouse   {
  @JsonProperty("date")

  private LocalDate date = null;

  @JsonProperty("from")

  private String from = null;

  @JsonProperty("messageId")

  private String messageId = null;

  @JsonProperty("subject")

  private String subject = null;

  @JsonProperty("to")

  private String to = null;


  public MailBlockClickHouse date(LocalDate date) { 

    this.date = date;
    return this;
  }

  /**
   * The date the block event was recorded.
   * @return date
   **/
  
  @Schema(example = "Sun Aug 06 20:00:00 EDT 2023", required = true, description = "The date the block event was recorded.")
  
@Valid
  @NotNull
  public LocalDate getDate() {  
    return date;
  }



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
   **/
  
  @Schema(example = "user@domain.com", required = true, description = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
  
  @NotNull
  public String getFrom() {  
    return from;
  }



  public void setFrom(String from) { 

    this.from = from;
  }

  public MailBlockClickHouse messageId(String messageId) { 

    this.messageId = messageId;
    return this;
  }

  /**
   * The `Message-ID` header of the blocked message, or `null` if not present.
   * @return messageId
   **/
  
  @Schema(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", description = "The `Message-ID` header of the blocked message, or `null` if not present.")
  
  public String getMessageId() {
 
    return messageId;
  }



  public void setMessageId(String messageId) { 
    this.messageId = messageId;
  }

  public MailBlockClickHouse subject(String subject) { 

    this.subject = subject;
    return this;
  }

  /**
   * The `Subject` header of the blocked message.
   * @return subject
   **/
  
  @Schema(example = "Test Email", required = true, description = "The `Subject` header of the blocked message.")
  
  @NotNull
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
  
  @Schema(example = "['client@site.com']", required = true, description = "The serialized list of recipients of the blocked message.")
  
  @NotNull
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
    return Objects.equals(this.date, mailBlockClickHouse.date) &&
        Objects.equals(this.from, mailBlockClickHouse.from) &&
        Objects.equals(this.messageId, mailBlockClickHouse.messageId) &&
        Objects.equals(this.subject, mailBlockClickHouse.subject) &&
        Objects.equals(this.to, mailBlockClickHouse.to);
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
