package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.")

public class MailAttachment   {

  private @Valid String filename = null;

  private @Valid byte[] data = null;

  /**
   * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
   **/
  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  
  @ApiModelProperty(example = "message.txt", required = true, value = "The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).")
  @JsonProperty("filename")
  @NotNull

  public String getFilename() {
    return filename;
  }
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

  
  @ApiModelProperty(example = "[B@42b3321", required = true, value = "The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.")
  @JsonProperty("data")
  @NotNull

  public byte[] getData() {
    return data;
  }
  public void setData(byte[] data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailAttachment mailAttachment = (MailAttachment) o;
    return Objects.equals(filename, mailAttachment.filename) &&
        Objects.equals(data, mailAttachment.data);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
