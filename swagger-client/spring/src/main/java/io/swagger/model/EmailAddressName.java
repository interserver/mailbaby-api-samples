package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An email contact.
 */
@Schema(description = "An email contact.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-02T13:33:33.953471686-04:00[America/New_York]")


public class EmailAddressName  implements EmailAddressTypes {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("name")
  private String name = null;

  public EmailAddressName email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address.
   * @return email
   **/
  @Schema(example = "user@domain.com", required = true, description = "The email address.")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmailAddressName name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name to use for the sending contact.
   * @return name
   **/
  @Schema(example = "John Smith", description = "Name to use for the sending contact.")
  
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
    EmailAddressName emailAddressName = (EmailAddressName) o;
    return Objects.equals(this.email, emailAddressName.email) &&
        Objects.equals(this.name, emailAddressName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailAddressName {\n");
    
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
