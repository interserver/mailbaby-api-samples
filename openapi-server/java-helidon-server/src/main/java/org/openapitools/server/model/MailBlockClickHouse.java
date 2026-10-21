package org.openapitools.server.model;

import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A block event record sourced from the ClickHouse analytics store.  Represents a message that triggered one of the rspamd block rules (`LOCAL_BL_RCPT` or `MBTRAP`). The `from` address can be passed to `POST /mail/blocks/delete` to delist it.
 */
public class MailBlockClickHouse   {

    private LocalDate date;
    private String from;
    private String subject;
    private String to;
    private String messageId;

    /**
     * Default constructor.
     */
    public MailBlockClickHouse() {
    // JSON-B / Jackson
    }

    /**
     * Create MailBlockClickHouse.
     *
     * @param date The date the block event was recorded.
     * @param from The SMTP envelope sender (&#x60;MAIL FROM&#x60;) address of the blocked message. Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist it.
     * @param subject The &#x60;Subject&#x60; header of the blocked message.
     * @param to The serialized list of recipients of the blocked message.
     * @param messageId The &#x60;Message-ID&#x60; header of the blocked message, or &#x60;null&#x60; if not present.
     */
    public MailBlockClickHouse(
        LocalDate date, 
        String from, 
        String subject, 
        String to, 
        String messageId
    ) {
        this.date = date;
        this.from = from;
        this.subject = subject;
        this.to = to;
        this.messageId = messageId;
    }



    /**
     * The date the block event was recorded.
     * @return date
     */
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * The SMTP envelope sender (`MAIL FROM`) address of the blocked message. Pass this value as `email` to `POST /mail/blocks/delete` to delist it.
     * @return from
     */
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * The `Subject` header of the blocked message.
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * The serialized list of recipients of the blocked message.
     * @return to
     */
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    /**
     * The `Message-ID` header of the blocked message, or `null` if not present.
     * @return messageId
     */
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailBlockClickHouse {\n");
        
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    from: ").append(toIndentedString(from)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    to: ").append(toIndentedString(to)).append("\n");
        sb.append("    messageId: ").append(toIndentedString(messageId)).append("\n");
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

