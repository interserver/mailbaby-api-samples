package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (&#x60;LOCAL_BL_RCPT&#x60; or &#x60;MBTRAP&#x60;). The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 **/
@ApiModel(description = "A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
@JsonTypeName("MailBlockClickHouse")
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class MailBlockClickHouse   {
  private LocalDate date;
  private String from;
  private String subject;
  private String to;
  private String messageId;

  public MailBlockClickHouse() {
  }

  @JsonCreator
  public MailBlockClickHouse(
    @JsonProperty(required = true, value = "date") LocalDate date,
    @JsonProperty(required = true, value = "from") String from,
    @JsonProperty(required = true, value = "subject") String subject,
    @JsonProperty(required = true, value = "to") String to
  ) {
    this.date = date;
    this.from = from;
    this.subject = subject;
    this.to = to;
  }

  /**
   * The date the block event was recorded.
   **/
  public MailBlockClickHouse date(LocalDate date) {
    this.date = date;
    return this;
  }

  
  @ApiModelProperty(example = "2023-08-07", required = true, value = "The date the block event was recorded.")
  @JsonProperty(required = true, value = "date")
  @NotNull public LocalDate getDate() {
    return date;
  }

  @JsonProperty(required = true, value = "date")
  public void setDate(LocalDate date) {
    this.date = date;
  }

  /**
   * The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
   **/
  public MailBlockClickHouse from(String from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.")
  @JsonProperty(required = true, value = "from")
  @NotNull public String getFrom() {
    return from;
  }

  @JsonProperty(required = true, value = "from")
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * The &#x60;Subject&#x60; header of the blocked message.
   **/
  public MailBlockClickHouse subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(example = "Test Email", required = true, value = "The `Subject` header of the blocked message.")
  @JsonProperty(required = true, value = "subject")
  @NotNull public String getSubject() {
    return subject;
  }

  @JsonProperty(required = true, value = "subject")
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

  
  @ApiModelProperty(example = "['client@site.com']", required = true, value = "The serialized list of recipients of the blocked message.")
  @JsonProperty(required = true, value = "to")
  @NotNull public String getTo() {
    return to;
  }

  @JsonProperty(required = true, value = "to")
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
   **/
  public MailBlockClickHouse messageId(String messageId) {
    this.messageId = messageId;
    return this;
  }

  
  @ApiModelProperty(example = "pFaRqFUEWkucjhTuIzYuoAgWU@domain.com", value = "The `Message-ID` header of the blocked message, or `null` if not present.")
  @JsonProperty("messageId")
  public String getMessageId() {
    return messageId;
  }

  @JsonProperty("messageId")
  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * Creates the property if it does not already exist, otherwise replaces it.
   * @param key the name of the property
   * @param value the value of the property
   * @return self reference
   */
  @JsonAnySetter
  public MailBlockClickHouse putAdditionalProperty(String key, Object value) {
    this.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) properties.
   * @return the additional (undeclared) properties
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   * @param key the name of the property
   * @return the additional (undeclared) property with the specified name
   */
  public Object getAdditionalProperty(String key) {
    return this.get(key);
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
