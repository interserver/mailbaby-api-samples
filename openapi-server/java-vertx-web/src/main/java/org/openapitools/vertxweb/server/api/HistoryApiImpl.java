package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.DateOrTimestamp;
import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.MailLog;
import org.openapitools.vertxweb.server.model.MailStatsType;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.handler.HttpException;

import java.util.List;
import java.util.Map;

// Implement this class

public class HistoryApiImpl implements HistoryApi {
    public Future<ApiResponse<MailStatsType>> getStats(String time) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<MailLog>> viewMailLog(Long id, String origin, String mx, String from, String to, String subject, String mailid, String messageId, String replyto, String headerfrom, Integer delivered, Integer skip, Integer limit, DateOrTimestamp startDate, DateOrTimestamp endDate, String sort, String dir, String groupby) {
        return Future.failedFuture(new HttpException(501));
    }

}
