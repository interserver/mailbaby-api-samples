package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * An Email Contact
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "An Email Contact")

public class SendMailAdvFrom   {

  private @Valid String email = null;

  private @Valid String name = null;

  /**
   * The email address
   **/
  public SendMailAdvFrom email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(example = "johndoe@company.com", required = true, value = "The email address")
  @JsonProperty("email")
  @NotNull

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Optional contact name
   **/
  public SendMailAdvFrom name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "John Doe", value = "Optional contact name")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMailAdvFrom sendMailAdvFrom = (SendMailAdvFrom) o;
    return Objects.equals(email, sendMailAdvFrom.email) &&
        Objects.equals(name, sendMailAdvFrom.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvFrom {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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