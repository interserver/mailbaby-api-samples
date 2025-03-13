import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration, ConfigurationOptions } from '../configuration'
import type { Middleware } from '../middleware';

import { DenyRuleNew } from '../models/DenyRuleNew';
import { DenyRuleRecord } from '../models/DenyRuleRecord';
import { EmailAddressName } from '../models/EmailAddressName';
import { EmailAddressTypes } from '../models/EmailAddressTypes';
import { EmailAddressesTypes } from '../models/EmailAddressesTypes';
import { ErrorMessage } from '../models/ErrorMessage';
import { GenericResponse } from '../models/GenericResponse';
import { GetStats200ResponseInner } from '../models/GetStats200ResponseInner';
import { MailAttachment } from '../models/MailAttachment';
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
     * Defaults to: undefined
     * @type string
     * @memberof BlockingApiaddRule
     */
    type: string
    /**
     * The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * Defaults to: undefined
     * @type string
     * @memberof BlockingApiaddRule
     */
    data: string
    /**
     * Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     * Defaults to: undefined
     * @type string
     * @memberof BlockingApiaddRule
     */
    user?: string
}

export interface BlockingApiDeleteRuleRequest {
    /**
     * The ID of the Rules entry.
     * Defaults to: undefined
     * @type number
     * @memberof BlockingApideleteRule
     */
    ruleId: number
}

export interface BlockingApiDelistBlockRequest {
    /**
     * 
     * @type string
     * @memberof BlockingApidelistBlock
     */
    body: string
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
    public addRuleWithHttpInfo(param: BlockingApiAddRuleRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.addRuleWithHttpInfo(param.type, param.data, param.user,  options).toPromise();
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     * @param param the request object
     */
    public addRule(param: BlockingApiAddRuleRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.addRule(param.type, param.data, param.user,  options).toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param param the request object
     */
    public deleteRuleWithHttpInfo(param: BlockingApiDeleteRuleRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.deleteRuleWithHttpInfo(param.ruleId,  options).toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param param the request object
     */
    public deleteRule(param: BlockingApiDeleteRuleRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.deleteRule(param.ruleId,  options).toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param param the request object
     */
    public delistBlockWithHttpInfo(param: BlockingApiDelistBlockRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.delistBlockWithHttpInfo(param.body,  options).toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param param the request object
     */
    public delistBlock(param: BlockingApiDelistBlockRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.delistBlock(param.body,  options).toPromise();
    }

    /**
     * displays a list of blocked email addresses
     * @param param the request object
     */
    public getMailBlocksWithHttpInfo(param: BlockingApiGetMailBlocksRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<MailBlocks>> {
        return this.api.getMailBlocksWithHttpInfo( options).toPromise();
    }

    /**
     * displays a list of blocked email addresses
     * @param param the request object
     */
    public getMailBlocks(param: BlockingApiGetMailBlocksRequest = {}, options?: ConfigurationOptions): Promise<MailBlocks> {
        return this.api.getMailBlocks( options).toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     * @param param the request object
     */
    public getRulesWithHttpInfo(param: BlockingApiGetRulesRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<Array<DenyRuleRecord>>> {
        return this.api.getRulesWithHttpInfo( options).toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     * @param param the request object
     */
    public getRules(param: BlockingApiGetRulesRequest = {}, options?: ConfigurationOptions): Promise<Array<DenyRuleRecord>> {
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
     * Defaults to: undefined
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    id?: number
    /**
     * originating ip address sending mail
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    origin?: string
    /**
     * mx record mail was sent to
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    mx?: string
    /**
     * from email address
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    _from?: string
    /**
     * to/destination email address
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    to?: string
    /**
     * subject containing this string
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    subject?: string
    /**
     * mail id
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    mailid?: string
    /**
     * number of records to skip for pagination
     * Minimum: 0
     * Defaults to: 0
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    skip?: number
    /**
     * maximum number of records to return
     * Minimum: 1
     * Maximum: 10000
     * Defaults to: 100
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    limit?: number
    /**
     * earliest date to get emails in unix timestamp format
     * Minimum: 0
     * Maximum: 9999999999
     * Defaults to: undefined
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    startDate?: number
    /**
     * earliest date to get emails in unix timestamp format
     * Minimum: 0
     * Maximum: 9999999999
     * Defaults to: undefined
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    endDate?: number
    /**
     * Reply-To Email Address
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    replyto?: string
    /**
     * Header From Email Address
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    headerfrom?: string
}

export class ObjectHistoryApi {
    private api: ObservableHistoryApi

    public constructor(configuration: Configuration, requestFactory?: HistoryApiRequestFactory, responseProcessor?: HistoryApiResponseProcessor) {
        this.api = new ObservableHistoryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Returns information about the usage on your mail accounts.
     * Account usage statistics.
     * @param param the request object
     */
    public getStatsWithHttpInfo(param: HistoryApiGetStatsRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<Array<GetStats200ResponseInner>>> {
        return this.api.getStatsWithHttpInfo( options).toPromise();
    }

    /**
     * Returns information about the usage on your mail accounts.
     * Account usage statistics.
     * @param param the request object
     */
    public getStats(param: HistoryApiGetStatsRequest = {}, options?: ConfigurationOptions): Promise<Array<GetStats200ResponseInner>> {
        return this.api.getStats( options).toPromise();
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param param the request object
     */
    public viewMailLogWithHttpInfo(param: HistoryApiViewMailLogRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<MailLog>> {
        return this.api.viewMailLogWithHttpInfo(param.id, param.origin, param.mx, param._from, param.to, param.subject, param.mailid, param.skip, param.limit, param.startDate, param.endDate, param.replyto, param.headerfrom,  options).toPromise();
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param param the request object
     */
    public viewMailLog(param: HistoryApiViewMailLogRequest = {}, options?: ConfigurationOptions): Promise<MailLog> {
        return this.api.viewMailLog(param.id, param.origin, param.mx, param._from, param.to, param.subject, param.mailid, param.skip, param.limit, param.startDate, param.endDate, param.replyto, param.headerfrom,  options).toPromise();
    }

}

import { ObservableSendingApi } from "./ObservableAPI";
import { SendingApiRequestFactory, SendingApiResponseProcessor} from "../apis/SendingApi";

export interface SendingApiSendAdvMailRequest {
    /**
     * The subject or title of the email
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendAdvMail
     */
    subject: string
    /**
     * The main email contents.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendAdvMail
     */
    body: string
    /**
     * 
     * Defaults to: undefined
     * @type EmailAddressTypes
     * @memberof SendingApisendAdvMail
     */
    _from: EmailAddressTypes
    /**
     * 
     * Defaults to: undefined
     * @type EmailAddressesTypes
     * @memberof SendingApisendAdvMail
     */
    to: EmailAddressesTypes
    /**
     * 
     * Defaults to: undefined
     * @type EmailAddressesTypes
     * @memberof SendingApisendAdvMail
     */
    replyto?: EmailAddressesTypes
    /**
     * 
     * Defaults to: undefined
     * @type EmailAddressesTypes
     * @memberof SendingApisendAdvMail
     */
    cc?: EmailAddressesTypes
    /**
     * 
     * Defaults to: undefined
     * @type EmailAddressesTypes
     * @memberof SendingApisendAdvMail
     */
    bcc?: EmailAddressesTypes
    /**
     * (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * Defaults to: undefined
     * @type Array&lt;MailAttachment&gt;
     * @memberof SendingApisendAdvMail
     */
    attachments?: Array<MailAttachment>
    /**
     * (optional)  ID of the Mail order within our system to use as the Mail Account.
     * Defaults to: undefined
     * @type number
     * @memberof SendingApisendAdvMail
     */
    id?: number
}

export interface SendingApiSendMailRequest {
    /**
     * The Contact whom is the primary recipient of this email.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendMail
     */
    to: string
    /**
     * The contact whom is the this email is from.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendMail
     */
    _from: string
    /**
     * The subject or title of the email
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendMail
     */
    subject: string
    /**
     * The main email contents.
     * Defaults to: undefined
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
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param param the request object
     */
    public sendAdvMailWithHttpInfo(param: SendingApiSendAdvMailRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.sendAdvMailWithHttpInfo(param.subject, param.body, param._from, param.to, param.replyto, param.cc, param.bcc, param.attachments, param.id,  options).toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param param the request object
     */
    public sendAdvMail(param: SendingApiSendAdvMailRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.sendAdvMail(param.subject, param.body, param._from, param.to, param.replyto, param.cc, param.bcc, param.attachments, param.id,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param param the request object
     */
    public sendMailWithHttpInfo(param: SendingApiSendMailRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.sendMailWithHttpInfo(param.to, param._from, param.subject, param.body,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param param the request object
     */
    public sendMail(param: SendingApiSendMailRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
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
    public getMailOrdersWithHttpInfo(param: ServicesApiGetMailOrdersRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<Array<MailOrder>>> {
        return this.api.getMailOrdersWithHttpInfo( options).toPromise();
    }

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     * @param param the request object
     */
    public getMailOrders(param: ServicesApiGetMailOrdersRequest = {}, options?: ConfigurationOptions): Promise<Array<MailOrder>> {
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
    public pingServerWithHttpInfo(param: StatusApiPingServerRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<void>> {
        return this.api.pingServerWithHttpInfo( options).toPromise();
    }

    /**
     * Checks if the server is running
     * @param param the request object
     */
    public pingServer(param: StatusApiPingServerRequest = {}, options?: ConfigurationOptions): Promise<void> {
        return this.api.pingServer( options).toPromise();
    }

}
