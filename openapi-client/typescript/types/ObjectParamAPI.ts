import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import * as models from '../models/all';
import { Configuration} from '../configuration'

import { ErrorResponse } from '../models/ErrorResponse';
import { GenericResponse } from '../models/GenericResponse';
import { MailAttachment } from '../models/MailAttachment';
import { MailContact } from '../models/MailContact';
import { MailLog } from '../models/MailLog';
import { MailOrder } from '../models/MailOrder';
import { SendMail } from '../models/SendMail';
import { SendMailFrom } from '../models/SendMailFrom';

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

export interface DefaultApiSendAdvMailByIdRequest {
    /**
     * 
     * @type SendMail
     * @memberof DefaultApisendAdvMailById
     */
    sendMail: SendMail
}

export interface DefaultApiSendMailByIdRequest {
    /**
     * 
     * @type SendMail
     * @memberof DefaultApisendMailById
     */
    sendMail: SendMail
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
    public sendAdvMailById(param: DefaultApiSendAdvMailByIdRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendAdvMailById(param.sendMail,  options).toPromise();
    }

    /**
     * Sends An email through one of your mail orders.
     * Sends an Email
     * @param param the request object
     */
    public sendMailById(param: DefaultApiSendMailByIdRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendMailById(param.sendMail,  options).toPromise();
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
