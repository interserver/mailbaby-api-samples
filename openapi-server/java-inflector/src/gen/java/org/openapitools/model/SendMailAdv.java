package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.MailAttachment;



/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 **/

@ApiModel(description = "Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", comments = "Generator version: 7.26.0")
public class SendMailAdv   {
  @JsonProperty("subject")
  private String subject;

  @JsonProperty("body")
  private String body;

  @JsonProperty("from")
  private EmailAddressTypes from;

  @JsonProperty("to")
  private EmailAddressesTypes to;

  @JsonProperty("replyto")
  private EmailAddressesTypes replyto;

  @JsonProperty("cc")
  private EmailAddressesTypes cc;

  @JsonProperty("bcc")
  private EmailAddressesTypes bcc;

  @JsonProperty("attachments")
  private List<MailAttachment> attachments = null;

  @JsonProperty("id")
  private Long id;

  /**
   * The subject line of the email.
   **/
  public SendMailAdv subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(example = "Your Package has been Delivered!", required = true, value = "The subject line of the email.")
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
   **/
  public SendMailAdv body(String body) {
    this.body = body;
    return this;
  }

  
  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered.", required = true, value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
  @JsonProperty("body")
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
   **/
  public SendMailAdv from(EmailAddressTypes from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.")
  @JsonProperty("from")
  public EmailAddressTypes getFrom() {
    return from;
  }
  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   **/
  public SendMailAdv to(EmailAddressesTypes to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")
  @JsonProperty("to")
  public EmailAddressesTypes getTo() {
    return to;
  }
  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  /**
   * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
   **/
  public SendMailAdv replyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
    return this;
  }

  
  @ApiModelProperty(value = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")
  @JsonProperty("replyto")
  public EmailAddressesTypes getReplyto() {
    return replyto;
  }
  public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
   **/
  public SendMailAdv cc(EmailAddressesTypes cc) {
    this.cc = cc;
    return this;
  }

  
  @ApiModelProperty(value = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")
  @JsonProperty("cc")
  public EmailAddressesTypes getCc() {
    return cc;
  }
  public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

  /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   **/
  public SendMailAdv bcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
    return this;
  }

  
  @ApiModelProperty(value = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")
  @JsonProperty("bcc")
  public EmailAddressesTypes getBcc() {
    return bcc;
  }
  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
   **/
  public SendMailAdv attachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  
  @ApiModelProperty(value = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")
  @JsonProperty("attachments")
  public List<MailAttachment> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }

  /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
   **/
  public SendMailAdv id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "5000", value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
  @JsonProperty("id")
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
    SendMailAdv sendMailAdv = (SendMailAdv) o;
    return Objects.equals(subject, sendMailAdv.subject) &&
        Objects.equals(body, sendMailAdv.body) &&
        Objects.equals(from, sendMailAdv.from) &&
        Objects.equals(to, sendMailAdv.to) &&
        Objects.equals(replyto, sendMailAdv.replyto) &&
        Objects.equals(cc, sendMailAdv.cc) &&
        Objects.equals(bcc, sendMailAdv.bcc) &&
        Objects.equals(attachments, sendMailAdv.attachments) &&
        Objects.equals(id, sendMailAdv.id);
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

