package controllers;

import apimodels.ErrorMessage;
import apimodels.MailLog;
import apimodels.MailStatsType;

import com.typesafe.config.Config;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import java.io.File;
import play.libs.Files.TemporaryFile;
import openapitools.OpenAPIUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.validation.constraints.*;
import javax.validation.Valid;
import com.typesafe.config.Config;

import openapitools.OpenAPIUtils.ApiAction;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
public class HistoryApiController extends Controller {
    private final HistoryApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Config configuration;

    @Inject
    private HistoryApiController(Config configuration, HistoryApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }

    @ApiAction
    public Result getStats(Http.Request request) throws Exception {
        String valuetime = request.getQueryString("time");
        String time;
        if (valuetime != null) {
            time = valuetime;
        } else {
            time = "1h";
        }
        return imp.getStatsHttp(request, time);
    }

    @ApiAction
    public Result viewMailLog(Http.Request request) throws Exception {
        String valueid = request.getQueryString("id");
        Long id;
        if (valueid != null) {
            id = Long.parseLong(valueid);
        } else {
            id = null;
        }
        String valueorigin = request.getQueryString("origin");
        String origin;
        if (valueorigin != null) {
            origin = valueorigin;
        } else {
            origin = null;
        }
        String valuemx = request.getQueryString("mx");
        String mx;
        if (valuemx != null) {
            mx = valuemx;
        } else {
            mx = null;
        }
        String valuefrom = request.getQueryString("from");
        String from;
        if (valuefrom != null) {
            from = valuefrom;
        } else {
            from = null;
        }
        String valueto = request.getQueryString("to");
        String to;
        if (valueto != null) {
            to = valueto;
        } else {
            to = null;
        }
        String valuesubject = request.getQueryString("subject");
        String subject;
        if (valuesubject != null) {
            subject = valuesubject;
        } else {
            subject = null;
        }
        String valuemailid = request.getQueryString("mailid");
        String mailid;
        if (valuemailid != null) {
            mailid = valuemailid;
        } else {
            mailid = null;
        }
        String valuemessageId = request.getQueryString("messageId");
        String messageId;
        if (valuemessageId != null) {
            messageId = valuemessageId;
        } else {
            messageId = null;
        }
        String valuereplyto = request.getQueryString("replyto");
        String replyto;
        if (valuereplyto != null) {
            replyto = valuereplyto;
        } else {
            replyto = null;
        }
        String valueheaderfrom = request.getQueryString("headerfrom");
        String headerfrom;
        if (valueheaderfrom != null) {
            headerfrom = valueheaderfrom;
        } else {
            headerfrom = null;
        }
        String valuedelivered = request.getQueryString("delivered");
        Integer delivered;
        if (valuedelivered != null) {
            delivered = Integer.parseInt(valuedelivered);
        } else {
            delivered = null;
        }
        String valueskip = request.getQueryString("skip");
        Integer skip;
        if (valueskip != null) {
            skip = Integer.parseInt(valueskip);
        } else {
            skip = 0;
        }
        String valuelimit = request.getQueryString("limit");
        Integer limit;
        if (valuelimit != null) {
            limit = Integer.parseInt(valuelimit);
        } else {
            limit = 100;
        }
        String valuestartDate = request.getQueryString("startDate");
        String startDate;
        if (valuestartDate != null) {
            startDate = valuestartDate;
        } else {
            startDate = null;
        }
        String valueendDate = request.getQueryString("endDate");
        String endDate;
        if (valueendDate != null) {
            endDate = valueendDate;
        } else {
            endDate = null;
        }
        String valuesort = request.getQueryString("sort");
        String sort;
        if (valuesort != null) {
            sort = valuesort;
        } else {
            sort = "time";
        }
        String valuedir = request.getQueryString("dir");
        String dir;
        if (valuedir != null) {
            dir = valuedir;
        } else {
            dir = "desc";
        }
        String valuegroupby = request.getQueryString("groupby");
        String groupby;
        if (valuegroupby != null) {
            groupby = valuegroupby;
        } else {
            groupby = "recipient";
        }
        return imp.viewMailLogHttp(request, id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby);
    }

}
