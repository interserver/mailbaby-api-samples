/*
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.File;
import java.io.IOException;
/**
 * A File attachment for an email
 */
@Schema(description = "A File attachment for an email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-28T16:58:18.769348-04:00[America/New_York]")
public class MailAttachment {
  @SerializedName("filename")
  private String filename = null;

  @SerializedName("data")
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
    return Objects.hash(filename, Objects.hashCode(data));
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