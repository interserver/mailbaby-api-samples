package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;


/**
 * Details for an Email
 **/
@Schema(description = "Details for an Email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2023-01-10T22:49:52.655060-05:00[America/New_York]")
public class SendMailAdv   {
  @JsonProperty("subject")
  private String subject = null;
  @JsonProperty("body")
  private String body = null;
  @JsonProperty("from")
  private SendMailAdvFrom from = null;
  @JsonProperty("to")
  private List<SendMailAdvTo> to = new ArrayList<SendMailAdvTo>();
  @JsonProperty("replyto")
  private List<SendMailAdvReplyto> replyto = null;
  @JsonProperty("cc")
  private List<SendMailAdvCc> cc = null;
  @JsonProperty("bcc")
  private List<SendMailAdvBcc> bcc = null;
  @JsonProperty("attachments")
  private List<SendMailAdvAttachments> attachments = null;
  @JsonProperty("id")
  private Long id = null;
  /**
   * The subject or title of the email
   **/
  public SendMailAdv subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @Schema(example = "Your Package has been Delivered!", required = true, description = "The subject or title of the email")
  @JsonProperty("subject")
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

  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", required = true, description = "The main email contents.")
  @JsonProperty("body")
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

  
  @Schema(required = true, description = "")
  @JsonProperty("from")
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

  
  @Schema(required = true, description = "A list of destionation email addresses to send this to")
  @JsonProperty("to")
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

  
  @Schema(description = "(optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.")
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

  
  @Schema(description = "(optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
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

  
  @Schema(description = "(optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
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

  
  @Schema(description = "(optional) File attachments to include in the email.  The file contents must be base64 encoded!")
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

  
  @Schema(example = "5000", description = "(optional)  ID of the Mail order within our system to use as the Mail Account.")
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
