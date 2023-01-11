package io.swagger.model;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * An Email Contact
 **/
@Schema(description = "An Email Contact")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2023-01-10T22:49:52.655060-05:00[America/New_York]")
public class SendMailAdvBcc   {
  @JsonProperty("email")
  private String email = null;
  @JsonProperty("name")
  private String name = null;
  /**
   * The email address
   **/
  public SendMailAdvBcc email(String email) {
    this.email = email;
    return this;
  }

  
  @Schema(example = "records@company.com", required = true, description = "The email address")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * (optional) Name to use for the BCC contact.
   **/
  public SendMailAdvBcc name(String name) {
    this.name = name;
    return this;
  }

  
  @Schema(example = "Records Department", description = "(optional) Name to use for the BCC contact.")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendMailAdvBcc sendMailAdvBcc = (SendMailAdvBcc) o;
    return Objects.equals(email, sendMailAdvBcc.email) &&
        Objects.equals(name, sendMailAdvBcc.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendMailAdvBcc {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
