package controllers;

import apimodels.EmailAddressTypes;
import apimodels.EmailAddressesTypes;
import apimodels.ErrorMessage;
import apimodels.GenericResponse;
import apimodels.MailAttachment;
import apimodels.SendMailRaw;
import apimodels.SendMailTo;

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
public abstract class SendingApiControllerImpInterface {
    @Inject private Config configuration;
    @Inject private SecurityAPIUtils securityAPIUtils;
    private ObjectMapper mapper = new ObjectMapper();

    public Result rawMailHttp(Http.Request request, SendMailRaw sendMailRaw) throws Exception {
        GenericResponse obj = rawMail(request, sendMailRaw);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract GenericResponse rawMail(Http.Request request, SendMailRaw sendMailRaw) throws Exception;

    public Result sendAdvMailHttp(Http.Request request, String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<@Valid MailAttachment> attachments, Long id) throws Exception {
        GenericResponse obj = sendAdvMail(request, subject, body, from, to, replyto, cc, bcc, attachments, id);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract GenericResponse sendAdvMail(Http.Request request, String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<@Valid MailAttachment> attachments, Long id) throws Exception;

    public Result sendMailHttp(Http.Request request, SendMailTo to, String from, String subject, String body, Long id) throws Exception {
        GenericResponse obj = sendMail(request, to, from, subject, body, id);

        if (configuration.getBoolean("useOutputBeanValidation")) {
            OpenAPIUtils.validate(obj);
        }

        JsonNode result = mapper.valueToTree(obj);

        return ok(result);

    }

    public abstract GenericResponse sendMail(Http.Request request, SendMailTo to, String from, String subject, String body, Long id) throws Exception;

}
