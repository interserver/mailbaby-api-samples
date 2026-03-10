package org.openapitools.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.MailAttachment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
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

  @ApiModelProperty(required = true, value = "")

  private EmailAddressTypes from;

  @ApiModelProperty(required = true, value = "")

  private EmailAddressesTypes to;

  @ApiModelProperty(value = "")

  private EmailAddressesTypes replyto;

  @ApiModelProperty(value = "")

  private EmailAddressesTypes cc;

  @ApiModelProperty(value = "")

  private EmailAddressesTypes bcc;

 /**
  * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
  */
  @ApiModelProperty(value = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")

  private List<MailAttachment> attachments = new ArrayList<>();

 /**
  * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
  */
  @ApiModelProperty(example = "5000", value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")

  private Long id;
 /**
   * The subject line of the email.
   * @return subject
  **/
  @JsonProperty("subject")
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
   * Get from
   * @return from
  **/
  @JsonProperty("from")
  public EmailAddressTypes getFrom() {
    return from;
  }

  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  public SendMailAdv from(EmailAddressTypes from) {
    this.from = from;
    return this;
  }

 /**
   * Get to
   * @return to
  **/
  @JsonProperty("to")
  public EmailAddressesTypes getTo() {
    return to;
  }

  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  public SendMailAdv to(EmailAddressesTypes to) {
    this.to = to;
    return this;
  }

 /**
   * Get replyto
   * @return replyto
  **/
  @JsonProperty("replyto")
  public EmailAddressesTypes getReplyto() {
    return replyto;
  }

  public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  public SendMailAdv replyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
    return this;
  }

 /**
   * Get cc
   * @return cc
  **/
  @JsonProperty("cc")
  public EmailAddressesTypes getCc() {
    return cc;
  }

  public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

  public SendMailAdv cc(EmailAddressesTypes cc) {
    this.cc = cc;
    return this;
  }

 /**
   * Get bcc
   * @return bcc
  **/
  @JsonProperty("bcc")
  public EmailAddressesTypes getBcc() {
    return bcc;
  }

  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv bcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
    return this;
  }

 /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
   * @return attachments
  **/
  @JsonProperty("attachments")
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
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

