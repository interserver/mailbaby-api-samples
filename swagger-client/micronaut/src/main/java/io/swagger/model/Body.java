package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.micronaut.validation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details for an Email
 */
@Schema(description = "Details for an Email")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2021-05-05T07:07:27.876026-04:00[America/New_York]")
public class Body   {
  @JsonProperty("to")
  private String to = null;

  @JsonProperty("from")
  private String from = null;

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("body")
  private String body = null;

  public Body to(String to) {
    this.to = to;
    return this;
  }

  /**
   * The Contact whom is the primary recipient of this email.
   * @return to
  **/
  @Schema(example = "johndoe@company.com", description = "The Contact whom is the primary recipient of this email.")

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Body from(String from) {
    this.from = from;
    return this;
  }

  /**
   * The contact whom is the this email is from.
   * @return from
  **/
  @Schema(example = "johndoe@company.com", description = "The contact whom is the this email is from.")

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Body subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The subject or title of the email
   * @return subject
  **/
  @Schema(example = "Your Package has been Delivered!", description = "The subject or title of the email")

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Body body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The main email contents.
   * @return body
  **/
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. ", description = "The main email contents.")

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
    Body body = (Body) o;
    return Objects.equals(this.to, body.to) &&
        Objects.equals(this.from, body.from) &&
        Objects.equals(this.subject, body.subject) &&
        Objects.equals(this.body, body.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, subject, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
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
