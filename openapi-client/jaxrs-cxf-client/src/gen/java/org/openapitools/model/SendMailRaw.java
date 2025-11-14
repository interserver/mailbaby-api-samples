package org.openapitools.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Raw Email Object
 */
@ApiModel(description="Raw Email Object")

public class SendMailRaw  {
  
 /**
  * The entire email contents
  */
  @ApiModelProperty(required = true, value = "The entire email contents")

  private String rawEmail;

 /**
  * Optional order id
  */
  @ApiModelProperty(value = "Optional order id")

  private Integer id;
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

  public SendMailRaw rawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
    return this;
  }

 /**
   * Optional order id
   * @return id
  **/
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SendMailRaw id(Integer id) {
    this.id = id;
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
    SendMailRaw sendMailRaw = (SendMailRaw) o;
    return Objects.equals(this.rawEmail, sendMailRaw.rawEmail) &&
        Objects.equals(this.id, sendMailRaw.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawEmail, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailRaw {\n");
    
    sb.append("    rawEmail: ").append(toIndentedString(rawEmail)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

