/*
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
/**
 * Details for an Email
 */
@Schema(description = "Details for an Email")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-05-05T07:12:33.264226-04:00[America/New_York]")
public class Body1 {
  @SerializedName("to")
  private String to = null;

  @SerializedName("from")
  private String from = null;

  @SerializedName("subject")
  private String subject = null;

  @SerializedName("body")
  private String body = null;

  public Body1 to(String to) {
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

  public Body1 from(String from) {
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

  public Body1 subject(String subject) {
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

  public Body1 body(String body) {
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
    Body1 body1 = (Body1) o;
    return Objects.equals(this.to, body1.to) &&
        Objects.equals(this.from, body1.from) &&
        Objects.equals(this.subject, body1.subject) &&
        Objects.equals(this.body, body1.body);
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