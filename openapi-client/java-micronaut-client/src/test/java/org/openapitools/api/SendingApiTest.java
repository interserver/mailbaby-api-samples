package org.openapitools.api;

import org.openapitools.model.EmailAddressName;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.GetMailOrders401Response;
import org.openapitools.model.MailAttachment;
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
 * API tests for SendingApi
 */
@MicronautTest
public class SendingApiTest {

    @Inject
    SendingApi api;

    
    /**
     * Sends an Email with Advanced Options
     *
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     */
    @Test
    @Disabled("Not Implemented")
    public void sendAdvMailTest() {
        // given
        String subject = "example";
        String _body = "example";
        EmailAddressName from = new EmailAddressName();
        List<EmailAddressName> to = Arrays.asList();
        List<EmailAddressName> replyto = Arrays.asList();
        List<EmailAddressName> cc = Arrays.asList();
        List<EmailAddressName> bcc = Arrays.asList();
        List<MailAttachment> attachments = Arrays.asList();
        Long id = 56L;

        // when
        GenericResponse body = api.sendAdvMail(subject, _body, from, to, replyto, cc, bcc, attachments, id).block();

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

    
}
