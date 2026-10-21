package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The response body returned when an error occurs.
 */

@Schema(name = "ErrorMessage", description = "The response body returned when an error occurs.")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class ErrorMessage {

  private Integer code;

  private String message;

  public ErrorMessage() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorMessage(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public ErrorMessage code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * The HTTP-style status code associated with the error.
   * @return code
   */
  @NotNull 
  @Schema(name = "code", example = "400", description = "The HTTP-style status code associated with the error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
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
   */
  @NotNull 
  @Schema(name = "message", example = "The specified ID was invalid.", description = "A human-readable description of the error.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

