package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import javax.validation.Valid;
import javax.validation.constraints.*;
/**
 * A File attachment for an email
 **/
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

import javax.xml.bind.annotation.*;

@Schema(description = "A File attachment for an email")

public class MailAttachment   {
  private String filename = null;
  private File data = null;

  /**
   * Optional filename to specify for the attachment.
   **/
  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  
  
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
  public MailAttachment data(File data) {
    this.data = data;
    return this;
  }

  
  
  @Schema(required = true, description = "Contents of the attached file")
  @JsonProperty("data")
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
