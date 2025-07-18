/*
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.model.MailStatsTypeVolumeFrom;
import org.openapitools.model.MailStatsTypeVolumeIp;
import org.openapitools.model.MailStatsTypeVolumeTo;
import com.fasterxml.jackson.annotation.*;

import javax.validation.constraints.*;
import javax.validation.Valid;
import io.micronaut.core.annotation.*;
import javax.annotation.Generated;

/**
 * MailStatsTypeVolume
 */
@JsonPropertyOrder({
  MailStatsTypeVolume.JSON_PROPERTY_TO,
  MailStatsTypeVolume.JSON_PROPERTY_FROM,
  MailStatsTypeVolume.JSON_PROPERTY_IP
})
@JsonTypeName("MailStatsType_volume")
@Generated(value="org.openapitools.codegen.languages.JavaMicronautClientCodegen", date="2025-07-19T04:15:45.324289885-04:00[America/New_York]", comments = "Generator version: 7.14.0-SNAPSHOT")
@Introspected
public class MailStatsTypeVolume {
    public static final String JSON_PROPERTY_TO = "to";
    private MailStatsTypeVolumeTo to;

    public static final String JSON_PROPERTY_FROM = "from";
    private MailStatsTypeVolumeFrom from;

    public static final String JSON_PROPERTY_IP = "ip";
    private MailStatsTypeVolumeIp ip;

    public MailStatsTypeVolume() {
    }

    public MailStatsTypeVolume to(MailStatsTypeVolumeTo to) {
        this.to = to;
        return this;
    }

    /**
     * Get to
     * @return to
     */
    @Valid
    @Nullable
    @JsonProperty(JSON_PROPERTY_TO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public MailStatsTypeVolumeTo getTo() {
        return to;
    }

    @JsonProperty(JSON_PROPERTY_TO)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTo(MailStatsTypeVolumeTo to) {
        this.to = to;
    }

    public MailStatsTypeVolume from(MailStatsTypeVolumeFrom from) {
        this.from = from;
        return this;
    }

    /**
     * Get from
     * @return from
     */
    @Valid
    @Nullable
    @JsonProperty(JSON_PROPERTY_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public MailStatsTypeVolumeFrom getFrom() {
        return from;
    }

    @JsonProperty(JSON_PROPERTY_FROM)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setFrom(MailStatsTypeVolumeFrom from) {
        this.from = from;
    }

    public MailStatsTypeVolume ip(MailStatsTypeVolumeIp ip) {
        this.ip = ip;
        return this;
    }

    /**
     * Get ip
     * @return ip
     */
    @Valid
    @Nullable
    @JsonProperty(JSON_PROPERTY_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public MailStatsTypeVolumeIp getIp() {
        return ip;
    }

    @JsonProperty(JSON_PROPERTY_IP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setIp(MailStatsTypeVolumeIp ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MailStatsTypeVolume mailStatsTypeVolume = (MailStatsTypeVolume) o;
        return Objects.equals(this.to, mailStatsTypeVolume.to) &&
            Objects.equals(this.from, mailStatsTypeVolume.from) &&
            Objects.equals(this.ip, mailStatsTypeVolume.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, from, ip);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailStatsTypeVolume {\n");
        sb.append("    to: ").append(toIndentedString(to)).append("\n");
        sb.append("    from: ").append(toIndentedString(from)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

