package org.openapitools.model;

import io.swagger.annotations.ApiModel;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
  * Details for an Email
 **/
@ApiModel(description="Details for an Email")

public class SendMail  {
  
  @ApiModelProperty(example = "johndoe@company.com", required = true, value = "The Contact whom is the primary recipient of this email.")
 /**
   * The Contact whom is the primary recipient of this email.
  **/
  private String to;

  @ApiModelProperty(example = "janedoe@company.com", required = true, value = "The contact whom is the this email is from.")
 /**
   * The contact whom is the this email is from.
  **/
  private String from;

  @ApiModelProperty(example = "Attention Client", required = true, value = "The subject or title of the email")
 /**
   * The subject or title of the email
  **/
  private String subject;

  @ApiModelProperty(example = "This is an email to inform you that something noteworthy happened.", required = true, value = "The main email contents.")
 /**
   * The main email contents.
  **/
  private String body;
 /**
   * The Contact whom is the primary recipient of this email.
   * @return to
  **/
  @JsonProperty("to")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public SendMail to(String to) {
    this.to = to;
    return this;
  }

 /**
   * The contact whom is the this email is from.
   * @return from
  **/
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public SendMail from(String from) {
    this.from = from;
    return this;
  }

 /**
   * The subject or title of the email
   * @return subject
  **/
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SendMail subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
   * The main email contents.
   * @return body
  **/
  @JsonProperty("body")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public SendMail body(String body) {
    this.body = body;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMail {\n");
    
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

