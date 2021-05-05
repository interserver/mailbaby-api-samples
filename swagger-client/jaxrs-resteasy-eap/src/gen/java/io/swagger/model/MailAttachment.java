package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="A File attachment for an email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-05-05T08:03:52.541933-04:00[America/New_York]")public class MailAttachment   {
  private String filename = null;
  private File data = null;

  /**
   * Optional filename to specify for the attachment.
   **/
  
  @Schema(example = "company_logo.png", description = "Optional filename to specify for the attachment.")
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * Contents of the attached file
   **/
  
  @Schema(required = true, description = "Contents of the attached file")
  @JsonProperty("data")
  @NotNull
  public File getData() {
    return data;
  }
  public void setData(File data) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
