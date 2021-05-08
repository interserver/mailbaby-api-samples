package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvFrom;

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
 * Mail Baby API
 *
 * <p>This is an API defintion for accesssing the Mail.Baby mail service.
 *
 */
public class DefaultApiServiceImpl implements DefaultApi {
    /**
     * displays a list of mail service orders
     *
     */
    public MailOrders getMailOrders() {
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
     * places a mail order
     *
     * Adds an item to the system
     *
     */
    public void placeMailOrder(MailOrder body) {
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
    public GenericResponse sendAdvMail(String subject, String body, List<SendMailAdvFrom> from, List<MailContact> to, Long id, List<MailContact> replyto, List<MailContact> cc, List<MailContact> bcc, List<MailAttachment> attachments) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     */
    public GenericResponse sendMail(String to, String from, String subject, String body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     */
    public GenericResponse sendMail(SendMail body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * validatess order details before placing an order
     *
     */
    public void validateMailOrder() {
        // TODO: Implement...
        
        
    }
    
    /**
     * displays the mail log
     *
     * By passing in the appropriate options, you can search for available inventory in the system 
     *
     */
    public List<MailLog> viewMailLog(Long id, String searchString, Integer skip, Integer limit) {
        // TODO: Implement...
        
        return null;
    }
    
}

