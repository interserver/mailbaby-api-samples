package org.openapitools.vertxweb.server.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.vertxweb.server.model.MailBlockClickHouse;
import org.openapitools.vertxweb.server.model.MailBlockRspamd;

/**
 * The complete set of blocked addresses and message patterns returned by &#x60;GET /mail/blocks&#x60;. Three independent block sources are combined into one response. Use &#x60;POST /mail/blocks/delete&#x60; with a &#x60;from&#x60; address from any entry to delist it.
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MailBlocks   {
  
  private List<MailBlockClickHouse> local = new ArrayList<>();
  private List<MailBlockClickHouse> mbtrap = new ArrayList<>();
  private List<MailBlockRspamd> subject = new ArrayList<>();

  public MailBlocks () {

  }

  public MailBlocks (List<MailBlockClickHouse> local, List<MailBlockClickHouse> mbtrap, List<MailBlockRspamd> subject) {
    this.local = local;
    this.mbtrap = mbtrap;
    this.subject = subject;
  }

    
  @JsonProperty("local")
  public List<MailBlockClickHouse> getLocal() {
    return local;
  }
  public void setLocal(List<MailBlockClickHouse> local) {
    this.local = local;
  }

    
  @JsonProperty("mbtrap")
  public List<MailBlockClickHouse> getMbtrap() {
    return mbtrap;
  }
  public void setMbtrap(List<MailBlockClickHouse> mbtrap) {
    this.mbtrap = mbtrap;
  }

    
  @JsonProperty("subject")
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
    return Objects.equals(local, mailBlocks.local) &&
        Objects.equals(mbtrap, mailBlocks.mbtrap) &&
        Objects.equals(subject, mailBlocks.subject);
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
