package io.interserver.spring.model;

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
 * Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
 */

@Schema(name = "SendMailRaw", description = "Request body for `POST /mail/rawsend`.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing `DKIM-Signature` header intact.  The `From`, `To`, `Cc`, and `Bcc` addresses are extracted from the message headers automatically — you do not need to specify them separately.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.26.0")
public class SendMailRaw {

  private String rawEmail;

  private @Nullable Long id;

  public SendMailRaw() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SendMailRaw(String rawEmail) {
    this.rawEmail = rawEmail;
  }

  public SendMailRaw rawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
    return this;
  }

  /**
   * The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.
   * @return rawEmail
   */
  @NotNull 
  @Schema(name = "raw_email", description = "The complete RFC 822 email message including all headers and the body. Must include at minimum `From`, `To`, `Subject`, `Date`, and `MIME-Version` headers.  DKIM signatures in the `DKIM-Signature` header are transmitted verbatim and will pass verification at the destination.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("raw_email")
  public String getRawEmail() {
    return rawEmail;
  }

  @JsonProperty("raw_email")
  public void setRawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
  }

  public SendMailRaw id(@Nullable Long id) {
    this.id = id;
    return this;
  }

  /**
   * Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.
   * @return id
   */
  
  @Schema(name = "id", description = "Optional numeric ID of the mail order to use for SMTP authentication. If omitted the first active order on your account is used.  Valid IDs are returned by `GET /mail`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(@Nullable Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

