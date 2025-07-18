/**
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


package org.openapitools.api;

import org.openapitools.model.ErrorMessage;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailStatsType;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * MailBaby Email Delivery and Management Service API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * API tests for HistoryApi
 */
public class HistoryApiTest {


    private HistoryApi api;

    @Before
    public void setup() {
        JacksonJsonProvider provider = new JacksonJsonProvider();
        List providers = new ArrayList();
        providers.add(provider);

        api = JAXRSClientFactory.create("https://api.mailbaby.net", HistoryApi.class, providers);
        org.apache.cxf.jaxrs.client.Client client = WebClient.client(api);

        ClientConfiguration config = WebClient.getConfig(client);
    }

    
    /**
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStatsTest() {
        String time = null;
        //MailStatsType response = api.getStats(time);
        //assertNotNull(response);
        // TODO: test validations


    }
    
    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void viewMailLogTest() {
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
        //MailLog response = api.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered);
        //assertNotNull(response);
        // TODO: test validations


    }
    
}
