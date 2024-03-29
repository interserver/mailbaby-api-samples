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
/* tslint:disable:no-unused-variable member-ordering */

import { Observable } from 'rxjs/Observable';

import { map } from 'rxjs/operators';
import IHttpClient from '../IHttpClient';
import { inject, injectable } from 'inversify';
import { IAPIConfiguration } from '../IAPIConfiguration';
import { Headers } from '../Headers';
import HttpResponse from '../HttpResponse';

import { DenyRuleRecord } from '../model/denyRuleRecord';
import { ErrorMessage } from '../model/errorMessage';
import { GenericResponse } from '../model/genericResponse';
import { MailBlocks } from '../model/mailBlocks';

import { COLLECTION_FORMATS }  from '../variables';



@injectable()
export class BlockingService {
    private basePath: string = 'https://api.mailbaby.net';

    constructor(@inject('IApiHttpClient') private httpClient: IHttpClient,
        @inject('IAPIConfiguration') private APIConfiguration: IAPIConfiguration ) {
        if(this.APIConfiguration.basePath)
            this.basePath = this.APIConfiguration.basePath;
    }

    /**
     * Creates a new email deny rule.
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * @param type The type of deny rule.
     * @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     
     */
    public addRule(type: string, data: string, user?: string, observe?: 'body', headers?: Headers): Observable<GenericResponse>;
    public addRule(type: string, data: string, user?: string, observe?: 'response', headers?: Headers): Observable<HttpResponse<GenericResponse>>;
    public addRule(type: string, data: string, user?: string, observe: any = 'body', headers: Headers = {}): Observable<any> {
        if (type === null || type === undefined){
            throw new Error('Required parameter type was null or undefined when calling addRule.');
        }

        if (data === null || data === undefined){
            throw new Error('Required parameter data was null or undefined when calling addRule.');
        }

        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';

        let formData: FormData = new FormData();
        headers['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
        if (user !== undefined) {
            formData.append('user', <any>user);
        }
        if (type !== undefined) {
            formData.append('type', <any>type);
        }
        if (data !== undefined) {
            formData.append('data', <any>data);
        }

        const response: Observable<HttpResponse<GenericResponse>> = this.httpClient.post(`${this.basePath}/mail/rules`, formData, headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <GenericResponse>(httpResponse.response))
               );
        }
        return response;
    }


    /**
     * Removes an deny mail rule.
     * Removes one of the configured deny mail rules from the system.
     * @param ruleId The ID of the Rules entry.
     
     */
    public deleteRule(ruleId: number, observe?: 'body', headers?: Headers): Observable<GenericResponse>;
    public deleteRule(ruleId: number, observe?: 'response', headers?: Headers): Observable<HttpResponse<GenericResponse>>;
    public deleteRule(ruleId: number, observe: any = 'body', headers: Headers = {}): Observable<any> {
        if (ruleId === null || ruleId === undefined){
            throw new Error('Required parameter ruleId was null or undefined when calling deleteRule.');
        }

        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';

        const response: Observable<HttpResponse<GenericResponse>> = this.httpClient.delete(`${this.basePath}/mail/rules/${encodeURIComponent(String(ruleId))}`, headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <GenericResponse>(httpResponse.response))
               );
        }
        return response;
    }


    /**
     * Removes an email address from the blocked list
     * Removes an email address from the various block lists. 
     * @param body 
     
     */
    public delistBlock(body: string, observe?: 'body', headers?: Headers): Observable<GenericResponse>;
    public delistBlock(body: string, observe?: 'response', headers?: Headers): Observable<HttpResponse<GenericResponse>>;
    public delistBlock(body: string, observe: any = 'body', headers: Headers = {}): Observable<any> {
        if (body === null || body === undefined){
            throw new Error('Required parameter body was null or undefined when calling delistBlock.');
        }

        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';
        headers['Content-Type'] = 'application/json';

        const response: Observable<HttpResponse<GenericResponse>> = this.httpClient.post(`${this.basePath}/mail/blocks/delete`, body , headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <GenericResponse>(httpResponse.response))
               );
        }
        return response;
    }


    /**
     * displays a list of blocked email addresses
     * 
     
     */
    public getMailBlocks(observe?: 'body', headers?: Headers): Observable<MailBlocks>;
    public getMailBlocks(observe?: 'response', headers?: Headers): Observable<HttpResponse<MailBlocks>>;
    public getMailBlocks(observe: any = 'body', headers: Headers = {}): Observable<any> {
        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';

        const response: Observable<HttpResponse<MailBlocks>> = this.httpClient.get(`${this.basePath}/mail/blocks`, headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <MailBlocks>(httpResponse.response))
               );
        }
        return response;
    }


    /**
     * Displays a listing of deny email rules.
     * Returns a listing of all the deny block rules you have configured.
     
     */
    public getRules(observe?: 'body', headers?: Headers): Observable<Array<DenyRuleRecord>>;
    public getRules(observe?: 'response', headers?: Headers): Observable<HttpResponse<Array<DenyRuleRecord>>>;
    public getRules(observe: any = 'body', headers: Headers = {}): Observable<any> {
        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';

        const response: Observable<HttpResponse<Array<DenyRuleRecord>>> = this.httpClient.get(`${this.basePath}/mail/rules`, headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <Array<DenyRuleRecord>>(httpResponse.response))
               );
        }
        return response;
    }

}
