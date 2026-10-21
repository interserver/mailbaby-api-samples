package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */

@Schema(name = "MailAttachment", description = "A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class MailAttachment {

  private String filename;

  private byte[] data;

  public MailAttachment() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailAttachment(String filename, byte[] data) {
    this.filename = filename;
    this.data = data;
  }

  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
   * @return filename
   */
  @NotNull 
  @Schema(name = "filename", example = "message.txt", description = "The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public MailAttachment data(byte[] data) {
    this.data = data;
    return this;
  }

  /**
   * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
   * @return data
   */
  @NotNull 
  @Schema(name = "data", example = "[B@315105f", description = "The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
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

