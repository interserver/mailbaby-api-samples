package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
/**
 * The resposne when an error occurs.
 **/
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

import javax.xml.bind.annotation.*;

@Schema(description = "The resposne when an error occurs.")

public class ErrorMessage   {
  private Integer code = null;
  private String message = null;

  /**
   * The response code associated with the error.
   **/
  public ErrorMessage code(Integer code) {
    this.code = code;
    return this;
  }

  
  
  @Schema(example = "400", required = true, description = "The response code associated with the error.")
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

  
  
  @Schema(example = "There was an error.", required = true, description = "The details or description of the error.")
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
