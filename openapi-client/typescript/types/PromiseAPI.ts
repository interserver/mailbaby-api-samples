import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration, PromiseConfigurationOptions, wrapOptions } from '../configuration'
import { PromiseMiddleware, Middleware, PromiseMiddlewareWrapper } from '../middleware';

import { DenyRuleNew } from '../models/DenyRuleNew';
import { DenyRuleRecord } from '../models/DenyRuleRecord';
import { EmailAddressName } from '../models/EmailAddressName';
import { EmailAddressTypes } from '../models/EmailAddressTypes';
import { EmailAddressesTypes } from '../models/EmailAddressesTypes';
import { ErrorMessage } from '../models/ErrorMessage';
import { GenericResponse } from '../models/GenericResponse';
import { MailAttachment } from '../models/MailAttachment';
import { MailBlockClickHouse } from '../models/MailBlockClickHouse';
import { MailBlockRspamd } from '../models/MailBlockRspamd';
import { MailBlocks } from '../models/MailBlocks';
import { MailLog } from '../models/MailLog';
import { MailLogEntry } from '../models/MailLogEntry';
import { MailOrder } from '../models/MailOrder';
import { MailStatsType } from '../models/MailStatsType';
import { MailStatsTypeVolume } from '../models/MailStatsTypeVolume';
import { MailStatsTypeVolumeFrom } from '../models/MailStatsTypeVolumeFrom';
import { MailStatsTypeVolumeIp } from '../models/MailStatsTypeVolumeIp';
import { MailStatsTypeVolumeTo } from '../models/MailStatsTypeVolumeTo';
import { SendMail } from '../models/SendMail';
import { SendMailAdv } from '../models/SendMailAdv';
import { SendMailRaw } from '../models/SendMailRaw';
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
     * @param [user] Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    public addRuleWithHttpInfo(type: string, data: string, user?: string, _options?: PromiseConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.addRuleWithHttpInfo(type, data, user, observableOptions);
        return result.toPromise();
    }

    /**
     * Adds a new email deny rule into the system to block new emails that match the given criteria
     * Creates a new email deny rule.
     * @param type The type of deny rule.
     * @param data The content of the rule.  If a domain type rule then an example would be google.com. For a begins with type an example would be msgid-.  For the email typer an example would be user@server.com.
     * @param [user] Mail account username that will be tied to this rule.  If not specified the first active mail order will be used.
     */
    public addRule(type: string, data: string, user?: string, _options?: PromiseConfigurationOptions): Promise<GenericResponse> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.addRule(type, data, user, observableOptions);
        return result.toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param ruleId The ID of the Rules entry.
     */
    public deleteRuleWithHttpInfo(ruleId: number, _options?: PromiseConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.deleteRuleWithHttpInfo(ruleId, observableOptions);
        return result.toPromise();
    }

    /**
     * Removes one of the configured deny mail rules from the system.
     * Removes an deny mail rule.
     * @param ruleId The ID of the Rules entry.
     */
    public deleteRule(ruleId: number, _options?: PromiseConfigurationOptions): Promise<GenericResponse> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.deleteRule(ruleId, observableOptions);
        return result.toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param body
     */
    public delistBlockWithHttpInfo(body: string, _options?: PromiseConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.delistBlockWithHttpInfo(body, observableOptions);
        return result.toPromise();
    }

    /**
     * Removes an email address from the various block lists. 
     * Removes an email address from the blocked list
     * @param body
     */
    public delistBlock(body: string, _options?: PromiseConfigurationOptions): Promise<GenericResponse> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.delistBlock(body, observableOptions);
        return result.toPromise();
    }

    /**
     * displays a list of blocked email addresses
     */
    public getMailBlocksWithHttpInfo(_options?: PromiseConfigurationOptions): Promise<HttpInfo<MailBlocks>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getMailBlocksWithHttpInfo(observableOptions);
        return result.toPromise();
    }

    /**
     * displays a list of blocked email addresses
     */
    public getMailBlocks(_options?: PromiseConfigurationOptions): Promise<MailBlocks> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getMailBlocks(observableOptions);
        return result.toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     */
    public getRulesWithHttpInfo(_options?: PromiseConfigurationOptions): Promise<HttpInfo<Array<DenyRuleRecord>>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getRulesWithHttpInfo(observableOptions);
        return result.toPromise();
    }

    /**
     * Returns a listing of all the deny block rules you have configured.
     * Displays a listing of deny email rules.
     */
    public getRules(_options?: PromiseConfigurationOptions): Promise<Array<DenyRuleRecord>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getRules(observableOptions);
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
     * @param [time] The timeframe for the statistics.
     */
    public getStatsWithHttpInfo(time?: 'all' | 'billing' | 'month' | '7d' | '24h' | '1d' | '1h', _options?: PromiseConfigurationOptions): Promise<HttpInfo<MailStatsType>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getStatsWithHttpInfo(time, observableOptions);
        return result.toPromise();
    }

    /**
     * Returns information about the usage on your mail accounts.
     * Account usage statistics.
     * @param [time] The timeframe for the statistics.
     */
    public getStats(time?: 'all' | 'billing' | 'month' | '7d' | '24h' | '1d' | '1h', _options?: PromiseConfigurationOptions): Promise<MailStatsType> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getStats(time, observableOptions);
        return result.toPromise();
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param [id] The ID of your mail order this will be sent through.
     * @param [origin] originating ip address sending mail
     * @param [mx] mx record mail was sent to
     * @param [_from] from email address
     * @param [to] to/destination email address
     * @param [subject] subject containing this string
     * @param [mailid] mail id
     * @param [skip] number of records to skip for pagination
     * @param [limit] maximum number of records to return
     * @param [startDate] earliest date to get emails in unix timestamp format
     * @param [endDate] earliest date to get emails in unix timestamp format
     * @param [replyto] Reply-To Email Address
     * @param [headerfrom] Header From Email Address
     * @param [delivered] Limiting the emails to wether or not they were delivered.
     */
    public viewMailLogWithHttpInfo(id?: number, origin?: string, mx?: string, _from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, replyto?: string, headerfrom?: string, delivered?: '0' | '1', _options?: PromiseConfigurationOptions): Promise<HttpInfo<MailLog>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.viewMailLogWithHttpInfo(id, origin, mx, _from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered, observableOptions);
        return result.toPromise();
    }

    /**
     * Get a listing of the emails sent through this system 
     * displays the mail log
     * @param [id] The ID of your mail order this will be sent through.
     * @param [origin] originating ip address sending mail
     * @param [mx] mx record mail was sent to
     * @param [_from] from email address
     * @param [to] to/destination email address
     * @param [subject] subject containing this string
     * @param [mailid] mail id
     * @param [skip] number of records to skip for pagination
     * @param [limit] maximum number of records to return
     * @param [startDate] earliest date to get emails in unix timestamp format
     * @param [endDate] earliest date to get emails in unix timestamp format
     * @param [replyto] Reply-To Email Address
     * @param [headerfrom] Header From Email Address
     * @param [delivered] Limiting the emails to wether or not they were delivered.
     */
    public viewMailLog(id?: number, origin?: string, mx?: string, _from?: string, to?: string, subject?: string, mailid?: string, skip?: number, limit?: number, startDate?: number, endDate?: number, replyto?: string, headerfrom?: string, delivered?: '0' | '1', _options?: PromiseConfigurationOptions): Promise<MailLog> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.viewMailLog(id, origin, mx, _from, to, subject, mailid, skip, limit, startDate, endDate, replyto, headerfrom, delivered, observableOptions);
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
     * This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.
     * Sends a raw email
     * @param sendMailRaw
     */
    public rawMailWithHttpInfo(sendMailRaw: SendMailRaw, _options?: PromiseConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.rawMailWithHttpInfo(sendMailRaw, observableOptions);
        return result.toPromise();
    }

    /**
     * This call will let you pass the raw / complete email contents (including headers) as a string and have it get sent as-is.  This is useful for things like DKIM signed messages.
     * Sends a raw email
     * @param sendMailRaw
     */
    public rawMail(sendMailRaw: SendMailRaw, _options?: PromiseConfigurationOptions): Promise<GenericResponse> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.rawMail(sendMailRaw, observableOptions);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param _from
     * @param to
     * @param [replyto]
     * @param [cc]
     * @param [bcc]
     * @param [attachments] (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param [id] (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public sendAdvMailWithHttpInfo(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto?: EmailAddressesTypes, cc?: EmailAddressesTypes, bcc?: EmailAddressesTypes, attachments?: Array<MailAttachment>, id?: number, _options?: PromiseConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.sendAdvMailWithHttpInfo(subject, body, _from, to, replyto, cc, bcc, attachments, id, observableOptions);
        return result.toPromise();
    }

    /**
     * Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ```BasicForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data to=support@interserver.net ```  ```ArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" ```  ```NameEmailForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=\"Joe <user@domain.com>\" \\ --data to=\"Joe <support@interserver.net>\" ```  ```MultToForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=support@interserver.net, support@interserver.net\" ```  ```MultToFullForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to=Joe <support@interserver.net>, Joe <support@interserver.net>\" ```  ```MultToArrayForm curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/x-www-form-urlencoded\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'subject=Welcome\' \\ --data \'body=Hello\' \\ --data from=user@domain.com \\ --data \"to[0][name]=Joe\" \\ --data \"to[0][email]=support@interserver.net\" \\ --data \"to[1][name]=Joe\" \\ --data \"to[1][email]=support@interserver.net\" ```  ```BasicJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"user@domain.com\", \"to\": \"support@interserver.net\" }\' ```  ```ArrayJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": {\"name\": \"Joe\", \"email\": \"user@domain.com\"}, \"to\": [{\"name\": \"Joe\", \"email\": \"support@interserver.net\"}] }\' ```  ```NameEmailJson curl -i --request POST --url https://api.mailbaby.net/mail/advsend \\ --header \'Accept: application/json\' \\ --header \'Content-Type: application/json\' \\ --header \'X-API-KEY: YOUR_API_KEY\' \\ --data \'{ \"subject\": \"Welcome\", \"body\": \"Hello\", \"from\": \"Joe <user@domain.com>\", \"to\": \"Joe <support@interserver.net>\" }\' ``` 
     * Sends an Email with Advanced Options
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param _from
     * @param to
     * @param [replyto]
     * @param [cc]
     * @param [bcc]
     * @param [attachments] (optional) File attachments to include in the email.  The file contents must be base64 encoded!
     * @param [id] (optional)  ID of the Mail order within our system to use as the Mail Account.
     */
    public sendAdvMail(subject: string, body: string, _from: EmailAddressTypes, to: EmailAddressesTypes, replyto?: EmailAddressesTypes, cc?: EmailAddressesTypes, bcc?: EmailAddressesTypes, attachments?: Array<MailAttachment>, id?: number, _options?: PromiseConfigurationOptions): Promise<GenericResponse> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.sendAdvMail(subject, body, _from, to, replyto, cc, bcc, attachments, id, observableOptions);
        return result.toPromise();
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param _from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param [id] Optional Order ID
     */
    public sendMailWithHttpInfo(to: string, _from: string, subject: string, body: string, id?: number, _options?: PromiseConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.sendMailWithHttpInfo(to, _from, subject, body, id, observableOptions);
        return result.toPromise();
    }

    /**
     * Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
     * Sends an Email
     * @param to The Contact whom is the primary recipient of this email.
     * @param _from The contact whom is the this email is from.
     * @param subject The subject or title of the email
     * @param body The main email contents.
     * @param [id] Optional Order ID
     */
    public sendMail(to: string, _from: string, subject: string, body: string, id?: number, _options?: PromiseConfigurationOptions): Promise<GenericResponse> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.sendMail(to, _from, subject, body, id, observableOptions);
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
    public getMailOrdersWithHttpInfo(_options?: PromiseConfigurationOptions): Promise<HttpInfo<Array<MailOrder>>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getMailOrdersWithHttpInfo(observableOptions);
        return result.toPromise();
    }

    /**
     * This will return a list of the mail orders you have in our system including their id, status, username, and optional comment.
     * displays a list of mail service orders
     */
    public getMailOrders(_options?: PromiseConfigurationOptions): Promise<Array<MailOrder>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.getMailOrders(observableOptions);
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
    public pingServerWithHttpInfo(_options?: PromiseConfigurationOptions): Promise<HttpInfo<void>> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.pingServerWithHttpInfo(observableOptions);
        return result.toPromise();
    }

    /**
     * Checks if the server is running
     */
    public pingServer(_options?: PromiseConfigurationOptions): Promise<void> {
        const observableOptions = wrapOptions(_options);
        const result = this.api.pingServer(observableOptions);
        return result.toPromise();
    }


}



