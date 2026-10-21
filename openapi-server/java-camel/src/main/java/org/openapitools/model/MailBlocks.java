package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.MailBlockClickHouse;
import org.openapitools.model.MailBlockRspamd;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 */

@Schema(name = "MailBlocks", description = "The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.")
@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", comments = "Generator version: 7.26.0")
public class MailBlocks {

  private List<@Valid MailBlockClickHouse> local = new ArrayList<>();

  private List<@Valid MailBlockClickHouse> mbtrap = new ArrayList<>();

  private List<@Valid MailBlockRspamd> subject = new ArrayList<>();

  public MailBlocks() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public MailBlocks(List<@Valid MailBlockClickHouse> local, List<@Valid MailBlockClickHouse> mbtrap, List<@Valid MailBlockRspamd> subject) {
    this.local = local;
    this.mbtrap = mbtrap;
    this.subject = subject;
  }

  public MailBlocks local(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
    return this;
  }

  public MailBlocks addLocalItem(MailBlockClickHouse localItem) {
    if (this.local == null) {
      this.local = new ArrayList<>();
    }
    this.local.add(localItem);
    return this;
  }

  /**
   * Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
   * @return local
   */
  @NotNull 
  @Schema(name = "local", description = "Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("local")
  public List<@Valid MailBlockClickHouse> getLocal() {
    return local;
  }

  public void setLocal(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
  }

  public MailBlocks mbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
    return this;
  }

  public MailBlocks addMbtrapItem(MailBlockClickHouse mbtrapItem) {
    if (this.mbtrap == null) {
      this.mbtrap = new ArrayList<>();
    }
    this.mbtrap.add(mbtrapItem);
    return this;
  }

  /**
   * Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
   * @return mbtrap
   */
  @NotNull 
  @Schema(name = "mbtrap", description = "Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mbtrap")
  public List<@Valid MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }

  public void setMbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

  public MailBlocks subject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
    return this;
  }

  public MailBlocks addSubjectItem(MailBlockRspamd subjectItem) {
    if (this.subject == null) {
      this.subject = new ArrayList<>();
    }
    this.subject.add(subjectItem);
    return this;
  }

  /**
   * Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
   * @return subject
   */
  @NotNull 
  @Schema(name = "subject", description = "Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subject")
  public List<@Valid MailBlockRspamd> getSubject() {
    return subject;
  }

  public void setSubject(List<@Valid MailBlockRspamd> subject) {
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
    MailBlocks mailBlocks = (MailBlocks) o;
    return Objects.equals(this.local, mailBlocks.local) &&
        Objects.equals(this.mbtrap, mailBlocks.mbtrap) &&
        Objects.equals(this.subject, mailBlocks.subject);
  }

  @Override
  public int hashCode() {
    return Objects.hash(local, mbtrap, subject);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailBlocks {\n");
    sb.append("    local: ").append(toIndentedString(local)).append("\n");
    sb.append("    mbtrap: ").append(toIndentedString(mbtrap)).append("\n");
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

