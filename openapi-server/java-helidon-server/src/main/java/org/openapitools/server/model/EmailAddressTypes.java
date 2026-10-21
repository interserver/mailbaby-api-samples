package org.openapitools.server.model;

import org.openapitools.server.model.EmailAddressName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.
 */
public class EmailAddressTypes   {

    private String email;
    private String name;

    /**
     * Default constructor.
     */
    public EmailAddressTypes() {
    // JSON-B / Jackson
    }

    /**
     * Create EmailAddressTypes.
     *
     * @param email The email address.
     * @param name Optional display name shown to recipients (e.g. in the &#x60;From:&#x60; header).
     */
    public EmailAddressTypes(
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
        sb.append("class EmailAddressTypes {\n");
        
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

