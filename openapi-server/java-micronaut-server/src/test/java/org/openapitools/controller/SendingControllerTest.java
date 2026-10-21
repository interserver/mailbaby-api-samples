package org.openapitools.controller;

import org.openapitools.model.EmailAddressTypes;
import org.openapitools.model.EmailAddressesTypes;
import org.openapitools.model.ErrorMessage;
import org.openapitools.model.GenericResponse;
import org.openapitools.model.MailAttachment;
import org.openapitools.model.SendMailRaw;
import org.openapitools.model.SendMailTo;
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
 * API tests for SendingController
 */
@MicronautTest
public class SendingControllerTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client
    HttpClient client;

    @Inject
    SendingController controller;

    /**
     * This test is used to validate the implementation of rawMail() method
     *
     * The method should: Send a pre-built RFC 822 message verbatim (preserves DKIM)
     *
     * **Use this when you have already built (and possibly DKIM-signed) the full RFC 822 message yourself** and want the relay to transmit it byte-for-byte. Required: &#x60;raw_email&#x60; (full RFC 822 string with headers + body). Optional: &#x60;id&#x60; (mail order to authenticate as). Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact. If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The &#x60;From&#x60; and recipient addresses are parsed automatically from the message headers (&#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, &#x60;Bcc&#x60;).  You do **not** need to specify them separately.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void rawMailMethodTest() {
        // given
        SendMailRaw sendMailRaw = new SendMailRaw("example");

        // when
        GenericResponse result = controller.rawMail(sendMailRaw).block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/rawsend' to the features of rawMail() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void rawMailClientApiTest() throws IOException {
        // given
        SendMailRaw body = new SendMailRaw("example");
        String uri = UriTemplate.of("/mail/rawsend").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.POST(uri, body)
            .accept("[Ljava.lang.String;@b4732dc");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, GenericResponse.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of sendAdvMail() method
     *
     * The method should: Send email with multiple recipients, CC/BCC, attachments, named contacts
     *
     * **Use this when the simple send is not enough** — multiple recipients, CC/BCC, named contacts, custom Reply-To, or file attachments. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;cc&#x60;, &#x60;bcc&#x60;, &#x60;replyto&#x60;, &#x60;attachments&#x60; (array of &#x60;{filename,data}&#x60; with base64 data), &#x60;id&#x60;. Sends through one of your mail orders with full control over recipients, headers, and attachments.  **Content-type flexibility** — the request body may be submitted as either &#x60;application/x-www-form-urlencoded&#x60; or &#x60;application/json&#x60;.  When using form encoding, address fields (&#x60;from&#x60;, &#x60;to&#x60;, &#x60;replyto&#x60;, &#x60;cc&#x60;, &#x60;bcc&#x60;) accept both a plain RFC 822 comma-separated string (e.g. &#x60;\&quot;Joe &lt;joe@example.com&gt;, jane@example.com\&quot;&#x60;) and the structured &#x60;[{\&quot;email\&quot;:\&quot;...\&quot;,\&quot;name\&quot;:\&quot;...\&quot;}]&#x60; array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if &#x60;body&#x60; contains HTML tags the &#x60;Content-Type&#x60; is set to &#x60;text/html&#x60;; otherwise &#x60;text/plain&#x60;.  **Attachments** must be base64-encoded.  Each attachment requires at least a &#x60;data&#x60; field; the optional &#x60;filename&#x60; field controls the attachment name shown to recipients.  If an &#x60;id&#x60; is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response &#x60;text&#x60; field contains the relay transaction ID which can be looked up in &#x60;GET /mail/log&#x60; via the &#x60;mailid&#x60; query parameter.  ## Examples  ### Form — basic string addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d to&#x3D;support@interserver.net &#x60;&#x60;&#x60; ### Form — RFC 822 named addresses &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; \\   -d &#39;body&#x3D;Hello&#39; \\   -d &#39;from&#x3D;Joe &lt;user@domain.com&gt;&#39; \\   -d &#39;to&#x3D;Jane &lt;support@interserver.net&gt;&#39; &#x60;&#x60;&#x60; ### Form — multiple recipients as array &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/x-www-form-urlencoded&#39; \\   -d &#39;subject&#x3D;Welcome&#39; -d &#39;body&#x3D;Hello&#39; \\   -d from&#x3D;user@domain.com \\   -d &#39;to[0][name]&#x3D;Joe&#39; -d &#39;to[0][email]&#x3D;support@interserver.net&#39; \\   -d &#39;to[1][name]&#x3D;Jane&#39; -d &#39;to[1][email]&#x3D;jane@interserver.net&#39; &#x60;&#x60;&#x60; ### JSON — structured objects &#x60;&#x60;&#x60;sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H &#39;X-API-KEY: YOUR_API_KEY&#39; \\   -H &#39;Content-Type: application/json&#39; \\   -d &#39;{     \&quot;subject\&quot;: \&quot;Welcome\&quot;,     \&quot;body\&quot;: \&quot;&lt;h1&gt;Hello&lt;/h1&gt;\&quot;,     \&quot;from\&quot;: {\&quot;email\&quot;: \&quot;user@domain.com\&quot;, \&quot;name\&quot;: \&quot;Sender Name\&quot;},     \&quot;to\&quot;: [{\&quot;email\&quot;: \&quot;joe@client.com\&quot;, \&quot;name\&quot;: \&quot;Joe Client\&quot;}],     \&quot;cc\&quot;: [{\&quot;email\&quot;: \&quot;manager@client.com\&quot;}],     \&quot;attachments\&quot;: [{\&quot;filename\&quot;: \&quot;report.pdf\&quot;, \&quot;data\&quot;: \&quot;BASE64_DATA\&quot;}]   }&#39; &#x60;&#x60;&#x60; 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void sendAdvMailMethodTest() {
        // given
        String subject = "example";
        String _body = "example";
        EmailAddressTypes from = new EmailAddressTypes();
        EmailAddressesTypes to = new EmailAddressesTypes();
        EmailAddressesTypes replyto = new EmailAddressesTypes();
        EmailAddressesTypes cc = new EmailAddressesTypes();
        EmailAddressesTypes bcc = new EmailAddressesTypes();
        List<@Valid MailAttachment> attachments = Arrays.asList();
        Long id = 56L;

        // when
        GenericResponse result = controller.sendAdvMail(subject, _body, from, to, replyto, cc, bcc, attachments, id).block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/advsend' to the features of sendAdvMail() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void sendAdvMailClientApiTest() throws IOException {
        // given
        Map<String, Object> form = new HashMap<String, Object>(){{
            // Fill in the body form parameters
            put("subject", "example");
            put("body", "example");
            put("from", new EmailAddressTypes());
            put("to", new EmailAddressesTypes());
            put("replyto", new EmailAddressesTypes());
            put("cc", new EmailAddressesTypes());
            put("bcc", new EmailAddressesTypes());
            put("attachments", Arrays.asList());
            put("id", 56L);
        }};
        String uri = UriTemplate.of("/mail/advsend").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.POST(uri, form)
            .accept("[Ljava.lang.String;@45292ec1");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, GenericResponse.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

    /**
     * This test is used to validate the implementation of sendMail() method
     *
     * The method should: Send a simple email (single recipient, plain or HTML)
     *
     * **Use this for the simplest case** — one or a few plain-string recipients, no attachments, no CC/BCC, no named contacts. Required: &#x60;from&#x60;, &#x60;to&#x60;, &#x60;subject&#x60;, &#x60;body&#x60;. Optional: &#x60;id&#x60; (selects which mail order to send through; auto-selects your first active order if omitted). Sends through one of your mail orders using a flat set of fields.  **HTML detection** is automatic — if the &#x60;body&#x60; value contains any HTML tags the message will be sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.  The &#x60;from&#x60; address is also automatically set as the &#x60;Reply-To&#x60; header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use &#x60;POST /mail/advsend&#x60; instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use &#x60;POST /mail/rawsend&#x60;.  On success the response &#x60;text&#x60; field contains the relay transaction ID.  This ID can be used with &#x60;GET /mail/log&#x60; (via the &#x60;mailid&#x60; query parameter) to look up the delivery record. 
     *
     * TODO fill in the parameters and test return value.
     */
    @Test
    @Disabled("Not Implemented")
    void sendMailMethodTest() {
        // given
        SendMailTo to = new SendMailTo();
        String from = "example";
        String subject = "example";
        String _body = "example";
        Long id = 56L;

        // when
        GenericResponse result = controller.sendMail(to, from, subject, _body, id).block();

        // then
        Assertions.assertTrue(true);
    }

    /**
     * This test is used to check that the api available to client through
     * '/mail/send' to the features of sendMail() works as desired.
     *
     * TODO fill in the request parameters and test response.
     */
    @Test
    @Disabled("Not Implemented")
    void sendMailClientApiTest() throws IOException {
        // given
        Map<String, Object> form = new HashMap<String, Object>(){{
            // Fill in the body form parameters
            put("to", new SendMailTo());
            put("from", "example");
            put("subject", "example");
            put("body", "example");
            put("id", 56L);
        }};
        String uri = UriTemplate.of("/mail/send").expand(new HashMap<>());
        MutableHttpRequest<?> request = HttpRequest.POST(uri, form)
            .accept("[Ljava.lang.String;@28babeca");

        // when
        HttpResponse<?> response = client.toBlocking().exchange(request, GenericResponse.class);

        // then
        Assertions.assertEquals(HttpStatus.OK, response.status());
    }

}
