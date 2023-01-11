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

import { ObservableDefaultApi } from "./ObservableAPI";
import { DefaultApiRequestFactory, DefaultApiResponseProcessor} from "../apis/DefaultApi";

export interface DefaultApiGetMailOrdersRequest {
}

export interface DefaultApiPingServerRequest {
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
    to: string
    /**
     * The contact whom is the this email is from.
     * @type string
     * @memberof DefaultApisendMail
     */
    _from: string
    /**
     * The subject or title of the email
     * @type string
     * @memberof DefaultApisendMail
     */
    subject: string
    /**
     * The main email contents.
     * @type string
     * @memberof DefaultApisendMail
     */
    body: string
}

export interface DefaultApiViewMailLogRequest {
    /**
     * The ID of your mail order this will be sent through.
     * @type number
     * @memberof DefaultApiviewMailLog
     */
    id?: number
    /**
     * originating ip address sending mail
     * @type string
     * @memberof DefaultApiviewMailLog
     */
    origin?: string
    /**
     * mx record mail was sent to
     * @type string
     * @memberof DefaultApiviewMailLog
     */
    mx?: string
    /**
     * from email address
     * @type string
     * @memberof DefaultApiviewMailLog
     */
    _from?: string
    /**
     * to/destination email address
     * @type string
     * @memberof DefaultApiviewMailLog
     */
    to?: string
    /**
     * subject containing this string
     * @type string
     * @memberof DefaultApiviewMailLog
     */
    subject?: string
    /**
     * mail id
     * @type string
     * @memberof DefaultApiviewMailLog
     */
    mailid?: string
    /**
     * number of records to skip for pagination
     * @type number
     * @memberof DefaultApiviewMailLog
     */
    skip?: number
    /**
     * maximum number of records to return
     * @type number
     * @memberof DefaultApiviewMailLog
     */
    limit?: number
    /**
     * earliest date to get emails in unix timestamp format
     * @type number
     * @memberof DefaultApiviewMailLog
     */
    startDate?: number
    /**
     * earliest date to get emails in unix timestamp format
     * @type number
     * @memberof DefaultApiviewMailLog
     */
    endDate?: number
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
    public getMailOrders(param: DefaultApiGetMailOrdersRequest = {}, options?: Configuration): Promise<Array<GetMailOrders200ResponseInner>> {
        return this.api.getMailOrders( options).toPromise();
    }

    /**
     * Checks if the server is running
     * @param param the request object
     */
    public pingServer(param: DefaultApiPingServerRequest = {}, options?: Configuration): Promise<void> {
        return this.api.pingServer( options).toPromise();
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
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param param the request object
     */
    public sendMail(param: DefaultApiSendMailRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendMail(param.to, param._from, param.subject, param.body,  options).toPromise();
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param param the request object
     */
    public viewMailLog(param: DefaultApiViewMailLogRequest = {}, options?: Configuration): Promise<MailLog> {
        return this.api.viewMailLog(param.id, param.origin, param.mx, param._from, param.to, param.subject, param.mailid, param.skip, param.limit, param.startDate, param.endDate,  options).toPromise();
    }

}
