package io.interserver.jaxrs.cxf.cdi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.interserver.jaxrs.cxf.cdi.model.MailBlockClickHouse;
import io.interserver.jaxrs.cxf.cdi.model.MailBlockRspamd;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 **/

import io.swagger.annotations.*;
import java.util.Objects;


@ApiModel(description = "The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.")
public class MailBlocks   {
  
  private List<@Valid MailBlockClickHouse> local = new ArrayList<>();

  private List<@Valid MailBlockClickHouse> mbtrap = new ArrayList<>();

  private List<@Valid MailBlockRspamd> subject = new ArrayList<>();

  /**
   * Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
   **/
  public MailBlocks local(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.")
  @JsonProperty("local")
  @NotNull
  public List<@Valid MailBlockClickHouse> getLocal() {
    return local;
  }
  public void setLocal(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
  }

  public MailBlocks addLocalItem(MailBlockClickHouse localItem) {
    if (this.local == null) {
      this.local = new ArrayList<>();
    }
    this.local.add(localItem);
    return this;
  }


  /**
   * Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.
   **/
  public MailBlocks mbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.")
  @JsonProperty("mbtrap")
  @NotNull
  public List<@Valid MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }
  public void setMbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

  public MailBlocks addMbtrapItem(MailBlockClickHouse mbtrapItem) {
    if (this.mbtrap == null) {
      this.mbtrap = new ArrayList<>();
    }
    this.mbtrap.add(mbtrapItem);
    return this;
  }


  /**
   * Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.
   **/
  public MailBlocks subject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.")
  @JsonProperty("subject")
  @NotNull
  public List<@Valid MailBlockRspamd> getSubject() {
    return subject;
  }
  public void setSubject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
  }

  public MailBlocks addSubjectItem(MailBlockRspamd subjectItem) {
    if (this.subject == null) {
      this.subject = new ArrayList<>();
    }
    this.subject.add(subjectItem);
    return this;
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

