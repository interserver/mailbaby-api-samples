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

import { EmailAddressName } from '../model/emailAddressName';
import { GenericResponse } from '../model/genericResponse';
import { GetMailOrders401Response } from '../model/getMailOrders401Response';
import { MailAttachment } from '../model/mailAttachment';

import { COLLECTION_FORMATS }  from '../variables';



@injectable()
export class SendingService {
    private basePath: string = 'https://api.mailbaby.net';

    constructor(@inject('IApiHttpClient') private httpClient: IHttpClient,
        @inject('IAPIConfiguration') private APIConfiguration: IAPIConfiguration ) {
        if(this.APIConfiguration.basePath)
            this.basePath = this.APIConfiguration.basePath;
    }

    /**
     * Sends an Email with Advanced Options
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param from 
     * @param to A list of destionation email addresses to send this to
     * @param replyto (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
     * @param cc (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     * @param bcc (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
     
     */
    public sendAdvMail(subject: string, body: string, from: EmailAddressName, to: Array<EmailAddressName>, replyto?: Array<EmailAddressName>, cc?: Array<EmailAddressName>, bcc?: Array<EmailAddressName>, attachments?: Array<MailAttachment>, id?: number, observe?: 'body', headers?: Headers): Observable<GenericResponse>;
    public sendAdvMail(subject: string, body: string, from: EmailAddressName, to: Array<EmailAddressName>, replyto?: Array<EmailAddressName>, cc?: Array<EmailAddressName>, bcc?: Array<EmailAddressName>, attachments?: Array<MailAttachment>, id?: number, observe?: 'response', headers?: Headers): Observable<HttpResponse<GenericResponse>>;
    public sendAdvMail(subject: string, body: string, from: EmailAddressName, to: Array<EmailAddressName>, replyto?: Array<EmailAddressName>, cc?: Array<EmailAddressName>, bcc?: Array<EmailAddressName>, attachments?: Array<MailAttachment>, id?: number, observe: any = 'body', headers: Headers = {}): Observable<any> {
        if (subject === null || subject === undefined){
            throw new Error('Required parameter subject was null or undefined when calling sendAdvMail.');
        }

        if (body === null || body === undefined){
            throw new Error('Required parameter body was null or undefined when calling sendAdvMail.');
        }

        if (from === null || from === undefined){
            throw new Error('Required parameter from was null or undefined when calling sendAdvMail.');
        }

        if (to === null || to === undefined){
            throw new Error('Required parameter to was null or undefined when calling sendAdvMail.');
        }

        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';

        let formData: FormData = new FormData();
        headers['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
        if (subject !== undefined) {
            formData.append('subject', <any>subject);
        }
        if (body !== undefined) {
            formData.append('body', <any>body);
        }
        if (from !== undefined) {
            formData.append('from', <any>from);
        }
        if (to) {
            formData.append('to', to.join(COLLECTION_FORMATS['csv']));
        }
        if (replyto) {
            formData.append('replyto', replyto.join(COLLECTION_FORMATS['csv']));
        }
        if (cc) {
            formData.append('cc', cc.join(COLLECTION_FORMATS['csv']));
        }
        if (bcc) {
            formData.append('bcc', bcc.join(COLLECTION_FORMATS['csv']));
        }
        if (attachments) {
            formData.append('attachments', attachments.join(COLLECTION_FORMATS['csv']));
        }
        if (id !== undefined) {
            formData.append('id', <any>id);
        }

        const response: Observable<HttpResponse<GenericResponse>> = this.httpClient.post(`${this.basePath}/mail/advsend`, formData, headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <GenericResponse>(httpResponse.response))
               );
        }
        return response;
    }


    /**
     * Sends an Email
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * @param to The Contact whom is the primary recipient of this email.
     * @param from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     
     */
    public sendMail(to: string, from: string, subject: string, body: string, observe?: 'body', headers?: Headers): Observable<GenericResponse>;
    public sendMail(to: string, from: string, subject: string, body: string, observe?: 'response', headers?: Headers): Observable<HttpResponse<GenericResponse>>;
    public sendMail(to: string, from: string, subject: string, body: string, observe: any = 'body', headers: Headers = {}): Observable<any> {
        if (to === null || to === undefined){
            throw new Error('Required parameter to was null or undefined when calling sendMail.');
        }

        if (from === null || from === undefined){
            throw new Error('Required parameter from was null or undefined when calling sendMail.');
        }

        if (subject === null || subject === undefined){
            throw new Error('Required parameter subject was null or undefined when calling sendMail.');
        }

        if (body === null || body === undefined){
            throw new Error('Required parameter body was null or undefined when calling sendMail.');
        }

        // authentication (apiKeyAuth) required
        if (this.APIConfiguration.apiKeys && this.APIConfiguration.apiKeys['X-API-KEY']) {
            headers['X-API-KEY'] = this.APIConfiguration.apiKeys['X-API-KEY'];
        }
        headers['Accept'] = 'application/json';

        let formData: FormData = new FormData();
        headers['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
        if (to !== undefined) {
            formData.append('to', <any>to);
        }
        if (from !== undefined) {
            formData.append('from', <any>from);
        }
        if (subject !== undefined) {
            formData.append('subject', <any>subject);
        }
        if (body !== undefined) {
            formData.append('body', <any>body);
        }

        const response: Observable<HttpResponse<GenericResponse>> = this.httpClient.post(`${this.basePath}/mail/send`, formData, headers);
        if (observe === 'body') {
               return response.pipe(
                   map((httpResponse: HttpResponse) => <GenericResponse>(httpResponse.response))
               );
        }
        return response;
    }

}