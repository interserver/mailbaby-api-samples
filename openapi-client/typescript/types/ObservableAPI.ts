import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import * as models from '../models/all';
import { Configuration} from '../configuration'
import { Observable, of, from } from '../rxjsStub';
import {mergeMap, map} from  '../rxjsStub';
import { ErrorResponse } from '../models/ErrorResponse';
import { GenericResponse } from '../models/GenericResponse';
import { MailAttachment } from '../models/MailAttachment';
import { MailContact } from '../models/MailContact';
import { MailLog } from '../models/MailLog';
import { MailOrder } from '../models/MailOrder';
import { SendMail } from '../models/SendMail';

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
     * returns information about a mail order in the system with the given id.
     * Gets mail order information by id
     * @param id User ID
     */
    public getMailById(id: number, options?: Configuration): Observable<MailOrder> {
        const requestContextPromise = this.requestFactory.getMailById(id, options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.getMailById(rsp)));
            }));
    }
 
    /**
     * displays a list of mail service orders
     */
    public getMailOrders(options?: Configuration): Observable<Array<MailOrder>> {
        const requestContextPromise = this.requestFactory.getMailOrders(options);

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
    public pingServer(options?: Configuration): Observable<void> {
        const requestContextPromise = this.requestFactory.pingServer(options);

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
     * Adds an item to the system
     * places a mail order
     * @param mailOrder Inventory item to add
     */
    public placeMailOrder(mailOrder?: MailOrder, options?: Configuration): Observable<void> {
        const requestContextPromise = this.requestFactory.placeMailOrder(mailOrder, options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.placeMailOrder(rsp)));
            }));
    }
 
    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param id User ID
     * @param sendMail 
     */
    public sendAdvMailById(id: number, sendMail: SendMail, options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.sendAdvMailById(id, sendMail, options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.sendAdvMailById(rsp)));
            }));
    }
 
    /**
     * Sends An email through one of your mail orders.
     * Sends an Email
     * @param id User ID
     * @param subject 
     * @param body 
     * @param to 
     * @param toName 
     * @param from 
     * @param fromName 
     */
    public sendMailById(id: number, subject?: string, body?: string, to?: string, toName?: string, from?: string, fromName?: string, options?: Configuration): Observable<GenericResponse> {
        const requestContextPromise = this.requestFactory.sendMailById(id, subject, body, to, toName, from, fromName, options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.sendMailById(rsp)));
            }));
    }
 
    /**
     * validatess order details before placing an order
     */
    public validateMailOrder(options?: Configuration): Observable<void> {
        const requestContextPromise = this.requestFactory.validateMailOrder(options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.validateMailOrder(rsp)));
            }));
    }
 
    /**
     * By passing in the appropriate options, you can search for available inventory in the system 
     * displays the mail log
     * @param id User ID
     * @param searchString pass an optional search string for looking up inventory
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     */
    public viewMailLogById(id: number, searchString?: string, skip?: number, limit?: number, options?: Configuration): Observable<Array<MailLog>> {
        const requestContextPromise = this.requestFactory.viewMailLogById(id, searchString, skip, limit, options);

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
                return middlewarePostObservable.pipe(map((rsp: ResponseContext) => this.responseProcessor.viewMailLogById(rsp)));
            }));
    }
 
}
