package org.openapitools.server.api;

import org.openapitools.server.model.ErrorMessage;
import java.util.HexFormat;
import org.openapitools.server.model.MailLog;
import org.openapitools.server.model.MailStatsType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import io.helidon.http.Status;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.helidon.webserver.http.HttpService;

@io.helidon.common.Generated(value = "org.openapitools.codegen.languages.JavaHelidonServerCodegen",
                             trigger = "tag = 'History'",
                             version = "7.26.0")
public interface HistoryService extends HttpService {

    /**
     * A service registers itself by updating the routing rules.
     * @param rules the routing rules.
     */
    @Override
    default void routing(HttpRules rules) {
        rules.get("/stats", this::getStats);
        rules.get("/log", this::viewMailLog);
    }


    /**
     * GET /mail/stats : Account usage, cost, and volume statistics for a time window.
     *
     * @param request the server request
     * @param response the server response
     */
    void getStats(ServerRequest request, ServerResponse response);
    /**
     * GET /mail/log : Query the mail delivery log (filterable, paginated).
     *
     * @param request the server request
     * @param response the server response
     */
    void viewMailLog(ServerRequest request, ServerResponse response);
}
