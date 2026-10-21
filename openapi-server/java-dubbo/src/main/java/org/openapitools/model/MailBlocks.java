package org.openapitools.model;

import org.openapitools.model.MailBlockClickHouse;
import org.openapitools.model.MailBlockRspamd;
import java.util.*;
import java.util.Objects;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import java.time.*;
import java.math.*;
@Generated(value = "org.openapitools.codegen.languages.JavaDubboServerCodegen", comments = "Generator version: 7.26.0")

/**
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 */
public class MailBlocks implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
   */
  @JsonProperty("local")
  private List<MailBlockClickHouse> local = new ArrayList<>();

  /**
   * Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.
   */
  @JsonProperty("mbtrap")
  private List<MailBlockClickHouse> mbtrap = new ArrayList<>();

  /**
   * Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.
   */
  @JsonProperty("subject")
  private List<MailBlockRspamd> subject = new ArrayList<>();

  /**
   * Messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
   * @return local
   */
  public List<MailBlockClickHouse> getLocal() {
    return local;
  }

  public void setLocal(List<MailBlockClickHouse> local) {
    this.local = local;
  }

  /**
   * Messages flagged by the &#x60;MBTRAP&#x60; rspamd rule in the last 5 days. These triggered MailBaby&#39;s honeypot / trap address detection.
   * @return mbtrap
   */
  public List<MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }

  public void setMbtrap(List<MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

  /**
   * Senders whose messages contained spam-indicative subjects (containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with more than 4 occurrences of the same subject in the last 3 days.
   * @return subject
   */
  public List<MailBlockRspamd> getSubject() {
    return subject;
  }

  public void setSubject(List<MailBlockRspamd> subject) {
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
