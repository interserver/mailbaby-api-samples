package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.DenyRuleRecord;
import org.openapitools.vertxweb.server.model.EmailAddressParam;
import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.GenericResponse;
import org.openapitools.vertxweb.server.model.MailBlocks;

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

public class BlockingApiHandler {

    private static final Logger logger = LoggerFactory.getLogger(BlockingApiHandler.class);

    private final BlockingApi api;

    public BlockingApiHandler(BlockingApi api) {
        this.api = api;
    }

    @Deprecated
    public BlockingApiHandler() {
        this(new BlockingApiImpl());
    }

    public void mount(RouterBuilder builder) {
        builder.operation("addRule").handler(this::addRule);
        builder.operation("deleteRule").handler(this::deleteRule);
        builder.operation("delistBlock").handler(this::delistBlock);
        builder.operation("getMailBlocks").handler(this::getMailBlocks);
        builder.operation("getRules").handler(this::getRules);
    }

    private void addRule(RoutingContext routingContext) {
        logger.info("addRule()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        RequestParameter body = requestParameters.body();
        JsonObject formBody = body != null ? body.getJsonObject() : null;

        logger.debug("Parameter formBody is {}", formBody);

        api.addRule(formBody)
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

    private void deleteRule(RoutingContext routingContext) {
        logger.info("deleteRule()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        Integer ruleId = requestParameters.pathParameter("ruleId") != null ? requestParameters.pathParameter("ruleId").getInteger() : null;

        logger.debug("Parameter ruleId is {}", ruleId);

        api.deleteRule(ruleId)
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

    private void delistBlock(RoutingContext routingContext) {
        logger.info("delistBlock()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        RequestParameter body = requestParameters.body();
        EmailAddressParam emailAddressParam = body != null ? DatabindCodec.mapper().convertValue(body.get(), new TypeReference<EmailAddressParam>(){}) : null;

        logger.debug("Parameter emailAddressParam is (body omitted)");

        api.delistBlock(emailAddressParam)
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

    private void getMailBlocks(RoutingContext routingContext) {
        logger.info("getMailBlocks()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);



        api.getMailBlocks()
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

    private void getRules(RoutingContext routingContext) {
        logger.info("getRules()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);



        api.getRules()
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
