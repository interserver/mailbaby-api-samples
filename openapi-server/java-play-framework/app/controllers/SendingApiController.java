package controllers;

import apimodels.EmailAddressTypes;
import apimodels.EmailAddressesTypes;
import apimodels.ErrorMessage;
import apimodels.GenericResponse;
import apimodels.MailAttachment;
import apimodels.SendMailRaw;
import apimodels.SendMailTo;

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
public class SendingApiController extends Controller {
    private final SendingApiControllerImpInterface imp;
    private final ObjectMapper mapper;
    private final Config configuration;

    @Inject
    private SendingApiController(Config configuration, SendingApiControllerImpInterface imp) {
        this.imp = imp;
        mapper = new ObjectMapper();
        this.configuration = configuration;
    }

    @ApiAction
    public Result rawMail(Http.Request request) throws Exception {
        JsonNode nodesendMailRaw = request.body().asJson();
        SendMailRaw sendMailRaw;
        if (nodesendMailRaw != null) {
            sendMailRaw = mapper.readValue(nodesendMailRaw.toString(), SendMailRaw.class);
            if (configuration.getBoolean("useInputBeanValidation")) {
                OpenAPIUtils.validate(sendMailRaw);
            }
        } else {
            throw new IllegalArgumentException("'SendMailRaw' parameter is required");
        }
        return imp.rawMailHttp(request, sendMailRaw);
    }

    @ApiAction
    public Result sendAdvMail(Http.Request request) throws Exception {
        String[] valuesubject = request.body().asMultipartFormData().asFormUrlEncoded().get("subject");
        String subject;
        if (valuesubject != null) {
            subject = valuesubject[0];
        } else {
            throw new IllegalArgumentException("'subject' parameter is required");
        }
        String[] valuebody = request.body().asMultipartFormData().asFormUrlEncoded().get("body");
        String body;
        if (valuebody != null) {
            body = valuebody[0];
        } else {
            throw new IllegalArgumentException("'body' parameter is required");
        }
        String[] valuefrom = request.body().asMultipartFormData().asFormUrlEncoded().get("from");
        EmailAddressTypes from;
        if (valuefrom != null) {
            from = valuefrom[0];
        } else {
            throw new IllegalArgumentException("'from' parameter is required");
        }
        String[] valueto = request.body().asMultipartFormData().asFormUrlEncoded().get("to");
        EmailAddressesTypes to;
        if (valueto != null) {
            to = valueto[0];
        } else {
            throw new IllegalArgumentException("'to' parameter is required");
        }
        String[] valuereplyto = request.body().asMultipartFormData().asFormUrlEncoded().get("replyto");
        EmailAddressesTypes replyto;
        if (valuereplyto != null) {
            replyto = valuereplyto[0];
        } else {
            replyto = null;
        }
        String[] valuecc = request.body().asMultipartFormData().asFormUrlEncoded().get("cc");
        EmailAddressesTypes cc;
        if (valuecc != null) {
            cc = valuecc[0];
        } else {
            cc = null;
        }
        String[] valuebcc = request.body().asMultipartFormData().asFormUrlEncoded().get("bcc");
        EmailAddressesTypes bcc;
        if (valuebcc != null) {
            bcc = valuebcc[0];
        } else {
            bcc = null;
        }
        String[] attachmentsArray = request.body().asMultipartFormData().asFormUrlEncoded().get("attachments");
        List<String> attachmentsList = OpenAPIUtils.parametersToList("csv", attachmentsArray);
        List<@Valid MailAttachment> attachments = new ArrayList<>();
        for (String curParam : attachmentsList) {
            if (!curParam.isEmpty()) {
                //noinspection UseBulkOperation
                attachments.add(curParam);
            }
        }
        String[] valueid = request.body().asMultipartFormData().asFormUrlEncoded().get("id");
        Long id;
        if (valueid != null) {
            id = Long.parseLong(valueid[0]);
        } else {
            id = null;
        }
        return imp.sendAdvMailHttp(request, subject, body, from, to, replyto, cc, bcc, attachments, id);
    }

    @ApiAction
    public Result sendMail(Http.Request request) throws Exception {
        String[] valueto = request.body().asMultipartFormData().asFormUrlEncoded().get("to");
        SendMailTo to;
        if (valueto != null) {
            to = valueto[0];
        } else {
            throw new IllegalArgumentException("'to' parameter is required");
        }
        String[] valuefrom = request.body().asMultipartFormData().asFormUrlEncoded().get("from");
        String from;
        if (valuefrom != null) {
            from = valuefrom[0];
        } else {
            throw new IllegalArgumentException("'from' parameter is required");
        }
        String[] valuesubject = request.body().asMultipartFormData().asFormUrlEncoded().get("subject");
        String subject;
        if (valuesubject != null) {
            subject = valuesubject[0];
        } else {
            throw new IllegalArgumentException("'subject' parameter is required");
        }
        String[] valuebody = request.body().asMultipartFormData().asFormUrlEncoded().get("body");
        String body;
        if (valuebody != null) {
            body = valuebody[0];
        } else {
            throw new IllegalArgumentException("'body' parameter is required");
        }
        String[] valueid = request.body().asMultipartFormData().asFormUrlEncoded().get("id");
        Long id;
        if (valueid != null) {
            id = Long.parseLong(valueid[0]);
        } else {
            id = null;
        }
        return imp.sendMailHttp(request, to, from, subject, body, id);
    }

}
