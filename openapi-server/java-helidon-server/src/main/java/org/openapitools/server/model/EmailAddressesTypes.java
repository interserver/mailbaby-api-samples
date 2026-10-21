package org.openapitools.server.model;

import java.util.List;
import org.openapitools.server.model.EmailAddressName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * A flexible email address list that accepts either a plain RFC 822 string or a structured array of contact objects.  When a string is provided it is parsed as a comma-separated list of RFC 822 addresses (supporting the `\"Name <email>\"` and bare `email` formats).  When an array is provided each entry must have at least an `email` field with an optional `name` field.
 */
public class EmailAddressesTypes   {


    /**
     * Default constructor.
     */
    public EmailAddressesTypes() {
    // JSON-B / Jackson
    }





    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EmailAddressesTypes {\n");
        
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

