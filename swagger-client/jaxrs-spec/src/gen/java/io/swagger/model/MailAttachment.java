package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * A File attachment for an email
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "A File attachment for an email")

public class MailAttachment   {
  private @Valid String filename = null;
  private @Valid File data = null;

  /**
   * Optional filename to specify for the attachment.
   **/
  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  
  @ApiModelProperty(example = "company_logo.png", value = "Optional filename to specify for the attachment.")
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
  public MailAttachment data(File data) {
    this.data = data;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Contents of the attached file")
  @JsonProperty("data")
  @NotNull

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
