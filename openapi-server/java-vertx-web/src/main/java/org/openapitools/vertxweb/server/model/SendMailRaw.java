package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendMailRaw   {
  
  private String rawEmail;
  private Long id;

  public SendMailRaw () {

  }

  public SendMailRaw (String rawEmail, Long id) {
    this.rawEmail = rawEmail;
    this.id = id;
  }

    
  @JsonProperty("raw_email")
  public String getRawEmail() {
    return rawEmail;
  }
  public void setRawEmail(String rawEmail) {
    this.rawEmail = rawEmail;
  }

    
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
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
  private String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}
