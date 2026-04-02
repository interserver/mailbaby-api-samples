package org.openapitools.model;

import groovy.transform.Canonical
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.model.MailStatsVolume;

@Canonical
class MailStatsType {

    enum TimeEnum {
    
        All("all"),
        
        Billing("billing"),
        
        Month("month"),
        
        SevenDays("7d"),
        
        TwentyFourHours("24h"),
        
        Day("day"),
        
        OneHour("1h")
    
        private final String value
    
        TimeEnum(String value) {
            this.value = value
        }
    
        String getValue() {
            value
        }
    
        @Override
        String toString() {
            String.valueOf(value)
        }
    }

    /* The time window these `received`, `sent`, and `volume` statistics cover. */
    TimeEnum time = TimeEnum.OneHour
    /* Total messages accepted during the current billing cycle.  Used to calculate the `cost` value. */
    Integer usage
    /* The ISO 4217 currency code for this account (e.g. `USD`). */
    String currency
    /* Estimated cost for the current billing cycle combining the base plan price and per-email charges ($0.20/1000 emails). */
    Double cost
    /* Count of messages accepted by the relay within the selected `time` window. Includes messages still in queue. */
    Integer received
    /* Count of messages successfully delivered to the destination MX within the selected `time` window.  Will be ≤ `received`. */
    Integer sent
    
    MailStatsVolume volume
}
