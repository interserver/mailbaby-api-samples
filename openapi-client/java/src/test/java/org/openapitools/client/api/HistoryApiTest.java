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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.ErrorMessage;
import org.openapitools.client.model.MailLog;
import org.openapitools.client.model.MailStatsType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for HistoryApi
 */
@Disabled
public class HistoryApiTest {

    private final HistoryApi api = new HistoryApi();

    /**
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getStatsTest() throws ApiException {
        String time = null;
        MailStatsType response = api.getStats(time);
        // TODO: test validations
    }

    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system 
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void viewMailLogTest() throws ApiException {
        Long id = null;
        String origin = null;
        String mx = null;
        String from = null;
        String to = null;
        String subject = null;
        String mailid = null;
        Integer skip = null;
        Integer limit = null;
        Long startDate = null;
        Long endDate = null;
        String replyto = null;
        String headerfrom = null;
        String delivered = null;
        MailLog response = api.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered);
        // TODO: test validations
    }

}
