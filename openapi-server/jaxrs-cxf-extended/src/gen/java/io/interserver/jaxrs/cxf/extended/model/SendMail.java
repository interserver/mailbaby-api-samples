package io.interserver.jaxrs.cxf.extended.model;

import io.interserver.jaxrs.cxf.extended.model.SendMailTo;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.
 */
@ApiModel(description="Request body for `POST /mail/send`.  Sends a simple single-recipient message. HTML detection is automatic — if `body` contains HTML tags the message is sent as `text/html`; otherwise as `text/plain`.  The `from` address is automatically set as both the `From` and `Reply-To` headers.  For multiple recipients, CC/BCC, attachments, or per-field Reply-To control, use `POST /mail/advsend` instead.")

public class SendMail  {
  
  @ApiModelProperty(required = true, value = "")
  @Valid
  private SendMailTo to;

 /**
  * The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
  */
  @ApiModelProperty(example = "janedoe@company.com", required = true, value = "The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.")
  private String from;

 /**
  * The subject line of the email.
  */
  @ApiModelProperty(example = "Attention Client", required = true, value = "The subject line of the email.")
  private String subject;

 /**
  * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
  */
  @ApiModelProperty(example = "This is an email to inform you that something noteworthy happened.", required = true, value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
  private String body;

 /**
  * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  */
  @ApiModelProperty(example = "2604", value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
  private Long id;
 /**
  * Get to
  * @return to
  */
  @JsonProperty("to")
  @NotNull
  public SendMailTo getTo() {
    return to;
  }

  /**
   * Sets the <code>to</code> property.
   */
 public void setTo(SendMailTo to) {
    this.to = to;
  }

  /**
   * Sets the <code>to</code> property.
   */
  public SendMail to(SendMailTo to) {
    this.to = to;
    return this;
  }

 /**
  * The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.
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
  public SendMail from(String from) {
    this.from = from;
    return this;
  }

 /**
  * The subject line of the email.
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
  public SendMail subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
  * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
  * @return body
  */
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }

  /**
   * Sets the <code>body</code> property.
   */
 public void setBody(String body) {
    this.body = body;
  }

  /**
   * Sets the <code>body</code> property.
   */
  public SendMail body(String body) {
    this.body = body;
    return this;
  }

 /**
  * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
  * @return id
  */
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  /**
   * Sets the <code>id</code> property.
   */
 public void setId(Long id) {
    this.id = id;
  }

  /**
   * Sets the <code>id</code> property.
   */
  public SendMail id(Long id) {
    this.id = id;
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
  private static String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

