package controllers;

import apimodels.EmailAddressTypes;
import apimodels.EmailAddressesTypes;
import apimodels.ErrorMessage;
import apimodels.GenericResponse;
import apimodels.MailAttachment;
import apimodels.SendMailRaw;
import apimodels.SendMailTo;

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
public class SendingApiControllerImp extends SendingApiControllerImpInterface {
    @Override
    public GenericResponse rawMail(Http.Request request, SendMailRaw sendMailRaw) throws Exception {
        //Do your magic!!!
        return new GenericResponse();
    }

    @Override
    public GenericResponse sendAdvMail(Http.Request request, String subject, String body, EmailAddressTypes from, EmailAddressesTypes to, EmailAddressesTypes replyto, EmailAddressesTypes cc, EmailAddressesTypes bcc, List<@Valid MailAttachment> attachments, Long id) throws Exception {
        //Do your magic!!!
        return new GenericResponse();
    }

    @Override
    public GenericResponse sendMail(Http.Request request, SendMailTo to, String from, String subject, String body, Long id) throws Exception {
        //Do your magic!!!
        return new GenericResponse();
    }

}
