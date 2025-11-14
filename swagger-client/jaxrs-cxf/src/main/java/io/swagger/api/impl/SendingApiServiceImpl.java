package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailRaw;

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
     * Sends a raw email
     *
     * This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.
     *
     */
    public GenericResponse rawMail(SendMailRaw body) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends a raw email
     *
     * This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.
     *
     */
    public GenericResponse rawMail(String rawEmail, Integer id) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
     *
     */
    public GenericResponse sendAdvMail(String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<MailAttachment> attachments, Long id) {
        // TODO: Implement...
        
        return null;
    }
    
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
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
    public GenericResponse sendMail(String to, String from, String subject, String body, Integer id) {
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

