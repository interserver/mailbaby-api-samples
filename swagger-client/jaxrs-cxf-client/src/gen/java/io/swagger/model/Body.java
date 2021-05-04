package io.swagger.model;


import io.swagger.v3.oas.annotations.media.Schema;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Body   {
  
  @Schema(example = "test subject", required = true, description = "The Subject of the email")
 /**
   * The Subject of the email  
  **/
  private String subject = null;
  
  @Schema(example = "test body", required = true, description = "The contents of the email")
 /**
   * The contents of the email  
  **/
  private String body = null;
  
  @Schema(example = "me@domain.com", required = true, description = "The email address of who this email will be sent from.")
 /**
   * The email address of who this email will be sent from.  
  **/
  private String from = null;
  
  @Schema(example = "my@domain.com", required = true, description = "The email address of who this email will be sent to.")
 /**
   * The email address of who this email will be sent to.  
  **/
  private String to = null;
  
  @Schema(example = "5000", description = "The ID of your mail order this will be sent through.")
 /**
   * The ID of your mail order this will be sent through.  
  **/
  private Integer id = null;
  
  @Schema(example = "John Doe", description = "The name or title of who this email is being sent to.")
 /**
   * The name or title of who this email is being sent to.  
  **/
  private String toName = null;
  
  @Schema(example = "Jane Doe", description = "The name or title of who this email is being sent from.")
 /**
   * The name or title of who this email is being sent from.  
  **/
  private String fromName = null;
 /**
   * The Subject of the email
   * @return subject
  **/
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Body subject(String subject) {
    this.subject = subject;
    return this;
  }

 /**
   * The contents of the email
   * @return body
  **/
  @JsonProperty("body")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Body body(String body) {
    this.body = body;
    return this;
  }

 /**
   * The email address of who this email will be sent from.
   * @return from
  **/
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Body from(String from) {
    this.from = from;
    return this;
  }

 /**
   * The email address of who this email will be sent to.
   * @return to
  **/
  @JsonProperty("to")
  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Body to(String to) {
    this.to = to;
    return this;
  }

 /**
   * The ID of your mail order this will be sent through.
   * @return id
  **/
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Body id(Integer id) {
    this.id = id;
    return this;
  }

 /**
   * The name or title of who this email is being sent to.
   * @return toName
  **/
  @JsonProperty("toName")
  public String getToName() {
    return toName;
  }

  public void setToName(String toName) {
    this.toName = toName;
  }

  public Body toName(String toName) {
    this.toName = toName;
    return this;
  }

 /**
   * The name or title of who this email is being sent from.
   * @return fromName
  **/
  @JsonProperty("fromName")
  public String getFromName() {
    return fromName;
  }

  public void setFromName(String fromName) {
    this.fromName = fromName;
  }

  public Body fromName(String fromName) {
    this.fromName = fromName;
    return this;
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
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
