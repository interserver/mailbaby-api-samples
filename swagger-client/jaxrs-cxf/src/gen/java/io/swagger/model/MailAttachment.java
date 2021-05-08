package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import javax.validation.constraints.*;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
  * A File attachment for an email
 **/
@Schema(description="A File attachment for an email")
public class MailAttachment   {
  
  @Schema(example = "company_logo.png", description = "Optional filename to specify for the attachment.")
 /**
   * Optional filename to specify for the attachment.  
  **/
  private String filename = null;
  
  @Schema(required = true, description = "Contents of the attached file")
 /**
   * Contents of the attached file  
  **/
  private File data = null;
 /**
   * Optional filename to specify for the attachment.
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
   * Contents of the attached file
   * @return data
  **/
  @JsonProperty("data")
  @NotNull
  public File getData() {
    return data;
  }

  public void setData(File data) {
    this.data = data;
  }

  public MailAttachment data(File data) {
    this.data = data;
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
