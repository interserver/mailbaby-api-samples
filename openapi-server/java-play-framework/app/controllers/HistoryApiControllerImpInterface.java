package controllers;

import apimodels.DateOrTimestamp;
import apimodels.ErrorMessage;
import apimodels.MailLog;
import apimodels.MailStatsType;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import play.mvc.Controller;
import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import play.mvc.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import openapitools.OpenAPIUtils;
import openapitools.SecurityAPIUtils;
import static play.mvc.Results.ok;
import static play.mvc.Results.unauthorized;
import play.libs.Files.TemporaryFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

@SuppressWarnings("RedundantThrows")
public abstract class HistoryApiControllerImpInterface {
    @Inject private Config configuration;
    @Inject private SecurityAPIUtils securityAPIUtils;
    private ObjectMapper mapper = new ObjectMapper();

    public Result getStatsHttp(Http.Request request, String time) throws Exception {
        MailStatsType obj = getStats(request, time);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract MailStatsType getStats(Http.Request request, String time) throws Exception;

    public Result viewMailLogHttp(Http.Request request, Long id, String origin, String mx, String from, String to, String subject,  @Size(min=18,max=19)String mailid, String messageId, String replyto, String headerfrom, Integer delivered,  @Min(0)Integer skip,  @Min(1) @Max(10000)Integer limit, DateOrTimestamp startDate, DateOrTimestamp endDate, String sort, String dir, String groupby) throws Exception {
        MailLog obj = viewMailLog(request, id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract MailLog viewMailLog(Http.Request request, Long id, String origin, String mx, String from, String to, String subject,  @Size(min=18,max=19)String mailid, String messageId, String replyto, String headerfrom, Integer delivered,  @Min(0)Integer skip,  @Min(1) @Max(10000)Integer limit, DateOrTimestamp startDate, DateOrTimestamp endDate, String sort, String dir, String groupby) throws Exception;

}
