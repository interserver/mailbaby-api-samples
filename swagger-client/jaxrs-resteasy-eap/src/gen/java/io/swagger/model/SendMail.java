package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.SendMailFrom;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Details for an Email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-05-05T04:29:58.444271-04:00[America/New_York]")public class SendMail   {
  private String subject = null;
  private String body = null;
  private List<SendMailFrom> from = new ArrayList<SendMailFrom>();
  private List<MailContact> to = new ArrayList<MailContact>();
  private Long id = null;
  private List<MailContact> replyto = new ArrayList<MailContact>();
  private List<MailContact> cc = new ArrayList<MailContact>();
  private List<MailContact> bcc = new ArrayList<MailContact>();
  private List<MailAttachment> attachments = new ArrayList<MailAttachment>();

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
   * The contact whom is the this email is from.
   **/
  
  @Schema(required = true, description = "The contact whom is the this email is from.")
  @JsonProperty("from")
  @NotNull
  public List<SendMailFrom> getFrom() {
    return from;
  }
  public void setFrom(List<SendMailFrom> from) {
    this.from = from;
  }

  /**
   * The Contact whom is the primary recipient of this email.
   **/
  
  @Schema(required = true, description = "The Contact whom is the primary recipient of this email.")
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
  
  @Schema(example = "5000", required = true, description = "The ID of the Mail order within our system to use as the Mail Account.")
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
  
  @Schema(description = "Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address.")
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
  
  @Schema(description = "Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.")
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
  
  @Schema(description = "Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.")
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
  
  @Schema(description = "Optional file attachments to include in the email")
  @JsonProperty("attachments")
  public List<MailAttachment> getAttachments() {
    return attachments;
  }
  public void setAttachments(List<MailAttachment> attachments) {
    this.attachments = attachments;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMail sendMail = (SendMail) o;
    return Objects.equals(subject, sendMail.subject) &&
        Objects.equals(body, sendMail.body) &&
        Objects.equals(from, sendMail.from) &&
        Objects.equals(to, sendMail.to) &&
        Objects.equals(id, sendMail.id) &&
        Objects.equals(replyto, sendMail.replyto) &&
        Objects.equals(cc, sendMail.cc) &&
        Objects.equals(bcc, sendMail.bcc) &&
        Objects.equals(attachments, sendMail.attachments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, body, from, to, id, replyto, cc, bcc, attachments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMail {\n");
    
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
