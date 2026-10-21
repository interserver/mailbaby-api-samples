package controllers;

import apimodels.DenyRuleRecord;
import apimodels.EmailAddressParam;
import apimodels.ErrorMessage;
import apimodels.GenericResponse;
import apimodels.MailBlocks;

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
public abstract class BlockingApiControllerImpInterface {
    @Inject private Config configuration;
    @Inject private SecurityAPIUtils securityAPIUtils;
    private ObjectMapper mapper = new ObjectMapper();

    public Result addRuleHttp(Http.Request request, String type, String data, String user) throws Exception {
        GenericResponse obj = addRule(request, type, data, user);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract GenericResponse addRule(Http.Request request, String type, String data, String user) throws Exception;

    public Result deleteRuleHttp(Http.Request request, Integer ruleId) throws Exception {
        GenericResponse obj = deleteRule(request, ruleId);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract GenericResponse deleteRule(Http.Request request, Integer ruleId) throws Exception;

    public Result delistBlockHttp(Http.Request request, EmailAddressParam emailAddressParam) throws Exception {
        GenericResponse obj = delistBlock(request, emailAddressParam);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract GenericResponse delistBlock(Http.Request request, EmailAddressParam emailAddressParam) throws Exception;

    public Result getMailBlocksHttp(Http.Request request) throws Exception {
        MailBlocks obj = getMailBlocks(request);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract MailBlocks getMailBlocks(Http.Request request) throws Exception;

    public Result getRulesHttp(Http.Request request) throws Exception {
        List<DenyRuleRecord> obj = getRules(request);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            for (DenyRuleRecord curItem : obj) {
                OpenAPIUtils.validate(curItem);
            }
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract List<DenyRuleRecord> getRules(Http.Request request) throws Exception;

}
