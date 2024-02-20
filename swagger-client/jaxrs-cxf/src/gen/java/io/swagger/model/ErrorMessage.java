package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
  * The resposne when an error occurs.
 **/
@Schema(description="The resposne when an error occurs.")
public class ErrorMessage   {
  
  @Schema(example = "400", required = true, description = "The response code associated with the error.")
 /**
   * The response code associated with the error.  
  **/
  private Integer code = null;
  
  @Schema(example = "There was an error.", required = true, description = "The details or description of the error.")
 /**
   * The details or description of the error.  
  **/
  private String message = null;
 /**
   * The response code associated with the error.
   * @return code
  **/
  @JsonProperty("code")
  @NotNull
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ErrorMessage code(Integer code) {
    this.code = code;
    return this;
  }

 /**
   * The details or description of the error.
   * @return message
  **/
  @JsonProperty("message")
  @NotNull
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorMessage message(String message) {
    this.message = message;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
