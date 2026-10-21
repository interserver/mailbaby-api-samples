package org.openapitools.controller;

import org.openapitools.model.DenyRuleRecord;
import org.openapitools.model.EmailAddressParam;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailBlocks;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.uri.UriTemplate;
import io.micronaut.http.cookie.Cookie;
import io.micronaut.http.client.multipart.MultipartBody;
import io.micronaut.core.type.Argument;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Assertions;
import jakarta.inject.Inject;
import reactor.core.publisher.Mono;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;


/**
 * API tests for BlockingController
 */
@MicronautTest
public class BlockingControllerTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client
    HttpClient client;

    @Inject
    BlockingController controller;

    /**
     * This test is used to validate the implementation of addRule() method
     *
     * The method should: Create a deny rule to block a sender, domain, destination, or prefix
     *
     * **Use this to prevent future relay attempts that match a pattern.** Required: &#x60;type&#x60; (&#x60;email&#x60;, &#x60;domain&#x60;, &#x60;destination&#x60;, or &#x60;startswith&#x60;) and &#x60;data&#x60; (the value to match). Optional: &#x60;user&#x60; (SMTP username; auto-selects first active order if omitted). Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The &#x60;type&#x60; field selects the matching strategy: - **&#x60;email&#x60;** — exact match against the SMTP envelope &#x60;MAIL FROM&#x60; address. - **&#x60;domain&#x60;** — matches any sender address at the specified domain. - **&#x60;destination&#x60;** — exact match against the SMTP envelope &#x60;RCPT TO&#x60; address. - **&#x60;startswith&#x60;** — matches any sender address whose local-part (the portion   before the &#x60;@&#x60;) starts with the given string.  Only alphanumeric characters   and &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; are permitted in the prefix.   If &#x60;username&#x60; is provided it must be the SMTP username of one of your active mail orders (e.g. &#x60;mb20682&#x60;).  If omitted the rule is associated with your first active order.  On success the response &#x60;text&#x60; field contains the newly created rule&#39;s &#x60;id&#x60;, which can later be passed to &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove it. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void addRuleMethodTest() {
        // given
        String type = "example";
        String data = "example";
        String user = "example";

        // when
        GenericResponse result = controller.addRule(type, data, user).block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/rules' to the features of addRule() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void addRuleClientApiTest() throws IOException {
        // given
        Map<String, Object> form = new HashMap<String, Object>(){{
            // Fill in the body form parameters
            put("user", "example");
            put("type", "example");
            put("data", "example");
        }};
        String uri = UriTemplate.of("/mail/rules").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.POST(uri, form)
            .accept("[Ljava.lang.String;@552cede7");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, GenericResponse.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of deleteRule() method
     *
     * The method should: Delete a deny rule by its numeric ruleId
     *
     * **Destructive — permanently removes the rule.** Required: &#x60;ruleId&#x60; (path param; obtain from the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field returned by &#x60;POST /mail/rules&#x60;). Permanently removes a single deny rule identified by its numeric &#x60;ruleId&#x60;.  The &#x60;ruleId&#x60; is the &#x60;id&#x60; field returned by &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field from a successful &#x60;POST /mail/rules&#x60; response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void deleteRuleMethodTest() {
        // given
        Integer ruleId = 34;

        // when
        GenericResponse result = controller.deleteRule(ruleId).block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/rules/{ruleId}' to the features of deleteRule() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void deleteRuleClientApiTest() throws IOException {
        // given
        String uri = UriTemplate.of("/mail/rules/{ruleId}").expand(new HashMap<String, Object>(){{
            // Fill in the path variables
            put("ruleId", 34);
        }});
        MutableHttpRequest<?> request = HttpRequest.DELETE(uri)
            .accept("[Ljava.lang.String;@1b7f06c7");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, GenericResponse.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of delistBlock() method
     *
     * The method should: Delist an email address from the spam-filter block lists
     *
     * **Destructive — wipes block records for the given address.** Required: &#x60;email&#x60; (must be a valid address; typically a &#x60;from&#x60; value previously returned by &#x60;GET /mail/blocks&#x60; or &#x60;GET /mail/log&#x60;). Delists an email address from all three block list stores: 1. The rspamd spam-filter database (&#x60;fromemail&#x60; / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use &#x60;GET /mail/blocks&#x60; to discover which addresses are currently blocked.  The &#x60;from&#x60; field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void delistBlockMethodTest() {
        // given
        EmailAddressParam emailAddressParam = new EmailAddressParam("user@domain.com");

        // when
        GenericResponse result = controller.delistBlock(emailAddressParam).block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/blocks/delete' to the features of delistBlock() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void delistBlockClientApiTest() throws IOException {
        // given
        EmailAddressParam body = new EmailAddressParam("user@domain.com");
        String uri = UriTemplate.of("/mail/blocks/delete").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.POST(uri, body)
            .accept("[Ljava.lang.String;@151732fb");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, GenericResponse.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of getMailBlocks() method
     *
     * The method should: List addresses currently flagged by spam-filter block lists
     *
     * **Use this to discover which addresses to delist.** The &#x60;from&#x60; value of any returned entry can be passed to &#x60;POST /mail/blocks/delete&#x60; (as the &#x60;email&#x60; field) to remove the block. Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s). Three categories are returned:  - **&#x60;local&#x60;** — messages flagged by the &#x60;LOCAL_BL_RCPT&#x60; rspamd rule.  These are   messages sent to recipients on your account&#39;s local block list. - **&#x60;mbtrap&#x60;** — messages flagged by the &#x60;MBTRAP&#x60; rspamd rule.  These are messages   that triggered MailBaby&#39;s internal trap / honeypot detection. - **&#x60;subject&#x60;** — senders whose recent messages contain spam-indicative subjects   (strings containing &#x60;@&#x60;, &#x60;smtp&#x60;, &#x60;socks4&#x60;, or &#x60;socks5&#x60;) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The &#x60;local&#x60; and &#x60;mbtrap&#x60; results cover the last 5 days.  The &#x60;subject&#x60; results cover the last 3 days.  A sender address returned in any of these lists can be delisted using &#x60;POST /mail/blocks/delete&#x60; with the &#x60;email&#x60; field set to that address. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void getMailBlocksMethodTest() {
        // given

        // when
        MailBlocks result = controller.getMailBlocks().block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/blocks' to the features of getMailBlocks() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void getMailBlocksClientApiTest() throws IOException {
        // given
        String uri = UriTemplate.of("/mail/blocks").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.GET(uri)
            .accept("[Ljava.lang.String;@729c8063");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, MailBlocks.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of getRules() method
     *
     * The method should: List custom deny rules (sender / domain / destination / prefix)
     *
     * **Use this to inspect or pick a &#x60;ruleId&#x60; to delete.** Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | &#x60;type&#x60; | &#x60;data&#x60; format | Effect | |--------|---------------|--------| | &#x60;email&#x60; | &#x60;user@domain.com&#x60; | Rejects any message from this exact sender address | | &#x60;domain&#x60; | &#x60;domain.com&#x60; | Rejects any message from any address at this domain | | &#x60;destination&#x60; | &#x60;user@domain.com&#x60; | Rejects any message addressed to this recipient | | &#x60;startswith&#x60; | &#x60;prefix&#x60; | Rejects any message whose sender address begins with this string (alphanumeric, &#x60;+&#x60;, &#x60;_&#x60;, &#x60;.&#x60;, &#x60;-&#x60; only) |  Use &#x60;POST /mail/rules&#x60; to add new rules and &#x60;DELETE /mail/rules/{ruleId}&#x60; to remove them.  The &#x60;id&#x60; field in each returned record is the value needed for the delete call. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void getRulesMethodTest() {
        // given

        // when
        List<DenyRuleRecord> result = controller.getRules().block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/rules' to the features of getRules() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void getRulesClientApiTest() throws IOException {
        // given
        String uri = UriTemplate.of("/mail/rules").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.GET(uri)
            .accept("[Ljava.lang.String;@40ed1802");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, Argument.of(List.class, DenyRuleRecord.class));

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

}
