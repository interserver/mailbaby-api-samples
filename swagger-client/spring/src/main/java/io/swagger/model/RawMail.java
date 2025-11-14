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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-14T05:52:58.531972048-05:00[America/New_York]")


public class RawMail   {
  @JsonProperty("raw_email")

  private String rawEmail = null;


  public RawMail rawEmail(String rawEmail) { 

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

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RawMail rawMail = (RawMail) o;
    return Objects.equals(this.rawEmail, rawMail.rawEmail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rawEmail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RawMail {\n");
    
    sb.append("    rawEmail: ").append(toIndentedString(rawEmail)).append("\n");
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
