package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2021-05-04T18:07:31.669174-04:00[America/New_York]")public class Body   {
  private String subject = null;
  private String body = null;
  private String from = null;
  private String to = null;
  private Integer id = null;
  private String toName = null;
  private String fromName = null;

  /**
   * The Subject of the email
   **/
  
  @Schema(example = "test subject", required = true, description = "The Subject of the email")
  @JsonProperty("subject")
  @NotNull
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * The contents of the email
   **/
  
  @Schema(example = "test body", required = true, description = "The contents of the email")
  @JsonProperty("body")
  @NotNull
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * The email address of who this email will be sent from.
   **/
  
  @Schema(example = "me@domain.com", required = true, description = "The email address of who this email will be sent from.")
  @JsonProperty("from")
  @NotNull
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * The email address of who this email will be sent to.
   **/
  
  @Schema(example = "my@domain.com", required = true, description = "The email address of who this email will be sent to.")
  @JsonProperty("to")
  @NotNull
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * The ID of your mail order this will be sent through.
   **/
  
  @Schema(example = "5000", description = "The ID of your mail order this will be sent through.")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * The name or title of who this email is being sent to.
   **/
  
  @Schema(example = "John Doe", description = "The name or title of who this email is being sent to.")
  @JsonProperty("toName")
  public String getToName() {
    return toName;
  }
  public void setToName(String toName) {
    this.toName = toName;
  }

  /**
   * The name or title of who this email is being sent from.
   **/
  
  @Schema(example = "Jane Doe", description = "The name or title of who this email is being sent from.")
  @JsonProperty("fromName")
  public String getFromName() {
    return fromName;
  }
  public void setFromName(String fromName) {
    this.fromName = fromName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(subject, body.subject) &&
        Objects.equals(body, body.body) &&
        Objects.equals(from, body.from) &&
        Objects.equals(to, body.to) &&
        Objects.equals(id, body.id) &&
        Objects.equals(toName, body.toName) &&
        Objects.equals(fromName, body.fromName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, body, from, to, id, toName, fromName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    toName: ").append(toIndentedString(toName)).append("\n");
    sb.append("    fromName: ").append(toIndentedString(fromName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
