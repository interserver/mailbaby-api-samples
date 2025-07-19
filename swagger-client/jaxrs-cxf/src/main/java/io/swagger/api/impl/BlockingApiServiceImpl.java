package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailBlocks;

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
public class BlockingApiServiceImpl implements BlockingApi {
    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     *
     */
    public GenericResponse addRule(String user, String type, String data) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     *
     */
    public GenericResponse addRule(DenyRuleNew body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Removes an deny mail rule.
     *
     * Removes one of the configured deny mail rules from the system.
     *
     */
    public GenericResponse deleteRule(Integer ruleId) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Removes an email address from the blocked list
     *
     * Removes an email address from the various block lists. 
     *
     */
    public GenericResponse delistBlock(String body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * displays a list of blocked email addresses
     *
     */
    public MailBlocks getMailBlocks() {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Displays a listing of deny email rules.
     *
     * Returns a listing of all the deny block rules you have configured.
     *
     */
    public List<DenyRuleRecord> getRules() {
        // TODO: Implement...
        
        return null;
    }
    
}

