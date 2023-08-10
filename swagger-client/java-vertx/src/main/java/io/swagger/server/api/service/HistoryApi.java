package io.swagger.server.api.service;

import io.swagger.server.api.model.InlineResponse200;
import io.swagger.server.api.model.InlineResponse401;
import io.swagger.server.api.model.MailLog;

import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.api.service.WebApiServiceGen;

import java.util.List;
import java.util.Map;

@WebApiServiceGen
public interface HistoryApi  {

    String WEBSERVICE_ADDRESS_HISTORYAPI = "";
    String OPERATION_ID_GETSTATS = "getStats";
    String OPERATION_ID_VIEWMAILLOG = "viewMailLog";

    void getStats(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
    void viewMailLog(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
}
