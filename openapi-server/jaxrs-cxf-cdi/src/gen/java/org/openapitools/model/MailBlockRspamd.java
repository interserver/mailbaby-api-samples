package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist it.
 **/

import io.swagger.annotations.*;
import java.util.Objects;


@ApiModel(description = "A block pattern sourced from the rspamd database.  Represents a sender whose recent messages contained suspicious subject lines (e.g. containing relay/proxy strings) repeated more than 4 times in the last 3 days. The `from` address can be passed to `POST /mail/blocks/delete` to delist it.")
public class MailBlockRspamd   {
  
  private String from;

  private String subject;

  /**
   * The sender email address.  Pass this value as &#x60;email&#x60; to &#x60;POST /mail/blocks/delete&#x60; to delist the sender.
   **/
  public MailBlockRspamd from(String from) {
    this.from = from;
    return this;
  }

  
  @ApiModelProperty(example = "user@domain.com", required = true, value = "The sender email address.  Pass this value as `email` to `POST /mail/blocks/delete` to delist the sender.")
  @JsonProperty("from")
  @NotNull
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }


  /**
   * The suspicious subject pattern that triggered the block.
   **/
  public MailBlockRspamd subject(String subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(example = "Test email", required = true, value = "The suspicious subject pattern that triggered the block.")
  @JsonProperty("subject")
  @NotNull
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailBlockRspamd mailBlockRspamd = (MailBlockRspamd) o;
    return Objects.equals(this.from, mailBlockRspamd.from) &&
        Objects.equals(this.subject, mailBlockRspamd.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlockRspamd {\n");
    
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
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

