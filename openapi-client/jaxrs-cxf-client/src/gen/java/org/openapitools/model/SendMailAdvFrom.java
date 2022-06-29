package org.openapitools.model;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * The information to use for the From address in the email. from.
 **/
@ApiModel(description="The information to use for the From address in the email. from.")

public class SendMailAdvFrom  {
  
  @ApiModelProperty(example = "business@company.com", required = true, value = "The email address")
 /**
   * The email address
  **/
  private String email;

  @ApiModelProperty(example = "The Man", value = "(optional) Name to use for the sending contact.")
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

  public SendMailAdvFrom email(String email) {
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

  public SendMailAdvFrom name(String name) {
    this.name = name;
    return this;
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
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

