package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.MailAttachment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Details for an Email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2025-07-19T04:18:56.581036886-04:00[America/New_York]")
public class SendMailAdv   {
  private String subject = null;
  private String body = null;
  private EmailAddressTypes from = null;
  private EmailAddressesTypes to = null;
  private EmailAddressesTypes replyto = null;
  private EmailAddressesTypes cc = null;
  private EmailAddressesTypes bcc = null;
  private List<MailAttachment> attachments = new ArrayList<MailAttachment>();
  private Long id = null;

  /**
   * The subject or title of the email
   **/
  
  @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject or title of the email")
  @JsonProperty("subject")
  @NotNull
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The main email contents.
   **/
  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", required = true, description = "The main email contents.")
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  /**
   **/
  
  @Schema(required = true, description = "")
  @JsonProperty("from")
  @NotNull
  public EmailAddressTypes getFrom() {
    return from;
  }
  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  /**
   **/
  
  @Schema(required = true, description = "")
  @JsonProperty("to")
  @NotNull
  public EmailAddressesTypes getTo() {
    return to;
  }
  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  /**
   **/
  
  @Schema(description = "")
  @JsonProperty("replyto")
  @NotNull
  public EmailAddressesTypes getReplyto() {
    return replyto;
  }
  public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  /**
   **/
  
  @Schema(description = "")
  @JsonProperty("cc")
  @NotNull
  public EmailAddressesTypes getCc() {
    return cc;
  }
  public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

  /**
   **/
  
  @Schema(description = "")
  @JsonProperty("bcc")
  @NotNull
  public EmailAddressesTypes getBcc() {
    return bcc;
  }
  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  /**
   * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
   **/
  
  @Schema(example = "[         {             \"filename\": \"text.txt\",             \"data\": \"base64_encoded_contents\"         } ]", description = "(optional) File attachments to include in the email.  The file contents must be base64 encoded!")
  @JsonProperty("attachments")
  @NotNull
  public List<MailAttachment> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }

  /**
   * (optional)  ID of the Mail order within our system to use as the Mail Account.
   **/
  
  @Schema(example = "5000", description = "(optional)  ID of the Mail order within our system to use as the Mail Account.")
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
