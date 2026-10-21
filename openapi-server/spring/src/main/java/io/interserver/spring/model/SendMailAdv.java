package io.interserver.spring.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.interserver.spring.model.EmailAddressTypes;
import io.interserver.spring.model.EmailAddressesTypes;
import io.interserver.spring.model.MailAttachment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 */

@Schema(name = "SendMailAdv", description = "Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class SendMailAdv {

  private String subject;

  private String body;

  private EmailAddressTypes from;

  private EmailAddressesTypes to;

  private @Nullable EmailAddressesTypes replyto;

  private @Nullable EmailAddressesTypes cc;

  private @Nullable EmailAddressesTypes bcc;

  private List<@Valid MailAttachment> attachments = new ArrayList<>();

  private @Nullable Long id;

  public SendMailAdv() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SendMailAdv(String subject, String body, EmailAddressTypes from, EmailAddressesTypes to) {
    this.subject = subject;
    this.body = body;
    this.from = from;
    this.to = to;
  }

  public SendMailAdv subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The subject line of the email.
   * @return subject
   */
  @NotNull 
  @Schema(name = "subject", example = "Your Package has been Delivered!", description = "The subject line of the email.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  @JsonProperty("subject")
  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SendMailAdv body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
   * @return body
   */
  @NotNull 
  @Schema(name = "body", example = "The package you ordered on 2021-01-23 has been delivered.", description = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("body")
  public String getBody() {
    return body;
  }

  @JsonProperty("body")
  public void setBody(String body) {
    this.body = body;
  }

  public SendMailAdv from(EmailAddressTypes from) {
    this.from = from;
    return this;
  }

  /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
   * @return from
   */
  @NotNull @Valid 
  @Schema(name = "from", description = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("from")
  public EmailAddressTypes getFrom() {
    return from;
  }

  @JsonProperty("from")
  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  public SendMailAdv to(EmailAddressesTypes to) {
    this.to = to;
    return this;
  }

  /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   * @return to
   */
  @NotNull @Valid 
  @Schema(name = "to", description = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("to")
  public EmailAddressesTypes getTo() {
    return to;
  }

  @JsonProperty("to")
  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  public SendMailAdv replyto(@Nullable EmailAddressesTypes replyto) {
    this.replyto = replyto;
    return this;
  }

  /**
   * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
   * @return replyto
   */
  @Valid 
  @Schema(name = "replyto", description = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("replyto")
  public @Nullable EmailAddressesTypes getReplyto() {
    return replyto;
  }

  @JsonProperty("replyto")
  public void setReplyto(@Nullable EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  public SendMailAdv cc(@Nullable EmailAddressesTypes cc) {
    this.cc = cc;
    return this;
  }

  /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
   * @return cc
   */
  @Valid 
  @Schema(name = "cc", description = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cc")
  public @Nullable EmailAddressesTypes getCc() {
    return cc;
  }

  @JsonProperty("cc")
  public void setCc(@Nullable EmailAddressesTypes cc) {
    this.cc = cc;
  }

  public SendMailAdv bcc(@Nullable EmailAddressesTypes bcc) {
    this.bcc = bcc;
    return this;
  }

  /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   * @return bcc
   */
  @Valid 
  @Schema(name = "bcc", description = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bcc")
  public @Nullable EmailAddressesTypes getBcc() {
    return bcc;
  }

  @JsonProperty("bcc")
  public void setBcc(@Nullable EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  public SendMailAdv attachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  public SendMailAdv addAttachmentsItem(MailAttachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<>();
    }
    this.attachments.add(attachmentsItem);
    return this;
  }

  /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
   * @return attachments
   */
  
  @Schema(name = "attachments", description = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attachments")
  public List<@Valid MailAttachment> getAttachments() {
    return attachments;
  }

  @JsonProperty("attachments")
  public void setAttachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
  }

  public SendMailAdv id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
   * @return id
   */
  
  @Schema(name = "id", example = "5000", description = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(@Nullable Long id) {
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
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

