package apimodels;

import apimodels.EmailAddressTypes;
import apimodels.EmailAddressesTypes;
import apimodels.MailAttachment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;
import javax.validation.*;
import java.util.Objects;
import javax.validation.constraints.*;
import javax.validation.Valid;
/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class SendMailAdv   {
  @JsonProperty("subject")
  @NotNull

  private String subject;

  @JsonProperty("body")
  @NotNull

  private String body;

  @JsonProperty("from")
  @NotNull
@Valid

  private EmailAddressTypes from;

  @JsonProperty("to")
  @NotNull
@Valid

  private EmailAddressesTypes to;

  @JsonProperty("replyto")
  @Valid

  private EmailAddressesTypes replyto;

  @JsonProperty("cc")
  @Valid

  private EmailAddressesTypes cc;

  @JsonProperty("bcc")
  @Valid

  private EmailAddressesTypes bcc;

  @JsonProperty("attachments")
  @Valid

  private List<@Valid MailAttachment> attachments = null;

  @JsonProperty("id")
  
  private Long id;

  public SendMailAdv subject(String subject) {
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

  public SendMailAdv body(String body) {
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

  public SendMailAdv from(EmailAddressTypes from) {
    this.from = from;
    return this;
  }

   /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
   * @return from
  **/
  public EmailAddressTypes getFrom() {
    return from;
  }

  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  public SendMailAdv to(EmailAddressesTypes to) {
    this.to = to;
    return this;
  }

   /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   * @return to
  **/
  public EmailAddressesTypes getTo() {
    return to;
  }

  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  public SendMailAdv replyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
    return this;
  }

   /**
   * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
   * @return replyto
  **/
  public EmailAddressesTypes getReplyto() {
    return replyto;
  }

  public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  public SendMailAdv cc(EmailAddressesTypes cc) {
    this.cc = cc;
    return this;
  }

   /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
   * @return cc
  **/
  public EmailAddressesTypes getCc() {
    return cc;
  }

  public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

  public SendMailAdv bcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
    return this;
  }

   /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   * @return bcc
  **/
  public EmailAddressesTypes getBcc() {
    return bcc;
  }

  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv attachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public SendMailAdv addAttachmentsItem(MailAttachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

   /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
   * @return attachments
  **/
  public List<@Valid MailAttachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
  }

  public SendMailAdv id(Long id) {
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

  @SuppressWarnings("StringBufferReplaceableByString")
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

