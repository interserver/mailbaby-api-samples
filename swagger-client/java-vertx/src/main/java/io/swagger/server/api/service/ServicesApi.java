package io.swagger.server.api.service;

import io.swagger.server.api.model.InlineResponse401;
import io.swagger.server.api.model.MailOrder;

import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.ext.web.validation.RequestParameter;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.api.service.WebApiServiceGen;

import java.util.List;
import java.util.Map;

@WebApiServiceGen
public interface ServicesApi  {

    String WEBSERVICE_ADDRESS_SERVICESAPI = "";
    String OPERATION_ID_GETMAILORDERS = "getMailOrders";

    void getMailOrders(RequestParameter body, ServiceRequest request, Handler<AsyncResult<ServiceResponse>> resultHandler);
}
