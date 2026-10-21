package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.MailLog;
import org.openapitools.vertxweb.server.model.MailStatsType;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Map;

public interface HistoryApi  {
    Future<ApiResponse<MailStatsType>> getStats(String time);
    Future<ApiResponse<MailLog>> viewMailLog(Long id, String origin, String mx, String from, String to, String subject, String mailid, String messageId, String replyto, String headerfrom, Integer delivered, Integer skip, Integer limit, String startDate, String endDate, String sort, String dir, String groupby);
}
