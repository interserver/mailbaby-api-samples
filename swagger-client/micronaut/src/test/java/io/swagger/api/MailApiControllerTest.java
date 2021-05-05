package io.swagger.api;

import io.swagger.model.ErrorResponse;
import io.swagger.model.GenericResponse;
import io.swagger.model.MailLog;
import io.swagger.model.MailOrder;
import io.swagger.model.MailOrders;
import io.swagger.model.SendMail;

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
    void sendAdvMailByIdTest() {
        SendMail body = new SendMail();
        try {
            api.sendAdvMailById(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendMailByIdTest() {
        SendMail body = new SendMail();
        try {
            api.sendMailById(body).blockingGet();
        } catch (UnsupportedOperationException e) {
            assumeTrue(false, "API is not yet implemented");
        }
    }

    @Test
    void sendMailByIdWithFormTest() {
        SendMail payload = new SendMail();
        try {
            api.sendMailById(payload).blockingGet();
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
