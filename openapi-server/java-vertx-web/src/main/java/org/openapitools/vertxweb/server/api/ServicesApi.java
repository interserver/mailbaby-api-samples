package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.MailOrder;
import org.openapitools.vertxweb.server.model.MailOrderDetail;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Map;

public interface ServicesApi  {
    Future<ApiResponse<MailOrderDetail>> getMailOrderById(Long id);
    Future<ApiResponse<List<MailOrder>>> getMailOrders();
}
