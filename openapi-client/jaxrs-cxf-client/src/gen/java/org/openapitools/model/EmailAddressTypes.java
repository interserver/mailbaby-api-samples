package org.openapitools.model;

import io.swagger.annotations.ApiModel;
import org.openapitools.model.EmailAddressName;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * 
 **/
@ApiModel(description="")

public class EmailAddressTypes  {
  
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The email address.")
 /**
   * The email address.
  **/
  private String email;

  @ApiModelProperty(example = "John Smith", value = "Name to use for the sending contact.")
 /**
   * Name to use for the sending contact.
  **/
  private String name;
 /**
   * The email address.
   * @return email
  **/
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public EmailAddressTypes email(String email) {
    this.email = email;
    return this;
  }

 /**
   * Name to use for the sending contact.
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EmailAddressTypes name(String name) {
    this.name = name;
    return this;
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

