package io.swagger.model;

import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.SendMailAdvFrom;
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
  * Details for an Email
 **/
@Schema(description="Details for an Email")
public class SendMailAdv   {
  
  @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject or title of the email")
 /**
   * The subject or title of the email  
  **/
  private String subject = null;
  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. ", required = true, description = "The main email contents.")
 /**
   * The main email contents.  
  **/
  private String body = null;
  
  @Schema(required = true, description = "The contact whom is the this email is from.")
 /**
   * The contact whom is the this email is from.  
  **/
  private List<SendMailAdvFrom> from = new ArrayList<SendMailAdvFrom>();
  
  @Schema(required = true, description = "The Contact whom is the primary recipient of this email.")
 /**
   * The Contact whom is the primary recipient of this email.  
  **/
  private List<MailContact> to = new ArrayList<MailContact>();
  
  @Schema(example = "5000", required = true, description = "The ID of the Mail order within our system to use as the Mail Account.")
 /**
   * The ID of the Mail order within our system to use as the Mail Account.  
  **/
  private Long id = null;
  
  @Schema(description = "Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.")
 /**
   * Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.  
  **/
  private List<MailContact> replyto = null;
  
  @Schema(description = "Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
 /**
   * Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.  
  **/
  private List<MailContact> cc = null;
  
  @Schema(description = "Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
 /**
   * Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.  
  **/
  private List<MailContact> bcc = null;
  
  @Schema(description = "Optional file attachments to include in the email")
 /**
   * Optional file attachments to include in the email  
  **/
  private List<MailAttachment> attachments = null;
 /**
   * The subject or title of the email
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
   * The main email contents.
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
   * The contact whom is the this email is from.
   * @return from
  **/
  @JsonProperty("from")
  @NotNull
  public List<SendMailAdvFrom> getFrom() {
    return from;
  }

  public void setFrom(List<SendMailAdvFrom> from) {
    this.from = from;
  }

  public SendMailAdv from(List<SendMailAdvFrom> from) {
    this.from = from;
    return this;
  }

  public SendMailAdv addFromItem(SendMailAdvFrom fromItem) {
    this.from.add(fromItem);
    return this;
  }

 /**
   * The Contact whom is the primary recipient of this email.
   * @return to
  **/
  @JsonProperty("to")
  @NotNull
  public List<MailContact> getTo() {
    return to;
  }

  public void setTo(List<MailContact> to) {
    this.to = to;
  }

  public SendMailAdv to(List<MailContact> to) {
    this.to = to;
    return this;
  }

  public SendMailAdv addToItem(MailContact toItem) {
    this.to.add(toItem);
    return this;
  }

 /**
   * The ID of the Mail order within our system to use as the Mail Account.
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

 /**
   * Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.
   * @return replyto
  **/
  @JsonProperty("replyto")
  public List<MailContact> getReplyto() {
    return replyto;
  }

  public void setReplyto(List<MailContact> replyto) {
    this.replyto = replyto;
  }

  public SendMailAdv replyto(List<MailContact> replyto) {
    this.replyto = replyto;
    return this;
  }

  public SendMailAdv addReplytoItem(MailContact replytoItem) {
    this.replyto.add(replytoItem);
    return this;
  }

 /**
   * Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
   * @return cc
  **/
  @JsonProperty("cc")
  public List<MailContact> getCc() {
    return cc;
  }

  public void setCc(List<MailContact> cc) {
    this.cc = cc;
  }

  public SendMailAdv cc(List<MailContact> cc) {
    this.cc = cc;
    return this;
  }

  public SendMailAdv addCcItem(MailContact ccItem) {
    this.cc.add(ccItem);
    return this;
  }

 /**
   * Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
   * @return bcc
  **/
  @JsonProperty("bcc")
  public List<MailContact> getBcc() {
    return bcc;
  }

  public void setBcc(List<MailContact> bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv bcc(List<MailContact> bcc) {
    this.bcc = bcc;
    return this;
  }

  public SendMailAdv addBccItem(MailContact bccItem) {
    this.bcc.add(bccItem);
    return this;
  }

 /**
   * Optional file attachments to include in the email
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
