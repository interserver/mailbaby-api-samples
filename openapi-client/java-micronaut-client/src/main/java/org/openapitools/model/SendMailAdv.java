/*
 * MailBaby Email Delivery API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.    We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.model;

import java.util.Objects;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.model.SendMailAdvAttachmentsInner;
import org.openapitools.model.SendMailAdvBccInner;
import org.openapitools.model.SendMailAdvCcInner;
import org.openapitools.model.SendMailAdvFrom;
import org.openapitools.model.SendMailAdvReplytoInner;
import org.openapitools.model.SendMailAdvToInner;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.*;
import javax.validation.Valid;
import io.micronaut.core.annotation.*;
import javax.annotation.Generated;

/**
 * Details for an Email
 */
@JsonPropertyOrder({
  SendMailAdv.JSON_PROPERTY_SUBJECT,
  SendMailAdv.JSON_PROPERTY_BODY,
  SendMailAdv.JSON_PROPERTY_FROM,
  SendMailAdv.JSON_PROPERTY_TO,
  SendMailAdv.JSON_PROPERTY_REPLYTO,
  SendMailAdv.JSON_PROPERTY_CC,
  SendMailAdv.JSON_PROPERTY_BCC,
  SendMailAdv.JSON_PROPERTY_ATTACHMENTS,
  SendMailAdv.JSON_PROPERTY_ID
})
@JsonTypeName("SendMailAdv")
@Generated(value="org.openapitools.codegen.languages.JavaMicronautClientCodegen", date="2022-06-28T22:22:40.110742-04:00[America/New_York]")
@Introspected
public class SendMailAdv {
    public static final String JSON_PROPERTY_SUBJECT = "subject";
    private String subject;

    public static final String JSON_PROPERTY_BODY = "body";
    private String _body;

    public static final String JSON_PROPERTY_FROM = "from";
    private SendMailAdvFrom from;

    public static final String JSON_PROPERTY_TO = "to";
    private List<SendMailAdvToInner> to = new ArrayList<>();

    public static final String JSON_PROPERTY_REPLYTO = "replyto";
    private List<SendMailAdvReplytoInner> replyto = null;

    public static final String JSON_PROPERTY_CC = "cc";
    private List<SendMailAdvCcInner> cc = null;

    public static final String JSON_PROPERTY_BCC = "bcc";
    private List<SendMailAdvBccInner> bcc = null;

    public static final String JSON_PROPERTY_ATTACHMENTS = "attachments";
    private List<SendMailAdvAttachmentsInner> attachments = null;

    public static final String JSON_PROPERTY_ID = "id";
    private Long id;

    public SendMailAdv(String subject, String _body, SendMailAdvFrom from, List<SendMailAdvToInner> to) {
        this.subject = subject;
        this._body = _body;
        this.from = from;
        this.to = to;
    }

    public SendMailAdv subject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * The subject or title of the email
     * @return subject
     **/
    @NotNull
    @JsonProperty(JSON_PROPERTY_SUBJECT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getSubject() {
        return subject;
    }

    @JsonProperty(JSON_PROPERTY_SUBJECT)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public SendMailAdv _body(String _body) {
        this._body = _body;
        return this;
    }

    /**
     * The main email contents.
     * @return _body
     **/
    @NotNull
    @JsonProperty(JSON_PROPERTY_BODY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getBody() {
        return _body;
    }

    @JsonProperty(JSON_PROPERTY_BODY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setBody(String _body) {
        this._body = _body;
    }

    public SendMailAdv from(SendMailAdvFrom from) {
        this.from = from;
        return this;
    }

    /**
     * Get from
     * @return from
     **/
    @Valid
    @NotNull
    @JsonProperty(JSON_PROPERTY_FROM)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public SendMailAdvFrom getFrom() {
        return from;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFrom(SendMailAdvFrom from) {
        this.from = from;
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
     * A list of destionation email addresses to send this to
     * @return to
     **/
    @NotNull
    @JsonProperty(JSON_PROPERTY_TO)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<SendMailAdvToInner> getTo() {
        return to;
    }

    @JsonProperty(JSON_PROPERTY_TO)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setTo(List<SendMailAdvToInner> to) {
        this.to = to;
    }

    public SendMailAdv replyto(List<SendMailAdvReplytoInner> replyto) {
        this.replyto = replyto;
        return this;
    }

    public SendMailAdv addReplytoItem(SendMailAdvReplytoInner replytoItem) {
        if (this.replyto == null) {
            this.replyto = new ArrayList<>();
        }
        this.replyto.add(replytoItem);
        return this;
    }

    /**
     * (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
     * @return replyto
     **/
    @Nullable
    @JsonProperty(JSON_PROPERTY_REPLYTO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<SendMailAdvReplytoInner> getReplyto() {
        return replyto;
    }

    @JsonProperty(JSON_PROPERTY_REPLYTO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReplyto(List<SendMailAdvReplytoInner> replyto) {
        this.replyto = replyto;
    }

    public SendMailAdv cc(List<SendMailAdvCcInner> cc) {
        this.cc = cc;
        return this;
    }

    public SendMailAdv addCcItem(SendMailAdvCcInner ccItem) {
        if (this.cc == null) {
            this.cc = new ArrayList<>();
        }
        this.cc.add(ccItem);
        return this;
    }

    /**
     * (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     * @return cc
     **/
    @Nullable
    @JsonProperty(JSON_PROPERTY_CC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<SendMailAdvCcInner> getCc() {
        return cc;
    }

    @JsonProperty(JSON_PROPERTY_CC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCc(List<SendMailAdvCcInner> cc) {
        this.cc = cc;
    }

    public SendMailAdv bcc(List<SendMailAdvBccInner> bcc) {
        this.bcc = bcc;
        return this;
    }

    public SendMailAdv addBccItem(SendMailAdvBccInner bccItem) {
        if (this.bcc == null) {
            this.bcc = new ArrayList<>();
        }
        this.bcc.add(bccItem);
        return this;
    }

    /**
     * (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     * @return bcc
     **/
    @Nullable
    @JsonProperty(JSON_PROPERTY_BCC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<SendMailAdvBccInner> getBcc() {
        return bcc;
    }

    @JsonProperty(JSON_PROPERTY_BCC)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setBcc(List<SendMailAdvBccInner> bcc) {
        this.bcc = bcc;
    }

    public SendMailAdv attachments(List<SendMailAdvAttachmentsInner> attachments) {
        this.attachments = attachments;
        return this;
    }

    public SendMailAdv addAttachmentsItem(SendMailAdvAttachmentsInner attachmentsItem) {
        if (this.attachments == null) {
            this.attachments = new ArrayList<>();
        }
        this.attachments.add(attachmentsItem);
        return this;
    }

    /**
     * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @return attachments
     **/
    @Nullable
    @JsonProperty(JSON_PROPERTY_ATTACHMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<SendMailAdvAttachmentsInner> getAttachments() {
        return attachments;
    }

    @JsonProperty(JSON_PROPERTY_ATTACHMENTS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setAttachments(List<SendMailAdvAttachmentsInner> attachments) {
        this.attachments = attachments;
    }

    public SendMailAdv id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * (optional)  ID of the Mail order within our system to use as the Mail Account.
     * @return id
     **/
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public Long getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(Long id) {
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
            Objects.equals(this._body, sendMailAdv._body) &&
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
        return Objects.hash(subject, _body, from, to, replyto, cc, bcc, attachments, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SendMailAdv {\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    _body: ").append(toIndentedString(_body)).append("\n");
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
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
