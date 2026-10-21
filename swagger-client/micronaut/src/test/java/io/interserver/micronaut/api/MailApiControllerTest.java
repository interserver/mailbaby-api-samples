package io.interserver.micronaut.api;

import io.interserver.micronaut.model.DenyRuleNew;
import io.interserver.micronaut.model.DenyRuleRecord;
import io.interserver.micronaut.model.EmailAddressParam;
import io.interserver.micronaut.model.ErrorMessage;
import io.interserver.micronaut.model.GenericResponse;
import io.interserver.micronaut.model.MailAttachment;
import io.interserver.micronaut.model.MailBlocks;
import io.interserver.micronaut.model.MailLog;
import io.interserver.micronaut.model.MailOrder;
import io.interserver.micronaut.model.MailOrderDetail;
import io.interserver.micronaut.model.MailStatsType;
import io.interserver.micronaut.model.SendMail;
import io.interserver.micronaut.model.SendMailAdv;
import io.interserver.micronaut.model.SendMailRaw;
import io.interserver.micronaut.model.SendMailTo;

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
        EmailAddressParam body = null;
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
    void getMailOrderByIdTest() {
        Long id = null;
        try {
            //TODO: api.getMailOrderById(id).blockingGet();
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
        String time = null;
        try {
            //TODO: api.getStats(time).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void rawMailTest() {
        SendMailRaw body = null;
        try {
            //TODO: api.rawMail(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendAdvMailFormTest() {
        String subject = null;
        String body = null;
        Object from = null;
        Object to = null;
        Object replyto = null;
        Object cc = null;
        Object bcc = null;
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
        SendMailTo to = null;
        String from = null;
        String subject = null;
        String body = null;
        Long id = null;
        try {
            //TODO: api.sendMail(to, from, subject, body, id).blockingGet();
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
        String messageId = null;
        String replyto = null;
        String headerfrom = null;
        Integer delivered = null;
        Integer skip = null;
        Integer limit = null;
        String startDate = null;
        String endDate = null;
        String sort = null;
        String dir = null;
        String groupby = null;
        try {
            //TODO: api.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

}
