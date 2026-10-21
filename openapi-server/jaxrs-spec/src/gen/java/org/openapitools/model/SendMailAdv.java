package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.MailAttachment;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Request body for &#x60;POST /mail/advsend&#x60;.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) each accept either a plain RFC 822 string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;\&quot;&#x60; or a comma-separated list) or a structured array of &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; objects.  HTML detection is automatic based on whether &#x60;body&#x60; contains HTML tags.
 **/
@ApiModel(description = "Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.")
@JsonTypeName("SendMailAdv")
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class SendMailAdv   {
  private String subject;
  private String body;
  private EmailAddressTypes from;
  private EmailAddressesTypes to;
  private EmailAddressesTypes replyto;
  private EmailAddressesTypes cc;
  private EmailAddressesTypes bcc;
  private List<@Valid MailAttachment> attachments = new ArrayList<>();
  private Long id;

  public SendMailAdv() {
  }

  @JsonCreator
  public SendMailAdv(
    @JsonProperty(required = true, value = "subject") String subject,
    @JsonProperty(required = true, value = "body") String body,
    @JsonProperty(required = true, value = "from") EmailAddressTypes from,
    @JsonProperty(required = true, value = "to") EmailAddressesTypes to
  ) {
    this.subject = subject;
    this.body = body;
    this.from = from;
    this.to = to;
  }

  /**
   * The subject line of the email.
   **/
  public SendMailAdv subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(example = "Your Package has been Delivered!", required = true, value = "The subject line of the email.")
  @JsonProperty(required = true, value = "subject")
  @NotNull public String getSubject() {
    return subject;
  }

  @JsonProperty(required = true, value = "subject")
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
   **/
  public SendMailAdv body(String body) {
    this.body = body;
    return this;
  }

  
  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered.", required = true, value = "The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.")
  @JsonProperty(required = true, value = "body")
  @NotNull public String getBody() {
    return body;
  }

  @JsonProperty(required = true, value = "body")
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.
   **/
  public SendMailAdv from(EmailAddressTypes from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.")
  @JsonProperty(required = true, value = "from")
  @NotNull @Valid public EmailAddressTypes getFrom() {
    return from;
  }

  @JsonProperty(required = true, value = "from")
  public void setFrom(EmailAddressTypes from) {
    this.from = from;
  }

  /**
   * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
   **/
  public SendMailAdv to(EmailAddressesTypes to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.")
  @JsonProperty(required = true, value = "to")
  @NotNull @Valid public EmailAddressesTypes getTo() {
    return to;
  }

  @JsonProperty(required = true, value = "to")
  public void setTo(EmailAddressesTypes to) {
    this.to = to;
  }

  /**
   * Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
   **/
  public SendMailAdv replyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
    return this;
  }

  
  @ApiModelProperty(value = "Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.")
  @JsonProperty("replyto")
  @Valid public EmailAddressesTypes getReplyto() {
    return replyto;
  }

  @JsonProperty("replyto")
  public void setReplyto(EmailAddressesTypes replyto) {
    this.replyto = replyto;
  }

  /**
   * Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
   **/
  public SendMailAdv cc(EmailAddressesTypes cc) {
    this.cc = cc;
    return this;
  }

  
  @ApiModelProperty(value = "Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.")
  @JsonProperty("cc")
  @Valid public EmailAddressesTypes getCc() {
    return cc;
  }

  @JsonProperty("cc")
  public void setCc(EmailAddressesTypes cc) {
    this.cc = cc;
  }

  /**
   * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
   **/
  public SendMailAdv bcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
    return this;
  }

  
  @ApiModelProperty(value = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")
  @JsonProperty("bcc")
  @Valid public EmailAddressesTypes getBcc() {
    return bcc;
  }

  @JsonProperty("bcc")
  public void setBcc(EmailAddressesTypes bcc) {
    this.bcc = bcc;
  }

  /**
   * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
   **/
  public SendMailAdv attachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
    return this;
  }

  
  @ApiModelProperty(value = "Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.")
  @JsonProperty("attachments")
  public List<@Valid MailAttachment> getAttachments() {
    return attachments;
  }

  @JsonProperty("attachments")
  public void setAttachments(List<@Valid MailAttachment> attachments) {
    this.attachments = attachments;
  }

  public SendMailAdv addAttachmentsItem(MailAttachment attachmentsItem) {
    if (this.attachments == null) {
      this.attachments = new ArrayList<>();
    }

    this.attachments.add(attachmentsItem);
    return this;
  }

  public SendMailAdv removeAttachmentsItem(MailAttachment attachmentsItem) {
    if (attachmentsItem != null && this.attachments != null) {
      this.attachments.remove(attachmentsItem);
    }

    return this;
  }
  /**
   * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
   **/
  public SendMailAdv id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "5000", value = "Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * Creates the property if it does not already exist, otherwise replaces it.
   * @param key the name of the property
   * @param value the value of the property
   * @return self reference
   */
  @JsonAnySetter
  public SendMailAdv putAdditionalProperty(String key, Object value) {
    this.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) properties.
   * @return the additional (undeclared) properties
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   * @param key the name of the property
   * @return the additional (undeclared) property with the specified name
   */
  public Object getAdditionalProperty(String key) {
    return this.get(key);
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }


}
