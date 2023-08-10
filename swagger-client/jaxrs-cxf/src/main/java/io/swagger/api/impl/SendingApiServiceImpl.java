package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.EmailAddressName;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailAttachment;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

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
public class SendingApiServiceImpl implements SendingApi {
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     */
    public GenericResponse sendAdvMail(String subject, String body, EmailAddressName from, List<EmailAddressName> to, List<EmailAddressName> replyto, List<EmailAddressName> cc, List<EmailAddressName> bcc, List<MailAttachment> attachments, Long id) {
        // TODO: Implement...
        
        return null;
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
    
}

