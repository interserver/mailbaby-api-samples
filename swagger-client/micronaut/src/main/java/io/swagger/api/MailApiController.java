package io.swagger.api;

import io.swagger.model.DenyRuleNew;

import io.swagger.model.DenyRuleRecord;

import io.swagger.model.EmailAddressTypes;

import io.swagger.model.EmailAddressesTypes;

import io.swagger.model.ErrorMessage;

import io.swagger.model.GenericResponse;

import io.swagger.model.MailAttachment;

import io.swagger.model.MailBlocks;

import io.swagger.model.MailLog;

import io.swagger.model.MailOrder;

import io.swagger.model.MailStatsType;

import io.swagger.model.SendMail;

import io.swagger.model.SendMailAdv;

import io.swagger.model.SendMailRaw;

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
    public Single<HttpResponse<GenericResponse>> delistBlock(@NotNull @Valid String body) {
        // TODO: Implement me
        return MailApi.super.delistBlock(body);
    }

    @Override
    public Single<HttpResponse<MailBlocks>> getMailBlocks() {
        // TODO: Implement me
        return MailApi.super.getMailBlocks();
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
    public Single<HttpResponse<GenericResponse>> rawMail(@NotNull String rawEmail, @NotNull Integer id) {
        // TODO: Implement me
        return MailApi.super.rawMail(rawEmail, id);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendAdvMail(@NotNull String subject, @NotNull String body, @NotNull @Valid EmailAddressTypes from, @NotNull @Valid EmailAddressesTypes to, @NotNull @Valid EmailAddressesTypes replyto, @NotNull @Valid EmailAddressesTypes cc, @NotNull @Valid EmailAddressesTypes bcc, @NotNull @Valid List<MailAttachment> attachments, @NotNull Long id) {
        // TODO: Implement me
        return MailApi.super.sendAdvMail(subject, body, from, to, replyto, cc, bcc, attachments, id);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendAdvMail(@NotNull @Valid SendMailAdv body) {
        // TODO: Implement me
        return MailApi.super.sendAdvMail(body);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendMail(@NotNull String to, @NotNull String from, @NotNull String subject, @NotNull String body, @NotNull Integer id) {
        // TODO: Implement me
        return MailApi.super.sendMail(to, from, subject, body, id);
    }

    @Override
    public Single<HttpResponse<GenericResponse>> sendMail(@NotNull @Valid SendMail body) {
        // TODO: Implement me
        return MailApi.super.sendMail(body);
    }

    @Override
    public Single<HttpResponse<MailLog>> viewMailLog(@Nullable Long id, @Nullable String origin, @Nullable String mx, @Nullable String from, @Nullable String to, @Nullable String subject, @Nullable String mailid, @Nullable @Min(0)Integer skip, @Nullable @Min(1) @Max(10000) Integer limit, @Nullable @Min(0L) @Max(9999999999L) Long startDate, @Nullable @Min(0L) @Max(9999999999L) Long endDate, @Nullable String replyto, @Nullable String headerfrom, @Nullable String delivered) {
        // TODO: Implement me
        return MailApi.super.viewMailLog(id, origin, mx, from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered);
    }
}
