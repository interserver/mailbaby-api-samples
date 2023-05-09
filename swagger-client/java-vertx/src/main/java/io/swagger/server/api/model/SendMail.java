package io.swagger.server.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import io.vertx.core.json.JsonObject;
import io.vertx.codegen.annotations.DataObject;
/**
 * Details for an Email
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaVertXServerCodegen", date = "2023-05-09T00:51:46.773748-04:00[America/New_York]")



public class SendMail   {
  private String to = null;

  private String from = null;

  private String subject = null;

  private String body = null;

  public SendMail to(String to) {
    this.to = to;
    return this;
  }

  /**
   * The Contact whom is the primary recipient of this email.
   * @return to
   **/
    public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public SendMail from(String from) {
    this.from = from;
    return this;
  }

  /**
   * The contact whom is the this email is from.
   * @return from
   **/
    public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public SendMail subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The subject or title of the email
   * @return subject
   **/
    public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public SendMail body(String body) {
    this.body = body;
    return this;
  }

  /**
   * The main email contents.
   * @return body
   **/
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
    return Objects.equals(this.to, sendMail.to) &&
        Objects.equals(this.from, sendMail.from) &&
        Objects.equals(this.subject, sendMail.subject) &&
        Objects.equals(this.body, sendMail.body);
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
