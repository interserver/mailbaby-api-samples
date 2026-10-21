package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 **/
@ApiModel(description = "A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.")
@JsonTypeName("MailAttachment")
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.26.0")
public class MailAttachment   {
  private String filename;
  private byte[] data;

  public MailAttachment() {
  }

  @JsonCreator
  public MailAttachment(
    @JsonProperty(required = true, value = "filename") String filename,
    @JsonProperty(required = true, value = "data") byte[] data
  ) {
    this.filename = filename;
    this.data = data;
  }

  /**
   * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
   **/
  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  
  @ApiModelProperty(example = "message.txt", required = true, value = "The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).")
  @JsonProperty(required = true, value = "filename")
  @NotNull public String getFilename() {
    return filename;
  }

  @JsonProperty(required = true, value = "filename")
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
   **/
  public MailAttachment data(byte[] data) {
    this.data = data;
    return this;
  }

  
  @ApiModelProperty(example = "[B@58b5a2f3", required = true, value = "The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.")
  @JsonProperty(required = true, value = "data")
  @NotNull public byte[] getData() {
    return data;
  }

  @JsonProperty(required = true, value = "data")
  public void setData(byte[] data) {
    this.data = data;
  }

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * Creates the property if it does not already exist, otherwise replaces it.
   * @param key the name of the property
   * @param value the value of the property
   * @return self reference
   */
  @JsonAnySetter
  public MailAttachment putAdditionalProperty(String key, Object value) {
    this.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) properties.
   * @return the additional (undeclared) properties
   */
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   * @param key the name of the property
   * @return the additional (undeclared) property with the specified name
   */
  public Object getAdditionalProperty(String key) {
    return this.get(key);
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
        Arrays.equals(this.data, mailAttachment.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename, Arrays.hashCode(data));
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
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }


}
