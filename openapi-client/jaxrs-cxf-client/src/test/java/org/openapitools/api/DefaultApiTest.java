/**
 * Mail Baby API
 * This is an API for accesssing the mail services.
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.api;

import org.openapitools.model.Error;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailLog;
import org.openapitools.model.MailOrder;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

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
 * Mail Baby API
 *
 * <p>This is an API for accesssing the mail services.
 *
 * API tests for DefaultApi 
 */
public class DefaultApiTest {


    private DefaultApi api;
    
    @Before
    public void setup() {
        JacksonJsonProvider provider = new JacksonJsonProvider();
        List providers = new ArrayList();
        providers.add(provider);
        
        api = JAXRSClientFactory.create("https://api.mailbaby.net", DefaultApi.class, providers);
        org.apache.cxf.jaxrs.client.Client client = WebClient.client(api);
        
        ClientConfiguration config = WebClient.getConfig(client); 
    }

    
    /**
     * Gets mail order information by id
     *
     * returns information about a mail order in the system with the given id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getMailByIdTest() {
        Long id = null;
        //MailOrder response = api.getMailById(id);
        //assertNotNull(response);
        // TODO: test validations
        
        
    }
    
    /**
     * displays a list of mail service orders
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getMailOrdersTest() {
        //List<MailOrder> response = api.getMailOrders();
        //assertNotNull(response);
        // TODO: test validations
        
        
    }
    
    /**
     * Checks if the server is running
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pingServerTest() {
        //api.pingServer();
        
        // TODO: test validations
        
        
    }
    
    /**
     * places a mail order
     *
     * Adds an item to the system
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void placeMailOrderTest() {
        MailOrder mailOrder = null;
        //api.placeMailOrder(mailOrder);
        
        // TODO: test validations
        
        
    }
    
    /**
     * Sends an Email
     *
     * Sends An email through one of your mail orders.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendMailByIdTest() {
        Long id = null;
        String subject = null;
        String body = null;
        String to = null;
        String from = null;
        //GenericResponse response = api.sendMailById(id, subject, body, to, from);
        //assertNotNull(response);
        // TODO: test validations
        
        
    }
    
    /**
     * validatess order details before placing an order
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateMailOrderTest() {
        //api.validateMailOrder();
        
        // TODO: test validations
        
        
    }
    
    /**
     * displays the mail log
     *
     * By passing in the appropriate options, you can search for available inventory in the system 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void viewMailLogByIdTest() {
        Long id = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        //List<MailLog> response = api.viewMailLogById(id, searchString, skip, limit);
        //assertNotNull(response);
        // TODO: test validations
        
        
    }
    
}