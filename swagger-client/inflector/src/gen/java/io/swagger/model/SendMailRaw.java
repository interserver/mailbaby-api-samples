package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Raw Email Object
 **/
@Schema(description = "Raw Email Object")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2025-11-14T07:22:19.646134809-05:00[America/New_York]")

public class SendMailRaw   {
  @JsonProperty("raw_email")
  private String rawEmail = null;
  @JsonProperty("id")
  private Integer id = null;
  /**
   * The entire email contents
   **/
  public SendMailRaw rawEmail(String rawEmail) {
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

  /**
   * Optional order id
   **/
  public SendMailRaw id(Integer id) {
    this.id = id;
    return this;
  }

  
  @Schema(description = "Optional order id")
  @JsonProperty("id")
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
    return Objects.equals(rawEmail, sendMailRaw.rawEmail) &&
        Objects.equals(id, sendMailRaw.id);
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
