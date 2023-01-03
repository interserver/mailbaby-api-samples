package org.openapitools.api;

import org.openapitools.model.GenericResponse;
import org.openapitools.model.GetMailOrders200ResponseInner;
import org.openapitools.model.GetMailOrders401Response;
import org.openapitools.model.MailLog;
import org.openapitools.model.SendMailAdv;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import jakarta.inject.Inject;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;


/**
 * API tests for DefaultApi
 */
@MicronautTest
public class DefaultApiTest {

    @Inject
    DefaultApi api;

    
    /**
     * displays a list of mail service orders
     */
    @Test
    @Disabled("Not Implemented")
    public void getMailOrdersTest() {
        // given

        // when
        List<GetMailOrders200ResponseInner> body = api.getMailOrders().block();

        // then
        // TODO implement the getMailOrdersTest()
    }

    
    /**
     * Checks if the server is running
     */
    @Test
    @Disabled("Not Implemented")
    public void pingServerTest() {
        // given

        // when
        api.pingServer().block();

        // then
        // TODO implement the pingServerTest()
    }

    
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     */
    @Test
    @Disabled("Not Implemented")
    public void sendAdvMailTest() {
        // given
        SendMailAdv sendMailAdv = new SendMailAdv("Your Package has been Delivered!", "The package you ordered on 2021-01-23 has been delivered. If the package is broken into many pieces, please blaim someone else.", null, Arrays.asList());

        // when
        GenericResponse body = api.sendAdvMail(sendMailAdv).block();

        // then
        // TODO implement the sendAdvMailTest()
    }

    
    /**
     * Sends an Email
     *
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     */
    @Test
    @Disabled("Not Implemented")
    public void sendMailTest() {
        // given
        String to = "example";
        String from = "example";
        String subject = "example";
        String _body = "example";

        // when
        GenericResponse body = api.sendMail(to, from, subject, _body).block();

        // then
        // TODO implement the sendMailTest()
    }

    
    /**
     * displays the mail log
     *
     * By passing in the appropriate options, you can search for available inventory in the system 
     */
    @Test
    @Disabled("Not Implemented")
    public void viewMailLogTest() {
        // given
        Long id = 56L;
        String search = "example";
        Integer skip = 0;
        Integer limit = 100;
        Long startDate = 56L;
        Long endDate = 56L;

        // when
        MailLog body = api.viewMailLog(id, search, skip, limit, startDate, endDate).block();

        // then
        // TODO implement the viewMailLogTest()
    }

    
}
