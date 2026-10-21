package org.openapitools.server.model;

import java.util.HashMap;
import java.util.Map;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
 */
public class MailStatsVolume   {

    private Map<String, Integer> to = new HashMap<>();
    private Map<String, Integer> from = new HashMap<>();
    private Map<String, Integer> ip = new HashMap<>();

    /**
     * Default constructor.
     */
    public MailStatsVolume() {
    // JSON-B / Jackson
    }

    /**
     * Create MailStatsVolume.
     *
     * @param to Message counts keyed by destination (envelope &#x60;to&#x60;) email address.
     * @param from Message counts keyed by sender (envelope &#x60;from&#x60;) email address.
     * @param ip Message counts keyed by originating client IP address.
     */
    public MailStatsVolume(
        Map<String, Integer> to, 
        Map<String, Integer> from, 
        Map<String, Integer> ip
    ) {
        this.to = to;
        this.from = from;
        this.ip = ip;
    }



    /**
     * Message counts keyed by destination (envelope `to`) email address.
     * @return to
     */
    public Map<String, Integer> getTo() {
        return to;
    }

    public void setTo(Map<String, Integer> to) {
        this.to = to;
    }

    /**
     * Message counts keyed by sender (envelope `from`) email address.
     * @return from
     */
    public Map<String, Integer> getFrom() {
        return from;
    }

    public void setFrom(Map<String, Integer> from) {
        this.from = from;
    }

    /**
     * Message counts keyed by originating client IP address.
     * @return ip
     */
    public Map<String, Integer> getIp() {
        return ip;
    }

    public void setIp(Map<String, Integer> ip) {
        this.ip = ip;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailStatsVolume {\n");
        
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
    private static String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

