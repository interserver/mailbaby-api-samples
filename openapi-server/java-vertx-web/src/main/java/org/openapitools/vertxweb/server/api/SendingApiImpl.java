package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.EmailAddressTypes;
import org.openapitools.vertxweb.server.model.EmailAddressesTypes;
import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.GenericResponse;
import org.openapitools.vertxweb.server.model.MailAttachment;
import org.openapitools.vertxweb.server.model.SendMailRaw;
import org.openapitools.vertxweb.server.model.SendMailTo;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.handler.HttpException;

import java.util.List;
import java.util.Map;

// Implement this class

public class SendingApiImpl implements SendingApi {
    public Future<ApiResponse<GenericResponse>> rawMail(SendMailRaw sendMailRaw) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<GenericResponse>> sendAdvMail(JsonObject formBody) {
        return Future.failedFuture(new HttpException(501));
    }

    public Future<ApiResponse<GenericResponse>> sendMail(JsonObject formBody) {
        return Future.failedFuture(new HttpException(501));
    }

}
