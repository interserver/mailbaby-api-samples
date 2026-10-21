package org.openapitools.server.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.
 */
public class EmailAddressName   {

    private String email;
    private String name;

    /**
     * Default constructor.
     */
    public EmailAddressName() {
    // JSON-B / Jackson
    }

    /**
     * Create EmailAddressName.
     *
     * @param email The email address.
     * @param name Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).
     */
    public EmailAddressName(
        String email, 
        String name
    ) {
        this.email = email;
        this.name = name;
    }



    /**
     * The email address.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Optional display name shown to recipients (e.g. in the `From:` header).
     * @return name
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EmailAddressName {\n");
        
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

