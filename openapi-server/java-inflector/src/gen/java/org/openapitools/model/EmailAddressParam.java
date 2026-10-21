package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * A single email address parameter used as the body of &#x60;POST /mail/blocks/delete&#x60;.
 **/

@ApiModel(description = "A single email address parameter used as the body of `POST /mail/blocks/delete`.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", comments = "Generator version: 7.26.0")
public class EmailAddressParam   {
  @JsonProperty("email")
  private String email;

  /**
   * The email address to delist from all block lists.
   **/
  public EmailAddressParam email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The email address to delist from all block lists.")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailAddressParam emailAddressParam = (EmailAddressParam) o;
    return Objects.equals(email, emailAddressParam.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailAddressParam {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

