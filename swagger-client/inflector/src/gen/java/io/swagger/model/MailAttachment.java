package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * (optional) File attachments to include in the email.  The file contents must be base64
 **/
@Schema(description = "(optional) File attachments to include in the email.  The file contents must be base64")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2023-08-10T12:37:57.566505-04:00[America/New_York]")

public class MailAttachment   {
  @JsonProperty("filename")
  private String filename = null;
  @JsonProperty("data")
  private String data = null;
  /**
   * The filename of the attached file.
   **/
  public MailAttachment filename(String filename) {
    this.filename = filename;
    return this;
  }

  
  @Schema(example = "message.txt", required = true, description = "The filename of the attached file.")
  @JsonProperty("filename")
  public String getFilename() {
    return filename;
  }
  public void setFilename(String filename) {
    this.filename = filename;
  }

  /**
   * The file contents base64 encoded
   **/
  public MailAttachment data(String data) {
    this.data = data;
    return this;
  }

  
  @Schema(example = "aGVsbG8gdGhlcmUK", required = true, description = "The file contents base64 encoded")
  @JsonProperty("data")
  public String getData() {
    return data;
  }
  public void setData(String data) {
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
