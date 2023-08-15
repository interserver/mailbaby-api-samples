import { ResponseContext, RequestContext, HttpFile } from '../http/http';
import { Configuration} from '../configuration'

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

import { ObservableBlockingApi } from "./ObservableAPI";
import { BlockingApiRequestFactory, BlockingApiResponseProcessor} from "../apis/BlockingApi";

export interface BlockingApiAddRuleRequest {
    /**
     * The type of deny rule.
     * @type string
     * @memberof BlockingApiaddRule
     */
    type: string
    /**
     * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @type string
     * @memberof BlockingApiaddRule
     */
    data: string
    /**
     * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     * @type string
     * @memberof BlockingApiaddRule
     */
    user?: string
}

export interface BlockingApiDeleteRuleRequest {
    /**
     * The ID of the Rules entry.
     * @type number
     * @memberof BlockingApideleteRule
     */
    ruleId: number
}

export interface BlockingApiDelistBlockRequest {
    /**
     * 
     * @type EmailAddress
     * @memberof BlockingApidelistBlock
     */
    emailAddress: EmailAddress
}

export interface BlockingApiGetMailBlocksRequest {
}

export interface BlockingApiGetRulesRequest {
}

export class ObjectBlockingApi {
    private api: ObservableBlockingApi

    public constructor(configuration: Configuration, requestFactory?: BlockingApiRequestFactory, responseProcessor?: BlockingApiResponseProcessor) {
        this.api = new ObservableBlockingApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     * @param param the request object
     */
    public addRule(param: BlockingApiAddRuleRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.addRule(param.type, param.data, param.user,  options).toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param param the request object
     */
    public deleteRule(param: BlockingApiDeleteRuleRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.deleteRule(param.ruleId,  options).toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param param the request object
     */
    public delistBlock(param: BlockingApiDelistBlockRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.delistBlock(param.emailAddress,  options).toPromise();
    }

    /**
     * displays a list of blocked email addresses
     * @param param the request object
     */
    public getMailBlocks(param: BlockingApiGetMailBlocksRequest = {}, options?: Configuration): Promise<MailBlocks> {
        return this.api.getMailBlocks( options).toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     * @param param the request object
     */
    public getRules(param: BlockingApiGetRulesRequest = {}, options?: Configuration): Promise<Array<DenyRuleRecord>> {
        return this.api.getRules( options).toPromise();
    }

}

import { ObservableHistoryApi } from "./ObservableAPI";
import { HistoryApiRequestFactory, HistoryApiResponseProcessor} from "../apis/HistoryApi";

export interface HistoryApiGetStatsRequest {
}

export interface HistoryApiViewMailLogRequest {
    /**
     * The ID of your mail order this will be sent through.
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    id?: number
    /**
     * originating ip address sending mail
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    origin?: string
    /**
     * mx record mail was sent to
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    mx?: string
    /**
     * from email address
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    _from?: string
    /**
     * to/destination email address
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    to?: string
    /**
     * subject containing this string
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    subject?: string
    /**
     * mail id
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    mailid?: string
    /**
     * number of records to skip for pagination
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    skip?: number
    /**
     * maximum number of records to return
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    limit?: number
    /**
     * earliest date to get emails in unix timestamp format
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    startDate?: number
    /**
     * earliest date to get emails in unix timestamp format
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    endDate?: number
}

export class ObjectHistoryApi {
    private api: ObservableHistoryApi

    public constructor(configuration: Configuration, requestFactory?: HistoryApiRequestFactory, responseProcessor?: HistoryApiResponseProcessor) {
        this.api = new ObservableHistoryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * displays a list of blocked email addresses
     * @param param the request object
     */
    public getStats(param: HistoryApiGetStatsRequest = {}, options?: Configuration): Promise<Array<GetStats200ResponseInner>> {
        return this.api.getStats( options).toPromise();
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param param the request object
     */
    public viewMailLog(param: HistoryApiViewMailLogRequest = {}, options?: Configuration): Promise<MailLog> {
        return this.api.viewMailLog(param.id, param.origin, param.mx, param._from, param.to, param.subject, param.mailid, param.skip, param.limit, param.startDate, param.endDate,  options).toPromise();
    }

}

import { ObservableSendingApi } from "./ObservableAPI";
import { SendingApiRequestFactory, SendingApiResponseProcessor} from "../apis/SendingApi";

export interface SendingApiSendAdvMailRequest {
    /**
     * The subject or title of the email
     * @type string
     * @memberof SendingApisendAdvMail
     */
    subject: string
    /**
     * The main email contents.
     * @type string
     * @memberof SendingApisendAdvMail
     */
    body: string
    /**
     * 
     * @type EmailAddressName
     * @memberof SendingApisendAdvMail
     */
    _from: EmailAddressName
    /**
     * A list of destionation email addresses to send this to
     * @type Array&lt;EmailAddressName&gt;
     * @memberof SendingApisendAdvMail
     */
    to: Array<EmailAddressName>
    /**
     * (optional) A list of email addresses that specify where replies to the email should be sent instead of the _from_ address.
     * @type Array&lt;EmailAddressName&gt;
     * @memberof SendingApisendAdvMail
     */
    replyto?: Array<EmailAddressName>
    /**
     * (optional) A list of email addresses to carbon copy this message to.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well.
     * @type Array&lt;EmailAddressName&gt;
     * @memberof SendingApisendAdvMail
     */
    cc?: Array<EmailAddressName>
    /**
     * (optional) list of email addresses that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list.
     * @type Array&lt;EmailAddressName&gt;
     * @memberof SendingApisendAdvMail
     */
    bcc?: Array<EmailAddressName>
    /**
     * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @type Array&lt;MailAttachment&gt;
     * @memberof SendingApisendAdvMail
     */
    attachments?: Array<MailAttachment>
    /**
     * (optional)  ID of the Mail order within our system to use as the Mail Account.
     * @type number
     * @memberof SendingApisendAdvMail
     */
    id?: number
}

export interface SendingApiSendMailRequest {
    /**
     * The Contact whom is the primary recipient of this email.
     * @type string
     * @memberof SendingApisendMail
     */
    to: string
    /**
     * The contact whom is the this email is from.
     * @type string
     * @memberof SendingApisendMail
     */
    _from: string
    /**
     * The subject or title of the email
     * @type string
     * @memberof SendingApisendMail
     */
    subject: string
    /**
     * The main email contents.
     * @type string
     * @memberof SendingApisendMail
     */
    body: string
}

export class ObjectSendingApi {
    private api: ObservableSendingApi

    public constructor(configuration: Configuration, requestFactory?: SendingApiRequestFactory, responseProcessor?: SendingApiResponseProcessor) {
        this.api = new ObservableSendingApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.
     * Sends an Email with Advanced Options
     * @param param the request object
     */
    public sendAdvMail(param: SendingApiSendAdvMailRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendAdvMail(param.subject, param.body, param._from, param.to, param.replyto, param.cc, param.bcc, param.attachments, param.id,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param param the request object
     */
    public sendMail(param: SendingApiSendMailRequest, options?: Configuration): Promise<GenericResponse> {
        return this.api.sendMail(param.to, param._from, param.subject, param.body,  options).toPromise();
    }

}

import { ObservableServicesApi } from "./ObservableAPI";
import { ServicesApiRequestFactory, ServicesApiResponseProcessor} from "../apis/ServicesApi";

export interface ServicesApiGetMailOrdersRequest {
}

export class ObjectServicesApi {
    private api: ObservableServicesApi

    public constructor(configuration: Configuration, requestFactory?: ServicesApiRequestFactory, responseProcessor?: ServicesApiResponseProcessor) {
        this.api = new ObservableServicesApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     * @param param the request object
     */
    public getMailOrders(param: ServicesApiGetMailOrdersRequest = {}, options?: Configuration): Promise<Array<MailOrder>> {
        return this.api.getMailOrders( options).toPromise();
    }

}

import { ObservableStatusApi } from "./ObservableAPI";
import { StatusApiRequestFactory, StatusApiResponseProcessor} from "../apis/StatusApi";

export interface StatusApiPingServerRequest {
}

export class ObjectStatusApi {
    private api: ObservableStatusApi

    public constructor(configuration: Configuration, requestFactory?: StatusApiRequestFactory, responseProcessor?: StatusApiResponseProcessor) {
        this.api = new ObservableStatusApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Checks if the server is running
     * @param param the request object
     */
    public pingServer(param: StatusApiPingServerRequest = {}, options?: Configuration): Promise<void> {
        return this.api.pingServer( options).toPromise();
    }

}
