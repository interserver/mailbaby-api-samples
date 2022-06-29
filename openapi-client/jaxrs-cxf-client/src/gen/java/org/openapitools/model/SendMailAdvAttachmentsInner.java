package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import java.io.File;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * A File attachment for an email
 **/
@ApiModel(description="A File attachment for an email")

public class SendMailAdvAttachmentsInner  {
  
  @ApiModelProperty(required = true, value = "Contents of the attached file (must be base64 encoded)")
 /**
   * Contents of the attached file (must be base64 encoded)
  **/
  private File data;

  @ApiModelProperty(example = "company_logo.png", value = "(optional) Filename to specify for the attachment.")
 /**
   * (optional) Filename to specify for the attachment.
  **/
  private String filename;
 /**
   * Contents of the attached file (must be base64 encoded)
   * @return data
  **/
  @JsonProperty("data")
  public File getData() {
    return data;
  }

  public void setData(File data) {
    this.data = data;
  }

  public SendMailAdvAttachmentsInner data(File data) {
    this.data = data;
    return this;
  }

 /**
   * (optional) Filename to specify for the attachment.
   * @return filename
  **/
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public SendMailAdvAttachmentsInner filename(String filename) {
    this.filename = filename;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvAttachmentsInner {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
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

