// tslint:disable
/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * The version of the OpenAPI document: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import type { Observable } from 'rxjs';
import type { AjaxResponse } from 'rxjs/ajax';
import { BaseAPI, throwIfNullOrUndefined, encodeURI } from '../runtime';
import type { OperationOpts, HttpHeaders } from '../runtime';
import type {
    DenyRuleRecord,
    ErrorMessage,
    GenericResponse,
    MailBlocks,
} from '../models';

export interface AddRuleRequest {
    type: AddRuleTypeEnum;
    data: string;
    user?: string;
}

export interface DeleteRuleRequest {
    ruleId: number;
}

export interface DelistBlockRequest {
    body: string;
}

/**
 * no description
 */
export class BlockingApi extends BaseAPI {

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     */
    addRule({ type, data, user }: AddRuleRequest): Observable<GenericResponse>
    addRule({ type, data, user }: AddRuleRequest, opts?: OperationOpts): Observable<AjaxResponse<GenericResponse>>
    addRule({ type, data, user }: AddRuleRequest, opts?: OperationOpts): Observable<GenericResponse | AjaxResponse<GenericResponse>> {
        throwIfNullOrUndefined(type, 'type', 'addRule');
        throwIfNullOrUndefined(data, 'data', 'addRule');

        const headers: HttpHeaders = {
            ...(this.configuration.apiKey && { 'X-API-KEY': this.configuration.apiKey('X-API-KEY') }), // apiKeyAuth authentication
        };

        const formData = new FormData();
        if (user !== undefined) { formData.append('user', user as any); }
        if (type !== undefined) { formData.append('type', type as any); }
        if (data !== undefined) { formData.append('data', data as any); }

        return this.request<GenericResponse>({
            url: '/mail/rules',
            method: 'POST',
            headers,
            body: formData,
        }, opts?.responseOpts);
    };

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     */
    deleteRule({ ruleId }: DeleteRuleRequest): Observable<GenericResponse>
    deleteRule({ ruleId }: DeleteRuleRequest, opts?: OperationOpts): Observable<AjaxResponse<GenericResponse>>
    deleteRule({ ruleId }: DeleteRuleRequest, opts?: OperationOpts): Observable<GenericResponse | AjaxResponse<GenericResponse>> {
        throwIfNullOrUndefined(ruleId, 'ruleId', 'deleteRule');

        const headers: HttpHeaders = {
            ...(this.configuration.apiKey && { 'X-API-KEY': this.configuration.apiKey('X-API-KEY') }), // apiKeyAuth authentication
        };

        return this.request<GenericResponse>({
            url: '/mail/rules/{ruleId}'.replace('{ruleId}', encodeURI(ruleId)),
            method: 'DELETE',
            headers,
        }, opts?.responseOpts);
    };

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     */
    delistBlock({ body }: DelistBlockRequest): Observable<GenericResponse>
    delistBlock({ body }: DelistBlockRequest, opts?: OperationOpts): Observable<AjaxResponse<GenericResponse>>
    delistBlock({ body }: DelistBlockRequest, opts?: OperationOpts): Observable<GenericResponse | AjaxResponse<GenericResponse>> {
        throwIfNullOrUndefined(body, 'body', 'delistBlock');

        const headers: HttpHeaders = {
            'Content-Type': 'application/json',
            ...(this.configuration.apiKey && { 'X-API-KEY': this.configuration.apiKey('X-API-KEY') }), // apiKeyAuth authentication
        };

        return this.request<GenericResponse>({
            url: '/mail/blocks/delete',
            method: 'POST',
            headers,
            body: body as any,
        }, opts?.responseOpts);
    };

    /**
     * displays a list of blocked email addresses
     */
    getMailBlocks(): Observable<MailBlocks>
    getMailBlocks(opts?: OperationOpts): Observable<AjaxResponse<MailBlocks>>
    getMailBlocks(opts?: OperationOpts): Observable<MailBlocks | AjaxResponse<MailBlocks>> {
        const headers: HttpHeaders = {
            ...(this.configuration.apiKey && { 'X-API-KEY': this.configuration.apiKey('X-API-KEY') }), // apiKeyAuth authentication
        };

        return this.request<MailBlocks>({
            url: '/mail/blocks',
            method: 'GET',
            headers,
        }, opts?.responseOpts);
    };

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     */
    getRules(): Observable<Array<DenyRuleRecord>>
    getRules(opts?: OperationOpts): Observable<AjaxResponse<Array<DenyRuleRecord>>>
    getRules(opts?: OperationOpts): Observable<Array<DenyRuleRecord> | AjaxResponse<Array<DenyRuleRecord>>> {
        const headers: HttpHeaders = {
            ...(this.configuration.apiKey && { 'X-API-KEY': this.configuration.apiKey('X-API-KEY') }), // apiKeyAuth authentication
        };

        return this.request<Array<DenyRuleRecord>>({
            url: '/mail/rules',
            method: 'GET',
            headers,
        }, opts?.responseOpts);
    };

}

/**
 * @export
 * @enum {string}
 */
export enum AddRuleTypeEnum {
    Domain = 'domain',
    Email = 'email',
    Startswith = 'startswith',
    Destination = 'destination'
}
