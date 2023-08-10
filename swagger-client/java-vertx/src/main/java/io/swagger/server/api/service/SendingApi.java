package io.swagger.server.api.service;

import io.swagger.server.api.model.EmailAddressName;
import io.swagger.server.api.model.GenericResponse;
import io.swagger.server.api.model.InlineResponse401;
import io.swagger.server.api.model.MailAttachment;
import io.swagger.server.api.model.SendMail;
import io.swagger.server.api.model.SendMailAdv;

import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.api.service.WebApiServiceGen;

import java.util.List;
import java.util.Map;

@WebApiServiceGen
public interface SendingApi  {

    String WEBSERVICE_ADDRESS_SENDINGAPI = "";
    String OPERATION_ID_SENDADVMAIL = "sendAdvMail";
    String OPERATION_ID_SENDMAIL = "sendMail";

    void sendAdvMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendAdvMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
}
