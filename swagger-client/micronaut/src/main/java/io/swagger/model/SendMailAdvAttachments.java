package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A File attachment for an email
 */
@Schema(description = "A File attachment for an email")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2023-05-09T00:51:48.563040-04:00[America/New_York]")
public class SendMailAdvAttachments   {
  @JsonProperty("filename")
  private String filename = null;

  @JsonProperty("data")
  private File data = null;

  public SendMailAdvAttachments filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * (optional) Filename to specify for the attachment.
   * @return filename
  **/
  @Schema(example = "company_logo.png", description = "(optional) Filename to specify for the attachment.")

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public SendMailAdvAttachments data(File data) {
    this.data = data;
    return this;
  }

  /**
   * Contents of the attached file (must be base64 encoded)
   * @return data
  **/
  @Schema(required = true, description = "Contents of the attached file (must be base64 encoded)")
  @NotNull

  @Valid
  public File getData() {
    return data;
  }

  public void setData(File data) {
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
    SendMailAdvAttachments sendMailAdvAttachments = (SendMailAdvAttachments) o;
    return Objects.equals(this.filename, sendMailAdvAttachments.filename) &&
        Objects.equals(this.data, sendMailAdvAttachments.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(filename, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvAttachments {\n");
    
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
