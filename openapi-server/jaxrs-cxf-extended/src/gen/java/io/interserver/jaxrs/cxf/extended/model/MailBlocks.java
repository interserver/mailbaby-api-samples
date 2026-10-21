package io.interserver.jaxrs.cxf.extended.model;

import io.interserver.jaxrs.cxf.extended.model.MailBlockClickHouse;
import io.interserver.jaxrs.cxf.extended.model.MailBlockRspamd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.
 */
@ApiModel(description="The complete set of blocked addresses and message patterns returned by `GET /mail/blocks`. Three independent block sources are combined into one response. Use `POST /mail/blocks/delete` with a `from` address from any entry to delist it.")

public class MailBlocks  {
  
 /**
  * Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
  */
  @ApiModelProperty(required = true, value = "Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.")
  private List<@Valid MailBlockClickHouse> local = new ArrayList<>();

 /**
  * Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
  */
  @ApiModelProperty(required = true, value = "Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.")
  private List<@Valid MailBlockClickHouse> mbtrap = new ArrayList<>();

 /**
  * Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
  */
  @ApiModelProperty(required = true, value = "Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.")
  private List<@Valid MailBlockRspamd> subject = new ArrayList<>();
 /**
  * Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
  * @return local
  */
  @JsonProperty("local")
  @NotNull
  public List<@Valid MailBlockClickHouse> getLocal() {
    return local;
  }

  /**
   * Sets the <code>local</code> property.
   */
 public void setLocal(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
  }

  /**
   * Sets the <code>local</code> property.
   */
  public MailBlocks local(List<@Valid MailBlockClickHouse> local) {
    this.local = local;
    return this;
  }

  /**
   * Adds a new item to the <code>local</code> list.
   */
  public MailBlocks addLocalItem(MailBlockClickHouse localItem) {
    this.local.add(localItem);
    return this;
  }

 /**
  * Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.
  * @return mbtrap
  */
  @JsonProperty("mbtrap")
  @NotNull
  public List<@Valid MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }

  /**
   * Sets the <code>mbtrap</code> property.
   */
 public void setMbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

  /**
   * Sets the <code>mbtrap</code> property.
   */
  public MailBlocks mbtrap(List<@Valid MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
    return this;
  }

  /**
   * Adds a new item to the <code>mbtrap</code> list.
   */
  public MailBlocks addMbtrapItem(MailBlockClickHouse mbtrapItem) {
    this.mbtrap.add(mbtrapItem);
    return this;
  }

 /**
  * Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.
  * @return subject
  */
  @JsonProperty("subject")
  @NotNull
  public List<@Valid MailBlockRspamd> getSubject() {
    return subject;
  }

  /**
   * Sets the <code>subject</code> property.
   */
 public void setSubject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
  }

  /**
   * Sets the <code>subject</code> property.
   */
  public MailBlocks subject(List<@Valid MailBlockRspamd> subject) {
    this.subject = subject;
    return this;
  }

  /**
   * Adds a new item to the <code>subject</code> list.
   */
  public MailBlocks addSubjectItem(MailBlockRspamd subjectItem) {
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
  private static String toIndentedString(Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}

