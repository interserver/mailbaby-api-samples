package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Details for an Email
 **/
@Schema(description = "Details for an Email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2021-05-05T07:19:42.293294-04:00[America/New_York]")
public class Body1   {
  @JsonProperty("to")
  private String to = null;
  @JsonProperty("from")
  private String from = null;
  @JsonProperty("subject")
  private String subject = null;
  @JsonProperty("body")
  private String body = null;
  /**
   * The Contact whom is the primary recipient of this email.
   **/
  public Body1 to(String to) {
    this.to = to;
    return this;
  }

  
  @Schema(example = "johndoe@company.com", description = "The Contact whom is the primary recipient of this email.")
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
  public Body1 from(String from) {
    this.from = from;
    return this;
  }

  
  @Schema(example = "johndoe@company.com", description = "The contact whom is the this email is from.")
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
  public Body1 subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @Schema(example = "Your Package has been Delivered!", description = "The subject or title of the email")
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
  public Body1 body(String body) {
    this.body = body;
    return this;
  }

  
  @Schema(example = "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else. ", description = "The main email contents.")
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
    Body1 body1 = (Body1) o;
    return Objects.equals(to, body1.to) &&
        Objects.equals(from, body1.from) &&
        Objects.equals(subject, body1.subject) &&
        Objects.equals(body, body1.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, from, subject, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body1 {\n");
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
