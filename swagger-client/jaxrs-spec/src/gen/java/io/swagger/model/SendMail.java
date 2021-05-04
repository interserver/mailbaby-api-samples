package io.swagger.model;

import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Details for an Email
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "Details for an Email")

public class SendMail   {

  private @Valid Long id = null;

  private @Valid MailContact from = null;

  private @Valid List<MailContact> to = new ArrayList<MailContact>();

  private @Valid String subject = null;

  private @Valid String body = null;

  private @Valid List<MailContact> replyto = new ArrayList<MailContact>();

  private @Valid List<MailContact> cc = new ArrayList<MailContact>();

  private @Valid List<MailContact> bcc = new ArrayList<MailContact>();

  private @Valid List<MailAttachment> attachments = new ArrayList<MailAttachment>();

  /**
   * The ID of the Mail order within our system to use as the Mail Account.
   **/
  public SendMail id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The ID of the Mail order within our system to use as the Mail Account.")
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

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("from")
  @NotNull

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

  
  @ApiModelProperty(required = true, value = "The Contact whom is the primary recipient of this email.")
  @JsonProperty("to")
  @NotNull

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

  
  @ApiModelProperty(example = "Your Package has been Delivered!", required = true, value = "The subject or title of the email")
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

  
  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. ", required = true, value = "The main email contents.")
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

  
  @ApiModelProperty(value = "Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.")
  @JsonProperty("replyto")

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

  
  @ApiModelProperty(value = "Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
  @JsonProperty("cc")

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

  
  @ApiModelProperty(value = "Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
  @JsonProperty("bcc")

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

  
  @ApiModelProperty(value = "Optional file attachments to include in the email")
  @JsonProperty("attachments")

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
