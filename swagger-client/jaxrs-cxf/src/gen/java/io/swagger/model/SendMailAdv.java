package io.swagger.model;

import io.swagger.model.MailAttachment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

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
  * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 **/
@Schema(description="Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.")
public class SendMailAdv   {
  
  @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject line of the email.")
 /**
   * The subject line of the email.  
  **/
  private String subject = null;
  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered.", required = true, description = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
 /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.  
  **/
  private String body = null;
  
  @Schema(required = true, description = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.")
 /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.  
  **/
  private AllOfSendMailAdvFrom from = null;
  
  @Schema(required = true, description = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")
 /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.  
  **/
  private AllOfSendMailAdvTo to = null;
  
  @Schema(description = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")
 /**
   * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.  
  **/
  private AllOfSendMailAdvReplyto replyto = null;
  
  @Schema(description = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")
 /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.  
  **/
  private AllOfSendMailAdvCc cc = null;
  
  @Schema(description = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")
 /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.  
  **/
  private AllOfSendMailAdvBcc bcc = null;
  
  @Schema(description = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")
 /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.  
  **/
  private List<MailAttachment> attachments = null;
  
  @Schema(example = "5000", description = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
 /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.  
  **/
  private Long id = null;
 /**
   * The subject line of the email.
   * @return subject
  **/
  @JsonProperty("subject")
  @NotNull
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SendMailAdv subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
   * @return body
  **/
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public SendMailAdv body(String body) {
    this.body = body;
    return this;
  }

 /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.
   * @return from
  **/
  @JsonProperty("from")
  @NotNull
  public AllOfSendMailAdvFrom getFrom() {
    return from;
  }

  public void setFrom(AllOfSendMailAdvFrom from) {
    this.from = from;
  }

  public SendMailAdv from(AllOfSendMailAdvFrom from) {
    this.from = from;
    return this;
  }

 /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   * @return to
  **/
  @JsonProperty("to")
  @NotNull
  public AllOfSendMailAdvTo getTo() {
    return to;
  }

  public void setTo(AllOfSendMailAdvTo to) {
    this.to = to;
  }

  public SendMailAdv to(AllOfSendMailAdvTo to) {
    this.to = to;
    return this;
  }

 /**
   * Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
   * @return replyto
  **/
  @JsonProperty("replyto")
  @NotNull
  public AllOfSendMailAdvReplyto getReplyto() {
    return replyto;
  }

  public void setReplyto(AllOfSendMailAdvReplyto replyto) {
    this.replyto = replyto;
  }

  public SendMailAdv replyto(AllOfSendMailAdvReplyto replyto) {
    this.replyto = replyto;
    return this;
  }

 /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
   * @return cc
  **/
  @JsonProperty("cc")
  @NotNull
  public AllOfSendMailAdvCc getCc() {
    return cc;
  }

  public void setCc(AllOfSendMailAdvCc cc) {
    this.cc = cc;
  }

  public SendMailAdv cc(AllOfSendMailAdvCc cc) {
    this.cc = cc;
    return this;
  }

 /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   * @return bcc
  **/
  @JsonProperty("bcc")
  @NotNull
  public AllOfSendMailAdvBcc getBcc() {
    return bcc;
  }

  public void setBcc(AllOfSendMailAdvBcc bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv bcc(AllOfSendMailAdvBcc bcc) {
    this.bcc = bcc;
    return this;
  }

 /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
   * @return attachments
  **/
  @JsonProperty("attachments")
  @NotNull
  public List<MailAttachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }

  public SendMailAdv attachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public SendMailAdv addAttachmentsItem(MailAttachment attachmentsItem) {
    this.attachments.add(attachmentsItem);
    return this;
  }

 /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
   * @return id
  **/
  @JsonProperty("id")
  @NotNull
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SendMailAdv id(Long id) {
    this.id = id;
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
