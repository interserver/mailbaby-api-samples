package io.swagger.api;

import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailLog;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;
import io.swagger.model.SendMailAdvAttachments;
import io.swagger.model.SendMailAdvBcc;
import io.swagger.model.SendMailAdvCc;
import io.swagger.model.SendMailAdvFrom;
import io.swagger.model.SendMailAdvReplyto;
import io.swagger.model.SendMailAdvTo;

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
        try {
            api.getMailOrders().blockingGet();
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
        SendMailAdvFrom from = new SendMailAdvFrom();
        List<SendMailAdvTo> to = Arrays.asList(new SendMailAdvTo());
        List<SendMailAdvReplyto> replyto = Arrays.asList(new SendMailAdvReplyto());
        List<SendMailAdvCc> cc = Arrays.asList(new SendMailAdvCc());
        List<SendMailAdvBcc> bcc = Arrays.asList(new SendMailAdvBcc());
        List<SendMailAdvAttachments> attachments = Arrays.asList(new SendMailAdvAttachments());
        Long id = 789L;
        try {
            api.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id).blockingGet();
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
    void sendMailTest() {
        SendMail body = new SendMail();
        try {
            api.sendMail(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void viewMailLogTest() {
        Long id = 789L;
        String origin = "origin_example";
        String mx = "mx_example";
        String from = "from_example";
        String to = "to_example";
        String subject = "subject_example";
        String mailid = "mailid_example";
        Integer skip = 0;
        Integer limit = 100;
        Long startDate = 789L;
        Long endDate = 789L;
        try {
            api.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

}
