package io.swagger.model;
import java.util.Objects;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.
 **/
@Schema(description = "Optional.  Blind-carbon-copy recipients.  These addresses receive the message but are not listed in any visible header.")


public class AllOfSendMailAdvBcc extends EmailAddressesTypes  {

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllOfSendMailAdvBcc allOfSendMailAdvBcc = (AllOfSendMailAdvBcc) o;
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllOfSendMailAdvBcc {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
