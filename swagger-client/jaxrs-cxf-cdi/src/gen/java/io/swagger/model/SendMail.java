package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
/**
 * Details for an Email
 **/
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

import javax.xml.bind.annotation.*;

@Schema(description = "Details for an Email")

public class SendMail   {
  private Long id = null;
  private MailContact from = null;
  private List<MailContact> to = new ArrayList<MailContact>();
  private String subject = null;
  private String body = null;
  private List<MailContact> replyto = new ArrayList<MailContact>();
  private List<MailContact> cc = new ArrayList<MailContact>();
  private List<MailContact> bcc = new ArrayList<MailContact>();
  private List<MailAttachment> attachments = new ArrayList<MailAttachment>();

  /**
   * The ID of the Mail order within our system to use as the Mail Account.
   **/
  public SendMail id(Long id) {
    this.id = id;
    return this;
  }

  
  
  @Schema(required = true, description = "The ID of the Mail order within our system to use as the Mail Account.")
  @JsonProperty("id")
  @NotNull
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  public SendMail from(MailContact from) {
    this.from = from;
    return this;
  }

  
  
  @Schema(required = true, description = "")
  @JsonProperty("from")
  @NotNull
  @Valid
  public MailContact getFrom() {
    return from;
  }
  public void setFrom(MailContact from) {
    this.from = from;
  }

  /**
   * The Contact whom is the primary recipient of this email.
   **/
  public SendMail to(List<MailContact> to) {
    this.to = to;
    return this;
  }

  
  
  @Schema(required = true, description = "The Contact whom is the primary recipient of this email.")
  @JsonProperty("to")
  @NotNull
  @Valid
  public List<MailContact> getTo() {
    return to;
  }
  public void setTo(List<MailContact> to) {
    this.to = to;
  }

  /**
   * The subject or title of the email
   **/
  public SendMail subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  
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
  public SendMail body(String body) {
    this.body = body;
    return this;
  }

  
  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. ", required = true, description = "The main email contents.")
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
   **/
  public SendMail replyto(List<MailContact> replyto) {
    this.replyto = replyto;
    return this;
  }

  
  
  @Schema(description = "Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.")
  @JsonProperty("replyto")
  @Valid
  public List<MailContact> getReplyto() {
    return replyto;
  }
  public void setReplyto(List<MailContact> replyto) {
    this.replyto = replyto;
  }

  /**
   * Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
   **/
  public SendMail cc(List<MailContact> cc) {
    this.cc = cc;
    return this;
  }

  
  
  @Schema(description = "Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
  @JsonProperty("cc")
  @Valid
  public List<MailContact> getCc() {
    return cc;
  }
  public void setCc(List<MailContact> cc) {
    this.cc = cc;
  }

  /**
   * Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
   **/
  public SendMail bcc(List<MailContact> bcc) {
    this.bcc = bcc;
    return this;
  }

  
  
  @Schema(description = "Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
  @JsonProperty("bcc")
  @Valid
  public List<MailContact> getBcc() {
    return bcc;
  }
  public void setBcc(List<MailContact> bcc) {
    this.bcc = bcc;
  }

  /**
   * Optional file attachments to include in the email
   **/
  public SendMail attachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  
  
  @Schema(description = "Optional file attachments to include in the email")
  @JsonProperty("attachments")
  @Valid
  public List<MailAttachment> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMail sendMail = (SendMail) o;
    return Objects.equals(id, sendMail.id) &&
        Objects.equals(from, sendMail.from) &&
        Objects.equals(to, sendMail.to) &&
        Objects.equals(subject, sendMail.subject) &&
        Objects.equals(body, sendMail.body) &&
        Objects.equals(replyto, sendMail.replyto) &&
        Objects.equals(cc, sendMail.cc) &&
        Objects.equals(bcc, sendMail.bcc) &&
        Objects.equals(attachments, sendMail.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, from, to, subject, body, replyto, cc, bcc, attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMail {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    replyto: ").append(toIndentedString(replyto)).append("\n");
    sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
    sb.append("    bcc: ").append(toIndentedString(bcc)).append("\n");
    sb.append("    attachments: ").append(toIndentedString(attachments)).append("\n");
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