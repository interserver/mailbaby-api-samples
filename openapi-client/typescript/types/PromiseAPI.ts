import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import * as models from '../models/all';
import { Configuration} from '../configuration'

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
     */
    public getMailOrders(_options?: Configuration): Promise<Array<GetMailOrders200ResponseInner>> {
        const result = this.api.getMailOrders(_options);
        return result.toPromise();
    }

    /**
     * Checks if the server is running
     */
    public pingServer(_options?: Configuration): Promise<void> {
        const result = this.api.pingServer(_options);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param sendMailAdv 
     */
    public sendAdvMail(sendMailAdv: SendMailAdv, _options?: Configuration): Promise<GenericResponse> {
        const result = this.api.sendAdvMail(sendMailAdv, _options);
        return result.toPromise();
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param _from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     */
    public sendMail(to: string, _from: string, subject: string, body: string, _options?: Configuration): Promise<GenericResponse> {
        const result = this.api.sendMail(to, _from, subject, body, _options);
        return result.toPromise();
    }

    /**
     * By passing in the appropriate options, you can search for available inventory in the system 
     * displays the mail log
     * @param id The ID of your mail order this will be sent through.
     * @param search pass an optional search string for looking up inventory
     * @param skip number of records to skip for pagination
     * @param limit maximum number of records to return
     */
    public viewMailLog(id?: number, search?: string, skip?: number, limit?: number, _options?: Configuration): Promise<MailLog> {
        const result = this.api.viewMailLog(id, search, skip, limit, _options);
        return result.toPromise();
    }


}



