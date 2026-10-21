package org.openapitools.server.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A single email address parameter used as the body of `POST /mail/blocks/delete`.
 */
public class EmailAddressParam   {

    private String email;

    /**
     * Default constructor.
     */
    public EmailAddressParam() {
    // JSON-B / Jackson
    }

    /**
     * Create EmailAddressParam.
     *
     * @param email The email address to delist from all block lists.
     */
    public EmailAddressParam(
        String email
    ) {
        this.email = email;
    }



    /**
     * The email address to delist from all block lists.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EmailAddressParam {\n");
        
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

