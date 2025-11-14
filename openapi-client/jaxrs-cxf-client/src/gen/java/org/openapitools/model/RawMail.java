package org.openapitools.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Raw Email Object
 */
@ApiModel(description="Raw Email Object")

public class RawMail  {
  
 /**
  * The entire email contents
  */
  @ApiModelProperty(required = true, value = "The entire email contents")

  private String rawEmail;
 /**
   * The entire email contents
   * @return rawEmail
  **/
  @JsonProperty("raw_email")
  public String getRawEmail() {
    return rawEmail;
  }

  public void setRawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
  }

  public RawMail rawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RawMail rawMail = (RawMail) o;
    return Objects.equals(this.rawEmail, rawMail.rawEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RawMail {\n");
    
    sb.append("    rawEmail: ").append(toIndentedString(rawEmail)).append("\n");
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

