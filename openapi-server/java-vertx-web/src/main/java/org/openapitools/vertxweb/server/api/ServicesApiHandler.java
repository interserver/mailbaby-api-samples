package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.MailOrder;
import org.openapitools.vertxweb.server.model.MailOrderDetail;

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

public class ServicesApiHandler {

    private static final Logger logger = LoggerFactory.getLogger(ServicesApiHandler.class);

    private final ServicesApi api;

    public ServicesApiHandler(ServicesApi api) {
        this.api = api;
    }

    @Deprecated
    public ServicesApiHandler() {
        this(new ServicesApiImpl());
    }

    public void mount(RouterBuilder builder) {
        builder.operation("getMailOrderById").handler(this::getMailOrderById);
        builder.operation("getMailOrders").handler(this::getMailOrders);
    }

    private void getMailOrderById(RoutingContext routingContext) {
        logger.info("getMailOrderById()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        Long id = requestParameters.pathParameter("id") != null ? requestParameters.pathParameter("id").getLong() : null;

        logger.debug("Parameter id is {}", id);

        api.getMailOrderById(id)
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

    private void getMailOrders(RoutingContext routingContext) {
        logger.info("getMailOrders()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);



        api.getMailOrders()
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
