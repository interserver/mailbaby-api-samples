import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
import { DenyRuleNew } from '../models/DenyRuleNew';
import { DenyRuleRecord } from '../models/DenyRuleRecord';
import { DenyRuleRecordAllOf } from '../models/DenyRuleRecordAllOf';
import { EmailAddress } from '../models/EmailAddress';
import { GenericResponse } from '../models/GenericResponse';
import { GetMailOrders401Response } from '../models/GetMailOrders401Response';
import { GetStats200ResponseInner } from '../models/GetStats200ResponseInner';
import { MailBlockClickHouse } from '../models/MailBlockClickHouse';
import { MailBlockRspamd } from '../models/MailBlockRspamd';
import { MailBlocks } from '../models/MailBlocks';
import { MailLog } from '../models/MailLog';
import { MailLogEntry } from '../models/MailLogEntry';
import { MailOrder } from '../models/MailOrder';
import { SendMail } from '../models/SendMail';
import { SendMailAdv } from '../models/SendMailAdv';

import { BlockingApiRequestFactory, BlockingApiResponseProcessor} from "../apis/BlockingApi";
export class ObservableBlockingApi {
    private requestFactory: BlockingApiRequestFactory;
    private responseProcessor: BlockingApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: BlockingApiRequestFactory,
        responseProcessor?: BlockingApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new BlockingApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new BlockingApiResponseProcessor();
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     * @param type The type of deny rule.
     * @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    public addRule(type: string, data: string, user?: string, _options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.addRule(type, data, user, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.addRule(rsp)));
            }));
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param ruleId The ID of the Rules entry.
     */
    public deleteRule(ruleId: number, _options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.deleteRule(ruleId, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.deleteRule(rsp)));
            }));
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param emailAddress 
     */
    public delistBlock(emailAddress: EmailAddress, _options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.delistBlock(emailAddress, _options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.delistBlock(rsp)));
            }));
    }

    /**
     * displays a list of blocked email addresses
     */
    public getMailBlocks(_options?: Configuration): Observable<MailBlocks> {
        const requestContextPromise = this.requestFactory.getMailBlocks(_options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getMailBlocks(rsp)));
            }));
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     */
    public getRules(_options?: Configuration): Observable<Array<DenyRuleRecord>> {
        const requestContextPromise = this.requestFactory.getRules(_options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getRules(rsp)));
            }));
    }

}

import { HistoryApiRequestFactory, HistoryApiResponseProcessor} from "../apis/HistoryApi";
export class ObservableHistoryApi {
    private requestFactory: HistoryApiRequestFactory;
    private responseProcessor: HistoryApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: HistoryApiRequestFactory,
        responseProcessor?: HistoryApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new HistoryApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new HistoryApiResponseProcessor();
    }

    /**
     * displays a list of blocked email addresses
     */
    public getStats(_options?: Configuration): Observable<Array<GetStats200ResponseInner>> {
        const requestContextPromise = this.requestFactory.getStats(_options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getStats(rsp)));
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

import { SendingApiRequestFactory, SendingApiResponseProcessor} from "../apis/SendingApi";
export class ObservableSendingApi {
    private requestFactory: SendingApiRequestFactory;
    private responseProcessor: SendingApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: SendingApiRequestFactory,
        responseProcessor?: SendingApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new SendingApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new SendingApiResponseProcessor();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param _from 
     * @param to A list of destionation email addresses to send this to
     * @param replyto (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
     * @param cc (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     * @param bcc (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public sendAdvMail(subject: string, body: string, _from: EmailAddressName, to: Array<EmailAddressName>, replyto?: Array<EmailAddressName>, cc?: Array<EmailAddressName>, bcc?: Array<EmailAddressName>, attachments?: Array<MailAttachment>, id?: number, _options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.sendAdvMail(subject, body, _from, to, replyto, cc, bcc, attachments, id, _options);

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

}

import { ServicesApiRequestFactory, ServicesApiResponseProcessor} from "../apis/ServicesApi";
export class ObservableServicesApi {
    private requestFactory: ServicesApiRequestFactory;
    private responseProcessor: ServicesApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: ServicesApiRequestFactory,
        responseProcessor?: ServicesApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new ServicesApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new ServicesApiResponseProcessor();
    }

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     */
    public getMailOrders(_options?: Configuration): Observable<Array<MailOrder>> {
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

}

import { StatusApiRequestFactory, StatusApiResponseProcessor} from "../apis/StatusApi";
export class ObservableStatusApi {
    private requestFactory: StatusApiRequestFactory;
    private responseProcessor: StatusApiResponseProcessor;
    private configuration: Configuration;

    public constructor(
        configuration: Configuration,
        requestFactory?: StatusApiRequestFactory,
        responseProcessor?: StatusApiResponseProcessor
    ) {
        this.configuration = configuration;
        this.requestFactory = requestFactory || new StatusApiRequestFactory(configuration);
        this.responseProcessor = responseProcessor || new StatusApiResponseProcessor();
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

}
