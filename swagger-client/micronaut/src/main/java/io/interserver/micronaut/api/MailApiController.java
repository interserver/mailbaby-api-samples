package io.interserver.micronaut.api;

import io.interserver.micronaut.model.DenyRuleNew;

import io.interserver.micronaut.model.DenyRuleRecord;

import io.interserver.micronaut.model.EmailAddressParam;

import io.interserver.micronaut.model.ErrorMessage;

import io.interserver.micronaut.model.GenericResponse;

import io.interserver.micronaut.model.MailAttachment;

import io.interserver.micronaut.model.MailBlocks;

import io.interserver.micronaut.model.MailLog;

import io.interserver.micronaut.model.MailOrder;

import io.interserver.micronaut.model.MailOrderDetail;

import io.interserver.micronaut.model.MailStatsType;

import io.interserver.micronaut.model.SendMail;

import io.interserver.micronaut.model.SendMailAdv;

import io.interserver.micronaut.model.SendMailRaw;

import io.interserver.micronaut.model.SendMailTo;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.HttpResponse;
import io.reactivex.rxjava3.core.Single;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Controller
public class MailApiController implements MailApi {

    @Override
    public Single<HttpResponse<GenericResponse>> addRule(@NotNull String user, @NotNull String type, @NotNull String data) {
        // TODO: Implement me
        return MailApi.super.addRule(user, type, data);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> addRule(@NotNull @Valid DenyRuleNew body) {
        // TODO: Implement me
        return MailApi.super.addRule(body);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> deleteRule(Integer ruleId) {
        // TODO: Implement me
        return MailApi.super.deleteRule(ruleId);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> delistBlock(@NotNull @Valid EmailAddressParam body) {
        // TODO: Implement me
        return MailApi.super.delistBlock(body);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> delistBlock(@NotNull String email) {
        // TODO: Implement me
        return MailApi.super.delistBlock(email);
    }

    @Override
    public Single<HttpResponse<MailBlocks>> getMailBlocks() {
        // TODO: Implement me
        return MailApi.super.getMailBlocks();
    }

    @Override
    public Single<HttpResponse<MailOrderDetail>> getMailOrderById(Long id) {
        // TODO: Implement me
        return MailApi.super.getMailOrderById(id);
    }

    @Override
    public Single<HttpResponse<List<MailOrder>>> getMailOrders() {
        // TODO: Implement me
        return MailApi.super.getMailOrders();
    }

    @Override
    public Single<HttpResponse<List<DenyRuleRecord>>> getRules() {
        // TODO: Implement me
        return MailApi.super.getRules();
    }

    @Override
    public Single<HttpResponse<MailStatsType>> getStats(@Nullable String time) {
        // TODO: Implement me
        return MailApi.super.getStats(time);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> rawMail(@NotNull @Valid SendMailRaw body) {
        // TODO: Implement me
        return MailApi.super.rawMail(body);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> rawMail(@NotNull String rawEmail, @NotNull Long id) {
        // TODO: Implement me
        return MailApi.super.rawMail(rawEmail, id);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendAdvMail(@NotNull String subject, @NotNull String body, @NotNull @Valid Object from, @NotNull @Valid Object to, @NotNull @Valid Object replyto, @NotNull @Valid Object cc, @NotNull @Valid Object bcc, @NotNull @Valid List<MailAttachment> attachments, @NotNull Long id) {
        // TODO: Implement me
        return MailApi.super.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendAdvMail(@NotNull @Valid SendMailAdv body) {
        // TODO: Implement me
        return MailApi.super.sendAdvMail(body);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendMail(@NotNull @Valid SendMailTo to, @NotNull String from, @NotNull String subject, @NotNull String body, @NotNull Long id) {
        // TODO: Implement me
        return MailApi.super.sendMail(to, from, subject, body, id);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendMail(@NotNull @Valid SendMail body) {
        // TODO: Implement me
        return MailApi.super.sendMail(body);
    }

    @Override
    public Single<HttpResponse<MailLog>> viewMailLog(@Nullable Long id, @Nullable String origin, @Nullable String mx, @Nullable String from, @Nullable String to, @Nullable String subject, @Nullable @Size(min=18,max=19) String mailid, @Nullable String messageId, @Nullable String replyto, @Nullable String headerfrom, @Nullable Integer delivered, @Nullable @Min(0)Integer skip, @Nullable @Min(1) @Max(10000) Integer limit, @Nullable String startDate, @Nullable String endDate, @Nullable String sort, @Nullable String dir, @Nullable String groupby) {
        // TODO: Implement me
        return MailApi.super.viewMailLog(id, origin, mx, from, to, subject, mailid, messageId, replyto, headerfrom, delivered, skip, limit, startDate, endDate, sort, dir, groupby);
    }
}
