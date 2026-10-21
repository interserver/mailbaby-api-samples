package org.openapitools.model;

import org.openapitools.model.byte[];
import java.util.Objects;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.time.*;
import java.math.*;
@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */
public class MailAttachment implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
   */
  @JsonProperty("filename")
  private String filename;

  /**
   * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
   */
  @JsonProperty("data")
  private byte[] data;

  /**
   * The filename shown to recipients (e.g. &#x60;report.pdf&#x60;, &#x60;invoice.xlsx&#x60;).
   * @return filename
   */
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.
   * @return data
   */
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
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
