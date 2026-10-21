package org.openapitools.vertxweb.server.api;


import com.fasterxml.jackson.core.type.TypeReference;
import io.vertx.core.json.jackson.DatabindCodec;
import io.vertx.ext.web.openapi.RouterBuilder;
import io.vertx.ext.web.validation.RequestParameters;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.validation.ValidationHandler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class StatusApiHandler {

    private static final Logger logger = LoggerFactory.getLogger(StatusApiHandler.class);

    private final StatusApi api;

    public StatusApiHandler(StatusApi api) {
        this.api = api;
    }

    @Deprecated
    public StatusApiHandler() {
        this(new StatusApiImpl());
    }

    public void mount(RouterBuilder builder) {
        builder.operation("pingServer").handler(this::pingServer);
    }

    private void pingServer(RoutingContext routingContext) {
        logger.info("pingServer()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);



        api.pingServer()
            .onSuccess(apiResponse -> {
                routingContext.response().setStatusCode(apiResponse.getStatusCode());
                if (apiResponse.hasData()) {
                    routingContext.json(apiResponse.getData());
                } else {
                    routingContext.response().end();
                }
            })
            .onFailure(routingContext::fail);
    }

}
