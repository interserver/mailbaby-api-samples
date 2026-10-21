package org.openapitools.server.api;

import org.openapitools.server.model.DenyRuleRecord;
import org.openapitools.server.model.EmailAddressParam;
import org.openapitools.server.model.ErrorMessage;
import org.openapitools.server.model.GenericResponse;
import java.util.HexFormat;
import java.util.List;
import org.openapitools.server.model.MailBlocks;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import io.helidon.common.parameters.Parameters;
import io.helidon.http.media.multipart.ReadablePart;
import io.helidon.http.Status;
import io.helidon.common.mapper.Value;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.helidon.webserver.http.HttpService;

@io.helidon.common.Generated(value = "org.openapitools.codegen.languages.JavaHelidonServerCodegen",
                             trigger = "tag = 'Blocking'",
                             version = "7.26.0")
public interface BlockingService extends HttpService {

    /**
     * A service registers itself by updating the routing rules.
     * @param rules the routing rules.
     */
    @Override
    default void routing(HttpRules rules) {
        rules.post("/rules", this::addRule);
        rules.delete("/rules/{ruleId}", this::deleteRule);
        rules.post("/blocks/delete", this::delistBlock);
        rules.get("/blocks", this::getMailBlocks);
        rules.get("/rules", this::getRules);
    }


    /**
     * POST /mail/rules : Create a deny rule to block a sender, domain, destination, or prefix.
     *
     * @param request the server request
     * @param response the server response
     */
    void addRule(ServerRequest request, ServerResponse response);
    /**
     * DELETE /mail/rules/{ruleId} : Delete a deny rule by its numeric ruleId.
     *
     * @param request the server request
     * @param response the server response
     */
    void deleteRule(ServerRequest request, ServerResponse response);
    /**
     * POST /mail/blocks/delete : Delist an email address from the spam-filter block lists.
     *
     * @param request the server request
     * @param response the server response
     */
    void delistBlock(ServerRequest request, ServerResponse response);
    /**
     * GET /mail/blocks : List addresses currently flagged by spam-filter block lists.
     *
     * @param request the server request
     * @param response the server response
     */
    void getMailBlocks(ServerRequest request, ServerResponse response);
    /**
     * GET /mail/rules : List custom deny rules (sender / domain / destination / prefix).
     *
     * @param request the server request
     * @param response the server response
     */
    void getRules(ServerRequest request, ServerResponse response);
}
