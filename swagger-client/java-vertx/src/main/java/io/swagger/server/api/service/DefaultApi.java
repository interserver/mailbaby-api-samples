package io.swagger.server.api.service;

import io.swagger.server.api.model.GenericResponse;
import io.swagger.server.api.model.InlineResponse200;
import io.swagger.server.api.model.InlineResponse401;
import io.swagger.server.api.model.MailLog;
import io.swagger.server.api.model.SendMail;
import io.swagger.server.api.model.SendMailAdv;
import io.swagger.server.api.model.SendMailAdvAttachments;
import io.swagger.server.api.model.SendMailAdvBcc;
import io.swagger.server.api.model.SendMailAdvCc;
import io.swagger.server.api.model.SendMailAdvFrom;
import io.swagger.server.api.model.SendMailAdvReplyto;
import io.swagger.server.api.model.SendMailAdvTo;

import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.api.service.WebApiServiceGen;

import java.util.List;
import java.util.Map;

@WebApiServiceGen
public interface DefaultApi  {

    String WEBSERVICE_ADDRESS_DEFAULTAPI = "";
    String OPERATION_ID_GETMAILORDERS = "getMailOrders";
    String OPERATION_ID_PINGSERVER = "pingServer";
    String OPERATION_ID_SENDADVMAIL = "sendAdvMail";
    String OPERATION_ID_SENDMAIL = "sendMail";
    String OPERATION_ID_VIEWMAILLOG = "viewMailLog";

    void getMailOrders(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void pingServer(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendAdvMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendAdvMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void sendMail(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void viewMailLog(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
}
