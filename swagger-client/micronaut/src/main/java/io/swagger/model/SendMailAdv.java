package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.MailAttachment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details for an Email
 */
@Schema(description = "Details for an Email")
@Validated
@Introspected
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2025-10-06T16:15:25.436344464-04:00[America/New_York]")
public class SendMailAdv   {
  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("body")
  private String body = null;

  @JsonProperty("from")
  private EmailAddressTypes from = null;

  @JsonProperty("to")
  private EmailAddressesTypes to = null;

  @JsonProperty("replyto")
  private EmailAddressesTypes replyto = null;

  @JsonProperty("cc")
  private EmailAddressesTypes cc = null;

  @JsonProperty("bcc")
  private EmailAddressesTypes bcc = null;

  @JsonProperty("attachments")
  @Valid
  private List<MailAttachment> attachments = null;

  @JsonProperty("id")
  private Long id = null;

  public SendMailAdv subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The subject or title of the email
   * @return subject
  **/
  @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject or title of the email")
  @NotNull

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
   * The main email contents.
   * @return body
  **/
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", required = true, description = "The main email contents.")
  @NotNull

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
   * Get from
   * @return from
  **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
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
   * Get to
   * @return to
  **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
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
   * Get replyto
   * @return replyto
  **/
  @Schema(description = "")
  @NotNull

  @Valid
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
   * Get cc
   * @return cc
  **/
  @Schema(description = "")
  @NotNull

  @Valid
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
   * Get bcc
   * @return bcc
  **/
  @Schema(description = "")
  @NotNull

  @Valid
  public EmailAddressesTypes getBcc() {
    return bcc;
  }

  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv attachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public SendMailAdv addAttachmentsItem(MailAttachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<MailAttachment>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
   * @return attachments
  **/
  @Schema(example = "[         {             \"filename\": \"text.txt\",             \"data\": \"base64_encoded_contents\"         } ]", description = "(optional) File attachments to include in the email.  The file contents must be base64 encoded!")
  @NotNull
  @Valid
  public List<MailAttachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }

  public SendMailAdv id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * (optional)  ID of the Mail order within our system to use as the Mail Account.
   * @return id
  **/
  @Schema(example = "5000", description = "(optional)  ID of the Mail order within our system to use as the Mail Account.")
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
