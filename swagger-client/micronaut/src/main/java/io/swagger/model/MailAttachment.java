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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2021-05-08T00:57:56.594294-04:00[America/New_York]")
public class MailAttachment   {
  @JsonProperty("filename")
  private String filename = null;

  @JsonProperty("data")
  private File data = null;

  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Optional filename to specify for the attachment.
   * @return filename
  **/
  @Schema(example = "company_logo.png", description = "Optional filename to specify for the attachment.")

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public MailAttachment data(File data) {
    this.data = data;
    return this;
  }

  /**
   * Contents of the attached file
   * @return data
  **/
  @Schema(required = true, description = "Contents of the attached file")
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
