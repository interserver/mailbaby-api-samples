package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.SendMailAdvAttachmentsInner;
import org.openapitools.model.SendMailAdvBccInner;
import org.openapitools.model.SendMailAdvCcInner;
import org.openapitools.model.SendMailAdvFrom;
import org.openapitools.model.SendMailAdvReplytoInner;
import org.openapitools.model.SendMailAdvToInner;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * Details for an Email
 **/
@ApiModel(description="Details for an Email")

public class SendMailAdv  {
  
  @ApiModelProperty(example = "Your Package has been Delivered!", required = true, value = "The subject or title of the email")
 /**
   * The subject or title of the email
  **/
  private String subject;

  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", required = true, value = "The main email contents.")
 /**
   * The main email contents.
  **/
  private String body;

  @ApiModelProperty(required = true, value = "")
  private SendMailAdvFrom from;

  @ApiModelProperty(required = true, value = "A list of destionation email addresses to send this to")
 /**
   * A list of destionation email addresses to send this to
  **/
  private List<SendMailAdvToInner> to = new ArrayList<>();

  @ApiModelProperty(value = "(optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.")
 /**
   * (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
  **/
  private List<SendMailAdvReplytoInner> replyto = null;

  @ApiModelProperty(value = "(optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
 /**
   * (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
  **/
  private List<SendMailAdvCcInner> cc = null;

  @ApiModelProperty(value = "(optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
 /**
   * (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
  **/
  private List<SendMailAdvBccInner> bcc = null;

  @ApiModelProperty(value = "(optional) File attachments to include in the email.  The file contents must be base64 encoded!")
 /**
   * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
  **/
  private List<SendMailAdvAttachmentsInner> attachments = null;

  @ApiModelProperty(example = "5000", value = "(optional)  ID of the Mail order within our system to use as the Mail Account.")
 /**
   * (optional)  ID of the Mail order within our system to use as the Mail Account.
  **/
  private Long id;
 /**
   * The subject or title of the email
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
   * The main email contents.
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
  public SendMailAdvFrom getFrom() {
    return from;
  }

  public void setFrom(SendMailAdvFrom from) {
    this.from = from;
  }

  public SendMailAdv from(SendMailAdvFrom from) {
    this.from = from;
    return this;
  }

 /**
   * A list of destionation email addresses to send this to
   * @return to
  **/
  @JsonProperty("to")
  public List<SendMailAdvToInner> getTo() {
    return to;
  }

  public void setTo(List<SendMailAdvToInner> to) {
    this.to = to;
  }

  public SendMailAdv to(List<SendMailAdvToInner> to) {
    this.to = to;
    return this;
  }

  public SendMailAdv addToItem(SendMailAdvToInner toItem) {
    this.to.add(toItem);
    return this;
  }

 /**
   * (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
   * @return replyto
  **/
  @JsonProperty("replyto")
  public List<SendMailAdvReplytoInner> getReplyto() {
    return replyto;
  }

  public void setReplyto(List<SendMailAdvReplytoInner> replyto) {
    this.replyto = replyto;
  }

  public SendMailAdv replyto(List<SendMailAdvReplytoInner> replyto) {
    this.replyto = replyto;
    return this;
  }

  public SendMailAdv addReplytoItem(SendMailAdvReplytoInner replytoItem) {
    this.replyto.add(replytoItem);
    return this;
  }

 /**
   * (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
   * @return cc
  **/
  @JsonProperty("cc")
  public List<SendMailAdvCcInner> getCc() {
    return cc;
  }

  public void setCc(List<SendMailAdvCcInner> cc) {
    this.cc = cc;
  }

  public SendMailAdv cc(List<SendMailAdvCcInner> cc) {
    this.cc = cc;
    return this;
  }

  public SendMailAdv addCcItem(SendMailAdvCcInner ccItem) {
    this.cc.add(ccItem);
    return this;
  }

 /**
   * (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
   * @return bcc
  **/
  @JsonProperty("bcc")
  public List<SendMailAdvBccInner> getBcc() {
    return bcc;
  }

  public void setBcc(List<SendMailAdvBccInner> bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv bcc(List<SendMailAdvBccInner> bcc) {
    this.bcc = bcc;
    return this;
  }

  public SendMailAdv addBccItem(SendMailAdvBccInner bccItem) {
    this.bcc.add(bccItem);
    return this;
  }

 /**
   * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
   * @return attachments
  **/
  @JsonProperty("attachments")
  public List<SendMailAdvAttachmentsInner> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<SendMailAdvAttachmentsInner> attachments) {
    this.attachments = attachments;
  }

  public SendMailAdv attachments(List<SendMailAdvAttachmentsInner> attachments) {
    this.attachments = attachments;
    return this;
  }

  public SendMailAdv addAttachmentsItem(SendMailAdvAttachmentsInner attachmentsItem) {
    this.attachments.add(attachmentsItem);
    return this;
  }

 /**
   * (optional)  ID of the Mail order within our system to use as the Mail Account.
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

