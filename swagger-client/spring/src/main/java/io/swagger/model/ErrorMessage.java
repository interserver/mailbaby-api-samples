package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The response body returned when an error occurs.
 */
@Schema(description = "The response body returned when an error occurs.")
@Validated
@NotUndefined



public class ErrorMessage   {
  @JsonProperty("code")

  private Integer code = null;

  @JsonProperty("message")

  private String message = null;


  public ErrorMessage code(Integer code) { 

    this.code = code;
    return this;
  }

  /**
   * The HTTP-style status code associated with the error.
   * @return code
   **/
  
  @Schema(example = "400", required = true, description = "The HTTP-style status code associated with the error.")
  
  @NotNull
  public Integer getCode() {  
    return code;
  }



  public void setCode(Integer code) { 

    this.code = code;
  }

  public ErrorMessage message(String message) { 

    this.message = message;
    return this;
  }

  /**
   * A human-readable description of the error.
   * @return message
   **/
  
  @Schema(example = "The specified ID was invalid.", required = true, description = "A human-readable description of the error.")
  
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
