package org.openapitools.server.api;

import org.openapitools.server.model.ErrorMessage;
import java.util.HexFormat;
import java.util.List;
import org.openapitools.server.model.MailOrder;
import org.openapitools.server.model.MailOrderDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.http.Status;

import io.helidon.webserver.http.HttpRules;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import io.helidon.webserver.http.HttpService;

@io.helidon.common.Generated(value = "org.openapitools.codegen.languages.JavaHelidonServerCodegen",
                             trigger = "tag = 'Services'",
                             version = "7.26.0")
public interface ServicesService extends HttpService {

    /**
     * A service registers itself by updating the routing rules.
     * @param rules the routing rules.
     */
    @Override
    default void routing(HttpRules rules) {
        rules.get("/{id}", this::getMailOrderById);
        rules.get("/", this::getMailOrders);
    }


    /**
     * GET /mail/{id} : Get one mail order&#39;s full detail including SMTP password.
     *
     * @param request the server request
     * @param response the server response
     */
    void getMailOrderById(ServerRequest request, ServerResponse response);
    /**
     * GET /mail : List your provisioned mail orders (sending accounts).
     *
     * @param request the server request
     * @param response the server response
     */
    void getMailOrders(ServerRequest request, ServerResponse response);
}
