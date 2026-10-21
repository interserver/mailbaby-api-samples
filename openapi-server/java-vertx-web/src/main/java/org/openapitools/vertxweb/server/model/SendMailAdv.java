package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.vertxweb.server.model.EmailAddressTypes;
import org.openapitools.vertxweb.server.model.EmailAddressesTypes;
import org.openapitools.vertxweb.server.model.MailAttachment;

/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMailAdv   {
  
  private String subject;
  private String body;
  private EmailAddressTypes from;
  private EmailAddressesTypes to;
  private EmailAddressesTypes replyto;
  private EmailAddressesTypes cc;
  private EmailAddressesTypes bcc;
  private List<MailAttachment> attachments = new ArrayList<>();
  private Long id;

  public SendMailAdv () {

  }

  public SendMailAdv (String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, Long id) {
    this.subject = subject;
    this.body = body;
    this.from = from;
    this.to = to;
    this.replyto = replyto;
    this.cc = cc;
    this.bcc = bcc;
    this.attachments = attachments;
    this.id = id;
  }

    
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

    
  @JsonProperty("body")
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

    
  @JsonProperty("from")
  public EmailAddressTypes getFrom() {
    return from;
  }
  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

    
  @JsonProperty("to")
  public EmailAddressesTypes getTo() {
    return to;
  }
  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

    
  @JsonProperty("replyto")
  public EmailAddressesTypes getReplyto() {
    return replyto;
  }
  public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

    
  @JsonProperty("cc")
  public EmailAddressesTypes getCc() {
    return cc;
  }
  public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

    
  @JsonProperty("bcc")
  public EmailAddressesTypes getBcc() {
    return bcc;
  }
  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

    
  @JsonProperty("attachments")
  public List<MailAttachment> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }

    
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
