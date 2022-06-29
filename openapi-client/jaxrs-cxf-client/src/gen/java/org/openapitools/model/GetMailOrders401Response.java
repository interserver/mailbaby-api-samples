package org.openapitools.model;


import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;


public class GetMailOrders401Response  {
  
  @ApiModelProperty(required = true, value = "")
  private String code;

  @ApiModelProperty(required = true, value = "")
  private String message;
 /**
   * Get code
   * @return code
  **/
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public GetMailOrders401Response code(String code) {
    this.code = code;
    return this;
  }

 /**
   * Get message
   * @return message
  **/
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public GetMailOrders401Response message(String message) {
    this.message = message;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetMailOrders401Response {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

