package org.openapitools.api;

import org.openapitools.model.ErrorMessage;
import org.openapitools.model.MailOrder;
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
 * API tests for ServicesApi
 */
@MicronautTest
public class ServicesApiTest {

    @Inject
    ServicesApi api;

    
    /**
     * displays a list of mail service orders
     *
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     */
    @Test
    @Disabled("Not Implemented")
    public void getMailOrdersTest() {
        // given

        // when
        List<MailOrder> body = api.getMailOrders().block();

        // then
        // TODO implement the getMailOrdersTest()
    }

    
}
