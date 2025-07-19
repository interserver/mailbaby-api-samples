package io.swagger.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyServerCodegen", date = "2025-07-19T04:18:59.781785343-04:00[America/New_York]")
public class MailStatsTypeVolumeFrom   {
  private Integer billingAtSomedomainCom = null;  private Integer salesAtSomedomainCom = null;

  /**
   **/
  
  @Schema(description = "")
  @JsonProperty("billing@somedomain.com")
  @NotNull
  public Integer getBillingAtSomedomainCom() {
    return billingAtSomedomainCom;
  }
  public void setBillingAtSomedomainCom(Integer billingAtSomedomainCom) {
    this.billingAtSomedomainCom = billingAtSomedomainCom;
  }

  /**
   **/
  
  @Schema(description = "")
  @JsonProperty("sales@somedomain.com")
  @NotNull
  public Integer getSalesAtSomedomainCom() {
    return salesAtSomedomainCom;
  }
  public void setSalesAtSomedomainCom(Integer salesAtSomedomainCom) {
    this.salesAtSomedomainCom = salesAtSomedomainCom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailStatsTypeVolumeFrom mailStatsTypeVolumeFrom = (MailStatsTypeVolumeFrom) o;
    return Objects.equals(billingAtSomedomainCom, mailStatsTypeVolumeFrom.billingAtSomedomainCom) &&
        Objects.equals(salesAtSomedomainCom, mailStatsTypeVolumeFrom.salesAtSomedomainCom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(billingAtSomedomainCom, salesAtSomedomainCom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailStatsTypeVolumeFrom {\n");
    
    sb.append("    billingAtSomedomainCom: ").append(toIndentedString(billingAtSomedomainCom)).append("\n");
    sb.append("    salesAtSomedomainCom: ").append(toIndentedString(salesAtSomedomainCom)).append("\n");
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
