package io.swagger.api;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddress;
import io.swagger.model.EmailAddressName;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.InlineResponse401;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

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
    void addRuleWithFormTest() {
        String user = "user_example";
        String type = "type_example";
        String data = "data_example";
        try {
            api.addRule(user, type, data).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void addRuleTest() {
        DenyRuleNew body = new DenyRuleNew();
        try {
            api.addRule(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void deleteRuleTest() {
        Integer ruleId = 56;
        try {
            api.deleteRule(ruleId).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void delistBlockTest() {
        EmailAddress body = new EmailAddress();
        try {
            api.delistBlock(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void delistBlockWithFormTest() {
        String email = "email_example";
        try {
            api.delistBlock(email).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getMailBlocksTest() {
        try {
            api.getMailBlocks().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getMailOrdersTest() {
        try {
            api.getMailOrders().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getRulesTest() {
        try {
            api.getRules().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getStatsTest() {
        try {
            api.getStats().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendAdvMailWithFormTest() {
        String subject = "subject_example";
        String body = "body_example";
        EmailAddressName from = new EmailAddressName();
        List<EmailAddressName> to = Arrays.asList(new EmailAddressName());
        List<EmailAddressName> replyto = Arrays.asList(new EmailAddressName());
        List<EmailAddressName> cc = Arrays.asList(new EmailAddressName());
        List<EmailAddressName> bcc = Arrays.asList(new EmailAddressName());
        List<MailAttachment> attachments = Arrays.asList(new MailAttachment());
        Long id = 789L;
        try {
            api.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id).blockingGet();
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
