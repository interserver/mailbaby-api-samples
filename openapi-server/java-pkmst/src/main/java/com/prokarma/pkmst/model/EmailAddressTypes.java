package com.prokarma.pkmst.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.prokarma.pkmst.model.EmailAddressName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * Response class to be returned by Api
 * @author pkmst
 *
 */
/**
 * A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (&#x60;\&quot;Name &lt;email&gt;\&quot;&#x60;), or a structured contact object.
 */
@ApiModel(description = "A flexible single email address that accepts either a plain address string, an RFC 822 named-address string (`\"Name <email>\"`), or a structured contact object.")

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPKMSTServerCodegen", comments = "Generator version: 7.26.0")
public class EmailAddressTypes   {
  @JsonProperty("email")
  private String email;

  @JsonProperty("name")
  private String name;

  public EmailAddressTypes email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address.
   * @return email
   */
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The email address.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmailAddressTypes name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Optional display name shown to recipients (e.g. in the `From:` header).
   * @return name
   */
  @ApiModelProperty(example = "John Smith", value = "Optional display name shown to recipients (e.g. in the `From:` header).")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailAddressTypes emailAddressTypes = (EmailAddressTypes) o;
    return Objects.equals(this.email, emailAddressTypes.email) &&
        Objects.equals(this.name, emailAddressTypes.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailAddressTypes {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

