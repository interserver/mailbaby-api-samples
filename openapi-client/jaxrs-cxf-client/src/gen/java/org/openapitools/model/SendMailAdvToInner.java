package org.openapitools.model;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * An Email Contact
 **/
@ApiModel(description="An Email Contact")

public class SendMailAdvToInner  {
  
  @ApiModelProperty(example = "johndoe@isp.com", required = true, value = "The email address")
 /**
   * The email address
  **/
  private String email;

  @ApiModelProperty(example = "John Doe", value = "(optional) Name to use for the destination contact.")
 /**
   * (optional) Name to use for the destination contact.
  **/
  private String name;
 /**
   * The email address
   * @return email
  **/
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SendMailAdvToInner email(String email) {
    this.email = email;
    return this;
  }

 /**
   * (optional) Name to use for the destination contact.
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SendMailAdvToInner name(String name) {
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
    SendMailAdvToInner sendMailAdvToInner = (SendMailAdvToInner) o;
    return Objects.equals(email, sendMailAdvToInner.email) &&
        Objects.equals(name, sendMailAdvToInner.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvToInner {\n");
    
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

