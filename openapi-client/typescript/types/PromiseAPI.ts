import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration} from '../configuration'

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
import { ObservableBlockingApi } from './ObservableAPI';

import { BlockingApiRequestFactory, BlockingApiResponseProcessor} from "../apis/BlockingApi";
export class PromiseBlockingApi {
    private api: ObservableBlockingApi

    public constructor(
        configuration: Configuration,
        requestFactory?: BlockingApiRequestFactory,
        responseProcessor?: BlockingApiResponseProcessor
    ) {
        this.api = new ObservableBlockingApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     * @param type The type of deny rule.
     * @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    public addRuleWithHttpInfo(type: string, data: string, user?: string, _options?: Configuration): Promise<HttpInfo<GenericResponse>> {
        const result = this.api.addRuleWithHttpInfo(type, data, user, _options);
        return result.toPromise();
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     * @param type The type of deny rule.
     * @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @param user Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    public addRule(type: string, data: string, user?: string, _options?: Configuration): Promise<GenericResponse> {
        const result = this.api.addRule(type, data, user, _options);
        return result.toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param ruleId The ID of the Rules entry.
     */
    public deleteRuleWithHttpInfo(ruleId: number, _options?: Configuration): Promise<HttpInfo<GenericResponse>> {
        const result = this.api.deleteRuleWithHttpInfo(ruleId, _options);
        return result.toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param ruleId The ID of the Rules entry.
     */
    public deleteRule(ruleId: number, _options?: Configuration): Promise<GenericResponse> {
        const result = this.api.deleteRule(ruleId, _options);
        return result.toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param body 
     */
    public delistBlockWithHttpInfo(body: string, _options?: Configuration): Promise<HttpInfo<GenericResponse>> {
        const result = this.api.delistBlockWithHttpInfo(body, _options);
        return result.toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param body 
     */
    public delistBlock(body: string, _options?: Configuration): Promise<GenericResponse> {
        const result = this.api.delistBlock(body, _options);
        return result.toPromise();
    }

    /**
     * displays a list of blocked email addresses
     */
    public getMailBlocksWithHttpInfo(_options?: Configuration): Promise<HttpInfo<MailBlocks>> {
        const result = this.api.getMailBlocksWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * displays a list of blocked email addresses
     */
    public getMailBlocks(_options?: Configuration): Promise<MailBlocks> {
        const result = this.api.getMailBlocks(_options);
        return result.toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     */
    public getRulesWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<DenyRuleRecord>>> {
        const result = this.api.getRulesWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     */
    public getRules(_options?: Configuration): Promise<Array<DenyRuleRecord>> {
        const result = this.api.getRules(_options);
        return result.toPromise();
    }


}



import { ObservableHistoryApi } from './ObservableAPI';

import { HistoryApiRequestFactory, HistoryApiResponseProcessor} from "../apis/HistoryApi";
export class PromiseHistoryApi {
    private api: ObservableHistoryApi

    public constructor(
        configuration: Configuration,
        requestFactory?: HistoryApiRequestFactory,
        responseProcessor?: HistoryApiResponseProcessor
    ) {
        this.api = new ObservableHistoryApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Returns information about the usage on your mail accounts.
     * Account usage statistics.
     */
    public getStatsWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<GetStats200ResponseInner>>> {
        const result = this.api.getStatsWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Returns information about the usage on your mail accounts.
     * Account usage statistics.
     */
    public getStats(_options?: Configuration): Promise<Array<GetStats200ResponseInner>> {
        const result = this.api.getStats(_options);
        return result.toPromise();
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
     * @param replyto Reply-To Email Address
     * @param headerfrom Header From Email Address
     */
    public viewMailLogWithHttpInfo(id?: number, origin?: string, mx?: string, _from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, replyto?: string, headerfrom?: string, _options?: Configuration): Promise<HttpInfo<MailLog>> {
        const result = this.api.viewMailLogWithHttpInfo(id, origin, mx, _from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, _options);
        return result.toPromise();
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
     * @param replyto Reply-To Email Address
     * @param headerfrom Header From Email Address
     */
    public viewMailLog(id?: number, origin?: string, mx?: string, _from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, replyto?: string, headerfrom?: string, _options?: Configuration): Promise<MailLog> {
        const result = this.api.viewMailLog(id, origin, mx, _from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, _options);
        return result.toPromise();
    }


}



import { ObservableSendingApi } from './ObservableAPI';

import { SendingApiRequestFactory, SendingApiResponseProcessor} from "../apis/SendingApi";
export class PromiseSendingApi {
    private api: ObservableSendingApi

    public constructor(
        configuration: Configuration,
        requestFactory?: SendingApiRequestFactory,
        responseProcessor?: SendingApiResponseProcessor
    ) {
        this.api = new ObservableSendingApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param _from 
     * @param to 
     * @param replyto 
     * @param cc 
     * @param bcc 
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public sendAdvMailWithHttpInfo(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto?: EmailAddressesTypes, cc?: EmailAddressesTypes, bcc?: EmailAddressesTypes, attachments?: Array<MailAttachment>, id?: number, _options?: Configuration): Promise<HttpInfo<GenericResponse>> {
        const result = this.api.sendAdvMailWithHttpInfo(subject, body, _from, to, replyto, cc, bcc, attachments, id, _options);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param _from 
     * @param to 
     * @param replyto 
     * @param cc 
     * @param bcc 
     * @param attachments (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param id (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public sendAdvMail(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto?: EmailAddressesTypes, cc?: EmailAddressesTypes, bcc?: EmailAddressesTypes, attachments?: Array<MailAttachment>, id?: number, _options?: Configuration): Promise<GenericResponse> {
        const result = this.api.sendAdvMail(subject, body, _from, to, replyto, cc, bcc, attachments, id, _options);
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
    public sendMailWithHttpInfo(to: string, _from: string, subject: string, body: string, _options?: Configuration): Promise<HttpInfo<GenericResponse>> {
        const result = this.api.sendMailWithHttpInfo(to, _from, subject, body, _options);
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


}



import { ObservableServicesApi } from './ObservableAPI';

import { ServicesApiRequestFactory, ServicesApiResponseProcessor} from "../apis/ServicesApi";
export class PromiseServicesApi {
    private api: ObservableServicesApi

    public constructor(
        configuration: Configuration,
        requestFactory?: ServicesApiRequestFactory,
        responseProcessor?: ServicesApiResponseProcessor
    ) {
        this.api = new ObservableServicesApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     */
    public getMailOrdersWithHttpInfo(_options?: Configuration): Promise<HttpInfo<Array<MailOrder>>> {
        const result = this.api.getMailOrdersWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     */
    public getMailOrders(_options?: Configuration): Promise<Array<MailOrder>> {
        const result = this.api.getMailOrders(_options);
        return result.toPromise();
    }


}



import { ObservableStatusApi } from './ObservableAPI';

import { StatusApiRequestFactory, StatusApiResponseProcessor} from "../apis/StatusApi";
export class PromiseStatusApi {
    private api: ObservableStatusApi

    public constructor(
        configuration: Configuration,
        requestFactory?: StatusApiRequestFactory,
        responseProcessor?: StatusApiResponseProcessor
    ) {
        this.api = new ObservableStatusApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Checks if the server is running
     */
    public pingServerWithHttpInfo(_options?: Configuration): Promise<HttpInfo<void>> {
        const result = this.api.pingServerWithHttpInfo(_options);
        return result.toPromise();
    }

    /**
     * Checks if the server is running
     */
    public pingServer(_options?: Configuration): Promise<void> {
        const result = this.api.pingServer(_options);
        return result.toPromise();
    }


}



