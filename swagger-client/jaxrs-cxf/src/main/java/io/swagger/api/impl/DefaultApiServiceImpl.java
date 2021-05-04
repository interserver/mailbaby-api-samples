package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

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
    public MailOrders getMailOrders(Long id) {
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
    public GenericResponse sendAdvMailById(SendMail body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     */
    public GenericResponse sendMailById(String subject, String body, String to, String from, Long id, String toName, String fromName) {
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
    public List<MailLog> viewMailLogById(Long id, String searchString, Integer skip, Integer limit) {
        // TODO: Implement...
        
        return null;
    }
    
}

