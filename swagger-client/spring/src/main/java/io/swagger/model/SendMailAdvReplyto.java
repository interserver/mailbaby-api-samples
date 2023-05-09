package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An Email Contact
 */
@Schema(description = "An Email Contact")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-05-09T00:51:50.862675-04:00[America/New_York]")


public class SendMailAdvReplyto   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("name")
  private String name = null;

  public SendMailAdvReplyto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address
   * @return email
   **/
  @Schema(example = "support@company.com", required = true, description = "The email address")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SendMailAdvReplyto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * (optional) Name to use for the sending contact.
   * @return name
   **/
  @Schema(example = "Support Staff", description = "(optional) Name to use for the sending contact.")
  
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
    return Objects.equals(this.email, sendMailAdvReplyto.email) &&
        Objects.equals(this.name, sendMailAdvReplyto.name);
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
