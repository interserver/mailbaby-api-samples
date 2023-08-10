package org.openapitools.api;

import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddress;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.GetMailOrders401Response;
import org.openapitools.model.MailBlocks;
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
 * API tests for BlockingApi
 */
@MicronautTest
public class BlockingApiTest {

    @Inject
    BlockingApi api;

    
    /**
     * Creates a new email deny rule.
     *
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     */
    @Test
    @Disabled("Not Implemented")
    public void addRuleTest() {
        // given
        String type = "example";
        String data = "example";
        String user = "example";

        // when
        GenericResponse body = api.addRule(type, data, user).block();

        // then
        // TODO implement the addRuleTest()
    }

    
    /**
     * Removes an deny mail rule.
     *
     * Removes one of the configured deny mail rules from the system.
     */
    @Test
    @Disabled("Not Implemented")
    public void deleteRuleTest() {
        // given
        Integer ruleId = 34;

        // when
        GenericResponse body = api.deleteRule(ruleId).block();

        // then
        // TODO implement the deleteRuleTest()
    }

    
    /**
     * Removes an email address from the blocked list
     *
     * Removes an email address from the various block lists. 
     */
    @Test
    @Disabled("Not Implemented")
    public void delistBlockTest() {
        // given
        EmailAddress emailAddress = new EmailAddress();

        // when
        GenericResponse body = api.delistBlock(emailAddress).block();

        // then
        // TODO implement the delistBlockTest()
    }

    
    /**
     * displays a list of blocked email addresses
     */
    @Test
    @Disabled("Not Implemented")
    public void getMailBlocksTest() {
        // given

        // when
        MailBlocks body = api.getMailBlocks().block();

        // then
        // TODO implement the getMailBlocksTest()
    }

    
    /**
     * Displays a listing of deny email rules.
     *
     * Returns a listing of all the deny block rules you have configured.
     */
    @Test
    @Disabled("Not Implemented")
    public void getRulesTest() {
        // given

        // when
        List<DenyRuleRecord> body = api.getRules().block();

        // then
        // TODO implement the getRulesTest()
    }

    
}
