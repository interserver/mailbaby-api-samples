package org.openapitools.model;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * An Email Contact
 **/
@ApiModel(description="An Email Contact")

public class SendMailAdvReplytoInner  {
  
  @ApiModelProperty(example = "support@company.com", required = true, value = "The email address")
 /**
   * The email address
  **/
  private String email;

  @ApiModelProperty(example = "Support Staff", value = "(optional) Name to use for the sending contact.")
 /**
   * (optional) Name to use for the sending contact.
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

  public SendMailAdvReplytoInner email(String email) {
    this.email = email;
    return this;
  }

 /**
   * (optional) Name to use for the sending contact.
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SendMailAdvReplytoInner name(String name) {
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
    SendMailAdvReplytoInner sendMailAdvReplytoInner = (SendMailAdvReplytoInner) o;
    return Objects.equals(email, sendMailAdvReplytoInner.email) &&
        Objects.equals(name, sendMailAdvReplytoInner.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvReplytoInner {\n");
    
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

