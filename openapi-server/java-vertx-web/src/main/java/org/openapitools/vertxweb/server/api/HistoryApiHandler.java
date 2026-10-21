package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.MailLog;
import org.openapitools.vertxweb.server.model.MailStatsType;

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

public class HistoryApiHandler {

    private static final Logger logger = LoggerFactory.getLogger(HistoryApiHandler.class);

    private final HistoryApi api;

    public HistoryApiHandler(HistoryApi api) {
        this.api = api;
    }

    @Deprecated
    public HistoryApiHandler() {
        this(new HistoryApiImpl());
    }

    public void mount(RouterBuilder builder) {
        builder.operation("getStats").handler(this::getStats);
        builder.operation("viewMailLog").handler(this::viewMailLog);
    }

    private void getStats(RoutingContext routingContext) {
        logger.info("getStats()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        String time = requestParameters.queryParameter("time") != null ? requestParameters.queryParameter("time").getString() : "1h";

        logger.debug("Parameter time is {}", time);

        api.getStats(time)
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

    private void viewMailLog(RoutingContext routingContext) {
        logger.info("viewMailLog()");

        // Param extraction
        RequestParameters requestParameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);

        Long id = requestParameters.queryParameter("id") != null ? requestParameters.queryParameter("id").getLong() : null;
        String origin = requestParameters.queryParameter("origin") != null ? requestParameters.queryParameter("origin").getString() : null;
        String mx = requestParameters.queryParameter("mx") != null ? requestParameters.queryParameter("mx").getString() : null;
        String from = requestParameters.queryParameter("from") != null ? requestParameters.queryParameter("from").getString() : null;
        String to = requestParameters.queryParameter("to") != null ? requestParameters.queryParameter("to").getString() : null;
        String subject = requestParameters.queryParameter("subject") != null ? requestParameters.queryParameter("subject").getString() : null;
        String mailid = requestParameters.queryParameter("mailid") != null ? requestParameters.queryParameter("mailid").getString() : null;
        String messageId = requestParameters.queryParameter("messageId") != null ? requestParameters.queryParameter("messageId").getString() : null;
        String replyto = requestParameters.queryParameter("replyto") != null ? requestParameters.queryParameter("replyto").getString() : null;
        String headerfrom = requestParameters.queryParameter("headerfrom") != null ? requestParameters.queryParameter("headerfrom").getString() : null;
        Integer delivered = requestParameters.queryParameter("delivered") != null ? requestParameters.queryParameter("delivered").getInteger() : null;
        Integer skip = requestParameters.queryParameter("skip") != null ? requestParameters.queryParameter("skip").getInteger() : 0;
        Integer limit = requestParameters.queryParameter("limit") != null ? requestParameters.queryParameter("limit").getInteger() : 100;
        String startDate = requestParameters.queryParameter("startDate") != null ? requestParameters.queryParameter("startDate").getString() : null;
        String endDate = requestParameters.queryParameter("endDate") != null ? requestParameters.queryParameter("endDate").getString() : null;
        String sort = requestParameters.queryParameter("sort") != null ? requestParameters.queryParameter("sort").getString() : "time";
        String dir = requestParameters.queryParameter("dir") != null ? requestParameters.queryParameter("dir").getString() : "desc";
        String groupby = requestParameters.queryParameter("groupby") != null ? requestParameters.queryParameter("groupby").getString() : "recipient";

        logger.debug("Parameter id is {}", id);
        logger.debug("Parameter origin is {}", origin);
        logger.debug("Parameter mx is {}", mx);
        logger.debug("Parameter from is {}", from);
        logger.debug("Parameter to is {}", to);
        logger.debug("Parameter subject is {}", subject);
        logger.debug("Parameter mailid is {}", mailid);
        logger.debug("Parameter messageId is {}", messageId);
        logger.debug("Parameter replyto is {}", replyto);
        logger.debug("Parameter headerfrom is {}", headerfrom);
        logger.debug("Parameter delivered is {}", delivered);
        logger.debug("Parameter skip is {}", skip);
        logger.debug("Parameter limit is {}", limit);
        logger.debug("Parameter startDate is {}", startDate);
        logger.debug("Parameter endDate is {}", endDate);
        logger.debug("Parameter sort is {}", sort);
        logger.debug("Parameter dir is {}", dir);
        logger.debug("Parameter groupby is {}", groupby);

        api.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby)
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
