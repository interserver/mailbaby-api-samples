package io.swagger.model;

import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.SendMailAdvFrom;
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

  private @Valid List<SendMailAdvFrom> from = new ArrayList<SendMailAdvFrom>();

  private @Valid List<MailContact> to = new ArrayList<MailContact>();

  private @Valid Long id = null;

  private @Valid List<MailContact> replyto = new ArrayList<MailContact>();

  private @Valid List<MailContact> cc = new ArrayList<MailContact>();

  private @Valid List<MailContact> bcc = new ArrayList<MailContact>();

  private @Valid List<MailAttachment> attachments = new ArrayList<MailAttachment>();

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
   * The contact whom is the this email is from.
   **/
  public SendMailAdv from(List<SendMailAdvFrom> from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The contact whom is the this email is from.")
  @JsonProperty("from")
  @NotNull

  public List<SendMailAdvFrom> getFrom() {
    return from;
  }
  public void setFrom(List<SendMailAdvFrom> from) {
    this.from = from;
  }

  /**
   * The Contact whom is the primary recipient of this email.
   **/
  public SendMailAdv to(List<MailContact> to) {
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
   * The ID of the Mail order within our system to use as the Mail Account.
   **/
  public SendMailAdv id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "5000", required = true, value = "The ID of the Mail order within our system to use as the Mail Account.")
  @JsonProperty("id")
  @NotNull

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
   **/
  public SendMailAdv replyto(List<MailContact> replyto) {
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
  public SendMailAdv cc(List<MailContact> cc) {
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
  public SendMailAdv bcc(List<MailContact> bcc) {
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
  public SendMailAdv attachments(List<MailAttachment> attachments) {
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
    SendMailAdv sendMailAdv = (SendMailAdv) o;
    return Objects.equals(subject, sendMailAdv.subject) &&
        Objects.equals(body, sendMailAdv.body) &&
        Objects.equals(from, sendMailAdv.from) &&
        Objects.equals(to, sendMailAdv.to) &&
        Objects.equals(id, sendMailAdv.id) &&
        Objects.equals(replyto, sendMailAdv.replyto) &&
        Objects.equals(cc, sendMailAdv.cc) &&
        Objects.equals(bcc, sendMailAdv.bcc) &&
        Objects.equals(attachments, sendMailAdv.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, body, from, to, id, replyto, cc, bcc, attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdv {\n");
    
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
