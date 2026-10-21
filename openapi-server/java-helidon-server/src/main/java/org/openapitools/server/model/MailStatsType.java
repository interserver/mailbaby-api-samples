package org.openapitools.server.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.server.model.MailStatsVolume;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


/**
 * Account usage statistics returned by `GET /mail/stats`.  Includes billing-cycle usage totals (for cost calculation) as well as time-windowed sent/received counts and volume breakdowns by IP, destination, and source address.
 */
public class MailStatsType   {


    /**
    * The time window these `received`, `sent`, and `volume` statistics cover.
    */
    public enum TimeEnum {
        All("all"),
        Billing("billing"),
        Month("month"),
        SevenDays("7d"),
        TwentyFourHours("24h"),
        Day("day"),
        OneHour("1h"),
        UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

        private String value;

        TimeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }


        @JsonCreator
        public static TimeEnum fromValue(String text) {
            for (TimeEnum b : TimeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + text + "'");
        }
    }


    private TimeEnum time = TimeEnum.OneHour;
    private Integer usage;
    private String currency;
    private Double cost;
    private Integer received;
    private Integer sent;
    private MailStatsVolume volume;

    /**
     * Default constructor.
     */
    public MailStatsType() {
    // JSON-B / Jackson
    }

    /**
     * Create MailStatsType.
     *
     * @param time The time window these &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics cover.
     * @param usage Total messages accepted during the current billing cycle.  Used to calculate the &#x60;cost&#x60; value.
     * @param currency The ISO 4217 currency code for this account (e.g. &#x60;USD&#x60;).
     * @param cost Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
     * @param received Count of messages accepted by the relay within the selected &#x60;time&#x60; window. Includes messages still in queue.
     * @param sent Count of messages successfully delivered to the destination MX within the selected &#x60;time&#x60; window.  Will be ≤ &#x60;received&#x60;.
     * @param volume volume
     */
    public MailStatsType(
        TimeEnum time, 
        Integer usage, 
        String currency, 
        Double cost, 
        Integer received, 
        Integer sent, 
        MailStatsVolume volume
    ) {
        this.time = time;
        this.usage = usage;
        this.currency = currency;
        this.cost = cost;
        this.received = received;
        this.sent = sent;
        this.volume = volume;
    }



    /**
     * The time window these `received`, `sent`, and `volume` statistics cover.
     * @return time
     */
    public TimeEnum getTime() {
        return time;
    }

    public void setTime(TimeEnum time) {
        this.time = time;
    }

    /**
     * Total messages accepted during the current billing cycle.  Used to calculate the `cost` value.
     * @return usage
     */
    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    /**
     * The ISO 4217 currency code for this account (e.g. `USD`).
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails).
     * @return cost
     */
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue.
     * @return received
     */
    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }

    /**
     * Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`.
     * @return sent
     */
    public Integer getSent() {
        return sent;
    }

    public void setSent(Integer sent) {
        this.sent = sent;
    }

    /**
     * Get volume
     * @return volume
     */
    public MailStatsVolume getVolume() {
        return volume;
    }

    public void setVolume(MailStatsVolume volume) {
        this.volume = volume;
    }

    /**
      * Create a string representation of this pojo.
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MailStatsType {\n");
        
        sb.append("    time: ").append(toIndentedString(time)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
        sb.append("    received: ").append(toIndentedString(received)).append("\n");
        sb.append("    sent: ").append(toIndentedString(sent)).append("\n");
        sb.append("    volume: ").append(toIndentedString(volume)).append("\n");
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

