import { ResponseContext, RequestContext, HttpFile, HttpInfo } from '../http/http';
import { Configuration, ConfigurationOptions } from '../configuration'
import type { Middleware } from '../middleware';

import { DenyRuleNew } from '../models/DenyRuleNew';
import { DenyRuleRecord } from '../models/DenyRuleRecord';
import { EmailAddressName } from '../models/EmailAddressName';
import { EmailAddressNames } from '../models/EmailAddressNames';
import { EmailAddressParam } from '../models/EmailAddressParam';
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
import { MailOrderDetail } from '../models/MailOrderDetail';
import { MailStatsType } from '../models/MailStatsType';
import { MailStatsVolume } from '../models/MailStatsVolume';
import { SendMail } from '../models/SendMail';
import { SendMailAdv } from '../models/SendMailAdv';
import { SendMailRaw } from '../models/SendMailRaw';
import { SendMailTo } from '../models/SendMailTo';

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
     * The value to match against, interpreted according to &#x60;type&#x60;: a full email address for &#x60;email&#x60;/&#x60;destination&#x60;, a domain name for &#x60;domain&#x60;, or an alphanumeric prefix string for &#x60;startswith&#x60;.
     * Defaults to: undefined
     * @type string
     * @memberof BlockingApiaddRule
     */
    data: string
    /**
     * Optional SMTP username of the mail order to associate this rule with (e.g. &#x60;mb20682&#x60;).  If omitted the first active order is used.  Valid usernames are the &#x60;username&#x60; values returned by &#x60;GET /mail&#x60;.
     * Defaults to: undefined
     * @type string
     * @memberof BlockingApiaddRule
     */
    user?: string
}

export interface BlockingApiDeleteRuleRequest {
    /**
     * The numeric ID of the deny rule to delete.  Obtain this from the &#x60;id&#x60; field in &#x60;GET /mail/rules&#x60; or the &#x60;text&#x60; field of a &#x60;POST /mail/rules&#x60; response.
     * Defaults to: undefined
     * @type number
     * @memberof BlockingApideleteRule
     */
    ruleId: number
}

export interface BlockingApiDelistBlockRequest {
    /**
     * 
     * @type EmailAddressParam
     * @memberof BlockingApidelistBlock
     */
    emailAddressParam: EmailAddressParam
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
     * Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule\'s `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 
     * Creates a new email deny rule
     * @param param the request object
     */
    public addRuleWithHttpInfo(param: BlockingApiAddRuleRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.addRuleWithHttpInfo(param.type, param.data, param.user,  options).toPromise();
    }

    /**
     * Adds a deny rule to block specific senders, domains, destinations, or sender prefixes from being relayed through your mail account.  The `type` field selects the matching strategy: - **`email`** — exact match against the SMTP envelope `MAIL FROM` address. - **`domain`** — matches any sender address at the specified domain. - **`destination`** — exact match against the SMTP envelope `RCPT TO` address. - **`startswith`** — matches any sender address whose local-part (the portion   before the `@`) starts with the given string.  Only alphanumeric characters   and `+`, `_`, `.`, `-` are permitted in the prefix.   If `username` is provided it must be the SMTP username of one of your active mail orders (e.g. `mb20682`).  If omitted the rule is associated with your first active order.  On success the response `text` field contains the newly created rule\'s `id`, which can later be passed to `DELETE /mail/rules/{ruleId}` to remove it. 
     * Creates a new email deny rule
     * @param param the request object
     */
    public addRule(param: BlockingApiAddRuleRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.addRule(param.type, param.data, param.user,  options).toPromise();
    }

    /**
     * Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
     * Removes a deny mail rule
     * @param param the request object
     */
    public deleteRuleWithHttpInfo(param: BlockingApiDeleteRuleRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.deleteRuleWithHttpInfo(param.ruleId,  options).toPromise();
    }

    /**
     * Permanently removes a single deny rule identified by its numeric `ruleId`.  The `ruleId` is the `id` field returned by `GET /mail/rules` or the `text` field from a successful `POST /mail/rules` response.  Only rules belonging to your own active mail account(s) can be deleted — the server will reject attempts to delete rules that belong to a different account. 
     * Removes a deny mail rule
     * @param param the request object
     */
    public deleteRule(param: BlockingApiDeleteRuleRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.deleteRule(param.ruleId,  options).toPromise();
    }

    /**
     * Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
     * Removes an email address from the block lists
     * @param param the request object
     */
    public delistBlockWithHttpInfo(param: BlockingApiDelistBlockRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.delistBlockWithHttpInfo(param.emailAddressParam,  options).toPromise();
    }

    /**
     * Delists an email address from all three block list stores: 1. The rspamd spam-filter database (`fromemail` / envelope sender records). 2. The MailChannels integration block table. 3. The MailBaby internal block table.  Use `GET /mail/blocks` to discover which addresses are currently blocked.  The `from` field in any returned block entry is a valid input for this call.  **Note:** Delisting an address removes it from the block tracking databases but does not prevent the spam filter from re-blocking it if future messages continue to trigger filter rules. 
     * Removes an email address from the block lists
     * @param param the request object
     */
    public delistBlock(param: BlockingApiDelistBlockRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.delistBlock(param.emailAddressParam,  options).toPromise();
    }

    /**
     * Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account\'s local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby\'s internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 
     * Displays a list of blocked email addresses
     * @param param the request object
     */
    public getMailBlocksWithHttpInfo(param: BlockingApiGetMailBlocksRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<MailBlocks>> {
        return this.api.getMailBlocksWithHttpInfo( options).toPromise();
    }

    /**
     * Returns addresses and messages that have been flagged by the spam filtering system for your mail account(s).  Three categories are returned:  - **`local`** — messages flagged by the `LOCAL_BL_RCPT` rspamd rule.  These are   messages sent to recipients on your account\'s local block list. - **`mbtrap`** — messages flagged by the `MBTRAP` rspamd rule.  These are messages   that triggered MailBaby\'s internal trap / honeypot detection. - **`subject`** — senders whose recent messages contain spam-indicative subjects   (strings containing `@`, `smtp`, `socks4`, or `socks5`) with high repetition   (more than 4 identical subjects from the same sender in the last 3 days).   The `local` and `mbtrap` results cover the last 5 days.  The `subject` results cover the last 3 days.  A sender address returned in any of these lists can be delisted using `POST /mail/blocks/delete` with the `email` field set to that address. 
     * Displays a list of blocked email addresses
     * @param param the request object
     */
    public getMailBlocks(param: BlockingApiGetMailBlocksRequest = {}, options?: ConfigurationOptions): Promise<MailBlocks> {
        return this.api.getMailBlocks( options).toPromise();
    }

    /**
     * Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 
     * Displays a listing of deny email rules
     * @param param the request object
     */
    public getRulesWithHttpInfo(param: BlockingApiGetRulesRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<Array<DenyRuleRecord>>> {
        return this.api.getRulesWithHttpInfo( options).toPromise();
    }

    /**
     * Returns all deny rules you have configured for your active mail account(s). Deny rules are evaluated **before** a message is transmitted and cause it to be rejected immediately when it matches.  Four rule types are supported: | `type` | `data` format | Effect | |--------|---------------|--------| | `email` | `user@domain.com` | Rejects any message from this exact sender address | | `domain` | `domain.com` | Rejects any message from any address at this domain | | `destination` | `user@domain.com` | Rejects any message addressed to this recipient | | `startswith` | `prefix` | Rejects any message whose sender address begins with this string (alphanumeric, `+`, `_`, `.`, `-` only) |  Use `POST /mail/rules` to add new rules and `DELETE /mail/rules/{ruleId}` to remove them.  The `id` field in each returned record is the value needed for the delete call. 
     * Displays a listing of deny email rules
     * @param param the request object
     */
    public getRules(param: BlockingApiGetRulesRequest = {}, options?: ConfigurationOptions): Promise<Array<DenyRuleRecord>> {
        return this.api.getRules( options).toPromise();
    }

}

import { ObservableHistoryApi } from "./ObservableAPI";
import { HistoryApiRequestFactory, HistoryApiResponseProcessor} from "../apis/HistoryApi";

export interface HistoryApiGetStatsRequest {
    /**
     * The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle.  Defaults to &#x60;1h&#x60;.
     * Defaults to: &#39;1h&#39;
     * @type &#39;all&#39; | &#39;billing&#39; | &#39;month&#39; | &#39;7d&#39; | &#39;24h&#39; | &#39;day&#39; | &#39;1h&#39;
     * @memberof HistoryApigetStats
     */
    time?: 'all' | 'billing' | 'month' | '7d' | '24h' | 'day' | '1h'
}

export interface HistoryApiViewMailLogRequest {
    /**
     * The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from &#x60;GET /mail&#x60; or &#x60;GET /mail/{id}&#x60;.
     * Defaults to: undefined
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    id?: number
    /**
     * Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    origin?: string
    /**
     * Filter by the MX hostname the relay attempted delivery to.  For example &#x60;mx.google.com&#x60; would return messages destined for Gmail recipients. Maps to &#x60;mxHostname&#x60; in the &#x60;MailLogEntry&#x60; response.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    mx?: string
    /**
     * Filter by SMTP envelope &#x60;MAIL FROM&#x60; address (exact match).  This is the address the relay used for bounce handling and may differ from the &#x60;From:&#x60; message header.  For header-level filtering use &#x60;headerfrom&#x60;.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    _from?: string
    /**
     * Filter by SMTP envelope &#x60;RCPT TO&#x60; address (exact match).  This is the delivery address used by the relay and may differ from the &#x60;To:&#x60; header when BCC recipients are involved.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    to?: string
    /**
     * Filter by email &#x60;Subject&#x60; header (exact match).  To search for a substring, include it in the full subject text.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    subject?: string
    /**
     * Filter by the relay-assigned mail ID string (exact match).  This corresponds to the &#x60;id&#x60; field in &#x60;MailLogEntry&#x60; and to the &#x60;text&#x60; value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as &#x60;185997065c60008840&#x60;.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    mailid?: string
    /**
     * Filter by the &#x60;Message-ID&#x60; email header using a substring (case-insensitive) match.  The &#x60;Message-ID&#x60; is assigned by the sending mail client and is visible in the &#x60;messageId&#x60; field of &#x60;MailLogEntry&#x60;.  Useful when you know the message ID generated by your application but not the relay &#x60;mailid&#x60;.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    messageId?: string
    /**
     * Filter by the &#x60;Reply-To&#x60; message header address (exact match).  Only returns messages where this header was explicitly set.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    replyto?: string
    /**
     * Filter by the &#x60;From&#x60; message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope &#x60;from&#x60; parameter when sending on behalf of another address.
     * Defaults to: undefined
     * @type string
     * @memberof HistoryApiviewMailLog
     */
    headerfrom?: string
    /**
     * Filter by delivery status.  &#x60;1&#x60; returns only messages that were successfully delivered to the destination MX.  &#x60;0&#x60; returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status.
     * Defaults to: undefined
     * @type 0 | 1
     * @memberof HistoryApiviewMailLog
     */
    delivered?: 0 | 1
    /**
     * Number of records to skip for pagination.  Use in combination with &#x60;limit&#x60; to page through large result sets.  Defaults to &#x60;0&#x60; (no skip).
     * Minimum: 0
     * Defaults to: 0
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    skip?: number
    /**
     * Maximum number of records to return per page.  Defaults to &#x60;100&#x60;. Maximum allowed value is &#x60;10000&#x60;.  The response also includes a &#x60;total&#x60; field with the full matched count so you can calculate the number of pages.
     * Minimum: 1
     * Maximum: 10000
     * Defaults to: 100
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    limit?: number
    /**
     * Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a &#x60;time&#x60; value **greater than or equal to** this value will be included.
     * Minimum: 0
     * Maximum: 9999999999
     * Defaults to: undefined
     * @type number
     * @memberof HistoryApiviewMailLog
     */
    startDate?: number
    /**
     * Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a &#x60;time&#x60; value **less than or equal to** this value will be included.
     * Minimum: 0
     * Maximum: 9999999999
     * Defaults to: undefined
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
     * Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
     * Account usage statistics
     * @param param the request object
     */
    public getStatsWithHttpInfo(param: HistoryApiGetStatsRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<MailStatsType>> {
        return this.api.getStatsWithHttpInfo(param.time,  options).toPromise();
    }

    /**
     * Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
     * Account usage statistics
     * @param param the request object
     */
    public getStats(param: HistoryApiGetStatsRequest = {}, options?: ConfigurationOptions): Promise<MailStatsType> {
        return this.api.getStats(param.time,  options).toPromise();
    }

    /**
     * Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
     * Displays the mail log
     * @param param the request object
     */
    public viewMailLogWithHttpInfo(param: HistoryApiViewMailLogRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<MailLog>> {
        return this.api.viewMailLogWithHttpInfo(param.id, param.origin, param.mx, param._from, param.to, param.subject, param.mailid, param.messageId, param.replyto, param.headerfrom, param.delivered, param.skip, param.limit, param.startDate, param.endDate,  options).toPromise();
    }

    /**
     * Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
     * Displays the mail log
     * @param param the request object
     */
    public viewMailLog(param: HistoryApiViewMailLogRequest = {}, options?: ConfigurationOptions): Promise<MailLog> {
        return this.api.viewMailLog(param.id, param.origin, param.mx, param._from, param.to, param.subject, param.mailid, param.messageId, param.replyto, param.headerfrom, param.delivered, param.skip, param.limit, param.startDate, param.endDate,  options).toPromise();
    }

}

import { ObservableSendingApi } from "./ObservableAPI";
import { SendingApiRequestFactory, SendingApiResponseProcessor} from "../apis/SendingApi";

export interface SendingApiRawMailRequest {
    /**
     * 
     * @type SendMailRaw
     * @memberof SendingApirawMail
     */
    sendMailRaw: SendMailRaw
}

export interface SendingApiSendAdvMailRequest {
    /**
     * The subject line of the email.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendAdvMail
     */
    subject: string
    /**
     * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
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
     * Optional list of file attachments.  Each file must be base64-encoded. Include &#x60;filename&#x60; so recipients see a meaningful attachment name.
     * Defaults to: undefined
     * @type Array&lt;MailAttachment&gt;
     * @memberof SendingApisendAdvMail
     */
    attachments?: Array<MailAttachment>
    /**
     * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     * Defaults to: undefined
     * @type number
     * @memberof SendingApisendAdvMail
     */
    id?: number
}

export interface SendingApiSendMailRequest {
    /**
     * 
     * Defaults to: undefined
     * @type SendMailTo
     * @memberof SendingApisendMail
     */
    to: SendMailTo
    /**
     * The sender address.  This is used as both the &#x60;From&#x60; header and the &#x60;Reply-To&#x60; header automatically.  Must be a valid email address authorized for your mail order.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendMail
     */
    _from: string
    /**
     * The subject line of the email.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendMail
     */
    subject: string
    /**
     * The email body.  If the string contains any HTML tags the message is automatically sent as &#x60;text/html&#x60;; otherwise it is sent as &#x60;text/plain&#x60;.
     * Defaults to: undefined
     * @type string
     * @memberof SendingApisendMail
     */
    body: string
    /**
     * Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by &#x60;GET /mail&#x60;.
     * Defaults to: undefined
     * @type number
     * @memberof SendingApisendMail
     */
    id?: number
}

export class ObjectSendingApi {
    private api: ObservableSendingApi

    public constructor(configuration: Configuration, requestFactory?: SendingApiRequestFactory, responseProcessor?: SendingApiResponseProcessor) {
        this.api = new ObservableSendingApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
     * Sends a raw RFC 822 email
     * @param param the request object
     */
    public rawMailWithHttpInfo(param: SendingApiRawMailRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.rawMailWithHttpInfo(param.sendMailRaw,  options).toPromise();
    }

    /**
     * Accepts a complete, pre-built RFC 822 email message (headers + body) as a string and injects it into the relay without any modification.  This endpoint is particularly useful when the message has already been **DKIM-signed** — because the relay transmits the exact bytes you provide, the DKIM signature remains intact.  If you use the other sending endpoints the relay may add or reorder headers, breaking an existing signature.  The `From` and recipient addresses are parsed automatically from the message headers (`From`, `To`, `Cc`, `Bcc`).  You do **not** need to specify them separately.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  The SMTP credentials for the selected order are used to authenticate with the relay.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
     * Sends a raw RFC 822 email
     * @param param the request object
     */
    public rawMail(param: SendingApiRawMailRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.rawMail(param.sendMailRaw,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' \\   -d \'body=Hello\' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' \\   -d \'body=Hello\' \\   -d \'from=Joe <user@domain.com>\' \\   -d \'to=Jane <support@interserver.net>\' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' -d \'body=Hello\' \\   -d from=user@domain.com \\   -d \'to[0][name]=Joe\' -d \'to[0][email]=support@interserver.net\' \\   -d \'to[1][name]=Jane\' -d \'to[1][email]=jane@interserver.net\' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/json\' \\   -d \'{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }\' ``` 
     * Sends an Email with Advanced Options
     * @param param the request object
     */
    public sendAdvMailWithHttpInfo(param: SendingApiSendAdvMailRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.sendAdvMailWithHttpInfo(param.subject, param.body, param._from, param.to, param.replyto, param.cc, param.bcc, param.attachments, param.id,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders with full control over recipients, headers, and attachments.  Supports multiple To / CC / BCC addresses, named contacts, Reply-To overrides, and base64-encoded file attachments.  **Content-type flexibility** — the request body may be submitted as either `application/x-www-form-urlencoded` or `application/json`.  When using form encoding, address fields (`from`, `to`, `replyto`, `cc`, `bcc`) accept both a plain RFC 822 comma-separated string (e.g. `\"Joe <joe@example.com>, jane@example.com\"`) and the structured `[{\"email\":\"...\",\"name\":\"...\"}]` array format.  When using JSON, both formats are equally supported.  **HTML detection** is automatic — if `body` contains HTML tags the `Content-Type` is set to `text/html`; otherwise `text/plain`.  **Attachments** must be base64-encoded.  Each attachment requires at least a `data` field; the optional `filename` field controls the attachment name shown to recipients.  If an `id` is provided it must correspond to an active mail order on your account. If omitted, the first active order is selected automatically.  On success the response `text` field contains the relay transaction ID which can be looked up in `GET /mail/log` via the `mailid` query parameter.  ## Examples  ### Form — basic string addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' \\   -d \'body=Hello\' \\   -d from=user@domain.com \\   -d to=support@interserver.net ``` ### Form — RFC 822 named addresses ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' \\   -d \'body=Hello\' \\   -d \'from=Joe <user@domain.com>\' \\   -d \'to=Jane <support@interserver.net>\' ``` ### Form — multiple recipients as array ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/x-www-form-urlencoded\' \\   -d \'subject=Welcome\' -d \'body=Hello\' \\   -d from=user@domain.com \\   -d \'to[0][name]=Joe\' -d \'to[0][email]=support@interserver.net\' \\   -d \'to[1][name]=Jane\' -d \'to[1][email]=jane@interserver.net\' ``` ### JSON — structured objects ```sh curl -X POST https://api.mailbaby.net/mail/advsend \\   -H \'X-API-KEY: YOUR_API_KEY\' \\   -H \'Content-Type: application/json\' \\   -d \'{     \"subject\": \"Welcome\",     \"body\": \"<h1>Hello</h1>\",     \"from\": {\"email\": \"user@domain.com\", \"name\": \"Sender Name\"},     \"to\": [{\"email\": \"joe@client.com\", \"name\": \"Joe Client\"}],     \"cc\": [{\"email\": \"manager@client.com\"}],     \"attachments\": [{\"filename\": \"report.pdf\", \"data\": \"BASE64_DATA\"}]   }\' ``` 
     * Sends an Email with Advanced Options
     * @param param the request object
     */
    public sendAdvMail(param: SendingApiSendAdvMailRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.sendAdvMail(param.subject, param.body, param._from, param.to, param.replyto, param.cc, param.bcc, param.attachments, param.id,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
     * Sends an Email
     * @param param the request object
     */
    public sendMailWithHttpInfo(param: SendingApiSendMailRequest, options?: ConfigurationOptions): Promise<HttpInfo<GenericResponse>> {
        return this.api.sendMailWithHttpInfo(param.to, param._from, param.subject, param.body, param.id,  options).toPromise();
    }

    /**
     * Sends an email through one of your mail orders using a simple flat set of fields. This is the quickest way to send a single-recipient plain-text or HTML message.  **HTML detection** is automatic — if the `body` value contains any HTML tags the message will be sent as `text/html`; otherwise it is sent as `text/plain`.  The `from` address is also automatically set as the `Reply-To` header.  *Note*: If you need to send to multiple recipients, add CC/BCC, or include file attachments, use `POST /mail/advsend` instead.  If you have a pre-built RFC 822 message (e.g. already DKIM-signed), use `POST /mail/rawsend`.  On success the response `text` field contains the relay transaction ID.  This ID can be used with `GET /mail/log` (via the `mailid` query parameter) to look up the delivery record. 
     * Sends an Email
     * @param param the request object
     */
    public sendMail(param: SendingApiSendMailRequest, options?: ConfigurationOptions): Promise<GenericResponse> {
        return this.api.sendMail(param.to, param._from, param.subject, param.body, param.id,  options).toPromise();
    }

}

import { ObservableServicesApi } from "./ObservableAPI";
import { ServicesApiRequestFactory, ServicesApiResponseProcessor} from "../apis/ServicesApi";

export interface ServicesApiGetMailOrderByIdRequest {
    /**
     * The numeric ID of the mail order.
     * Defaults to: undefined
     * @type number
     * @memberof ServicesApigetMailOrderById
     */
    id: number
}

export interface ServicesApiGetMailOrdersRequest {
}

export class ObjectServicesApi {
    private api: ObservableServicesApi

    public constructor(configuration: Configuration, requestFactory?: ServicesApiRequestFactory, responseProcessor?: ServicesApiResponseProcessor) {
        this.api = new ObservableServicesApi(configuration, requestFactory, responseProcessor);
    }

    /**
     * Returns the full detail record for one specific mail order identified by its numeric `id`.  In addition to the fields returned by `GET /mail`, this endpoint also includes the current **SMTP password** for the order.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 
     * Displays details for a single mail order
     * @param param the request object
     */
    public getMailOrderByIdWithHttpInfo(param: ServicesApiGetMailOrderByIdRequest, options?: ConfigurationOptions): Promise<HttpInfo<MailOrderDetail>> {
        return this.api.getMailOrderByIdWithHttpInfo(param.id,  options).toPromise();
    }

    /**
     * Returns the full detail record for one specific mail order identified by its numeric `id`.  In addition to the fields returned by `GET /mail`, this endpoint also includes the current **SMTP password** for the order.  The `username` and `password` values returned here can be used directly to authenticate against `relay.mailbaby.net:25` (SMTP AUTH) if you need to send email via a native SMTP client rather than through the REST API.  The `id` path parameter is the same integer `id` value returned by `GET /mail`. 
     * Displays details for a single mail order
     * @param param the request object
     */
    public getMailOrderById(param: ServicesApiGetMailOrderByIdRequest, options?: ConfigurationOptions): Promise<MailOrderDetail> {
        return this.api.getMailOrderById(param.id,  options).toPromise();
    }

    /**
     * Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional human-readable `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 
     * Displays a list of mail service orders
     * @param param the request object
     */
    public getMailOrdersWithHttpInfo(param: ServicesApiGetMailOrdersRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<Array<MailOrder>>> {
        return this.api.getMailOrdersWithHttpInfo( options).toPromise();
    }

    /**
     * Returns every mail order (active **and** inactive) associated with your account. Each record includes the numeric `id`, the `status` (`active` or `canceled`), the SMTP `username` (always `mb<id>`), and an optional human-readable `comment`.  The `id` values returned here are used as the `id` input parameter on all sending endpoints (`/mail/send`, `/mail/advsend`, `/mail/rawsend`) as well as the log and stats queries.  When the `id` parameter is omitted on those calls the API automatically picks the **first active** order returned by this endpoint.  To retrieve full details — including the current SMTP password — for a single order use `GET /mail/{id}`. 
     * Displays a list of mail service orders
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
     * A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
     * Checks if the server is running
     * @param param the request object
     */
    public pingServerWithHttpInfo(param: StatusApiPingServerRequest = {}, options?: ConfigurationOptions): Promise<HttpInfo<void>> {
        return this.api.pingServerWithHttpInfo( options).toPromise();
    }

    /**
     * A lightweight health-check endpoint.  Returns a plain-text `200 OK` when the API server is reachable.  No authentication is required.  Useful for monitoring and uptime checks. 
     * Checks if the server is running
     * @param param the request object
     */
    public pingServer(param: StatusApiPingServerRequest = {}, options?: ConfigurationOptions): Promise<void> {
        return this.api.pingServer( options).toPromise();
    }

}
