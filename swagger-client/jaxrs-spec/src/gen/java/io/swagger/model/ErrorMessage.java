package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * The resposne when an error occurs.
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "The resposne when an error occurs.")

public class ErrorMessage   {

  private @Valid Integer code = null;

  private @Valid String message = null;

  /**
   * The response code associated with the error.
   **/
  public ErrorMessage code(Integer code) {
    this.code = code;
    return this;
  }

  
  @ApiModelProperty(example = "400", required = true, value = "The response code associated with the error.")
  @JsonProperty("code")
  @NotNull

  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * The details or description of the error.
   **/
  public ErrorMessage message(String message) {
    this.message = message;
    return this;
  }

  
  @ApiModelProperty(example = "There was an error.", required = true, value = "The details or description of the error.")
  @JsonProperty("message")
  @NotNull

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(code, errorMessage.code) &&
        Objects.equals(message, errorMessage.message);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
