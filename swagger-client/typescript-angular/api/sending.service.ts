/**
 * MailBaby Email Delivery and Management Service API
 * **Send emails fast and with confidence through our easy to use [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) API interface.** # Overview This is the API interface to the [Mail Baby](https//mail.baby/) Mail services provided by [InterServer](https://www.interserver.net). To use this service you must have an account with us at [my.interserver.net](https://my.interserver.net). # Authentication In order to use most of the API calls you must pass credentials from the [my.interserver.net](https://my.interserver.net/) site. We support several different authentication methods but the preferred method is to use the **API Key** which you can get from the [Account Security](https://my.interserver.net/account_security) page. 
 *
 * OpenAPI spec version: 1.1.0
 * Contact: support@interserver.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *//* tslint:disable:no-unused-variable member-ordering */

import { Inject, Injectable, Optional }                      from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams,
         HttpResponse, HttpEvent }                           from '@angular/common/http';
import { CustomHttpUrlEncodingCodec }                        from '../encoder';

import { Observable }                                        from 'rxjs';

import { EmailAddressTypes } from '../model/emailAddressTypes';
import { EmailAddressesTypes } from '../model/emailAddressesTypes';
import { ErrorMessage } from '../model/errorMessage';
import { GenericResponse } from '../model/genericResponse';
import { MailAttachment } from '../model/mailAttachment';
import { SendMail } from '../model/sendMail';
import { SendMailAdv } from '../model/sendMailAdv';

import { BASE_PATH, COLLECTION_FORMATS }                     from '../variables';
import { Configuration }                                     from '../configuration';


@Injectable()
export class SendingService {

    protected basePath = 'https://api.mailbaby.net';
    public defaultHeaders = new HttpHeaders();
    public configuration = new Configuration();

    constructor(protected httpClient: HttpClient, @Optional()@Inject(BASE_PATH) basePath: string, @Optional() configuration: Configuration) {
        if (basePath) {
            this.basePath = basePath;
        }
        if (configuration) {
            this.configuration = configuration;
            this.basePath = basePath || configuration.basePath || this.basePath;
        }
    }

    /**
     * @param consumes string[] mime-types
     * @return true: consumes contains 'multipart/form-data', false: otherwise
     */
    private canConsumeForm(consumes: string[]): boolean {
        const form = 'multipart/form-data';
        for (const consume of consumes) {
            if (form === consume) {
                return true;
            }
        }
        return false;
    }


    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
     * @param subject 
     * @param body 
     * @param from 
     * @param to 
     * @param replyto 
     * @param cc 
     * @param bcc 
     * @param attachments 
     * @param id 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public sendAdvMailForm(subject: string, body: string, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: Array<MailAttachment>, id: number, observe?: 'body', reportProgress?: boolean): Observable<GenericResponse>;
    public sendAdvMailForm(subject: string, body: string, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: Array<MailAttachment>, id: number, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<GenericResponse>>;
    public sendAdvMailForm(subject: string, body: string, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: Array<MailAttachment>, id: number, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<GenericResponse>>;
    public sendAdvMailForm(subject: string, body: string, from: EmailAddressTypes, to: EmailAddressesTypes, replyto: EmailAddressesTypes, cc: EmailAddressesTypes, bcc: EmailAddressesTypes, attachments: Array<MailAttachment>, id: number, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (subject === null || subject === undefined) {
            throw new Error('Required parameter subject was null or undefined when calling sendAdvMail.');
        }

        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling sendAdvMail.');
        }

        if (from === null || from === undefined) {
            throw new Error('Required parameter from was null or undefined when calling sendAdvMail.');
        }

        if (to === null || to === undefined) {
            throw new Error('Required parameter to was null or undefined when calling sendAdvMail.');
        }

        if (replyto === null || replyto === undefined) {
            throw new Error('Required parameter replyto was null or undefined when calling sendAdvMail.');
        }

        if (cc === null || cc === undefined) {
            throw new Error('Required parameter cc was null or undefined when calling sendAdvMail.');
        }

        if (bcc === null || bcc === undefined) {
            throw new Error('Required parameter bcc was null or undefined when calling sendAdvMail.');
        }

        if (attachments === null || attachments === undefined) {
            throw new Error('Required parameter attachments was null or undefined when calling sendAdvMail.');
        }

        if (id === null || id === undefined) {
            throw new Error('Required parameter id was null or undefined when calling sendAdvMail.');
        }

        let headers = this.defaultHeaders;

        // authentication (apiKeyAuth) required
        if (this.configuration.apiKeys && this.configuration.apiKeys["X-API-KEY"]) {
            headers = headers.set('X-API-KEY', this.configuration.apiKeys["X-API-KEY"]);
        }

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/x-www-form-urlencoded',
            'application/json'
        ];

        const canConsumeForm = this.canConsumeForm(consumes);

        let formParams: { append(param: string, value: any): void; };
        let useForm = false;
        let convertFormParamsToString = false;
        if (useForm) {
            formParams = new FormData();
        } else {
            formParams = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        }

        if (subject !== undefined) {
            formParams = formParams.append('subject', <any>subject) as any || formParams;
        }
        if (body !== undefined) {
            formParams = formParams.append('body', <any>body) as any || formParams;
        }
        if (from !== undefined) {
            formParams = formParams.append('from', <any>from) as any || formParams;
        }
        if (to !== undefined) {
            formParams = formParams.append('to', <any>to) as any || formParams;
        }
        if (replyto !== undefined) {
            formParams = formParams.append('replyto', <any>replyto) as any || formParams;
        }
        if (cc !== undefined) {
            formParams = formParams.append('cc', <any>cc) as any || formParams;
        }
        if (bcc !== undefined) {
            formParams = formParams.append('bcc', <any>bcc) as any || formParams;
        }
        if (attachments) {
            attachments.forEach((element) => {
                formParams = formParams.append('attachments', <any>element) as any || formParams;
            })
        }
        if (id !== undefined) {
            formParams = formParams.append('id', <any>id) as any || formParams;
        }

        return this.httpClient.request<GenericResponse>('post',`${this.basePath}/mail/advsend`,
            {
                body: convertFormParamsToString ? formParams.toString() : formParams,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  &#x60;&#x60;&#x60;BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data to&#x3D;support@interserver.net &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;\&quot;Joe &lt;user@domain.com&gt;\&quot; \\ --data to&#x3D;\&quot;Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;support@interserver.net, support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to&#x3D;Joe &lt;support@interserver.net&gt;, Joe &lt;support@interserver.net&gt;\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/x-www-form-urlencoded&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;subject&#x3D;Welcome&#x27; \\ --data &#x27;body&#x3D;Hello&#x27; \\ --data from&#x3D;user@domain.com \\ --data \&quot;to[0][name]&#x3D;Joe\&quot; \\ --data \&quot;to[0][email]&#x3D;support@interserver.net\&quot; \\ --data \&quot;to[1][name]&#x3D;Joe\&quot; \\ --data \&quot;to[1][email]&#x3D;support@interserver.net\&quot; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;user@domain.com\&quot;, \&quot;to\&quot;: \&quot;support@interserver.net\&quot; }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: {\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;user@domain.com\&quot;}, \&quot;to\&quot;: [{\&quot;name\&quot;: \&quot;Joe\&quot;, \&quot;email\&quot;: \&quot;support@interserver.net\&quot;}] }&#x27; &#x60;&#x60;&#x60;  &#x60;&#x60;&#x60;NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header &#x27;Accept: application/json&#x27; \\ --header &#x27;Content-Type: application/json&#x27; \\ --header &#x27;X-API-KEY: YOUR_API_KEY&#x27; \\ --data &#x27;{ \&quot;subject\&quot;: \&quot;Welcome\&quot;, \&quot;body\&quot;: \&quot;Hello\&quot;, \&quot;from\&quot;: \&quot;Joe &lt;user@domain.com&gt;\&quot;, \&quot;to\&quot;: \&quot;Joe &lt;support@interserver.net&gt;\&quot; }&#x27; &#x60;&#x60;&#x60; 
     * @param body 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public sendAdvMail(body: SendMailAdv, observe?: 'body', reportProgress?: boolean): Observable<GenericResponse>;
    public sendAdvMail(body: SendMailAdv, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<GenericResponse>>;
    public sendAdvMail(body: SendMailAdv, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<GenericResponse>>;
    public sendAdvMail(body: SendMailAdv, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling sendAdvMail.');
        }

        let headers = this.defaultHeaders;

        // authentication (apiKeyAuth) required
        if (this.configuration.apiKeys && this.configuration.apiKeys["X-API-KEY"]) {
            headers = headers.set('X-API-KEY', this.configuration.apiKeys["X-API-KEY"]);
        }

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/x-www-form-urlencoded',
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.request<GenericResponse>('post',`${this.basePath}/mail/advsend`,
            {
                body: body,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Sends an Email
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @param to 
     * @param from 
     * @param subject 
     * @param body 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public sendMailForm(to: string, from: string, subject: string, body: string, observe?: 'body', reportProgress?: boolean): Observable<GenericResponse>;
    public sendMailForm(to: string, from: string, subject: string, body: string, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<GenericResponse>>;
    public sendMailForm(to: string, from: string, subject: string, body: string, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<GenericResponse>>;
    public sendMailForm(to: string, from: string, subject: string, body: string, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (to === null || to === undefined) {
            throw new Error('Required parameter to was null or undefined when calling sendMail.');
        }

        if (from === null || from === undefined) {
            throw new Error('Required parameter from was null or undefined when calling sendMail.');
        }

        if (subject === null || subject === undefined) {
            throw new Error('Required parameter subject was null or undefined when calling sendMail.');
        }

        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling sendMail.');
        }

        let headers = this.defaultHeaders;

        // authentication (apiKeyAuth) required
        if (this.configuration.apiKeys && this.configuration.apiKeys["X-API-KEY"]) {
            headers = headers.set('X-API-KEY', this.configuration.apiKeys["X-API-KEY"]);
        }

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/x-www-form-urlencoded',
            'application/json'
        ];

        const canConsumeForm = this.canConsumeForm(consumes);

        let formParams: { append(param: string, value: any): void; };
        let useForm = false;
        let convertFormParamsToString = false;
        if (useForm) {
            formParams = new FormData();
        } else {
            formParams = new HttpParams({encoder: new CustomHttpUrlEncodingCodec()});
        }

        if (to !== undefined) {
            formParams = formParams.append('to', <any>to) as any || formParams;
        }
        if (from !== undefined) {
            formParams = formParams.append('from', <any>from) as any || formParams;
        }
        if (subject !== undefined) {
            formParams = formParams.append('subject', <any>subject) as any || formParams;
        }
        if (body !== undefined) {
            formParams = formParams.append('body', <any>body) as any || formParams;
        }

        return this.httpClient.request<GenericResponse>('post',`${this.basePath}/mail/send`,
            {
                body: convertFormParamsToString ? formParams.toString() : formParams,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

    /**
     * Sends an Email
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @param body 
     * @param observe set whether or not to return the data Observable as the body, response or events. defaults to returning the body.
     * @param reportProgress flag to report request and response progress.
     */
    public sendMail(body: SendMail, observe?: 'body', reportProgress?: boolean): Observable<GenericResponse>;
    public sendMail(body: SendMail, observe?: 'response', reportProgress?: boolean): Observable<HttpResponse<GenericResponse>>;
    public sendMail(body: SendMail, observe?: 'events', reportProgress?: boolean): Observable<HttpEvent<GenericResponse>>;
    public sendMail(body: SendMail, observe: any = 'body', reportProgress: boolean = false ): Observable<any> {

        if (body === null || body === undefined) {
            throw new Error('Required parameter body was null or undefined when calling sendMail.');
        }

        let headers = this.defaultHeaders;

        // authentication (apiKeyAuth) required
        if (this.configuration.apiKeys && this.configuration.apiKeys["X-API-KEY"]) {
            headers = headers.set('X-API-KEY', this.configuration.apiKeys["X-API-KEY"]);
        }

        // to determine the Accept header
        let httpHeaderAccepts: string[] = [
            'application/json'
        ];
        const httpHeaderAcceptSelected: string | undefined = this.configuration.selectHeaderAccept(httpHeaderAccepts);
        if (httpHeaderAcceptSelected != undefined) {
            headers = headers.set('Accept', httpHeaderAcceptSelected);
        }

        // to determine the Content-Type header
        const consumes: string[] = [
            'application/x-www-form-urlencoded',
            'application/json'
        ];
        const httpContentTypeSelected: string | undefined = this.configuration.selectHeaderContentType(consumes);
        if (httpContentTypeSelected != undefined) {
            headers = headers.set('Content-Type', httpContentTypeSelected);
        }

        return this.httpClient.request<GenericResponse>('post',`${this.basePath}/mail/send`,
            {
                body: body,
                withCredentials: this.configuration.withCredentials,
                headers: headers,
                observe: observe,
                reportProgress: reportProgress
            }
        );
    }

}
