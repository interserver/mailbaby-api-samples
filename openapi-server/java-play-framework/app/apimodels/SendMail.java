package apimodels;

import apimodels.SendMailTo;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * Request body for &#x60;POST /mail/send&#x60;.  Sends a simple single-recipient message. HTML detection is automatic — if &#x60;body&#x60; contains HTML tags the message is sent as &#x60;text/html&#x60;; otherwise as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is automatically set as both the &#x60;From&#x60; and &#x60;Reply-To&#x60; headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use &#x60;POST /mail/advsend&#x60; instead.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class SendMail   {
  @JsonProperty("to")
  @NotNull
@Valid

  private SendMailTo to;

  @JsonProperty("from")
  @NotNull

  private String from;

  @JsonProperty("subject")
  @NotNull

  private String subject;

  @JsonProperty("body")
  @NotNull

  private String body;

  @JsonProperty("id")
  
  private Long id;

  public SendMail to(SendMailTo to) {
    this.to = to;
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  public SendMailTo getTo() {
    return to;
  }

  public void setTo(SendMailTo to) {
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
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMail sendMail = (SendMail) o;
    return Objects.equals(to, sendMail.to) &&
        Objects.equals(from, sendMail.from) &&
        Objects.equals(subject, sendMail.subject) &&
        Objects.equals(body, sendMail.body) &&
        Objects.equals(id, sendMail.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, subject, body, id);
  }

  @SuppressWarnings("StringBufferReplaceableByString")
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

