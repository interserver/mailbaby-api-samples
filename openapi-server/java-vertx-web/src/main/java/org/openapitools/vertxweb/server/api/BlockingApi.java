package org.openapitools.vertxweb.server.api;

import org.openapitools.vertxweb.server.model.DenyRuleRecord;
import org.openapitools.vertxweb.server.model.EmailAddressParam;
import org.openapitools.vertxweb.server.model.ErrorMessage;
import org.openapitools.vertxweb.server.model.GenericResponse;
import org.openapitools.vertxweb.server.model.MailBlocks;

import org.openapitools.vertxweb.server.ApiResponse;

import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Map;

public interface BlockingApi  {
    Future<ApiResponse<GenericResponse>> addRule(JsonObject formBody);
    Future<ApiResponse<GenericResponse>> deleteRule(Integer ruleId);
    Future<ApiResponse<GenericResponse>> delistBlock(EmailAddressParam emailAddressParam);
    Future<ApiResponse<MailBlocks>> getMailBlocks();
    Future<ApiResponse<List<DenyRuleRecord>>> getRules();
}
