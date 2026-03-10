package org.openapitools.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.
 */
@ApiModel(description="A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.")

public class MailAttachment  {
  
 /**
  * The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
  */
  @ApiModelProperty(example = "message.txt", required = true, value = "The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).")

  private String filename;

 /**
  * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
  */
  @ApiModelProperty(example = "[B@10c72a6f", required = true, value = "The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.")

  private byte[] data;
 /**
   * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
   * @return filename
  **/
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

 /**
   * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
   * @return data
  **/
  @JsonProperty("data")
  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public MailAttachment data(byte[] data) {
    this.data = data;
    return this;
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

