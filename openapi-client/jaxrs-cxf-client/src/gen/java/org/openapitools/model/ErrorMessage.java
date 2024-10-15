package org.openapitools.model;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * The resposne when an error occurs.
 **/
@ApiModel(description="The resposne when an error occurs.")

public class ErrorMessage  {
  
  @ApiModelProperty(example = "400", required = true, value = "The response code associated with the error.")
 /**
   * The response code associated with the error.
  **/
  private Integer code;

  @ApiModelProperty(example = "There was an error.", required = true, value = "The details or description of the error.")
 /**
   * The details or description of the error.
  **/
  private String message;
 /**
   * The response code associated with the error.
   * @return code
  **/
  @JsonProperty("code")
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.code, errorMessage.code) &&
        Objects.equals(this.message, errorMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

