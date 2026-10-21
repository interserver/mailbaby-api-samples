package controllers;

import apimodels.DenyRuleRecord;
import apimodels.EmailAddressParam;
import apimodels.ErrorMessage;
import apimodels.GenericResponse;
import apimodels.MailBlocks;

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
public class BlockingApiController extends Controller {
    private final BlockingApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Config configuration;

    @Inject
    private BlockingApiController(Config configuration, BlockingApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }

    @ApiAction
    public Result addRule(Http.Request request) throws Exception {
        String[] valueuser = request.body().asMultipartFormData().asFormUrlEncoded().get("user");
        String user;
        if (valueuser != null) {
            user = valueuser[0];
        } else {
            user = null;
        }
        String[] valuetype = request.body().asMultipartFormData().asFormUrlEncoded().get("type");
        String type;
        if (valuetype != null) {
            type = valuetype[0];
        } else {
            throw new IllegalArgumentException("'type' parameter is required");
        }
        String[] valuedata = request.body().asMultipartFormData().asFormUrlEncoded().get("data");
        String data;
        if (valuedata != null) {
            data = valuedata[0];
        } else {
            throw new IllegalArgumentException("'data' parameter is required");
        }
        return imp.addRuleHttp(request, type, data, user);
    }

    @ApiAction
    public Result deleteRule(Http.Request request, Integer ruleId) throws Exception {
        return imp.deleteRuleHttp(request, ruleId);
    }

    @ApiAction
    public Result delistBlock(Http.Request request) throws Exception {
        JsonNode nodeemailAddressParam = request.body().asJson();
        EmailAddressParam emailAddressParam;
        if (nodeemailAddressParam != null) {
            emailAddressParam = mapper.readValue(nodeemailAddressParam.toString(), EmailAddressParam.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                OpenAPIUtils.validate(emailAddressParam);
            }
        } else {
            throw new IllegalArgumentException("'EmailAddressParam' parameter is required");
        }
        return imp.delistBlockHttp(request, emailAddressParam);
    }

    @ApiAction
    public Result getMailBlocks(Http.Request request) throws Exception {
        return imp.getMailBlocksHttp(request);
    }

    @ApiAction
    public Result getRules(Http.Request request) throws Exception {
        return imp.getRulesHttp(request);
    }

}
