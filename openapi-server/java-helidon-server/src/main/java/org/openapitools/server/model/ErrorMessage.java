package org.openapitools.server.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * The response body returned when an error occurs.
 */
public class ErrorMessage   {

    private Integer code;
    private String message;

    /**
     * Default constructor.
     */
    public ErrorMessage() {
    // JSON-B / Jackson
    }

    /**
     * Create ErrorMessage.
     *
     * @param code The HTTP-style status code associated with the error.
     * @param message A human-readable description of the error.
     */
    public ErrorMessage(
        Integer code, 
        String message
    ) {
        this.code = code;
        this.message = message;
    }



    /**
     * The HTTP-style status code associated with the error.
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * A human-readable description of the error.
     * @return message
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorMessage {\n");
        
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

