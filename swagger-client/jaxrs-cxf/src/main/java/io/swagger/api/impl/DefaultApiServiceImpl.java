package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailLog;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;

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
 * MailBaby Email Delivery API
 *
 * <p>**Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.**   # 📌 Overview  This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net).   # 🔐 Authentication  In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site.  We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 */
public class DefaultApiServiceImpl implements DefaultApi {
    /**
     * displays a list of mail service orders
     *
     */
    public List<InlineResponse200> getMailOrders() {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Checks if the server is running
     *
     */
    public void pingServer() {
        // TODO: Implement...
        
        
    }
    
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     */
    public GenericResponse sendAdvMail(SendMailAdv body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     */
    public GenericResponse sendAdvMail(String subject, String body, SendMailAdvFrom from, List<SendMailAdvTo> to, List<SendMailAdvReplyto> replyto, List<SendMailAdvCc> cc, List<SendMailAdvBcc> bcc, List<SendMailAdvAttachments> attachments, Long id) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email
     *
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     *
     */
    public GenericResponse sendMail(String to, String from, String subject, String body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email
     *
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     *
     */
    public GenericResponse sendMail(SendMail body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * displays the mail log
     *
     * By passing in the appropriate options, you can search for available inventory in the system 
     *
     */
    public MailLog viewMailLog(Long id, String search, Integer skip, Integer limit, Long startDate, Long endDate) {
        // TODO: Implement...
        
        return null;
    }
    
}

