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

import { HttpService, Inject, Injectable, Optional } from '@nestjs/common';
import { AxiosResponse } from 'axios';
import { Observable } from 'rxjs';
import { GetMailOrders401Response } from '../model/getMailOrders401Response';
import { GetStats200ResponseInner } from '../model/getStats200ResponseInner';
import { MailLog } from '../model/mailLog';
import { Configuration } from '../configuration';


@Injectable()
export class HistoryService {

    protected basePath = 'https://api.mailbaby.net';
    public defaultHeaders: Record<string,string> = {};
    public configuration = new Configuration();

    constructor(protected httpClient: HttpService, @Optional() configuration: Configuration) {
        this.configuration = configuration || this.configuration;
        this.basePath = configuration?.basePath || this.basePath;
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        return consumes.includes(form);
    }

    /**
     * displays a list of blocked email addresses
     * 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public getStats(): Observable<AxiosResponse<Array<GetStats200ResponseInner>>>;
    public getStats(): Observable<any> {

        let headers = {...this.defaultHeaders};

        // authentication (apiKeyAuth) required
        if (this.configuration.apiKeys["X-API-KEY"]) {
            headers['X-API-KEY'] = this.configuration.apiKeys["X-API-KEY"];
        }

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers['Accept'] = httpHeaderAcceptSelected;
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];
        return this.httpClient.get<Array<GetStats200ResponseInner>>(`${this.basePath}/mail/stats`,
            {
                withCredentials: this.configuration.withCredentials,
                headers: headers
            }
        );
    }
    /**
     * displays the mail log
     * Get a listing of the emails sent through this system 
     * @param id The ID of your mail order this will be sent through.
     * @param origin originating ip address sending mail
     * @param mx mx record mail was sent to
     * @param from from email address
     * @param to to/destination email address
     * @param subject subject containing this string
     * @param mailid mail id
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     * @param startDate earliest date to get emails in unix timestamp format
     * @param endDate earliest date to get emails in unix timestamp format
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public viewMailLog(id?: number, origin?: string, mx?: string, from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, ): Observable<AxiosResponse<MailLog>>;
    public viewMailLog(id?: number, origin?: string, mx?: string, from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, ): Observable<any> {












        let queryParameters = new URLSearchParams();
        if (id !== undefined && id !== null) {
            queryParameters.append('id', <any>id);
        }
        if (origin !== undefined && origin !== null) {
            queryParameters.append('origin', <any>origin);
        }
        if (mx !== undefined && mx !== null) {
            queryParameters.append('mx', <any>mx);
        }
        if (from !== undefined && from !== null) {
            queryParameters.append('from', <any>from);
        }
        if (to !== undefined && to !== null) {
            queryParameters.append('to', <any>to);
        }
        if (subject !== undefined && subject !== null) {
            queryParameters.append('subject', <any>subject);
        }
        if (mailid !== undefined && mailid !== null) {
            queryParameters.append('mailid', <any>mailid);
        }
        if (skip !== undefined && skip !== null) {
            queryParameters.append('skip', <any>skip);
        }
        if (limit !== undefined && limit !== null) {
            queryParameters.append('limit', <any>limit);
        }
        if (startDate !== undefined && startDate !== null) {
            queryParameters.append('startDate', <any>startDate);
        }
        if (endDate !== undefined && endDate !== null) {
            queryParameters.append('endDate', <any>endDate);
        }

        let headers = {...this.defaultHeaders};

        // authentication (apiKeyAuth) required
        if (this.configuration.apiKeys["X-API-KEY"]) {
            headers['X-API-KEY'] = this.configuration.apiKeys["X-API-KEY"];
        }

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers['Accept'] = httpHeaderAcceptSelected;
        }

        // to determine the Content-Type header
        const consumes: string[] = [
        ];
        return this.httpClient.get<MailLog>(`${this.basePath}/mail/log`,
            {
                params: queryParameters,
                withCredentials: this.configuration.withCredentials,
                headers: headers
            }
        );
    }
}