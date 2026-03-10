package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
 */
@Schema(description = "A file attachment for use with `POST /mail/advsend`.  The file content must be base64-encoded.  The `filename` is shown to recipients in their email client.")
@Validated
@Introspected

public class MailAttachment   {
  @JsonProperty("filename")
  private String filename = null;

  @JsonProperty("data")
  private byte[] data = null;

  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).
   * @return filename
  **/
  @Schema(example = "message.txt", required = true, description = "The filename shown to recipients (e.g. `report.pdf`, `invoice.xlsx`).")
  @NotNull

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
  **/
  @Schema(example = "[B@16c3eb6b", required = true, description = "The file contents as a base64-encoded string.  Decode this to retrieve the original binary file.")
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
