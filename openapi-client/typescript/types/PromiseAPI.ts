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
import { SendMailAdv } from '../models/SendMailAdv';
import { SendMailAdvFrom } from '../models/SendMailAdvFrom';
import { ObservableDefaultApi } from './ObservableAPI';

import { DefaultApiRequestFactory, DefaultApiResponseProcessor} from "../apis/DefaultApi";
export class PromiseDefaultApi {
    private api: ObservableDefaultApi

    public constructor(
        configuration: Configuration,
        requestFactory?: DefaultApiRequestFactory,
        responseProcessor?: DefaultApiResponseProcessor
    ) {
        this.api = new ObservableDefaultApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * displays a list of mail service orders
     * @param id The ID of your mail order this will be sent through.
     */
    public getMailOrders(id?: number, options?: Configuration): Promise<Array<MailOrder>> {
        const result = this.api.getMailOrders(id, options);
        return result.toPromise();
    }

    /**
     * Checks if the server is running
     */
    public pingServer(options?: Configuration): Promise<void> {
        const result = this.api.pingServer(options);
        return result.toPromise();
    }

    /**
     * Adds an item to the system
     * places a mail order
     * @param mailOrder Inventory item to add
     */
    public placeMailOrder(mailOrder?: MailOrder, options?: Configuration): Promise<void> {
        const result = this.api.placeMailOrder(mailOrder, options);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param sendMailAdv 
     */
    public sendAdvMail(sendMailAdv: SendMailAdv, options?: Configuration): Promise<GenericResponse> {
        const result = this.api.sendAdvMail(sendMailAdv, options);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders.
     * Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     */
    public sendMail(to?: string, from?: string, subject?: string, body?: string, options?: Configuration): Promise<GenericResponse> {
        const result = this.api.sendMail(to, from, subject, body, options);
        return result.toPromise();
    }

    /**
     * validatess order details before placing an order
     */
    public validateMailOrder(options?: Configuration): Promise<void> {
        const result = this.api.validateMailOrder(options);
        return result.toPromise();
    }

    /**
     * By passing in the appropriate options, you can search for available inventory in the system 
     * displays the mail log
     * @param id The ID of your mail order this will be sent through.
     * @param searchString pass an optional search string for looking up inventory
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     */
    public viewMailLogById(id?: number, searchString?: string, skip?: number, limit?: number, options?: Configuration): Promise<Array<MailLog>> {
        const result = this.api.viewMailLogById(id, searchString, skip, limit, options);
        return result.toPromise();
    }


}



