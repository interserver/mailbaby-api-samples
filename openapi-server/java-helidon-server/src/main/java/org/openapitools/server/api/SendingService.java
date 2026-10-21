package org.openapitools.server.api;

import java.util.stream.Collectors;
import org.openapitools.server.model.EmailAddressTypes;
import org.openapitools.server.model.EmailAddressesTypes;
import org.openapitools.server.model.ErrorMessage;
import org.openapitools.server.model.GenericResponse;
import java.util.HexFormat;
import org.openapitools.server.model.MailAttachment;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import io.helidon.common.parameters.Parameters;
import io.helidon.http.media.multipart.ReadablePart;
import org.openapitools.server.model.SendMailRaw;
import org.openapitools.server.model.SendMailTo;
import io.helidon.http.Status;
import jakarta.validation.Valid;
import io.helidon.common.mapper.Value;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.helidon.webserver.http.HttpService;

@io.helidon.common.Generated(value = "org.openapitools.codegen.languages.JavaHelidonServerCodegen",
                             trigger = "tag = 'Sending'",
                             version = "7.26.0")
public interface SendingService extends HttpService {

    /**
     * A service registers itself by updating the routing rules.
     * @param rules the routing rules.
     */
    @Override
    default void routing(HttpRules rules) {
        rules.post("/rawsend", this::rawMail);
        rules.post("/advsend", this::sendAdvMail);
        rules.post("/send", this::sendMail);
    }


    /**
     * POST /mail/rawsend : Send a pre-built RFC 822 message verbatim (preserves DKIM).
     *
     * @param request the server request
     * @param response the server response
     */
    void rawMail(ServerRequest request, ServerResponse response);
    /**
     * POST /mail/advsend : Send email with multiple recipients, CC/BCC, attachments, named contacts.
     *
     * @param request the server request
     * @param response the server response
     */
    void sendAdvMail(ServerRequest request, ServerResponse response);
    /**
     * POST /mail/send : Send a simple email (single recipient, plain or HTML).
     *
     * @param request the server request
     * @param response the server response
     */
    void sendMail(ServerRequest request, ServerResponse response);
}
