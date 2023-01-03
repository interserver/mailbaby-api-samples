package io.swagger.model;

import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;
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

public class SendMailAdv   {

  private @Valid String subject = null;

  private @Valid String body = null;

  private @Valid SendMailAdvFrom from = null;

  private @Valid List<SendMailAdvTo> to = new ArrayList<SendMailAdvTo>();

  private @Valid List<SendMailAdvReplyto> replyto = new ArrayList<SendMailAdvReplyto>();

  private @Valid List<SendMailAdvCc> cc = new ArrayList<SendMailAdvCc>();

  private @Valid List<SendMailAdvBcc> bcc = new ArrayList<SendMailAdvBcc>();

  private @Valid List<SendMailAdvAttachments> attachments = new ArrayList<SendMailAdvAttachments>();

  private @Valid Long id = null;

  /**
   * The subject or title of the email
   **/
  public SendMailAdv subject(String subject) {
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
  public SendMailAdv body(String body) {
    this.body = body;
    return this;
  }

  
  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", required = true, value = "The main email contents.")
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
  public SendMailAdv from(SendMailAdvFrom from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("from")
  @NotNull

  public SendMailAdvFrom getFrom() {
    return from;
  }
  public void setFrom(SendMailAdvFrom from) {
    this.from = from;
  }

  /**
   * A list of destionation email addresses to send this to
   **/
  public SendMailAdv to(List<SendMailAdvTo> to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "A list of destionation email addresses to send this to")
  @JsonProperty("to")
  @NotNull

  public List<SendMailAdvTo> getTo() {
    return to;
  }
  public void setTo(List<SendMailAdvTo> to) {
    this.to = to;
  }

  /**
   * (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
   **/
  public SendMailAdv replyto(List<SendMailAdvReplyto> replyto) {
    this.replyto = replyto;
    return this;
  }

  
  @ApiModelProperty(value = "(optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.")
  @JsonProperty("replyto")

  public List<SendMailAdvReplyto> getReplyto() {
    return replyto;
  }
  public void setReplyto(List<SendMailAdvReplyto> replyto) {
    this.replyto = replyto;
  }

  /**
   * (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
   **/
  public SendMailAdv cc(List<SendMailAdvCc> cc) {
    this.cc = cc;
    return this;
  }

  
  @ApiModelProperty(value = "(optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
  @JsonProperty("cc")

  public List<SendMailAdvCc> getCc() {
    return cc;
  }
  public void setCc(List<SendMailAdvCc> cc) {
    this.cc = cc;
  }

  /**
   * (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
   **/
  public SendMailAdv bcc(List<SendMailAdvBcc> bcc) {
    this.bcc = bcc;
    return this;
  }

  
  @ApiModelProperty(value = "(optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
  @JsonProperty("bcc")

  public List<SendMailAdvBcc> getBcc() {
    return bcc;
  }
  public void setBcc(List<SendMailAdvBcc> bcc) {
    this.bcc = bcc;
  }

  /**
   * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
   **/
  public SendMailAdv attachments(List<SendMailAdvAttachments> attachments) {
    this.attachments = attachments;
    return this;
  }

  
  @ApiModelProperty(value = "(optional) File attachments to include in the email.  The file contents must be base64 encoded!")
  @JsonProperty("attachments")

  public List<SendMailAdvAttachments> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<SendMailAdvAttachments> attachments) {
    this.attachments = attachments;
  }

  /**
   * (optional)  ID of the Mail order within our system to use as the Mail Account.
   **/
  public SendMailAdv id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "5000", value = "(optional)  ID of the Mail order within our system to use as the Mail Account.")
  @JsonProperty("id")

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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
