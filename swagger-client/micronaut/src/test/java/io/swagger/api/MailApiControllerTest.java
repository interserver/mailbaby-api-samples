package io.swagger.api;

import io.swagger.model.DenyRuleNew;
import io.swagger.model.DenyRuleRecord;
import io.swagger.model.EmailAddressTypes;
import io.swagger.model.EmailAddressesTypes;
import io.swagger.model.ErrorMessage;
import io.swagger.model.GenericResponse;
import io.swagger.model.InlineResponse200;
import io.swagger.model.MailAttachment;
import io.swagger.model.MailBlocks;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.SendMail;
import io.swagger.model.SendMailAdv;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;

import java.util.*;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@MicronautTest
class MailApiControllerTest {

    @Inject
    private MailApi api;

    @Test
    void addRuleFormTest() {
        String user = null;
        String type = null;
        String data = null;
        try {
            //TODO: api.addRule(user, type, data).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void deleteRuleTest() {
        Integer ruleId = null;
        try {
            //TODO: api.deleteRule(ruleId).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void delistBlockTest() {
        String body = null;
        try {
            //TODO: api.delistBlock(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getMailBlocksTest() {
        try {
            //TODO: api.getMailBlocks().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getMailOrdersTest() {
        try {
            //TODO: api.getMailOrders().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getRulesTest() {
        try {
            //TODO: api.getRules().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void getStatsTest() {
        try {
            //TODO: api.getStats().blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendAdvMailFormTest() {
        String subject = null;
        String body = null;
        EmailAddressTypes from = null;
        EmailAddressesTypes to = null;
        EmailAddressesTypes replyto = null;
        EmailAddressesTypes cc = null;
        EmailAddressesTypes bcc = null;
        List<MailAttachment> attachments = null;
        Long id = null;
        try {
            //TODO: api.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendMailFormTest() {
        String to = null;
        String from = null;
        String subject = null;
        String body = null;
        try {
            //TODO: api.sendMail(to, from, subject, body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void viewMailLogTest() {
        Long id = null;
        String origin = null;
        String mx = null;
        String from = null;
        String to = null;
        String subject = null;
        String mailid = null;
        Integer skip = null;
        Integer limit = null;
        Long startDate = null;
        Long endDate = null;
        try {
            //TODO: api.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

}
