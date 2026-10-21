package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.MailOrder;
import org.openapitools.vertxweb.server.model.MailOrderDetail;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.handler.HttpException;

import java.util.List;
import java.util.Map;

// Implement this class

public class ServicesApiImpl implements ServicesApi {
    public Future<ApiResponse<MailOrderDetail>> getMailOrderById(Long id) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<List<MailOrder>>> getMailOrders() {
        return Future.failedFuture(new HttpException(501));
    }

}
