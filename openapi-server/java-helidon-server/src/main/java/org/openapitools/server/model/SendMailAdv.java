package org.openapitools.server.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.server.model.EmailAddressTypes;
import org.openapitools.server.model.EmailAddressesTypes;
import org.openapitools.server.model.MailAttachment;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * Request body for `POST /mail/advsend`.  Provides full control over all email headers and supports multiple recipients, CC, BCC, Reply-To, and file attachments.  Address fields (`from`, `to`, `replyto`, `cc`, `bcc`) each accept either a plain RFC 822 string (e.g. `\"Joe <joe@example.com>\"` or a comma-separated list) or a structured array of `{\"email\": \"...\", \"name\": \"...\"}` objects.  HTML detection is automatic based on whether `body` contains HTML tags.
 */
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

    /**
     * Default constructor.
     */
    public SendMailAdv() {
    // JSON-B / Jackson
    }

    /**
     * Create SendMailAdv.
     *
     * @param subject The subject line of the email.
     * @param body The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
     * @param from The sender address.  Accepts a plain email string, an RFC 822 named string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a &#x60;{\&quot;email\&quot;: \&quot;...\&quot;, \&quot;name\&quot;: \&quot;...\&quot;}&#x60; object.
     * @param to One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
     * @param replyto Optional.  One or more addresses to set as the &#x60;Reply-To&#x60; header. When recipients reply to the message their email client will address the reply to these addresses instead of &#x60;from&#x60;.
     * @param cc Optional.  Carbon-copy recipients.  These addresses are listed in the &#x60;Cc&#x60; header and are visible to all recipients.
     * @param bcc Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
     * @param attachments Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
     * @param id Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     */
    public SendMailAdv(
        String subject, 
        String body, 
        EmailAddressTypes from, 
        EmailAddressesTypes to, 
        EmailAddressesTypes replyto, 
        EmailAddressesTypes cc, 
        EmailAddressesTypes bcc, 
        List<@Valid MailAttachment> attachments, 
        Long id
    ) {
        this.subject = subject;
        this.body = body;
        this.from = from;
        this.to = to;
        this.replyto = replyto;
        this.cc = cc;
        this.bcc = bcc;
        this.attachments = attachments;
        this.id = id;
    }



    /**
     * The subject line of the email.
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
     * @return body
     */
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * The sender address.  Accepts a plain email string, an RFC 822 named string (`\"Name <email>\"`), or a `{\"email\": \"...\", \"name\": \"...\"}` object.
     * @return from
     */
    public EmailAddressTypes getFrom() {
        return from;
    }

    public void setFrom(EmailAddressTypes from) {
        this.from = from;
    }

    /**
     * One or more destination addresses.  Accepts a comma-separated RFC 822 string or an array of contact objects.
     * @return to
     */
    public EmailAddressesTypes getTo() {
        return to;
    }

    public void setTo(EmailAddressesTypes to) {
        this.to = to;
    }

    /**
     * Optional.  One or more addresses to set as the `Reply-To` header. When recipients reply to the message their email client will address the reply to these addresses instead of `from`.
     * @return replyto
     */
    public EmailAddressesTypes getReplyto() {
        return replyto;
    }

    public void setReplyto(EmailAddressesTypes replyto) {
        this.replyto = replyto;
    }

    /**
     * Optional.  Carbon-copy recipients.  These addresses are listed in the `Cc` header and are visible to all recipients.
     * @return cc
     */
    public EmailAddressesTypes getCc() {
        return cc;
    }

    public void setCc(EmailAddressesTypes cc) {
        this.cc = cc;
    }

    /**
     * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
     * @return bcc
     */
    public EmailAddressesTypes getBcc() {
        return bcc;
    }

    public void setBcc(EmailAddressesTypes bcc) {
        this.bcc = bcc;
    }

    /**
     * Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
     * @return attachments
     */
    public List<@Valid MailAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<@Valid MailAttachment> attachments) {
        this.attachments = attachments;
    }

    /**
     * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
     * @return id
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
      * Create a string representation of this pojo.
    **/
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
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

