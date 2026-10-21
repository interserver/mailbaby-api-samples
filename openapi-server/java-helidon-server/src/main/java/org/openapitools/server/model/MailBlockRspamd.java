package org.openapitools.server.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 */
public class MailBlockRspamd   {

    private String from;
    private String subject;

    /**
     * Default constructor.
     */
    public MailBlockRspamd() {
    // JSON-B / Jackson
    }

    /**
     * Create MailBlockRspamd.
     *
     * @param from The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender.
     * @param subject The suspicious subject pattern that triggered the block.
     */
    public MailBlockRspamd(
        String from, 
        String subject
    ) {
        this.from = from;
        this.subject = subject;
    }



    /**
     * The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.
     * @return from
     */
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * The suspicious subject pattern that triggered the block.
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailBlockRspamd {\n");
        
        sb.append("    from: ").append(toIndentedString(from)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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

