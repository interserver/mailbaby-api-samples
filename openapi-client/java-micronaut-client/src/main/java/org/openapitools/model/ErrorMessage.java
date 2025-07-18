/*
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.*;
import javax.validation.Valid;
import io.micronaut.core.annotation.*;
import javax.annotation.Generated;

/**
 * The resposne when an error occurs.
 */
@JsonPropertyOrder({
  ErrorMessage.JSON_PROPERTY_CODE,
  ErrorMessage.JSON_PROPERTY_MESSAGE
})
@JsonTypeName("ErrorMessage")
@Generated(value="org.openapitools.codegen.languages.JavaMicronautClientCodegen", date="2025-07-19T04:15:45.324289885-04:00[America/New_York]", comments = "Generator version: 7.14.0-SNAPSHOT")
@Introspected
public class ErrorMessage {
    public static final String JSON_PROPERTY_CODE = "code";
    private Integer code;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    private String message;

    public ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessage code(Integer code) {
        this.code = code;
        return this;
    }

    /**
     * The response code associated with the error.
     * @return code
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getCode() {
        return code;
    }

    @JsonProperty(JSON_PROPERTY_CODE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setCode(Integer code) {
        this.code = code;
    }

    public ErrorMessage message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The details or description of the error.
     * @return message
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getMessage() {
        return message;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorMessage errorMessage = (ErrorMessage) o;
        return Objects.equals(this.code, errorMessage.code) &&
            Objects.equals(this.message, errorMessage.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }

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
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

