package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailContact;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvFrom;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@MicronautTest
class MailApiControllerTest {

    @Inject
    private MailApi api;

    @Test
    void getMailOrdersTest() {
        Long id = 789L;
        try {
            api.getMailOrders(id).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void placeMailOrderTest() {
        MailOrder body = new MailOrder();
        try {
            api.placeMailOrder(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendAdvMailTest() {
        SendMailAdv body = new SendMailAdv();
        try {
            api.sendAdvMail(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendAdvMailWithFormTest() {
        String subject = "subject_example";
        String body = "body_example";
        List<SendMailAdvFrom> from = Arrays.asList(new SendMailAdvFrom());
        List<MailContact> to = Arrays.asList(new MailContact());
        Long id = 789L;
        List<MailContact> replyto = Arrays.asList(new MailContact());
        List<MailContact> cc = Arrays.asList(new MailContact());
        List<MailContact> bcc = Arrays.asList(new MailContact());
        List<MailAttachment> attachments = Arrays.asList(new MailAttachment());
        try {
            api.sendAdvMail(subject, body, from, to, id, replyto, cc, bcc, attachments).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendMailTest() {
        SendMail body = new SendMail();
        try {
            api.sendMail(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendMailWithFormTest() {
        String to = "to_example";
        String from = "from_example";
        String subject = "subject_example";
        String body = "body_example";
        try {
            api.sendMail(to, from, subject, body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void validateMailOrderTest() {
        try {
            api.validateMailOrder().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void viewMailLogByIdTest() {
        Long id = 789L;
        String searchString = "searchString_example";
        Integer skip = 56;
        Integer limit = 56;
        try {
            api.viewMailLogById(id, searchString, skip, limit).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

}
