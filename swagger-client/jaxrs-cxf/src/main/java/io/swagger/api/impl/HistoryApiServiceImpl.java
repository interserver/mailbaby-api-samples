package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.ErrorMessage;
import io.swagger.model.InlineResponse200;
import io.swagger.model.MailLog;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import org.apache.cxf.jaxrs.ext.multipart.*;


/**
 * MailBaby Email Delivery and Management Service API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 */
public class HistoryApiServiceImpl implements HistoryApi {
    /**
     * Account usage statistics.
     *
     * Returns information about the usage on your mail accounts.
     *
     */
    public List<InlineResponse200> getStats() {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * displays the mail log
     *
     * Get a listing of the emails sent through this system 
     *
     */
    public MailLog viewMailLog(Long id, String origin, String mx, String from, String to, String subject, String mailid, Integer skip, Integer limit, Long startDate, Long endDate) {
        // TODO: Implement...
        
        return null;
    }
    
}

