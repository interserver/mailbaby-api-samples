import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import * as models from '../models/all';
import { Configuration} from '../configuration'

import { Body1 } from '../models/Body1';
import { ErrorResponse } from '../models/ErrorResponse';
import { GenericResponse } from '../models/GenericResponse';
import { MailAttachment } from '../models/MailAttachment';
import { MailContact } from '../models/MailContact';
import { MailLog } from '../models/MailLog';
import { MailOrder } from '../models/MailOrder';
import { SendMailAdv } from '../models/SendMailAdv';
import { SendMailAdvFrom } from '../models/SendMailAdvFrom';

import { ObservableDefaultApi } from "./ObservableAPI";
import { DefaultApiRequestFactory, DefaultApiResponseProcessor} from "../apis/DefaultApi";

export interface DefaultApiGetMailOrdersRequest {
    /**
     * The ID of your mail order this will be sent through.
     * @type number
     * @memberof DefaultApigetMailOrders
     */
    id?: number
}

export interface DefaultApiPingServerRequest {
}

export interface DefaultApiPlaceMailOrderRequest {
    /**
     * Inventory item to add
     * @type MailOrder
     * @memberof DefaultApiplaceMailOrder
     */
    mailOrder?: MailOrder
}

export interface DefaultApiSendAdvMailRequest {
    /**
     * 
     * @type SendMailAdv
     * @memberof DefaultApisendAdvMail
     */
    sendMailAdv: SendMailAdv
}

export interface DefaultApiSendMailRequest {
    /**
     * The Contact whom is the primary recipient of this email.
     * @type string
     * @memberof DefaultApisendMail
     */
    to?: string
    /**
     * The contact whom is the this email is from.
     * @type string
     * @memberof DefaultApisendMail
     */
    from?: string
    /**
     * The subject or title of the email
     * @type string
     * @memberof DefaultApisendMail
     */
    subject?: string
    /**
     * The main email contents.
     * @type string
     * @memberof DefaultApisendMail
     */
    body?: string
}

export interface DefaultApiValidateMailOrderRequest {
}

export interface DefaultApiViewMailLogByIdRequest {
    /**
     * The ID of your mail order this will be sent through.
     * @type number
     * @memberof DefaultApiviewMailLogById
     */
    id?: number
    /**
     * pass an optional search string for looking up inventory
     * @type string
     * @memberof DefaultApiviewMailLogById
     */
    searchString?: string
    /**
     * number of records to skip for pagination
     * @type number
     * @memberof DefaultApiviewMailLogById
     */
    skip?: number
    /**
     * maximum number of records to return
     * @type number
     * @memberof DefaultApiviewMailLogById
     */
    limit?: number
}

export class ObjectDefaultApi {
    private api: ObservableDefaultApi

    public constructor(configuration: Configuration, requestFactory?: DefaultApiRequestFactory, responseProcessor?: DefaultApiResponseProcessor) {
        this.api = new ObservableDefaultApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * displays a list of mail service orders
     * @param param the request object
     */
    public getMailOrders(param: DefaultApiGetMailOrdersRequest, options?: Configuration): Promise<Array<MailOrder>> {
        return this.api.getMailOrders(param.id,  options).toPromise();
    }

    /**
     * Checks if the server is running
     * @param param the request object
     */
    public pingServer(param: DefaultApiPingServerRequest, options?: Configuration): Promise<void> {
        return this.api.pingServer( options).toPromise();
    }

    /**
     * Adds an item to the system
     * places a mail order
     * @param param the request object
     */
    public placeMailOrder(param: DefaultApiPlaceMailOrderRequest, options?: Configuration): Promise<void> {
        return this.api.placeMailOrder(param.mailOrder,  options).toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param param the request object
     */
    public sendAdvMail(param: DefaultApiSendAdvMailRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendAdvMail(param.sendMailAdv,  options).toPromise();
    }

    /**
     * Sends An email through one of your mail orders.
     * Sends an Email
     * @param param the request object
     */
    public sendMail(param: DefaultApiSendMailRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendMail(param.to, param.from, param.subject, param.body,  options).toPromise();
    }

    /**
     * validatess order details before placing an order
     * @param param the request object
     */
    public validateMailOrder(param: DefaultApiValidateMailOrderRequest, options?: Configuration): Promise<void> {
        return this.api.validateMailOrder( options).toPromise();
    }

    /**
     * By passing in the appropriate options, you can search for available inventory in the system 
     * displays the mail log
     * @param param the request object
     */
    public viewMailLogById(param: DefaultApiViewMailLogByIdRequest, options?: Configuration): Promise<Array<MailLog>> {
        return this.api.viewMailLogById(param.id, param.searchString, param.skip, param.limit,  options).toPromise();
    }

}
