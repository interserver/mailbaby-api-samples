package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.DenyRuleRecord;
import org.openapitools.vertxweb.server.model.EmailAddressParam;
import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.GenericResponse;
import org.openapitools.vertxweb.server.model.MailBlocks;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.handler.HttpException;

import java.util.List;
import java.util.Map;

// Implement this class

public class BlockingApiImpl implements BlockingApi {
    public Future<ApiResponse<GenericResponse>> addRule(JsonObject formBody) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<GenericResponse>> deleteRule(Integer ruleId) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<GenericResponse>> delistBlock(EmailAddressParam emailAddressParam) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<MailBlocks>> getMailBlocks() {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<List<DenyRuleRecord>>> getRules() {
        return Future.failedFuture(new HttpException(501));
    }

}
