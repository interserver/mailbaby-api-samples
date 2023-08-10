package io.swagger.server.api.service;

import io.swagger.server.api.model.DenyRuleNew;
import io.swagger.server.api.model.DenyRuleRecord;
import io.swagger.server.api.model.EmailAddress;
import io.swagger.server.api.model.GenericResponse;
import io.swagger.server.api.model.InlineResponse401;
import io.swagger.server.api.model.MailBlocks;

import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.api.service.WebApiServiceGen;

import java.util.List;
import java.util.Map;

@WebApiServiceGen
public interface BlockingApi  {

    String WEBSERVICE_ADDRESS_BLOCKINGAPI = "";
    String OPERATION_ID_ADDRULE = "addRule";
    String OPERATION_ID_DELETERULE = "deleteRule";
    String OPERATION_ID_DELISTBLOCK = "delistBlock";
    String OPERATION_ID_GETMAILBLOCKS = "getMailBlocks";
    String OPERATION_ID_GETRULES = "getRules";

    void addRule(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void addRule(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void deleteRule(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void delistBlock(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void delistBlock(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void getMailBlocks(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void getRules(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
}
