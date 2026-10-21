package io.interserver.jaxrs.cxf.extended.model;

import io.interserver.jaxrs.cxf.extended.model.EmailAddressTypes;
import io.interserver.jaxrs.cxf.extended.model.EmailAddressesTypes;
import io.interserver.jaxrs.cxf.extended.model.MailAttachment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 */
@ApiModel(description="Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.")

public class SendMailAdv  {
  
 /**
  * The subject line of the email.
  */
  @ApiModelProperty(example = "Your Package has been Delivered!", required = true, value = "The subject line of the email.")
  private String subject;

 /**
  * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
  */
  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered.", required = true, value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
  private String body;

 /**
  * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
  */
  @ApiModelProperty(required = true, value = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.")
  @Valid
  private EmailAddressTypes from;

 /**
  * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
  */
  @ApiModelProperty(required = true, value = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")
  @Valid
  private EmailAddressesTypes to;

 /**
  * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
  */
  @ApiModelProperty(value = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")
  @Valid
  private EmailAddressesTypes replyto;

 /**
  * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
  */
  @ApiModelProperty(value = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")
  @Valid
  private EmailAddressesTypes cc;

 /**
  * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
  */
  @ApiModelProperty(value = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")
  @Valid
  private EmailAddressesTypes bcc;

 /**
  * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
  */
  @ApiModelProperty(value = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")
  private List<@Valid MailAttachment> attachments = new ArrayList<>();

 /**
  * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  */
  @ApiModelProperty(example = "5000", value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
  private Long id;
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
  public SendMailAdv subject(String subject) {
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
  public SendMailAdv body(String body) {
    this.body = body;
    return this;
  }

 /**
  * The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.
  * @return from
  */
  @JsonProperty("from")
  @NotNull
  public EmailAddressTypes getFrom() {
    return from;
  }

  /**
   * Sets the <code>from</code> property.
   */
 public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  /**
   * Sets the <code>from</code> property.
   */
  public SendMailAdv from(EmailAddressTypes from) {
    this.from = from;
    return this;
  }

 /**
  * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
  * @return to
  */
  @JsonProperty("to")
  @NotNull
  public EmailAddressesTypes getTo() {
    return to;
  }

  /**
   * Sets the <code>to</code> property.
   */
 public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  /**
   * Sets the <code>to</code> property.
   */
  public SendMailAdv to(EmailAddressesTypes to) {
    this.to = to;
    return this;
  }

 /**
  * Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
  * @return replyto
  */
  @JsonProperty("replyto")
  public EmailAddressesTypes getReplyto() {
    return replyto;
  }

  /**
   * Sets the <code>replyto</code> property.
   */
 public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  /**
   * Sets the <code>replyto</code> property.
   */
  public SendMailAdv replyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
    return this;
  }

 /**
  * Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
  * @return cc
  */
  @JsonProperty("cc")
  public EmailAddressesTypes getCc() {
    return cc;
  }

  /**
   * Sets the <code>cc</code> property.
   */
 public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

  /**
   * Sets the <code>cc</code> property.
   */
  public SendMailAdv cc(EmailAddressesTypes cc) {
    this.cc = cc;
    return this;
  }

 /**
  * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
  * @return bcc
  */
  @JsonProperty("bcc")
  public EmailAddressesTypes getBcc() {
    return bcc;
  }

  /**
   * Sets the <code>bcc</code> property.
   */
 public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  /**
   * Sets the <code>bcc</code> property.
   */
  public SendMailAdv bcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
    return this;
  }

 /**
  * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
  * @return attachments
  */
  @JsonProperty("attachments")
  public List<@Valid MailAttachment> getAttachments() {
    return attachments;
  }

  /**
   * Sets the <code>attachments</code> property.
   */
 public void setAttachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
  }

  /**
   * Sets the <code>attachments</code> property.
   */
  public SendMailAdv attachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  /**
   * Adds a new item to the <code>attachments</code> list.
   */
  public SendMailAdv addAttachmentsItem(MailAttachment attachmentsItem) {
    this.attachments.add(attachmentsItem);
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
  public SendMailAdv id(Long id) {
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
    SendMailAdv sendMailAdv = (SendMailAdv) o;
    return Objects.equals(this.subject, sendMailAdv.subject) &&
        Objects.equals(this.body, sendMailAdv.body) &&
        Objects.equals(this.from, sendMailAdv.from) &&
        Objects.equals(this.to, sendMailAdv.to) &&
        Objects.equals(this.replyto, sendMailAdv.replyto) &&
        Objects.equals(this.cc, sendMailAdv.cc) &&
        Objects.equals(this.bcc, sendMailAdv.bcc) &&
        Objects.equals(this.attachments, sendMailAdv.attachments) &&
        Objects.equals(this.id, sendMailAdv.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, body, from, to, replyto, cc, bcc, attachments, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdv {\n");
    
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    replyto: ").append(toIndentedString(replyto)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    bcc: ").append(toIndentedString(bcc)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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

