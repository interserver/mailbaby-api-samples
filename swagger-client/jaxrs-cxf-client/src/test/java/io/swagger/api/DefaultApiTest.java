/**
 * Mail Baby API
 * This is an API defintion for accesssing the Mail.Baby mail service.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
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
 * <p>This is an API defintion for accesssing the Mail.Baby mail service.
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
        
        api = JAXRSClientFactory.create("https://api.mailbaby.net/", DefaultApi.class, providers);
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
        //MailOrders response = api.getMailOrders();
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
        MailOrder body = null;
        //api.placeMailOrder(body);
        
        // TODO: test validations
        
        
    }
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void sendAdvMailByIdTest() {
        SendMail body = null;
        Long id = null;
        //GenericResponse response = api.sendAdvMailById(body, id);
        //assertNotNull(response);
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
        String toName = null;
        String from = null;
        String fromName = null;
        //GenericResponse response = api.sendMailById(id, subject, body, to, toName, from, fromName);
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