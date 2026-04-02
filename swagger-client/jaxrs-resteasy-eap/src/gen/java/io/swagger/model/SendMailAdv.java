package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.MailAttachment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.")

public class SendMailAdv   {
  private String subject = null;
  private String body = null;
  private AllOfSendMailAdvFrom from = null;
  private AllOfSendMailAdvTo to = null;
  private AllOfSendMailAdvReplyto replyto = null;
  private AllOfSendMailAdvCc cc = null;
  private AllOfSendMailAdvBcc bcc = null;
  private List<MailAttachment> attachments = new ArrayList<MailAttachment>();
  private Long id = null;

  /**
   * The subject line of the email.
   **/
  
  @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject line of the email.")
  @JsonProperty("subject")
  @NotNull
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
   **/
  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered.", required = true, description = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.
   **/
  
  @Schema(required = true, description = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.")
  @JsonProperty("from")
  @NotNull
  public AllOfSendMailAdvFrom getFrom() {
    return from;
  }
  public void setFrom(AllOfSendMailAdvFrom from) {
    this.from = from;
  }

  /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   **/
  
  @Schema(required = true, description = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")
  @JsonProperty("to")
  @NotNull
  public AllOfSendMailAdvTo getTo() {
    return to;
  }
  public void setTo(AllOfSendMailAdvTo to) {
    this.to = to;
  }

  /**
   * Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
   **/
  
  @Schema(description = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")
  @JsonProperty("replyto")
  @NotNull
  public AllOfSendMailAdvReplyto getReplyto() {
    return replyto;
  }
  public void setReplyto(AllOfSendMailAdvReplyto replyto) {
    this.replyto = replyto;
  }

  /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
   **/
  
  @Schema(description = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")
  @JsonProperty("cc")
  @NotNull
  public AllOfSendMailAdvCc getCc() {
    return cc;
  }
  public void setCc(AllOfSendMailAdvCc cc) {
    this.cc = cc;
  }

  /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   **/
  
  @Schema(description = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")
  @JsonProperty("bcc")
  @NotNull
  public AllOfSendMailAdvBcc getBcc() {
    return bcc;
  }
  public void setBcc(AllOfSendMailAdvBcc bcc) {
    this.bcc = bcc;
  }

  /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
   **/
  
  @Schema(description = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")
  @JsonProperty("attachments")
  @NotNull
  public List<MailAttachment> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }

  /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
   **/
  
  @Schema(example = "5000", description = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
  @JsonProperty("id")
  @NotNull
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
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
