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
 * (optional) File attachments to include in the email.  The file contents must be base64
 */
@JsonPropertyOrder({
  MailAttachment.JSON_PROPERTY_FILENAME,
  MailAttachment.JSON_PROPERTY_DATA
})
@JsonTypeName("MailAttachment")
@Generated(value="org.openapitools.codegen.languages.JavaMicronautClientCodegen", date="2025-07-19T04:15:45.324289885-04:00[America/New_York]", comments = "Generator version: 7.14.0-SNAPSHOT")
@Introspected
public class MailAttachment {
    public static final String JSON_PROPERTY_FILENAME = "filename";
    private String filename;

    public static final String JSON_PROPERTY_DATA = "data";
    private String data;

    public MailAttachment(String filename, String data) {
        this.filename = filename;
        this.data = data;
    }

    public MailAttachment filename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * The filename of the attached file.
     * @return filename
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_FILENAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getFilename() {
        return filename;
    }

    @JsonProperty(JSON_PROPERTY_FILENAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public MailAttachment data(String data) {
        this.data = data;
        return this;
    }

    /**
     * The file contents base64 encoded
     * @return data
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getData() {
        return data;
    }

    @JsonProperty(JSON_PROPERTY_DATA)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MailAttachment mailAttachment = (MailAttachment) o;
        return Objects.equals(this.filename, mailAttachment.filename) &&
            Objects.equals(this.data, mailAttachment.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailAttachment {\n");
        sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

