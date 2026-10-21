package org.openapitools.server.model;

import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * The primary recipient address for a simple send request. Accepts a single email address string or an array of email address strings for multiple recipients.
 */
public class SendMailTo   {


    /**
     * Default constructor.
     */
    public SendMailTo() {
    // JSON-B / Jackson
    }





    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SendMailTo {\n");
        
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

