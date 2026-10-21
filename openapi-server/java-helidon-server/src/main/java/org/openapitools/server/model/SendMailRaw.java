package org.openapitools.server.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.
 */
public class SendMailRaw   {

    private String rawEmail;
    private Long id;

    /**
     * Default constructor.
     */
    public SendMailRaw() {
    // JSON-B / Jackson
    }

    /**
     * Create SendMailRaw.
     *
     * @param rawEmail The complete RFC 822 email message including all headers and the body. Must include at minimum &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Subject&#x60;, &#x60;Date&#x60;, and &#x60;MIME-Version&#x60; headers.  DKIM signatures in the &#x60;DKIM-Signature&#x60; header are transmitted verbatim and will pass verification at the destination.
     * @param id Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     */
    public SendMailRaw(
        String rawEmail, 
        Long id
    ) {
        this.rawEmail = rawEmail;
        this.id = id;
    }



    /**
     * The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
     * @return rawEmail
     */
    public String getRawEmail() {
        return rawEmail;
    }

    public void setRawEmail(String rawEmail) {
        this.rawEmail = rawEmail;
    }

    /**
     * Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
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
        sb.append("class SendMailRaw {\n");
        
        sb.append("    rawEmail: ").append(toIndentedString(rawEmail)).append("\n");
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

