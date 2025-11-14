package io.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

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

/**
  * Raw Email Object
 **/
@Schema(description="Raw Email Object")
public class SendMailRaw   {
  
  @Schema(required = true, description = "The entire email contents")
 /**
   * The entire email contents  
  **/
  private String rawEmail = null;
  
  @Schema(description = "Optional order id")
 /**
   * Optional order id  
  **/
  private Integer id = null;
 /**
   * The entire email contents
   * @return rawEmail
  **/
  @JsonProperty("raw_email")
  public String getRawEmail() {
    return rawEmail;
  }

  public void setRawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
  }

  public SendMailRaw rawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
    return this;
  }

 /**
   * Optional order id
   * @return id
  **/
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public SendMailRaw id(Integer id) {
    this.id = id;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailRaw {\n");
    
    sb.append("    rawEmail: ").append(toIndentedString(rawEmail)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
