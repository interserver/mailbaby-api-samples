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

public class SendMailAdvReplyto   {

  private @Valid String email = null;

  private @Valid String name = null;

  /**
   * The email address
   **/
  public SendMailAdvReplyto email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(example = "support@company.com", required = true, value = "The email address")
  @JsonProperty("email")
  @NotNull

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * (optional) Name to use for the sending contact.
   **/
  public SendMailAdvReplyto name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "Support Staff", value = "(optional) Name to use for the sending contact.")
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
    SendMailAdvReplyto sendMailAdvReplyto = (SendMailAdvReplyto) o;
    return Objects.equals(email, sendMailAdvReplyto.email) &&
        Objects.equals(name, sendMailAdvReplyto.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvReplyto {\n");
    
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
