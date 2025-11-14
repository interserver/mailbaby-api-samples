package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Raw Email Object
 **/
@Schema(description = "Raw Email Object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2025-11-14T05:52:30.119517379-05:00[America/New_York]")

public class RawMail   {
  @JsonProperty("raw_email")
  private String rawEmail = null;
  /**
   * The entire email contents
   **/
  public RawMail rawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
    return this;
  }

  
  @Schema(required = true, description = "The entire email contents")
  @JsonProperty("raw_email")
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
    return Objects.equals(rawEmail, rawMail.rawEmail);
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
