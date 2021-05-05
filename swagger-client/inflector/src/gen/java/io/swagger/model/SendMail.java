package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Details for an Email
 **/
@Schema(description = "Details for an Email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2021-05-05T15:32:40.501382-04:00[America/New_York]")
public class SendMail   {
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
  public SendMail to(String to) {
    this.to = to;
    return this;
  }

  
  @Schema(example = "johndoe@company.com", required = true, description = "The Contact whom is the primary recipient of this email.")
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

  
  @Schema(example = "janedoe@company.com", required = true, description = "The contact whom is the this email is from.")
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

  
  @Schema(example = "Attention Client", required = true, description = "The subject or title of the email")
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

  
  @Schema(example = "This is an email to inform you that something noteworthy happened.", required = true, description = "The main email contents.")
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
