package controllers;

import apimodels.DateOrTimestamp;
import apimodels.ErrorMessage;
import apimodels.MailLog;
import apimodels.MailStatsType;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.io.FileInputStream;
import play.libs.Files.TemporaryFile;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", comments = "Generator version: 7.26.0")
public class HistoryApiControllerImp extends HistoryApiControllerImpInterface {
    @Override
    public MailStatsType getStats(Http.Request request, String time) throws Exception {
        //Do your magic!!!
        return new MailStatsType();
    }

    @Override
    public MailLog viewMailLog(Http.Request request, Long id, String origin, String mx, String from, String to, String subject,  @Size(min=18,max=19)String mailid, String messageId, String replyto, String headerfrom, Integer delivered,  @Min(0)Integer skip,  @Min(1) @Max(10000)Integer limit, DateOrTimestamp startDate, DateOrTimestamp endDate, String sort, String dir, String groupby) throws Exception {
        //Do your magic!!!
        return new MailLog();
    }

}
