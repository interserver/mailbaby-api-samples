/*
 * Mail Baby API
 * This is an API for accesssing the mail services.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: detain@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Error;
import io.swagger.client.model.GenericResponse;
import io.swagger.client.model.MailLog;
import io.swagger.client.model.MailOrder;
import io.swagger.client.model.MailOrders;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@Ignore
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    /**
     * Gets mail order information by id
     *
     * returns information about a mail order in the system with the given id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getMailByIdTest() throws ApiException {
        Long id = null;
        MailOrder response = api.getMailById(id);

        // TODO: test validations
    }
    /**
     * displays a list of mail service orders
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getMailOrdersTest() throws ApiException {
        MailOrders response = api.getMailOrders();

        // TODO: test validations
    }
    /**
     * Checks if the server is running
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void pingServerTest() throws ApiException {
        api.pingServer();

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
    public void placeMailOrderTest() throws ApiException {
        MailOrder body = null;
        api.placeMailOrder(body);

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
    public void sendMailByIdTest() throws ApiException {
        Long id = null;
        String subject = null;
        String body = null;
        String to = null;
        String from = null;
        GenericResponse response = api.sendMailById(id, subject, body, to, from);

        // TODO: test validations
    }
    /**
     * validatess order details before placing an order
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void validateMailOrderTest() throws ApiException {
        api.validateMailOrder();

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
    public void viewMailLogByIdTest() throws ApiException {
        Long id = null;
        String searchString = null;
        Integer skip = null;
        Integer limit = null;
        List<MailLog> response = api.viewMailLogById(id, searchString, skip, limit);

        // TODO: test validations
    }
}