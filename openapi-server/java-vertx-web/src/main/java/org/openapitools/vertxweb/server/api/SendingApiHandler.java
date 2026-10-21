package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.EmailAddressTypes;
import org.openapitools.vertxweb.server.model.EmailAddressesTypes;
import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.GenericResponse;
import org.openapitools.vertxweb.server.model.MailAttachment;
import org.openapitools.vertxweb.server.model.SendMailRaw;
import org.openapitools.vertxweb.server.model.SendMailTo;

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

public class SendingApiHandler {

    private static final Logger logger = LoggerFactory.getLogger(SendingApiHandler.class);

    private final SendingApi api;

    public SendingApiHandler(SendingApi api) {
        this.api = api;
    }

    @Deprecated
    public SendingApiHandler() {
        this(new SendingApiImpl());
    }

    public void mount(RouterBuilder builder) {
        builder.operation("rawMail").handler(this::rawMail);
        builder.operation("sendAdvMail").handler(this::sendAdvMail);
        builder.operation("sendMail").handler(this::sendMail);
    }

    private void rawMail(RoutingContext routingContext) {
        logger.info("rawMail()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        RequestParameter body = requestParameters.body();
        SendMailRaw sendMailRaw = body != null ? DatabindCodec.mapper().convertValue(body.get(), new TypeReference<SendMailRaw>(){}) : null;

        logger.debug("Parameter sendMailRaw is (body omitted)");

        api.rawMail(sendMailRaw)
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

    private void sendAdvMail(RoutingContext routingContext) {
        logger.info("sendAdvMail()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        RequestParameter body = requestParameters.body();
        JsonObject formBody = body != null ? body.getJsonObject() : null;

        logger.debug("Parameter formBody is {}", formBody);

        api.sendAdvMail(formBody)
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

    private void sendMail(RoutingContext routingContext) {
        logger.info("sendMail()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        RequestParameter body = requestParameters.body();
        JsonObject formBody = body != null ? body.getJsonObject() : null;

        logger.debug("Parameter formBody is {}", formBody);

        api.sendMail(formBody)
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
