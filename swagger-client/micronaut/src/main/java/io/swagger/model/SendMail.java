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
 * Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
 */
@Schema(description = "Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.")
@Validated
@Introspected

public class SendMail   {
  @JsonProperty("to")
  private OneOfSendMailTo to = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("body")
  private String body = null;

  @JsonProperty("id")
  private Long id = null;

  public SendMail to(OneOfSendMailTo to) {
    this.to = to;
    return this;
  }

  /**
   * The primary recipient address.  Accepts a single email address string or an array of email address strings for multiple recipients.
   * @return to
  **/
  @Schema(required = true, description = "The primary recipient address.  Accepts a single email address string or an array of email address strings for multiple recipients.")
  @NotNull

  public OneOfSendMailTo getTo() {
    return to;
  }

  public void setTo(OneOfSendMailTo to) {
    this.to = to;
  }

  public SendMail from(String from) {
    this.from = from;
    return this;
  }

  /**
   * The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
   * @return from
  **/
  @Schema(example = "janedoe@company.com", required = true, description = "The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.")
  @NotNull

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public SendMail subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The subject line of the email.
   * @return subject
  **/
  @Schema(example = "Attention Client", required = true, description = "The subject line of the email.")
  @NotNull

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SendMail body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
   * @return body
  **/
  @Schema(example = "This is an email to inform you that something noteworthy happened.", required = true, description = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
  @NotNull

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public SendMail id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
   * @return id
  **/
  @Schema(example = "2604", description = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
  @NotNull

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMail sendMail = (SendMail) o;
    return Objects.equals(this.to, sendMail.to) &&
        Objects.equals(this.from, sendMail.from) &&
        Objects.equals(this.subject, sendMail.subject) &&
        Objects.equals(this.body, sendMail.body) &&
        Objects.equals(this.id, sendMail.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, subject, body, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMail {\n");
    
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
