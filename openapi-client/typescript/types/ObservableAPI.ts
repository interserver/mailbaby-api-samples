import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import * as models from '../models/all';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
import { GenericResponse } from '../models/GenericResponse';
import { GetMailOrders200ResponseInner } from '../models/GetMailOrders200ResponseInner';
import { GetMailOrders401Response } from '../models/GetMailOrders401Response';
import { MailLog } from '../models/MailLog';
import { MailLogEntry } from '../models/MailLogEntry';
import { SendMail } from '../models/SendMail';
import { SendMailAdv } from '../models/SendMailAdv';
import { SendMailAdvAttachmentsInner } from '../models/SendMailAdvAttachmentsInner';
import { SendMailAdvBccInner } from '../models/SendMailAdvBccInner';
import { SendMailAdvCcInner } from '../models/SendMailAdvCcInner';
import { SendMailAdvFrom } from '../models/SendMailAdvFrom';
import { SendMailAdvReplytoInner } from '../models/SendMailAdvReplytoInner';
import { SendMailAdvToInner } from '../models/SendMailAdvToInner';

import { DefaultApiRequestFactory, DefaultApiResponseProcessor} from "../apis/DefaultApi";
export class ObservableDefaultApi {
    private requestFactory: DefaultApiRequestFactory;
    private responseProcessor: DefaultApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: DefaultApiRequestFactory,
        responseProcessor?: DefaultApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new DefaultApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new DefaultApiResponseProcessor();
    }

    /**
     * displays a list of mail service orders
     */
    public getMailOrders(_options?: Configuration): Observable<Array<GetMailOrders200ResponseInner>> {
        const requestContextPromise = this.requestFactory.getMailOrders(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getMailOrders(rsp)));
            }));
    }

    /**
     * Checks if the server is running
     */
    public pingServer(_options?: Configuration): Observable<void> {
        const requestContextPromise = this.requestFactory.pingServer(_options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.pingServer(rsp)));
            }));
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param sendMailAdv 
     */
    public sendAdvMail(sendMailAdv: SendMailAdv, _options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.sendAdvMail(sendMailAdv, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.sendAdvMail(rsp)));
            }));
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param _from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     */
    public sendMail(to: string, _from: string, subject: string, body: string, _options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.sendMail(to, _from, subject, body, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.sendMail(rsp)));
            }));
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param id The ID of your mail order this will be sent through.
     * @param origin originating ip address sending mail
     * @param mx mx record mail was sent to
     * @param _from from email address
     * @param to to/destination email address
     * @param subject subject containing this string
     * @param mailid mail id
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     * @param startDate earliest date to get emails in unix timestamp format
     * @param endDate earliest date to get emails in unix timestamp format
     */
    public viewMailLog(id?: number, origin?: string, mx?: string, _from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, _options?: Configuration): Observable<MailLog> {
        const requestContextPromise = this.requestFactory.viewMailLog(id, origin, mx, _from, to, subject, mailid, skip, limit, startDate, endDate, _options);

        // build promise chain
        let middlewarePreObservable = from<RequestContext>(requestContextPromise);
        for (let middleware of this.configuration.middleware) {
            middlewarePreObservable = middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => middleware.pre(ctx)));
        }

        return middlewarePreObservable.pipe(mergeMap((ctx: RequestContext) => this.configuration.httpApi.send(ctx))).
            pipe(mergeMap((response: ResponseContext) => {
                let middlewarePostObservable = of(response);
                for (let middleware of this.configuration.middleware) {
                    middlewarePostObservable = middlewarePostObservable.pipe(mergeMap((rsp: ResponseContext) => middleware.post(rsp)));
                }
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.viewMailLog(rsp)));
            }));
    }

}
