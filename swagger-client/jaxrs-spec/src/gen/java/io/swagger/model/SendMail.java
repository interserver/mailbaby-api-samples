package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Details for an Email
 **/
import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
@Schema(description = "Details for an Email")

public class SendMail   {

  private @Valid String to = null;

  private @Valid String from = null;

  private @Valid String subject = null;

  private @Valid String body = null;

  /**
   * The Contact whom is the primary recipient of this email.
   **/
  public SendMail to(String to) {
    this.to = to;
    return this;
  }

  
  @ApiModelProperty(example = "johndoe@company.com", value = "The Contact whom is the primary recipient of this email.")
  @JsonProperty("to")

  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * The contact whom is the this email is from.
   **/
  public SendMail from(String from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(example = "johndoe@company.com", value = "The contact whom is the this email is from.")
  @JsonProperty("from")

  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * The subject or title of the email
   **/
  public SendMail subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(example = "Your Package has been Delivered!", value = "The subject or title of the email")
  @JsonProperty("subject")

  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The main email contents.
   **/
  public SendMail body(String body) {
    this.body = body;
    return this;
  }

  
  @ApiModelProperty(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. ", value = "The main email contents.")
  @JsonProperty("body")

  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMail sendMail = (SendMail) o;
    return Objects.equals(to, sendMail.to) &&
        Objects.equals(from, sendMail.from) &&
        Objects.equals(subject, sendMail.subject) &&
        Objects.equals(body, sendMail.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, subject, body);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
