package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * An email contact with an optional display name.  Used in structured address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;) in &#x60;SendMailAdv&#x60;.
 */

@Schema(name = "EmailAddressName", description = "An email contact with an optional display name.  Used in structured address fields (`from`, `to`, `cc`, `bcc`, `replyto`) in `SendMailAdv`.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class EmailAddressName implements EmailAddressTypes {

  private String email;

  private @Nullable String name;

  public EmailAddressName() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmailAddressName(String email) {
    this.email = email;
  }

  public EmailAddressName email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email address.
   * @return email
   */
  @NotNull @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "user@domain.com", description = "The email address.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

  public EmailAddressName name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Optional display name shown to recipients (e.g. in the `From:` header).
   * @return name
   */
  
  @Schema(name = "name", example = "John Smith", description = "Optional display name shown to recipients (e.g. in the `From:` header).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(@Nullable String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailAddressName emailAddressName = (EmailAddressName) o;
    return Objects.equals(this.email, emailAddressName.email) &&
        Objects.equals(this.name, emailAddressName.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailAddressName {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

