package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Raw Email Object
 */
@Schema(description = "Raw Email Object")
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-12-23T19:41:09.077744585-05:00[America/New_York]")


public class SendMailRaw   {
  @JsonProperty("raw_email")

  private String rawEmail = null;

  @JsonProperty("id")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer id = null;


  public SendMailRaw rawEmail(String rawEmail) { 

    this.rawEmail = rawEmail;
    return this;
  }

  /**
   * The entire email contents
   * @return rawEmail
   **/
  
  @Schema(required = true, description = "The entire email contents")
  
  @NotNull
  public String getRawEmail() {  
    return rawEmail;
  }



  public void setRawEmail(String rawEmail) { 

    this.rawEmail = rawEmail;
  }

  public SendMailRaw id(Integer id) { 

    this.id = id;
    return this;
  }

  /**
   * Optional order id
   * @return id
   **/
  
  @Schema(description = "Optional order id")
  
  public Integer getId() {  
    return id;
  }



  public void setId(Integer id) { 
    this.id = id;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMailRaw sendMailRaw = (SendMailRaw) o;
    return Objects.equals(this.rawEmail, sendMailRaw.rawEmail) &&
        Objects.equals(this.id, sendMailRaw.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawEmail, id);
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
